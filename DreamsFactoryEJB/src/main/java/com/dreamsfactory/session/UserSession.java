package com.dreamsfactory.session;

import java.util.Date;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.dreamsfactory.dao.UserDAO;
import com.dreamsfactory.entity.User;

@Stateless
@LocalBean
public class UserSession {

	@EJB
	private UserDAO userDAO;

	public Set<User> findAll() {
		return userDAO.findAll();
	}

	public User findById(Integer id) {
		return userDAO.findById(id);
	}

}
