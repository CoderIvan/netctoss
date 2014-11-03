package com.tarena.netctoss.dao.hibernateImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;

import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.dao.AdminInfoDao;
import com.tarena.netctoss.entity.AdminInfo;

@Repository
public class AdminInfoDaoHibernateImpl extends
		BaseDaoHibernateImpl<AdminInfo, Integer> implements AdminInfoDao {

	@Override
	@SuppressWarnings("unchecked")
	public List<Integer> getUrlsByAdminId(Integer adminId) throws Exception {
		String hql = "select rp.privilegeId"
				+ " from AdminInfo a join a.roleInfo r join r.rolePrivileges rp"
				+ " where a.id=:id";
		Query query = getSession().createQuery(hql);
		query.setInteger("id", adminId);
		return query.list();
	}

	@Override
	public Pager list(Pager pager, Integer privilegeId, Integer roleInfoId)
			throws Exception {
		// 搜索所有满足条件的adminInfo_id
		Criteria subSelect = getCriteria();
		subSelect.setProjection(Projections.distinct(Property.forName("id"))).addOrder(Order.asc("id"));// 只搜ID,去重
		if (roleInfoId != null || privilegeId != null) {
			subSelect.createAlias("roleInfo","roleInfo");
			if (roleInfoId != null) {
				subSelect.add(Restrictions.eq("roleInfo.id", roleInfoId));// 添加角色ID的过滤
			}
			if (privilegeId != null) {
				subSelect.createAlias("roleInfo.privilege","privilege");
				subSelect.add(Restrictions.eq("privilege.id",privilegeId));//添加权限ID的过滤
			}
		}

		// 通过adminInfo_id搜索出所有AdminInfo，并关联RoleInfo
		@SuppressWarnings("unchecked")
		List<Integer> adminIds = subSelect.list();
		if (adminIds != null && adminIds.size() != 0) {
			Criteria criteria = getCriteria();
			// 对已分页的admin_id进行子查询，并按ID升序
			List<Integer> subList = subList(adminIds,pager.getPageSize(),pager.getPage());
			criteria.add(Restrictions.in("id", subList)).addOrder(Order.asc("id"));
			// 关联ROLEINFO，并按ID升序
			criteria.createCriteria("roleInfo", JoinType.LEFT_OUTER_JOIN);
			// 查询完成后进行去重
			criteria.setResultTransformer(DetachedCriteria.DISTINCT_ROOT_ENTITY);
			// 设置Pager对象
			pager.setList(criteria.list());
			pager.setTotalCount(adminIds.size());
		}
		return pager;
	}
	
	protected <T> List<T> subList(List<T> list , int pageSize , int page) throws Exception{
		int beginIndex = pageSize * (page - 1);
		int endIndex = Math.min(pageSize * page , list.size());
		return list.subList(beginIndex, endIndex);
	}
}
