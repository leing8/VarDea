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
    private Long id;
    private String nickname;//昵称
    private String email;
    private String content;
    private boolean adminComment;//是否为管理员评论
    private String avatar;//头像
    private Date createTime;
    private Long blogId;
    private Long parentCommentId;//父评论id
    private String parentNickname;

    private Blog blog;
    private Comment parentComment;//父评论
    private List<Comment> replyComments = new ArrayList<>();//子评论

}

