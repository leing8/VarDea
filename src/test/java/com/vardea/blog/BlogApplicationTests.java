package com.vardea.blog;

import com.vardea.blog.aop.LogAspect;
import com.vardea.blog.domain.Blog;
import com.vardea.blog.domain.User;
import com.vardea.blog.mapper.BlogMapper;
import com.vardea.blog.mapper.UserMapper;
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
        List<Blog> blogList = blogMapper.getBlogList();
        for (Blog blog : blogList) {
            System.out.println(blog);
        }
    }

}
