package com.dreamsfactory.util;

import com.dreamsfactory.dto.ResponseDTO;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ws.rs.core.Response;

@Singleton
public class RestReponseUtil {

	@EJB
	private GsonConverterUtil gsonConverterUtil;

	public Response makeReponse(ResponseDTO dto) {
		Response response = null;
		if (dto.getSuccess()) {
			response = this.makeReponse(dto, Response.Status.OK);
		} else {
			response = this.makeReponse(dto, Response.Status.BAD_REQUEST);
		}
		return response;
	}

	public Response makeReponse(ResponseDTO dto, Response.Status status) {
		return Response.status(status).entity(gsonConverterUtil.toJson(dto)).build();
	}

}