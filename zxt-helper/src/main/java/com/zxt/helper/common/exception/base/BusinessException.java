package com.zxt.helper.common.exception.base;

import com.zxt.helper.common.exception.BaseException;

/**
 * 基础异常类
 * @author:TanXiao
 * @date:2023/3/17
 */
public class BusinessException extends BaseException {
    public BusinessException(String message){
        super(message);
    }
}
