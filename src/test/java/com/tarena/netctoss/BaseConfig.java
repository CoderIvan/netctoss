package com.tarena.netctoss;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.tarena.netctoss.manager.TestManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/applicationContext.xml" })
@Transactional
@TransactionConfiguration(transactionManager = "txManager")
public class BaseConfig {
	@Resource
	protected TestManager testManager;

	public BaseConfig() {
		super();
		try {
			System.out.println("测试基类加载完成");
		} catch (Exception e) {
			System.out.println("测试基类加载失败");
		}
	}
}
