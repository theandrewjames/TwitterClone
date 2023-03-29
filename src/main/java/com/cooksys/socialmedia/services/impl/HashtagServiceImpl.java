package com.cooksys.socialmedia.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.socialmedia.dto.HashtagDto;
import com.cooksys.socialmedia.mapper.HashtagMapper;
import com.cooksys.socialmedia.repositories.HashtagRepository;
import com.cooksys.socialmedia.services.HashtagService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class HashtagServiceImpl implements HashtagService {
	private final HashtagRepository hashtagRepository;
	private final HashtagMapper hashtagMapper;

	@Override
	public List<HashtagDto> getAllTags() {
		return hashtagMapper.entitiesToDtos(hashtagRepository.findAll());
		
	}

}
