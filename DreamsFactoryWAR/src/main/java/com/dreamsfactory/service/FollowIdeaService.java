package com.dreamsfactory.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dreamsfactory.dto.ResponseDTO;
import com.dreamsfactory.handler.UserRequestHandler;
import com.dreamsfactory.session.FollowIdeaSession;
import com.dreamsfactory.util.RestReponseUtil;

@Stateless
@Path("/followidea")
public class FollowIdeaService {

	@EJB
	private RestReponseUtil restReponseUtil;

	@EJB
	private FollowIdeaSession followIdeaSession;

	@Inject
	private UserRequestHandler userRequestHandler;

	@GET
	@Path("/followers/{ideaId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response follow(@PathParam("ideaId") Integer ideaId) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(followIdeaSession.findFollowers(ideaId));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@POST
	@Path("/follow/{ideaId}/user/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response follow(@PathParam("ideaId") Integer ideaId, @PathParam("userId") Integer userId) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(followIdeaSession.follow(ideaId, userId));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@POST
	@Path("/unfollow/{followId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response unfollow(@PathParam("followId") Integer followId) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(followIdeaSession.unfollow(followId));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

	@POST
	@Path("/unfollow/{ideaId}/user/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response unfollow(@PathParam("ideaId") Integer ideaId, @PathParam("userId") Integer userId) {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(followIdeaSession.unfollow(ideaId, userId));
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

}
