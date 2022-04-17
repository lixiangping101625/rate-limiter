package com.hlkj.redislua.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RateLimiter {

    /*资源key*/
    String limitKey() default "limitKey";
    /*放行的数量*/
    int count() default 1;
    /*时间段，单位秒*/
    int period() default 1;
}
