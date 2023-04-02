package com.zxt.helper.controller;

import com.zxt.helper.Annotation.PassToken;
import com.zxt.helper.common.Biz.BaseController;
import com.zxt.helper.common.exception.SelectResultException;
import com.zxt.helper.common.exception.param.ParamEmptyException;
import com.zxt.helper.common.exception.param.ParamNullException;
import com.zxt.helper.common.msg.ObjectRestResponse;
import com.zxt.helper.common.msg.TableResultResponse;
import com.zxt.helper.common.utils.BaseAssert;
import com.zxt.helper.common.utils.ExcelExportUtil;
import com.zxt.helper.common.utils.ExcelImportUtil;
import com.zxt.helper.common.utils.JsonUtil;
import com.zxt.helper.entity.SupervisionRules;
import com.zxt.helper.service.SupervisionRulesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author:TanXiao
 * @date:2023/3/29
 */
@RestController
@RequestMapping("/supervisionRules")
@Api(tags=" 监督细则API ")
public class SupervisionRulesController extends BaseController<SupervisionRulesService,SupervisionRules> {


    @PassToken
    @GetMapping(value = "/delByDetailId")
    @ApiOperation(value = "根据ID删除数据（修改状态）")
    public ObjectRestResponse delByDetailId(@RequestParam("detailId")  Integer detailId){
         BaseAssert.isNull(detailId,ParamNullException::new);
        supervisionRulesService.deleteById(detailId);
        return new ObjectRestResponse().message("SUCCESS");
    }


    /**
     * 查询细则名称
     * @return
     */
    @PassToken
    @PostMapping("/distinctRuleName")
    @ApiOperation(value = "获取细则名称")
    public ObjectRestResponse<List<String>> distinctRuleName(){
        List<String> value = supervisionRulesService.distinctRuleName();
        BaseAssert.isEmpty(Collections.singletonList(value), SelectResultException::new);
        return new ObjectRestResponse<List<String>>().data(value);
    }

    /**
     * 分页
     * @return
     */
    @PassToken
    @GetMapping("/pageHandel")
    @ApiOperation(value = "条件分页")
    @ApiImplicitParams({
            @ApiImplicitParam(value="细则名称",name="ruleName",dataType="String",paramType = "query"),
            @ApiImplicitParam(value="项目阶段",name="staName",dataType="String",paramType = "query"),
            @ApiImplicitParam(value="开始时间",name="startTime",dataType="String",paramType = "query"),
            @ApiImplicitParam(value="结束时间",name="endTime",dataType="String",paramType = "query"),
            @ApiImplicitParam(value="当前页码",name="currentPage",dataType="String",paramType = "query"),
            @ApiImplicitParam(value="页大小 ",name="pageSize",dataType="String",paramType = "query"),
    })
    public TableResultResponse pageHandel(
            @RequestParam(value = "ruleName",required = false) String ruleName,
            @RequestParam(value = "staName",required = false) String staName,
            @RequestParam(value = "ruleTitle",required = false)  String ruleTitle,
            @RequestParam(value = "startTime",required = false) String startTime,
            @RequestParam(value = "endTime",required = false) String endTime,
            @RequestParam(value = "currentPage",defaultValue = "1") Integer currentPage,
            @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize){
        return  supervisionRulesService.getPage(ruleName, staName, ruleTitle, startTime, endTime, currentPage, pageSize);
    }


    /**
     * 使用Excel的工具类进行导出 基于模板
     */
    @PassToken
    @ApiOperation(value = "excel导出文件", notes = "请查看Models数据字典")
    @GetMapping(value = "export")
    public void ruleExport(HttpServletResponse response)  {
        try{
            //1.获取数据
            List<Map<String,Object>> value = supervisionRulesService.getList();
            List<SupervisionRules> rules = jsonUtil.mapToObject(value, SupervisionRules.class);
            //2.加载模板
            Resource resource = new ClassPathResource(FILE_PATH);
            FileInputStream fis =  new FileInputStream(resource.getFile());
            //3.通过 工具类下载文件
            new ExcelExportUtil<SupervisionRules>(SupervisionRules.class,1,0)
                    /**
                     * 参数 1：HttpServletResponse
                     *      2：文件输入流
                     *      3：封装好的对象
                     *      4：文件名
                     */
                    .export(response,fis,rules,FILE_NAME);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 使用抽取的Excel的工具类进行导入 基于模板
     */
    @PassToken
    @ApiOperation(value = "excel导入文件", notes = "请查看Models数据字典")
    @PostMapping("import")
    @ResponseBody
    public ObjectRestResponse  ruleImport(@RequestParam(name = "file") MultipartFile file) throws Exception {
        BaseAssert.isNull(file, ParamNullException::new);
        List<Object> list = new ExcelImportUtil<>(SupervisionRules.class).readExcel(file.getInputStream(), 1, 1);
        BaseAssert.isEmpty(list, ParamEmptyException::new);
        for (Object object:list) {
            SupervisionRules rules=(SupervisionRules) object;
            System.out.println(rules);
        }
        return new ObjectRestResponse().message("SUCCESS");
    }


    @Autowired
    private SupervisionRulesService supervisionRulesService;

    @Autowired
    private JsonUtil<SupervisionRules> jsonUtil;

    private final static String  FILE_PATH = "/excel/super_rule.xls";

    private final static String FILE_NAME = "监督细则-"+System.currentTimeMillis()+ ".xls";
}
