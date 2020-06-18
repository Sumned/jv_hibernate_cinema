package com.dev.cinema.security;

import com.dev.cinema.model.User;
import com.dev.cinema.service.RoleService;
import com.dev.cinema.service.ShoppingCartService;
import com.dev.cinema.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    public AuthenticationServiceImpl(UserService userService,
                                     ShoppingCartService shoppingCartService,
                                     PasswordEncoder passwordEncoder,
                                     RoleService roleService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Override
    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.addRoles(roleService.getByName("USER"));
        user = userService.add(user);
        shoppingCartService.registerNewShoppingCart(user);
        return user;
    }
}
