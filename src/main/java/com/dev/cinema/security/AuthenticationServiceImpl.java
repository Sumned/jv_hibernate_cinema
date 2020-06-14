package com.dev.cinema.security;

import com.dev.cinema.exceptions.AuthenticationException;
import com.dev.cinema.model.User;
import com.dev.cinema.service.ShoppingCartService;
import com.dev.cinema.service.UserService;
import com.dev.cinema.util.HashUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger LOGGER = LogManager.getLogger(AuthenticationServiceImpl.class);

    private UserService userService;
    private ShoppingCartService shoppingCartService;
    private HashUtil hashUtil;

    public AuthenticationServiceImpl(UserService userService,
                                     ShoppingCartService shoppingCartService,
                                     HashUtil hashUtil) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.hashUtil = hashUtil;
    }

    @Override
    public User login(String email, String password) throws AuthenticationException {
        User userFromDB = userService.findByEmail(email)
                .orElseThrow(() -> new AuthenticationException("Incorrect username or password"));
        if (userFromDB.getPassword()
                .equals(hashUtil.hashPassword(password, userFromDB.getSalt()))) {
            String logger = "user " + userFromDB.getName() + " login successful";
            LOGGER.info(logger);
            return userFromDB;
        }
        throw new AuthenticationException("Incorrect username or password");
    }

    @Override
    public User register(String email, String password) {
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setSalt(hashUtil.getSalt());
        newUser.setPassword(hashUtil.hashPassword(password, newUser.getSalt()));
        newUser = userService.add(newUser);
        shoppingCartService.registerNewShoppingCart(newUser);
        return newUser;
    }
}
