package com.dreamsfactory.mapper;

import com.dreamsfactory.dto.LikeIdeaDTO;
import com.dreamsfactory.entity.Idea;
import com.dreamsfactory.entity.LikeIdea;
import com.dreamsfactory.entity.User;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import javax.enterprise.context.ApplicationScoped;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2018-07-16T22:46:02-0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"
)
@ApplicationScoped
public class LikeIdeaMapperImpl implements LikeIdeaMapper {

    @Override
    public LikeIdeaDTO likeIdeaToLikeIdeaDTO(LikeIdea likeIdea) {
        if ( likeIdea == null ) {
            return null;
        }

        LikeIdeaDTO likeIdeaDTO = new LikeIdeaDTO();

        Integer id = likeIdeaUserIdId( likeIdea );
        if ( id != null ) {
            likeIdeaDTO.setUserId( id );
        }
        Integer id1 = likeIdeaIdeaIdId( likeIdea );
        if ( id1 != null ) {
            likeIdeaDTO.setIdeaId( id1 );
        }
        likeIdeaDTO.setId( likeIdea.getId() );
        likeIdeaDTO.setLikeDate( likeIdea.getLikeDate() );

        return likeIdeaDTO;
    }

    @Override
    public LikeIdea likeIdeaDTOToLikeIdea(LikeIdeaDTO likeIdeaDTO) {
        if ( likeIdeaDTO == null ) {
            return null;
        }

        LikeIdea likeIdea = new LikeIdea();

        likeIdea.setUserId( likeIdeaDTOToUser( likeIdeaDTO ) );
        likeIdea.setIdeaId( likeIdeaDTOToIdea( likeIdeaDTO ) );
        likeIdea.setId( likeIdeaDTO.getId() );
        likeIdea.setLikeDate( likeIdeaDTO.getLikeDate() );

        return likeIdea;
    }

    @Override
    public Set<LikeIdeaDTO> likeIdeasToLikeIdeaDTOs(Set<LikeIdea> likeIdeas) {
        if ( likeIdeas == null ) {
            return null;
        }

        Set<LikeIdeaDTO> set = new HashSet<LikeIdeaDTO>( Math.max( (int) ( likeIdeas.size() / .75f ) + 1, 16 ) );
        for ( LikeIdea likeIdea : likeIdeas ) {
            set.add( likeIdeaToLikeIdeaDTO( likeIdea ) );
        }

        return set;
    }

    @Override
    public Set<LikeIdea> likeIdeaDTOsToLikeIdeas(Set<LikeIdeaDTO> likeIdeaDTOs) {
        if ( likeIdeaDTOs == null ) {
            return null;
        }

        Set<LikeIdea> set = new HashSet<LikeIdea>( Math.max( (int) ( likeIdeaDTOs.size() / .75f ) + 1, 16 ) );
        for ( LikeIdeaDTO likeIdeaDTO : likeIdeaDTOs ) {
            set.add( likeIdeaDTOToLikeIdea( likeIdeaDTO ) );
        }

        return set;
    }

    private Integer likeIdeaUserIdId(LikeIdea likeIdea) {
        if ( likeIdea == null ) {
            return null;
        }
        User userId = likeIdea.getUserId();
        if ( userId == null ) {
            return null;
        }
        Integer id = userId.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer likeIdeaIdeaIdId(LikeIdea likeIdea) {
        if ( likeIdea == null ) {
            return null;
        }
        Idea ideaId = likeIdea.getIdeaId();
        if ( ideaId == null ) {
            return null;
        }
        Integer id = ideaId.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected User likeIdeaDTOToUser(LikeIdeaDTO likeIdeaDTO) {
        if ( likeIdeaDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( likeIdeaDTO.getUserId() );

        return user;
    }

    protected Idea likeIdeaDTOToIdea(LikeIdeaDTO likeIdeaDTO) {
        if ( likeIdeaDTO == null ) {
            return null;
        }

        Idea idea = new Idea();

        idea.setId( likeIdeaDTO.getIdeaId() );

        return idea;
    }
}
