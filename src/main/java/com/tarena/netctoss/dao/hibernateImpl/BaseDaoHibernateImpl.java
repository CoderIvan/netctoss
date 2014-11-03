package com.tarena.netctoss.dao.hibernateImpl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.dao.BaseDao;
import com.tarena.netctoss.util.Const;

@Repository
public class BaseDaoHibernateImpl<T, PK extends Serializable> implements
		BaseDao<T, PK> {
	@Resource
	protected SessionFactory sessionFactory;
	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public BaseDaoHibernateImpl() {
		Type type = getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			Type[] parameterizedType = ((ParameterizedType) type)
					.getActualTypeArguments();
			clazz = (Class<T>) parameterizedType[0];
		}
	}

	// 获取Session
	protected Session getSession() throws Exception {
		return sessionFactory.getCurrentSession();
	}

	/* ==============================实现=============================== */

	@Override
	public void delete(T entity) throws Exception {
		getSession().delete(entity);
	}

	@Override
	public void delete(PK id) throws Exception {
		getSession().delete(load(id));
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(PK id) throws Exception {
		return (T) getSession().get(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T load(PK id) throws Exception {
		return (T) getSession().load(clazz, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PK save(T entity) throws Exception {
		return (PK) getSession().save(entity);
	}

	@Override
	public void saveOrUpdate(T entity) throws Exception {
		getSession().saveOrUpdate(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(Map<String, Object> proMap) throws Exception {
		return (T) getCriteria(proMap,null).uniqueResult();
	}

	@Override
	public void update(T entity) throws Exception {
		getSession().update(entity);
	}
	
	public int updateByMap(Map<String,Object> setMap,Map<String,Object> proMap) throws Exception{
		int num = -1 ;
		if(setMap != null && setMap.size() != 0){
			//写HQL语句
			StringBuilder hql = new StringBuilder("UPDATE " +clazz.getSimpleName() + " SET ");
			for(Entry<String,Object> e : setMap.entrySet()){
				hql.append(e.getKey()).append("=:").append(e.getKey()).append(",");
			}
			hql.deleteCharAt(hql.length()-1);
			
			if(proMap.entrySet() != null && proMap.size() != 0 ){
				hql.append(" WHERE ");
				for(Entry<String,Object> e : proMap.entrySet()){
					hql.append(e.getKey());
					if(e.getValue() instanceof Collection || e.getValue() instanceof Object[]){
						hql.append(" in :");
					}else{
						hql.append(" = : ");
					}
					hql.append(e.getKey()).append(",").append(" and ");
				}
				hql.delete(hql.length()-6, hql.length()-1);
			}
			
			Query query = getSession().createQuery(hql.toString());
			
			// 设置属性
			for(Entry<String,Object> e : setMap.entrySet()){
				if(e.getValue() instanceof Collection){
					query.setParameterList(e.getKey(), (Collection<?>) e.getValue());
				}else if(e.getValue() instanceof Object[]){
					query.setParameterList(e.getKey(), Arrays.asList(e.getValue()));
				}else{
					query.setParameter(e.getKey(), e.getValue());
				}
			}
			if(proMap.entrySet() != null && proMap.size() != 0 ){
				for(Entry<String,Object> e : proMap.entrySet()){
					if(e.getValue() instanceof Collection){
						query.setParameterList(e.getKey(), (Collection<?>) e.getValue());
					}else if(e.getValue() instanceof Object[]){
						query.setParameterList(e.getKey(), Arrays.asList(e.getValue()));
					}else{
						query.setParameter(e.getKey(), e.getValue());
					}
				}
			}
			
			num = query.executeUpdate();
		}
		return num;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list() throws Exception {
		return getCriteria().list();
	}

	@Override
	public Pager list(Pager pager) throws Exception {
		return list(pager, null, null);
	}

	@Override
	public Pager listByProMap(Pager pager, Map<String, Object> proMap) throws Exception {
		return list(pager, proMap, null);
	}
	
	@Override
	public Pager listBySortMap(Pager pager, Map<String, String> sortMap)
			throws Exception {
		return list(pager, null, sortMap);
	}

	@Override
	public Pager list(Pager pager, Map<String, Object> proMap, Map<String, String> sortMap) throws Exception {
		pager.setList(getList(getCriteria(proMap, sortMap), pager.getPageSize()	, pager.getPage()));
		pager.setTotalCount(getTotalCount(getCriteria(proMap, sortMap)));
		return pager;
	}

	protected Criteria getCriteria() throws Exception {
		return getSession().createCriteria(clazz);
	}

	protected Criteria getCriteria(Map<String, Object> proMap, Map<String, String> sortMap) throws Exception {
		Criteria criteria = getCriteria();
		if (proMap != null && proMap.size() > 0) {
			for (Entry<String, Object> e : proMap.entrySet()) {
				if (e.getValue() instanceof Object[]) {
					criteria.add(Restrictions.in(e.getKey(), (Object[]) e.getValue()));
				} else if (e.getValue() != null) {
					criteria.add(Restrictions.eq(e.getKey(), e.getValue()));
				}
			}
		}
		if (sortMap != null && sortMap.size() > 0) {
			for (Entry<String, String> e : sortMap.entrySet()) {
				if (Const.SORT_ASC.equals(e.getValue())) {
					criteria.addOrder(Order.asc(e.getKey()));
				} else if (Const.SORT_DESC.equals(e.getValue())) {
					criteria.addOrder(Order.desc(e.getKey()));
				}
			}
		}
		return criteria;
	}

	/** 以下是自定义分页 **/

	// 根据Criteria对象，设置Pager的List内容
	@SuppressWarnings("unchecked")
	private List<T> getList(Criteria criteria, int pageSize , int page) throws Exception {
		criteria.setFirstResult(pageSize * (page - 1));
		criteria.setMaxResults(pageSize);
		return criteria.list();
	}

	// 根据Criteria对象，设置Pager的总实体数;
	private int getTotalCount(Criteria criteria)
			throws Exception {
		criteria.setProjection(Projections.rowCount());
		Object result = criteria.uniqueResult();
		if (result == null) {
			return 0;
		} else {
			return Integer.parseInt(result.toString());
		}
	}

	/**
	 * 根据自定义的Criteria，获取分页后的对象
	 * 
	 * @param myCriteria
	 *            自定义Criteria
	 * @param pager
	 *            分页对象
	 * @throws Exception
	 * @author Ivan
	 * @since 2014-3-26
	 */
	protected Pager listByCriteria(MyCriteria myCriteria, Pager pager)
			throws Exception {
		pager.setList(getList(myCriteria.set(getCriteria()), pager.getPageSize(), pager.getPage()));
		pager.setTotalCount(getTotalCount(myCriteria.set(getCriteria())));
		return pager;
	}

	protected interface MyCriteria {
		public Criteria set(Criteria criteria) throws Exception;
	}
	

	protected Pager setPagerByQuery(Query listQuery, Query countQuery, Pager pager)
			throws Exception {
		listQuery.setMaxResults(pager.getPageSize());
		listQuery.setFirstResult(pager.getPageSize() * (pager.getPage() - 1));
		pager.setList(listQuery.list());

		Integer totalCount = Integer.valueOf(countQuery.uniqueResult().toString());
		pager.setTotalCount(totalCount);
		return pager;
	}
}
