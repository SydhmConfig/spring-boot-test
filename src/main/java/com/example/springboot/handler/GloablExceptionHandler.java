package com.example.springboot.handler;


import com.example.springboot.POJO.ResultBean;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GloablExceptionHandler {

//    private Logger logger = LoggerFactory.getLogger(GloablExceptionHandler.class);


    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResultBean validationErrorHandler(BindException ex) throws JsonProcessingException {
        //1.此处先获取BindingResult
        BindingResult bindingResult = ex.getBindingResult();
        //2.获取错误信息
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        //3.组装异常信息
        Map<String, String> message = new HashMap<String, String>();
        for (FieldError fieldError : fieldErrors) {
            message.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        //4.将map转换为JSON
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(message);
        //5.返回错误信息
        return new ResultBean("400", json);
    }


    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultBean handlerException(Exception e) {
        //记录错误日志
        log.error(e.getMessage());
        //返回客户信息
        return new ResultBean("success", "当前服务繁忙，请稍后再试");
    }
}

