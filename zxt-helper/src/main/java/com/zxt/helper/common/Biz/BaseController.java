package com.zxt.helper.common.Biz;

import com.zxt.helper.Annotation.PassToken;
import com.zxt.helper.Annotation.UserLoginToken;
import com.zxt.helper.common.exception.param.ParamEmptyException;
import com.zxt.helper.common.exception.param.ParamNullException;
import com.zxt.helper.common.msg.ObjectRestResponse;
import com.zxt.helper.common.msg.TableResultResponse;
import com.zxt.helper.common.utils.BaseAssert;
import com.zxt.helper.common.utils.JsonUtil;
import com.zxt.helper.common.utils.Query;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

/**
 * @author:TanXiao
 * @date:2023/3/17
 */
public class BaseController  <Biz extends BaseBiz,Entity>{


    @PassToken
    @PostMapping(value = "/add")
    @ResponseBody
    @UserLoginToken
    @ApiOperation(value = "通用:写入新对象", notes = "请查看数据字典")
    public ObjectRestResponse<Entity> add(@RequestBody Entity entity){
        baseBiz.insertSelective(entity);
        return new ObjectRestResponse<Entity>().data(entity);
    }

    @PassToken
    @UserLoginToken
    @GetMapping(value = "/{id}")
    @ApiOperation(value = "通用:根据ID得到对象", notes = "请查看数据字典")
    public ObjectRestResponse<Entity> get(@PathVariable String id){
        BaseAssert.isNull(id, ParamNullException::new);
        ObjectRestResponse<Entity> entityObjectRestResponse = new ObjectRestResponse<>();
        Object o = baseBiz.selectById(id);
        entityObjectRestResponse.data((Entity)o);
        return entityObjectRestResponse;
    }

    @PassToken
    @UserLoginToken
    @PostMapping("/upd")
    @ResponseBody
    @ApiOperation(value = "通用:通过ID更新对象指定字段", notes = "请查看数据字典")
    public ObjectRestResponse<Entity> update(@RequestBody Entity entity){
        baseBiz.updateSelectiveById(entity);
        return new ObjectRestResponse<Entity>().data(entity);
    }

    @PassToken
    @UserLoginToken
    @PostMapping("/updateById")
    @ResponseBody
    @ApiOperation(value = "通用:通过ID更新对象", notes = "请查看数据字典")
    public ObjectRestResponse<Entity> updateById(@RequestBody Entity entity){
        baseBiz.updateById(entity);
        return new ObjectRestResponse<Entity>().data(entity);
    }

    @PassToken
    @UserLoginToken
    @PostMapping("/all")
    @ResponseBody
    @ApiOperation(value = "通用:获取所有对象", notes = "请查看数据字典")
    public ObjectRestResponse<List<Entity>> all(){
        List<Entity> list = baseBiz.selectListAll();
        return new ObjectRestResponse<List<Entity>>().data(list);
    }

    @PassToken
    @UserLoginToken
    @PostMapping("/selectOne")
    @ResponseBody
    @ApiOperation(value = "通用:通过字段获取对象", notes = "请查看数据字典")
    public ObjectRestResponse<Entity> selectOne(@RequestBody Map<String,Object> map){
        BaseAssert.isEmpty(map, ParamEmptyException::new);
        Entity t = (Entity) jsonUtil.jsonToObj(JsonUtil.mapToJson(map), clazz);
        Object o = baseBiz.selectOne(t);
        return new ObjectRestResponse<Entity>().data((Entity) o);
    }


    @PassToken
    @UserLoginToken
    @PostMapping("/selectMore")
    @ResponseBody
    @ApiOperation(value = "通用:通过字段获取多个对象", notes = "请查看数据字典")
    public ObjectRestResponse<List<Entity>> selectMore(@RequestBody Entity entity){
        List list = baseBiz.selectList(entity);
        return new ObjectRestResponse<List<Entity>>().data(list);
    }

    @PassToken
    @GetMapping(value = "/page")
    @ResponseBody
    @ApiOperation(value = "通用:根据传入条件分页", notes = "请查看数据字典，page,limit是特殊值")
    public TableResultResponse<Entity> list(@RequestParam("page") Integer page, @RequestParam("limit") Integer limit){
        Query query = new Query(page,limit);
        return baseBiz.selectPage(query);
    }


    @Autowired
    protected HttpServletRequest request;

    @Autowired
    protected Biz baseBiz;

    @Autowired
    protected JsonUtil jsonUtil;

    private  final  Class<Entity> clazz = (Class<Entity>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];

}
