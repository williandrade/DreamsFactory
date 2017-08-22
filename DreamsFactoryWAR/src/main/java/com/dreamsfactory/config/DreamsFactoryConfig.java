package com.dreamsfactory.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/service")
public class DreamsFactoryConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();

//		classes.add(com.dreamsfactory.config.RequestParamFilter.class);
//		classes.add(com.dreamsfactory.config.ResponseFilter.class);

		classes.add(com.dreamsfactory.service.UserService.class);

		return classes;
	}

}