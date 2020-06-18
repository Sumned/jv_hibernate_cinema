package com.dev.cinema.controller.authentication;

import com.dev.cinema.mapper.UserMapper;
import com.dev.cinema.model.dto.user.UserRequestDto;
import com.dev.cinema.security.AuthenticationService;
import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/registration")
public class AuthenticationController {
    private static final Logger LOGGER =
            LogManager.getLogger(AuthenticationController.class);
    private final AuthenticationService authenticationService;
    private final UserMapper userMapper;

    public AuthenticationController(AuthenticationService authenticationService,
                                    UserMapper userMapper) {
        this.authenticationService = authenticationService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public ModelAndView registerIndex() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/registration");
        return modelAndView;
    }

    @PostMapping
    public String register(@RequestBody @Valid UserRequestDto requestDto) {
        LOGGER.info(requestDto.toString());
        if (requestDto.getPassword().equals(requestDto.getRepeatPassword())) {
            authenticationService.register(userMapper
                    .getUserFromRequestDto(requestDto));
            return "Registration successful";
        }
        return "Registration failed";
    }
}
