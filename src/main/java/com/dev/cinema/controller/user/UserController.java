package com.dev.cinema.controller.user;

import com.dev.cinema.exceptions.DataProcessingException;
import com.dev.cinema.mapper.UserMapper;
import com.dev.cinema.model.dto.user.UserResponseDto;
import com.dev.cinema.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private static final Logger LOGGER =
            LogManager.getLogger(UserController.class);
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping(value = "/by-email")
    public UserResponseDto getByEmail(Authentication authentication) {
        LOGGER.info("trying to get user by email");
        return userMapper.getUserResponseDto(userService.findByEmail(authentication.getName())
                .orElseThrow(() -> new DataProcessingException("Can't find user by email")));
    }
}
