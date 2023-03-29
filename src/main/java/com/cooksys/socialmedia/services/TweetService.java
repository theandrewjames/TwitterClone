package com.cooksys.socialmedia.services;

import java.util.List;

import com.cooksys.socialmedia.dto.TweetResponseDto;
import com.cooksys.socialmedia.entity.Credentials;

public interface TweetService  {
	TweetResponseDto getTweetById(Long id);

	List<TweetResponseDto> getAllTweets();

	TweetResponseDto deleteTweetById(Long id, Credentials credentials);

	List<TweetResponseDto> getRepostsById(Long id);
}
