package com.dreamsfactory.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.dreamsfactory.entity.IdeaType;

@Stateless
@LocalBean
public class IdeaTypeDAO extends GenericDAO<IdeaType> {

	public IdeaTypeDAO() {
		super(IdeaType.class);
	}

}
