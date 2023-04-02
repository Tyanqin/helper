package com.zxt.helper.dao;

import com.zxt.helper.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;

/**
 * @author:TanXiao
 * @date:2023/3/17
 */
@Repository
@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends Mapper<User> {
    public HashMap<String,Object> login(@Param("userName")String userName, @Param("password")String password);
}
