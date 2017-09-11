package com.dreamsfactory.mapper;

import java.util.Set;

import org.mapstruct.Mapper;

import com.dreamsfactory.dto.UserDTO;
import com.dreamsfactory.entity.User;

@Mapper(componentModel = "cdi")
public interface UserMapper {

	UserDTO userToUserDTO(User user);

	User userDTOToUser(UserDTO userDTO);
	
	Set<UserDTO> usersToUserDTOs(Set<User> users);

	Set<User> userDTOsToUsers(Set<UserDTO> userDTOs);
}
