package com.study.springboot.configure.advice;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.study.springboot.base.ApiBusiException;
import com.study.springboot.base.ApiResult;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ApiBusiException.class)
    @ResponseBody
    public ApiResult<Object> handleBusinessException(ApiBusiException e) {
        return new ApiResult<>(false, e.getErrorCode(), e.getErrorMsg(), e.getData());
    }
/*
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public AjaxResult<Void> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.warn(e.getMessage(), e);
        BindingResult bindingResult = e.getBindingResult();
        if (bindingResult.hasErrors()) {
            List<FieldError> fieldErrorList = bindingResult.getFieldErrors();
            Map<String, Object> result = new HashMap<>();
            fieldErrorList.forEach(error ->
                    result.put(error.getField(), error.getDefaultMessage())
            );
            return new AjaxResult<>(false, ErrorCodeEnum.PARAM_CHECK_ERROR.getCode(), JSON.toJSONString(result), null);
        }
        return AjaxResult.fail();
    }

    @ExceptionHandler(value = {HttpRequestMethodNotSupportedException.class, HttpMediaTypeNotSupportedException.class, HttpMessageNotReadableException.class, MissingServletRequestParameterException.class})
    @ResponseBody
    public AjaxResult<Void> handleHttpRequestMethodNotSupportedException(Exception e) {
        log.warn(e.getMessage(), e);
        return AjaxResult.fail(e.getMessage());
    }*/


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ApiResult<Void> handleException(Exception e) {
        log.error("error",e);
        return ApiResult.fail(e.getMessage());
    }
}
