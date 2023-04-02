package com.zxt.helper.controller;

import io.swagger.annotations.Api;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author:TanXiao
 * @date:2023/3/21
 */
@RestController
@RequestMapping("/tess")
@Api(tags = "image")
public class TessController {

    @Autowired
    private Tess4jClient tess4jClient;


    @GetMapping("/image")
    public String getImages() throws IOException, TesseractException {
        File file = new File("D:\\a\\ocr.jpg");
        System.out.println(file.length());
        FileInputStream in = new FileInputStream(file);
        BufferedImage imageFile = ImageIO.read(in);
        Tess4jClient tess4jClient = new Tess4jClient();
        String result = tess4jClient.doOCR(imageFile);
        System.out.println(result);
        return result;
    }
}
