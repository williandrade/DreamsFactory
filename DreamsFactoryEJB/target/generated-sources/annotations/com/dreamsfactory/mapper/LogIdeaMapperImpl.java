package com.dreamsfactory.mapper;

import com.dreamsfactory.dto.LogIdeaDTO;
import com.dreamsfactory.entity.Idea;
import com.dreamsfactory.entity.LogIdea;
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
public class LogIdeaMapperImpl implements LogIdeaMapper {

    @Override
    public LogIdeaDTO logIdeaToLogIdeaDTO(LogIdea logIdea) {
        if ( logIdea == null ) {
            return null;
        }

        LogIdeaDTO logIdeaDTO = new LogIdeaDTO();

        Integer id = logIdeaUserIdId( logIdea );
        if ( id != null ) {
            logIdeaDTO.setUserId( id );
        }
        Integer id1 = logIdeaIdeaIdId( logIdea );
        if ( id1 != null ) {
            logIdeaDTO.setIdeaId( id1 );
        }
        logIdeaDTO.setId( logIdea.getId() );
        logIdeaDTO.setLog( logIdea.getLog() );
        logIdeaDTO.setLogDate( logIdea.getLogDate() );

        return logIdeaDTO;
    }

    @Override
    public LogIdea logIdeaDTOToLogIdea(LogIdeaDTO logIdeaDTO) {
        if ( logIdeaDTO == null ) {
            return null;
        }

        LogIdea logIdea = new LogIdea();

        logIdea.setUserId( logIdeaDTOToUser( logIdeaDTO ) );
        logIdea.setIdeaId( logIdeaDTOToIdea( logIdeaDTO ) );
        logIdea.setId( logIdeaDTO.getId() );
        logIdea.setLog( logIdeaDTO.getLog() );
        logIdea.setLogDate( logIdeaDTO.getLogDate() );

        return logIdea;
    }

    @Override
    public Set<LogIdeaDTO> logIdeasToLogIdeaDTOs(Set<LogIdea> logIdeas) {
        if ( logIdeas == null ) {
            return null;
        }

        Set<LogIdeaDTO> set = new HashSet<LogIdeaDTO>( Math.max( (int) ( logIdeas.size() / .75f ) + 1, 16 ) );
        for ( LogIdea logIdea : logIdeas ) {
            set.add( logIdeaToLogIdeaDTO( logIdea ) );
        }

        return set;
    }

    @Override
    public Set<LogIdea> logIdeaDTOsToLogIdeas(Set<LogIdeaDTO> logIdeaDTOs) {
        if ( logIdeaDTOs == null ) {
            return null;
        }

        Set<LogIdea> set = new HashSet<LogIdea>( Math.max( (int) ( logIdeaDTOs.size() / .75f ) + 1, 16 ) );
        for ( LogIdeaDTO logIdeaDTO : logIdeaDTOs ) {
            set.add( logIdeaDTOToLogIdea( logIdeaDTO ) );
        }

        return set;
    }

    private Integer logIdeaUserIdId(LogIdea logIdea) {
        if ( logIdea == null ) {
            return null;
        }
        User userId = logIdea.getUserId();
        if ( userId == null ) {
            return null;
        }
        Integer id = userId.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Integer logIdeaIdeaIdId(LogIdea logIdea) {
        if ( logIdea == null ) {
            return null;
        }
        Idea ideaId = logIdea.getIdeaId();
        if ( ideaId == null ) {
            return null;
        }
        Integer id = ideaId.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected User logIdeaDTOToUser(LogIdeaDTO logIdeaDTO) {
        if ( logIdeaDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( logIdeaDTO.getUserId() );

        return user;
    }

    protected Idea logIdeaDTOToIdea(LogIdeaDTO logIdeaDTO) {
        if ( logIdeaDTO == null ) {
            return null;
        }

        Idea idea = new Idea();

        idea.setId( logIdeaDTO.getIdeaId() );

        return idea;
    }
}
