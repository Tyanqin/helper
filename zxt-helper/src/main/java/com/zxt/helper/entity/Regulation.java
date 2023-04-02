package com.zxt.helper.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author:TanXiao
 * @date:2023/4/1
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "规章制度")
@Accessors(chain = true)
@Table(name = "rules_regulation")
public class Regulation implements Serializable {

    @Id
    @ApiModelProperty(value = "ID")
    @Column(name = "ruRegId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ruRegId;

    @ApiModelProperty(value = "规章名称")
    @Column(name = "resName")
    private String    resName;

    @ApiModelProperty(value = "制度名称")
    @Column(name = "regName")
    private String regName;

    @ApiModelProperty(value = "文件名称")
    @Column(name = "fileName")
    private String fileName;

    @ApiModelProperty(value = "文件页数")
    @Column(name = "pageNumber")
    private Integer pageNumber;

    @ApiModelProperty(value = "URL地址")
    @Column(name = "ruRegUrl")
    private String    ruRegUrl;

    @ApiModelProperty(value = "创建时间")
    @Column(name = "creTime")
    private String creTime;

    @ApiModelProperty(value = "修改时间")
    @Column(name = "updTime")
    private String    updTime;

    @ApiModelProperty(value = "是否删除？1、正常 0、删除")
    @Column(name = "isDelete")
    private String isDelete;

    @ApiModelProperty(value = "阶段ID")
    @Column(name = "ruRegId")
    private String    stageId;

    @ApiModelProperty(value = "用户ID")
    @Column(name = "userId")
    private String  userId;

    @ApiModelProperty(value = "编号")
    @Column(name = "markCode")
    private String markCode;
}
