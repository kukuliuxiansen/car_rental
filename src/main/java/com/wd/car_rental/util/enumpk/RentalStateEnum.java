package com.wd.car_rental.util.enumpk;

import com.wd.car_rental.util.exception.BusinessException;

/**
 * @author 刘广运
 * @version 1.0
 * @date 2020/12/31 5:08 下午
 */
public enum RentalStateEnum {
    IN_RENTAL_STATE(1,"出租中"),
    NOT_RENTAL_STATE(2,"未出租");

    private int code;
     private String stateValue;

    public int getCode() {
        return code;
    }

    public String getStateValue() {
        return stateValue;
    }

    RentalStateEnum(int code, String stateValue) {
        this.code = code;
        this.stateValue = stateValue;
    }

    public static RentalStateEnum getStateByCode(Integer code){
        RentalStateEnum[] values = RentalStateEnum.values();
        for (int i = 0; i < values.length; i++) {
            if(values[i].getCode()==code){
                return values[i];
            }
        }
        throw new BusinessException("请传入正确的状态参数。");
    }
}
