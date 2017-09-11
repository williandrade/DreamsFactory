package com.dreamsfactory.dto;

import java.util.Date;

public class NotificationDTO {
	private Integer id;
	private String title;
	private String description;
	private Date notificationDate;
	private NotificationTypeDTO notificationTypeId;
	private Date visualizationDate;
	private Integer userId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getNotificationDate() {
		return notificationDate;
	}

	public void setNotificationDate(Date notificationDate) {
		this.notificationDate = notificationDate;
	}

	public NotificationTypeDTO getNotificationTypeId() {
		return notificationTypeId;
	}

	public void setNotificationTypeId(NotificationTypeDTO notificationTypeId) {
		this.notificationTypeId = notificationTypeId;
	}

	public Date getVisualizationDate() {
		return visualizationDate;
	}

	public void setVisualizationDate(Date visualizationDate) {
		this.visualizationDate = visualizationDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
