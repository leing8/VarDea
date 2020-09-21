package cn.vardea.blog.web.controller.manage;

import cn.vardea.blog.domain.Tag;
import cn.vardea.blog.service.TagService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author leing
 * @date 2020/9/16 20:13
 */
@Controller
@RequestMapping("/manage")
public class TagController {

    @Resource
    private TagService tagService;

    @GetMapping("/tags")
    public String listTag(Page<Tag> page, Model model) {
        List<Tag> allTag = tagService.listTag(null, page);
        //得到分页结果对象
        PageInfo<Tag> pageInfo = new PageInfo<>(allTag);
        model.addAttribute("pageInfo", pageInfo);
        return "manage/tags";
    }

    @GetMapping("/edit/tag")
    public String toAddPage(Model model) {
        model.addAttribute("tag", new Tag());
        return "manage/edit/tag";
    }

    @GetMapping("/edit/{id}/tag")
    public String toEditPage(Tag tag, Model model) {
        Tag resultTag = tagService.getTag(tag);
        model.addAttribute("tag", resultTag);
        return "manage/edit/tag";
    }

    @PostMapping("/tag")
    public String saveTag(@Validated Tag tag, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        //获取domain中数据校验的所有错误
        if (bindingResult.hasErrors()) return "manage/edit/tag";

        Tag t = tagService.getTag(tag);
        if (t != null) {
            bindingResult.rejectValue("name", "nameError", "已有" + tag.getName() + "标签, 请重新添加!");
            return "manage/edit/tag";
        }
        int i = tagService.saveTag(tag);
        if (i == 1 && tag.getId() != null) redirectAttributes.addFlashAttribute("message", "添加成功");
        return "redirect:/manage/tags";
    }

    @DeleteMapping("/tag/{id}")
    public String removeTag(Tag tag, RedirectAttributes redirectAttributes) {
        int i = tagService.removeTag(tag);
        if (i == 1) redirectAttributes.addFlashAttribute("message", "删除成功");
        return "redirect:/manage/tags";
    }

    @PutMapping("/tag")
    public String updateTag(Tag tag, RedirectAttributes redirectAttributes) {
        int i = tagService.updateTag(tag);
        if (i == 1) redirectAttributes.addFlashAttribute("message", "修改成功");
        return "redirect:/manage/tags";
    }
}
