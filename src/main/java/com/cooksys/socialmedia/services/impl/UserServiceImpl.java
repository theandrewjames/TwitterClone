package com.cooksys.socialmedia.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cooksys.socialmedia.dto.CredentialsDto;
import com.cooksys.socialmedia.dto.ProfileDto;
import com.cooksys.socialmedia.dto.UserRequestDto;
import com.cooksys.socialmedia.dto.UserResponseDto;
import com.cooksys.socialmedia.entity.Credentials;
import com.cooksys.socialmedia.entity.Profile;
import com.cooksys.socialmedia.entity.User;
import com.cooksys.socialmedia.exceptions.BadRequestException;
import com.cooksys.socialmedia.exceptions.NotFoundException;
import com.cooksys.socialmedia.mapper.CredentialsMapper;
import com.cooksys.socialmedia.mapper.ProfileMapper;
import com.cooksys.socialmedia.mapper.UserMapper;
import com.cooksys.socialmedia.repositories.UserRepository;
import com.cooksys.socialmedia.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;
	private final UserMapper userMapper;

	private final CredentialsMapper credentialsMapper;
	private final ProfileMapper profileMapper;

	@Override
	public List<UserResponseDto> getAllUsers() {
		List<User> usersFound = new ArrayList<>();
		for (User user : userRepository.findAll()) {
			if (user.isDeleted() == false) {
				usersFound.add(user);
			}
		}
		return userMapper.entitiesToDtos(usersFound);
	}

	@Override
	public UserResponseDto getUserByUsername(String username) {
		User foundUser = null;
		for (User user : userRepository.findAll()) {
			if (user.getCredentials().getUsername().equals(username)) {
				foundUser = user;
			}
		}
		if (foundUser == null || foundUser.isDeleted()) {
			throw new NotFoundException("User not found");
		}
		return userMapper.entityToDto(foundUser);
	}

	@Override
	public UserResponseDto updateUsername(String username) {
		if (username.equals(null)) {
			throw new NotFoundException("User not found to update");
		}
		return userMapper.entityToDto(username);
	}

	@Override
	public UserResponseDto deleteUserByUsername(String username, Credentials credentials) {
		User userToDelete = null;
		if (username.equals(null)) {
			throw new NotFoundException("No user found to delete");
		}
		for (User user : userRepository.findAll()) {
			if (user.getCredentials().getUsername().equals(username)) {
				userToDelete = user;
			}
		}
		Credentials credentialsToBeDeleted = userToDelete.getCredentials();
		if (credentials.equals(credentialsToBeDeleted)) {
			userToDelete.setDeleted(true);
		}
		return userMapper.entityToDto(userRepository.saveAndFlush(userToDelete));
	}

	@Override
	public UserResponseDto createUser(UserRequestDto userRequestDto) {
		Credentials credentials = credentialsMapper.dtoToEntity(userRequestDto.getCredentials());
		Profile profile = profileMapper.dtoToEntity(userRequestDto.getProfile());

		Optional<User> userInDbOptional = userRepository.findByCredentials(credentials);
		User user = new User();
		
		Optional<User> usernameInDBOptional = userRepository.findByCredentialsUsername(credentials.getUsername());
		if (usernameInDBOptional.isPresent()) {
			User usernameInDB = userInDbOptional.get();
			Credentials credentialsInDB = usernameInDB.getCredentials();
			if (credentialsInDB.getUsername().equals(credentials.getUsername())) {
				throw new BadRequestException("Username is already taken!");
			}
			
		}
				
		if (userInDbOptional.isPresent()) {
			if (userInDbOptional.get().isDeleted()) {
				// Reactivate user
				user = userInDbOptional.get();
				user.setDeleted(false);

			} else {
				throw new BadRequestException("User already exists!");
			}
		} else {
			user.setCredentials(credentials);
			user.setProfile(profile);
		}

		User savedUser = userRepository.saveAndFlush(user);
		return userMapper.entityToDto(savedUser);
	}
}
