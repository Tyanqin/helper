package com.zxt.helper.common.exception.param;

import com.zxt.helper.common.constant.RestCodeConstants;
import com.zxt.helper.common.exception.BaseException;

/**
 * @author:TanXiao
 * @date:2023/3/25
 */
public class ParameterInvalidException extends BaseException {
    public ParameterInvalidException(){
        super(RestCodeConstants.INVALID_PARAMETER_MESSAGE);
    }
}
