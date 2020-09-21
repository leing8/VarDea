package cn.vardea.blog.handler;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Var Dea
 * @date 2020/8/10 13:38
 * 控制器异常处理器
 */

@ControllerAdvice
public class ControllerExceptionHandler {

    //对控制器抛出的运行时期异常进行处理
    @ExceptionHandler(RuntimeException.class)
    public ModelAndView exceptionHandler(HttpServletRequest request, RuntimeException e) {
        //不对带ResponseStatus注解的异常做处理
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }
        //将异常信息返回到error/error.html页面
        ModelAndView mv = new ModelAndView();
        mv.addObject("url", request.getRequestURL());
        mv.addObject("exception", e);
        mv.setViewName("error/error");
        return mv;
    }
}
