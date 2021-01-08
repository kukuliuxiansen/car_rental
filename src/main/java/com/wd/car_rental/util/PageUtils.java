package com.wd.car_rental.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 刘广运
 * @version 1.0
 * @date 2021/1/4 3:59 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageUtils {
    private int page;
    private int pageSize;
}
