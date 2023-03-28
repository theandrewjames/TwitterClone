package com.cooksys.socialmedia.services.impl;

import com.cooksys.socialmedia.dto.HashtagResponseDto;
import com.cooksys.socialmedia.dto.TweetResponseDto;
import com.cooksys.socialmedia.mapper.HashtagMapper;
import com.cooksys.socialmedia.repositories.HashtagRepository;
import com.cooksys.socialmedia.services.HashtagService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HashtagServiceImpl implements HashtagService {
    private final HashtagRepository hashtagRepository;
    private final HashtagMapper hashtagMapper;
	@Override
	public List<TweetResponseDto> getTweetsByHashtagLabel() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<HashtagResponseDto> getAllTags() {
		// TODO Auto-generated method stub
		return null;
	}

}
