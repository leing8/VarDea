package com.vardea.blog.domain;

import lombok.*;

import java.util.List;



/**
 * @author leing
 * @date 2020/9/9 17:40
 * 博客标签类
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Tag {
    /**
     * 标签编号
     */
    private Long id;
    /**
     * 标签名
     */
    private String name;
    /**
     * 此标签下的博客
     */
    private List<Blog> blogs;

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
