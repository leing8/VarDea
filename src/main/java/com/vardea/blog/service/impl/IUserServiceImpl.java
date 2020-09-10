package com.vardea.blog.service.impl;

import com.vardea.blog.domain.User;
import com.vardea.blog.mapper.UserMapper;
import com.vardea.blog.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author leing
 * @date 2020/9/10 20:11
 */
@Service
public class IUserServiceImpl implements IUserService {

/*    @Autowired
    private UserMapper userMapper;*/

    @Override
    public User checkUser(String username, String password) {
        return null;
    }
}
