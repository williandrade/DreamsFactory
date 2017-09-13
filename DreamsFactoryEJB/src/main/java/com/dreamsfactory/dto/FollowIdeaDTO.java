package com.dreamsfactory.dto;

import java.util.Date;

public class FollowIdeaDTO {

	private Integer id;
	private Date followDate;
	private Date unfollowDate;
	private Integer userId;
	private Integer ideaId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFollowDate() {
		return followDate;
	}

	public void setFollowDate(Date followDate) {
		this.followDate = followDate;
	}

	public Date getUnfollowDate() {
		return unfollowDate;
	}

	public void setUnfollowDate(Date unfollowDate) {
		this.unfollowDate = unfollowDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getIdeaId() {
		return ideaId;
	}

	public void setIdeaId(Integer ideaId) {
		this.ideaId = ideaId;
	}

}
