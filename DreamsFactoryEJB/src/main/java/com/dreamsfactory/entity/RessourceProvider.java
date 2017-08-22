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
@Table(name = "RESSOURCE_PROVIDER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RessourceProvider.findAll", query = "SELECT r FROM RessourceProvider r")
    , @NamedQuery(name = "RessourceProvider.findById", query = "SELECT r FROM RessourceProvider r WHERE r.id = :id")
    , @NamedQuery(name = "RessourceProvider.findByName", query = "SELECT r FROM RessourceProvider r WHERE r.name = :name")
    , @NamedQuery(name = "RessourceProvider.findByAvailable", query = "SELECT r FROM RessourceProvider r WHERE r.available = :available")})
public class RessourceProvider implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "providerId", fetch = FetchType.LAZY)
    private Set<Ressource> ressourceSet;

    public RessourceProvider() {
    }

    public RessourceProvider(Integer id) {
        this.id = id;
    }

    public RessourceProvider(Integer id, String name, boolean available) {
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RessourceProvider)) {
            return false;
        }
        RessourceProvider other = (RessourceProvider) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dreamsfactory.entity.RessourceProvider[ id=" + id + " ]";
    }
    
}
