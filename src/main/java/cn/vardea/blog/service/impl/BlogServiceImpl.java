package cn.vardea.blog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.vardea.blog.domain.Blog;
import cn.vardea.blog.mapper.BlogMapper;
import cn.vardea.blog.service.BlogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author leing
 * @date 2020/9/13 21:07
 */
@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    @Resource
    private BlogMapper blogMapper;

    @Override
    public int saveBlog(Blog blog) {
        return blogMapper.saveBlog(blog);
    }

    @Override
    public int removeBlog(Blog blog) {
        return blogMapper.removeBlog(blog);
    }

    @Override
    public int updateBlog(Blog blog) {
        return blogMapper.updateBlog(blog);
    }

    @Transactional(readOnly = true)
    @Override
    public Blog getBlog(Blog blog) {
        return blogMapper.getBlog(blog);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Blog> listBlog(Blog blog, Page<Blog> page) {
        PageHelper.startPage(page.getPageNum(), 5);
        return blogMapper.listBlog(blog);
    }
}
