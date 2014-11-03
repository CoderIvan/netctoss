package com.tarena.netctoss.util;

public interface Const {
	/**
	 * 存放于session中的验证码
	 */
	public static final String SESSION_VERIFICATION_CODE = "VerificationCode";

	/**
	 * 存放于session中的用户ID
	 */
	public static final String SESSION_ADMIN_ID = "admin_id";

	/**
	 * 升序
	 */
	public static final String SORT_ASC = "asc";
	/**
	 * 降序
	 */
	public static final String SORT_DESC = "desc";

	/**
	 * Cost的状态-开通
	 */
	public static final String COST_STATUS_OPEN = "0";
	/**
	 * Cost的状态-暂停
	 */
	public static final String COST_STATUS_PAUSE = "1";
	/**
	 * Cost的状态-删除
	 */
	public static final String COST_STATUS_DELETE = "2";
	
	/**
	 * Cost的资费类型-包月
	 */
	public static final String COST_COSTTYPE_PERMONTH = "1";
	/**
	 * Cost的资费类型-套餐
	 */
	public static final String COST_COSTTYPE_PACKAGE = "2";
	/**
	 * Cost的资费类型-计时
	 */
	public static final String COST_COSTTYPE_PERTIME = "3";

	/**
	 * Account的状态-开通
	 */
	public static final String ACCOUNT_STATUS_OPEN = "0";
	/**
	 * Account的状态-暂停
	 */
	public static final String ACCOUNT_STATUS_PAUSE = "1";
	/**
	 * Account的状态-删除
	 */
	public static final String ACCOUNT_STATUS_DELETE = "2";
	
	/**
	 * Service的状态-开通
	 */
	public static final String SERVICE_STATUS_OPEN = "0";
	/**
	 * Service的状态-暂停
	 */
	public static final String SERVICE_STATUS_PAUSE = "1";
	/**
	 * Service的状态-删除
	 */
	public static final String SERVICE_STATUS_DELETE = "2";
}
