package com.tarena.netctoss.manager.adminInfomanager;

import java.util.Date;

import javax.annotation.Resource;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import com.tarena.netctoss.BaseConfig;
import com.tarena.netctoss.entity.AdminInfo;
import com.tarena.netctoss.manager.AdminInfoManager;

public class DeleteById extends BaseConfig {

	@Resource
	private AdminInfoManager adminInfoManager;
	
	private AdminInfo adminInfo;
	
	public DeleteById() {
		adminInfo = new AdminInfo(null,new Integer[]{1,2},"Ivan","123456","测试的程序员","13798988787","43811702@qq.com",new Date());
	}
	
	@Test
	public void deleteById() throws Exception {
		testManager.getQuery("delete from AdminInfo").executeUpdate();
		Integer id = (Integer) testManager.getSession().save(adminInfo);
		testManager.getSession().flush();
		
		adminInfoManager.deleteById(id);
		testManager.getSession().flush();
		testManager.getSession().clear();
		
		AdminInfo adminInfo = (AdminInfo) testManager.getSession().get(AdminInfo.class, id);
		Assert.assertThat(adminInfo, CoreMatchers.nullValue());
	}
}
