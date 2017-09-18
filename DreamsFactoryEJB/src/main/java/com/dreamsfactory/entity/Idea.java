/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dreamsfactory.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author william
 */
@Entity
@Table(name = "IDEA")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Idea.findAll", query = "SELECT i FROM Idea i"),
		@NamedQuery(name = "Idea.findById", query = "SELECT i FROM Idea i WHERE i.id = :id"),
		@NamedQuery(name = "Idea.findByName", query = "SELECT i FROM Idea i WHERE i.name = :name"),
		@NamedQuery(name = "Idea.findByShortDescription", query = "SELECT i FROM Idea i WHERE i.shortDescription = :shortDescription"),
		@NamedQuery(name = "Idea.findByCreationDate", query = "SELECT i FROM Idea i WHERE i.creationDate = :creationDate") })
public class Idea implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "NAME")
	private String name;
	@Basic(optional = false)
	@Column(name = "SHORT_DESCRIPTION")
	private String shortDescription;
	@Basic(optional = false)
	@Lob
	@Column(name = "DESCRIPTION")
	private String description;
	@Basic(optional = false)
	@Column(name = "CREATION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;
	@JoinColumn(name = "IDEA_TYPE_ID", referencedColumnName = "ID")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private IdeaType ideaType;
	@JoinTable(name = "IDEA_TAG", joinColumns = {
			@JoinColumn(name = "IDEA_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "TAGS_ID", referencedColumnName = "ID") })
	@ManyToMany(fetch = FetchType.LAZY)
	private Set<Tag> tagSet;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ideaId", fetch = FetchType.LAZY)
	private Set<SubscribeIdea> subscribeIdeaSet;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ideaId", fetch = FetchType.LAZY)
	private Set<LikeIdea> likeIdeaSet;
	@JoinColumn(name = "USER_ID", referencedColumnName = "ID")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private User userId;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ideaId", fetch = FetchType.LAZY)
	private Set<LogIdea> logIdeaSet;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ideaId", fetch = FetchType.LAZY)
	private Set<FollowIdea> followIdeaSet;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ideaId", fetch = FetchType.LAZY)
	private Set<Ressource> ressourceSet;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ideaId", fetch = FetchType.LAZY)
	private Set<IdeaVersion> ideaHistorySet;

	public Idea() {
	}

	public Idea(Integer id) {
		this.id = id;
	}

	public Idea(Integer id, String name, String shortDescription, String description, Date creationDate) {
		this.id = id;
		this.name = name;
		this.shortDescription = shortDescription;
		this.description = description;
		this.creationDate = creationDate;
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

	@XmlTransient
	public Set<Tag> getTagSet() {
		return tagSet;
	}

	public void setTagSet(Set<Tag> tagSet) {
		this.tagSet = tagSet;
	}

	@XmlTransient
	public Set<SubscribeIdea> getSubscribeIdeaSet() {
		return subscribeIdeaSet;
	}

	public void setSubscribeIdeaSet(Set<SubscribeIdea> subscribeIdeaSet) {
		this.subscribeIdeaSet = subscribeIdeaSet;
	}

	@XmlTransient
	public Set<LikeIdea> getLikeIdeaSet() {
		return likeIdeaSet;
	}

	public void setLikeIdeaSet(Set<LikeIdea> likeIdeaSet) {
		this.likeIdeaSet = likeIdeaSet;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	@XmlTransient
	public Set<LogIdea> getLogIdeaSet() {
		return logIdeaSet;
	}

	public void setLogIdeaSet(Set<LogIdea> logIdeaSet) {
		this.logIdeaSet = logIdeaSet;
	}

	@XmlTransient
	public Set<FollowIdea> getFollowIdeaSet() {
		return followIdeaSet;
	}

	public void setFollowIdeaSet(Set<FollowIdea> followIdeaSet) {
		this.followIdeaSet = followIdeaSet;
	}

	@XmlTransient
	public Set<Ressource> getRessourceSet() {
		return ressourceSet;
	}

	public void setRessourceSet(Set<Ressource> ressourceSet) {
		this.ressourceSet = ressourceSet;
	}

	public IdeaType getIdeaType() {
		return ideaType;
	}

	public void setIdeaType(IdeaType ideaType) {
		this.ideaType = ideaType;
	}

	public Set<IdeaVersion> getIdeaHistorySet() {
		return ideaHistorySet;
	}

	public void setIdeaHistorySet(Set<IdeaVersion> ideaHistorySet) {
		this.ideaHistorySet = ideaHistorySet;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Idea)) {
			return false;
		}
		Idea other = (Idea) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.dreamsfactory.entity.Idea[ id=" + id + " ]";
	}

}
