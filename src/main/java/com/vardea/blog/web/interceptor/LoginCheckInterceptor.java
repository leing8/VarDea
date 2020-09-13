package com.vardea.blog.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author leing
 * @date 2020/9/13 21:16
 * 登陆检查拦截器
 */
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //若无会话中无用户登录信息则进行拦截
        if (request.getSession().getAttribute("user") == null){
            //重定向到登录页
            response.sendRedirect("/manage");
            return false;
        }
        return true;
    }
}
