package com.zxt.helper.common.exception;

import com.zxt.helper.common.constant.RestCodeConstants;

/**
 * 查询结果异常
 * @author:TanXiao
 * @date:2023/3/30
 */
public class SelectResultException extends BaseException {
    public SelectResultException(){
        super(RestCodeConstants.EX_SELECT_RESULT_MESSAGE);
    }
}
