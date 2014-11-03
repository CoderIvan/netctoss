package com.tarena.netctoss.dao.hibernateImpl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.dao.AccountDao;
import com.tarena.netctoss.entity.Account;
import com.tarena.netctoss.util.Const;

@Repository
public class AccountDaoHibernateImpl extends
BaseDaoHibernateImpl<Account, Integer> implements AccountDao {

	@Override
	public Pager listByCondition(final String idcardNo, final String realName,
			final String loginName, final String status, Pager pager)
			throws Exception {
		return listByCriteria(new MyCriteria() {
			@Override
			public Criteria set(Criteria criteria) throws Exception {
				if (idcardNo != null && !"".equals(idcardNo)) {
					criteria.add(Restrictions.like("idcardNo", "%" + idcardNo + "%"));
				}
				if (realName != null && !"".equals(realName)) {
					criteria.add(Restrictions.like("realName", "%" + realName + "%"));
				}
				if (loginName != null && !"".equals(loginName)) {
					criteria.add(Restrictions.like("loginName", "%" + loginName + "%"));
				}
				if (Const.ACCOUNT_STATUS_OPEN.equals(status)
						|| Const.ACCOUNT_STATUS_PAUSE.equals(status)
						|| Const.ACCOUNT_STATUS_DELETE.equals(status)) {
					criteria.add(Restrictions.eq("status", status));
				}
				criteria.addOrder(Order.asc("id"));
				return criteria;
			}
		}, pager);
	}
}
