package com.vardea.blog.service.impl;

import com.vardea.blog.domain.Blog;
import com.vardea.blog.mapper.BlogMapper;
import com.vardea.blog.service.BlogService;
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

    @Transactional(readOnly = true)
    @Override
    public List<Blog> listBlog() {
        return blogMapper.listBlog();
    }
}
