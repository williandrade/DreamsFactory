package com.dreamsfactory.mapper;

import com.dreamsfactory.dto.RessourceCategoryDTO;

import com.dreamsfactory.entity.RessourceCategory;

import java.util.HashSet;

import java.util.Set;

import javax.annotation.Generated;

import javax.enterprise.context.ApplicationScoped;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-09-19T15:32:22-0300",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"

)

@ApplicationScoped

public class RessourceCategoryMapperImpl implements RessourceCategoryMapper {

    @Override

    public RessourceCategoryDTO ressourceCategoryToRessourceCategoryDTO(RessourceCategory ressourceCategory) {

        if ( ressourceCategory == null ) {

            return null;
        }

        RessourceCategoryDTO ressourceCategoryDTO = new RessourceCategoryDTO();

        ressourceCategoryDTO.setId( ressourceCategory.getId() );

        ressourceCategoryDTO.setName( ressourceCategory.getName() );

        ressourceCategoryDTO.setAvailable( ressourceCategory.getAvailable() );

        return ressourceCategoryDTO;
    }

    @Override

    public RessourceCategory ressourceCategoryDTOToRessourceCategory(RessourceCategoryDTO ressourceCategoryDTO) {

        if ( ressourceCategoryDTO == null ) {

            return null;
        }

        RessourceCategory ressourceCategory = new RessourceCategory();

        ressourceCategory.setId( ressourceCategoryDTO.getId() );

        ressourceCategory.setName( ressourceCategoryDTO.getName() );

        ressourceCategory.setAvailable( ressourceCategoryDTO.isAvailable() );

        return ressourceCategory;
    }

    @Override

    public Set<RessourceCategoryDTO> ressourceCategorysToRessourceCategoryDTOs(Set<RessourceCategory> ressourceCategorys) {

        if ( ressourceCategorys == null ) {

            return null;
        }

        Set<RessourceCategoryDTO> set = new HashSet<RessourceCategoryDTO>();

        for ( RessourceCategory ressourceCategory : ressourceCategorys ) {

            set.add( ressourceCategoryToRessourceCategoryDTO( ressourceCategory ) );
        }

        return set;
    }

    @Override

    public Set<RessourceCategory> ressourceCategoryDTOsToRessourceCategorys(Set<RessourceCategoryDTO> ressourceCategoryDTOs) {

        if ( ressourceCategoryDTOs == null ) {

            return null;
        }

        Set<RessourceCategory> set = new HashSet<RessourceCategory>();

        for ( RessourceCategoryDTO ressourceCategoryDTO : ressourceCategoryDTOs ) {

            set.add( ressourceCategoryDTOToRessourceCategory( ressourceCategoryDTO ) );
        }

        return set;
    }
}

