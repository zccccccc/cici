package com.springboot.demo.util.base.entityvo;

/**
 * 分页
 */
public class BasePage<T> {


    //总页数
    private int totalPages;

    //总数量
    private long totalElement;

    //页面显示数量
    private int size = 10;

    //当前页面
    private int currentPage = 1;

    //排序
    private String sortDirection = "DESC";

    //排序字段
    private String sortField;

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalElement() {
        return totalElement;
    }

    public void setTotalElement(long totalElement) {
        this.totalElement = totalElement;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public String getSortDirection() {
        return sortDirection.toUpperCase();
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }
}
