package com.mytech.thebagsservice.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.mytech.thebagsservice.dtos.UserDTO;
import com.mytech.thebagsservice.entities.User;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
	UserMapper MAPPER = Mappers.getMapper(UserMapper.class);
	
	UserDTO userToUserDTO(User user);
	User userDTOToUser(UserDTO userDTO);
}
