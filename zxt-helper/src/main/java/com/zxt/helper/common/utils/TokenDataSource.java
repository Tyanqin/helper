package com.zxt.helper.common.utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:TanXiao
 * @date:2023/3/17
 */
@Component
public class TokenDataSource {

    private static final Map<String,Object> mapData = new HashMap<String,Object>();

    public  TokenDataSource append(String key,Object obj){
        mapData.put(key,obj);
        return this;
    }
    public  TokenDataSource appendObject(Map<String,Object> map){
        this.append("id",map.get("id"))
                .append("userName",map.get("userName"))
                .append("iphone",map.get("iphone"));
        return this;
    }
    public  Map<String,Object>   build(){
        return mapData;
    }
}
