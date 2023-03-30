package com.cooksys.socialmedia.services;

import java.util.List;

import com.cooksys.socialmedia.dto.CredentialsDto;
import com.cooksys.socialmedia.dto.TweetRequestDto;
import com.cooksys.socialmedia.dto.TweetResponseDto;
import com.cooksys.socialmedia.dto.UserResponseDto;
import com.cooksys.socialmedia.entity.Credentials;

public interface TweetService  {
	TweetResponseDto getTweetById(Long id);

	List<TweetResponseDto> getAllTweets();

	TweetResponseDto deleteTweetById(Long id, Credentials credentials);

	TweetResponseDto getTweetContextById(Long id);
  
	TweetResponseDto createTweet(TweetRequestDto tweetRequestDto);
	
	List<TweetResponseDto> getRepostsById(Long id);

	TweetResponseDto likeTweet(Long id, CredentialsDto credentialsDto);

	List<UserResponseDto> getUsersMentionedInTweet(Long id);
}
