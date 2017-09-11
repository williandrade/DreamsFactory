package com.dreamsfactory.config;

import java.io.IOException;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import com.dreamsfactory.annotation.OpenMethodAnnotation;
import com.dreamsfactory.handler.UserRequestHandler;
import com.dreamsfactory.util.Constants;

@Provider
public class RequestParamFilter implements ContainerRequestFilter {

	@Context
	private ResourceInfo resourceInfo;

	@Context
	private HttpServletRequest servletRequest;

	@Inject
	private UserRequestHandler userRequestHandler;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String applicationUuid = servletRequest.getHeader("Application-Uuid");
		String userUuid = servletRequest.getHeader("User-Uuid");

		if (!Constants.DEBUG_MODE) {

			if (applicationUuid == null) {
				requestContext.abortWith(Response.status(Status.FORBIDDEN).build());
				return;
			}

			try {

				// VALID APPLICATION,
				// FIND THE APP THAT ARE CALLING ON DATABASE AND IF THE APP DO NOT HAVE THE
				// RIGHT PERMISSION THROWS THE ERROR

				// app = applicationSession.findByUuid(applicationUuid);
				//
				// if (app == null) {
				// requestContext.abortWith(Response.status(Status.FORBIDDEN).build());
				// return;
				// }

			} catch (Exception e) {
				requestContext.abortWith(Response.status(Status.INTERNAL_SERVER_ERROR).build());
				return;
			}

			if (!resourceInfo.getResourceMethod().isAnnotationPresent(OpenMethodAnnotation.class)) {
				if (userUuid == null) {
					requestContext.abortWith(Response.status(Status.FORBIDDEN).build());
					return;
				}
//				try {
//					 VALID USER, IF USER HAVE PERMISSION
//					 user = userSession.findByUuid(userUuid);
//					
//					 if (user == null) {
//					 requestContext.abortWith(Response.status(Status.FORBIDDEN).build());
//					 return;
//					 }
//
//				} catch (TimeoutException te) {
//					requestContext.abortWith(Response.status(Status.REQUEST_TIMEOUT).build());
//					return;
//				} catch (Exception e) {
//					requestContext.abortWith(Response.status(Status.INTERNAL_SERVER_ERROR).build());
//					return;
//				}
			}
		}

		userRequestHandler.setApplication(applicationUuid);
		userRequestHandler.setUser(userUuid);
		userRequestHandler.setStartRequest(new Date());

	}

}
