package cn.vardea.blog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import cn.vardea.blog.domain.Type;
import cn.vardea.blog.mapper.TypeMapper;
import cn.vardea.blog.service.TypeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author leing
 * @date 2020/9/14 9:50
 */
@Service
@Transactional
public class TypeServiceImpl implements TypeService {

    @Resource
    private TypeMapper typeMapper;

    @Override
    public int saveType(Type type) {
        return typeMapper.saveType(type);
    }

    @Override
    public int removeType(Type type) {
        return typeMapper.removeType(type);
    }

    @Override
    public int updateType(Type type) {
        return typeMapper.updateType(type);
    }

    @Transactional(readOnly = true)
    @Override
    public Type getType(Type type) {
        return typeMapper.getType(type);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Type> listType(Type type, Page<Type> page) {
        PageHelper.startPage(page.getPageNum(), 5);
        return typeMapper.listType(type);
    }
}
