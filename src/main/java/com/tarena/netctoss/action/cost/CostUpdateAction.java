package com.tarena.netctoss.action.cost;

import javax.annotation.Resource;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.entity.Cost;
import com.tarena.netctoss.manager.CostManager;

/**
 * 修改资费-控制
 * 
 * @author Ivan
 * 
 * @since 2013-11-22
 */
/**
 * @author Ivan
 * 
 */
public class CostUpdateAction extends BaseAction {
	@Resource
	private CostManager costManager;
	private Integer id;
	private Cost cost;

	private Integer costId;
	private String name;
	private String costType;
	private Integer baseDuration;
	private Float baseCost;
	private Float unitCost;
	private String descr;

	// 链接至更新页面
	public String toUpdate() throws Exception {
		cost = costManager.get(id);
		return SUCCESS;
	}

	// 更新资费信息
	public String update() throws Exception {
		return runAjaxJSON(new IAjaxJSONCB(){
			@Override
			public void run() throws Exception {
				Cost cost = new Cost();
				cost.setId(costId);
				cost.setName(name);
				cost.setCostType(costType);
				cost.setBaseDuration(baseDuration);
				cost.setBaseCost(baseCost);
				cost.setUnitCost(unitCost);
				cost.setDescr(descr);
				costManager.update(cost);
			}
		});
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cost getCost() {
		return cost;
	}

	public void setCostId(Integer costId) {
		this.costId = costId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCostType(String costType) {
		this.costType = costType;
	}

	public void setBaseDuration(Integer baseDuration) {
		this.baseDuration = baseDuration;
	}

	public void setBaseCost(Float baseCost) {
		this.baseCost = baseCost;
	}

	public void setUnitCost(Float unitCost) {
		this.unitCost = unitCost;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}
}
