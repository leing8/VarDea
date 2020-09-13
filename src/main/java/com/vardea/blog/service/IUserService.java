package com.vardea.blog.service;

import com.vardea.blog.domain.User;

/**
 * @author leing
 * @date 2020/9/10 20:09
 */
public interface IUserService {

    User checkUser(String username, String password);
}
