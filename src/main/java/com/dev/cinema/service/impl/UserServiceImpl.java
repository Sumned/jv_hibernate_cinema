package com.dev.cinema.service.impl;

import com.dev.cinema.dao.RoleDao;
import com.dev.cinema.dao.UserDao;
import com.dev.cinema.exceptions.DataProcessingException;
import com.dev.cinema.model.User;
import com.dev.cinema.service.UserService;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final RoleDao roleDao;

    public UserServiceImpl(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    @Override
    public User add(User user) {
        user.getRoles().forEach(roleDao::add);
        return userDao.add(user);
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id)
                .orElseThrow(() -> new DataProcessingException("Can't get movie by id"));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
