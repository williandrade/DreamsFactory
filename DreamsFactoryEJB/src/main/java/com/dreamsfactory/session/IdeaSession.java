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
import com.dreamsfactory.dto.IdeaTypeDTO;
import com.dreamsfactory.entity.Idea;
import com.dreamsfactory.exception.ArgumentMissingException;
import com.dreamsfactory.mapper.IdeaMapper;

@Stateless
@LocalBean
public class IdeaSession {

	@EJB
	private IdeaDAO ideaDAO;

	@EJB
	private IdeaTypeSession ideaTypeSession;

	@Inject
	private IdeaMapper ideaMapper;

	public IdeaDTO create(IdeaCreationDTO ideaCreationDTO) throws Exception {
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

		// TODO setUser
		ideaDTO.setUserId(1);

		Idea idea = ideaMapper.ideaDTOToIdea(ideaDTO);
		idea = ideaDAO.insert(idea);
		ideaDTO = ideaMapper.ideaToIdeaDTO(idea);

		return ideaDTO;
	}

	public IdeaDTO findById(Integer id) {
		Idea idea = ideaDAO.findById(id);
		return ideaMapper.ideaToIdeaDTO(idea);
	}

	public List<IdeaDTO> findSimillar(String description) {
		// TODO Auto-generated method stub
		return null;
	}

}
