package com.zxt.helper.common.utils;

import java.util.List;
import java.util.Map;

/**
 * @author:TanXiao
 * @date:2023/3/17
 */
public class QueryPage {

    private int currentPage = 1;//当前页，默认显示第一页

    private int pageCount = 10;//每页显示的行数（查询返回的行数），默认每页显示10行

    private int totalCount ;//数据库表中的总记录数

    private int totalPage;//总页数  =  总记录数  /    每页显示的行数（+1）

    private List<Map<String,Object>> data;//分页查询到的数据

    public QueryPage(int currentPage, int totalCount,int pageCount) {
        this.currentPage = currentPage;
        this.totalCount = totalCount;
        this.pageCount = pageCount;
    }

    public int getCurrentPage() {
        if(this.currentPage < 0){
            this.currentPage = 0;
        }else if(this.currentPage > this.getTotalPage()){
            this.currentPage = this.getTotalPage();
        }
        return currentPage * pageCount;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return this.totalCount/ this.pageCount;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<Map<String,Object>> getData() {
        return data;
    }

    public void setData(List<Map<String,Object>> data) {
        this.data = data;
    }

}
