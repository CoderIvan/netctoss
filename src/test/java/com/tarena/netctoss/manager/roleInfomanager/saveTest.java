package com.tarena.netctoss.manager.roleInfomanager;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import com.tarena.netctoss.BaseConfig;
import com.tarena.netctoss.entity.Privilege;
import com.tarena.netctoss.entity.RoleInfo;
import com.tarena.netctoss.manager.RoleInfoManager;

public class saveTest extends BaseConfig {
	@Resource
	private RoleInfoManager roleInfoManager;
	
	@Test
	public void save() throws Exception{
		testManager.getQuery("delete from RoleInfo");
		RoleInfo test_roleInfo = new RoleInfo();
		test_roleInfo.setName("test01");
		test_roleInfo.setPrivilege(new Integer[]{1,2,3});
		System.err.println("======================准备测试数据完成======================");

		Integer id = roleInfoManager.save(test_roleInfo);
		testManager.flush();
		System.err.println("======================运行测试主体完成======================");
		
		testManager.clear();
		RoleInfo result_roleInfo = roleInfoManager.get(id);
		List<Integer> test_id = new ArrayList<Integer>();
		for(Privilege p : test_roleInfo.getPrivilege()){
			test_id.add(p.getId());
		}
		List<Integer> result_id = new ArrayList<Integer>();
		for(Privilege p : result_roleInfo.getPrivilege()){
			result_id.add(p.getId());
		}
		
		Assert.assertThat(result_roleInfo.getName(), CoreMatchers.equalTo(test_roleInfo.getName()));
		Assert.assertTrue(result_id.containsAll(test_id));
		Assert.assertTrue(test_id.containsAll(result_id));
		System.err.println("======================数据结果检查成功======================");
	}
}
