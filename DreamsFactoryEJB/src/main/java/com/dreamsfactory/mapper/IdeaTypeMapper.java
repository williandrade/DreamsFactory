package com.dreamsfactory.mapper;

import java.util.Set;

import org.mapstruct.Mapper;

import com.dreamsfactory.dto.IdeaTypeDTO;
import com.dreamsfactory.entity.IdeaType;

@Mapper(componentModel = "cdi")
public interface IdeaTypeMapper {

	IdeaTypeDTO ideaTypeToIdeaTypeDTO(IdeaType ideaType);

	IdeaType ideaTypeDTOToIdeaType(IdeaTypeDTO ideaTypeDTO);

	Set<IdeaTypeDTO> ideaTypesToIdeaTypeDTOs(Set<IdeaType> ideaTypes);

	Set<IdeaType> ideaTypeDTOsToIdeaTypes(Set<IdeaTypeDTO> ideaTypeDTOs);
}
