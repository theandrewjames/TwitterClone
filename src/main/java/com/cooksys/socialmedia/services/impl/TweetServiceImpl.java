package com.cooksys.socialmedia.services.impl;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.socialmedia.dto.TweetResponseDto;
import com.cooksys.socialmedia.mapper.TweetMapper;
import com.cooksys.socialmedia.repositories.TweetRepository;
import com.cooksys.socialmedia.services.TweetService;

@Service
@RequiredArgsConstructor
public class TweetServiceImpl implements TweetService {
	
	private final TweetRepository tweetRepository;
	private final TweetMapper tweetMapper;
	
	@Override
	public List<TweetResponseDto> getAllTweets() {
		return tweetMapper.entitiesToDtos(tweetRepository.findAll());
	}
	
	@Override
	public TweetResponseDto getTweetById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
