package com.zxt.helper.common.exception.login;

import com.zxt.helper.common.constant.RestCodeConstants;
import com.zxt.helper.common.exception.BaseException;

/**
 * 用户已存在异常
 * @author:TanXiao
 * @date:2023/3/17
 */
public class UserExistException extends BaseException {
    public UserExistException(){
        super(RestCodeConstants.EX_USER_EXIST_MESSAGE);
    }
}
