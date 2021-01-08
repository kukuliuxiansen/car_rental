package com.wd.car_rental.entry;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private Long orderId;

    private Long userId;

    private Long carId;

    private Integer rentalState;

    private Date addTime;

    private Date endTime;

    private Car car;

    private static final long serialVersionUID = 1L;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Integer getRentalState() {
        return rentalState;
    }

    public void setRentalState(Integer rentalState) {
        this.rentalState = rentalState;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", orderId=").append(orderId);
        sb.append(", userId=").append(userId);
        sb.append(", carId=").append(carId);
        sb.append(", rentalState=").append(rentalState);
        sb.append(", addTime=").append(addTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", car=").append(car.toString());
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}