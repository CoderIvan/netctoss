package com.tarena.netctoss.action.cost;

import javax.annotation.Resource;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.entity.Cost;
import com.tarena.netctoss.manager.CostManager;

/**
 * 查看资费详细信息
 * 
 * @author Ivan
 * 
 * @since 2013-11-21
 */
public class CostDetailAction extends BaseAction {
	@Resource
	private CostManager costManager;
	private Cost cost;
	private Integer id;

	public String detail() throws Exception {
		cost = costManager.get(id);
		return SUCCESS;
	}

	public Cost getCost() {
		return cost;
	}

	public void setCost(Cost cost) {
		this.cost = cost;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
