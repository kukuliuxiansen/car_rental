package com.wd.car_rental.entry;

import java.io.Serializable;
import java.util.Date;

public class Car implements Serializable {
    private Long  carId;

    private String carNum;

    private Integer rentalState;

    private Integer delState;

    private Date addTime;

    private static final long serialVersionUID = 1L;

    public Long getCarId() {
        return  carId;
    }

    public void setCarId(Long  carId) {
        this. carId =  carId;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum == null ? null : carNum.trim();
    }

    public Integer getRentalState() {
        return rentalState;
    }

    public void setRentalState(Integer rentalState) {
        this.rentalState = rentalState;
    }

    public Integer getDelState() {
        return delState;
    }

    public void setDelState(Integer delState) {
        this.delState = delState;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(",  carId=").append( carId);
        sb.append(", carNum=").append(carNum);
        sb.append(", rentalState=").append(rentalState);
        sb.append(", delState=").append(delState);
        sb.append(", addTime=").append(addTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}