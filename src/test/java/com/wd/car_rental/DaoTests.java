package com.wd.car_rental;

import com.wd.car_rental.dao.CarMapper;
import com.wd.car_rental.entry.Car;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 刘广运
 * @version 1.0
 * @date 2021/1/4 11:22 上午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class DaoTests {
    private String carNum = "123456";

    @Autowired
    private CarMapper carMapper;

    @Before
    public void addData(){
        Car car = new Car();
        car.setCarNum(carNum);
        int i = carMapper.addNewCar(car);
        Assert.assertEquals("添加失败",1,i);
    }

    @After
    public void deleteData(){
        Car car = carMapper.selectByCarNum(carNum);
        int i = carMapper.deleteByPrimaryId(car.getCarId());
        Assert.assertEquals("删除失败",1,i);
    }

    @Test
    public void testAddNewCar(){
        Car car1 = carMapper.selectByCarNum(carNum);
        Assert.assertEquals("出现异常",carNum,car1==null?"":car1.getCarNum()+"12");
    }
}
