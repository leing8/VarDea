package cn.vardea.blog.service;

import cn.vardea.blog.domain.User;

/**
 * @author leing
 * @date 2020/9/10 20:09
 */
public interface UserService {

    User checkUser(String username, String password);
}
