package com.dev.cinema.controller.user;

import com.dev.cinema.exceptions.DataProcessingException;
import com.dev.cinema.mapper.UserMapper;
import com.dev.cinema.model.User;
import com.dev.cinema.model.dto.user.UserResponseDto;
import com.dev.cinema.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping(value = "/inject")
    public String userInject() {
        User user = new User("user@user.com", "1234");
        userService.add(user);
        User user1 = new User("user1@user.com", "1234");
        userService.add(user1);
        User user2 = new User("user2@user.com", "1234");
        userService.add(user2);
        User user3 = new User("user3@user.com", "1234");
        userService.add(user3);
        LOGGER.info("Injection done successfully");
        return "Injection done successfully";
    }

    @GetMapping(value = "/by-email")
    public UserResponseDto getByEmail(@RequestParam String email) {
        LOGGER.info("trying to get user by email");
        return userMapper.getUserResponseDto(userService.findByEmail(email)
                .orElseThrow(() -> new DataProcessingException("Can't find user by email")));
    }
}
