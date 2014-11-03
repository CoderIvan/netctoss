package com.tarena.netctoss.action.cost;

import javax.annotation.Resource;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.manager.CostManager;

/**
 * 添加资费-控制
 * 
 * @author Ivan
 * 
 * @since 2013-11-2
 */
public class AddCostAction extends BaseAction {
	@Resource
	private CostManager costManager;
	private String feeName;// 资费名称
	private String costType;// 资费类型：{1:包月,2:套餐,3:计时}
	private Integer baseDuration;// 基本时长
	private Float baseCost;// 基本费用
	private Float unitCost;// 单位费用
	private String descr; // 资费说明

	// 添加资费信息
	public String add() throws Exception {
		return runAjaxJSON(new IAjaxJSONCB(){
			@Override
			public void run() throws Exception {
				costManager.save(feeName, costType, baseDuration, baseCost,unitCost, descr);
			}
		});
	}

	public void setFeeName(String feeName) {
		this.feeName = feeName;
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
