package com.cooksys.socialmedia.services;

import com.cooksys.socialmedia.dto.UserResponseDto;

import java.util.List;

public interface UserService {
	List<UserResponseDto> checkIfUsernameExists(String username);
	List<UserResponseDto> getUserbyUsername(String username);
    List<UserResponseDto> getAllUsers();
}
