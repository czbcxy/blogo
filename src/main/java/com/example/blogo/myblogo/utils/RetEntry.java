package com.example.blogo.myblogo.utils;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @描述
 * @参数 $params$
 * @返回值 $return$
 * @创建人 czb
 * @创建时间 $date$
 * @修改人和其它信息
 */
@Component
public class RetEntry {

    private String status;

    private List<?> retList;

    private Integer pageSize;

    private Integer currentPage;
    private Integer totalCount;


    public RetEntry(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "RetEntry{" +
                "status='" + status + '\'' +
                ", retList=" + retList +
                ", pageSize=" + pageSize +
                ", currentPage=" + currentPage +
                ", totalCount=" + totalCount +
                '}';
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public RetEntry(String status, List<?> retList, Integer pageSize, Integer currentPage) {
        this.status = status;
        this.retList = retList;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
    }

    public RetEntry() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<?> getRetList() {
        return retList;
    }

    public void setRetList(List<?> retList) {
        this.retList = retList;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

}
