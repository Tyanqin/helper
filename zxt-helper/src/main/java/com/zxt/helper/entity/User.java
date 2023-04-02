package com.zxt.helper.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
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
@NoArgsConstructor
@ToString
@Builder
@Accessors(chain = true)
@ApiModel(value = "用户实例")
@Table(name = "sys_user")
public class User implements Serializable {
    @Id
    @ApiModelProperty(value = "用户ID")
    private Integer id;

    @Column(name = "userName")
    @ApiModelProperty(value = "用户名称")
    private String userName;

    @Column(name = "password")
    @ApiModelProperty(value = "用户密码")
    private String password;

    @Column(name = "iphone")
    @ApiModelProperty(value = "用户手机")
    private String iphone;

    @Column(name = "permissionId")
    @ApiModelProperty(value = "权限ID")
    private String permissionId;

    @Column(name = "departmentId")
    @ApiModelProperty(value = "部门ID")
    private Integer departmentId;

    @Column(name = "isFreeze")
    @ApiModelProperty(value = "是否冻结？0、冻结 1、正常")
    private String isFreeze;

    @Column(name = "isDelete")
    @ApiModelProperty(value = "是否删除？0、删除 1、正常")
    private String isDelete;

    @Column(name = "creTime")
    @ApiModelProperty(value = "创建时间")
    private String creTime;

    @Column(name = "updTime")
    @ApiModelProperty(value = "修改时间")
    private String updTime;

    @JsonIgnore
    private Dept dept;

    @JsonIgnore
    private Permission permission;

}
