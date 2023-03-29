package com.cooksys.socialmedia.services;

import java.util.List;

import com.cooksys.socialmedia.dto.HashtagDto;
import com.cooksys.socialmedia.dto.TweetResponseDto;

public interface HashtagService {

	List<HashtagDto> getAllTags();

	List<TweetResponseDto> getTweetsByHashtagLabel(String label);
}
