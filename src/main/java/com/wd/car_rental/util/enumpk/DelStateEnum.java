package com.wd.car_rental.util.enumpk;

import com.wd.car_rental.util.exception.BusinessException;

/**
 * @author 刘广运
 * @version 1.0
 * @date 2020/12/31 5:08 下午
 */
public enum DelStateEnum {
    OPEN_STATE(1,"正常"),
    STOP_STATE(2,"异常");

    private int code;
     private String stateValue;

    public int getCode() {
        return code;
    }

    public String getStateValue() {
        return stateValue;
    }

    DelStateEnum(int code, String stateValue) {
        this.code = code;
        this.stateValue = stateValue;
    }

    public static DelStateEnum getStateByCode(Integer code){
        DelStateEnum[] values = DelStateEnum.values();
        for (int i = 0; i < values.length; i++) {
            if(values[i].getCode()==code){
                return values[i];
            }
        }
        throw new BusinessException("请传入正确的状态参数。");
    }
}
