package com.vardea.blog.mapper;

import com.vardea.blog.domain.Tag;

import java.util.List;

/**
 * @author leing
 * @date 2020/9/12 22:40
 */
public interface TagMapper {

    int saveTag(Tag tag);

    int removeTag(Tag tag);

    int updateTag(Tag tag);

    Tag getTag(Tag tag);

    List<Tag> listTag(Tag tag);
}
