package com.dreamsfactory.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dreamsfactory.dto.IdeaTypeDTO;
import com.dreamsfactory.dto.ResponseDTO;
import com.dreamsfactory.handler.UserRequestHandler;
import com.dreamsfactory.session.IdeaTypeSession;
import com.dreamsfactory.util.RestReponseUtil;

@Stateless
@Path("/ideatype")
public class IdeaTypeService {

	@EJB
	private RestReponseUtil restReponseUtil;

	@EJB
	private IdeaTypeSession ideaTypeSession;

	@Inject
	private UserRequestHandler userRequestHandler;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(ideaTypeSession.findAll());
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("id") Integer id) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(ideaTypeSession.findById(id));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(IdeaTypeDTO ideaTypeDTO) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(ideaTypeSession.create(ideaTypeDTO));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(IdeaTypeDTO ideaTypeDTO) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(ideaTypeSession.update(ideaTypeDTO));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") Integer id) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			ideaTypeSession.delete(id);
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}
}
