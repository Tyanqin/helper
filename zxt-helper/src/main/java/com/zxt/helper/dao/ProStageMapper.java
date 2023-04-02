package com.zxt.helper.dao;

import com.zxt.helper.entity.ProStage;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author:TanXiao
 * @date:2023/3/30
 */
@Repository
@org.apache.ibatis.annotations.Mapper
public interface ProStageMapper extends Mapper<ProStage> {
}
