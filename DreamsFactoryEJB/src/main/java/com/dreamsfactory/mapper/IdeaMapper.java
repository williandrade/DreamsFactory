package com.dreamsfactory.mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.dreamsfactory.dto.IdeaDTO;
import com.dreamsfactory.entity.Idea;

@Mapper(componentModel = "cdi", uses = { IdeaTypeMapper.class })
public interface IdeaMapper {

	@Mappings({ @Mapping(source = "userId.id", target = "userId") })
	IdeaDTO ideaToIdeaDTO(Idea idea);

	@Mappings({ @Mapping(source = "userId", target = "userId.id") })
	Idea ideaDTOToIdea(IdeaDTO ideaDTO);

	Set<IdeaDTO> ideasToIdeaDTOs(Set<Idea> ideas);

	Set<Idea> ideaDTOsToIdeas(Set<IdeaDTO> ideaDTOs);
}
