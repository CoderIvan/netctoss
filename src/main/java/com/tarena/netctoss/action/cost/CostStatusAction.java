package com.tarena.netctoss.action.cost;

import javax.annotation.Resource;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.manager.CostManager;

/**
 * 开通资费与暂停资费-控制
 * 
 * @author Ivan
 * 
 * @since 2013-11-20
 */
public class CostStatusAction extends BaseAction {
	@Resource
	private CostManager costManager;
	private Integer id;

	// 开通资费控制
	public String open() throws Exception {
		return runAjaxJSON(new IAjaxJSONCB(){
			@Override
			public void run() throws Exception {
				costManager.open(id);
			}
		});
	}

	// 暂停资费控制
	public String delete() throws Exception {
		return runAjaxJSON(new IAjaxJSONCB(){
			@Override
			public void run() throws Exception {
				costManager.delete(id);
			}
		});
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
