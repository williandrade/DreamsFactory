package com.dreamsfactory.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.dreamsfactory.dto.ResponseDTO;
import com.dreamsfactory.dto.TagDTO;
import com.dreamsfactory.handler.UserRequestHandler;
import com.dreamsfactory.session.TagSession;
import com.dreamsfactory.util.RestReponseUtil;

@Stateless
@Path("/tag")
public class TagService {

	@EJB
	private TagSession tagSession;

	@EJB
	private RestReponseUtil restReponseUtil;

	@Inject
	private UserRequestHandler userRequestHandler;

	@GET
	public Response findAll() {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(tagSession.findAll());
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@GET
	@Path("/{id}")
	public Response findById(@PathParam("id") Integer id) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(tagSession.findById(id));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@GET
	@Path("/complete/{name}")
	public Response completeByName(@PathParam("name") String name) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(tagSession.completeByName(name));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@PUT
	public Response create(TagDTO tagDTO) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(tagSession.create(tagDTO));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@POST
	public Response update(TagDTO tagDTO) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(tagSession.update(tagDTO));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") Integer id) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			tagSession.delete(id);
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}
}
