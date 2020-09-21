package cn.vardea.blog.domain;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;


/**
 * @author leing
 * @date 2020/9/9 17:40
 * 博客标签类
 */
@Getter
@Setter
@ToString(exclude = "blogs")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Tag {
    /**
     * 标签编号
     */
    private Long id;
    /**
     * 标签名
     */
    @NotEmpty(message = "请输入标签名称")
    private String name;
    /**
     * 此标签下的博客
     */
    private List<Blog> blogs;
}
