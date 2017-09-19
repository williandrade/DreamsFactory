package com.dreamsfactory.mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.dreamsfactory.dto.RessourceDTO;
import com.dreamsfactory.entity.Ressource;

@Mapper(componentModel = "cdi", uses = { RessourceCategoryMapper.class, RessourceProviderMapper.class })
public interface RessourceMapper {

	@Mappings({ @Mapping(source = "userId.id", target = "userId"), @Mapping(source = "ideaId.id", target = "ideaId") })
	RessourceDTO ressourceToRessourceDTO(Ressource ressource);

	@Mappings({ @Mapping(source = "userId", target = "userId.id"), @Mapping(source = "ideaId", target = "ideaId.id") })
	Ressource ressourceDTOToRessource(RessourceDTO ressourceDTO);

	Set<RessourceDTO> ressourcesToRessourceDTOs(Set<Ressource> ressources);

	Set<Ressource> ressourceDTOsToRessources(Set<RessourceDTO> ressourceDTOs);
}
