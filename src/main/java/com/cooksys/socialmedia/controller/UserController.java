
package com.cooksys.socialmedia.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.socialmedia.dto.UserResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

	@GetMapping("/@{username}")
	public UserResponseDto getUserByUsername(@PathVariable String username) {
		return null;
	}

	@PatchMapping("/@{username}")
	public UserResponseDto updateUserByUsername(@PathVariable String username) {
		return null;
	}

	@DeleteMapping("/@{username}")
	public UserResponseDto deleteUserByUsername(@PathVariable String username) {
		return null;
	}

	@GetMapping("/@{username}")
	public UserResponseDto getAllTweetsByUsername(@PathVariable String username) {
		return null;
	}

}