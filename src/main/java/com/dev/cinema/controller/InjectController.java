package com.dev.cinema.controller;

import com.dev.cinema.model.Role;
import com.dev.cinema.model.User;
import com.dev.cinema.security.AuthenticationService;
import com.dev.cinema.service.RoleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/inject")
public class InjectController {
    private static final Logger LOGGER =
            LogManager.getLogger(InjectController.class);
    private final RoleService roleService;
    private final AuthenticationService authenticationService;

    public InjectController(RoleService roleService,
                            AuthenticationService authenticationService) {
        this.roleService = roleService;
        this.authenticationService = authenticationService;
    }

    @GetMapping
    public void injection() {
        LOGGER.info("injection");
        roleService.add(Role.of("ADMIN"));
        roleService.add(Role.of("USER"));
        User user = new User("admin@user.com", "admin");
        user.addRoles(roleService.getByName("ADMIN"));
        authenticationService.register(user);
        LOGGER.info("injection successful");
    }
}
