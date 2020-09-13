package com.vardea.blog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author leing
 * @date 2020/9/9 17:39
 * 评论类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    /**
     * 评论编号
     */
    private Long id;
    /**
     * 评论昵称
     */
    private String nickname;
    /**
     * 评论邮箱
     */
    private String email;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 是否为管理员评论
     */
    private boolean adminComment;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 父昵称
     */
    private String parentNickname;

    /**
     * 博客编号
     */
    private Blog blogId;
    /**
     * 父评论
     */
    private Comment parentCommentId;
    /**
     * 子评论
     */
    private List<Comment> replyComments;

}

