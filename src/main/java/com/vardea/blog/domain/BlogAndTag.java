package com.vardea.blog.domain;

import lombok.*;

/**
 * @author leing
 * @date 2020/9/9 17:38
 * 把博客和标签关系存到数据库中使用的类
 */
@Getter
@Setter
@ToString(exclude = "blogId")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BlogAndTag {
    /**
     * 标签编号
     */
    private Long tagId;
    /**
     * 博客编号
     */
    private Blog blogId;
}
