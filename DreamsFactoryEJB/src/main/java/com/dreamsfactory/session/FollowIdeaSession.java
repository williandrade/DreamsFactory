package com.dreamsfactory.session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dreamsfactory.dao.FollowIdeaDAO;
import com.dreamsfactory.dto.FollowIdeaDTO;
import com.dreamsfactory.entity.FollowIdea;
import com.dreamsfactory.entity.Idea;
import com.dreamsfactory.entity.User;
import com.dreamsfactory.exception.ArgumentMissingException;
import com.dreamsfactory.mapper.FollowIdeaMapper;

@Stateless
@LocalBean
public class FollowIdeaSession {

	private static final Logger logger = LogManager.getLogger(FollowIdeaSession.class);

	@EJB
	private FollowIdeaDAO followIdeaDAO;

	@Inject
	private FollowIdeaMapper followIdeaMapper;

	public FollowIdeaDTO follow(Integer ideaId, Integer userId) throws Exception {
		if (ideaId == null) {
			throw new ArgumentMissingException("IdeaId");
		}
		if (userId == null) {
			throw new ArgumentMissingException("UserId");
		}

		FollowIdea followIdea = followIdeaDAO.findByIdeaIdAndUserId(ideaId, userId);

		if (followIdea != null) {
			logger.debug("The user " + userId + " already follow the idea " + ideaId);
			throw new Exception("Already Following");
		}
		logger.debug("The user " + userId + " will follow the idea " + ideaId);

		followIdea = new FollowIdea();

		followIdea.setFollowDate(new Date());
		followIdea.setUserId(new User(ideaId));
		followIdea.setIdeaId(new Idea(ideaId));

		followIdea = followIdeaDAO.insert(followIdea);

		FollowIdeaDTO followIdeaDTO = followIdeaMapper.followIdeaToFollowIdeaDTO(followIdea);
		logger.debug("The user " + userId + " is now following the idea " + ideaId);

		return followIdeaDTO;
	}

	public FollowIdeaDTO unfollow(Integer followId) throws Exception {
		if (followId == null) {
			throw new ArgumentMissingException("followId");
		}

		logger.debug("The folow register " + followId + " will be set as unfollow");

		FollowIdea followIdea = followIdeaDAO.findById(followId);
		followIdea.setUnfollowDate(new Date());

		followIdea = followIdeaDAO.update(followIdea);

		FollowIdeaDTO followIdeaDTO = followIdeaMapper.followIdeaToFollowIdeaDTO(followIdea);
		logger.debug("The folow register " + followId + " was set as unfollow");

		return followIdeaDTO;
	}

	public FollowIdeaDTO unfollow(Integer ideaId, Integer userId) throws Exception {
		if (ideaId == null) {
			throw new ArgumentMissingException("IdeaId");
		}
		if (userId == null) {
			throw new ArgumentMissingException("UserId");
		}

		logger.debug("The user " + userId + " will unfollow the idea " + ideaId);
		FollowIdea followIdea = followIdeaDAO.findByIdeaIdAndUserId(ideaId, userId);

		if (followIdea == null) {
			throw new Exception("Register not found");
		}

		followIdea.setUnfollowDate(new Date());

		followIdea = followIdeaDAO.update(followIdea);

		FollowIdeaDTO followIdeaDTO = followIdeaMapper.followIdeaToFollowIdeaDTO(followIdea);
		logger.debug("The user " + userId + " is now unfollow the idea " + ideaId);

		return followIdeaDTO;
	}

	public List<FollowIdeaDTO> findFollowers(Integer ideaId) throws Exception {
		if (ideaId == null) {
			throw new ArgumentMissingException("followId");
		}

		logger.debug("Finding folowers for idea " + ideaId);
		Set<FollowIdea> FollowIdeaaSet = followIdeaDAO.findFollowers(ideaId);
		Set<FollowIdeaDTO> followIdeaDTO = followIdeaMapper.followIdeasToFollowIdeaDTOs(FollowIdeaaSet);

		List<FollowIdeaDTO> followIdeas = new ArrayList<>(followIdeaDTO);
		logger.debug("Found " + followIdeas.size() + " folowers for idea " + ideaId);

		return followIdeas;
	}
}
