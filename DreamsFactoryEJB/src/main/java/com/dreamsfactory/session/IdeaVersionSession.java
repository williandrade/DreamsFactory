package com.dreamsfactory.session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.dreamsfactory.dao.IdeaVersionDAO;
import com.dreamsfactory.dto.IdeaDTO;
import com.dreamsfactory.dto.IdeaVersionDTO;
import com.dreamsfactory.entity.Idea;
import com.dreamsfactory.entity.IdeaVersion;
import com.dreamsfactory.exception.ArgumentMissingException;
import com.dreamsfactory.mapper.IdeaVersionMapper;

@Stateless
@LocalBean
public class IdeaVersionSession {

	@EJB
	private IdeaVersionDAO ideaVersionDAO;

	@Inject
	private IdeaVersionMapper ideaVersionMapper;

	public IdeaVersionDTO create(IdeaDTO ideaDTO, Integer userId) throws Exception {
		IdeaVersion ideaVersion = new IdeaVersion();

		ideaVersion.setName(ideaDTO.getName());
		ideaVersion.setShortDescription(ideaDTO.getShortDescription());
		ideaVersion.setDescription(ideaDTO.getDescription());
		ideaVersion.setIdeaTypeId(ideaDTO.getIdeaType().getId());
		ideaVersion.setCreationDate(ideaDTO.getCreationDate());

		ideaVersion.setUserId(userId);
		ideaVersion.setIdeaId(new Idea(ideaDTO.getId()));
		ideaVersion.setChangeDate(new Date());

		Boolean approved = false;

		if (ideaDTO.getUserId() == userId) {
			approved = true;
		}

		ideaVersion.setApproved(approved);

		ideaVersion = ideaVersionDAO.insert(ideaVersion);

		return ideaVersionMapper.ideaVersionToIdeaVersionDTO(ideaVersion);
	}

	public List<IdeaVersionDTO> findByIdeaId(Integer ideaId) throws Exception {
		if (ideaId == null) {
			throw new ArgumentMissingException("ideaId");
		}

		Set<IdeaVersion> entities = ideaVersionDAO.findByIdeaId(ideaId);
		List<IdeaVersionDTO> result = new ArrayList<>(ideaVersionMapper.ideaVersionToIdeaVersionDTOs(entities));

		return result;
	}

	public void acceptVersion(Integer versionId, Integer userId) throws Exception {
		IdeaVersion ideaVersion = ideaVersionDAO.findById(versionId);

		if (ideaVersion.getIdeaId().getUserId().getId() == userId) {
			ideaVersion.setApproved(true);

			ideaVersionDAO.update(ideaVersion);
		} else {
			throw new Exception("You are not the owner of this idea");
		}
	}

}
