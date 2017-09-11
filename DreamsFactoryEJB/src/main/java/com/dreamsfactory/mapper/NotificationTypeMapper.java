package com.dreamsfactory.mapper;

import java.util.Set;

import org.mapstruct.Mapper;

import com.dreamsfactory.dto.NotificationTypeDTO;
import com.dreamsfactory.entity.NotificationType;

@Mapper(componentModel = "cdi")
public interface NotificationTypeMapper {

	NotificationTypeDTO notificationTypeToNotificationTypeDTO(NotificationType notificationType);

	NotificationType notificationTypeDTOToNotificationType(NotificationTypeDTO notificationTypeDTO);

	Set<NotificationTypeDTO> notificationTypesToNotificationTypeDTOs(Set<NotificationType> notificationTypes);

	Set<NotificationType> notificationTypeDTOsToNotificationTypes(Set<NotificationTypeDTO> notificationTypeDTOs);
}
