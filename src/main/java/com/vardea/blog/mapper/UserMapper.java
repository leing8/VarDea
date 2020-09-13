package com.vardea.blog.mapper;

import com.vardea.blog.domain.User;

/**
 * @author leing
 * @date 2020/9/10 20:15
 */
public interface UserMapper {
    /**
     * 获取用户
     * @param username 用户名
     * @param password 密码
     * @return 查询到的用户
     */
    User getUser(String username, String password);
}
