package com.dreamsfactory.mapper;

import com.dreamsfactory.dto.ApplicationDTO;
import com.dreamsfactory.entity.Application;
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
public class ApplicationMapperImpl implements ApplicationMapper {

    @Override
    public ApplicationDTO applicationToApplicationDTO(Application application) {
        if ( application == null ) {
            return null;
        }

        ApplicationDTO applicationDTO = new ApplicationDTO();

        applicationDTO.setId( application.getId() );
        applicationDTO.setName( application.getName() );
        applicationDTO.setApplicationKey( application.getApplicationKey() );

        return applicationDTO;
    }

    @Override
    public Application applicationDTOToApplication(ApplicationDTO applicationDTO) {
        if ( applicationDTO == null ) {
            return null;
        }

        Application application = new Application();

        application.setId( applicationDTO.getId() );
        application.setName( applicationDTO.getName() );
        application.setApplicationKey( applicationDTO.getApplicationKey() );

        return application;
    }

    @Override
    public Set<ApplicationDTO> applicationsToApplicationDTOs(Set<Application> applications) {
        if ( applications == null ) {
            return null;
        }

        Set<ApplicationDTO> set = new HashSet<ApplicationDTO>( Math.max( (int) ( applications.size() / .75f ) + 1, 16 ) );
        for ( Application application : applications ) {
            set.add( applicationToApplicationDTO( application ) );
        }

        return set;
    }

    @Override
    public Set<Application> applicationDTOsToApplications(Set<ApplicationDTO> applicationDTOs) {
        if ( applicationDTOs == null ) {
            return null;
        }

        Set<Application> set = new HashSet<Application>( Math.max( (int) ( applicationDTOs.size() / .75f ) + 1, 16 ) );
        for ( ApplicationDTO applicationDTO : applicationDTOs ) {
            set.add( applicationDTOToApplication( applicationDTO ) );
        }

        return set;
    }
}
