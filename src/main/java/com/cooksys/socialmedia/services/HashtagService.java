package com.cooksys.socialmedia.services;

import com.cooksys.socialmedia.dto.HashtagResponseDto;
import com.cooksys.socialmedia.dto.TweetResponseDto;

import java.util.List;

public interface HashtagService {
    List<TweetResponseDto> getTweetsByHashtagLabel(String label);

    List<HashtagResponseDto> getAllTags();
}
