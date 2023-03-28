package com.cooksys.socialmedia.dto;

import java.sql.Timestamp;

import com.cooksys.socialmedia.entity.Tweet;
import com.cooksys.socialmedia.entity.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TweetResponseDto {
	
	private Long id;
	
	private User author;
	
	private Timestamp posted;
	
	private String content;
	
	private Tweet inReplyTo;
	
	private Tweet repostOf;
	

}
