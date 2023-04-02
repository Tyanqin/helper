package com.zxt.helper.entity;

import com.zxt.helper.Annotation.ExcelAttribute;
import com.zxt.helper.Annotation.ExcelImportAnnotation;

/**
 * @author:TanXiao
 * @date:2023/3/29
 */
public class UserEx {

    @ExcelAttribute(sort = 0)//导出顺序
    @ExcelImportAnnotation(sort = 0)//导入顺序
    private int id;
    @ExcelAttribute(sort = 1)
    @ExcelImportAnnotation(sort = 1)
    private String name;
    @ExcelAttribute(sort = 2)
    @ExcelImportAnnotation(sort = 2)
    private int age;
    @ExcelAttribute(sort = 3)
    @ExcelImportAnnotation(sort = 3)
    private String sex;
    @ExcelAttribute(sort = 4)
    @ExcelImportAnnotation(sort = 4)
    private String telephone;
    @ExcelAttribute(sort = 5)
    @ExcelImportAnnotation(sort = 5)
    private String address;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
