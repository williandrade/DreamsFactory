package com.dreamsfactory.session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import com.dreamsfactory.dao.RessourceDAO;
import com.dreamsfactory.dto.RessourceDTO;
import com.dreamsfactory.entity.Ressource;
import com.dreamsfactory.exception.ArgumentMissingException;
import com.dreamsfactory.mapper.RessourceMapper;

@Stateless
@LocalBean
public class RessourceSession {

	@EJB
	private RessourceDAO ressourceDAO;

	@Inject
	private RessourceMapper ressourceMapper;

	public RessourceDTO create(RessourceDTO ressourceDTO) throws Exception {
		ressourceDTO.setInsertDate(new Date());

		Ressource ressource = ressourceMapper.ressourceDTOToRessource(ressourceDTO);
		ressource = ressourceDAO.insert(ressource);
		ressourceDTO = ressourceMapper.ressourceToRessourceDTO(ressource);
		return ressourceDTO;
	}

	public RessourceDTO findRessourceById(Integer id) throws Exception {
		if (id == null) {
			throw new ArgumentMissingException("Id");
		}
		Ressource ressource = ressourceDAO.findById(id);
		return ressourceMapper.ressourceToRessourceDTO(ressource);
	}

	public List<RessourceDTO> findByIdea(Integer ideaId) throws Exception {
		if (ideaId == null) {
			throw new ArgumentMissingException("ideaId");
		}
		Set<Ressource> ressources = ressourceDAO.findByIdeaId(ideaId);
		List<RessourceDTO> result = new ArrayList<>(ressourceMapper.ressourcesToRessourceDTOs(ressources));
		return result;
	}

	public List<RessourceDTO> findByUser(Integer userId) throws Exception {
		if (userId == null) {
			throw new ArgumentMissingException("userId");
		}
		Set<Ressource> ressources = ressourceDAO.findByUserId(userId);
		List<RessourceDTO> result = new ArrayList<>(ressourceMapper.ressourcesToRessourceDTOs(ressources));
		return result;
	}

}
