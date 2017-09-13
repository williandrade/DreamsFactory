package com.dreamsfactory.session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

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
			throw new Exception("Already Following");
		}

		followIdea = new FollowIdea();

		followIdea.setFollowDate(new Date());
		followIdea.setUserId(new User(ideaId));
		followIdea.setIdeaId(new Idea(ideaId));

		followIdea = followIdeaDAO.insert(followIdea);

		FollowIdeaDTO followIdeaDTO = followIdeaMapper.followIdeaToFollowIdeaDTO(followIdea);

		return followIdeaDTO;
	}

	public FollowIdeaDTO unfollow(Integer followId) throws Exception {
		if (followId == null) {
			throw new ArgumentMissingException("followId");
		}

		FollowIdea followIdea = followIdeaDAO.findById(followId);
		followIdea.setUnfollowDate(new Date());

		followIdea = followIdeaDAO.update(followIdea);

		FollowIdeaDTO followIdeaDTO = followIdeaMapper.followIdeaToFollowIdeaDTO(followIdea);

		return followIdeaDTO;
	}

	public FollowIdeaDTO unfollow(Integer ideaId, Integer userId) throws Exception {
		if (ideaId == null) {
			throw new ArgumentMissingException("IdeaId");
		}
		if (userId == null) {
			throw new ArgumentMissingException("UserId");
		}

		FollowIdea followIdea = followIdeaDAO.findByIdeaIdAndUserId(ideaId, userId);

		if (followIdea == null) {
			throw new Exception("Register not found");
		}

		followIdea.setUnfollowDate(new Date());

		followIdea = followIdeaDAO.update(followIdea);

		FollowIdeaDTO followIdeaDTO = followIdeaMapper.followIdeaToFollowIdeaDTO(followIdea);

		return followIdeaDTO;
	}

	public List<FollowIdeaDTO> findFollowers(Integer followId) throws Exception {
		if (followId == null) {
			throw new ArgumentMissingException("followId");
		}

		Set<FollowIdea> FollowIdeaaSet = followIdeaDAO.findFollowers(followId);
		Set<FollowIdeaDTO> followIdeaDTO = followIdeaMapper.followIdeasToFollowIdeaDTOs(FollowIdeaaSet);

		List<FollowIdeaDTO> followIdeas = new ArrayList<>(followIdeaDTO);

		return followIdeas;
	}
}
