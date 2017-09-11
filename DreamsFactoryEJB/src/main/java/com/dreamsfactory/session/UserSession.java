package com.dreamsfactory.session;

import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.dreamsfactory.dao.UserDAO;
import com.dreamsfactory.dto.UserDTO;
import com.dreamsfactory.entity.User;
import com.dreamsfactory.mapper.UserMapper;

@Stateless
@LocalBean
public class UserSession {

	@EJB
	private UserDAO userDAO;

	@Inject
	private UserMapper userMapper;

	public Set<UserDTO> findAll() {
		Set<User> users = userDAO.findAll();
		Set<UserDTO> userDTOs = userMapper.usersToUserDTOs(users);
		return userDTOs;
	}

	public UserDTO findById(Integer id) {
		User user = userDAO.findById(id);
		UserDTO userDTO = userMapper.userToUserDTO(user);
		return userDTO;
	}

}
