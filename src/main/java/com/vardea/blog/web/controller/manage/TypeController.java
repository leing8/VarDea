package com.vardea.blog.web.controller.manage;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.vardea.blog.domain.Type;
import com.vardea.blog.service.TypeService;
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
 * @date 2020/9/14 13:08
 */
@Controller
@RequestMapping("/manage")
public class TypeController {

    @Resource
    private TypeService typeService;

    @GetMapping("/types")
    public String listTypes(Page<Type> page, Model model) {
        List<Type> allType = typeService.listType(null, page);
        //得到分页结果对象
        PageInfo<Type> pageInfo = new PageInfo<>(allType);
        model.addAttribute("pageInfo", pageInfo);
        return "manage/types";
    }

    @GetMapping("/edit/type")
    public String toAddPage(Model model) {
        model.addAttribute("type", new Type());
        return "manage/edit/type";
    }

    @GetMapping("/edit/{id}/type")
    public String toEditPage(Type type, Model model) {
        Type resultType = typeService.getType(type);
        model.addAttribute("type", resultType);
        return "manage/edit/type";
    }

    @PostMapping("/type")
    public String saveType(@Validated Type type, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        //获取domain中数据校验的所有错误
        if (bindingResult.hasErrors()) return "manage/edit/type";

        Type t = typeService.getType(type);
        if (t != null) {
            bindingResult.rejectValue("name", "nameError", "已有" + type.getName() + "类型, 请重新添加!");
            return "manage/edit/type";
        }
        int i = typeService.saveType(type);
        if (i == 1 && type.getId() != null) redirectAttributes.addFlashAttribute("message", "添加成功");
        return "redirect:/manage/types";
    }

    @DeleteMapping("/type/{id}")
    public String removeType(Type type, RedirectAttributes redirectAttributes) {
        int i = typeService.removeType(type);
        if (i == 1) redirectAttributes.addFlashAttribute("message", "删除成功");
        return "redirect:/manage/types";
    }

    @PutMapping("/type")
    public String updateType(Type type, RedirectAttributes redirectAttributes) {
        int i = typeService.updateType(type);
        if (i == 1) redirectAttributes.addFlashAttribute("message", "修改成功");
        return "redirect:/manage/types";
    }
}
