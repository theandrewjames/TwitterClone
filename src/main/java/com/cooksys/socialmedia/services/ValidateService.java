package com.cooksys.socialmedia.services;

public interface ValidateService {
    boolean validateUsernameAvailable(String username);

	boolean validateUserByUsername(String username);
}
