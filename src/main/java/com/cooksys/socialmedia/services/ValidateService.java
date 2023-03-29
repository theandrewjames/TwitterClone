package com.cooksys.socialmedia.services;

import com.cooksys.socialmedia.dto.CredentialsDto;

public interface ValidateService {
    boolean validateUsernameAvailable(String username);
}
