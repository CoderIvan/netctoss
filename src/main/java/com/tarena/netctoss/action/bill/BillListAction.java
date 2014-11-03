package com.tarena.netctoss.action.bill;

import javax.annotation.Resource;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.bean.MyPager;
import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.manager.BillManager;

/**
 * 查看账单列表 请求
 * 
 * @author Ivan
 * @since 2014-4-12
 */
public class BillListAction extends BaseAction {

	@Resource
	private BillManager billManager;

	private String idcardNo;// 身份证
	private String loginName;// 账务账号
	private String realName;// 姓名
	private String year;// 年份
	private String month; // 月份
	private Pager billPager;

	public String index() throws Exception {
		billPager = billManager.list(new MyPager(httpRequest, 5), idcardNo,
				loginName, realName, year, month);
		return SUCCESS;
	}

	public Pager getBillPager() {
		return billPager;
	}

	public String getIdcardNo() {
		return idcardNo;
	}

	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

}
