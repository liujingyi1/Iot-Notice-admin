package com.rgkCloud.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rgkCloud.vo.ReturnObject;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ExceptionHandler(value = Exception.class)
//    public ReturnObject hand(Exception e) {
//    	e.printStackTrace();
//        return new ReturnObject(0, null, "unknow error!");
//    }


}
