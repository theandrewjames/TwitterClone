package com.cooksys.socialmedia.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.socialmedia.dto.HashtagDto;
import com.cooksys.socialmedia.dto.TweetResponseDto;
import com.cooksys.socialmedia.services.HashtagService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tags")
public class HashtagController {
	private final HashtagService hashtagService;

	@GetMapping
	public List<HashtagDto> getAllTags() {
		return hashtagService.getAllTags();
	}

	@GetMapping("/{label}")
	public List<TweetResponseDto> getTweetsByHashtagLabel(@PathVariable String label) {
		return hashtagService.getTweetsByHashtagLabel(label);
	}

}
