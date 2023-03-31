package com.cooksys.socialmedia.services;

import java.util.List;

import com.cooksys.socialmedia.dto.CredentialsDto;
import com.cooksys.socialmedia.dto.ProfileDto;
import com.cooksys.socialmedia.dto.TweetResponseDto;
import com.cooksys.socialmedia.dto.UserRequestDto;
import com.cooksys.socialmedia.dto.UserResponseDto;
import com.cooksys.socialmedia.entity.Credentials;
import com.cooksys.socialmedia.entity.Profile;

public interface UserService {
	List<UserResponseDto> getAllUsers();

	UserResponseDto getUserByUsername(String username);

	UserResponseDto deleteUserByUsername(String username, Credentials credentials);

	UserResponseDto createUser(UserRequestDto userRequestDto);

	void followUserByUsername(String username, Credentials credentials);

	void unfollowUserByUsername(String username, Credentials credentials);

	List<TweetResponseDto> getAllTweetsByMentions(String username);

	List<UserResponseDto> getAllFollowers(String username);

	List<UserResponseDto> getAllFollowing(String username);

	List<TweetResponseDto> getAllTweetsByUsername(String username);

	UserResponseDto updateUsername(String username, UserRequestDto userRequestDto);
}
