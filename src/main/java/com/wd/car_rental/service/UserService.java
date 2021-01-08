package com.wd.car_rental.service;

import com.wd.car_rental.dao.UserMapper;
import com.wd.car_rental.entry.User;
import com.wd.car_rental.util.exception.BusinessAssert;
import com.wd.car_rental.util.result.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 刘广运
 * @version 1.0
 * @date 2020/12/30 5:39 下午
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User userLogin(String account, String password) {
        User user = userMapper.selectByAccountAndPassword(account , password);
        BusinessAssert.isTrue(user!=null,"请输入正确的账号或密码");
        return user;
    }

    @Transactional(rollbackFor = Exception.class)
    public void userReg(User user) {
        User sqlUser = userMapper.selectByAccount(user.getAccount());
        BusinessAssert.isTrue(sqlUser==null,"该账号已存在。");
        int n = userMapper.addNewUser(user);
        BusinessAssert.isTrue(n==1, ResultInfo.RunTimeError);
    }


}
