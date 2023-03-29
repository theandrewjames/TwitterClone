package com.cooksys.socialmedia.services.impl;

import lombok.RequiredArgsConstructor;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cooksys.socialmedia.dto.TweetResponseDto;
import com.cooksys.socialmedia.entity.Credentials;
import com.cooksys.socialmedia.entity.Tweet;
import com.cooksys.socialmedia.exceptions.NotAuthorizedException;
import com.cooksys.socialmedia.exceptions.NotFoundException;
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
		List<Tweet> listOfTweets = tweetRepository.findAllByDeletedFalse();
			
		listOfTweets.sort(new Comparator<Tweet>() {

			@Override
			public int compare(Tweet o1, Tweet o2) {
				// TODO Auto-generated method stub
				return o2.getPosted().compareTo(o1.getPosted());
			}			
		});
		
		return tweetMapper.entitiesToDtos(listOfTweets);
	}

	@Override
	public TweetResponseDto getTweetById(Long id) {
		Optional<Tweet> tweet = tweetRepository.findByIdAndDeletedFalse(id);
		if (tweet.isPresent()) {
			return tweetMapper.entityToDto(tweet.get());
		} else {
			throw new NotFoundException("No tweet found with id: " + id);
		}

	}

	@Override
	public TweetResponseDto deleteTweetById(Long id, Credentials requestCredentials) {
		Optional<Tweet> tweet = tweetRepository.findByIdAndDeletedFalse(id);
				
		if (!tweet.isPresent()) {
			throw new NotFoundException("No tweet found with id: " + id);
		}
		
		Tweet tweetToDelete = tweet.get();
		
		//Check if author matches credentials
		Credentials currentCredentials = tweetToDelete.getAuthor().getCredentials();		
		if (requestCredentials.equals(currentCredentials)) {
			tweetToDelete.setId(id);
			tweetToDelete.setDeleted(true);		
			return tweetMapper.entityToDto(tweetRepository.saveAndFlush(tweetToDelete));
		} else {
			throw new NotAuthorizedException("Not authorized to delete tweet with id: " + id);
		}
	}

	@Override
	public TweetResponseDto getTweetContextById(Long id) {
		getTweetById(id);
		return null;
	}

}
