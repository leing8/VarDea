package com.vardea.blog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author leing
 * @date 2020/9/9 17:37
 * 博客类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    /**
     * 博客编号
     */
    private Long id;
    /**
     * 博客标题
     */
    private String title;
    /**
     * 博客内容
     */
    private String content;
    /**
     * 博客首图地址
     */
    private String firstPicture;
    /**
     * 博客旗子,标志标签
     */
    private String flag;
    /**
     * 博客浏览次数
     */
    private Integer views;
    /**
     * 开启赞赏
     */
    private boolean appreciation;
    /**
     * 转载声明是否开启
     */
    private boolean shareStatement;
    /**
     * 评论开启
     */
    private boolean commentabled;
    /**
     * 状态(上传,修改,发布等状态)
     */
    private boolean published;
    /**
     * 是否推荐
     */
    private boolean recommend;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 描述
     */
    private String description;
    /**
     * 类型
     */
    private Type typeId;
    /**
     * 发布人
     */
    private User userId;
    /**
     * 标签
     */
    private List<Tag> tags;
    /**
     * 评论
     */
    private List<Comment> comments;
}
