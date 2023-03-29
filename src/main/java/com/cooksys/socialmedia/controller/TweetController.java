
package com.cooksys.socialmedia.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.socialmedia.dto.TweetRequestDto;
import com.cooksys.socialmedia.dto.TweetResponseDto;
import com.cooksys.socialmedia.entity.Credentials;
import com.cooksys.socialmedia.services.TweetService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tweets")

public class TweetController {
	
	private final TweetService tweetService;
	
	@GetMapping
	public List<TweetResponseDto> getAllTweets() {
		return tweetService.getAllTweets();
	}
	
	@GetMapping("/{id}")
	public TweetResponseDto getTweetById(@PathVariable Long id) {
		return tweetService.getTweetById(id);
	}

	@GetMapping("/{id}/reposts")
	public List<TweetResponseDto> getRepostsById(@PathVariable Long id) {
		return tweetService.getRepostsById(id);
	}

	@DeleteMapping("/{id}")
	public TweetResponseDto deleteTweetById(@PathVariable Long id, @RequestBody Credentials credentials) {
		return tweetService.deleteTweetById(id, credentials);
	}
	
	@PostMapping
	public TweetResponseDto createTweet(@RequestBody TweetRequestDto tweetRequestDto ) {
		return tweetService.createTweet(tweetRequestDto);
	}

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
