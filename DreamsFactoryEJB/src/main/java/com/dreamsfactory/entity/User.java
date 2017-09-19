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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author william
 */
@Entity
@Table(name = "USER")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
		@NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
		@NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.firstName = :firstName"),
		@NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.lastName = :lastName"),
		@NamedQuery(name = "User.findByBirthDate", query = "SELECT u FROM User u WHERE u.birthDate = :birthDate"),
		@NamedQuery(name = "User.findByEMail", query = "SELECT u FROM User u WHERE u.eMail = :eMail"),
		@NamedQuery(name = "User.findByLogin", query = "SELECT u FROM User u WHERE u.login = :login"),
		@NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password") })
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID")
	private Integer id;
	@Basic(optional = false)
	@Column(name = "FIRST_NAME")
	private String firstName;
	@Basic(optional = false)
	@Column(name = "LAST_NAME")
	private String lastName;
	@Column(name = "BIRTH_DATE")
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	@Basic(optional = false)
	@Column(name = "E_MAIL")
	private String eMail;
	@Basic(optional = false)
	@Column(name = "LOGIN")
	private String login;
	@Basic(optional = false)
	@Column(name = "PASSWORD")
	private String password;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
	private Set<SubscribeIdea> subscribeIdeaSet;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
	private Set<LikeIdea> likeIdeaSet;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
	private Set<Notification> notificationSet;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
	private Set<Idea> ideaSet;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
	private Set<LogIdea> logIdeaSet;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
	private Set<FollowIdea> followIdeaSet;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
	private Set<Ressource> ressourceSet;
	@Size(max = 255)
	@Column(name = "UUID")
	private String uuid;
	@Column(name = "UUID_GENERATION_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date uuidGenerationDate;
	@Transient
	private Date expirationDate;
	@Basic(optional = false)
	@Column(name = "AVAILABLE")
	private boolean available;

	public User() {
	}

	public User(Integer id) {
		this.id = id;
	}

	public User(Integer id, String firstName, String lastName, Date birthDate, String eMail, String login,
			String password, Set<SubscribeIdea> subscribeIdeaSet, Set<LikeIdea> likeIdeaSet,
			Set<Notification> notificationSet, Set<Idea> ideaSet, Set<LogIdea> logIdeaSet,
			Set<FollowIdea> followIdeaSet, String uuid, Date uuidGenerationDate, Date expirationDate) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.eMail = eMail;
		this.login = login;
		this.password = password;
		this.subscribeIdeaSet = subscribeIdeaSet;
		this.likeIdeaSet = likeIdeaSet;
		this.notificationSet = notificationSet;
		this.ideaSet = ideaSet;
		this.logIdeaSet = logIdeaSet;
		this.followIdeaSet = followIdeaSet;
		this.uuid = uuid;
		this.uuidGenerationDate = uuidGenerationDate;
		this.expirationDate = expirationDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@XmlTransient
	public Set<Notification> getNotificationSet() {
		return notificationSet;
	}

	public void setNotificationSet(Set<Notification> notificationSet) {
		this.notificationSet = notificationSet;
	}

	@XmlTransient
	public Set<Idea> getIdeaSet() {
		return ideaSet;
	}

	public void setIdeaSet(Set<Idea> ideaSet) {
		this.ideaSet = ideaSet;
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

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Date getUuidGenerationDate() {
		return uuidGenerationDate;
	}

	public void setUuidGenerationDate(Date uuidGenerationDate) {
		this.uuidGenerationDate = uuidGenerationDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof User)) {
			return false;
		}
		User other = (User) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.dreamsfactory.entity.User[ id=" + id + " ]";
	}

}
