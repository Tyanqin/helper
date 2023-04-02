package com.zxt.helper.entity;

import com.zxt.helper.Annotation.ExcelAttribute;
import com.zxt.helper.Annotation.ExcelImportAnnotation;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author:TanXiao
 * @date:2023/3/29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "监督细则")
@Table(name = "supervision_rule")
public class SupervisionRules implements Serializable {

    @Id
    @ApiModelProperty(value = "细则ID")
    @Column(name = "detailId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String  detailId;

    @ExcelAttribute(sort = 0)//导出顺序
    @ExcelImportAnnotation(sort = 0)//导入顺序
    @ApiModelProperty(value = "细则名称")
    @Column(name = "ruleName")
    private String ruleName;

    @ExcelAttribute(sort = 1)
    @ExcelImportAnnotation(sort = 1)
    @Column(name = "staName")
    private String staName;

    @ExcelAttribute(sort = 2)
    @ExcelImportAnnotation(sort = 2)
    @ApiModelProperty(value = "细则标题")
    @Column(name = "ruleTitle")
    private String ruleTitle;

    @ExcelAttribute(sort = 3)
    @ExcelImportAnnotation(sort = 3)
    @ApiModelProperty(value = "细则主题")
    @Column(name = "ruleTheme")
    private String   ruleTheme;

    @ExcelAttribute(sort = 4)
    @ExcelImportAnnotation(sort = 4)
    @ApiModelProperty(value = "监督要点")
    @Column(name = "keyPoint")
    private String  keyPoint;


    @ApiModelProperty(value = "用户ID")
    @Column(name = "userId")
    private String userId;

    @ApiModelProperty(value = "创建时间")
    @Column(name = "creTime")
    private String    creTime;

    @ApiModelProperty(value = "修改时间")
    @Column(name = "updTime")
    private String updTime;

    @ApiModelProperty(value = "是否删除？1、正常0、删除")
    @Column(name = "isDelete")
    private String    isDelete;



}
