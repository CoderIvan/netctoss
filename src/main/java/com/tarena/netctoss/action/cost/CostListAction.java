package com.tarena.netctoss.action.cost;

import javax.annotation.Resource;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.bean.MyPager;
import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.manager.CostManager;

/**
 * 资费管理主页面控制
 * 
 * @author Ivan
 * 
 * @since 2013-10-22
 */
public class CostListAction extends BaseAction {
	@Resource
	private CostManager costManager;
	private Pager costPager;
	private String sortKey;
	private String sortValue;

	// 获取分页后的资费信息
	public String list() throws Exception {
		costPager = costManager.list(new MyPager(httpRequest, 5),sortKey,sortValue);
		return SUCCESS;
	}

	public Pager getCostPager() {
		return costPager;
	}

	public void setCostPager(Pager costPager) {
		this.costPager = costPager;
	}

	public String getSortKey() {
		return sortKey;
	}

	public void setSortKey(String sortKey) {
		this.sortKey = sortKey;
	}

	public String getSortValue() {
		return sortValue;
	}

	public void setSortValue(String sortValue) {
		this.sortValue = sortValue;
	}
}
