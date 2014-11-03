package com.tarena.netctoss.manager.roleInfomanager;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;

import com.tarena.netctoss.BaseConfig;
import com.tarena.netctoss.entity.Privilege;
import com.tarena.netctoss.entity.RoleInfo;
import com.tarena.netctoss.manager.RoleInfoManager;

public class listTest extends BaseConfig{
	@Resource
	private RoleInfoManager roleInfoManager;
	
	@Test
	public void testList() throws Exception{
		List<RoleInfo> roleInfos = roleInfoManager.list();
		for(RoleInfo roleInfo : roleInfos){
			roleInfo.getId();
			roleInfo.getName();
			roleInfo.getPrivilege().toString();
		}
		
		System.err.println();
		
		for(RoleInfo roleInfo : roleInfos){
			System.err.println("===============================");
			System.err.println("ID:"+roleInfo.getId());
			System.err.println("NAME:"+roleInfo.getName());
			System.err.println("PRIVILEGE:{");
			for(Privilege p : roleInfo.getPrivilege()){
				System.err.println("["+p.getId()+"|"+p.getModuleName()+"|"+p.getUrl()+"]");
			}
			System.err.println("}");
			System.err.println("===============================");
			System.err.println();
		}
	}
}
