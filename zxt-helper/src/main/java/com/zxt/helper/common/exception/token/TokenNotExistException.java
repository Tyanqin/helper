package com.zxt.helper.common.exception.token;

import com.zxt.helper.common.constant.RestCodeConstants;
import com.zxt.helper.common.exception.BaseException;

/**
 * token不存在异常
 * @author:TanXiao
 * @date:2023/3/24
 */
public class TokenNotExistException extends BaseException {
    public TokenNotExistException(){
        super(RestCodeConstants.EX_TOKEN_DOES_NOT_EXIST);
    }
}
