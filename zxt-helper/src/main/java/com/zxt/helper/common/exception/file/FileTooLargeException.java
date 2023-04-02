package com.zxt.helper.common.exception.file;

import com.zxt.helper.common.constant.RestCodeConstants;
import com.zxt.helper.common.exception.BaseException;

/**
 * 文件大小超过限制
 * @author:TanXiao
 * @date:2023/4/1
 */
public class FileTooLargeException extends BaseException {
    public FileTooLargeException(){
        super(RestCodeConstants.EX_FILE_TOO_LARGE_MESSAGE);
    }
}
