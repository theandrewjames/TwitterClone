package com.cooksys.socialmedia.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.socialmedia.entity.User;
import com.cooksys.socialmedia.repositories.UserRepository;
import com.cooksys.socialmedia.services.ValidateService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ValidateServiceImpl implements ValidateService {
	private final UserRepository userRepository;

	@Override
	public boolean validateUsernameAvailable(String username) {
		List<User> allUsers = userRepository.findAll();
		for (User user : allUsers) {
			if (user.getCredentials().getUsername().equals(username)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean validateUserByUsername(String username) {
		List<User> allUsers = userRepository.findAll();
		for (User user : allUsers) {
			if (user.getCredentials().getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}
}
