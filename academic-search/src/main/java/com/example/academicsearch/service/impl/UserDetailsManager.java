package com.example.academicsearch.service.impl;

import com.example.academicsearch.model.User;
import com.example.academicsearch.repository.UserDao;
import com.example.academicsearch.security.JwtUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsManager implements UserDetailsService {

    private final UserDao userDao;

    public UserDetailsManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        User user = userDao.findByEmail(mail);
        return JwtUserDetails.create(user);
    }

}
