package com.wd.car_rental.dao;

import com.wd.car_rental.entry.Car;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarMapper {
    @Update({
            "update car ",
            "set ",
            "delState = #{delState,jdbcType=INTEGER},",
            "where `carId` = #{ carId,jdbcType=BIGINT}"
    })
    int updateDelStateByPrimaryKey(@Param("carId") Long carId,@Param("delState") int delState);

    @Insert({
        "insert into car (carNum) ",
        "values ( #{carNum,jdbcType=VARCHAR} ",
        ")"
    })
    int addNewCar(Car record);

    @Select({
        "select",
        "`carId`, carNum, rentalState, delState, addTime",
        "from car",
        "where `carId` = #{ carId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="carId", property="carId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="carNum", property="carNum", jdbcType=JdbcType.VARCHAR),
        @Result(column="rentalState", property="rentalState", jdbcType=JdbcType.INTEGER),
        @Result(column="delState", property="delState", jdbcType=JdbcType.INTEGER),
        @Result(column="addTime", property="addTime", jdbcType=JdbcType.TIMESTAMP)
    })
    Car selectByPrimaryKey(Long  carId);

//    @Select({
//        "select",
//        "`carId`, carNum, rentalState, delState, addTime",
//        "from car"
//    })
//    @Results({
//        @Result(column="carId", property="carId", jdbcType=JdbcType.BIGINT, id=true),
//        @Result(column="carNum", property="carNum", jdbcType=JdbcType.VARCHAR),
//        @Result(column="rentalState", property="rentalState", jdbcType=JdbcType.INTEGER),
//        @Result(column="delState", property="delState", jdbcType=JdbcType.INTEGER),
//        @Result(column="addTime", property="addTime", jdbcType=JdbcType.TIMESTAMP)
//    })
    List<Car> selectAll();

    @Update({
        "update car",
        "set carNum = #{carNum,jdbcType=VARCHAR},",
          "rentalState = #{rentalState,jdbcType=INTEGER},",
          "delState = #{delState,jdbcType=INTEGER},",
          "addTime = #{addTime,jdbcType=TIMESTAMP}",
        "where `carId` = #{ carId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Car record);


    @Select({
            "select",
            "`carId`, carNum, rentalState, delState, addTime",
            "from car where carNum = #{carNum} "
    })
    Car selectByCarNum(String carNum);

    @Update({
            "update car",
            "set delState = #{delState,jdbcType=INTEGER} ",
            "where `carId` = #{ carId,jdbcType=BIGINT}"
    })
    int changeCarDelState(@Param("delState") Integer delState,@Param("carId") Long carId);

    @Delete({
            "delete from car",
            "where carId = #{carId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryId(@Param("carId") Long carId);


    @Select({
            "select",
            "`carId`, carNum, rentalState, delState, addTime",
            "from car where delState = 1 order by rentalState ASC"
    })
    @Results({
            @Result(column="carId", property="carId", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="carNum", property="carNum", jdbcType=JdbcType.VARCHAR),
            @Result(column="rentalState", property="rentalState", jdbcType=JdbcType.INTEGER),
            @Result(column="delState", property="delState", jdbcType=JdbcType.INTEGER),
            @Result(column="addTime", property="addTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Car> selectAvailableCarList();

    @Select("SELECT COUNT(*) FROM `car` WHERE delState = 1")
    Integer selectAvailableCarCount();

    @Select("SELECT COUNT(*) FROM `car` WHERE delState = 1 AND rentalState = 1")
    Integer getNotRentalCarCount();

    @Update({
            "update car ",
            "set ",
            "rentalSate = #{rentalSate,jdbcType=INTEGER},",
            "where `carId` = #{ carId,jdbcType=BIGINT}"
    })
    int updateRentalStateByPrimaryKey(@Param("carId") Long carId, @Param("") int rentalSate);
}