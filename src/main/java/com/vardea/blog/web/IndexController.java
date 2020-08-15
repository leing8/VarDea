package com.vardea.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Author Var Dea
 * @Date 2020/8/10 13:03
 */

@Controller
public class IndexController {

    @GetMapping("/")
    public String test(){
        return "index";
    }

    @GetMapping("/info")
    public String info(){
        return "info";
    }
}
