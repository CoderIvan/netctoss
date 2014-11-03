package com.tarena.netctoss.bean;

import java.util.List;

/**
 * 分页的基础类
 * 
 * @author Ivan
 * 
 * @since 2013-9-18
 */
public class Pager {

	// 当前页数，默认为1;
	private int page = 1;

	// 每页多少条，默认每页5条记录，想改的话有提供相应的构造器
	private int pageSize = 5;

	// 总共多少条记录
	private int totalCount;

	// 查询出来封装好的属性
	private List<?> list;

	public Pager() {

	}

	public Pager(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

}
