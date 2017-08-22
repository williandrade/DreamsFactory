package com.dreamsfactory.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.dreamsfactory.entity.User;

@Stateless
@LocalBean
public class UserDAO extends GenericDAO<User> {

	public UserDAO() {
		super(User.class);
	}

}
