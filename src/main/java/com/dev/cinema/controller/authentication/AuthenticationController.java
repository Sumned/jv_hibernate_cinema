package com.dev.cinema.controller.authentication;

import com.dev.cinema.mapper.UserMapper;
import com.dev.cinema.model.dto.user.UserRequestDto;
import com.dev.cinema.model.dto.user.UserResponseDto;
import com.dev.cinema.security.AuthenticationService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserMapper userMapper;

    public AuthenticationController(AuthenticationService authenticationService,
                                    UserMapper userMapper) {
        this.authenticationService = authenticationService;
        this.userMapper = userMapper;
    }

    @PostMapping(value = "/register")
    public UserResponseDto register(@RequestBody @Valid UserRequestDto requestDto) {
        return userMapper.getUserResponseDto(authenticationService
                .register(requestDto.getEmail(), requestDto.getPassword()));
    }
}
