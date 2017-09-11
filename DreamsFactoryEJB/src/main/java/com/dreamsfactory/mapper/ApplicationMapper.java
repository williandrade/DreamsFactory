package com.dreamsfactory.mapper;

import java.util.Set;

import org.mapstruct.Mapper;

import com.dreamsfactory.dto.ApplicationDTO;
import com.dreamsfactory.entity.Application;

@Mapper(componentModel = "cdi")
public interface ApplicationMapper {

	ApplicationDTO applicationToApplicationDTO(Application application);

	Application applicationDTOToApplication(ApplicationDTO applicationDTO);

	Set<ApplicationDTO> applicationsToApplicationDTOs(Set<Application> applications);

	Set<Application> applicationDTOsToApplications(Set<ApplicationDTO> applicationDTOs);
}
