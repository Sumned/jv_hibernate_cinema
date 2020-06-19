package com.dev.cinema.mapper;

import com.dev.cinema.model.User;
import com.dev.cinema.model.dto.user.UserRequestDto;
import com.dev.cinema.model.dto.user.UserResponseDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private static final Logger LOGGER =
            LogManager.getLogger(UserMapper.class);

    public UserResponseDto getUserResponseDto(User user) {
        return new UserResponseDto(user.getId(), user.getEmail());
    }

    public User getUserFromRequestDto(UserRequestDto requestDto) {
        LOGGER.info(requestDto.toString());
        return new User(requestDto.getEmail(), requestDto.getPassword());
    }
}
