package com.zxt.helper.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author:TanXiao
 * @date:2023/3/30
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "项目阶段实体类")
@Table(name = "pro_stage")
public class ProStage implements Serializable {

    @Id
    @ApiModelProperty(value = "阶段ID")
    @Column(name = "staId")
    private String staId;

    @ApiModelProperty(value = "阶段名称")
    @Column(name = "staName")
    private String staName;

    @ApiModelProperty(value = "阶段描述")
    @Column(name = "staDesc")
    private String staDesc;

    @ApiModelProperty(value = "创建时间")
    @Column(name = "creTime")
    private String creTime;

    @ApiModelProperty(value = "修改时间")
    @Column(name = "updTime")
    private String updTime;

    @ApiModelProperty(value = "是否删除 1：正常   0：删除")
    @Column(name = "isDelete")
    private String isDelete;
}
