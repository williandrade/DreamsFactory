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

    date = "2017-09-19T16:48:33-0300",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_144 (Oracle Corporation)"

)

@ApplicationScoped

public class LikeIdeaMapperImpl implements LikeIdeaMapper {

    @Override

    public LikeIdeaDTO likeIdeaToLikeIdeaDTO(LikeIdea likeIdea) {

        if ( likeIdea == null ) {

            return null;
        }

        LikeIdeaDTO likeIdeaDTO = new LikeIdeaDTO();

        likeIdeaDTO.setUserId( likeIdeaUserIdId( likeIdea ) );

        likeIdeaDTO.setIdeaId( likeIdeaIdeaIdId( likeIdea ) );

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

        User userId = new User();

        Idea ideaId = new Idea();

        likeIdea.setUserId( userId );

        likeIdea.setIdeaId( ideaId );

        userId.setId( likeIdeaDTO.getUserId() );

        ideaId.setId( likeIdeaDTO.getIdeaId() );

        likeIdea.setId( likeIdeaDTO.getId() );

        likeIdea.setLikeDate( likeIdeaDTO.getLikeDate() );

        return likeIdea;
    }

    @Override

    public Set<LikeIdeaDTO> likeIdeasToLikeIdeaDTOs(Set<LikeIdea> likeIdeas) {

        if ( likeIdeas == null ) {

            return null;
        }

        Set<LikeIdeaDTO> set = new HashSet<LikeIdeaDTO>();

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

        Set<LikeIdea> set = new HashSet<LikeIdea>();

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
}

