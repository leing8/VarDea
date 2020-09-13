package com.vardea.blog.web.controller.manage;

import com.vardea.blog.domain.Blog;
import com.vardea.blog.service.IBlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author leing
 * @date 2020/9/13 21:01
 */
@Controller
@RequestMapping("/manage")
public class BlogController {

    @Resource
    private IBlogService blogService;

    @RequestMapping("/blogs")
    public String blogs(Model model) {
        List<Blog> blogList = blogService.getBlogList();
        model.addAttribute("blogs", blogList);
        return "manage/blogs";
    }
}
