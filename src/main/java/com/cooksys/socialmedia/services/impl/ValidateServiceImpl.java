package com.cooksys.socialmedia.services.impl;

import com.cooksys.socialmedia.dto.CredentialsDto;
import com.cooksys.socialmedia.entity.User;
import com.cooksys.socialmedia.mapper.CredentialsMapper;
import com.cooksys.socialmedia.mapper.UserMapper;
import com.cooksys.socialmedia.repositories.UserRepository;
import com.cooksys.socialmedia.services.ValidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ValidateServiceImpl implements ValidateService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final CredentialsMapper credentialsMapper;

    @Override
    public boolean validateUsernameAvailable(String username) {
        List<User> allUsers = userRepository.findAll();
        for(User user : allUsers) {
            if(user.getCredentials().getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }
}
