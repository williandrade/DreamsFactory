package com.dreamsfactory.session;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.dreamsfactory.dao.IdeaTypeDAO;
import com.dreamsfactory.dto.IdeaTypeDTO;
import com.dreamsfactory.entity.IdeaType;
import com.dreamsfactory.exception.ArgumentMissingException;
import com.dreamsfactory.mapper.IdeaTypeMapper;

@Stateless
@LocalBean
public class IdeaTypeSession {

	@EJB
	private IdeaTypeDAO ideaTypeDAO;

	@Inject
	private IdeaTypeMapper ideaTypeMapper;

	public IdeaTypeDTO findById(Integer id) throws Exception {
		IdeaType ideaType = ideaTypeDAO.findById(id);
		return ideaTypeMapper.ideaTypeToIdeaTypeDTO(ideaType);
	}

	public IdeaTypeDTO create(IdeaTypeDTO ideaTypeDTO) throws Exception {
		IdeaType ideaType = ideaTypeMapper.ideaTypeDTOToIdeaType(ideaTypeDTO);

		ideaType = ideaTypeDAO.insert(ideaType);

		return ideaTypeMapper.ideaTypeToIdeaTypeDTO(ideaType);
	}

	public List<IdeaTypeDTO> findAll() throws Exception {
		Set<IdeaType> fromDb = ideaTypeDAO.findAll();
		Set<IdeaTypeDTO> allSet = ideaTypeMapper.ideaTypesToIdeaTypeDTOs(fromDb);

		List<IdeaTypeDTO> result = new ArrayList<>(allSet);

		return result;
	}

	public IdeaTypeDTO update(IdeaTypeDTO ideaTypeDTO) throws Exception {
		if (ideaTypeDTO.getId() == null) {
			throw new ArgumentMissingException("ID");
		}

		IdeaType ideaType = ideaTypeMapper.ideaTypeDTOToIdeaType(ideaTypeDTO);
		ideaType = ideaTypeDAO.update(ideaType);

		ideaTypeDTO = ideaTypeMapper.ideaTypeToIdeaTypeDTO(ideaType);

		return ideaTypeMapper.ideaTypeToIdeaTypeDTO(ideaType);
	}

	public void delete(Integer id) throws Exception {
		if (id == null) {
			throw new ArgumentMissingException("ID");
		}

		ideaTypeDAO.delete(id);
	}

}
