package com.dreamsfactory.mapper;

import com.dreamsfactory.dto.FollowIdeaDTO;
import com.dreamsfactory.entity.FollowIdea;
import com.dreamsfactory.entity.Idea;
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
public class FollowIdeaMapperImpl implements FollowIdeaMapper {

    @Override
    public FollowIdeaDTO followIdeaToFollowIdeaDTO(FollowIdea followIdea) {
        if ( followIdea == null ) {
            return null;
        }

        FollowIdeaDTO followIdeaDTO = new FollowIdeaDTO();

        Integer id = followIdeaUserIdId( followIdea );
        if ( id != null ) {
            followIdeaDTO.setUserId( id );
        }
        Integer id1 = followIdeaIdeaIdId( followIdea );
        if ( id1 != null ) {
            followIdeaDTO.setIdeaId( id1 );
        }
        followIdeaDTO.setId( followIdea.getId() );
        followIdeaDTO.setFollowDate( followIdea.getFollowDate() );
        followIdeaDTO.setUnfollowDate( followIdea.getUnfollowDate() );

        return followIdeaDTO;
    }

    @Override
    public FollowIdea followIdeaDTOToFollowIdea(FollowIdeaDTO followIdeaDTO) {
        if ( followIdeaDTO == null ) {
            return null;
        }

        FollowIdea followIdea = new FollowIdea();

        followIdea.setUserId( followIdeaDTOToUser( followIdeaDTO ) );
        followIdea.setIdeaId( followIdeaDTOToIdea( followIdeaDTO ) );
        followIdea.setId( followIdeaDTO.getId() );
        followIdea.setFollowDate( followIdeaDTO.getFollowDate() );
        followIdea.setUnfollowDate( followIdeaDTO.getUnfollowDate() );

        return followIdea;
    }

    @Override
    public Set<FollowIdeaDTO> followIdeasToFollowIdeaDTOs(Set<FollowIdea> followIdeas) {
        if ( followIdeas == null ) {
            return null;
        }

        Set<FollowIdeaDTO> set = new HashSet<FollowIdeaDTO>( Math.max( (int) ( followIdeas.size() / .75f ) + 1, 16 ) );
        for ( FollowIdea followIdea : followIdeas ) {
            set.add( followIdeaToFollowIdeaDTO( followIdea ) );
        }

        return set;
    }

    @Override
    public Set<FollowIdea> followIdeaDTOsToFollowIdeas(Set<FollowIdeaDTO> followIdeaDTOs) {
        if ( followIdeaDTOs == null ) {
            return null;
        }

        Set<FollowIdea> set = new HashSet<FollowIdea>( Math.max( (int) ( followIdeaDTOs.size() / .75f ) + 1, 16 ) );
        for ( FollowIdeaDTO followIdeaDTO : followIdeaDTOs ) {
            set.add( followIdeaDTOToFollowIdea( followIdeaDTO ) );
        }

        return set;
    }

    private Integer followIdeaUserIdId(FollowIdea followIdea) {
        if ( followIdea == null ) {
            return null;
        }
        User userId = followIdea.getUserId();
        if ( userId == null ) {
            return null;
        }
        Integer id = userId.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer followIdeaIdeaIdId(FollowIdea followIdea) {
        if ( followIdea == null ) {
            return null;
        }
        Idea ideaId = followIdea.getIdeaId();
        if ( ideaId == null ) {
            return null;
        }
        Integer id = ideaId.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected User followIdeaDTOToUser(FollowIdeaDTO followIdeaDTO) {
        if ( followIdeaDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( followIdeaDTO.getUserId() );

        return user;
    }

    protected Idea followIdeaDTOToIdea(FollowIdeaDTO followIdeaDTO) {
        if ( followIdeaDTO == null ) {
            return null;
        }

        Idea idea = new Idea();

        idea.setId( followIdeaDTO.getIdeaId() );

        return idea;
    }
}
