package com.dreamsfactory.dto;

import java.util.Date;

public class IdeaVersionDTO {

	private Integer id;
	private String name;
	private String shortDescription;
	private String description;
	private Date creationDate;
	private Integer ideaTypeId;
	private Integer userId;
	private Date changeDate;
	private Integer ideaId;
	private Boolean approved;
	private Boolean recognized;

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

	public Integer getIdeaTypeId() {
		return ideaTypeId;
	}

	public void setIdeaTypeId(Integer ideaTypeId) {
		this.ideaTypeId = ideaTypeId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getChangeDate() {
		return changeDate;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	public Integer getIdeaId() {
		return ideaId;
	}

	public void setIdeaId(Integer ideaId) {
		this.ideaId = ideaId;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public Boolean getRecognized() {
		return recognized;
	}

	public void setRecognized(Boolean recognized) {
		this.recognized = recognized;
	}

}
