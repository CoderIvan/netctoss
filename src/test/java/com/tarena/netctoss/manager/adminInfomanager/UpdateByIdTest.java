package com.tarena.netctoss.manager.adminInfomanager;

import java.util.Date;

import javax.annotation.Resource;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import com.tarena.netctoss.BaseConfig;
import com.tarena.netctoss.entity.AdminInfo;
import com.tarena.netctoss.entity.RoleInfo;
import com.tarena.netctoss.manager.AdminInfoManager;

public class UpdateByIdTest extends BaseConfig  {
	@Resource
	private AdminInfoManager adminInfoManager;
	private AdminInfo adminInfo;
	
	public UpdateByIdTest() {
		adminInfo = new AdminInfo(null,new Integer[]{1,2},"Ivan","123456","测试的程序员","13798988787","43811702@qq.com",new Date());
	}
	
	@Test
	public void test() throws Exception{
		testManager.getQuery("delete from AdminInfo").executeUpdate();
		Integer id = (Integer) testManager.getSession().save(adminInfo);
		testManager.getSession().flush();
		
		AdminInfo _adminInfo = new AdminInfo();
		_adminInfo.setName("Ivan改");
		_adminInfo.setTelephone("0123456789");
		_adminInfo.setEmail("43811702@test.com");
		_adminInfo.setRoleInfo(new Integer[]{1});
		adminInfoManager.updateById(id, _adminInfo);
		testManager.getSession().flush();
		
		testManager.getSession().evict(adminInfo);
		AdminInfo test_adminInfo =(AdminInfo) testManager.getSession().get(AdminInfo.class, id);
		Assert.assertThat(test_adminInfo,CoreMatchers.notNullValue());
		Assert.assertThat(test_adminInfo.getName(),CoreMatchers.equalTo(adminInfo.getName()));
		Assert.assertThat(test_adminInfo.getTelephone(), CoreMatchers.equalTo(adminInfo.getTelephone()));
		Assert.assertThat(test_adminInfo.getEmail(), CoreMatchers.equalTo(adminInfo.getEmail()));
		Assert.assertThat(test_adminInfo.getRoleInfo().size(), CoreMatchers.equalTo(adminInfo.getRoleInfo().size()));
		int num = 0;
		for (RoleInfo i : adminInfo.getRoleInfo()) {
			for (RoleInfo j : test_adminInfo.getRoleInfo()) {
				if (i.getId() == j.getId()) {
					num++;
				}
			}
		}
		Assert.assertThat(test_adminInfo.getRoleInfo().size(), CoreMatchers.equalTo(num));
	}
}
