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
@Table(name = "RESSOURCE_CATEGORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RessourceCategory.findAll", query = "SELECT r FROM RessourceCategory r")
    , @NamedQuery(name = "RessourceCategory.findById", query = "SELECT r FROM RessourceCategory r WHERE r.id = :id")
    , @NamedQuery(name = "RessourceCategory.findByName", query = "SELECT r FROM RessourceCategory r WHERE r.name = :name")
    , @NamedQuery(name = "RessourceCategory.findByAvailable", query = "SELECT r FROM RessourceCategory r WHERE r.available = :available")})
public class RessourceCategory implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryId", fetch = FetchType.LAZY)
    private Set<Ressource> ressourceSet;

    public RessourceCategory() {
    }

    public RessourceCategory(Integer id) {
        this.id = id;
    }

    public RessourceCategory(Integer id, String name, boolean available) {
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
    public Set<Ressource> getRessourceSet() {
        return ressourceSet;
    }

    public void setRessourceSet(Set<Ressource> ressourceSet) {
        this.ressourceSet = ressourceSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof RessourceCategory)) {
            return false;
        }
        RessourceCategory other = (RessourceCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dreamsfactory.entity.RessourceCategory[ id=" + id + " ]";
    }
    
}
