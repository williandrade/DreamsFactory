package com.dreamsfactory.dto;

public class IdeaTypeDTO {
	private Integer id;
	private String name;
	private boolean available;

	public IdeaTypeDTO() {
		super();
	}

	public IdeaTypeDTO(Integer id) {
		super();
		this.id = id;
	}

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

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}
}
