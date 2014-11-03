package com.tarena.netctoss.action;

import java.util.HashMap;

import com.tarena.netctoss.exception.ServiceException;

/**
 * Ajax请求支持类
 * 
 * @author Ivan
 * @since 2014-3-23
 */
public class AjaxSupport {

	/**
	 * 处理Ajax请求
	 */
	private HashMap<String, Object> ajaxJSON = new HashMap<String, Object>(2);
	protected static final String JSON = "json";

	/**
	 * 根据约定封装Ajax请求，返回JSON格式的内容
	 * 
	 * 操作成功，默认返回null结果
	 * 操作失败,默认返回ServiceExcpetion的内容
	 * 
	 * @param ajaxJSONCB
	 *            回调函数
	 * @return JSON
	 * @since 2014-3-23
	 */
	protected String runAjaxJSON(IAjaxJSONCB ajaxJSONCB) {
		try {
			setAjaxJSON(true, null);
			ajaxJSONCB.run();
		} catch (ServiceException e) {
			setAjaxJSON(false, e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			setAjaxJSON(false, "系统繁忙，请稍后再试");
		}
		return JSON;
	}

	/**
	 * 自定义要运行的内容
	 * 
	 * @author Ivan
	 * @since 2014-3-23
	 */
	protected interface IAjaxJSONCB {
		public void run() throws Exception;
	}

	protected void setAjaxJSON(Boolean success, Object message) {
		this.ajaxJSON.put("success", success);
		this.ajaxJSON.put("content", message);
	}
	
	public HashMap<String, Object> getAjaxJSON() {
		return ajaxJSON;
	}
}
