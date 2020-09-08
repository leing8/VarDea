package com.vardea.blog.aspect;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Var Dea
 * @date 2020/8/10 16:22
 */

@Async
@Aspect
@Component
public class LogAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    HttpServletRequest request;

    @Pointcut("execution(* com.vardea.blog.web.*.*(..))")
    public void log() {
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        String uri = request.getRequestURI();
        String ip = request.getRemoteAddr();
        String typeName = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(uri, ip, typeName + "." + methodName, args);

        logger.info("Request: " + requestLog.toString());
    }

    @After("log()")
    public void doAfter() {
        logger.info("===============after================");
    }

    @AfterReturning(returning = "result", pointcut = "log()")
    public void doReturn(Object result) {
        logger.info("result: " + result);
    }

    @Data
    @AllArgsConstructor
    private class RequestLog {
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;
    }
}
