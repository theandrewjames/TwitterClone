
package com.cooksys.socialmedia.controller;

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

//	@GetMapping("/username/exists/@{username}")
//	public boolean validateUserByUsername(@PathVariable String username) {
//		String userExists = username;
//		if (userExists.getCredentials().getUsername().equals(username)) {
//			return true;
//		} else {
//			return true;
//		}
//	}

}
