package cn.vardea.blog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.vardea.blog.domain.Tag;
import cn.vardea.blog.mapper.TagMapper;
import cn.vardea.blog.service.TagService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author leing
 * @date 2020/9/16 19:53
 */
@Service
@Transactional
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

    @Transactional(readOnly = true)
    @Override
    public Tag getTag(Tag tag) {
        return tagMapper.getTag(tag);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Tag> listTag(Tag tag, Page<Tag> page) {
        PageHelper.startPage(page.getPageNum(), 5);
        return tagMapper.listTag(tag);
    }
}
