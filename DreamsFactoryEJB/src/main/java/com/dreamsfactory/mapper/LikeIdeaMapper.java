package com.dreamsfactory.mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.dreamsfactory.dto.LikeIdeaDTO;
import com.dreamsfactory.entity.LikeIdea;

@Mapper(componentModel = "cdi")
public interface LikeIdeaMapper {

	@Mappings({ @Mapping(source = "userId.id", target = "userId"), @Mapping(source = "ideaId.id", target = "ideaId") })
	LikeIdeaDTO likeIdeaToLikeIdeaDTO(LikeIdea likeIdea);

	@Mappings({ @Mapping(source = "userId", target = "userId.id"), @Mapping(source = "ideaId", target = "ideaId.id") })
	LikeIdea likeIdeaDTOToLikeIdea(LikeIdeaDTO likeIdeaDTO);

	Set<LikeIdeaDTO> likeIdeasToLikeIdeaDTOs(Set<LikeIdea> likeIdeas);

	Set<LikeIdea> likeIdeaDTOsToLikeIdeas(Set<LikeIdeaDTO> likeIdeaDTOs);
}
