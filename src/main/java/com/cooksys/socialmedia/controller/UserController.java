
package com.cooksys.socialmedia.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.socialmedia.dto.TweetResponseDto;
import com.cooksys.socialmedia.dto.UserResponseDto;
import com.cooksys.socialmedia.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
	private final UserService userService;

	@GetMapping
	public List<UserResponseDto> getAllUsers() {
		return userService.getAllUsers();
	}
	@GetMapping("/@{username}")
	public UserResponseDto getUserByUsername(@PathVariable String username) {
		return userService.getUserByUsername(username);
	}

	@PatchMapping("/@{username}")
	public UserResponseDto updateUsername(@PathVariable String username) {
		return userService.updateUsername(username);
	}

	@DeleteMapping("/@{username}")
	public UserResponseDto deleteUserByUsername(@PathVariable String username) {
		return null;
	}

	@GetMapping("/@{username}/feed")
	public TweetResponseDto getAllTweetsByUsername(@PathVariable String username) {
		return null;
	}

}
