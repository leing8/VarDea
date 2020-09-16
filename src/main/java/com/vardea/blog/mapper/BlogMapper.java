package com.vardea.blog.mapper;

import com.github.pagehelper.Page;
import com.vardea.blog.domain.Blog;

import java.util.List;

/**
 * @author leing
 * @date 2020/9/12 22:39
 */
public interface BlogMapper {

    int saveBlog(Blog blog);

    int removeBlog(Blog blog);

    int updateBlog(Blog blog);

    Blog getBlog(Blog blog);

    List<Blog> listBlog(Blog blog);
}
