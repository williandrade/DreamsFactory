/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dreamsfactory.entity;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author william
 */
@Entity
@Table(name = "SUBSCRIBE_LEVEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SubscribeLevel.findAll", query = "SELECT s FROM SubscribeLevel s")
    , @NamedQuery(name = "SubscribeLevel.findById", query = "SELECT s FROM SubscribeLevel s WHERE s.id = :id")
    , @NamedQuery(name = "SubscribeLevel.findByName", query = "SELECT s FROM SubscribeLevel s WHERE s.name = :name")
    , @NamedQuery(name = "SubscribeLevel.findByAvailable", query = "SELECT s FROM SubscribeLevel s WHERE s.available = :available")})
public class SubscribeLevel implements Serializable {

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
    @Column(name = "AVAILABLE")
    private int available;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subscribeLevelId", fetch = FetchType.LAZY)
    private Set<SubscribeIdea> subscribeIdeaSet;

    public SubscribeLevel() {
    }

    public SubscribeLevel(Integer id) {
        this.id = id;
    }

    public SubscribeLevel(Integer id, String name, int available) {
        this.id = id;
        this.name = name;
        this.available = available;
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

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    @XmlTransient
    public Set<SubscribeIdea> getSubscribeIdeaSet() {
        return subscribeIdeaSet;
    }

    public void setSubscribeIdeaSet(Set<SubscribeIdea> subscribeIdeaSet) {
        this.subscribeIdeaSet = subscribeIdeaSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof SubscribeLevel)) {
            return false;
        }
        SubscribeLevel other = (SubscribeLevel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dreamsfactory.entity.SubscribeLevel[ id=" + id + " ]";
    }
    
}
