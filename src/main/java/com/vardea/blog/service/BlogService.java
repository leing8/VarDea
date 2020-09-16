package com.vardea.blog.service;

import com.github.pagehelper.Page;
import com.vardea.blog.domain.Blog;

import java.util.List;

/**
 * @author leing
 * @date 2020/9/13 21:07
 */
public interface BlogService {

    int saveBlog(Blog blog);

    int removeBlog(Blog blog);

    int updateBlog(Blog blog);

    Blog getBlog(Blog blog);

    List<Blog> listBlog(Blog blog, Page<Blog> page);
}
