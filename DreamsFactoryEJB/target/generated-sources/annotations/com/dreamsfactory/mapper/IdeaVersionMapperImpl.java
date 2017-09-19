package com.dreamsfactory.mapper;

import com.dreamsfactory.dto.IdeaVersionDTO;

import com.dreamsfactory.entity.Idea;

import com.dreamsfactory.entity.IdeaVersion;

import java.util.HashSet;

import java.util.Set;

import javax.annotation.Generated;

import javax.enterprise.context.ApplicationScoped;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-09-19T09:19:05-0300",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"

)

@ApplicationScoped

public class IdeaVersionMapperImpl implements IdeaVersionMapper {

    @Override

    public IdeaVersionDTO ideaVersionToIdeaVersionDTO(IdeaVersion ideaVersion) {

        if ( ideaVersion == null ) {

            return null;
        }

        IdeaVersionDTO ideaVersionDTO = new IdeaVersionDTO();

        ideaVersionDTO.setIdeaId( ideaVersionIdeaIdId( ideaVersion ) );

        ideaVersionDTO.setId( ideaVersion.getId() );

        ideaVersionDTO.setName( ideaVersion.getName() );

        ideaVersionDTO.setShortDescription( ideaVersion.getShortDescription() );

        ideaVersionDTO.setDescription( ideaVersion.getDescription() );

        ideaVersionDTO.setCreationDate( ideaVersion.getCreationDate() );

        ideaVersionDTO.setIdeaTypeId( ideaVersion.getIdeaTypeId() );

        ideaVersionDTO.setUserId( ideaVersion.getUserId() );

        ideaVersionDTO.setChangeDate( ideaVersion.getChangeDate() );

        ideaVersionDTO.setApproved( ideaVersion.isApproved() );

        return ideaVersionDTO;
    }

    @Override

    public IdeaVersion ideaVersionDTOToIdeaVersion(IdeaVersionDTO ideaVersionDTO) {

        if ( ideaVersionDTO == null ) {

            return null;
        }

        IdeaVersion ideaVersion = new IdeaVersion();

        Idea ideaId = new Idea();

        ideaVersion.setIdeaId( ideaId );

        ideaId.setId( ideaVersionDTO.getIdeaId() );

        ideaVersion.setId( ideaVersionDTO.getId() );

        ideaVersion.setName( ideaVersionDTO.getName() );

        ideaVersion.setShortDescription( ideaVersionDTO.getShortDescription() );

        ideaVersion.setDescription( ideaVersionDTO.getDescription() );

        ideaVersion.setCreationDate( ideaVersionDTO.getCreationDate() );

        ideaVersion.setIdeaTypeId( ideaVersionDTO.getIdeaTypeId() );

        ideaVersion.setUserId( ideaVersionDTO.getUserId() );

        ideaVersion.setChangeDate( ideaVersionDTO.getChangeDate() );

        if ( ideaVersionDTO.getApproved() != null ) {

            ideaVersion.setApproved( ideaVersionDTO.getApproved() );
        }

        return ideaVersion;
    }

    @Override

    public Set<IdeaVersionDTO> ideaVersionToIdeaVersionDTOs(Set<IdeaVersion> ideaVersions) {

        if ( ideaVersions == null ) {

            return null;
        }

        Set<IdeaVersionDTO> set = new HashSet<IdeaVersionDTO>();

        for ( IdeaVersion ideaVersion : ideaVersions ) {

            set.add( ideaVersionToIdeaVersionDTO( ideaVersion ) );
        }

        return set;
    }

    @Override

    public Set<IdeaVersion> ideaVersionDTOsToIdeaVersions(Set<IdeaVersionDTO> ideaVersionDTOs) {

        if ( ideaVersionDTOs == null ) {

            return null;
        }

        Set<IdeaVersion> set = new HashSet<IdeaVersion>();

        for ( IdeaVersionDTO ideaVersionDTO : ideaVersionDTOs ) {

            set.add( ideaVersionDTOToIdeaVersion( ideaVersionDTO ) );
        }

        return set;
    }

    private Integer ideaVersionIdeaIdId(IdeaVersion ideaVersion) {

        if ( ideaVersion == null ) {

            return null;
        }

        Idea ideaId = ideaVersion.getIdeaId();

        if ( ideaId == null ) {

            return null;
        }

        Integer id = ideaId.getId();

        if ( id == null ) {

            return null;
        }

        return id;
    }
}

