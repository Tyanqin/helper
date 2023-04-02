package com.zxt.helper.common.exception.login;

import com.zxt.helper.common.constant.RestCodeConstants;
import com.zxt.helper.common.exception.BaseException;

/**
 * 用户密码错误异常
 * @author:TanXiao
 * @date:2023/3/17
 */
public class UserPasswordException  extends BaseException {
    public UserPasswordException(){
        super(RestCodeConstants.EX_USER_PASSWORD_MESSAGE);
    }
}
