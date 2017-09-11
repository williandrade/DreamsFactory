/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dreamsfactory.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author william
 */
@Entity
@Table(name = "APPLICATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Application.findAll", query = "SELECT a FROM Application a")
    , @NamedQuery(name = "Application.findById", query = "SELECT a FROM Application a WHERE a.id = :id")
    , @NamedQuery(name = "Application.findByName", query = "SELECT a FROM Application a WHERE a.name = :name")
    , @NamedQuery(name = "Application.findByApplicationKey", query = "SELECT a FROM Application a WHERE a.applicationKey = :applicationKey")})
public class Application implements Serializable {

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
    @Column(name = "APPLICATION_KEY")
    private String applicationKey;

    public Application() {
    }

    public Application(Integer id) {
        this.id = id;
    }

    public Application(Integer id, String name, String applicationKey) {
        this.id = id;
        this.name = name;
        this.applicationKey = applicationKey;
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

    public String getApplicationKey() {
        return applicationKey;
    }

    public void setApplicationKey(String applicationKey) {
        this.applicationKey = applicationKey;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Application)) {
            return false;
        }
        Application other = (Application) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dreamsfactory.entity.Application[ id=" + id + " ]";
    }
    
}
