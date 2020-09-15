package com.vardea.blog.service;

import com.vardea.blog.domain.Blog;

import java.util.List;

/**
 * @author leing
 * @date 2020/9/13 21:07
 */
public interface BlogService {
    /**
     * 获取所有博客
     *
     * @return 博客集合
     */
    List<Blog> listBlog(Blog blog);

    Blog getBlog(Blog blog);
}
