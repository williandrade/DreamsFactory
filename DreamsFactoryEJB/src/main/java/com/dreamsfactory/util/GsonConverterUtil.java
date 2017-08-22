package com.dreamsfactory.util;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.dreamsfactory.strategy.AnnotationExclusionStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Startup
@Singleton
public class GsonConverterUtil {

	private Gson gson;

	@PostConstruct
	void init() {
		gson = new GsonBuilder().setExclusionStrategies(new AnnotationExclusionStrategy())
				.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").create();
	}

	public String toJson(Object obj) {
		return gson.toJson(obj);
	}

	@SuppressWarnings("unchecked")
	public Object fromJson(String json, Class clazz) {
		return gson.fromJson(json, clazz);
	}

}
