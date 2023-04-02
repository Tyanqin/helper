package com.zxt.helper.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.pdfbox.io.RandomAccessBuffer;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.*;

/**
 * @author:TanXiao
 * @date:2023/3/21
 */
@Slf4j
public class Test {

    public static void main(String args[]) throws IOException {
        Test test = new Test();
        test.readToString("D:\\a\\testpdf.pdf");
//        test.readToString("D:\\a\\resouce.pdf");
    }

    public void readToString(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        File file = new File(filePath);
        FileInputStream in = new FileInputStream(file);
        PDFParser parser = new PDFParser(new RandomAccessBuffer(in));
        parser.parse();
        PDDocument document = parser.getPDDocument();
        // 获取页码
        int pages = document.getNumberOfPages();
        log.info("");
        PDFTextStripper stripper = new PDFTextStripper();
        // 设置按顺序输出
        stripper.setSortByPosition(true);
        stripper.setStartPage(1);
        stripper.setEndPage(pages);
        int endPage = stripper.getEndPage();
        content.append(stripper.getText(document));
        System.out.println("======>>>>>>　　　"+content.toString().getBytes());
    }








    public void imageTest(){
        File originalFile = new File("D:\\a\\image.jpg");//指定要读取的图片
        try {
            File result = new File("D:\\a\\imageRes.jpg");//要写入的图片
            if (result.exists()) {//校验该文件是否已存在
                result.delete();//删除对应的文件，从磁盘中删除
                result = new File("D:\\a\\imageRes.jpg");//只是创建了一个File对象，并没有在磁盘下创建文件
            }
            if (!result.exists()) {//如果文件不存在
                result.createNewFile();//会在磁盘下创建文件，但此时大小为0K
            }
            FileInputStream in = new FileInputStream(originalFile);
            FileOutputStream out = new FileOutputStream(result);// 指定要写入的图片
            int n = 0;// 每次读取的字节长度
            byte[] bb = new byte[1024];// 存储每次读取的内容
            while ((n = in.read(bb)) != -1) {
                out.write(bb, 0, n);// 将读取的内容，写入到输出流当中
            }
//执行完以上后，磁盘下的该文件才完整，大小是实际大小
            out.close();// 关闭输入输出流
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
