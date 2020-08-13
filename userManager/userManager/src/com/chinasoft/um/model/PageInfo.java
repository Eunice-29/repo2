package com.chinasoft.um.model;

import java.util.List;

public class PageInfo<T> {

    private Integer pageNum;   //当前页号
    private Integer rows;      //页面显示的记录数
    private Integer totalNum;  //总的记录数
    private Integer totalPage; //总的页数
    List<T> list;               //页面显示记录信息


    public PageInfo() {
    }

    public PageInfo(Integer pageNum, Integer rows, Integer totalNum, Integer totalPage, List<T> list) {
        this.pageNum = pageNum;
        this.rows = rows;
        this.totalNum = totalNum;
        this.totalPage = totalPage;
        this.list = list;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageInfo{" +
                "pageNum=" + pageNum +
                ", rows=" + rows +
                ", totalNum=" + totalNum +
                ", totalPage=" + totalPage +
                ", list=" + list +
                '}';
    }
}
