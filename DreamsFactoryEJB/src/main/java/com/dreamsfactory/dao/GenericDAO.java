/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dreamsfactory.dao;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author williamandrade
 */
public class GenericDAO<T> {

	/**
	 * Entity Manager Principal.
	 */
	@PersistenceContext(unitName = "DreamsFactory-PU")
	private EntityManager em;

	protected Class<T> entityClass;

	public GenericDAO(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public T insert(T entity) {
		this.getEm().persist(entity);
		this.getEm().flush();

		return entity;
	}

	public T update(T entity) {
		T t = this.getEm().merge(entity);
		this.getEm().flush();
		return t;
	}

	public void delete(T id) {
		T entityExcluir = this.getEm().merge(id);
		this.getEm().remove(entityExcluir);
		this.getEm().flush();
	}

	public void delete(Integer id) {
		T entityExcluir = this.getEm().find(entityClass, id);
		this.getEm().remove(entityExcluir);
		this.getEm().flush();
	}

	public Set<T> findAll() {
		CriteriaBuilder cb = this.getEm().getCriteriaBuilder();
		CriteriaQuery cq = cb.createQuery();
		cq.select(cq.from(entityClass));
		return new HashSet<>(this.getEm().createQuery(cq).getResultList());
	}

	public T detach(T entity) {
		this.getEm().detach(entity);
		return entity;
	}

	public T findById(Integer id) {
		return this.getEm().find(entityClass, id);
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public void cleanEm() {
		this.getEm().clear();
	}

	public EntityManager getEm() {
		return em;
	}

}
