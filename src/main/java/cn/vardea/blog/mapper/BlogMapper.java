package cn.vardea.blog.mapper;

import cn.vardea.blog.domain.Blog;

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
