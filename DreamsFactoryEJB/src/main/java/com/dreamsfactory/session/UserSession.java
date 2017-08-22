package com.dreamsfactory.session;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.dreamsfactory.dto.UserDTO;

@Stateless
@LocalBean
public class UserSession {

	public List<String> findAll() {
		return Arrays.asList("OI", "Ola", "Hello");
	}

	public UserDTO getUser(String name) {
		UserDTO result = new UserDTO();

		result.setName(name);
		result.setBirthDate(new Date());

		return result;
	}

}
