package com.zxt.helper.common.handler;

import com.zxt.helper.common.exception.BaseException;
import com.zxt.helper.common.exception.login.UserFreezeException;
import com.zxt.helper.common.exception.login.UserNotExistException;
import com.zxt.helper.common.exception.login.UserPasswordException;
import com.zxt.helper.common.msg.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @author:TanXiao
 * @date:2023/3/17
 */
@ControllerAdvice(value = "com.zxt.helper")
@ResponseBody
public class LoginExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(LoginExceptionHandler.class);

    /**
     * 当前用户不存在
     * @param response
     * @param ex
     * @return
     */
    @ExceptionHandler(UserNotExistException.class)
    public BaseResponse userNotExistException(HttpServletResponse response, BaseException ex){
        logger.error(ex.getMessage()+"123");
        response.setStatus(HttpStatus.FORBIDDEN.value());
        return new BaseResponse(ex.getStatus(),ex.getMessage());
    }

    /**
     * 用户密码错误
     * @param response
     * @param ex
     * @return
     */
    @ExceptionHandler(UserPasswordException.class)
    public BaseResponse userPasswordException(HttpServletResponse response, BaseException ex){
        logger.error(ex.getMessage());
        response.setStatus(HttpStatus.FORBIDDEN.value());
        return new BaseResponse(ex.getStatus(),ex.getMessage());
    }

    /**
     * 当前用户已被冻结
     * @param response
     * @param ex
     * @return
     */
    @ExceptionHandler(UserFreezeException.class)
    public BaseResponse userFreezeException(HttpServletResponse response, BaseException ex){
        logger.error(ex.getMessage());
        response.setStatus(HttpStatus.FORBIDDEN.value());
        return new BaseResponse(ex.getStatus(),ex.getMessage());
    }


}
