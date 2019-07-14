package com.god.common.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 分页请求结果
 * @author H__D
 * @date 2018-11-15 00:50:17
 *
 * @param <T>
 */
public class PageResult<T> implements Serializable{

    
    /**
     * 页码，从1开始
     */
    private int pageNum;
    /**
     * 页面大小
     */
    private int pageSize;
    /**
     * 总数
     */
    private long total;
    /**
     * 总页数
     */
    private int pages;
    
    /**
     * 返回的数据结果集
     */
    private List<T> rows;
    
    public PageResult() {

    }
    
    public PageResult(long total, int pageNum, int pageSize) {
        this.rows = new ArrayList<T>();
        this.total = total;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.pages = (int) (total % pageSize == 0 ? total/pageSize : (total/pageSize + 1));
    }

    public PageResult(List<T> resultList, long total, int pageNum, int pageSize) {
        this.rows = resultList;
        this.total = total;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.pages = (int) (total % pageSize == 0 ? total/pageSize : (total/pageSize + 1));
    }

    public PageResult(List<T> resultList, Integer total, Integer pages, Integer pageNum, Integer pageSize) {
        this.rows = resultList;
        this.total = total;
        this.pages = pages;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

    
}
