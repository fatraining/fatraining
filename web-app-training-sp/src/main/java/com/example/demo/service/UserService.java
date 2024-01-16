package com.example.demo.service;

import com.example.demo.model.form.LoginForm;

/**
 * @author Created by YaoHaitao on 2018/3/14.
 * @since 2018-03-14 11:13
 */
public interface UserService {
    boolean shouldLogin(LoginForm loginForm);
}
