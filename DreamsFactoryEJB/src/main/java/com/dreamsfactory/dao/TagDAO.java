package com.dreamsfactory.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import com.dreamsfactory.entity.Tag;

@Stateless
@LocalBean
public class TagDAO extends GenericDAO<Tag> {

	public TagDAO() {
		super(Tag.class);
	}

	public Set<Tag> searchByName(String name) {
		String hql = "Select t from Tag t where t.name like :name";
		Query query = this.getEm().createQuery(hql);
		query.setParameter("name", "%" + name + "%");

		List<Tag> result = query.getResultList();
		return new HashSet<>(result);
	}

}
