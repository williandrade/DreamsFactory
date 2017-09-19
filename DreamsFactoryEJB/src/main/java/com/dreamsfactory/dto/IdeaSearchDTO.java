package com.dreamsfactory.dto;

public class IdeaSearchDTO {

	private Integer id;
	private String shortDescription;
	private Float score;

	public IdeaSearchDTO() {
		super();
	}

	public IdeaSearchDTO(Integer id, String shortDescription) {
		super();
		this.id = id;
		this.shortDescription = shortDescription;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

}
