package com.dreamsfactory.mapper;

import com.dreamsfactory.dto.TagDTO;

import com.dreamsfactory.entity.Tag;

import java.util.HashSet;

import java.util.Set;

import javax.annotation.Generated;

import javax.enterprise.context.ApplicationScoped;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-09-19T12:36:25-0300",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"

)

@ApplicationScoped

public class TagMapperImpl implements TagMapper {

    @Override

    public TagDTO tagToTagDTO(Tag tag) {

        if ( tag == null ) {

            return null;
        }

        TagDTO tagDTO = new TagDTO();

        tagDTO.setId( tag.getId() );

        tagDTO.setName( tag.getName() );

        tagDTO.setAvailable( tag.getAvailable() );

        return tagDTO;
    }

    @Override

    public Tag tagDTOToTag(TagDTO tagDTO) {

        if ( tagDTO == null ) {

            return null;
        }

        Tag tag = new Tag();

        tag.setId( tagDTO.getId() );

        tag.setName( tagDTO.getName() );

        tag.setAvailable( tagDTO.isAvailable() );

        return tag;
    }

    @Override

    public Set<TagDTO> tagsToTagDTOs(Set<Tag> tags) {

        if ( tags == null ) {

            return null;
        }

        Set<TagDTO> set = new HashSet<TagDTO>();

        for ( Tag tag : tags ) {

            set.add( tagToTagDTO( tag ) );
        }

        return set;
    }

    @Override

    public Set<Tag> tagDTOsToTags(Set<TagDTO> tagDTOs) {

        if ( tagDTOs == null ) {

            return null;
        }

        Set<Tag> set = new HashSet<Tag>();

        for ( TagDTO tagDTO : tagDTOs ) {

            set.add( tagDTOToTag( tagDTO ) );
        }

        return set;
    }
}

