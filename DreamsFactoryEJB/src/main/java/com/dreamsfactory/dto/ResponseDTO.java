package com.dreamsfactory.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement
	private String message;
	@XmlElement
	private Object payLoad;
	@XmlElement
	private Boolean success;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getPayLoad() {
		return payLoad;
	}

	public void setPayLoad(Object payLoad) {
		this.payLoad = payLoad;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

}
