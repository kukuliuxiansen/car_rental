package com.wd.car_rental.util.exception;

import com.wd.car_rental.util.result.ResultInfo;
import lombok.Data;

/**
 * @author :刘先森
 * @version :1.0
 * @PROJECT_NAME :普通话和方言语料库
 * @description : 自定义异常类
 * @date :2020-02-13 14:37
 **/
@Data
public class BusinessException extends RuntimeException{

    private String message = ResultInfo.RunTimeError;

    public BusinessException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public BusinessException(String message) {
        super(message);
        this.message=message;
        // TODO Auto-generated constructor stub
    }

    @Override
    public String getMessage() {
        return message;
    }
}