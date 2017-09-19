package com.dreamsfactory.dto;

import java.util.Date;
import java.util.Set;

public class RessourceDTO {

	private Integer id;
	private String name;
	private String url;
	private Integer userId;
	private Date insertDate;
	private Integer ideaId;
	private RessourceProviderDTO providerId;
	private Set<RessourceCategoryDTO> categorySet;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public Integer getIdeaId() {
		return ideaId;
	}

	public void setIdeaId(Integer ideaId) {
		this.ideaId = ideaId;
	}

	public RessourceProviderDTO getProviderId() {
		return providerId;
	}

	public void setProviderId(RessourceProviderDTO providerId) {
		this.providerId = providerId;
	}

	public Set<RessourceCategoryDTO> getCategorySet() {
		return categorySet;
	}

	public void setCategorySet(Set<RessourceCategoryDTO> categorySet) {
		this.categorySet = categorySet;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
