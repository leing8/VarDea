package com.vardea.blog.service.impl;

import com.vardea.blog.domain.Tag;
import com.vardea.blog.mapper.TagMapper;
import com.vardea.blog.service.TagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author leing
 * @date 2020/9/16 19:53
 */
@Service
public class TagServiceImpl implements TagService {

    @Resource
    private TagMapper tagMapper;

    @Override
    public int saveTag(Tag tag) {
        return tagMapper.saveTag(tag);
    }

    @Override
    public int removeTag(Tag tag) {
        return tagMapper.removeTag(tag);
    }

    @Override
    public int updateTag(Tag tag) {
        return tagMapper.updateTag(tag);
    }

    @Override
    public Tag getTag(Tag tag) {
        return tagMapper.getTag(tag);
    }

    @Override
    public List<Tag> listTag(Tag tag) {
        return tagMapper.listTag(tag);
    }
}
