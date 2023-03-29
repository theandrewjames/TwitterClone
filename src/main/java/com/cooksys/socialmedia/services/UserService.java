package com.cooksys.socialmedia.services;

import com.cooksys.socialmedia.dto.UserResponseDto;

import java.util.ArrayList;
import java.util.List;

public interface UserService {
	List<UserResponseDto> getAllUsers();

	UserResponseDto getUserByUsername(String username);
}
