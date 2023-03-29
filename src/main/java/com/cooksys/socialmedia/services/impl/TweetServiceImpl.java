package com.cooksys.socialmedia.services.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.cooksys.socialmedia.dto.CredentialsDto;
import com.cooksys.socialmedia.dto.TweetRequestDto;
import com.cooksys.socialmedia.dto.TweetResponseDto;
import com.cooksys.socialmedia.entity.Credentials;
import com.cooksys.socialmedia.entity.Hashtag;
import com.cooksys.socialmedia.entity.Tweet;
import com.cooksys.socialmedia.entity.User;
import com.cooksys.socialmedia.exceptions.NotAuthorizedException;
import com.cooksys.socialmedia.exceptions.NotFoundException;
import com.cooksys.socialmedia.mapper.CredentialsMapper;
import com.cooksys.socialmedia.mapper.HashtagMapper;
import com.cooksys.socialmedia.mapper.TweetMapper;
import com.cooksys.socialmedia.mapper.UserMapper;
import com.cooksys.socialmedia.repositories.HashtagRepository;
import com.cooksys.socialmedia.repositories.TweetRepository;
import com.cooksys.socialmedia.repositories.UserRepository;
import com.cooksys.socialmedia.services.TweetService;

@Service
@RequiredArgsConstructor
public class TweetServiceImpl implements TweetService {

	private final TweetRepository tweetRepository;
	private final UserRepository userRepository;
	private final HashtagRepository hashtagRepository;

	private final TweetMapper tweetMapper;
	private final CredentialsMapper credentialsMapper;


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

		// Check if author matches credentials
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
	public TweetResponseDto createTweet(TweetRequestDto tweetRequestDto) {
		User validatedUser = validateCredentials(tweetRequestDto.getCredentials());

		// Tweet
		Tweet tweetToBeSaved = tweetMapper.dtoToEntity(tweetRequestDto);

		// Extract hashtags and mentions
		List<Hashtag> tweetHashtags = extractHashtags(tweetToBeSaved.getContent());
		List<User> userMentions = extractUserMentions(tweetToBeSaved.getContent());

		tweetToBeSaved.setDeleted(false);
		tweetToBeSaved.setAuthor(validatedUser);
		tweetToBeSaved.setMentionedUsers(userMentions);
		tweetToBeSaved.setHashtags(tweetHashtags);

		Tweet savedTweet = tweetRepository.save(tweetToBeSaved);

		return tweetMapper.entityToDto(savedTweet);
	}
	
	
	@Override
	public TweetResponseDto likeTweet(Long id, CredentialsDto credentialsDto) {
		User user = validateCredentials(credentialsDto);
		Optional<Tweet> tweetToBeLikedOptional = tweetRepository.findAllByIdAndDeletedFalse(id);
		
		if (!tweetToBeLikedOptional.isPresent()) {
			throw new NotFoundException("Tweet with id: " + id + " not found!" );
		}
		
		Tweet tweetToBeLiked = tweetToBeLikedOptional.get();
		User savedUser = userRepository.saveAndFlush(user);	
		
		
		List<User> likedByUsersList = tweetToBeLiked.getLikedByUsers();
		List<Tweet> likedTweetsList = savedUser.getLikedTweets();
					
		
		likedTweetsList.add(tweetToBeLiked);
		likedByUsersList.add(savedUser);
		
		
		tweetToBeLiked.setLikedByUsers(likedByUsersList);
		Tweet savedTweet = tweetRepository.saveAndFlush(tweetToBeLiked);	
		
		return tweetMapper.entityToDto(savedTweet);		
	}

	

	private List<User> extractUserMentions(String content) {
		List<User> userMentions = new ArrayList<>();
		Map<String, User> dbUsernames = new HashMap<>();
		
		for (User user : userRepository.findAll()) {
			dbUsernames.put(user.getCredentials().getUsername(), user);
		}

		String[] words = content.split("\\s+");
		for (String word : words) {
			if (word.startsWith("@")) {
				User dbUser = dbUsernames.get(word.substring(1));
				if (dbUser != null) {
					userMentions.add(dbUser);
				}
			}
		}
		
		return userMentions;
	}
	

	private List<Hashtag> extractHashtags(String content) {
		// Extract hashtags
		List<Hashtag> hashtags = new ArrayList<>();
		Map<String, Hashtag> dbHashtags = new HashMap<>();
		
		for (Hashtag hashtag: hashtagRepository.findAll()) {
			dbHashtags.put(hashtag.getLabel(), hashtag);
		}
		
		String[] words = content.split("\\s+");
		for (String word : words) {
			if (word.startsWith("#")) {
				//If hashtag already exists in db 
				Hashtag dbHashtag = dbHashtags.get(word);
				if (dbHashtag != null) {
					hashtags.add(dbHashtag);
				} else {
				//Create new hashtag
					Hashtag newHashtag = new Hashtag();
					newHashtag.setLabel(word);
					Hashtag savedHashtag = hashtagRepository.saveAndFlush(newHashtag);
					hashtags.add(savedHashtag);
				}
			}
		}
		return hashtags;
	}

	
	private User validateCredentials(CredentialsDto credentialsDto) {
		Credentials requestCredentials = credentialsMapper.dtoToEntity(credentialsDto);

		Optional<User> userFromDB = userRepository.findByCredentials(requestCredentials);

		if (!userFromDB.isPresent()) {
			throw new NotAuthorizedException("User not authorized!");
		}

		return userFromDB.get();
	}


	public List<TweetResponseDto> getRepostsById(Long id) {
		List<Tweet> foundTweets = new ArrayList<>();
		for(Tweet tweet : tweetRepository.findAllByDeletedFalse()) {
			if(tweet.getRepostOf() != null && tweet.getRepostOf().getId() == id) {
				foundTweets.add(tweet);
			}
		}
		if(foundTweets.isEmpty()) {
			throw new NotFoundException("No reposts found for tweet with id #" + id);
		}
		return tweetMapper.entitiesToDtos(foundTweets);

	}





}
