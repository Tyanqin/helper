package com.zxt.helper.common.exception.param;

import com.zxt.helper.common.constant.RestCodeConstants;
import com.zxt.helper.common.exception.BaseException;

/**
 * 容器参数为null
 * @author:TanXiao
 * @date:2023/3/17
 */
public class ParamEmptyException extends BaseException {
    public ParamEmptyException(){
        super(RestCodeConstants.PARAMETER_CANNOT_BE_NULL);
    }
}
