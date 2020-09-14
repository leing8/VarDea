package com.vardea.blog.web.controller.show;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Var Dea
 * @date 2020/8/10 13:03
 */

@Controller
public class IndexController {

    @GetMapping("/info")
    public String info() {
        //User user = userMapper.getUser("朱一鸣", "e10adc3949ba59abbe56e057f20f883e");
        return "info";
    }
}
