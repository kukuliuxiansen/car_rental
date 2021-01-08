package com.wd.car_rental.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wd.car_rental.dao.CarMapper;
import com.wd.car_rental.entry.Car;
import com.wd.car_rental.util.PageUtils;
import com.wd.car_rental.util.enumpk.DelStateEnum;
import com.wd.car_rental.util.exception.BusinessAssert;
import com.wd.car_rental.util.result.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 刘广运
 * @version 1.0
 * @date 2020/12/30 5:39 下午
 */
@Service
public class CarService {

    @Autowired
    private CarMapper carMapper;


    @Transactional(rollbackFor = Exception.class)
    public void addCar(Car car) {
        Car sqlCar=  carMapper.selectByCarNum(car.getCarNum());
        BusinessAssert.isTrue(sqlCar==null,"该车辆编号已被注册。");
        int n = carMapper.addNewCar(car);
        BusinessAssert.isTrue(n==1, ResultInfo.RunTimeError);
    }

    public void changeCarDelState(Integer delState,Long carId) {
        DelStateEnum.getStateByCode(delState);
        Car sqlCar = carMapper.selectByPrimaryKey(carId);
        BusinessAssert.isTrue(sqlCar!=null,"不存在该车辆。");
        int n = carMapper.changeCarDelState(delState,carId);
        BusinessAssert.isTrue(n==1, ResultInfo.RunTimeError);
    }

    public PageInfo<Car> getAllList(PageUtils pageUtils) {
        PageHelper.startPage(pageUtils.getPage(), pageUtils.getPageSize());
        List<Car> list = carMapper.selectAll();
        PageInfo<Car> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    public PageInfo<Car> getAvailableCarList(PageUtils pageUtils) {
        PageHelper.startPage(pageUtils.getPage(), pageUtils.getPageSize());
        List<Car> list = carMapper.selectAvailableCarList();
        PageInfo<Car> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    public Integer getAvailableCarCount() {
        return carMapper.selectAvailableCarCount();
    }

    public Integer getNotRentalCarCount() {
        return carMapper.getNotRentalCarCount();
    }
}
