package com.vardea.blog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author leing
 * @date 2020/9/9 17:40
 * 博客分类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Type {
    /**
     * 分类编号
     */
    private Long id;
    /**
     * 分类名
     */
    private String name;
    /**
     * 该类型下的博客
     */
    private List<Blog> blogs;
}