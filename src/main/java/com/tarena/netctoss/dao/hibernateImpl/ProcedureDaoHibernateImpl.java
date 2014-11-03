package com.tarena.netctoss.dao.hibernateImpl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.tarena.netctoss.dao.ProcedureDao;

@Repository
public class ProcedureDaoHibernateImpl implements ProcedureDao {
	@Resource
	private SessionFactory sessionFactory;

	// 获取Session
	protected Session getSession() throws Exception {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void callGBillAll() throws Exception {
		getSession().createSQLQuery("call GBILL_ALL()").executeUpdate();
	}

	@Override
	public void callUpdateServiceCost() throws Exception {
		getSession().createSQLQuery("call UPDATE_SERVICE_COST()").executeUpdate();
	}
}
