package com.tarena.netctoss.manager.loginmanager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import com.tarena.netctoss.BaseConfig;
import com.tarena.netctoss.entity.AdminInfo;
import com.tarena.netctoss.manager.LoginManager;

public class LoginManagerTest extends BaseConfig {
	
	@Resource
	private LoginManager loginManager;
	
	private List<AdminInfo> adminInfos = new ArrayList<AdminInfo>();

	public LoginManagerTest() {
		super();
		adminInfos.add(new AdminInfo(null,new Integer[]{1,2},"admin","111111","测试的程序员","13798988787","43811702@qq.com",new Date()));
		adminInfos.add(new AdminInfo(null,new Integer[]{1,2},"lily","lily123","测试的程序员","13798988787","43811702@qq.com",new Date()));
		adminInfos.add(new AdminInfo(null,new Integer[]{1,2},"test2","test2","测试的程序员","13798988787","43811702@qq.com",new Date()));
		adminInfos.add(new AdminInfo(null,new Integer[]{1,2},"test3","test3","测试的程序员","13798988787","43811702@qq.com",new Date()));
		adminInfos.add(new AdminInfo(null,new Integer[]{1,2},"test4","test4","测试的程序员","13798988787","43811702@qq.com",new Date()));
		adminInfos.add(new AdminInfo(null,new Integer[]{1,2},"test5","test5","测试的程序员","13798988787","43811702@qq.com",new Date()));
		adminInfos.add(new AdminInfo(null,new Integer[]{1,2},"test6","test6","测试的程序员","13798988787","43811702@qq.com",new Date()));
	}
	
	@Test
	public void testLogin() throws Exception {
		testManager.getQuery("delete from AdminInfo").executeUpdate();
		
		for(AdminInfo adminInfo : adminInfos){
			testManager.getSession().save(adminInfo);
		}
		
		testManager.getSession().flush();
		testManager.getSession().clear();
		
		for(AdminInfo adminInfo : adminInfos){
			AdminInfo result_adminInfo = loginManager.login(adminInfo.getAdminCode(), adminInfo.getPassword());
			
			Assert.assertThat(result_adminInfo, CoreMatchers.notNullValue());
			Assert.assertThat(result_adminInfo.getAdminCode(), CoreMatchers.equalTo(adminInfo.getAdminCode()));
			Assert.assertThat(result_adminInfo.getPassword(), CoreMatchers.equalTo(adminInfo.getPassword()));
		}
	}
}
