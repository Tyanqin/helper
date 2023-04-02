package com.zxt.helper.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

/**
 * @author:TanXiao
 * @date:2023/3/17
 */
@Component
public class TokenEncryptUtils {
    //生成token
    public  static   String genToken(){
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static String getToken(Map<String,Object> map) {
        String token="";
        token= JWT.create().withAudience(String.valueOf(map.get("id"))).sign(Algorithm.HMAC256(map.get("password").toString()));
        return token;
    }
}
