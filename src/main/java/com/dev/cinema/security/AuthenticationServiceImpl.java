package com.dev.cinema.security;

import com.dev.cinema.exceptions.AuthenticationException;
import com.dev.cinema.lib.Inject;
import com.dev.cinema.lib.Service;
import com.dev.cinema.model.User;
import com.dev.cinema.service.ShoppingCartService;
import com.dev.cinema.service.UserService;
import com.dev.cinema.util.HashUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final Logger LOGGER = LogManager.getLogger(AuthenticationServiceImpl.class);

    @Inject
    private UserService userService;

    @Inject
    private ShoppingCartService shoppingCartService;

    @Override
    public User login(String email, String password) throws AuthenticationException {
        User userFromDB = userService.findByEmail(email)
                .orElseThrow(() -> new AuthenticationException("Incorrect username or password"));
        if (userFromDB.getPassword()
                .equals(HashUtil.hashPassword(password, userFromDB.getSalt()))) {
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
        newUser.setSalt(HashUtil.getSalt());
        newUser.setPassword(HashUtil.hashPassword(password, newUser.getSalt()));
        newUser = userService.add(newUser);
        shoppingCartService.registerNewShoppingCart(newUser);
        return newUser;
    }
}
