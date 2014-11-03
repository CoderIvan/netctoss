package com.tarena.netctoss.manager.adminInfomanager;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hamcrest.CoreMatchers;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.junit.Assert;
import org.junit.Test;

import com.tarena.netctoss.BaseConfig;
import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.entity.AdminInfo;
import com.tarena.netctoss.manager.AdminInfoManager;

public class AdminInfoManagerTest extends BaseConfig {

	@Resource
	private AdminInfoManager adminInfoManager;
	
	private List<AdminInfo> adminInfos = new ArrayList<AdminInfo>();

	public AdminInfoManagerTest() {
		super();
		adminInfos.add(new AdminInfo(null,new Integer[]{1,2},"Ivan","123456","测试的程序员","13798988787","43811702@qq.com",null));
		adminInfos.add(new AdminInfo(null,new Integer[]{1,2},"test1","test1","测试的程序员","13798988787","43811702@qq.com",null));
		adminInfos.add(new AdminInfo(null,new Integer[]{1,2},"test2","test2","测试的程序员","13798988787","43811702@qq.com",null));
		adminInfos.add(new AdminInfo(null,new Integer[]{1,2},"test3","test3","测试的程序员","13798988787","43811702@qq.com",null));
		adminInfos.add(new AdminInfo(null,new Integer[]{1,2},"test4","test4","测试的程序员","13798988787","43811702@qq.com",null));
		adminInfos.add(new AdminInfo(null,new Integer[]{1,2},"test5","test5","测试的程序员","13798988787","43811702@qq.com",null));
		adminInfos.add(new AdminInfo(null,new Integer[]{1,2},"test6","test6","测试的程序员","13798988787","43811702@qq.com",null));
	}
	
	@Test
	public void testSave() throws Exception {
		testManager.getQuery("delete from AdminInfo").executeUpdate();
		for(int i = 0 ; i < 1 ; i++){
			AdminInfo adminInfo = adminInfos.get(0);
			adminInfoManager.save(adminInfo);
			
			Criteria criteria = testManager.getCriteria(AdminInfo.class);
			criteria.add(Restrictions.eq("adminCode",adminInfo.getAdminCode()));
			criteria.add(Restrictions.eq("password", adminInfo.getPassword()));
			criteria.add(Restrictions.eq("name", adminInfo.getName()));
			criteria.add(Restrictions.eq("telephone", adminInfo.getTelephone()));
			criteria.add(Restrictions.eq("email", adminInfo.getEmail()));
			AdminInfo test_adminInfo = (AdminInfo) criteria.uniqueResult();
			
			Assert.assertThat(test_adminInfo, CoreMatchers.notNullValue());
			Assert.assertThat(test_adminInfo.getAdminCode(), CoreMatchers.equalTo(adminInfo.getAdminCode()));
			Assert.assertThat(test_adminInfo.getPassword(), CoreMatchers.equalTo(adminInfo.getPassword()));
			Assert.assertThat(test_adminInfo.getName(), CoreMatchers.equalTo(adminInfo.getName()));
			Assert.assertThat(test_adminInfo.getTelephone(), CoreMatchers.equalTo(adminInfo.getTelephone()));
			Assert.assertThat(test_adminInfo.getEmail(), CoreMatchers.equalTo(adminInfo.getEmail()));
			Assert.assertThat(test_adminInfo.getRoleInfo().size(), CoreMatchers.equalTo(adminInfo.getRoleInfo().size()));
		}
	}
	
	@Test
	public void testList() throws Exception{
		adminInfoManager.list(new Pager(5), null, null);
//		adminInfoManager.list(new Pager(5), null, 1);
//		adminInfoManager.list(new Pager(5), 1, null);
//		adminInfoManager.list(new Pager(5), 1, 1);
	}
	
	@Test
	public void testReset() throws Exception{
		List<Integer> adminInfoId = new ArrayList<Integer>();
		testManager.getQuery("delete from AdminInfo").executeUpdate();

		for(int i = 0 ; i < adminInfos.size() ; i++){
			adminInfoId.add(adminInfoManager.save(adminInfos.get(i)));
		}
		
		Assert.assertThat(adminInfoManager.updateByReset(adminInfoId),CoreMatchers.equalTo(adminInfoId.size()));
		testManager.getSession().clear();
		/** 不是同一事务 ？？ */
		/** 注意要清除一级缓存 */
		for(Integer id : adminInfoId){
			AdminInfo test_adminInfo = adminInfoManager.get(id);
			Assert.assertThat(test_adminInfo.getPassword(), CoreMatchers.equalTo("111111"));
		}
	}
}
