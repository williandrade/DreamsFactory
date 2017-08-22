package com.dreamsfactory.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dreamsfactory.dto.ResponseDTO;
import com.dreamsfactory.handler.UserRequestHandler;
import com.dreamsfactory.session.UserSession;
import com.dreamsfactory.util.RestReponseUtil;

@Stateless
@Path("/user")
public class UserService {

	@EJB
	private RestReponseUtil restReponseUtil;

	@EJB
	private UserSession userSession;

	@Inject
	private UserRequestHandler userRequestHandler;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response find() {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(userSession.findAll());
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@GET
	@Path("/{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response findByName(@PathParam("name") String name) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(userSession.getUser(name));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}
}
