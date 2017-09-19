package com.dreamsfactory.session;

import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dreamsfactory.dao.UserDAO;
import com.dreamsfactory.dto.UserDTO;
import com.dreamsfactory.entity.User;
import com.dreamsfactory.exception.ArgumentMissingException;
import com.dreamsfactory.mapper.UserMapper;

@Stateless
@LocalBean
public class UserSession {

	private static final Logger logger = LogManager.getLogger(UserSession.class);

	@EJB
	private UserDAO userDAO;

	@Inject
	private UserMapper userMapper;

	public Set<UserDTO> findAll() throws Exception {
		Set<User> users = userDAO.findAll();
		Set<UserDTO> userDTOs = userMapper.usersToUserDTOs(users);
		return userDTOs;
	}

	public UserDTO findById(Integer id) throws Exception {
		if (id == null) {
			throw new ArgumentMissingException("Id");
		}

		User user = userDAO.findById(id);
		UserDTO userDTO = userMapper.userToUserDTO(user);
		return userDTO;
	}

	public UserDTO findByLogin(String login) throws Exception {
		if (login == null) {
			throw new ArgumentMissingException("login");
		}

		User user = userDAO.findByLogin(login);
		UserDTO userDTO = userMapper.userToUserDTO(user);
		return userDTO;
	}

	public UserDTO findByUuid(String uuid) throws Exception {
		if (uuid == null) {
			throw new ArgumentMissingException("uuid");
		}

		User user = userDAO.findByUuid(uuid);
		UserDTO userDTO = userMapper.userToUserDTO(user);
		return userDTO;
	}

	public UserDTO create(UserDTO userDTO) throws Exception {
		if (userDTO.getAvailable() == null) {
			userDTO.setAvailable(true);
		}
		User user = userMapper.userDTOToUser(userDTO);
		user = userDAO.insert(user);
		userDTO = userMapper.userToUserDTO(user);
		return userDTO;
	}

	public UserDTO update(UserDTO userDTO) throws Exception {
		User user = userMapper.userDTOToUser(userDTO);
		user = userDAO.update(user);
		userDTO = userMapper.userToUserDTO(user);
		return userDTO;
	}

}
