package com.vardea.blog;

import com.github.pagehelper.PageHelper;
import com.vardea.blog.aop.LogAspect;
import com.vardea.blog.domain.Blog;
import com.vardea.blog.domain.Type;
import com.vardea.blog.domain.User;
import com.vardea.blog.mapper.BlogMapper;
import com.vardea.blog.mapper.TypeMapper;
import com.vardea.blog.mapper.UserMapper;
import com.vardea.blog.service.TypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Resource
    private UserMapper userMapper;

    @Resource
    private BlogMapper blogMapper;

    @Resource
    private TypeMapper typeMapper;

    @Resource
    private TypeService typeService;

    @Test
    void contextLoads() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void test() {
        HashMap<String, Object> hashMap = new HashMap<>();

        LogAspect logAspect = new LogAspect();

        String s = new String();
        String s2 = new String();
        System.out.println(s == s2);
        System.out.println(s.hashCode());
        System.out.println(s2.hashCode());
    }

    @Test
    public void mybatisTest() {
        User user = userMapper.getUser("朱一鸣", "e10adc3949ba59abbe56e057f20f883e");
        System.out.println(user);
        System.out.println("-----------------------------------------------------------------------------");
        List<Blog> blogList = blogMapper.listBlog();
        for (Blog blog : blogList) {
            System.out.println(blog);
        }
    }

    @Test
    public void typeMapperTest(){
        //Type type = new Type();
        //type.setName("第二条测试数据");
        //Type resultType = typeService.getType(type);
        //System.out.println(type);
        //System.out.println(resultType);

        //List<Type> types = typeMapper.listType();
        //System.out.println(types.size()+"++++++++++++++++++++++++");

        //Type type = new Type();
        //type.setName("测试保存");
        //Long type1 = typeMapper.saveType(type);
        //System.out.println(type1);
        //System.out.println(type);

        //int aByte = typeMapper.removeType(11L);
        //System.out.println(aByte);

        //Type type = new Type();
        //type.setId(14L);
        //type.setName("测试修改");
        //int aByte1 = typeMapper.updateType(type);
        //System.out.println(aByte1);

        //使用pagehelper插件做分页 测试
        //PageHelper.startPage(1,3);
        //List<Type> types = typeService.listType(null);
        //System.out.println(types.size()+"++++++++++++++++++++++++");

        //Type type = new Type();
        //type.setName("第二条测试数据");
        //Type resultType = typeService.getType(type);
        //
        //System.out.println(resultType);
        //System.out.println(resultType == null);
    }

}
