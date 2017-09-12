package com.dreamsfactory.mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.dreamsfactory.dto.LogIdeaDTO;
import com.dreamsfactory.entity.LogIdea;

@Mapper(componentModel = "cdi")
public interface LogIdeaMapper {

	@Mappings({ @Mapping(source = "userId.id", target = "userId"), @Mapping(source = "ideaId.id", target = "ideaId") })
	LogIdeaDTO logIdeaToLogIdeaDTO(LogIdea logIdea);

	@Mappings({ @Mapping(source = "userId", target = "userId.id"), @Mapping(source = "ideaId", target = "ideaId.id") })
	LogIdea logIdeaDTOToLogIdea(LogIdeaDTO logIdeaDTO);

	Set<LogIdeaDTO> logIdeasToLogIdeaDTOs(Set<LogIdea> logIdeas);

	Set<LogIdea> logIdeaDTOsToLogIdeas(Set<LogIdeaDTO> logIdeaDTOs);
}
