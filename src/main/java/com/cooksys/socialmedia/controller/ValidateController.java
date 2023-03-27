
package com.cooksys.socialmedia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.socialmedia.dto.CredintialsDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("validate")
@RequiredArgsConstructor
public class ValidateController {

	@GetMapping("/username/exists/@{username}")
	public CredintialsDto validateUserByUsername(@PathVariable String username) {
		return null;
	}

}
