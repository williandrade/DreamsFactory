package com.dreamsfactory.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.dreamsfactory.entity.Idea;

@Stateless
@LocalBean
public class IdeaDAO extends GenericDAO<Idea> {

	public IdeaDAO() {
		super(Idea.class);
	}

}
