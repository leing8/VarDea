package com.vardea.blog.mapper;

import com.vardea.blog.domain.Type;

import java.util.List;

/**
 * @author leing
 * @date 2020/9/12 22:40
 */
public interface TypeMapper {

    /**
     * 保存一个type
     *
     * @param type 要保存的type
     * @return 可返回的type对象中可获取保存的type对象id
     */
    int saveType(Type type);

    /**
     * 根据id删除一个type
     * @param type 要删除的一个type信息
     * @return 0表示未删除 1表示删除成功 -1表示删除失败
     */
    int removeType(Type type);

    /**
     * 更新一个type
     *
     * @param type 更新的type信息
     * @return 0表示未更新 1表示更新成功 -1表示更新失败
     */
    int updateType(Type type);

    /**
     * 根据id获取一个type
     *
     * @param type 要获取的type参数
     * @return 根据id查询数据库, 若存在则返回type对象, 否则返回null
     */
    Type getType(Type type);

    /**
     * 获取所有类型
     * @param type 获取条件
     * @return type集合
     */
    List<Type> listType(Type type);
}
