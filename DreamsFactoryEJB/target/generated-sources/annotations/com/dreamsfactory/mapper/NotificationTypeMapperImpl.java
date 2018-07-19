package com.dreamsfactory.mapper;

import com.dreamsfactory.dto.NotificationTypeDTO;
import com.dreamsfactory.entity.NotificationType;
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
public class NotificationTypeMapperImpl implements NotificationTypeMapper {

    @Override
    public NotificationTypeDTO notificationTypeToNotificationTypeDTO(NotificationType notificationType) {
        if ( notificationType == null ) {
            return null;
        }

        NotificationTypeDTO notificationTypeDTO = new NotificationTypeDTO();

        notificationTypeDTO.setId( notificationType.getId() );
        notificationTypeDTO.setName( notificationType.getName() );
        notificationTypeDTO.setAvailable( notificationType.getAvailable() );

        return notificationTypeDTO;
    }

    @Override
    public NotificationType notificationTypeDTOToNotificationType(NotificationTypeDTO notificationTypeDTO) {
        if ( notificationTypeDTO == null ) {
            return null;
        }

        NotificationType notificationType = new NotificationType();

        notificationType.setId( notificationTypeDTO.getId() );
        notificationType.setName( notificationTypeDTO.getName() );
        notificationType.setAvailable( notificationTypeDTO.isAvailable() );

        return notificationType;
    }

    @Override
    public Set<NotificationTypeDTO> notificationTypesToNotificationTypeDTOs(Set<NotificationType> notificationTypes) {
        if ( notificationTypes == null ) {
            return null;
        }

        Set<NotificationTypeDTO> set = new HashSet<NotificationTypeDTO>( Math.max( (int) ( notificationTypes.size() / .75f ) + 1, 16 ) );
        for ( NotificationType notificationType : notificationTypes ) {
            set.add( notificationTypeToNotificationTypeDTO( notificationType ) );
        }

        return set;
    }

    @Override
    public Set<NotificationType> notificationTypeDTOsToNotificationTypes(Set<NotificationTypeDTO> notificationTypeDTOs) {
        if ( notificationTypeDTOs == null ) {
            return null;
        }

        Set<NotificationType> set = new HashSet<NotificationType>( Math.max( (int) ( notificationTypeDTOs.size() / .75f ) + 1, 16 ) );
        for ( NotificationTypeDTO notificationTypeDTO : notificationTypeDTOs ) {
            set.add( notificationTypeDTOToNotificationType( notificationTypeDTO ) );
        }

        return set;
    }
}
