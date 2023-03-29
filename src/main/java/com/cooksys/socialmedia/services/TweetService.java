package com.cooksys.socialmedia.services;

import java.util.List;

import com.cooksys.socialmedia.dto.TweetResponseDto;

public interface TweetService  {
	TweetResponseDto getTweetById(Long id);

	List<TweetResponseDto> getAllTweets();
}
