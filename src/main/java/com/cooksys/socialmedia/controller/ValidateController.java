
package com.cooksys.socialmedia.controller;

import com.cooksys.socialmedia.dto.CredentialsDto;
import com.cooksys.socialmedia.services.ValidateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.socialmedia.entity.User;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/validate")
@RequiredArgsConstructor
public class ValidateController {
	private final ValidateService validateService;

//	@GetMapping("/username/exists/@{username}")
//	public boolean validateUserByUsername(@PathVariable String username) {
//		String userExists = username;
//		if (userExists.getCredentials().getUsername().equals(username)) {
//			return true;
//		} else {
//			return true;
//		}
//	}

	@GetMapping("/username/exists/@{username}")
	public CredentialsDto validateUserByUsername(@PathVariable String username) {

		return null;
	}
	@GetMapping("/username/available/@{username}")
	public boolean validateUsernameAvailable(@PathVariable String username) {
		return validateService.validateUsernameAvailable(username);
	}
}
