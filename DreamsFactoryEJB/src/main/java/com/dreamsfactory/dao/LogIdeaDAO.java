package com.dreamsfactory.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import com.dreamsfactory.entity.LogIdea;

@Stateless
@LocalBean
public class LogIdeaDAO extends GenericDAO<LogIdea> {

	public LogIdeaDAO() {
		super(LogIdea.class);
	}

	public Set<LogIdea> findByIdeaId(Integer id) {
		String hql = "Select l from LogIdea l where l.ideaId.id = :id";
		Query query = this.getEm().createQuery(hql);
		query.setParameter("id", id);

		return new HashSet<>(query.getResultList());
	}

	public LogIdea findLastByIdeaId(Integer id) {
		String hql = "Select l from LogIdea l where l.ideaId.id = :id order by l.logDate desc";
		Query query = this.getEm().createQuery(hql);
		query.setParameter("id", id);
		query.setMaxResults(1);

		List<LogIdea> result = query.getResultList();

		if (result.isEmpty()) {
			return null;
		}

		return result.get(0);
	}

	public Set<LogIdea> findByUserId(Integer id) {
		String hql = "Select l from LogIdea l where l.userId.id = :id";
		Query query = this.getEm().createQuery(hql);
		query.setParameter("id", id);

		return new HashSet<>(query.getResultList());
	}

	public LogIdea findLastByUserId(Integer id) {
		String hql = "Select l from LogIdea l where l.userId.id = :id order by l.logDate desc";
		Query query = this.getEm().createQuery(hql);
		query.setParameter("id", id);
		query.setMaxResults(1);

		List<LogIdea> result = query.getResultList();

		if (result.isEmpty()) {
			return null;
		}

		return result.get(0);
	}
}
