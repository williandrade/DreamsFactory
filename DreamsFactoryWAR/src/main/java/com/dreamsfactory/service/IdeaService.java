package com.dreamsfactory.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dreamsfactory.annotation.OpenMethodAnnotation;
import com.dreamsfactory.dto.IdeaCreationDTO;
import com.dreamsfactory.dto.IdeaDTO;
import com.dreamsfactory.dto.ResponseDTO;
import com.dreamsfactory.handler.UserRequestHandler;
import com.dreamsfactory.session.IdeaSession;
import com.dreamsfactory.util.RestReponseUtil;

@Stateless
@Path("/idea")
public class IdeaService {

	@EJB
	private RestReponseUtil restReponseUtil;

	@EJB
	private IdeaSession ideaSession;

	@Inject
	private UserRequestHandler userRequestHandler;

	@GET
	@Path("/{id}")
	@OpenMethodAnnotation
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("id") Integer id) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(ideaSession.findById(id));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@GET
	@Path("/top/{qtd}")
	@OpenMethodAnnotation
	@Produces(MediaType.APPLICATION_JSON)
	public Response findTop(@PathParam("qtd") Integer qtd) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(ideaSession.findTop(qtd));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(IdeaCreationDTO ideaCreateDTO) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(ideaSession.create(ideaCreateDTO, userRequestHandler.getUser()));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response findSimillar(IdeaDTO ideaDTO) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(ideaSession.edit(ideaDTO, userRequestHandler.getUser().getId()));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@POST
	@Path("/simillar")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findSimillar(@FormParam("description") String description) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(ideaSession.findSimillar(description));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}
}
