package com.zxt.helper.service;

import com.zxt.helper.common.Biz.BaseBiz;
import com.zxt.helper.common.utils.AESUtil;
import com.zxt.helper.dao.UserMapper;
import com.zxt.helper.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

/**
 * @author:TanXiao
 * @date:2023/3/17
 */
@Service
public class UserService extends BaseBiz<UserMapper, User> {

    @Autowired
    private UserMapper userMapper;

    public HashMap<String,Object> login(String userName, String password){
        return userMapper.login(userName,password);
    }


    public Integer register(User paramUser){
        try {
            byte[] encrypt = AESUtil.encrypt(paramUser.getPassword().getBytes());
           User user =  new User().setUserName(paramUser.getUserName()).setPassword(new String(encrypt)).setPermissionId("1");
            return userMapper.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
