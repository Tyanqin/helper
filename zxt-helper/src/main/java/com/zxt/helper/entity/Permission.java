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
@ApiModel(value = "权限实例")
@Table(name = "sys_permission")
public class Permission implements Serializable {

    @Id
    @ApiModelProperty(value = "权限ID")
    private Integer id;

    @Column(name = "perName")
    @ApiModelProperty(value = "权重名称")
    private String perName;

    @Column(name = "perLevel")
    @ApiModelProperty(value = "权重级别 0:没有审核权限，对应有第几次审核的权限")
    private String perLevel;

    @Column(name = "perMark")
    @ApiModelProperty(value = "权重标记")
    private String perMark;

    @Column(name = "isDetailsBtn")
    @ApiModelProperty(value = "是否有详情按钮 0:没有 1:有")
    private String isDetailsBtn;

    @Column(name = "isConfirmBtn")
    @ApiModelProperty(value = "是否有确认按钮 0:没有 1:有")
    private String isConfirmBtn;

    @Column(name = "isBackBtn")
    @ApiModelProperty(value = "是否有退回按钮 0:没有 1:有")
    private String isBackBtn;

    @Column(name = "isPostBtn")
    @ApiModelProperty(value = "是否有发布按钮 0:没有 1:有")
    private String isPostBtn;

    @Column(name = "isUpdateBtn")
    @ApiModelProperty(value = "是否有修改按钮 0:没有 1:有")
    private String isUpdateBtn;

    @Column(name = "isDeleteBtn")
    @ApiModelProperty(value = "是否有删除按钮 0:没有 1:有")
    private String isDeleteBtn;

    @Column(name = "isInsertBtn")
    @ApiModelProperty(value = "是否有新按钮 0:没有 1:有")
    private String isInsertBtn;


    @Column(name = "creTime")
    @ApiModelProperty(value = "创建时间")
    private String creTime;

    @Column(name = "updTime")
    @ApiModelProperty(value = "修改时间")
    private String updTime;

    @Column(name = "isDelete")
    @ApiModelProperty(value = "是否删除？0、删除 1、正常")
    private String isDelete;

    @Column(name = "isReviewBtn")
    @ApiModelProperty(value = "是否送审？0、没有 1、有")
    private String  isReviewBtn;

}
