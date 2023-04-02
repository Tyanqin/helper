package com.zxt.helper.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxt.helper.common.Biz.BaseBiz;
import com.zxt.helper.common.msg.TableResultResponse;
import com.zxt.helper.dao.SupervisionRulesMapper;
import com.zxt.helper.entity.SupervisionRules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author:TanXiao
 * @date:2023/3/29
 */
@Service
public class SupervisionRulesService extends BaseBiz<SupervisionRulesMapper, SupervisionRules> {

    @Autowired
    private SupervisionRulesMapper mapper;

    public List<Map<String,Object>> getList(){
        return mapper.getList();
    }



    /**
     *删除
     * @return
     */
    public void deleteById(Integer detailId) {
            mapper.deleteById(detailId);
    }

    /**
     * 查询细则名称（去重）
     * @return
     */
    public List<String> distinctRuleName() {
            List<String> value = mapper.distinctRuleName();
            return value;
    }

    public TableResultResponse getPage(
            String ruleName, String staName,
            String ruleTitle, String startTime,
            String endTime, Integer currentPage,
            Integer pageSize){
        PageHelper.startPage(currentPage,pageSize);
        List<Map<String,Object>> list=mapper.page(ruleName,  staName, ruleTitle,  startTime, endTime);
        PageInfo<List<Map<String,Object>>> pageInfo = new PageInfo(list);
        return new TableResultResponse(pageInfo.getTotal(),pageInfo.getPageNum(),pageInfo.getList());


    }

}
