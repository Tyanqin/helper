package com.zxt.helper.common.exception.param;

import com.zxt.helper.common.constant.RestCodeConstants;
import com.zxt.helper.common.exception.BaseException;

/**

 * @author:TanXiao
 * @date:2023/3/17
 */
public class ParamNullException extends BaseException {
    public ParamNullException(){
        super(RestCodeConstants.PARAMETER_CANNOT_BE_NULL);
    }
}
