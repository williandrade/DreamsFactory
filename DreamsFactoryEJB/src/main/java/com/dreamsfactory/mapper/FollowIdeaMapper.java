package com.dreamsfactory.mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.dreamsfactory.dto.FollowIdeaDTO;
import com.dreamsfactory.entity.FollowIdea;

@Mapper(componentModel = "cdi")
public interface FollowIdeaMapper {

	@Mappings({ @Mapping(source = "userId.id", target = "userId"), @Mapping(source = "ideaId.id", target = "ideaId") })
	FollowIdeaDTO followIdeaToFollowIdeaDTO(FollowIdea followIdea);

	@Mappings({ @Mapping(source = "userId", target = "userId.id"), @Mapping(source = "ideaId", target = "ideaId.id") })
	FollowIdea followIdeaDTOToFollowIdea(FollowIdeaDTO followIdeaDTO);

	Set<FollowIdeaDTO> followIdeasToFollowIdeaDTOs(Set<FollowIdea> followIdeas);

	Set<FollowIdea> followIdeaDTOsToFollowIdeas(Set<FollowIdeaDTO> followIdeaDTOs);
}
