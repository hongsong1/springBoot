package com.hs.configuration;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @description:
 * @author: 彭于晏
 * @create: 2020-04-03 13:27
 **/
@RestControllerAdvice
public class ExceptionUtil {

    @ExceptionHandler(RuntimeException.class)
    public String getAll(RuntimeException e){
        return e.getMessage();
    }
}
