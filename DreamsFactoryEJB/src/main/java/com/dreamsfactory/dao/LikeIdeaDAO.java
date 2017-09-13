package com.dreamsfactory.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import com.dreamsfactory.entity.LikeIdea;

@Stateless
@LocalBean
public class LikeIdeaDAO extends GenericDAO<LikeIdea> {

	public LikeIdeaDAO() {
		super(LikeIdea.class);
	}

	public Set<LikeIdea> findLikesFromIdea(Integer ideaId) {
		String hql = "Select l from LikeIdea l where l.ideaId.id = :ideaId";
		Query query = this.getEm().createQuery(hql);
		query.setParameter("ideaId", ideaId);

		return new HashSet<>(query.getResultList());
	}

	public Set<LikeIdea> findLikesFromUser(Integer userId) {
		String hql = "Select l from LikeIdea l where l.userId.id = :userId";
		Query query = this.getEm().createQuery(hql);
		query.setParameter("userId", userId);

		return new HashSet<>(query.getResultList());
	}

	public LikeIdea findByIdeaAndUser(Integer ideaId, Integer userId) {
		String hql = "Select l from LikeIdea l where l.ideaId.id = :ideaId and l.userId.id = :userId";
		Query query = this.getEm().createQuery(hql);
		query.setParameter("ideaId", ideaId);
		query.setParameter("userId", userId);
		query.setMaxResults(1);

		List<LikeIdea> result = query.getResultList();

		if (result.isEmpty()) {
			return null;
		}

		return result.get(0);
	}

}
