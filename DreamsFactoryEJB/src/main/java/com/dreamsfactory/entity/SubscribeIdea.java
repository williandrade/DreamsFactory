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
@Table(name = "SUBSCRIBE_IDEA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubscribeIdea.findAll", query = "SELECT s FROM SubscribeIdea s")
    , @NamedQuery(name = "SubscribeIdea.findById", query = "SELECT s FROM SubscribeIdea s WHERE s.id = :id")
    , @NamedQuery(name = "SubscribeIdea.findBySubscriptionDate", query = "SELECT s FROM SubscribeIdea s WHERE s.subscriptionDate = :subscriptionDate")
    , @NamedQuery(name = "SubscribeIdea.findByEnable", query = "SELECT s FROM SubscribeIdea s WHERE s.enable = :enable")})
public class SubscribeIdea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "SUBSCRIPTION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date subscriptionDate;
    @Basic(optional = false)
    @Column(name = "ENABLE")
    private boolean enable;
    @JoinColumn(name = "SUBSCRIBE_LEVEL_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SubscribeLevel subscribeLevelId;
    @JoinColumn(name = "IDEA_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Idea ideaId;
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User userId;

    public SubscribeIdea() {
    }

    public SubscribeIdea(Integer id) {
        this.id = id;
    }

    public SubscribeIdea(Integer id, Date subscriptionDate, boolean enable) {
        this.id = id;
        this.subscriptionDate = subscriptionDate;
        this.enable = enable;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public boolean getEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public SubscribeLevel getSubscribeLevelId() {
        return subscribeLevelId;
    }

    public void setSubscribeLevelId(SubscribeLevel subscribeLevelId) {
        this.subscribeLevelId = subscribeLevelId;
    }

    public Idea getIdeaId() {
        return ideaId;
    }

    public void setIdeaId(Idea ideaId) {
        this.ideaId = ideaId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
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
        if (!(object instanceof SubscribeIdea)) {
            return false;
        }
        SubscribeIdea other = (SubscribeIdea) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dreamsfactory.entity.SubscribeIdea[ id=" + id + " ]";
    }
    
}
