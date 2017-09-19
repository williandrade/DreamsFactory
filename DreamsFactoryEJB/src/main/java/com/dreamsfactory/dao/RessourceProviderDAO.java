package com.dreamsfactory.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.dreamsfactory.entity.RessourceProvider;

@Stateless
@LocalBean
public class RessourceProviderDAO extends GenericDAO<RessourceProvider> {

	public RessourceProviderDAO() {
		super(RessourceProvider.class);
	}

}
