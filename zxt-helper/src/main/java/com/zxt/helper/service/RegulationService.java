package com.zxt.helper.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxt.helper.common.Biz.BaseBiz;
import com.zxt.helper.common.msg.TableResultResponse;
import com.zxt.helper.dao.RegulationMapper;
import com.zxt.helper.entity.Regulation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author:TanXiao
 * @date:2023/4/1
 */
@Service
public class RegulationService extends BaseBiz<RegulationMapper, Regulation> {
    /**
     *删除
     * @return
     */
    public void deleteById(Integer ruRegId) {
        mapper.deleteById(ruRegId);
    }

    /**
     * 查询细则名称（去重）
     * @return
     */
    public List<String> distinctRegName() {
        List<String> value = mapper.distinctRegName();
        return value;
    }

    /**
     * 分页
     * @param regName
     * @param currentPage
     * @param pageSize
     * @return
     */
    public TableResultResponse getPage(String regName, String resName, Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Map<String,Object>> list=mapper.page(regName, resName);
        PageInfo<List<Map<String,Object>>> pageInfo = new PageInfo(list);
        return new TableResultResponse(pageInfo.getTotal(),pageInfo.getPageNum(),pageInfo.getList());
    }

    @Autowired
    private RegulationMapper mapper;

}
