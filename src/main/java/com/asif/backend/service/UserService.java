package com.asif.backend.service;

import com.asif.backend.model.User;
import com.asif.backend.payload.request.UserRequestDto;
import com.asif.backend.payload.response.UserResponseDto;

import java.util.Set;

public interface UserService {
    User findByUserName(String username);

    User findByUserId(Long userId);
    UserResponseDto createUser(UserRequestDto requestDto);

    Set<User> findAllUserByIdIn(Set<Long> userIds, Boolean isActive);
}
