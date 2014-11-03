package com.tarena.netctoss.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Formula;

/**
 * UNIX服务器信息表， 记录提供远程登记录的UNIX服务器
 * 
 * @author Ivan
 * 
 */
@Entity
public class Host {
	@Id
	private String id;
	private String name;
	private String location;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	// 存储该服务器中包月的使用次数
	@Formula(value = "(SELECT COUNT(*) FROM SERVICE S,COST C WHERE S.COST_ID=C.ID AND S.HOST_ID=ID AND C.COSTTYPE='1')")
	private Integer c1;
	// 存储该服务器中套餐的使用次数
	@Formula(value = "(SELECT COUNT(*) FROM SERVICE S,COST C WHERE S.COST_ID=C.ID AND S.HOST_ID=ID AND C.COSTTYPE='2')")
	private Integer c2;
	// 存储该服务器中计时的使用次数
	@Formula(value = "(SELECT COUNT(*) FROM SERVICE S,COST C WHERE S.COST_ID=C.ID AND S.HOST_ID=ID AND C.COSTTYPE='3')")
	private Integer c3;

	public Integer getC1() {
		return c1;
	}

	public Integer getC2() {
		return c2;
	}

	public Integer getC3() {
		return c3;
	}

	public void setC1(Integer c1) {
		this.c1 = c1;
	}

	public void setC2(Integer c2) {
		this.c2 = c2;
	}

	public void setC3(Integer c3) {
		this.c3 = c3;
	}
}
