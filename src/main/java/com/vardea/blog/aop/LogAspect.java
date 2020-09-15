package com.vardea.blog.aop;

import lombok.ToString;
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
     * 需要增强的方法:
     * 对任意修饰符 com.vardea.blog.web及其子包中以Controller结尾的类的方法
     * 对意修饰符 com.vardea.blog.handler包中以Handler结尾的类的方法
     * 做增强
     */
    @Pointcut("execution(* com.vardea.blog.web..*Controller.*(..)) || execution(* com.vardea.blog.handler.*Handler.*(..))")
    public void log() {
    }

    /**
     * 使用前置增强获取用户访问的请求地址,ip地址,类名,方法名,请求参数
     *
     * @param joinPoint 用于获取请求参数
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        RequestLog requestLog = RequestLog.getInstance();
        //获取请求地址
        requestLog.url = request.getRequestURI();
        //获取用户ip地址
        requestLog.ip = request.getRemoteAddr();
        //获取访问的方法名
        requestLog.methodName = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        //获取请求参数
        requestLog.args = joinPoint.getArgs();
        //将数据存入请求日志并写入log文件
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
    @ToString
    static class RequestLog {
        private final static RequestLog requestLog = new RequestLog();

        /**
         * 请求的controller地址
         */
        private String url;
        /**
         * 发起请求的ip地址
         */
        private String ip;
        /**
         * 请求的方法名
         */
        private String methodName;
        /**
         * 请求的参数
         */
        private Object[] args;

        private RequestLog() {
        }

        private static RequestLog getInstance() {
            return requestLog;
        }
    }
}
