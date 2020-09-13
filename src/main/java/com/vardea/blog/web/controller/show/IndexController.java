package com.vardea.blog.web.controller.show;

import com.vardea.blog.domain.User;
import com.vardea.blog.mapper.UserMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

/**
 * @author Var Dea
 * @date 2020/8/10 13:03
 */

@Controller
public class IndexController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("/")
    public String test() {
        return "index";
    }

    @GetMapping("/info")
    public String info() {
        User user = userMapper.getUser("朱一鸣", "e10adc3949ba59abbe56e057f20f883e");
        return "info";
    }
}
