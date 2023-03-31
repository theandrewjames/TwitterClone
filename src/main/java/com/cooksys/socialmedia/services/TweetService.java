package com.cooksys.socialmedia.services;

import java.util.List;

import com.cooksys.socialmedia.dto.ContextDto;
import com.cooksys.socialmedia.dto.CredentialsDto;
import com.cooksys.socialmedia.dto.HashtagDto;
import com.cooksys.socialmedia.dto.TweetRequestDto;
import com.cooksys.socialmedia.dto.TweetResponseDto;
import com.cooksys.socialmedia.dto.UserResponseDto;
import com.cooksys.socialmedia.entity.Credentials;

public interface TweetService  {
	TweetResponseDto getTweetById(Long id);

	List<TweetResponseDto> getAllTweets();

	TweetResponseDto deleteTweetById(Long id, Credentials credentials);
  
	TweetResponseDto createTweet(TweetRequestDto tweetRequestDto);
	
	List<TweetResponseDto> getRepostsById(Long id);

	TweetResponseDto likeTweet(Long id, CredentialsDto credentialsDto);

	List<UserResponseDto> getUsersMentionedInTweet(Long id);

	ContextDto getTweetContextById(Long id);

	TweetResponseDto createReplyById(Long id, TweetRequestDto tweetRequestDto);

	List<HashtagDto> getTagsById(Long id);

	List<UserResponseDto> getLikesById(Long id);

}
