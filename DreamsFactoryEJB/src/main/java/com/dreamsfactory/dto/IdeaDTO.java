package com.dreamsfactory.dto;

import java.util.Date;

public class IdeaDTO {

	private Integer id;
	private String name;
	private String shortDescription;
	private String description;
	private Date creationDate;
	private IdeaTypeDTO ideaType;

	private Integer userId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public IdeaTypeDTO getIdeaType() {
		return ideaType;
	}

	public void setIdeaType(IdeaTypeDTO ideaType) {
		this.ideaType = ideaType;
	}

}
