package com.wd.car_rental.util.result;

/**
 * @author :刘先森
 * @version :1.0
 * @PROJECT_NAME :普通话和方言语料库
 * @description : 常用返回信息
 * @date :2020-02-18 15:40
 **/
public class ResultInfo {
    public final static String Success = "操作成功";
    public final static String LoginError = "请输入正确的账号密码。";
    public final static String SendCodeSuccess = "验证码已发送，有效期30分钟。";
    public final static String CheckPhoneError = "您输入的手机号不正确。";
    public final static String CheckEmailError = "您输入的邮箱号不正确。";
    public final static String RepeatPhoneError= "该手机号已被注册。";
    public final static String RepeatEmailError= "该邮箱号已被注册。";
    public final static String RepeatAccountNameError= "该账号已被注册。";
    public final static String CheckCodeError="您输入的验证码不正确！";
    public final static String CodeMissedError="验证码已失效。";
    public final static String RunTimeError = "系统繁忙，请稍后重试。";
    public final static String UnknownError = "未知错误。";
    public final static String Unauthorized = "您未登录或账号已过期,请重新登陆。";
    public final static String AccountNotPower = "账号存在违规，已被禁用。";
    public final static String RepeatVoice= "该发音员以上传过该音频，请勿重复上传。";
}
