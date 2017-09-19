package com.dreamsfactory.session;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.dreamsfactory.dao.RessourceProviderDAO;
import com.dreamsfactory.dto.RessourceProviderDTO;
import com.dreamsfactory.entity.RessourceProvider;
import com.dreamsfactory.mapper.RessourceProviderMapper;

@Stateless
@LocalBean
public class RessourceProviderSession {

	@EJB
	private RessourceProviderDAO ressourceProviderDAO;

	@Inject
	private RessourceProviderMapper ressourceProviderMapper;

	public List<RessourceProviderDTO> findAll() {
		Set<RessourceProvider> fromDb = ressourceProviderDAO.findAll();
		List<RessourceProviderDTO> result = new ArrayList<>(
				ressourceProviderMapper.ressourceProvidersToRessourceProviderDTOs(fromDb));

		result.sort((r1, r2) -> r1.getName().compareTo(r2.getName()));

		return result;
	}
}
