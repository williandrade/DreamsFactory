package com.dreamsfactory.session;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.dreamsfactory.dao.IdeaDAO;
import com.dreamsfactory.dto.IdeaCreationDTO;
import com.dreamsfactory.dto.IdeaDTO;
import com.dreamsfactory.dto.IdeaVersionDTO;
import com.dreamsfactory.dto.IdeaTypeDTO;
import com.dreamsfactory.dto.UserDTO;
import com.dreamsfactory.entity.Idea;
import com.dreamsfactory.entity.IdeaType;
import com.dreamsfactory.exception.ArgumentMissingException;
import com.dreamsfactory.mapper.IdeaMapper;

@Stateless
@LocalBean
public class IdeaSession {

	@EJB
	private IdeaDAO ideaDAO;

	@EJB
	private IdeaTypeSession ideaTypeSession;

	@EJB
	private IdeaVersionSession ideaVersionSession;

	@Inject
	private IdeaMapper ideaMapper;

	public IdeaDTO create(IdeaCreationDTO ideaCreationDTO, UserDTO userDTO) throws Exception {
		if (userDTO == null) {
			throw new Exception("User is null");
		}
		IdeaDTO ideaDTO = new IdeaDTO();

		ideaDTO.setDescription(ideaCreationDTO.getDescription());
		ideaDTO.setShortDescription(ideaCreationDTO.getShortDescription());
		ideaDTO.setCreationDate(new Date());

		Integer ideaTypeId = ideaCreationDTO.getIdeaTypeId();
		if (ideaTypeId == null) {
			throw new ArgumentMissingException("ideaTypeId");
		}
		IdeaTypeDTO ideaTypeDTO = ideaTypeSession.findById(ideaTypeId);

		ideaDTO.setIdeaType(ideaTypeDTO);

		ideaDTO.setUserId(userDTO.getId());

		Idea idea = ideaMapper.ideaDTOToIdea(ideaDTO);
		idea = ideaDAO.insert(idea);
		ideaDTO = ideaMapper.ideaToIdeaDTO(idea);

		return ideaDTO;
	}

	public IdeaDTO findById(Integer id) throws Exception {
		Idea idea = ideaDAO.findById(id);
		return ideaMapper.ideaToIdeaDTO(idea);
	}

	public IdeaDTO edit(IdeaDTO ideaDTO, Integer userId) throws Exception {
		Idea onDb = ideaDAO.findById(ideaDTO.getId());
		IdeaDTO onDbDTO = ideaMapper.ideaToIdeaDTO(onDb);

		List<IdeaVersionDTO> versions = ideaVersionSession.findByIdeaId(ideaDTO.getId());
		if (versions.isEmpty()) {
			ideaVersionSession.create(onDbDTO, onDbDTO.getUserId());
		}

		onDbDTO.setName(ideaDTO.getName());
		onDbDTO.setShortDescription(ideaDTO.getShortDescription());
		onDbDTO.setDescription(ideaDTO.getDescription());

		if (ideaDTO.getIdeaType() == null) {
			throw new ArgumentMissingException("ideaType");
		}
		Integer ideaTypeId = ideaDTO.getIdeaType().getId();
		if (ideaTypeId == null) {
			throw new ArgumentMissingException("ideaType.Id");
		}
		IdeaTypeDTO ideaTypeDTO = ideaTypeSession.findById(ideaTypeId);

		if (ideaTypeDTO == null) {
			throw new Exception("IdeaType not found");
		}

		onDbDTO.setIdeaType(ideaTypeDTO);

		IdeaVersionDTO version = null;

		try {

			version = ideaVersionSession.create(ideaDTO, userId);

			if (version == null) {
				throw new Exception("Come null O.O");
			}
		} catch (Exception e) {
			// logger.error();
			throw new Exception("Error to create the history");
		}

		if (version.getApproved()) {
			onDbDTO = this.update(onDbDTO);
		}

		return ideaDTO;
	}

	public IdeaDTO update(IdeaDTO ideaDTO) {
		Idea idea = ideaMapper.ideaDTOToIdea(ideaDTO);
		idea = ideaDAO.update(idea);
		return ideaMapper.ideaToIdeaDTO(idea);
	}

	public List<IdeaDTO> findSimillar(String description) {
		// TODO Auto-generated method stub
		return null;
	}

}
