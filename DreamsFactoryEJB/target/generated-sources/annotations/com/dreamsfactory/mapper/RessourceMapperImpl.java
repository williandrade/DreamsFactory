package com.dreamsfactory.mapper;

import com.dreamsfactory.dto.RessourceDTO;
import com.dreamsfactory.entity.Idea;
import com.dreamsfactory.entity.Ressource;
import com.dreamsfactory.entity.User;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-07-16T22:46:02-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"
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

        Integer id = ressourceUserIdId( ressource );
        if ( id != null ) {
            ressourceDTO.setUserId( id );
        }
        Integer id1 = ressourceIdeaIdId( ressource );
        if ( id1 != null ) {
            ressourceDTO.setIdeaId( id1 );
        }
        ressourceDTO.setId( ressource.getId() );
        ressourceDTO.setName( ressource.getName() );
        ressourceDTO.setUrl( ressource.getUrl() );
        ressourceDTO.setInsertDate( ressource.getInsertDate() );
        ressourceDTO.setProviderId( ressourceProviderMapper.ressourceProviderToRessourceProviderDTO( ressource.getProviderId() ) );
        ressourceDTO.setCategorySet( ressourceCategoryMapper.ressourceCategorysToRessourceCategoryDTOs( ressource.getCategorySet() ) );

        return ressourceDTO;
    }

    @Override
    public Ressource ressourceDTOToRessource(RessourceDTO ressourceDTO) {
        if ( ressourceDTO == null ) {
            return null;
        }

        Ressource ressource = new Ressource();

        ressource.setUserId( ressourceDTOToUser( ressourceDTO ) );
        ressource.setIdeaId( ressourceDTOToIdea( ressourceDTO ) );
        ressource.setId( ressourceDTO.getId() );
        ressource.setName( ressourceDTO.getName() );
        ressource.setUrl( ressourceDTO.getUrl() );
        ressource.setInsertDate( ressourceDTO.getInsertDate() );
        ressource.setProviderId( ressourceProviderMapper.ressourceProviderDTOToRessourceProvider( ressourceDTO.getProviderId() ) );
        ressource.setCategorySet( ressourceCategoryMapper.ressourceCategoryDTOsToRessourceCategorys( ressourceDTO.getCategorySet() ) );

        return ressource;
    }

    @Override
    public Set<RessourceDTO> ressourcesToRessourceDTOs(Set<Ressource> ressources) {
        if ( ressources == null ) {
            return null;
        }

        Set<RessourceDTO> set = new HashSet<RessourceDTO>( Math.max( (int) ( ressources.size() / .75f ) + 1, 16 ) );
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

        Set<Ressource> set = new HashSet<Ressource>( Math.max( (int) ( ressourceDTOs.size() / .75f ) + 1, 16 ) );
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

    protected User ressourceDTOToUser(RessourceDTO ressourceDTO) {
        if ( ressourceDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( ressourceDTO.getUserId() );

        return user;
    }

    protected Idea ressourceDTOToIdea(RessourceDTO ressourceDTO) {
        if ( ressourceDTO == null ) {
            return null;
        }

        Idea idea = new Idea();

        idea.setId( ressourceDTO.getIdeaId() );

        return idea;
    }
}
