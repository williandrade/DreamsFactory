package com.dreamsfactory.dao;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import com.dreamsfactory.entity.IdeaVersion;

@Stateless
@LocalBean
public class IdeaVersionDAO extends GenericDAO<IdeaVersion> {

	public IdeaVersionDAO() {
		super(IdeaVersion.class);
	}

	public Set<IdeaVersion> findByIdeaId(Integer ideaId) {
		String hql = "Select i from IdeaVersion i where i.ideaId.id = :id";
		Query query = this.getEm().createQuery(hql);
		query.setParameter("id", ideaId);

		return new HashSet<>(query.getResultList());
	}

}
