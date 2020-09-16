package com.vardea.blog.service;

import com.github.pagehelper.Page;
import com.vardea.blog.domain.Tag;

import java.util.List;

/**
 * @author leing
 * @date 2020/9/16 19:53
 */
public interface TagService {

    int saveTag(Tag tag);

    int removeTag(Tag tag);

    int updateTag(Tag tag);

    Tag getTag(Tag tag);

    List<Tag> listTag(Tag tag, Page<Tag> page);
}
