package com.dreamsfactory.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.dreamsfactory.dto.ResponseDTO;
import com.dreamsfactory.handler.UserRequestHandler;
import com.dreamsfactory.session.LikeIdeaSession;
import com.dreamsfactory.util.RestReponseUtil;

@Stateless
@Path("/likeidea")
public class LikeIdeaService {

	@EJB
	private RestReponseUtil restReponseUtil;

	@EJB
	private LikeIdeaSession likeIdeaSession;

	@Inject
	private UserRequestHandler userRequestHandler;

	@GET
	@Path("/idea/{ideaId}")
	public Response findLikesFromIdea(@PathParam("ideaId") Integer ideaId) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(likeIdeaSession.findLikesFromIdea(ideaId));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@GET
	@Path("/user/{userId}")
	public Response findLikesFromUser(@PathParam("userId") Integer userId) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(likeIdeaSession.findLikesFromUser(userId));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@POST
	@Path("/like/{ideaId}/user/{userId}")
	public Response like(@PathParam("ideaId") Integer ideaId, @PathParam("userId") Integer userId) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(likeIdeaSession.like(ideaId, userId));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@POST
	@Path("/unlike/{ideaId}/user/{userId}")
	public Response unlike(@PathParam("ideaId") Integer ideaId, @PathParam("userId") Integer userId) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			likeIdeaSession.unlike(ideaId, userId);
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

}
