package com.asif.backend.service.Impl;

import com.asif.backend.common.constant.ErrorId;
import com.asif.backend.common.exception.RmsServerException;
import com.asif.backend.config.authentication.service.CustomUserDetails;
import com.asif.backend.mapper.UserMapper;
import com.asif.backend.model.User;
import com.asif.backend.payload.request.UserRequestDto;
import com.asif.backend.payload.response.UserResponseDto;
import com.asif.backend.repository.UserRepository;
import com.asif.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    @Override
    public User findByUserName(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return user.orElseThrow(() -> RmsServerException.notFound(ErrorId.NOT_FOUND));
    }

    @Override
    public User findByUserId(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> RmsServerException.notFound(""));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isPresent()) {
            return CustomUserDetails.build(user.get());
        } else {
            throw new UsernameNotFoundException("User Not Found" + username);
        }
    }

    @Override
    @Transactional
    public UserResponseDto createUser(UserRequestDto requestDto) {
        User user = userMapper.convertToEntity(requestDto);
        return userMapper.convertToResponse(userRepository.save(user));
    }
}
