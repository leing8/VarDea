package cn.vardea.blog.domain;

import lombok.*;

import java.util.Date;
import java.util.List;

/**
 * @author leing
 * @date 2020/9/9 17:41
 * 用户类
 */
@Getter
@Setter
@ToString(exclude = "blogs")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {
    /**
     * 用户编号
     */
    private Long id;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 类型(普通用户,管理员用户)
     */
    private Integer type;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 该用户发布的博客
     */
    private List<Blog> blogs;
}
