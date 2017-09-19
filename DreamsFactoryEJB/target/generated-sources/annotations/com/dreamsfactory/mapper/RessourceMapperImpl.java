package com.dreamsfactory.mapper;

import com.dreamsfactory.dto.RessourceCategoryDTO;

import com.dreamsfactory.dto.RessourceDTO;

import com.dreamsfactory.entity.Idea;

import com.dreamsfactory.entity.Ressource;

import com.dreamsfactory.entity.RessourceCategory;

import com.dreamsfactory.entity.User;

import java.util.HashSet;

import java.util.Set;

import javax.annotation.Generated;

import javax.enterprise.context.ApplicationScoped;

import javax.inject.Inject;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-09-19T16:48:33-0300",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"

)

@ApplicationScoped

public class RessourceMapperImpl implements RessourceMapper {

    @Inject

    private RessourceCategoryMapper ressourceCategoryMapper;

    @Inject

    private RessourceProviderMapper ressourceProviderMapper;

    @Override

    public RessourceDTO ressourceToRessourceDTO(Ressource ressource) {

        if ( ressource == null ) {

            return null;
        }

        RessourceDTO ressourceDTO = new RessourceDTO();

        ressourceDTO.setUserId( ressourceUserIdId( ressource ) );

        ressourceDTO.setIdeaId( ressourceIdeaIdId( ressource ) );

        ressourceDTO.setId( ressource.getId() );

        ressourceDTO.setName( ressource.getName() );

        ressourceDTO.setUrl( ressource.getUrl() );

        ressourceDTO.setInsertDate( ressource.getInsertDate() );

        ressourceDTO.setProviderId( ressourceProviderMapper.ressourceProviderToRessourceProviderDTO( ressource.getProviderId() ) );

        Set<RessourceCategoryDTO> set = ressourceCategoryMapper.ressourceCategorysToRessourceCategoryDTOs( ressource.getCategorySet() );

        if ( set != null ) {

            ressourceDTO.setCategorySet( set );
        }

        return ressourceDTO;
    }

    @Override

    public Ressource ressourceDTOToRessource(RessourceDTO ressourceDTO) {

        if ( ressourceDTO == null ) {

            return null;
        }

        Ressource ressource = new Ressource();

        User userId = new User();

        Idea ideaId = new Idea();

        ressource.setUserId( userId );

        ressource.setIdeaId( ideaId );

        userId.setId( ressourceDTO.getUserId() );

        ideaId.setId( ressourceDTO.getIdeaId() );

        ressource.setId( ressourceDTO.getId() );

        ressource.setName( ressourceDTO.getName() );

        ressource.setUrl( ressourceDTO.getUrl() );

        ressource.setInsertDate( ressourceDTO.getInsertDate() );

        ressource.setProviderId( ressourceProviderMapper.ressourceProviderDTOToRessourceProvider( ressourceDTO.getProviderId() ) );

        Set<RessourceCategory> set = ressourceCategoryMapper.ressourceCategoryDTOsToRessourceCategorys( ressourceDTO.getCategorySet() );

        if ( set != null ) {

            ressource.setCategorySet( set );
        }

        return ressource;
    }

    @Override

    public Set<RessourceDTO> ressourcesToRessourceDTOs(Set<Ressource> ressources) {

        if ( ressources == null ) {

            return null;
        }

        Set<RessourceDTO> set = new HashSet<RessourceDTO>();

        for ( Ressource ressource : ressources ) {

            set.add( ressourceToRessourceDTO( ressource ) );
        }

        return set;
    }

    @Override

    public Set<Ressource> ressourceDTOsToRessources(Set<RessourceDTO> ressourceDTOs) {

        if ( ressourceDTOs == null ) {

            return null;
        }

        Set<Ressource> set = new HashSet<Ressource>();

        for ( RessourceDTO ressourceDTO : ressourceDTOs ) {

            set.add( ressourceDTOToRessource( ressourceDTO ) );
        }

        return set;
    }

    private Integer ressourceUserIdId(Ressource ressource) {

        if ( ressource == null ) {

            return null;
        }

        User userId = ressource.getUserId();

        if ( userId == null ) {

            return null;
        }

        Integer id = userId.getId();

        if ( id == null ) {

            return null;
        }

        return id;
    }

    private Integer ressourceIdeaIdId(Ressource ressource) {

        if ( ressource == null ) {

            return null;
        }

        Idea ideaId = ressource.getIdeaId();

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

