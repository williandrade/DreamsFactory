package com.dreamsfactory.mapper;

import java.util.Set;

import org.mapstruct.Mapper;

import com.dreamsfactory.dto.TagDTO;
import com.dreamsfactory.entity.Tag;

@Mapper(componentModel = "cdi")
public interface TagMapper {

	TagDTO tagToTagDTO(Tag tag);

	Tag tagDTOToTag(TagDTO tagDTO);

	Set<TagDTO> tagsToTagDTOs(Set<Tag> tags);

	Set<Tag> tagDTOsToTags(Set<TagDTO> tagDTOs);
}
