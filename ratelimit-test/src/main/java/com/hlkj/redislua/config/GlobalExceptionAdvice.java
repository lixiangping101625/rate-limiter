package com.hlkj.redislua.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
/**
 * @author Xiang-ping li
 * @descition 用这个类接收从代码里抛出的异常，组织成UnifyResponse统一响应
 * @date 2020/5/15 0015  10:31
 */
@ControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler(value = Exception.class)
    public String handHttpException(HttpServletRequest request, Exception e){
        StringBuffer url = request.getRequestURL();
        System.out.println(url);
        System.out.println(e.getMessage());
        return e.getLocalizedMessage();
    }
}