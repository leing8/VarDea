package com.vardea.blog.service;

import com.vardea.blog.domain.Type;

import java.util.List;

/**
 * @author leing
 * @date 2020/9/14 9:49
 */
public interface TypeService {

    /**
     * 保存一个type
     *
     * @param type 保存的type对象信息
     * @return 返回的type对象中可获取保存的type对象id
     */
    int saveType(Type type);

    /**
     * 根据id删除一条type记录
     *
     * @param type 要删除的type的信息
     * @return 删除的结果
     */
    int removeType(Type type);

    /**
     * 更新一个类型
     *
     * @param type 要更新的类型信息
     * @return 更新结果
     */
    int updateType(Type type);

    /**
     * 根据id获取一个类型
     *
     * @param type 要获取的类型id
     * @return 类型对象
     */
    Type getType(Type type);

    /**
     * 获取一个类型集合
     *
     * @return 查询到的类型集合
     */
    List<Type> listType(Type type);
}
