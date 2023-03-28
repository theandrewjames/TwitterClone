package com.cooksys.socialmedia.services.impl;

import com.cooksys.socialmedia.dto.UserResponseDto;
import com.cooksys.socialmedia.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Override
    public List<UserResponseDto> checkIfUsernameExists(String username) {
        return null;
    }

    @Override
    public List<UserResponseDto> getUserbyUsername(String username) {
        return null;
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return null;
    }
}
