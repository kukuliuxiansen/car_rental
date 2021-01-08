package com.wd.car_rental.controller;

import com.wd.car_rental.entry.Order;
import com.wd.car_rental.entry.User;
import com.wd.car_rental.service.OrderService;
import com.wd.car_rental.util.Constant;
import com.wd.car_rental.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author 刘广运
 * @version 1.0
 * @date 2020/12/30 5:38 下午
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    protected OrderService orderService;
    @Autowired
    private HttpSession session;
    public Result addOrderToRenTalCar(Order order){
        User user = (User)session.getAttribute(Constant.token);
        orderService.addOrderToRenTalCar(order,user);
        return Result.getSuccessResult();
    }
}
