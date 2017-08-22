package com.dreamsfactory.config;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;

public class ResponseFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext reponseContext)
			throws IOException {
		reponseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
		reponseContext.getHeaders().add("Access-Control-Allow-Headers",
				"origin, content-type, accept, authorization, Application-Uuid, User-Uuid");
		reponseContext.getHeaders().add("Access-Control-Allow-Credentials", "true");
		reponseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
	}

}
