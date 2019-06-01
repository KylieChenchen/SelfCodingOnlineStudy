package com.chen.common;

import com.chen.utils.JsonUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@ControllerAdvice和@ResponseBody
@RestControllerAdvice
public class CommonException {

    @ExceptionHandler(UnauthorizedException.class)
    public JsonBean permException(UnauthorizedException e){
        return JsonUtils.createJsonBean(1, e.getMessage());
    }

}
