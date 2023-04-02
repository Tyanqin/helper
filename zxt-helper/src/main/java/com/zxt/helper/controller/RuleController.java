package com.zxt.helper.controller;

import com.zxt.helper.Annotation.PassToken;
import com.zxt.helper.common.msg.ObjectRestResponse;
import com.zxt.helper.service.SupervisionRulesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.io.RandomAccessBuffer;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author:TanXiao
 * @date:2023/3/29
 */
@Slf4j
@RestController
@RequestMapping("/rule")
@Api(tags=" rule  controller ")
public class RuleController {





    @PassToken
    @PostMapping("/upload")
    @ApiOperation(value = "上传文件", notes = "请查看Models数据字典")
    public ObjectRestResponse upload(@RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String newFileName = System.currentTimeMillis() + "." + StringUtils.substringAfterLast(fileName, ".");
        StringBuilder content = new StringBuilder();
        FileOutputStream output = null;
        InputStream inputStream = null;
        PDDocument document = null;
        try {
            inputStream = file.getInputStream();
            output = new FileOutputStream("D:\\a\\ocr.txt");
            PDFParser parser = new PDFParser(new RandomAccessBuffer(inputStream));
            parser.parse();
            document = parser.getPDDocument();
            // 获取页码
            int pages = document.getNumberOfPages();
            log.error("文件页码为：" + pages);
            PDFTextStripper stripper = new PDFTextStripper();
            stripper.setSortByPosition(true);
            stripper.setStartPage(1);
            stripper.setEndPage(1);
            int endPage = stripper.getEndPage();
            content.append(stripper.getText(document));
            output.write(content.toString().getBytes("UTF-8"));
            return new ObjectRestResponse().message("上传成功！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();
                inputStream.close();
                document.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return new ObjectRestResponse().message("上传失败！");
    }

    @Autowired
    private SupervisionRulesService sr;






//    @PassToken
//    @PostMapping("/uploadPDF")
//    @ApiOperation(value = "上传文件", notes = "请查看Models数据字典")
//    public ObjectRestResponse uploadPDF(@RequestParam("file") MultipartFile file) {
//        InputStream inputStream = null;
//        FileOutputStream outputStream = null;
//        try {
//            inputStream = file.getInputStream();
//            outputStream = new FileOutputStream("D:\\a\\ocr.txt");
//            String data = PDFUtil.readRectangle(inputStream);
//            outputStream.write(data.getBytes("UTF-8"));
//            return new ObjectRestResponse().message("上传成功！");
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                outputStream.close();
//                inputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            return new ObjectRestResponse().message("上传失败！");
//        }
//    }
}