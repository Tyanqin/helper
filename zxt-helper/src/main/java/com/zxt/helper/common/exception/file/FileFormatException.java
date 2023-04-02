package com.zxt.helper.common.exception.file;

import com.zxt.helper.common.constant.RestCodeConstants;
import com.zxt.helper.common.exception.BaseException;

/**
 * 文件格式错误
 * @author:TanXiao
 * @date:2023/4/1
 */
public class FileFormatException extends BaseException {
    public FileFormatException(){
        super(RestCodeConstants.EX_FILE_FORMAT_MESSAGE);
    }
}
