package com.dreamsfactory.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.dreamsfactory.dto.ResponseDTO;
import com.dreamsfactory.handler.UserRequestHandler;
import com.dreamsfactory.session.RessourceProviderSession;
import com.dreamsfactory.util.RestReponseUtil;

@Stateless
@Path("/ressourceprovider")
public class RessourceProviderService {

	@EJB
	private RestReponseUtil restReponseUtil;

	@EJB
	private RessourceProviderSession ressourceProviderSession;

	@Inject
	private UserRequestHandler userRequestHandler;

	@GET
	public Response findAll() {
		ResponseDTO response = new ResponseDTO();

		try {
			response.setSuccess(true);
			response.setPayLoad(ressourceProviderSession.findAll());
		} catch (Exception e) {
			response.setSuccess(false);
			response.setMessage(e.getMessage());
		}

		return restReponseUtil.makeReponse(response);
	}

}
