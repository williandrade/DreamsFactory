package com.dreamsfactory.dto;

import java.util.Set;

public class IdeaCreationDTO {

	private String shortDescription;
	private String description;
	private Integer ideaTypeId;
	private Set<Integer> tagIds;

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getIdeaTypeId() {
		return ideaTypeId;
	}

	public void setIdeaTypeId(Integer ideaTypeId) {
		this.ideaTypeId = ideaTypeId;
	}

	public Set<Integer> getTagIds() {
		return tagIds;
	}

	public void setTagIds(Set<Integer> tagIds) {
		this.tagIds = tagIds;
	}

}
