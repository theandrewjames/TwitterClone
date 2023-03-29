package com.cooksys.socialmedia.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.cooksys.socialmedia.dto.UserRequestDto;
import com.cooksys.socialmedia.dto.UserResponseDto;
import com.cooksys.socialmedia.entity.User;

@Mapper(componentModel = "spring", uses = { ProfileMapper.class, CredentialsMapper.class })

public interface UserMapper {

	@Mapping(target = "username", source = "credentials.username")
	UserResponseDto entityToDto(User user);
	

	User requestDtoToEntity(UserRequestDto userRequestDto);
	
	User responseDtoToEntity(UserResponseDto userResponseDto);
	


	List<UserResponseDto> entitiesToDtos(List<User> users);

}
