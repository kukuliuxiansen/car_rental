package com.wd.car_rental.config;


import com.wd.car_rental.util.exception.BusinessException;
import com.wd.car_rental.util.result.Result;
import com.wd.car_rental.util.result.ResultInfo;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther 送你一朵红花花
 *全局异常捕获
 * 如果出现异常，就可以把异常直接抛出给前端，把result抛出给前端
 * @Date 2020/11/26
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**BusinessException.class   是自定义异常类 **/
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Result throwableHandler(BusinessException ex) {
        if(ex.getMessage().equals("")||ex.getMessage()==null){
            return Result.getFailResult(ResultInfo.RunTimeError);
        }
        return Result.getFailResult(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Result throwableHandler(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        FieldError fieldError = bindingResult.getFieldErrors().get(0);
        return Result.getFailResult(ResultInfo.RunTimeError);
    }
}
