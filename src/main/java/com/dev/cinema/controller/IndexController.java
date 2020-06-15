package com.dev.cinema.controller;

import com.dev.cinema.model.User;
import com.dev.cinema.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class IndexController {
    private static final Logger LOGGER =
            LogManager.getLogger(IndexController.class);
    private final UserService userService;

    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView index() {
        try {
            User user = new User("admin@user.com", "admin");
            userService.add(user);
        } catch (Exception e) {
            LOGGER.info("This user exist");
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello";
    }
}
