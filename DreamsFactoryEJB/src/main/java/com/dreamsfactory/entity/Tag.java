/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dreamsfactory.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author william
 */
@Entity
@Table(name = "TAG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tag.findAll", query = "SELECT t FROM Tag t")
    , @NamedQuery(name = "Tag.findById", query = "SELECT t FROM Tag t WHERE t.id = :id")
    , @NamedQuery(name = "Tag.findByName", query = "SELECT t FROM Tag t WHERE t.name = :name")
    , @NamedQuery(name = "Tag.findByAvailable", query = "SELECT t FROM Tag t WHERE t.available = :available")})
public class Tag implements Serializable {

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
    private boolean available;
    @ManyToMany(mappedBy = "tagSet", fetch = FetchType.LAZY)
    private Set<Idea> ideaSet;

    public Tag() {
    }

    public Tag(Integer id) {
        this.id = id;
    }

    public Tag(Integer id, String name, boolean available) {
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

    public boolean getAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @XmlTransient
    public Set<Idea> getIdeaSet() {
        return ideaSet;
    }

    public void setIdeaSet(Set<Idea> ideaSet) {
        this.ideaSet = ideaSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Tag)) {
            return false;
        }
        Tag other = (Tag) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dreamsfactory.entity.Tag[ id=" + id + " ]";
    }
    
}
