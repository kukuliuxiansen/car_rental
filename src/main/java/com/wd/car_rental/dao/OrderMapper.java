package com.wd.car_rental.dao;

import com.wd.car_rental.entry.Order;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {
    @Delete({
        "delete from `order` ",
        "where orderId = #{orderId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long orderId);

    @Insert({
        "insert into `order` ( userId, ",
        "carId)",
        "values (#{userId,jdbcType=BIGINT}, ",
        "#{carId,jdbcType=BIGINT})"
    })
    int insert(Order record);

//    @Select({
//            "select",
//            "orderId, userId, carId, rentalState, addTime, endTime",
//            "from order",
//            "where orderId = #{orderId,jdbcType=BIGINT}"
//    })
//    @Results({
//            @Result(column="orderId", property="orderId", jdbcType=JdbcType.BIGINT, id=true),
//            @Result(column="userId", property="userId", jdbcType=JdbcType.BIGINT),
//            @Result(column="carId", property="carId", jdbcType=JdbcType.BIGINT),
//            @Result(column="rentalState", property="rentalState", jdbcType=JdbcType.INTEGER),
//            @Result(column="addTime", property="addTime", jdbcType=JdbcType.TIMESTAMP),
//            @Result(column="endTime", property="endTime", jdbcType=JdbcType.TIMESTAMP)
//    })
    Order selectByPrimaryKey(@Param("orderId") Long orderId);

    @Select({
        "select",
        "orderId, userId, carId, rentalState, addTime, endTime",
        "from `order`"
    })
    @Results({
        @Result(column="orderId", property="orderId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="userId", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="carId", property="carId", jdbcType=JdbcType.BIGINT),
        @Result(column="rentalState", property="rentalState", jdbcType=JdbcType.INTEGER),
        @Result(column="addTime", property="addTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="endTime", property="endTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Order> selectAll();

    @Update({
        "update `order` ",
        "set userId = #{userId,jdbcType=BIGINT},",
          "carId = #{carId,jdbcType=BIGINT},",
          "rentalState = #{rentalState,jdbcType=INTEGER},",
          "addTime = #{addTime,jdbcType=TIMESTAMP},",
          "endTime = #{endTime,jdbcType=TIMESTAMP}",
        "where orderId = #{orderId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Order record);

    Order selectByUserIdAndCarIdAndRentalStateEqualsOne(@Param("userId") Long userId,@Param("carId") Long carId,@Param("rentalState") Integer rentalState);
}