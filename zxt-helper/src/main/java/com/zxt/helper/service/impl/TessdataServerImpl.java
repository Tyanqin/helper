package com.zxt.helper.service.impl;

import com.zxt.helper.service.TessdataServer;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Repository;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author:TanXiao
 * @date:2023/3/21
 */
@Repository
public class TessdataServerImpl implements TessdataServer {
    @Override
    public boolean dosoc(String fileName) throws TesseractException, IOException {
        try {
            File file = new File(fileName);
            Tesseract tesseract = new Tesseract();
//            tesseract.setDatapath("E://work//Tesseract-OCR//tessdata");
            tesseract.setDatapath("C:\\Program Files (x86)\\Tesseract-OCR\\tessdata");
            tesseract.setLanguage("chi_sim");
            String result = tesseract.doOCR(file);
            writeObj(result);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public void writeObj(String result) throws IOException {
        String newFileName = "D:\\a\\ocr.txt";
        try {
            // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw
            /* 写入Txt文件 */
            File writename = new File(newFileName);// 相对路径，如果没有则要建立一个新的output。txt文件
            writename.createNewFile(); // 创建新文件
            BufferedWriter out = new BufferedWriter(new FileWriter(writename, true));
            out.write(result);
            System.out.println("写入成功！");
            out.flush(); // 把缓存区内容压入文件
            out.close(); // 最后记得关闭文件
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
