package com.wd.car_rental.util.result;


/**
 * 自定义响应码
 * @author :刘先森
 * @version :1.0
 * @PROJECT_NAME :普通话和方言语料库
 * @description : 响应码，部分参考HTTP状态码的语义,主要是为了前端方便识别返回结果
 * @date :2020-02-18 14:57
 *
 * 参考 https://blog.csdn.net/OrangeChenZ/article/details/86468642
 */
public class ResultCode {
    /**
     * 系统正常运行，且返回参数符合预期
     */
    public static int SUCCESS = 200;//成功

    /**
     * 系统正常运行，但返回值非预期值
     * 例如： 登陆失败  手机号已被注册，存在异常等
     * 属于用户不希望得到得的结果
     *
     *  PS  : http自定义的响应码 400 指的是传入参数不符合Controller所定义的
     * 与其有所不同，注意区分
     * 如果出现http 400 错误，会跳转至 error/400.html
     */
    public static int FAIL = 400;//失败

    /**
     * 系统正常运行，Session过期失效，导致部分功能无法完成
     * 例如 ：用户修改个人信息，但是Session已过期，无法获取其ID值进行修改
     * 或者管理员session 已过期
     */
    public static int UNAUTHORIZED = 401;//未认证（签名错误）

    /**
     * 系统正常运行，但是访问的URL存在错误信息，导致无法访问
     */
    public static int NOT_FOUND = 404;//接口不存在

    /**
     * 系统内部出现错误，但系统没有崩溃，仍可以运行
     * 一般为用户并发量过大，导致部分用户不能正常操作
     * 提示：系统繁忙
     */
    public static int SYSTEM_ERROR = 500;//系统内部错误
}