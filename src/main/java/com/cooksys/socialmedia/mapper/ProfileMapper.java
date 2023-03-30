package com.cooksys.socialmedia.mapper;

import org.mapstruct.Mapper;

import com.cooksys.socialmedia.dto.ProfileDto;
import com.cooksys.socialmedia.entity.Profile;

@Mapper(componentModel = "spring")

public interface ProfileMapper {
	ProfileDto entityToDto (Profile profile);
	
	Profile dtoToEntity (ProfileDto profileDto); 

}
