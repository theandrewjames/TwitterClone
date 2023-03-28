package com.cooksys.socialmedia.services.impl;

import com.cooksys.socialmedia.dto.UserResponseDto;
import com.cooksys.socialmedia.entity.User;
import com.cooksys.socialmedia.mapper.UserMapper;
import com.cooksys.socialmedia.repositories.UserRepository;
import com.cooksys.socialmedia.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> usersFound = new ArrayList<>();
        for(User user : userRepository.findAll()) {
            if(user.isDeleted() == false) {
                usersFound.add(user);
            }
        }
        return userMapper.entitiesToDtos(usersFound);
    }
}
