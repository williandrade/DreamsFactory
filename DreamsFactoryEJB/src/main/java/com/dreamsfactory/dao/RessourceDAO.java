package com.dreamsfactory.dao;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import com.dreamsfactory.entity.Ressource;

@Stateless
@LocalBean
public class RessourceDAO extends GenericDAO<Ressource> {

	public RessourceDAO() {
		super(Ressource.class);
	}

	public Set<Ressource> findByIdeaId(Integer ideaId) {
		String hql = "Select r from Ressource r where r.ideaId.id = :id";
		Query query = this.getEm().createQuery(hql);
		query.setParameter("id", ideaId);
		return new HashSet<Ressource>(query.getResultList());
	}

	public Set<Ressource> findByUserId(Integer userId) {
		String hql = "Select r from Ressource r where r.userId.id = :id";
		Query query = this.getEm().createQuery(hql);
		query.setParameter("id", userId);
		return new HashSet<Ressource>(query.getResultList());
	}
}
