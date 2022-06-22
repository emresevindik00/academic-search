package com.example.academicsearch.service.impl;

import com.example.academicsearch.model.User;
import com.example.academicsearch.repository.ResearcherDao;
import com.example.academicsearch.repository.UserDao;
import com.example.academicsearch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getOneUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }
}
