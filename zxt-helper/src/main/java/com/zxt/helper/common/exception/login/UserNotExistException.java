package com.zxt.helper.common.exception.login;

import com.zxt.helper.common.constant.RestCodeConstants;
import com.zxt.helper.common.exception.BaseException;

/**
 * @author:TanXiao
 * @date:2023/3/17
 */
public class UserNotExistException extends BaseException {
    public UserNotExistException(){
        super(RestCodeConstants.EX_USER_DOSE_NOT_EXIST_MESSAGE);
    }
}
