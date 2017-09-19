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

    date = "2017-09-19T09:19:05-0300",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"

)

@ApplicationScoped

public class FollowIdeaMapperImpl implements FollowIdeaMapper {

    @Override

    public FollowIdeaDTO followIdeaToFollowIdeaDTO(FollowIdea followIdea) {

        if ( followIdea == null ) {

            return null;
        }

        FollowIdeaDTO followIdeaDTO = new FollowIdeaDTO();

        followIdeaDTO.setUserId( followIdeaUserIdId( followIdea ) );

        followIdeaDTO.setIdeaId( followIdeaIdeaIdId( followIdea ) );

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

        User userId = new User();

        Idea ideaId = new Idea();

        followIdea.setUserId( userId );

        followIdea.setIdeaId( ideaId );

        userId.setId( followIdeaDTO.getUserId() );

        ideaId.setId( followIdeaDTO.getIdeaId() );

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

        Set<FollowIdeaDTO> set = new HashSet<FollowIdeaDTO>();

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

        Set<FollowIdea> set = new HashSet<FollowIdea>();

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
}

