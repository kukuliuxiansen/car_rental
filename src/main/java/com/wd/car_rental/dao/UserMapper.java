package com.wd.car_rental.dao;

import com.wd.car_rental.entry.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    @Insert({
            "insert into user ( account, ",
            "`password`)",
            "values ( #{account,jdbcType=VARCHAR}, ",
            "#{password,jdbcType=VARCHAR})"
    })
    int addNewUser(User record);

    @Select({
            "select",
            "userId, account, `password`, addTime",
            "from user"
    })
    @Results({
            @Result(column="userId", property="userId", jdbcType=JdbcType.BIGINT),
            @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="addTime", property="addTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<User> selectAll();

//    @Select({
//            "select",
//            "userId, account, `password`, addTime",
//            "from user ",
//            "where account = #{account} and password = #{password}"
//    })
    User selectByAccountAndPassword(@Param("account") String account,@Param("password") String password);

    @Select({
            "select",
            "userId, account, `password`, addTime",
            "from user ",
            "where account = #{account} "
    })
    User selectByAccount(String account);

    @Delete({
            "delete from user",
            "where userId = #{userId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryId(Long userId);
}