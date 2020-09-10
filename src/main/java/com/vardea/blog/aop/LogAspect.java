package com.vardea.blog.aop;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Var Dea
 * @date 2020/8/10 16:22
 * 日志切面,用于记录用户的操作
 */

@Aspect
@Component
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private HttpServletRequest request;

    /**
     * 需要增强的方法
     */
    @Pointcut("execution(* com.vardea.blog.web.*.*(..))")
    public void log() {
    }

    /**
     * 使用前置增强获取用户访问的请求地址,ip地址,类名,方法名,请求参数
     *
     * @param joinPoint 用于获取请求参数
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        //获取请求地址
        String uri = request.getRequestURI();
        //获取用户ip地址
        String ip = request.getRemoteAddr();
        //获取访问的类名
        String typeName = joinPoint.getSignature().getDeclaringTypeName();
        //获取访问的方法名
        String methodName = joinPoint.getSignature().getName();
        //获取请求参数
        Object[] args = joinPoint.getArgs();
        //将数据存入请求日志并写入log文件
        RequestLog requestLog = new RequestLog(uri, ip, typeName + "." + methodName, args);
        logger.info("Request: " + requestLog.toString());
    }

    @After("log()")
    public void doAfter() {
        logger.info("===============after================");
    }

    /**
     * 使用后置增强获取用户请求返回值
     *
     * @param result 执行方法的返回值
     */
    @AfterReturning(returning = "result", pointcut = "log()")
    public void doReturn(Object result) {
        logger.info("result: " + result);
    }

    /**
     * 日志内部类
     */
    @Data
    @AllArgsConstructor
    private class RequestLog {
        private String url;/*地址*/
        private String ip;/*ip*/
        private String classMethod;/*类名*/
        private Object[] args;/*参数*/
    }
}
