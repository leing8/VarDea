package com.vardea.blog.config;

import com.vardea.blog.web.interceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author leing
 * @date 2020/9/13 21:24
 * 登录检查拦截器
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //使来自项目根目录以及访问index.html的请求都访问login.html页面
        registry.addViewController("/manage").setViewName("/manage/login");
        //登录后防止表单重复提交
        registry.addViewController("/manage/main.html").setViewName("/manage/index");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //传入登录拦截器对象, 需要登录拦截的资源
        registry.addInterceptor(new LoginCheckInterceptor()).addPathPatterns("/manage/**")
                //不需要拦截的资源 如:登录页,登录请求,某些静态资源等
                .excludePathPatterns("/manage", "/manage/login.html", "/manage/login", "/asserts/**",
                        "/webjars/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //指定资源文件路径
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/templates/**")
                .addResourceLocations("classpath:/templates/");
    }
}
