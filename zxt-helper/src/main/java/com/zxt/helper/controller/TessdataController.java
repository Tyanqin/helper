package com.zxt.helper.controller;

import com.alibaba.fastjson.JSONObject;
import com.zxt.helper.service.TessdataServer;
import io.swagger.annotations.Api;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @author:TanXiao
 * @date:2023/3/21
 */
@RestController
@RequestMapping("/tessdata")
@Api(tags=" ocr  controller ")
public class TessdataController {

    @Resource
    private TessdataServer server;

    @RequestMapping(method = RequestMethod.POST)
    public JSONObject tessdata(@RequestBody JSONObject get) throws TesseractException, IOException {
        JSONObject output = new JSONObject();
        String fileName = get.getString("fileName");
        Boolean flag = server.dosoc(fileName);
        if (flag) {
            output.put("msg", "succeed");
        } else {
            output.put("msg", "failed");
        }
        return output;
    }

}
