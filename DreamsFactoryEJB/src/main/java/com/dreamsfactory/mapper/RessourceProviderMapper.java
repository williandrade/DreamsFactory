package com.dreamsfactory.mapper;

import java.util.Set;

import org.mapstruct.Mapper;

import com.dreamsfactory.dto.RessourceProviderDTO;
import com.dreamsfactory.entity.RessourceProvider;

@Mapper(componentModel = "cdi")
public interface RessourceProviderMapper {

	RessourceProviderDTO ressourceProviderToRessourceProviderDTO(RessourceProvider ressourceProvider);

	RessourceProvider ressourceProviderDTOToRessourceProvider(RessourceProviderDTO ressourceProviderDTO);

	Set<RessourceProviderDTO> ressourceProvidersToRessourceProviderDTOs(Set<RessourceProvider> ressourceProviders);

	Set<RessourceProvider> ressourceProviderDTOsToRessourceProviders(Set<RessourceProviderDTO> ressourceProviderDTOs);
}