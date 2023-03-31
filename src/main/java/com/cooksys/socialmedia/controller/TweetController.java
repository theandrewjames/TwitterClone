
package com.cooksys.socialmedia.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.socialmedia.dto.ContextDto;
import com.cooksys.socialmedia.dto.CredentialsDto;
import com.cooksys.socialmedia.dto.HashtagDto;
import com.cooksys.socialmedia.dto.TweetRequestDto;
import com.cooksys.socialmedia.dto.TweetResponseDto;
import com.cooksys.socialmedia.dto.UserResponseDto;
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

	@GetMapping("/{id}/mentions")
	public List<UserResponseDto> getUsersMentionedInTweet(@PathVariable Long id) {
		return tweetService.getUsersMentionedInTweet(id);
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
	
	
	@PostMapping("/{id}/like")
	public TweetResponseDto likeTweet(@PathVariable Long id, @RequestBody CredentialsDto credentialsDto) {
		return tweetService.likeTweet(id, credentialsDto);
	}

	@GetMapping("/{id}/context")
	public ContextDto getTweetContextById(@PathVariable Long id) {
		return tweetService.getTweetContextById(id);
	}
	
	@PostMapping("/{id}/repost")
	public TweetResponseDto createRepostById(@PathVariable Long id) {
		return null;
	}

	@GetMapping("/{id}/tags")
	public List<HashtagDto> getTagsById(@PathVariable Long id) {
		return tweetService.getTagsById(id);
	}

	@GetMapping("/{id}/likes")
	public List<TweetResponseDto> getLikesById(@PathVariable Long id) {
		return tweetService.getLikesById(id);
	}


	@PostMapping("/{id}/reply")
	public TweetResponseDto createReplyById(@PathVariable Long id, @RequestBody TweetRequestDto tweetRequestDto){
		return tweetService.createReplyById(id, tweetRequestDto);
	}

}
