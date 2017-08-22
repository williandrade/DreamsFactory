/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author william
 */
@Entity
@Table(name = "FOLLOW_IDEA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FollowIdea.findAll", query = "SELECT f FROM FollowIdea f")
    , @NamedQuery(name = "FollowIdea.findById", query = "SELECT f FROM FollowIdea f WHERE f.id = :id")
    , @NamedQuery(name = "FollowIdea.findByFollowDate", query = "SELECT f FROM FollowIdea f WHERE f.followDate = :followDate")
    , @NamedQuery(name = "FollowIdea.findByUnfollowDate", query = "SELECT f FROM FollowIdea f WHERE f.unfollowDate = :unfollowDate")})
public class FollowIdea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "FOLLOW_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date followDate;
    @Basic(optional = false)
    @Column(name = "UNFOLLOW_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date unfollowDate;
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User userId;
    @JoinColumn(name = "IDEA_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Idea ideaId;

    public FollowIdea() {
    }

    public FollowIdea(Integer id) {
        this.id = id;
    }

    public FollowIdea(Integer id, Date followDate, Date unfollowDate) {
        this.id = id;
        this.followDate = followDate;
        this.unfollowDate = unfollowDate;
    }

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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Idea getIdeaId() {
        return ideaId;
    }

    public void setIdeaId(Idea ideaId) {
        this.ideaId = ideaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FollowIdea)) {
            return false;
        }
        FollowIdea other = (FollowIdea) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dreamsfactory.entity.FollowIdea[ id=" + id + " ]";
    }
    
}
