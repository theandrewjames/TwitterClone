package com.cooksys.socialmedia.mapper;

import org.mapstruct.Mapper;

import com.cooksys.socialmedia.dto.CredentialsDto;
import com.cooksys.socialmedia.entity.Credentials;

@Mapper(componentModel="spring")
public interface CredentialsMapper {
	
	CredentialsDto entityToDto (Credentials credentials);
	
	Credentials dtoToEntity (CredentialsDto credentialsDto); 

}
