package com.cooksys.socialmedia.services.impl;

import com.cooksys.socialmedia.dto.TweetResponseDto;
import com.cooksys.socialmedia.services.TweetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TweetServiceImpl implements TweetService {
    @Override
    public List<TweetResponseDto> getAllTweets() {
        return null;
    }
}
