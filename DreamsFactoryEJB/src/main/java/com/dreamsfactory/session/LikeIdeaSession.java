package com.dreamsfactory.session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.dreamsfactory.dao.LikeIdeaDAO;
import com.dreamsfactory.dto.LikeIdeaDTO;
import com.dreamsfactory.entity.Idea;
import com.dreamsfactory.entity.LikeIdea;
import com.dreamsfactory.entity.User;
import com.dreamsfactory.exception.ArgumentMissingException;
import com.dreamsfactory.mapper.LikeIdeaMapper;

@Stateless
@LocalBean
public class LikeIdeaSession {

	@EJB
	private LikeIdeaDAO likeIdeaDAO;

	@Inject
	private LikeIdeaMapper likeIdeaMapper;

	public List<LikeIdeaDTO> findLikesFromIdea(Integer ideaId) throws Exception {
		if (ideaId == null) {
			throw new ArgumentMissingException("IdeaId");
		}

		Set<LikeIdea> entitys = likeIdeaDAO.findLikesFromIdea(ideaId);
		Set<LikeIdeaDTO> dtos = likeIdeaMapper.likeIdeasToLikeIdeaDTOs(entitys);

		List<LikeIdeaDTO> result = new ArrayList<>(dtos);

		return result;
	}

	public List<LikeIdeaDTO> findLikesFromUser(Integer userId) throws Exception {
		if (userId == null) {
			throw new ArgumentMissingException("UserId");
		}

		Set<LikeIdea> entitys = likeIdeaDAO.findLikesFromUser(userId);
		Set<LikeIdeaDTO> dtos = likeIdeaMapper.likeIdeasToLikeIdeaDTOs(entitys);

		List<LikeIdeaDTO> result = new ArrayList<>(dtos);

		return result;
	}

	public LikeIdeaDTO like(Integer ideaId, Integer userId) throws Exception {
		if (ideaId == null) {
			throw new ArgumentMissingException("IdeaId");
		}
		if (userId == null) {
			throw new ArgumentMissingException("UserId");
		}

		LikeIdea entity = likeIdeaDAO.findByIdeaAndUser(ideaId, userId);

		if (entity != null) {
			throw new Exception("Already Like");
		}

		entity = new LikeIdea();
		entity.setIdeaId(new Idea(ideaId));
		entity.setUserId(new User(userId));
		entity.setLikeDate(new Date());

		entity = likeIdeaDAO.insert(entity);

		LikeIdeaDTO ideaDTO = likeIdeaMapper.likeIdeaToLikeIdeaDTO(entity);
		return ideaDTO;
	}

	public void unlike(Integer ideaId, Integer userId) throws Exception {
		if (ideaId == null) {
			throw new ArgumentMissingException("IdeaId");
		}
		if (userId == null) {
			throw new ArgumentMissingException("UserId");
		}

		LikeIdea entity = likeIdeaDAO.findByIdeaAndUser(ideaId, userId);

		if (entity == null) {
			throw new Exception("The User do not Like this Idea");
		}

		likeIdeaDAO.delete(entity);
	}

}
