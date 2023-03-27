package com.cooksys.socialmedia.services.impl;

import com.cooksys.socialmedia.mapper.HashtagMapper;
import com.cooksys.socialmedia.repositories.HashtagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HashtagServiceImpl {
    private final HashtagRepository hashtagRepository;
    private final HashtagMapper hashtagMapper;

}
