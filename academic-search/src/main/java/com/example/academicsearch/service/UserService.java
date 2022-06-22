package com.example.academicsearch.service;

import com.example.academicsearch.model.User;

public interface UserService {

    User getOneUserByEmail(String userName);
    User save(User user);

}
