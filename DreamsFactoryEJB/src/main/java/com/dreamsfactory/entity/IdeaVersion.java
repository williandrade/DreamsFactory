package com.dreamsfactory.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "IDEA_VERSION")
@XmlRootElement
public class IdeaVersion implements Serializable {

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
	@Basic(optional = false)
	@Column(name = "IDEA_TYPE_ID")
	private Integer ideaTypeId;
	@Basic(optional = false)
	@Column(name = "USER_ID")
	private Integer userId;
	@Column(name = "CHANGE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date changeDate;
	@JoinColumn(name = "IDEA_ID", referencedColumnName = "ID")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private Idea ideaId;
	@Basic(optional = false)
	@Column(name = "APPROVED")
	private boolean approved;

	public IdeaVersion() {
	}

	public IdeaVersion(Integer id) {
		this.id = id;
	}

	public IdeaVersion(String name, String shortDescription, String description, Date creationDate, Integer ideaTypeId,
			Integer userId, Date changeDate, Boolean approved) {
		super();
		this.name = name;
		this.shortDescription = shortDescription;
		this.description = description;
		this.creationDate = creationDate;
		this.ideaTypeId = ideaTypeId;
		this.userId = userId;
		this.changeDate = changeDate;
		this.approved = approved;
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

	public Idea getIdeaId() {
		return ideaId;
	}

	public void setIdeaId(Idea ideaId) {
		this.ideaId = ideaId;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof IdeaVersion)) {
			return false;
		}
		IdeaVersion other = (IdeaVersion) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.dreamsfactory.entity.IdeaVersion[ id=" + id + " ]";
	}
}
