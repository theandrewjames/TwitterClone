package com.cooksys.socialmedia.dto;

import com.cooksys.socialmedia.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserResponseDto {
    private Long id;
    private User.Credentials credentials;
    private User.Profile profile;
    private Timestamp joined;
    private Boolean deleted;
}
