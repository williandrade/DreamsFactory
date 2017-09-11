package com.dreamsfactory.mapper;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.dreamsfactory.dto.NotificationDTO;
import com.dreamsfactory.entity.Notification;

@Mapper(componentModel = "cdi", uses = {NotificationTypeMapper.class})
public interface NotificationMapper {

	@Mappings({ @Mapping(source = "userId.id", target = "userId") })
	NotificationDTO notificationToNotificationDTO(Notification notification);

	@Mappings({ @Mapping(source = "userId", target = "userId.id") })
	Notification notificationDTOToNotification(NotificationDTO notificationDTO);

	Set<NotificationDTO> notificationsToNotificationDTOs(Set<Notification> notifications);

	Set<Notification> notificationDTOsToNotifications(Set<NotificationDTO> notificationDTOs);
}
