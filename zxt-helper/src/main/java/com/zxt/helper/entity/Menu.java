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
 * @date:2023/3/23
 */
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "菜单实例")
@Table(name = "sys_menu")
public class Menu implements Serializable {
    @Id
    @ApiModelProperty(value = "菜单ID")
    private Integer id;

    @Column(name = "menuCode")
    @ApiModelProperty(value = "菜单编码")
    private String menuCode;

    @Column(name = "menuName")
    @ApiModelProperty(value = "菜单名称")
    private String menuName;

    @Column(name = "creTime")
    @ApiModelProperty(value = "创建时间")
    private String creTime;

    @Column(name = "updTime")
    @ApiModelProperty(value = "修改时间")
    private String updTime;

    @Column(name = "isDelete")
    @ApiModelProperty(value = "是否删除 1、不删除（正常）0、删除")
    private String isDelete;

    @Column(name = "levelMenu")
    @ApiModelProperty(value = "几级菜单 1、一级 2、二级 3、三级 ...")
    private String levelMenu;
}
