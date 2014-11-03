package com.tarena.netctoss.dao.hibernateImpl;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.dao.ServiceDao;
import com.tarena.netctoss.entity.Service;
import com.tarena.netctoss.util.Const;

@Repository
public class ServiceDaoHibernateImpl extends
BaseDaoHibernateImpl<Service, Integer> implements ServiceDao {

	@Override
	public Pager list(final String accountIdcardNo, final String hostId, final String osUsername,
			final String status, Pager pager) throws Exception {
		
		 return listByCriteria(new MyCriteria() {
			@Override
			public Criteria set(Criteria criteria) throws Exception {
				if (!StringUtils.isEmpty(osUsername)) {
					criteria.add(Restrictions.like("osUsername", osUsername,
							MatchMode.ANYWHERE));
				}
				if (Const.SERVICE_STATUS_DELETE.equals(status) || Const.SERVICE_STATUS_OPEN.equals(status) || Const.SERVICE_STATUS_PAUSE.equals(status)) {
					criteria.add(Restrictions.eq("status", status));
				}
				if (!StringUtils.isEmpty(hostId)) {
					criteria.createCriteria("host").add(Restrictions.like("id", hostId, MatchMode.ANYWHERE));
				}
				if (!StringUtils.isEmpty(accountIdcardNo)) {
					criteria.createCriteria("account").add(Restrictions.like("idcardNo", accountIdcardNo,MatchMode.ANYWHERE));
				}
				criteria.addOrder(Order.asc("id"));
				return criteria;
			}
		}, pager);
	}
	
	@Override
	public int pauseServiceByAccountId(Integer accountId) throws Exception{
		String hql = "update Service s set s.status = :newStatus" +
				" , s.pauseDate = :pauseDate" +
				" where s.account.id = :accountId" +
				" and s.status = :status";
		Query query = getSession().createQuery(hql);
		query.setString("newStatus", Const.SERVICE_STATUS_PAUSE);
		query.setTimestamp("pauseDate", new Date());
		query.setInteger("accountId",accountId);
		query.setString("status", Const.SERVICE_STATUS_OPEN);//只暂停开通的业务账号
		return query.executeUpdate();
	}
	
	@Override
	public int deleteServiceByAccountId(Integer accountId) throws Exception{
		String hql = "update Service s set s.status = :newStatus" +
				" , s.closeDate = :closeDate" +
				" where s.account.id = :accountId";
		Query query = getSession().createQuery(hql);
		query.setString("newStatus", Const.SERVICE_STATUS_DELETE);
		query.setTimestamp("closeDate", new Date());
		query.setInteger("accountId",accountId);
		return query.executeUpdate();
	}
}
