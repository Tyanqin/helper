package com.zxt.helper.common.exception.login;

import com.zxt.helper.common.constant.RestCodeConstants;
import com.zxt.helper.common.exception.BaseException;

/**
 * 用户冻结异常
 * @author:TanXiao
 * @date:2023/3/17
 */
public class UserFreezeException extends BaseException {
    public UserFreezeException(){
        super(RestCodeConstants.EX_USER_FREEZE_MESSAGE);
    }
}
