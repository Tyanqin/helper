//package com.zxt.helper.common.utils;
//
//import lombok.SneakyThrows;
//import org.apache.pdfbox.io.RandomAccessFile;
//import org.apache.pdfbox.pdfparser.PDFParser;
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.pdmodel.PDPage;
//import org.apache.pdfbox.text.PDFTextStripper;
//import org.apache.pdfbox.text.PDFTextStripperByArea;
//
//import java.awt.*;
//import java.awt.geom.Rectangle2D;
//import java.io.*;
//
///**
// * @author:TanXiao
// * @date:2023/3/29
// */
//public class PDFUtils {
//
//    public static String readRectangle(InputStream in) throws Exception {
//        PDDocument doc = PDDocument.load(in);
//        // 这个四边形所在区域在 y轴向下为正，x轴向右为正。
//        int x = 135;
//        int y = 300;
//        int width = 150;
//        int height = 150;
//        PDFTextStripperByArea stripper = new PDFTextStripperByArea();
//        stripper.setSortByPosition(true);
//        // 划定区域
//        Rectangle2D rect = new Rectangle(x, y, width, height);
//        stripper.addRegion("area", rect);
//        PDPage page = doc.getPage(1);
//        stripper.extractRegions(page);
//        // 获取区域的text
//        String data = stripper.getTextForRegion("area");
//        data = data.trim();
//        doc.close();
//        return data;
//
//    }
//
//   @SneakyThrows(Exception.class)
//    public static void readRectangle()  {
//        String filePath = "D:\\a\\1.变压器全过程技术监督精益化管理实施细则1121.pdf";
//        File file = new File(filePath);
//        PDDocument doc = PDDocument.load(file);
//        // 这个四边形所在区域在 y轴向下为正，x轴向右为正。
//        int x = 100;
//        int y = 100;
//        int width = 250;
//        int height = 250;
//        PDFTextStripperByArea stripper = new PDFTextStripperByArea();
//        stripper.setSortByPosition(true);
//        // 划定区域
//        Rectangle2D rect = new Rectangle(x, y, width, height);
//        stripper.addRegion("area", rect);
//        PDPage page = doc.getPage(1);
//        stripper.extractRegions(page);
//        // 获取区域的text
//        String data = stripper.getTextForRegion("area");
//        data = data.trim();
//        System.out.println("=====>>>>>>   "+data);
//        doc.close();
//    }
//
//
//
//
//    /**
//     * 用来读取pdf文件
//     * @param filePath
//     * @return
//     * @throws Exception
//     */
//    public static String readPDF(String filePath) {
//        String buffer = "";
//        try{
//            File input = new File(filePath);
//            if (input != null && input.exists()) {
//                PDDocument pd = PDDocument.load(input);
//                pd.getNumberOfPages();
//                PDFTextStripper stripper = new PDFTextStripper();
//                stripper.setSortByPosition(false);
//                buffer = stripper.getText(pd);
//                pd.close();
//            }else {
//                buffer = "read failed";
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            return "read failed";
//        }
//        return buffer;
//    }
//
//
//
//    public static String readPDF2(String fileName) {
//        String result = "";
//        File file = new File(fileName);
//        FileInputStream in = null;
//        try {
//            in = new FileInputStream(fileName);
//            // 新建一个PDF解析器对象
//            PDFParser parser = new PDFParser(new RandomAccessFile(file,"rw"));
//            // 对PDF文件进行解析
//            parser.parse();
//            // 获取解析后得到的PDF文档对象
//            PDDocument pdfdocument = parser.getPDDocument();
//            // 新建一个PDF文本剥离器
//            PDFTextStripper stripper = new PDFTextStripper();
//            stripper.setSortByPosition(true);
//            stripper.setStartPage(1);
//            stripper.setEndPage(1);
//            System.out.println(stripper.getGraphicsStackSize());
//            stripper .setSortByPosition(false); //sort:设置为true 则按照行进行读取，默认是false
//            // 从PDF文档对象中剥离文本
//            result = stripper.getText(pdfdocument);
//        } catch (Exception e) {
//            System.out.println("读取PDF文件" + file.getAbsolutePath() + "生失败！" + e);
//            e.printStackTrace();
//        } finally {
//            if (in != null) {
//                try {
//                    in.close();
//                } catch (IOException e1) {
//                }
//            }
//        }
//        return result;
//    }
//
//    /**
//     * 测试pdf文件的创建
//     * @param args
//     */
//    public static void main(String[] args) {
//        try {
//            String filePath = "D:\\a\\1.变压器全过程技术监督精益化管理实施细则1121.pdf";  //这里先手动把绝对路径的文件夹给补上。
//            String result = PDFUtils.readPDF2(filePath);
//            System.out.println(result);
//            //将提取的表格内容写入txt文档
//            FileWriter fileWriter = new FileWriter("D:\\a\\ocr.txt");
//            fileWriter.write(result);
//            fileWriter.flush();
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//
////    public static void listFields(PDDocument doc) throws Exception {
////        PDDocumentCatalog catalog = doc.getDocumentCatalog();
////        PDAcroForm form = catalog.getAcroForm();
////        java.util.List<PDField> fields1 = form.getFields();
////        System.out.println(fields1.size());
////
//////        for(PDFieldTreeNode field: fields) {
//////            Object value = field.getValue();
//////            String name = field.getFullyQualifiedName();
//////            System.out.print(name);
//////            System.out.print(" = ");
//////            System.out.print(value);
//////            System.out.println();
//////        }
////    }
//
//
//
//    }
//
//
//
