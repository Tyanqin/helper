package com.zxt.helper.common.exception.token;

import com.zxt.helper.common.constant.RestCodeConstants;
import com.zxt.helper.common.exception.BaseException;

/**
 * token无效异常
 * @author:TanXiao
 * @date:2023/3/24
 */
public class TokenInvalidException extends BaseException {
    public TokenInvalidException(){
        super(RestCodeConstants.EX_USER_INVALID_MESSAGE);
    }
}
