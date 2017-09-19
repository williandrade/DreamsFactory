package com.dreamsfactory.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.dreamsfactory.dto.ResponseDTO;
import com.dreamsfactory.dto.RessourceDTO;
import com.dreamsfactory.handler.UserRequestHandler;
import com.dreamsfactory.session.RessourceSession;
import com.dreamsfactory.util.RestReponseUtil;

@Stateless
@Path("/ressource")
public class RessourceService {

	@EJB
	private RestReponseUtil restReponseUtil;

	@EJB
	private RessourceSession ressourceSession;

	@Inject
	private UserRequestHandler userRequestHandler;

	@GET
	@Path("/idea/{id}")
	public Response findByIdeaId(@PathParam("id") Integer id) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(ressourceSession.findByIdea(id));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@GET
	@Path("/user/{id}")
	public Response findByUserId(@PathParam("id") Integer id) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(ressourceSession.findByIdea(id));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@PUT
	public Response create(RessourceDTO ressourceDTO) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(ressourceSession.create(ressourceDTO));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

}
