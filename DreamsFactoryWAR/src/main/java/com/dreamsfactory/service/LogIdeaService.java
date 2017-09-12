package com.dreamsfactory.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.dreamsfactory.dto.IdeaTypeDTO;
import com.dreamsfactory.dto.LogIdeaDTO;
import com.dreamsfactory.dto.ResponseDTO;
import com.dreamsfactory.handler.UserRequestHandler;
import com.dreamsfactory.session.LogIdeaSession;
import com.dreamsfactory.util.RestReponseUtil;

@Stateless
@Path("/logidea")
public class LogIdeaService {
	@EJB
	private RestReponseUtil restReponseUtil;

	@EJB
	private LogIdeaSession logIdeaSession;

	@Inject
	private UserRequestHandler userRequestHandler;

	@GET
	@Path("/idea/{id}")
	public Response findByIdeaId(@PathParam("id") Integer id) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(logIdeaSession.findByIdeaId(id));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@GET
	@Path("/idea/{id}/last")
	public Response findLastByIdeaId(@PathParam("id") Integer id) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(logIdeaSession.findLastByIdeaId(id));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@PUT
	public Response create(LogIdeaDTO logIdeaDTO) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(logIdeaSession.create(logIdeaDTO));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}
}
