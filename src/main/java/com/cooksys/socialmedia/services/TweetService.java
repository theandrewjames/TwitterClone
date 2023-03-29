package com.cooksys.socialmedia.services;

import java.util.List;

import com.cooksys.socialmedia.dto.TweetRequestDto;
import com.cooksys.socialmedia.dto.TweetResponseDto;
import com.cooksys.socialmedia.entity.Credentials;

public interface TweetService  {
	TweetResponseDto getTweetById(Long id);

	List<TweetResponseDto> getAllTweets();

	TweetResponseDto deleteTweetById(Long id, Credentials credentials);

	TweetResponseDto createTweet(TweetRequestDto tweetRequestDto);
	
	List<TweetResponseDto> getRepostsById(Long id);

}
