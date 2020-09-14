package com.vardea.blog.service.impl;

import com.vardea.blog.domain.User;
import com.vardea.blog.mapper.UserMapper;
import com.vardea.blog.service.UserService;
import com.vardea.blog.util.MD5Utils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author leing
 * @date 2020/9/10 20:11
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User checkUser(String username, String password) {
        //将密码做md5加密
        return userMapper.getUser(username, MD5Utils.code(password));
    }
}