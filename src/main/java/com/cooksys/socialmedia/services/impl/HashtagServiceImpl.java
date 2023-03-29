package com.cooksys.socialmedia.services.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.cooksys.socialmedia.dto.TweetResponseDto;
import com.cooksys.socialmedia.entity.Tweet;
import com.cooksys.socialmedia.exceptions.NotFoundException;
import com.cooksys.socialmedia.mapper.TweetMapper;
import com.cooksys.socialmedia.repositories.TweetRepository;
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
	private final TweetRepository tweetRepository;
	private final HashtagMapper hashtagMapper;
	private final TweetMapper  tweetMapper;

	@Override
	public List<HashtagDto> getAllTags() {
		return hashtagMapper.entitiesToDtos(hashtagRepository.findAll());

	}

	@Override
	public List<TweetResponseDto> getTweetsByHashtagLabel(String label) {
		List<Tweet> matchedTweets = new ArrayList<>();
		for(Tweet tweet : tweetRepository.findAll()) {
			if(tweet.getContent() != null && tweet.getContent().contains("#" + label)) {
				matchedTweets.add(tweet);
			}
		}
		if(matchedTweets.isEmpty()) {
			throw new NotFoundException("No tweets found with this hashtag");
		}
		matchedTweets.sort(Comparator.comparing(Tweet::getPosted).reversed());
		return tweetMapper.entitiesToDtos(matchedTweets);
	}

}
