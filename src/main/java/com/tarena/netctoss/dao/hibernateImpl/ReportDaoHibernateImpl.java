package com.tarena.netctoss.dao.hibernateImpl;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.dao.ReportDao;
import com.tarena.netctoss.entity.report.CustomerDuration;
import com.tarena.netctoss.entity.report.DurationTopThree;

@Repository
public class ReportDaoHibernateImpl implements ReportDao {
	@Resource
	private SessionFactory sessionFactory;

	// 获取Session
	private Session getSession() throws Exception {
		return sessionFactory.getCurrentSession();
	}

	private static final String CUSTOMER_DURATION = "SELECT A.ID,A.LOGINNAME,A.REALNAME,A.IDCARDNO,A.TELEPHONE,TO_CHAR(SD.LOGOUTTIME,'yyyyMM') MONTH,SUM(SD.DURATION) DURATION"
			+ " FROM ACCOUNT A, SERVICE S, SERVICE_DETAIL SD"
			+ " WHERE A.ID = S.ACCOUNT_ID AND S.ID = SD.SERVICE_ID"
			+ " GROUP BY A.ID,A.LOGINNAME,A.REALNAME,A.IDCARDNO,A.TELEPHONE,SD.LOGOUTTIME"
			+ " ORDER BY A.ID,MONTH";
	private static final String CUSTOMER_DURATION_COUNT = "SELECT COUNT(*) FROM (" + CUSTOMER_DURATION + ")";

	private static final String DURATION_TOP_THREE = "SELECT UNIXHOST,OSUSERNAME,REALNAME,IDCARDNO,DURATION FROM ("
			+ " SELECT S.HOST_ID UNIXHOST,D.OSUSERNAME,A.REALNAME,A.IDCARDNO,SUM(D.DURATION) DURATION, ROW_NUMBER() OVER(PARTITION BY S.HOST_ID ORDER BY SUM(D.DURATION) DESC) RN"
			+ " FROM SERVICE_DETAIL D JOIN SERVICE S ON D.SERVICE_ID = S.ID JOIN ACCOUNT A ON S.ACCOUNT_ID = A.ID"
			+ " GROUP BY S.HOST_ID,D.OSUSERNAME,A.REALNAME,A.IDCARDNO"
			+ " ) WHERE RN<=3";
	private static final String DURATION_TOP_THREE_COUNT = "SELECT COUNT(*) FROM (" + DURATION_TOP_THREE + ")";

	@Override
	public Pager findCustomerDuration(Pager pager) throws Exception {
		SQLQuery listQuery = getSession().createSQLQuery(CUSTOMER_DURATION).addEntity(CustomerDuration.class);
		SQLQuery countQuery = getSession().createSQLQuery(CUSTOMER_DURATION_COUNT);
		return setPagerByQuery(listQuery,countQuery,pager);
	}
	
	@Override
	public Pager findDurationTopThree(Pager pager) throws Exception {
		SQLQuery listQuery = getSession().createSQLQuery(DURATION_TOP_THREE).addEntity(DurationTopThree.class);
		SQLQuery countQuery = getSession().createSQLQuery(DURATION_TOP_THREE_COUNT);
		return setPagerByQuery(listQuery,countQuery,pager);
	}
	
	@Override
	public Pager findHostUsed(Pager pager) throws Exception{
		Query listQuery = getSession().createQuery("from Host");
		Query countQuery = getSession().createQuery("select count(*) from Host");
		return setPagerByQuery(listQuery,countQuery,pager);
	}

	private Pager setPagerByQuery(Query listQuery, Query countQuery, Pager pager)
			throws Exception {
		listQuery.setMaxResults(pager.getPageSize());
		listQuery.setFirstResult(pager.getPageSize() * (pager.getPage() - 1));
		pager.setList(listQuery.list());

		Integer totalCount = Integer.valueOf(countQuery.uniqueResult().toString());
		pager.setTotalCount(totalCount);
		return pager;
	}
}
