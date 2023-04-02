package com.zxt.helper.dao;

import com.zxt.helper.entity.Regulation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author:TanXiao
 * @date:2023/4/1
 */
@Repository
@Mapper
public interface RegulationMapper extends tk.mybatis.mapper.common.Mapper<Regulation> {
    /**
     * 获取细则名称（去重）
     * @return
     */
    public List<String> distinctRegName();

    /**
     * 删除（更改isDelete状态）
     * @param ruRegId
     */
    public  void deleteById(@Param("ruRegId")Integer ruRegId);

    /**
     * 分页
     * @param regName
     * @param resName
     * @return
     */
    List<Map<String, Object>> page(
            @Param("regName")String regName,
            @Param("resName") String resName);
}
