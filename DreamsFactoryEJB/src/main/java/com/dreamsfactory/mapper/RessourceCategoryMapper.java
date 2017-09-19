package com.dreamsfactory.mapper;

import java.util.Set;

import org.mapstruct.Mapper;

import com.dreamsfactory.dto.RessourceCategoryDTO;
import com.dreamsfactory.entity.RessourceCategory;


@Mapper(componentModel = "cdi")
public interface RessourceCategoryMapper {

	RessourceCategoryDTO ressourceCategoryToRessourceCategoryDTO(RessourceCategory ressourceCategory);

	RessourceCategory ressourceCategoryDTOToRessourceCategory(RessourceCategoryDTO ressourceCategoryDTO);

	Set<RessourceCategoryDTO> ressourceCategorysToRessourceCategoryDTOs(Set<RessourceCategory> ressourceCategorys);

	Set<RessourceCategory> ressourceCategoryDTOsToRessourceCategorys(Set<RessourceCategoryDTO> ressourceCategoryDTOs);

}
