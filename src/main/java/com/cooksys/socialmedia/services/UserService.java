package com.cooksys.socialmedia.services;

import java.util.List;

import com.cooksys.socialmedia.dto.UserResponseDto;
import com.cooksys.socialmedia.entity.Credentials;

public interface UserService {
	List<UserResponseDto> getAllUsers();

	UserResponseDto getUserByUsername(String username);

	UserResponseDto updateUsername(String username);

	UserResponseDto deleteUserByUsername(String username, Credentials credentials);

	void followUserByUsername(String username, Credentials credentials);
}
