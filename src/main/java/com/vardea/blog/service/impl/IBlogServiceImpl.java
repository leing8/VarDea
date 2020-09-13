package com.vardea.blog.service.impl;

import com.vardea.blog.domain.Blog;
import com.vardea.blog.mapper.BlogMapper;
import com.vardea.blog.service.IBlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author leing
 * @date 2020/9/13 21:07
 */
@Service
public class IBlogServiceImpl implements IBlogService {

    @Resource
    private BlogMapper blogMapper;

    @Override
    public List<Blog> getBlogList() {
        return blogMapper.getBlogList();
    }
}
