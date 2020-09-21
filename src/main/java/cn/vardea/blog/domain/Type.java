package cn.vardea.blog.domain;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author leing
 * @date 2020/9/9 17:40
 * 博客分类
 */
@Getter
@Setter
@ToString(exclude = "blogs")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Type {
    /**
     * 分类编号
     */
    private Long id;
    /**
     * 分类名
     */
    @NotEmpty(message = "请输入类型名称")
    private String name;
    /**
     * 该类型下的博客
     */
    private List<Blog> blogs;
}