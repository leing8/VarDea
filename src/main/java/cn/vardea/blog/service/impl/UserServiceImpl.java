package cn.vardea.blog.service.impl;

import cn.vardea.blog.domain.User;
import cn.vardea.blog.mapper.UserMapper;
import cn.vardea.blog.service.UserService;
import cn.vardea.blog.util.MD5Utils;
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
