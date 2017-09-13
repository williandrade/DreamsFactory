package com.dreamsfactory.handler;

import java.util.Date;

import javax.enterprise.context.RequestScoped;

import com.dreamsfactory.dto.UserDTO;

@RequestScoped
public class UserRequestHandler {

	private String application;
	private UserDTO user;
	private Date startRequest;

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public Date getStartRequest() {
		return startRequest;
	}

	public void setStartRequest(Date startRequest) {
		this.startRequest = startRequest;
	}

}
