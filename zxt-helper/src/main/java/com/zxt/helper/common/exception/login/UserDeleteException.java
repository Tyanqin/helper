package com.zxt.helper.common.exception.login;

import com.zxt.helper.common.constant.RestCodeConstants;
import com.zxt.helper.common.exception.BaseException;

/**
 * 用户被删除异常
 * @author:TanXiao
 * @date:2023/3/17
 */
public class UserDeleteException extends BaseException {
    public UserDeleteException(){
        super(RestCodeConstants.EX_USER_DELETE_MESSAGE);
    }
}
