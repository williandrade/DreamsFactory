package com.dreamsfactory.session;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.dreamsfactory.dao.RessourceCategoryDAO;
import com.dreamsfactory.dto.RessourceCategoryDTO;
import com.dreamsfactory.entity.RessourceCategory;
import com.dreamsfactory.mapper.RessourceCategoryMapper;

@Stateless
@LocalBean
public class RessourceCategorySession {

	@EJB
	private RessourceCategoryDAO ressourceCategoryDAO;

	@Inject
	private RessourceCategoryMapper ressourceCategoryMapper;

	public List<RessourceCategoryDTO> findAll() {
		Set<RessourceCategory> onDb = ressourceCategoryDAO.findAll();
		List<RessourceCategoryDTO> result = new ArrayList<>(
				ressourceCategoryMapper.ressourceCategorysToRessourceCategoryDTOs(onDb));

		result.sort((r1, r2) -> r1.getName().compareTo(r2.getName()));

		return result;
	}

}
