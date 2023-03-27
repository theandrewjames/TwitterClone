
package com.cooksys.socialmedia.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.socialmedia.dto.TweetResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("tweets")
@RequiredArgsConstructor
public class TweetController {

	@GetMapping("/{id}/context")
	public TweetResponseDto getAllTweetsById(@PathVariable Long id) {
		return null;
	}

	@PostMapping("/{id}/repost")
	public TweetResponseDto createRepostById(@PathVariable Long id) {
		return null;
	}

	@GetMapping("/{id}/tags")
	public TweetResponseDto getTagsById(@PathVariable Long id) {
		return null;
	}

	@GetMapping("/{id}/likes")
	public TweetResponseDto getLikesById(@PathVariable Long id) {
		return null;
	}

}
