package com.dreamsfactory.mapper;

import com.dreamsfactory.dto.NotificationDTO;
import com.dreamsfactory.entity.Notification;
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
public class NotificationMapperImpl implements NotificationMapper {

    @Inject
    private NotificationTypeMapper notificationTypeMapper;

    @Override
    public NotificationDTO notificationToNotificationDTO(Notification notification) {
        if ( notification == null ) {
            return null;
        }

        NotificationDTO notificationDTO = new NotificationDTO();

        Integer id = notificationUserIdId( notification );
        if ( id != null ) {
            notificationDTO.setUserId( id );
        }
        notificationDTO.setId( notification.getId() );
        notificationDTO.setTitle( notification.getTitle() );
        notificationDTO.setDescription( notification.getDescription() );
        notificationDTO.setNotificationDate( notification.getNotificationDate() );
        notificationDTO.setNotificationTypeId( notificationTypeMapper.notificationTypeToNotificationTypeDTO( notification.getNotificationTypeId() ) );
        notificationDTO.setVisualizationDate( notification.getVisualizationDate() );

        return notificationDTO;
    }

    @Override
    public Notification notificationDTOToNotification(NotificationDTO notificationDTO) {
        if ( notificationDTO == null ) {
            return null;
        }

        Notification notification = new Notification();

        notification.setUserId( notificationDTOToUser( notificationDTO ) );
        notification.setId( notificationDTO.getId() );
        notification.setTitle( notificationDTO.getTitle() );
        notification.setDescription( notificationDTO.getDescription() );
        notification.setNotificationDate( notificationDTO.getNotificationDate() );
        notification.setNotificationTypeId( notificationTypeMapper.notificationTypeDTOToNotificationType( notificationDTO.getNotificationTypeId() ) );
        notification.setVisualizationDate( notificationDTO.getVisualizationDate() );

        return notification;
    }

    @Override
    public Set<NotificationDTO> notificationsToNotificationDTOs(Set<Notification> notifications) {
        if ( notifications == null ) {
            return null;
        }

        Set<NotificationDTO> set = new HashSet<NotificationDTO>( Math.max( (int) ( notifications.size() / .75f ) + 1, 16 ) );
        for ( Notification notification : notifications ) {
            set.add( notificationToNotificationDTO( notification ) );
        }

        return set;
    }

    @Override
    public Set<Notification> notificationDTOsToNotifications(Set<NotificationDTO> notificationDTOs) {
        if ( notificationDTOs == null ) {
            return null;
        }

        Set<Notification> set = new HashSet<Notification>( Math.max( (int) ( notificationDTOs.size() / .75f ) + 1, 16 ) );
        for ( NotificationDTO notificationDTO : notificationDTOs ) {
            set.add( notificationDTOToNotification( notificationDTO ) );
        }

        return set;
    }

    private Integer notificationUserIdId(Notification notification) {
        if ( notification == null ) {
            return null;
        }
        User userId = notification.getUserId();
        if ( userId == null ) {
            return null;
        }
        Integer id = userId.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected User notificationDTOToUser(NotificationDTO notificationDTO) {
        if ( notificationDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( notificationDTO.getUserId() );

        return user;
    }
}
