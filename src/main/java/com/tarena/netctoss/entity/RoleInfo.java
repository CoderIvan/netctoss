package com.tarena.netctoss.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;

@Entity
public class RoleInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE")
	@SequenceGenerator(name = "SEQUENCE", sequenceName = "ROLEINFO_ID_SQ", allocationSize = 1)
	private Integer id;
	private String name;
	@ManyToMany
	@OrderBy
	private Set<Privilege> privilege;

	public RoleInfo() {
		super();
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

	public Set<Privilege> getPrivilege() {
		return privilege;
	}

	public void setPrivilege(Set<Privilege> privilege) {
		this.privilege = privilege;
	}
	
	public void setPrivilege(Integer[] privilegeId) {
		if(this.privilege == null){
			this.privilege = new HashSet<Privilege>();
		}else{
			this.privilege.clear();
		}
		for(Integer id : privilegeId){
			this.privilege.add(new Privilege(id));
		}
	}

}
