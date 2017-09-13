package com.dreamsfactory.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import com.dreamsfactory.entity.User;

@Stateless
@LocalBean
public class UserDAO extends GenericDAO<User> {

	public UserDAO() {
		super(User.class);
	}

	public User findByLogin(String login) {
		String hql = "Select u from User u where u.login = :login and u.available = :available";
		Query query = this.getEm().createQuery(hql);
		query.setParameter("login", login);
		query.setParameter("available", Boolean.TRUE);
		query.setMaxResults(1);

		List<User> result = query.getResultList();

		if (result.isEmpty()) {
			return null;
		}

		return result.get(0);
	}

	public User findByUuid(String uuid) {
		String hql = "Select u from User u where u.uuid = :uuid and u.available = :available";
		Query query = this.getEm().createQuery(hql);
		query.setParameter("uuid", uuid);
		query.setParameter("available", Boolean.TRUE);
		query.setMaxResults(1);

		List<User> result = query.getResultList();

		if (result.isEmpty()) {
			return null;
		}

		return result.get(0);
	}
}
