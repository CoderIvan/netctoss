package com.tarena.netctoss.action.account;

import javax.annotation.Resource;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.entity.Account;
import com.tarena.netctoss.manager.AccountManager;

/**
 * 链接至账务账号修改页面
 * 
 * @author Ivan
 * 
 * @since 2013-10-20
 */
public class AccountUpdateAction extends BaseAction {
	@Resource
	private AccountManager accountManager;
	private int id;
	private Account account;
	private String recommenderIdcardNo;

	// private boolean UpdatePassword;

	// 链接至修改页面
	public String toUpdate() throws Exception {
		account = accountManager.getById(id);
		if (account != null && account.getRecommenderId() != null) {
			recommenderIdcardNo = accountManager.getIdcardNoById(account.getRecommenderId());
		}
		return SUCCESS;
	}
	
	public void setaccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRecommenderIdcardNo() {
		return recommenderIdcardNo;
	}

	public void setRecommenderIdcardNo(String recommenderIdcardNo) {
		this.recommenderIdcardNo = recommenderIdcardNo;
	}
}
