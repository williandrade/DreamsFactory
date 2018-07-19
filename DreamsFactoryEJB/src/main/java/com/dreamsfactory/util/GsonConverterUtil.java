package com.dreamsfactory.util;

import java.io.InputStreamReader;
import java.io.Reader;

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
				.setDateFormat(Constants.DEFAULT_DATE_FORMAT).create();
	}

	public String toJson(Object obj) {
		return gson.toJson(obj);
	}

	public Object fromJson(String json, Class<?> clazz) {
		return gson.fromJson(json, clazz);
	}

	public <T> T fromJson(Reader json, Class<T> classOfT) {
		return gson.fromJson(json, classOfT);
	}

}
