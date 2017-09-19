package com.dreamsfactory.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.dreamsfactory.entity.RessourceCategory;

@Stateless
@LocalBean
public class RessourceCategoryDAO extends GenericDAO<RessourceCategory> {

	public RessourceCategoryDAO() {
		super(RessourceCategory.class);
	}

}
