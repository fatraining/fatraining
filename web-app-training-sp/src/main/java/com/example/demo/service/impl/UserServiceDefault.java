package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.model.form.LoginForm;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

/**
 * @author Created by YaoHaitao on 2018/3/14.
 * @since 2018-03-14 11:14
 */
@Service
public class UserServiceDefault implements UserService{

    private final UserRepository userRepository;

    public UserServiceDefault(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean shouldLogin(LoginForm loginForm) {
        User user = userRepository.findByUsername(loginForm.getUsername());
        return user != null && user.getPassword().equals(loginForm.getPassword());
    }
}
