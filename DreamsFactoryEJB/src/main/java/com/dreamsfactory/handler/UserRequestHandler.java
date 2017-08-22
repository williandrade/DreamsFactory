package com.dreamsfactory.handler;

import java.util.Date;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class UserRequestHandler {

	private String application;
	private String user;
	private Date startRequest;

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Date getStartRequest() {
		return startRequest;
	}

	public void setStartRequest(Date startRequest) {
		this.startRequest = startRequest;
	}

}
