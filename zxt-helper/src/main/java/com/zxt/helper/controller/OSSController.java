package com.zxt.helper.controller;

import com.zxt.helper.Annotation.PassToken;
import com.zxt.helper.common.utils.ExcelExportUtil;
import com.zxt.helper.common.utils.ExcelImportUtil;
import com.zxt.helper.common.utils.MinioUtils;
import com.zxt.helper.config.MinioConfig;
import com.zxt.helper.entity.UserEx;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:TanXiao
 * @date:2023/3/29
 */
@Slf4j
@RestController
@RequestMapping("/oss")
@Api(tags=" oss  controller ")
public class OSSController {

    @Autowired
    private MinioUtils minioUtils;

    @Autowired
    private MinioConfig minioConfig;

    /**
     * 文件上传
     *
     * @param file
     */
    @PassToken
    @PostMapping("/upload")
    @ApiOperation(value = "上传文件", notes = "请查看Models数据字典")
    public String upload(@RequestParam("file") MultipartFile file) {
        try {
            //文件名
            String fileName = file.getOriginalFilename();
            String newFileName = System.currentTimeMillis() + "." + StringUtils.substringAfterLast(fileName, ".");
            //类型
            String contentType = file.getContentType();
            minioUtils.uploadFile(minioConfig.getBucketName(), file, newFileName, contentType);
            return "上传成功";
        } catch (Exception e) {
            log.error("上传失败");
            return "上传失败";
        }
    }

    /**
     * 删除
     * @param fileName
     */
    @PassToken
    @DeleteMapping("/")
    @ApiOperation(value = "根据名称删除文件", notes = "请查看Models数据字典")
    public void delete(@RequestParam("fileName") String fileName) {
        minioUtils.removeFile(minioConfig.getBucketName(), fileName);
    }

    /**
     * 获取文件信息
     *
     * @param fileName
     * @return
     */
    @PassToken
    @GetMapping("/info")
    @ApiOperation(value = "获取文件信息", notes = "请查看Models数据字典")
    public String getFileStatusInfo(@RequestParam("fileName") String fileName) {
        return minioUtils.getFileStatusInfo(minioConfig.getBucketName(), fileName);
    }

    /**
     * 获取文件外链
     *
     * @param fileName
     * @return
     */
    @PassToken
    @GetMapping("/url")
    public String getPresignedObjectUrl(@RequestParam("fileName") String fileName) {
        return minioUtils.getPresignedObjectUrl(minioConfig.getBucketName(), fileName);
    }

    /**
     * 文件下载
     *
     * @param fileName
     * @param response
     */
    @PassToken
    @GetMapping("/download")
    @ApiOperation(value = "下载文件", notes = "请查看Models数据字典")
    public void download(@RequestParam("fileName") String fileName, HttpServletResponse response) {
        try {
            InputStream fileInputStream = minioUtils.getObject(minioConfig.getBucketName(), fileName);
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
            response.setContentType("application/force-download");
            response.setCharacterEncoding("UTF-8");
            IOUtils.copy(fileInputStream, response.getOutputStream());
        } catch (Exception e) {
            log.error("下载失败");
        }
    }


    /**
     * 使用Excel的工具类进行导出 基于模板
     */
    @PassToken
    @ApiOperation(value = "excel导出文件", notes = "请查看Models数据字典")
    @GetMapping("ExcelUtilExport")
    public void  ExcelUtilExport(HttpServletResponse response) throws Exception {
        //1.获取数据
        //人为构造的数据，实际是要从数据库中查的
        List<Object> users=new ArrayList<>();
        for(int i=0;i<20;i++){
            UserEx user=new UserEx();
            int rs = (int) ((Math.random() * 9 + 1) * Math.pow(10, 8 - 1));
            user.setId(i+1);
            user.setName("zhangsan"+i);
            user.setAge(23);
            user.setSex("man");
            user.setTelephone("188"+rs);
            user.setAddress("随便编个地址");
            users.add(user);
        }

        //2.加载模板
        Resource resource = new ClassPathResource("/excel/super_rule.xls");
        FileInputStream fis = new FileInputStream(resource.getFile());

        //3.通过 工具类下载文件
        //因为内容样式和要写的内容都在下标1也就时excel中的第二行
        String fileName = "用户信息-"+System.currentTimeMillis()+ ".xls";
        new ExcelExportUtil<>(UserEx.class,1,0)
                /**
                 * 参数 1：HttpServletResponse
                 *      2：文件输入流
                 *      3：封装好的对象
                 *      4：文件名
                 */
                .export(response,fis,users,fileName);
    }

    /**
     * 使用抽取的Excel的工具类进行导入 基于模板
     */
    @PassToken
    @ApiOperation(value = "excel导入文件", notes = "请查看Models数据字典")
    @PostMapping("ExcelUtilImport")
    @ResponseBody
    public String  ExcelUtilImport(@RequestParam(name = "file") MultipartFile file) throws Exception {
        List<Object> list = new ExcelImportUtil<>(UserEx.class).readExcel(file.getInputStream(), 1, 0);
        for (Object object:list) {
            UserEx userEx=(UserEx) object;
            System.out.println(userEx);
        }
        return "SUCCESS";
    }


}
