package com.vardea.blog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author leing
 * @date 2020/9/9 17:41
 * 用户类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String nickname;//昵称
    private String username;
    private String password;
    private String email;
    private String avatar;//头像
    private Integer type;//类型(普通用户,管理员用户)
    private Date createTime;
    private Date updateTime;

    private List<Blog> blogs = new ArrayList<>();
}
