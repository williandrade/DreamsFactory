package com.dreamsfactory.mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.dreamsfactory.dto.IdeaVersionDTO;
import com.dreamsfactory.entity.IdeaVersion;

@Mapper(componentModel = "cdi")
public interface IdeaVersionMapper {

	@Mappings({ @Mapping(source = "ideaId.id", target = "ideaId") })
	IdeaVersionDTO ideaVersionToIdeaVersionDTO(IdeaVersion ideaVersion);

	@Mappings({ @Mapping(source = "ideaId", target = "ideaId.id") })
	IdeaVersion ideaVersionDTOToIdeaVersion(IdeaVersionDTO ideaVersionDTO);

	Set<IdeaVersionDTO> ideaVersionToIdeaVersionDTOs(Set<IdeaVersion> ideaVersions);

	Set<IdeaVersion> ideaVersionDTOsToIdeaVersions(Set<IdeaVersionDTO> ideaVersionDTOs);

}
