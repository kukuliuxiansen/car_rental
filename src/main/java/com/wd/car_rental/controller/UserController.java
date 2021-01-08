package com.wd.car_rental.controller;

import com.wd.car_rental.entry.User;
import com.wd.car_rental.service.UserService;
import com.wd.car_rental.util.Constant;
import com.wd.car_rental.util.exception.BusinessAssert;
import com.wd.car_rental.util.result.Result;
import com.wd.car_rental.util.result.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * @author 刘广运
 * @version 1.0
 * @date 2020/12/30 5:36 下午
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private HttpSession session;

    /**
     * 获取已登陆用户信息
     * @return
     */
    @GetMapping("/loginInfo")
    public Result LoginInfo(){
        User user = (User)session.getAttribute(Constant.token);
        BusinessAssert.isTrue(user!=null, ResultInfo.Unauthorized);
        return Result.getSuccessResult(user);
    }

    /**
     * 用户登陆
     * @param account 账号
     * @param password 密码
     * @return
     */
    @PostMapping("/login")
    public Result userLogin(String account, String password) {
        User user = userService.userLogin(account, password);
        session.setAttribute(Constant.token,user);
        return Result.getSuccessResult(user);
    }

    /**
     * 用户注册
     * @param user 用户注册信息
     * @return
     */
    @PostMapping("/reg")
    public Result userReg(@RequestBody User user) {
        userService.userReg(user);
        return Result.getSuccessResult();
    }

    /**
     * 用户注销登陆  （清除session）
     * @return
     */
    @RequestMapping("/logout")
    public Result userLogout(){
        session.removeAttribute(Constant.token);
        return Result.getSuccessResult();
    }

}
