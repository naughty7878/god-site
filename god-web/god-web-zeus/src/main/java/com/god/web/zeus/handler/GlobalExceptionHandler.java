package com.god.web.zeus.handler;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.god.common.bean.BaseOutput;
import com.god.web.zeus.exception.CustomException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
   //处理自定义的异常
   @ExceptionHandler(CustomException.class) 
   @ResponseBody
   public Object customHandler(CustomException e){
      e.printStackTrace();
      return BaseOutput.ERROR(500, e.getMessage());
   }
   //其他未处理的异常
   @ExceptionHandler(Exception.class)
   @ResponseBody
   public Object exceptionHandler(Exception e){
      e.printStackTrace();
      return BaseOutput.ERROR(500, e.getMessage());
   }
}
