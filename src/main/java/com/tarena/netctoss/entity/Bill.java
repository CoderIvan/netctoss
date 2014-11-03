package com.tarena.netctoss.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * 账单信息
 * 
 * @author Ivan
 * @since 2014-4-11
 */
@Entity
public class Bill {
	@Id
	private Integer id;// 主键 ,账单 ID
	@ManyToOne
	private Account account;// 账务账号ID
	private String billMonth;// 账单月份
	private Double cost; // 费用
	private String paymentMode;// 支付方式 (0：现金,1：银行转帐,2：邮局汇款,3：其它)
	private String payState;// 支付状态(0:未支付，1：已支付)

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getBillMonth() {
		return billMonth;
	}

	public void setBillMonth(String billMonth) {
		this.billMonth = billMonth;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getPayState() {
		return payState;
	}

	public void setPayState(String payState) {
		this.payState = payState;
	}

}
