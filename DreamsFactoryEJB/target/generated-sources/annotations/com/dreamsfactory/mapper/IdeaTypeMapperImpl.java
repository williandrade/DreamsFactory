package com.dreamsfactory.mapper;

import com.dreamsfactory.dto.IdeaTypeDTO;

import com.dreamsfactory.entity.IdeaType;

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

public class IdeaTypeMapperImpl implements IdeaTypeMapper {

    @Override

    public IdeaTypeDTO ideaTypeToIdeaTypeDTO(IdeaType ideaType) {

        if ( ideaType == null ) {

            return null;
        }

        IdeaTypeDTO ideaTypeDTO = new IdeaTypeDTO();

        ideaTypeDTO.setId( ideaType.getId() );

        ideaTypeDTO.setName( ideaType.getName() );

        ideaTypeDTO.setAvailable( ideaType.getAvailable() );

        return ideaTypeDTO;
    }

    @Override

    public IdeaType ideaTypeDTOToIdeaType(IdeaTypeDTO ideaTypeDTO) {

        if ( ideaTypeDTO == null ) {

            return null;
        }

        IdeaType ideaType = new IdeaType();

        ideaType.setId( ideaTypeDTO.getId() );

        ideaType.setName( ideaTypeDTO.getName() );

        ideaType.setAvailable( ideaTypeDTO.isAvailable() );

        return ideaType;
    }

    @Override

    public Set<IdeaTypeDTO> ideaTypesToIdeaTypeDTOs(Set<IdeaType> ideaTypes) {

        if ( ideaTypes == null ) {

            return null;
        }

        Set<IdeaTypeDTO> set = new HashSet<IdeaTypeDTO>();

        for ( IdeaType ideaType : ideaTypes ) {

            set.add( ideaTypeToIdeaTypeDTO( ideaType ) );
        }

        return set;
    }

    @Override

    public Set<IdeaType> ideaTypeDTOsToIdeaTypes(Set<IdeaTypeDTO> ideaTypeDTOs) {

        if ( ideaTypeDTOs == null ) {

            return null;
        }

        Set<IdeaType> set = new HashSet<IdeaType>();

        for ( IdeaTypeDTO ideaTypeDTO : ideaTypeDTOs ) {

            set.add( ideaTypeDTOToIdeaType( ideaTypeDTO ) );
        }

        return set;
    }
}

