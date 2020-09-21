package cn.vardea.blog.web.controller.manage;

import cn.vardea.blog.domain.Blog;
import cn.vardea.blog.service.BlogService;
import com.github.pagehelper.Page;
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
    private BlogService blogService;

    @RequestMapping("/blogs")
    public String blogs(Page<Blog> page, Blog blog, Model model) {
        List<Blog> blogList = blogService.listBlog(blog, page);
        model.addAttribute("blogs", blogList);
        return "manage/blogs";
    }
}
