package com.dreamsfactory.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.dreamsfactory.dto.ResponseDTO;
import com.dreamsfactory.handler.UserRequestHandler;
import com.dreamsfactory.session.IdeaVersionSession;
import com.dreamsfactory.util.RestReponseUtil;

@Stateless
@Path("/ideaversion")
public class IdeaVersionService {

	@EJB
	private RestReponseUtil restReponseUtil;

	@EJB
	private IdeaVersionSession ideaVersionSession;

	@Inject
	private UserRequestHandler userRequestHandler;

	@GET
	@Path("/idea/{ideaId}")
	public Response findAllByIdeaId(@PathParam("ideaId") Integer ideaId) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(ideaVersionSession.findByIdeaId(ideaId));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@GET
	@Path("/idea/{ideaId}/approved")
	public Response findAllByIdeaIdApproved(@PathParam("ideaId") Integer ideaId) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(ideaVersionSession.findByIdeaIdAndApproved(ideaId, true));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@GET
	@Path("/idea/{ideaId}/pending")
	public Response findAllByIdeaIdPending(@PathParam("ideaId") Integer ideaId) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(ideaVersionSession.findByIdeaIdAndApproved(ideaId, false));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@GET
	@Path("/{id}/accept")
	public Response acceptVersion(@PathParam("id") Integer id) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			ideaVersionSession.acceptVersion(id, userRequestHandler.getUser().getId());
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@GET
	@Path("/{id}/decline")
	public Response declineVersion(@PathParam("id") Integer id) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			ideaVersionSession.declineVersion(id, userRequestHandler.getUser().getId());
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}
}
