package com.cooksys.socialmedia.services;

import java.util.List;

import com.cooksys.socialmedia.dto.UserResponseDto;

public interface UserService {
	List<UserResponseDto> getAllUsers();

	UserResponseDto getUserByUsername(String username);
}
