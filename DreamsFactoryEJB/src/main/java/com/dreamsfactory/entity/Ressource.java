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
@Table(name = "RESSOURCE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ressource.findAll", query = "SELECT r FROM Ressource r")
    , @NamedQuery(name = "Ressource.findById", query = "SELECT r FROM Ressource r WHERE r.id = :id")
    , @NamedQuery(name = "Ressource.findByName", query = "SELECT r FROM Ressource r WHERE r.name = :name")
    , @NamedQuery(name = "Ressource.findByUrl", query = "SELECT r FROM Ressource r WHERE r.url = :url")
    , @NamedQuery(name = "Ressource.findByUserId", query = "SELECT r FROM Ressource r WHERE r.userId = :userId")
    , @NamedQuery(name = "Ressource.findByInsertDate", query = "SELECT r FROM Ressource r WHERE r.insertDate = :insertDate")})
public class Ressource implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @Column(name = "URL")
    private String url;
    @Basic(optional = false)
    @Column(name = "USER_ID")
    private int userId;
    @Basic(optional = false)
    @Column(name = "INSERT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate;
    @JoinColumn(name = "IDEA_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Idea ideaId;
    @JoinColumn(name = "PROVIDER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RessourceProvider providerId;
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private RessourceCategory categoryId;

    public Ressource() {
    }

    public Ressource(Integer id) {
        this.id = id;
    }

    public Ressource(Integer id, String name, String url, int userId, Date insertDate) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.userId = userId;
        this.insertDate = insertDate;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public Idea getIdeaId() {
        return ideaId;
    }

    public void setIdeaId(Idea ideaId) {
        this.ideaId = ideaId;
    }

    public RessourceProvider getProviderId() {
        return providerId;
    }

    public void setProviderId(RessourceProvider providerId) {
        this.providerId = providerId;
    }

    public RessourceCategory getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(RessourceCategory categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Ressource)) {
            return false;
        }
        Ressource other = (Ressource) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dreamsfactory.entity.Ressource[ id=" + id + " ]";
    }
    
}
