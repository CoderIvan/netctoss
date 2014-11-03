package com.tarena.netctoss.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * 资费对象，针对 TELNET服务的各种资费标准
 * 
 * @author Ivan
 * 
 * @since 2013-11-18
 */
@Entity
public class Cost {
	@Id
	@SequenceGenerator(name = "SEQUENCE", sequenceName = "COST_ID_SQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE")
	private Integer id;// 资费ID
	private String name; // 资费名称
	private Integer baseDuration;// 包在线时长
	private Float baseCost;// 月固定费用
	private Float unitCost;// 单位费用
	private String status;// 资费状态{"0":"开通","1":"暂停","2":"删除"}
	private String descr;// 对资费信息的说明
	private Date createTime;// 创建日期
	private Date startTime;// 启用日期
	private String costType; // 资费类型：{"1":"包月","2":"套餐","3":"计时"}

	public Cost() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBaseDuration() {
		return baseDuration;
	}

	public void setBaseDuration(Integer baseDuration) {
		this.baseDuration = baseDuration;
	}

	public Float getBaseCost() {
		return baseCost;
	}

	public void setBaseCost(Float baseCost) {
		this.baseCost = baseCost;
	}

	public Float getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(Float unitCost) {
		this.unitCost = unitCost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getCostType() {
		return costType;
	}

	public void setCostType(String costType) {
		this.costType = costType;
	}

}
