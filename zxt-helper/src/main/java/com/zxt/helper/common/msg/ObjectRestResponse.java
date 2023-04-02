package com.zxt.helper.common.msg;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author:TanXiao
 * @date:2023/3/17
 */
@Data
@Accessors(chain = true)
public class ObjectRestResponse<T> extends BaseResponse {

    private T data;

    public ObjectRestResponse data(T data){
        this.setData(data);
        return this;
    }
    public ObjectRestResponse message(String message){
        this.setMessage(message);
        return this;
    }

}
