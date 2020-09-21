package cn.vardea.blog;

import cn.vardea.blog.aop.LogAspect;
import cn.vardea.blog.domain.Blog;
import cn.vardea.blog.service.BlogService;
import cn.vardea.blog.service.TagService;
import cn.vardea.blog.service.TypeService;
import cn.vardea.blog.util.MD5Utils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    private DataSource dataSource;

    @Resource
    private TypeService typeService;

    @Resource
    private BlogService blogService;

    @Resource
    private TagService tagService;

    @Test
    void contextLoads() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void userTest() {
        String code = MD5Utils.code("1234");
        System.out.println(code);
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
        //User user = userMapper.getUser("朱一鸣", "e10adc3949ba59abbe56e057f20f883e");
        //System.out.println(user);
        //System.out.println("-----------------------------------------------------------------------------");
        //List<Blog> blogList = blogMapper.listBlog();
        //for (Blog blog : blogList) {
        //    System.out.println(blog);
        //}
    }

    @Test
    public void typeMapperTest() {
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
        //int aByte1 = typeService.updateType(type);
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

        //Type type = new Type();
        //type.setId(1L);
        //Type resultType = typeService.getType(type);
        //
        //System.out.println(resultType);
        //System.out.println(resultType.getBlogs().size());
    }

    @Test
    public void typeAndBlogServiceTest() {
        //Type type = new Type();
        //type.setId(1L);
        //Type resultType = typeService.getType(type);
        //System.out.println(resultType);
        //System.out.println(resultType.getBlogs().size());
        //Blog blog = new Blog();
        //blog.setId(1L);
        //Blog resultBlog = blogService.getBlog(blog);
        //System.out.println(resultBlog);
        //List<Type> types = typeService.listType(null);
        //System.out.println(types);
        Blog blog = new Blog();
        blog.setId(3L);
        Blog resultBlog = blogService.getBlog(blog);

        System.out.println(resultBlog);
    }

    @Test
    public void tagTest() {
        /*Tag tag = new Tag();
        tag.setId(4L);
        Tag resultTag = tagService.getTag(tag);
        System.out.println(resultTag);
        System.out.println(resultTag.getBlogs().size());*/

/*        Tag tag = new Tag();
        tag.setId(null);
        tag.setName("Test测试添加");
        int i = tagService.saveTag(tag);
        System.out.println(i);*/

/*        Tag tag = new Tag();
        tag.setId(11L);
        tag.setName(null);
        int i = tagService.removeTag(tag);
        System.out.println(i); */

/*        Tag tag = new Tag();
        tag.setId(10L);
        tag.setName("test 再次 测试修改");
        int i2 = tagService.updateTag(tag);
        System.out.println(i2);*/
    }

    @Test
    public void blogTest() {
/*        Blog blog = new Blog();
        blog.setId(13L);

        Blog resultBlog = blogService.getBlog(blog);
        System.out.println(resultBlog);
        System.out.println(resultBlog.getTypeId());
        System.out.println(resultBlog.getUserId());*/

        /*Blog blog = new Blog();
        blog.setId(1L);
        Page<Blog> page = new Page<>();
        page.setPageNum(5);
        List<Blog> blogs = blogService.listBlog(null, page);
        System.out.println(blogs);*/

/*        Blog blog = new Blog();

        Type type = new Type();
        type.setId(1L);
        User user = new User();
        user.setId(1L);

        blog.setTitle("test");
        blog.setContent("test");
        blog.setFirstPicture("test");
        blog.setFlag("test");
        blog.setViews(200);
        blog.setAppreciation(true);
        blog.setShareStatement(true);
        blog.setCommentabled(true);
        blog.setPublished(true);
        blog.setRecommend(true);
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setDescription("test");
        blog.setTypeId(type);
        blog.setUserId(user);
        blogService.saveBlog(blog);*/

/*        Blog blog = new Blog();
        blog.setId(12L);
        blogService.removeBlog(blog);*/

/*        Blog blog = new Blog();

        Type type = new Type();
        type.setId(2L);
        User user = new User();
        user.setId(2L);

        blog.setId(13L);
        blog.setTitle("testUpdate");
        blog.setContent("testUpdate");
        blog.setFirstPicture("testUpdate");
        blog.setFlag("testUpdate");
        blog.setViews(500);
        blog.setAppreciation(false);
        blog.setShareStatement(false);
        blog.setCommentabled(false);
        blog.setPublished(false);
        blog.setRecommend(false);
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setDescription("testUpdate");
        blog.setTypeId(type);
        blog.setUserId(user);
        blogService.updateBlog(blog);*/
    }
}
