package com.cooksys.socialmedia.dto;

import com.cooksys.socialmedia.entity.Tweet;
import com.cooksys.socialmedia.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TweetResponseDto {
    private Long id;
    private User user;
    private Timestamp posted;
    private Boolean deleted;
    private String content;
    private Tweet inReplyTo;
    private Tweet repostOf;
}
