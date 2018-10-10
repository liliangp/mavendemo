package com.hote.entity;

import java.util.List;

public class Page<T> {
	//当前页面
	private int currentPage;
	
	//页面大小
	private int pageSize;
	
	//总页数
	private int totalPage;
	
	//总计录数
	private int count;
	
	//页面内容
	List<T> content;
    
	public Page(){
		
	}
    public Page(int currentPage,int pageSize,int count,List<T> content){
    	this.currentPage=currentPage;
    	this.pageSize=pageSize;
    	this.count=count;
    	this.content=content;
		
	}
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		totalPage=(int)Math.ceil(count/(pageSize*1.0));
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}
    
}
