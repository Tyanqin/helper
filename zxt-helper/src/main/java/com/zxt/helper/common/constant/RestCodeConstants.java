package com.zxt.helper.common.constant;

/**
 * @author:TanXiao
 * @date:2023/3/17
 */
public class RestCodeConstants {
    /**
     * 参数异常
     */
    public static final String  INVALID_PARAMETER_MESSAGE = "参数无效！";
    public static final String  PARAMETER_CANNOT_BE_NULL = "参数不能为空！";

    /**
     *   用户登录异常
     */
    //该用户不存在
    public static final String EX_USER_DOSE_NOT_EXIST_MESSAGE = "该用户不存在！";
    //用户密码错误
    public static final String  EX_USER_PASSWORD_MESSAGE = "用户密码错误!";
    //用户被冻结
    public static final String  EX_USER_FREEZE_MESSAGE = "当前用户被冻结!";
    //该用户已存在
    public static final String  EX_USER_EXIST_MESSAGE = "该用户已存在!";
    //该用户被删除
    public static final String  EX_USER_DELETE_MESSAGE = "该用户被删除!";
    /**
     *    用户Token异常
     */
    //Token无效异常
    public static final String  EX_USER_INVALID_MESSAGE = "无效的token!";
    //Token被禁止异常
    public static final String  EX_USER_FORBIDDEN_MESSAGE = "该token已被禁止!";
    //token不存在
    public static final String  EX_TOKEN_DOES_NOT_EXIST = "token不存在,请进行登录！";


    //CRUD异常
    public static final String  EX_SELECT_RESULT_MESSAGE = "获取数据失败！";


    //文件异常
    public static final String  EX_FILE_CANNOT_BE_EMPTY_MESSAGE = "文件不能为空！";
    public static final String EX_FILE_FORMAT_MESSAGE = "文件格式错误！";
    public static final String EX_FILE_TOO_LARGE_MESSAGE = "文件大小超过限制！";

}
