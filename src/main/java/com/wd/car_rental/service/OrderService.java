package com.wd.car_rental.service;

import com.wd.car_rental.dao.CarMapper;
import com.wd.car_rental.dao.OrderMapper;
import com.wd.car_rental.entry.Car;
import com.wd.car_rental.entry.Order;
import com.wd.car_rental.entry.User;
import com.wd.car_rental.util.enumpk.RentalStateEnum;
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
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private CarMapper carMapper;

    @Transactional(rollbackFor = Exception.class)
    public void addOrderToRenTalCar(Order order, User user) {
        BusinessAssert.isTrue(user!=null, ResultInfo.Unauthorized);
        Car car = carMapper.selectByPrimaryKey(order.getCarId());
        BusinessAssert.isTrue(car!=null,ResultInfo.RunTimeError);
        BusinessAssert.isTrue(car.getRentalState()!=RentalStateEnum.IN_RENTAL_STATE.getCode(),"该车已被租用，请选择其他车辆");
        order.setUserId(user.getUserId());
        orderMapper.insert(order);
        carMapper.updateRentalStateByPrimaryKey(order.getCarId(), RentalStateEnum.IN_RENTAL_STATE.getCode());
    }
}
