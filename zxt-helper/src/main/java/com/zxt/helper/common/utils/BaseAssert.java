package com.zxt.helper.common.utils;

import com.zxt.helper.common.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author:TanXiao
 * @date:2023/3/17
 */
@Slf4j
public  class BaseAssert {

    public static void isNull(@Nullable String str, @Nullable Supplier<BaseException> supplier){
        if (str == null || "".equals(str)) {
            throw  supplier.get();
        }
    }

    public static void isNull(@Nullable Object obj, @Nullable Supplier<BaseException> supplier) {
        if (null == obj || obj.toString().equals("")) {
            throw  supplier.get();
        }
    }

    public static void isEmpty(@Nullable Map<String,Object> map,@Nullable Supplier<BaseException> supplier){
        if ( null == map  || map.isEmpty()) {
            throw  supplier.get();
        }
    }

    public static void isEmpty(@Nullable List<Object> list, @Nullable Supplier<BaseException> supplier){
        if ( null == list  || list.isEmpty()) {
            throw  supplier.get();
        }
    }

    //不包含
    public static void isNotInclude(String str){

    }

    private BaseAssert(){}

}
