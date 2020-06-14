package com.dev.cinema.mapper;

import com.dev.cinema.model.User;
import com.dev.cinema.model.dto.user.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponseDto getUserResponseDto(User user) {
        return new UserResponseDto(user.getId(), user.getEmail());
    }
}
