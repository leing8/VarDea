package com.vardea.blog.web.controller.manage;

import com.vardea.blog.domain.User;
import com.vardea.blog.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * @author leing
 * @date 2020/9/13 18:30
 */
@Controller
@RequestMapping("/manage")
public class LoginController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes redirectAttributes) {
        User user = userService.checkUser(username, password);
        if (user != null) {
            user.setPassword(null);
            session.setAttribute("user", user);
            return "redirect:main";
        } else {
            redirectAttributes.addFlashAttribute("message", "账号密码不匹配!");
            return "manage/login";
        }
    }

    @GetMapping("/loginOut")
    public String loginOut(HttpSession session) {
        //将登陆成功的用户信息清空
        session.removeAttribute("user");
        return "redirect:manage";
    }
}
