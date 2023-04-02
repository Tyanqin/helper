package com.zxt.helper.common.exception.file;

import com.zxt.helper.common.constant.RestCodeConstants;
import com.zxt.helper.common.exception.BaseException;

/**
 * 文件为空异常
 * @author:TanXiao
 * @date:2023/4/1
 */
public class FileNullException extends BaseException {
    public FileNullException(){
        super(RestCodeConstants.EX_FILE_CANNOT_BE_EMPTY_MESSAGE);
    }
}
