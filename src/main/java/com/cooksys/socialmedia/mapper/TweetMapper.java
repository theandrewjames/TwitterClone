package com.cooksys.socialmedia.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cooksys.socialmedia.dto.ContextDto;
import com.cooksys.socialmedia.dto.TweetRequestDto;
import com.cooksys.socialmedia.dto.TweetResponseDto;
import com.cooksys.socialmedia.entity.Tweet;

@Mapper(componentModel = "spring", uses = { UserMapper.class })

public interface TweetMapper {

	TweetResponseDto entityToDto(Tweet tweet);

	Tweet responseDtoToEntity(TweetResponseDto tweetResponseDto);

	Tweet dtoToEntity(TweetRequestDto tweetRequestDto);

	List<TweetResponseDto> entitiesToDtos(List<Tweet> tweets);

	ContextDto dtoToEntity(ContextDto contextDto);

}
