package com.tarena.netctoss.action.account;

import javax.annotation.Resource;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.manager.AccountManager;

/**
 * 账务账号暂停、开通与删除控制
 * 
 * @author Ivan
 * 
 * @since 2013-10-20
 */
public class AccountSetStatusAction extends BaseAction {
	@Resource
	private AccountManager accountManager;
	private int id;

	// 暂停账号
	public String pause() throws Exception {
		return runAjaxJSON(new IAjaxJSONCB(){
			@Override
			public void run() throws Exception {
				accountManager.updateStatusByPause(id);
			}
		});
	}

	// 开通账号
	public String open() throws Exception {
		return runAjaxJSON(new IAjaxJSONCB(){
			@Override
			public void run() throws Exception {
				accountManager.updateStatusByOpen(id);
			}
		});
	}

	// 删除账号
	public String delete() throws Exception {
		return runAjaxJSON(new IAjaxJSONCB(){
			@Override
			public void run() throws Exception {
				accountManager.updateStatusByDelete(id);
			}
		});
	}


	public void setId(int id) {
		this.id = id;
	}
}
