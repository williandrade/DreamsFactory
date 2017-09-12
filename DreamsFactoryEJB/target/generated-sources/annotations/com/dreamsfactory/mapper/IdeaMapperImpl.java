package com.dreamsfactory.mapper;

import com.dreamsfactory.dto.IdeaDTO;

import com.dreamsfactory.entity.Idea;

import com.dreamsfactory.entity.User;

import java.util.HashSet;

import java.util.Set;

import javax.annotation.Generated;

import javax.enterprise.context.ApplicationScoped;

import javax.inject.Inject;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-09-12T10:33:19-0300",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"

)

@ApplicationScoped

public class IdeaMapperImpl implements IdeaMapper {

    @Inject

    private IdeaTypeMapper ideaTypeMapper;

    @Override

    public IdeaDTO ideaToIdeaDTO(Idea idea) {

        if ( idea == null ) {

            return null;
        }

        IdeaDTO ideaDTO = new IdeaDTO();

        ideaDTO.setUserId( ideaUserIdId( idea ) );

        ideaDTO.setId( idea.getId() );

        ideaDTO.setName( idea.getName() );

        ideaDTO.setShortDescription( idea.getShortDescription() );

        ideaDTO.setDescription( idea.getDescription() );

        ideaDTO.setCreationDate( idea.getCreationDate() );

        ideaDTO.setIdeaType( ideaTypeMapper.ideaTypeToIdeaTypeDTO( idea.getIdeaType() ) );

        return ideaDTO;
    }

    @Override

    public Idea ideaDTOToIdea(IdeaDTO ideaDTO) {

        if ( ideaDTO == null ) {

            return null;
        }

        Idea idea = new Idea();

        User userId = new User();

        idea.setUserId( userId );

        userId.setId( ideaDTO.getUserId() );

        idea.setId( ideaDTO.getId() );

        idea.setName( ideaDTO.getName() );

        idea.setShortDescription( ideaDTO.getShortDescription() );

        idea.setDescription( ideaDTO.getDescription() );

        idea.setCreationDate( ideaDTO.getCreationDate() );

        idea.setIdeaType( ideaTypeMapper.ideaTypeDTOToIdeaType( ideaDTO.getIdeaType() ) );

        return idea;
    }

    @Override

    public Set<IdeaDTO> ideasToIdeaDTOs(Set<Idea> ideas) {

        if ( ideas == null ) {

            return null;
        }

        Set<IdeaDTO> set = new HashSet<IdeaDTO>();

        for ( Idea idea : ideas ) {

            set.add( ideaToIdeaDTO( idea ) );
        }

        return set;
    }

    @Override

    public Set<Idea> ideaDTOsToIdeas(Set<IdeaDTO> ideaDTOs) {

        if ( ideaDTOs == null ) {

            return null;
        }

        Set<Idea> set = new HashSet<Idea>();

        for ( IdeaDTO ideaDTO : ideaDTOs ) {

            set.add( ideaDTOToIdea( ideaDTO ) );
        }

        return set;
    }

    private Integer ideaUserIdId(Idea idea) {

        if ( idea == null ) {

            return null;
        }

        User userId = idea.getUserId();

        if ( userId == null ) {

            return null;
        }

        Integer id = userId.getId();

        if ( id == null ) {

            return null;
        }

        return id;
    }
}

