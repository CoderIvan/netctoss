package com.tarena.netctoss.dao.hibernateImpl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.tarena.netctoss.dao.RoleInfoDao;
import com.tarena.netctoss.entity.RoleInfo;
@Repository
public class RoleInfoDaoHibernateImpl extends
BaseDaoHibernateImpl<RoleInfo, Integer> implements RoleInfoDao {

	@Override
	public RoleInfo getByAll(Integer id) throws Exception {
		Criteria criteria = getCriteria().add(Restrictions.eq("id", id));
		criteria.createCriteria("privilege",JoinType.LEFT_OUTER_JOIN);
		return (RoleInfo) criteria.uniqueResult();
	}
}
