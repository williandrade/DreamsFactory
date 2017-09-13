package com.dreamsfactory.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import com.dreamsfactory.entity.FollowIdea;

@Stateless
@LocalBean
public class FollowIdeaDAO extends GenericDAO<FollowIdea> {

	public FollowIdeaDAO() {
		super(FollowIdea.class);
	}

	public Set<FollowIdea> findFollowers(Integer ideaId) {
		String hql = "Select f from FollowIdea f where f.ideaId.id = :id and f.unfollowDate is null";
		Query query = this.getEm().createQuery(hql);
		query.setParameter("id", ideaId);
		return new HashSet<FollowIdea>(query.getResultList());
	}

	public FollowIdea findByIdeaIdAndUserId(Integer ideaId, Integer userId) {
		String hql = "Select f from FollowIdea f where f.ideaId.id = :ideaId and f.userId.id = :userId and f.unfollowDate is null";
		Query query = this.getEm().createQuery(hql);
		query.setParameter("ideaId", ideaId);
		query.setParameter("userId", userId);
		query.setMaxResults(1);

		List<FollowIdea> result = query.getResultList();

		if (result.isEmpty()) {
			return null;
		}

		return result.get(0);
	}

}
