package com.dreamsfactory.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.dreamsfactory.annotation.OpenMethodAnnotation;
import com.dreamsfactory.dto.ResponseDTO;
import com.dreamsfactory.dto.SignInDTO;
import com.dreamsfactory.dto.UserDTO;
import com.dreamsfactory.handler.UserRequestHandler;
import com.dreamsfactory.session.LoginSession;
import com.dreamsfactory.util.RestReponseUtil;

@Stateless
@Path("/login")
public class LoginService {

	@EJB
	private RestReponseUtil restReponseUtil;

	@EJB
	private LoginSession loginSession;

	@Inject
	private UserRequestHandler userRequestHandler;

	@POST
	@Path("/signin")
	@OpenMethodAnnotation
	public Response signIn(SignInDTO signInDTO) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(loginSession.signIn(signInDTO));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@POST
	@Path("/signup")
	@OpenMethodAnnotation
	public Response signUp(UserDTO userDTO) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(loginSession.signUp(userDTO));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}
}
