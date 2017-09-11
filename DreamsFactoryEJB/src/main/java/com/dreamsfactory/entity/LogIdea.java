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
import javax.persistence.Lob;
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
@Table(name = "LOG_IDEA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LogIdea.findAll", query = "SELECT l FROM LogIdea l")
    , @NamedQuery(name = "LogIdea.findById", query = "SELECT l FROM LogIdea l WHERE l.id = :id")
    , @NamedQuery(name = "LogIdea.findByLogDate", query = "SELECT l FROM LogIdea l WHERE l.logDate = :logDate")})
public class LogIdea implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "LOG")
    private String log;
    @Basic(optional = false)
    @Column(name = "LOG_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date logDate;
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User userId;
    @JoinColumn(name = "IDEA_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Idea ideaId;

    public LogIdea() {
    }

    public LogIdea(Integer id) {
        this.id = id;
    }

    public LogIdea(Integer id, String log, Date logDate) {
        this.id = id;
        this.log = log;
        this.logDate = logDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
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
        if (!(object instanceof LogIdea)) {
            return false;
        }
        LogIdea other = (LogIdea) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dreamsfactory.entity.LogIdea[ id=" + id + " ]";
    }
    
}
