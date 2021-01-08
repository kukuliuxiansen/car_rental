package com.wd.car_rental;

import com.wd.car_rental.dao.CarMapper;
import com.wd.car_rental.dao.OrderMapper;
import com.wd.car_rental.dao.UserMapper;
import com.wd.car_rental.entry.Car;
import com.wd.car_rental.entry.Order;
import com.wd.car_rental.entry.User;
import com.wd.car_rental.util.enumpk.RentalStateEnum;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 刘广运
 * @version 1.0
 * @date 2021/1/7 10:54 上午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CarDaoTests {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private CarMapper carMapper;

    @Autowired
    private UserMapper userMapper;
    String account = "123";
    String password = "123";
    String carNum = "123456";
    @Before
    public void addDate() {
        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        userMapper.addNewUser(user);
        user = userMapper.selectByAccountAndPassword(account, password);
        Car car = new Car();
        car.setCarNum(carNum);
        carMapper.addNewCar(car);
        car = carMapper.selectByCarNum(carNum);
        Order order = new Order();
        order.setUserId(user.getUserId());
        order.setCarId(car.getCarId());
        orderMapper.insert(order);
    }

    @After
    public void deleteDate() {
        User user = userMapper.selectByAccountAndPassword(account, password);
        Car car = carMapper.selectByCarNum(carNum);
        Order order = orderMapper.selectByUserIdAndCarIdAndRentalStateEqualsOne(user.getUserId(),car.getCarId(), RentalStateEnum.IN_RENTAL_STATE.getCode());
        userMapper.deleteByPrimaryId(user.getUserId());
        orderMapper.deleteByPrimaryKey(order.getCarId());
        carMapper.deleteByPrimaryId(car.getCarId());
    }

    @Test
    public void test() {
        User user = userMapper.selectByAccountAndPassword(account, password);
        Car car = carMapper.selectByCarNum(carNum);
        Order order = orderMapper.selectByUserIdAndCarIdAndRentalStateEqualsOne(user.getUserId(),car.getCarId(), RentalStateEnum.IN_RENTAL_STATE.getCode());
        order = orderMapper.selectByPrimaryKey(order.getOrderId());
        System.out.println(order.toString());
    }
}
