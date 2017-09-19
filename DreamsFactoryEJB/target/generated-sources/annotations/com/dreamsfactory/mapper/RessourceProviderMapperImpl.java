package com.dreamsfactory.mapper;

import com.dreamsfactory.dto.RessourceProviderDTO;

import com.dreamsfactory.entity.RessourceProvider;

import java.util.HashSet;

import java.util.Set;

import javax.annotation.Generated;

import javax.enterprise.context.ApplicationScoped;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-09-19T16:48:33-0300",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"

)

@ApplicationScoped

public class RessourceProviderMapperImpl implements RessourceProviderMapper {

    @Override

    public RessourceProviderDTO ressourceProviderToRessourceProviderDTO(RessourceProvider ressourceProvider) {

        if ( ressourceProvider == null ) {

            return null;
        }

        RessourceProviderDTO ressourceProviderDTO = new RessourceProviderDTO();

        ressourceProviderDTO.setId( ressourceProvider.getId() );

        ressourceProviderDTO.setName( ressourceProvider.getName() );

        ressourceProviderDTO.setAvailable( ressourceProvider.getAvailable() );

        return ressourceProviderDTO;
    }

    @Override

    public RessourceProvider ressourceProviderDTOToRessourceProvider(RessourceProviderDTO ressourceProviderDTO) {

        if ( ressourceProviderDTO == null ) {

            return null;
        }

        RessourceProvider ressourceProvider = new RessourceProvider();

        ressourceProvider.setId( ressourceProviderDTO.getId() );

        ressourceProvider.setName( ressourceProviderDTO.getName() );

        ressourceProvider.setAvailable( ressourceProviderDTO.isAvailable() );

        return ressourceProvider;
    }

    @Override

    public Set<RessourceProviderDTO> ressourceProvidersToRessourceProviderDTOs(Set<RessourceProvider> ressourceProviders) {

        if ( ressourceProviders == null ) {

            return null;
        }

        Set<RessourceProviderDTO> set = new HashSet<RessourceProviderDTO>();

        for ( RessourceProvider ressourceProvider : ressourceProviders ) {

            set.add( ressourceProviderToRessourceProviderDTO( ressourceProvider ) );
        }

        return set;
    }

    @Override

    public Set<RessourceProvider> ressourceProviderDTOsToRessourceProviders(Set<RessourceProviderDTO> ressourceProviderDTOs) {

        if ( ressourceProviderDTOs == null ) {

            return null;
        }

        Set<RessourceProvider> set = new HashSet<RessourceProvider>();

        for ( RessourceProviderDTO ressourceProviderDTO : ressourceProviderDTOs ) {

            set.add( ressourceProviderDTOToRessourceProvider( ressourceProviderDTO ) );
        }

        return set;
    }
}

