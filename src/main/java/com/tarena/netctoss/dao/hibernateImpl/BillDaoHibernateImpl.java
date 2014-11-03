package com.tarena.netctoss.dao.hibernateImpl;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.tarena.netctoss.bean.Pager;
import com.tarena.netctoss.dao.BillDao;
import com.tarena.netctoss.entity.Bill;
import com.tarena.netctoss.entity.BillItem;
import com.tarena.netctoss.entity.ServiceDetail;

@Repository
public class BillDaoHibernateImpl extends BaseDaoHibernateImpl<Bill, Integer>
		implements BillDao {
	
	@Override
	public Pager list(Pager pager, final String idcardNo,
			final String loginName, final String realName, final String year,
			final String month) throws Exception {
		return listByCriteria(new MyCriteria() {
			@Override
			public Criteria set(Criteria criteria) throws Exception {
				if(!StringUtils.isEmpty(year)){
					criteria.add(Restrictions.like("billMonth", year, MatchMode.START));
				}if(!StringUtils.isEmpty(month)){
					criteria.add(Restrictions.like("billMonth", month, MatchMode.END));
				}
				if (!StringUtils.isEmpty(idcardNo) || !StringUtils.isEmpty(loginName) || !StringUtils.isEmpty(realName)) {
					criteria.createAlias("account", "account", JoinType.LEFT_OUTER_JOIN);
					if (!StringUtils.isEmpty(idcardNo)) { 
						criteria.add(Restrictions.like("account.idcardNo", idcardNo, MatchMode.ANYWHERE));
					}
					if (!StringUtils.isEmpty(loginName)) {
						criteria.add(Restrictions.like("account.loginName", loginName, MatchMode.ANYWHERE));
					}
					if (!StringUtils.isEmpty(realName)) {
						criteria.add(Restrictions.like("account.realName", realName, MatchMode.ANYWHERE));
					}
				}
				return criteria;
			}
		}, pager);
	}
	
	/** BILLITEM 部分开始 */
	private final static String BILLITEM = "SELECT BI.ID,BI.COST,BI.BILL_ID AS BILLID,"
			+ "S.OSUSERNAME,S.HOST_ID AS HOSTID,S.ACCOUNT_ID AS ACCOUNTID,"
			+ "(SELECT SUM(DURATION) FROM SERVICE_DETAIL SD WHERE S.ID = SD.SERVICE_ID) AS DURATION,"
			+ "C.NAME AS COSTNAME " 
			+ "FROM BILLITEM BI "
			+ "LEFT JOIN SERVICE S ON BI.SERVICE_ID = S.ID "
			+ "LEFT JOIN COST C ON S.COST_ID = C.ID";
	
	private final static String LIST_BILLITEM = BILLITEM + " WHERE BI.BILL_ID = :BILL_ID";
	private final static String LIST_BILLITEM_COUNT = "SELECT COUNT(*) FROM (" + LIST_BILLITEM + ")";
	
	private final static String GET_BILLITEM =  BILLITEM + " WHERE BI.ID = :ID";
	
	@Override
	public Pager listBillItem(Pager pager, Integer billId) throws Exception {
		SQLQuery listQuery = getSession().createSQLQuery(LIST_BILLITEM);
		listQuery.addEntity(BillItem.class);
		listQuery.setInteger("BILL_ID", billId);
		SQLQuery countQuery = getSession().createSQLQuery(LIST_BILLITEM_COUNT);
		countQuery.setInteger("BILL_ID", billId);
		return setPagerByQuery(listQuery, countQuery, pager);
	}
	
	@Override
	public BillItem getBillItem(Integer billItemId) throws Exception {
		SQLQuery listQuery = getSession().createSQLQuery(GET_BILLITEM);
		listQuery.addEntity(BillItem.class);
		listQuery.setInteger("ID", billItemId);
		return (BillItem) listQuery.uniqueResult();
	}
	/** BILLITEM 部分结束 */
	
	/** SERVICE_DETAIL 部分开始 */
	private static final String LIST_SERVICEDETAIL = "SELECT SD.ID,SD.CLIENTHOST,SD.LOGINTIME,SD.LOGOUTTIME,SD.DURATION,SD.COST,C.NAME AS COSTNAME"
			+ " FROM SERVICE_DETAIL SD"
			+ " LEFT JOIN SERVICE S ON SD.SERVICE_ID = S.ID"
			+ " LEFT JOIN COST C ON S.COST_ID = C.ID"
			+ " LEFT JOIN BILLITEM BI ON BI.SERVICE_ID = SD.SERVICE_ID"
			+ " WHERE BI.ID = :BILLITEMID";
	private static final String LIST_SERVICEDETAIL_COUNT = "SELECT COUNT(*) FROM (" + LIST_SERVICEDETAIL + ")";
	
	@Override
	public Pager listServiceDetail(Pager pager,Integer billItemId) throws Exception{
		SQLQuery listQuery = getSession().createSQLQuery(LIST_SERVICEDETAIL);
		listQuery.addEntity(ServiceDetail.class);
		listQuery.setInteger("BILLITEMID", billItemId);
		SQLQuery countQuery = getSession().createSQLQuery(LIST_SERVICEDETAIL_COUNT);
		countQuery.setInteger("BILLITEMID", billItemId);
		return setPagerByQuery(listQuery, countQuery, pager);
	}
	/** SERVICE_DETAIL 部分结束 */
}
