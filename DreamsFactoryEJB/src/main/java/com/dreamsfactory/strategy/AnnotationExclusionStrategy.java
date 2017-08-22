package com.dreamsfactory.strategy;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.annotations.Expose;

public class AnnotationExclusionStrategy implements ExclusionStrategy {

	@Override
	public boolean shouldSkipField(FieldAttributes f) {
		return f.getAnnotation(Expose.class) != null;
	}

	@Override
	public boolean shouldSkipClass(Class<?> clazz) {
		return false;
	}
}
