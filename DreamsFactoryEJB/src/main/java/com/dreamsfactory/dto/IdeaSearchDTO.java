package com.dreamsfactory.dto;

public class IdeaSearchDTO {

	private Integer id;
	private String name;
	private String shortDescription;
	private Long qtdLike;
	private Float score;

	public IdeaSearchDTO() {
		super();
	}

	public IdeaSearchDTO(Integer id, String shortDescription) {
		super();
		this.id = id;
		this.shortDescription = shortDescription;
	}

	public IdeaSearchDTO(Integer id, String name, String shortDescription) {
		super();
		this.id = id;
		this.name = name;
		this.shortDescription = shortDescription;
	}

	public IdeaSearchDTO(Integer id, String name, String shortDescription, Long qtdLike) {
		super();
		this.id = id;
		this.name = name;
		this.shortDescription = shortDescription;
		this.qtdLike = qtdLike;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getQtdLike() {
		return qtdLike;
	}

	public void setQtdLike(Long qtdLike) {
		this.qtdLike = qtdLike;
	}

}
