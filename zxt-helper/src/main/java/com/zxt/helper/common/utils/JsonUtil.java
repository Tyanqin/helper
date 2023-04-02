package com.zxt.helper.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zxt.helper.common.exception.param.ParameterInvalidException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.json.JsonParseException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * JSON工具类
 * @author:TanXiao
 * @date:2023/3/17
 */
@Slf4j
@Component
public final class JsonUtil<Entity> {

    public static JSONObject mapToJson(Map<String,Object> maps){
        try{
            return JSONObject.parseObject(JSON.toJSONString(maps));
        }catch( JsonParseException e){
             throw  new ParameterInvalidException();
        }
    }

    public  Entity jsonToObj(JSONObject jsonObject,Class<Entity> clazz){
        return   JSONObject.parseObject(jsonObject.toString(),clazz);
    }

    public static Map<String,Object> objToMap(Object obj){
        String s = JSONObject.toJSONString(obj);
        Map<String,Object> map = JSONObject.parseObject(s);
        return map;
    }

    /**
     *
     * @param value
     * @param clazz
     * @return
     */
    public List<Entity> mapToObject(List<Map<String,Object>> value,Class<Entity> clazz){
       List<Entity> entityList = new ArrayList<>();
        for (Map<String, Object> map : value) {
            String str = JSONObject.toJSONString(map);
            Entity entity = JSONObject.parseObject(str, clazz);
            entityList.add(entity);
        }
       log.info("");
        return entityList;
    }

    /**
     *
     * @param value
     * @param clazz
     * @return
     */
    public Entity mapToObject(Map<String,Object> value,Class<Entity> clazz){
            String str = JSONObject.toJSONString(value);
            Entity entity = JSONObject.parseObject(str, clazz);
        return entity;
    }



//    Student student = new Student();
//        student.setName("张三");
//        student.setAge(1);
//
//    //对象->json
//    String json = JSONObject.toJSONString(student);
//        System.out.println("对象->json = " + json);
//
//    //json->map
//    Map<String,Object> map = JSONObject.parseObject(json);
//        System.out.println("json->map = " + map);
//
//    //map-->json
//    String json1 = JSONObject.toJSONString(map);
//        System.out.println("map-->json = " + json1);
//
//    //json-->对象
//    Student student2 = JSONObject.parseObject(json1, Student.class);
//        System.out.println("json-->对象 = " + student2);


}
