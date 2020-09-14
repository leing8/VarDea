package com.vardea.blog.mapper;

import com.vardea.blog.domain.Blog;

import java.util.List;

/**
 * @author leing
 * @date 2020/9/12 22:39
 */
public interface BlogMapper {
    /**
     * 获取所有博客
     *
     * @return 博客集合
     */
    List<Blog> listBlog();

    Blog getBlogByTypeId();
}
