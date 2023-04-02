package com.zxt.helper.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author:TanXiao
 * @date:2023/3/17
 */
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "部门实例")
@Table(name = "sys_dept")
public class Dept implements Serializable {
    @Id
    @ApiModelProperty(value = "部门ID")
    private Integer id;

    @ApiModelProperty(value = "部门名称")
    @Column(name = "deptName")
    private String deptName;

    @ApiModelProperty(value = "部门编码")
    @Column(name = "deptCode")
    private String deptCode;

    @ApiModelProperty(value = "创建时间")
    @Column(name = "creTime")
    private String creTime;

    @ApiModelProperty(value = "修改时间")
    @Column(name = "updTime")
    private String updTime;

    @ApiModelProperty(value = "是否删除？0、删除 1、正常")
    @Column(name = "isDelete")
    private String isDelete;

    @ApiModelProperty(value = "几级部门 1、一级 2、二级 3、三级 ...")
    @Column(name = "levelDept")
    private String levelDept;
}
