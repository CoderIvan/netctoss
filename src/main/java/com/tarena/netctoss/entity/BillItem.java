package com.tarena.netctoss.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BillItem {
	@Id
	// BillItem表
	private Integer id;// 账单明细ID
	private Double cost;// 费用
	private Integer billId;// 账单ID
	// SERVICE表
	private String osUsername;// OS 账号
	private String hostId; // 服务器 IP
	private Integer accountId;// 账务账号ID
	// SERVICE_DETAIL表
	private Long duration;// 时长
	// COST表
	private String costName;// 资费名

	public BillItem() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getOsUsername() {
		return osUsername;
	}

	public void setOsUsername(String osUsername) {
		this.osUsername = osUsername;
	}

	public String getHostId() {
		return hostId;
	}

	public void setHostId(String hostId) {
		this.hostId = hostId;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public String getCostName() {
		return costName;
	}

	public void setCostName(String costName) {
		this.costName = costName;
	}

	public void setBillId(Integer billId) {
		this.billId = billId;
	}

	public Integer getBillId() {
		return billId;
	}
}
