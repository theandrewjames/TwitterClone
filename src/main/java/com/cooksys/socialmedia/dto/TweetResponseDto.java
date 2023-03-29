package com.cooksys.socialmedia.dto;

import java.sql.Timestamp;
import java.util.List;

import com.cooksys.socialmedia.entity.Tweet;
import com.cooksys.socialmedia.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class TweetResponseDto {
	
	private Long id;
	
	private UserResponseDto author;
	
	private Timestamp posted;
	
	private String content;
	
	private TweetResponseDto inReplyTo;
	
	private TweetResponseDto repostOf;
	

}
