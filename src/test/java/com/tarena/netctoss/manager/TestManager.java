package com.tarena.netctoss.manager;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

/**
 * 提供测试用的支持类
 * 
 * 该类在事务管理下
 * 
 * @author Ivan
 * @since 2014-3-30
 */
@Service
public class TestManager {

	@Resource
	private SessionFactory sessionFactory;

	public Criteria getCriteria(Class<?> clazz) throws Exception {
		return getSession().createCriteria(clazz);
	}
	
	public Query getQuery(String hql) throws Exception{
		return getSession().createQuery(hql);
	}
	
	public Session getSession() throws Exception {
		return sessionFactory.getCurrentSession();
	}
	
	public void flush() throws Exception{
		getSession().flush();
	}
	
	public void clear() throws Exception{
		getSession().clear();
	}
}
