package com.vardea.blog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author leing
 * @date 2020/9/9 17:38
 * 把博客和标签关系存到数据库中使用的类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogAndTag {
    private Long tagId;
    private Long blogId;
}
