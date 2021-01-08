package com.wd.car_rental.controller;

import com.github.pagehelper.PageInfo;
import com.wd.car_rental.entry.Car;
import com.wd.car_rental.service.CarService;
import com.wd.car_rental.util.PageUtils;
import com.wd.car_rental.util.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 刘广运
 * @version 1.0
 * @date 2020/12/30 5:38 下午
 */
@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    /**
     * 管理员添加车辆信息
     * @param car 车辆信息
     * @return
     */
    @PostMapping("/add")
    public Result addCar(@RequestBody Car car){
        carService.addCar(car);
        return Result.getSuccessResult();
    }

    /**
     * 修改车的禁用状态
     * @param delState 需要调整的状态  1：正常  2：被禁用
     * @param  carId 被修改状态的车辆ID
     * @return
     */
    @GetMapping("/changeDelState")
    public Result changeCarDelState(Integer delState,Long carId){
        carService.changeCarDelState(delState,carId);
        return Result.getSuccessResult();
    }

    /**
     * 管理员查看全部的车辆信息
     * @return
     */
    @GetMapping("/allList")
    public Result allList(@RequestBody PageUtils pageUtils){
        PageInfo<Car> pageInfo= carService.getAllList(pageUtils);
        return Result.getSuccessResult(pageInfo);
    }

    /**
     * 获得未禁用的车辆信息
     * @param pageUtils
     * @return
     */
    @GetMapping("/availableCarList")
    public Result availableCarList(@RequestBody PageUtils pageUtils){
        PageInfo<Car> pageInfo = carService.getAvailableCarList(pageUtils);
        return Result.getSuccessResult(pageInfo);
    }

    /**
     * 获取未禁用车辆的总数
     * @return
     */
    @GetMapping("/availableCarCount")
    public Result availableCarCount(){
        Integer count = carService.getAvailableCarCount();
        return Result.getSuccessResult(count);
    }


    /**
     * 查看可租车辆总数
     * @return
     */
    @GetMapping("/notRentalCarCount")
    public Result notRentalCarCount(){
        Integer count = carService.getNotRentalCarCount();
        return Result.getSuccessResult(count);
    }








}
