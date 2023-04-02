package com.zxt.helper.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author:TanXiao
 * @date:2023/3/21
 */
@Slf4j
@Data
@Component
@ConfigurationProperties(prefix = "tess4j")
public class Tess4jClient {
    public static void main(String args[]) throws IOException, TesseractException {


//        try {
//            for (String image : images) {
//                byte[] bytes = fileService.downLoadFile(image);
//                //从byte[]转换为butteredImage
//                ByteArrayInputStream in = new ByteArrayInputStream(bytes);
//                BufferedImage imageFile = ImageIO.read(in);
//                //识别图片的文字
//                String result = tess4jClient.doOCR("");
//                String result = tess4jClient.doOCR(imageFile);
//                //再结合敏感词过滤算法，审核图片中的文字是否包含敏感词
////                boolean isSensitive = sensitiveScan(result);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }

    }


    private String dataPath;
    private String language;

    // 入参：图片流
    public String doOCR(BufferedImage image) throws TesseractException {
        //创建Tesseract对象
        ITesseract tesseract = new Tesseract();
        //设置中文字体库路径
        tesseract.setDatapath(dataPath);
        //中文识别
        tesseract.setLanguage(language);
        //执行ocr识别
        String result = tesseract.doOCR(image);
        //替换回车和tal键  使结果为一行
        result = result.replaceAll("\\r|\\n", "-").replaceAll(" ", "");
        return result;
    }







//    public byte[] downLoadFile(String pathUrl)  {
//        String key = pathUrl.replace(minIOConfigProperties.getEndpoint()+"/","");
//        int index = key.indexOf("/");
//        String bucket = key.substring(0,index);
//        String filePath = key.substring(index+1);
//        InputStream inputStream = null;
//        try {
//            inputStream = minioClient.getObject(GetObjectArgs.builder().bucket(minIOConfigProperties.getBucket()).object(filePath).build());
//        } catch (Exception e) {
//            log.error("minio down file error.  pathUrl:{}",pathUrl);
//            e.printStackTrace();
//        }
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        byte[] buff = new byte[100];
//        int rc = 0;
//        while (true) {
//            try {
//                if (!((rc = inputStream.read(buff, 0, 100)) > 0)) break;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            byteArrayOutputStream.write(buff, 0, rc);
//        }
//        return byteArrayOutputStream.toByteArray();
//    }

}
