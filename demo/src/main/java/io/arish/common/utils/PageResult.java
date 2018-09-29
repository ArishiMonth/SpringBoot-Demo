package io.arish.common.utils;

import java.util.Collections;
import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
/**
 *重新封装返回类 
 * */
public class PageResult {
	/**
	 * 当前页码
	 * */
	private int current;
	/**
	 * 每页数量
	 * */
	private int limit;
	/**
	 * 总条数
	 * */
	private long total;
	/**
	 * 总页数
	 * */
	private int pages;
	private List<?> records = Collections.emptyList();
	public PageResult(){}
	public PageResult(Page<?> page){
	  this.current=page.getCurrent();
	  this.limit=page.getLimit();
	  this.total=page.getTotal();
	  this.setPages(page.getPages());
	  this.records=page.getRecords();
	}
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
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
	public List<?> getRecords() {
		return records;
	}
	public void setRecords(List<?> records) {
		this.records = records;
	}

}
