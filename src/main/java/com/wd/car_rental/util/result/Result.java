package com.wd.car_rental.util.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :刘先森
 * @version :1.0
 * @PROJECT_NAME :普通话和方言语料库
 * @description : 返回数据的封装
 * @date :2020-02-19 12:35
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private int code;//状态码
    private String message;//消息
    private Object data;//数据
    private Map<String,Object> map; //多数据返回时
    /**
     * 成功 默认 Success 信息
     */
    public static Result getSuccessResult(){
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS);
        result.setMessage(ResultInfo.Success);
        return result;
    }

    /**
     * 成功 默认信息 自定义返回数据
     * @param data
     * 返回数据
     */
    public static Result getSuccessResult(Object data){
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS);
        result.setMessage(ResultInfo.Success);
        result.setData(data);
        return result;
    }

    /**
     * 成功 默认信息 自定义返回Map数据
     * @param map
     * 多数据封装类型
     * 返回数据
     */
    public static Result getSuccessResult(Map map){
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS);
        result.setMessage(ResultInfo.Success);result.setMap(map);
        return result;
    }

    /**
     * 成功 自定义信息 自定义返回Map数据
     * @param map
     * 多数据封装类型
     * 返回数据
     */
    public static Result getSuccessResult(String message,Map map){
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS);
        result.setMessage(ResultInfo.Success);
        result.setMap(map);
        result.setMessage(message);
        return result;
    }
    /**
     * 成功 自定义信息
     * @param message
     * 自定义信息
     */
    public static Result getSuccessResult(String message){
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS);
        result.setMessage(message);
        return result;
    }

    /**
     * 成功 自定义信息 自定义返回参数
     * @param message
     * 自定义信息
     * @param data
     * 返回数据
     */
    public static Result getSuccessResult(String message,Object data){
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    /**
     * 失败  附带系统繁忙信息
     */
    public static Result getFailResult(){
        Result result = new Result();
        result.setCode(ResultCode.FAIL);
        result.setMessage(ResultInfo.RunTimeError);
        return result;
    }

    /**
     * 失败 附带未知错误信息 附带数据
     */
    public static Result getFailResult(Object data){
        Result result = new Result();
        result.setCode(ResultCode.FAIL);
        result.setMessage(ResultInfo.UnknownError);
        result.setData(data);
        return result;
    }

    /**
     * 失败 附带自定义信息
     */
    public static Result getFailResult(String message){
        Result result = new Result();
        result.setCode(ResultCode.FAIL);
        result.setMessage(message);
        return result;
    }

    /**
     * 失败 附带自定义信息 附带数据
     */
    public static Result getFailResult(String message,Object data){
        Result result = new Result();
        result.setCode(ResultCode.FAIL);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    /**
     * 账号过期
     */
    public static Result getUnauthorizedError() {
        Result result = new Result();
        result.setCode(ResultCode.UNAUTHORIZED);
        result.setMessage(ResultInfo.Unauthorized);
        return result;
    }


    /**
     * 自定义信息
     * @param code
     * 自定义编码
     * @param message
     * 自定义信息
     * @param data
     * 返回数据
     */
    public static Result getFreeResult(int code,String message,Object data){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static Result getSystemErrorResult(){
        Result result = new Result();
        result.setCode(ResultCode.FAIL);
        result.setMessage(ResultInfo.RunTimeError);
        return result;
    }

}
