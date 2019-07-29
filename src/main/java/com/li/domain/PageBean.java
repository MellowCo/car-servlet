package com.li.domain;

import java.util.List;

/**
 * @Program: exam
 * @ClassName: PageBean
 * @Description: 分页查询
 * @Author: li
 * @Create: 2019-07-23 19:25
 */
public class PageBean<T> {
    private Integer currentPage;
    private Integer pageSize;
    private Integer totalPage;
    private Integer totalData;
    private List<T> list;

    public PageBean(Integer currentPage, Integer pageSize, Integer totalData, List<T> list) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalPage = totalData % pageSize == 0 ? totalData / pageSize : totalData / pageSize + 1;
        this.totalData = totalData;
        this.list = list;
    }

    public PageBean() {
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", totalData=" + totalData +
                ", list=" + list +
                '}';
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalData() {
        return totalData;
    }

    public void setTotalData(Integer totalData) {
        this.totalData = totalData;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
