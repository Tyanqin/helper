package com.zxt.helper.dao;

import com.zxt.helper.entity.SupervisionRules;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author:TanXiao
 * @date:2023/3/29
 */
@Repository
@org.apache.ibatis.annotations.Mapper
public interface SupervisionRulesMapper extends Mapper<SupervisionRules> {

    /**
     * 导出
     * @return
     */
    public List<Map<String,Object>> getList();

    /**
     * 获取细则名称（去重）
     * @return
     */
    public List<String> distinctRuleName();

    /**
     * 删除（更改isDelete状态）
     * @param detailId
     */
    public  void deleteById(@Param("detailId")Integer detailId);

    /**
     * 分页
     * @return
     */
    public List<Map<String,Object>> page(
            @Param("ruleName")String ruleName, @Param("staName")String staName,
            @Param("ruleTitle")String ruleTitle, @Param("startTime")String startTime,
            @Param("endTime")String endTime);





    }


