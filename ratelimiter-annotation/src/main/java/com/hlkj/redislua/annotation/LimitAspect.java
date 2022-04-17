package com.hlkj.redislua.annotation;

import com.hlkj.redislua.AccessLimiter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
 
 
/**
 * 接口限流注解，示例见 a.b.c.controller.TestController
 */
@Aspect
@Component
@Slf4j
public class LimitAspect {
 
    private static final Logger logger = LoggerFactory.getLogger(LimitAspect.class);

    @Resource
    private AccessLimiter accessLimiter;

    @Pointcut("@annotation(com.hlkj.redislua.annotation.RateLimiter)")
    public void pointcut() {
        // do nothing
    }
 
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        RateLimiter limitAnnotation = method.getAnnotation(RateLimiter.class);
        String key = limitAnnotation.limitKey();
        int count = limitAnnotation.count();
        int period = limitAnnotation.period();
        accessLimiter.limitAccess(key, count, period);
        return "success";
    }
 

 
}