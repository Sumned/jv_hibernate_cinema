package com.dev.cinema.mapper;

import com.dev.cinema.model.User;
import com.dev.cinema.model.dto.user.UserRequestDto;
import com.dev.cinema.model.dto.user.UserResponseDto;
import com.dev.cinema.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private static final Logger LOGGER =
            LogManager.getLogger(UserMapper.class);
    private final UserService userService;

    public UserMapper(UserService userService) {
        this.userService = userService;
    }

    public UserResponseDto getUserResponseDto(User user) {
        return new UserResponseDto(user.getId(), user.getEmail());
    }

    public User getUserFromRequestDto(UserRequestDto requestDto) {
        LOGGER.info(requestDto.toString());
        return userService.add(new User(requestDto.getEmail(), requestDto.getPassword()));
    }
}
