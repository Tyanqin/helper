package com.zxt.helper.controller;

import com.zxt.helper.Annotation.PassToken;
import com.zxt.helper.common.Biz.BaseController;
import com.zxt.helper.common.exception.SelectResultException;
import com.zxt.helper.common.exception.file.FileNullException;
import com.zxt.helper.common.exception.param.ParamNullException;
import com.zxt.helper.common.msg.ObjectRestResponse;
import com.zxt.helper.common.msg.TableResultResponse;
import com.zxt.helper.common.utils.BaseAssert;
import com.zxt.helper.common.utils.MinioUtils;
import com.zxt.helper.config.MinioConfig;
import com.zxt.helper.entity.Regulation;
import com.zxt.helper.service.RegulationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/**
 * @author:TanXiao
 * @date:2023/4/1
 */
@Slf4j
@RestController
@RequestMapping("/reg")
@MultipartConfig
@Api(tags = "规章制度API")
public class RegulationController extends BaseController<RegulationService, Regulation> {

//    @RequestPart String regName,

    @PassToken
    @PostMapping("/upload")
    @ApiOperation(value = "上传文件", notes = "请查看Models数据字典")
    public ObjectRestResponse uploadAdd(HttpServletRequest request, @RequestParam("regName")String regName, @RequestParam("files")MultipartFile[] files) throws IOException {
        /**
         * 校验参数（此处还需要对文件格式与大小做校验） @RequestParam("files")
         */
        BaseAssert.isNull(regName,ParamNullException::new);
        //文件名
        for (MultipartFile file : files) {
            InputStream inputStream = file.getInputStream();
            PDDocument pd = PDDocument.load(inputStream);
            int pageNumber = pd.getNumberOfPages();
            System.err.println("pageNumber=====》》》》》"+pageNumber);
            String fileName = file.getOriginalFilename();
            BaseAssert.isNull(fileName, FileNullException::new);
            String newFileName = System.currentTimeMillis() + "." + StringUtils.substringAfterLast(fileName, ".");
            //类型
            String contentType = file.getContentType();
            minioUtils.uploadFile(minioConfig.getBucketName(), file, newFileName, contentType);
            String fileUrl = minioUtils.getPresignedObjectUrl(minioConfig.getBucketName(), fileName);
            Regulation regulation = new Regulation().setRegName(regName).setResName(fileName).setRuRegUrl(fileUrl).setFileName(newFileName).setPageNumber(pageNumber);
            regulationService.insertSelective(regulation);
        }

        return new ObjectRestResponse().message("SUCCESS");
    }



    @PassToken
    @GetMapping(value = "/delByRuRegId")
    @ApiOperation(value = "根据ID删除数据（修改状态）")
    public ObjectRestResponse delByDetailId(@RequestParam("ruRegId")  Integer ruRegId){
        BaseAssert.isNull(ruRegId, ParamNullException::new);
        regulationService.deleteById(ruRegId);
        return new ObjectRestResponse().message("SUCCESS");
    }


    /**
     * 查询细则名称
     * @return
     */
    @PassToken
    @PostMapping("/distinctRegName")
    @ApiOperation(value = "获取规章制度名称")
    public ObjectRestResponse<List<String>> distinctRegName(){
        List<String> value = regulationService.distinctRegName();
        BaseAssert.isEmpty(Collections.singletonList(value), SelectResultException::new);
        return new ObjectRestResponse<List<String>>().data(value);
    }


    /**
     * 分页
     * @return
     */
    @PassToken
    @GetMapping("/queryPage")
    @ApiOperation(value = "条件分页")
    @ApiImplicitParams({
            @ApiImplicitParam(value="规章名称",name="regName",dataType="String",paramType = "query"),
            @ApiImplicitParam(value="制度名称",name="resName",dataType="String",paramType = "query"),
            @ApiImplicitParam(value="当前页码",name="currentPage",dataType="String",paramType = "query"),
            @ApiImplicitParam(value="页大小 ",name="pageSize",dataType="String",paramType = "query"),
    })
    public TableResultResponse queryPage(
            @RequestParam(value = "regName",required = false) String regName,
            @RequestParam(value = "resName",required = false) String resName,
            @RequestParam(value = "currentPage",defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize){
        return regulationService.getPage(regName, resName,currentPage,pageSize);
    }

    @PassToken
    @PostMapping("/test")
    @ApiOperation(value = "获取ID")
    public ObjectRestResponse getId(){
        return    new ObjectRestResponse().data(regulationService.selectById(12));
    }

    @Autowired
    private RegulationService regulationService;

    @Autowired
    private MinioUtils minioUtils;

    @Autowired
    private MinioConfig minioConfig;


}
