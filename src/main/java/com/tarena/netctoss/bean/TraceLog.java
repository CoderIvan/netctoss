package com.tarena.netctoss.bean;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 跟踪日志
 * 
 * @author Ivan
 * @date 2013-12-8 下午4:53:17
 * @version v1.0.0
 */
public class TraceLog {
	private Logger logger = Logger.getLogger(TraceLog.class);

	public Object logger(ProceedingJoinPoint pjp) throws Throwable {
		// 执行目标对象的功能
		Object obj = pjp.proceed();
		// 获取方法名
		String method = pjp.getSignature().getName();
		// 获取目标对象类名
		String clazzName = pjp.getTarget().getClass().getName();
		logger.info("执行了" + clazzName + "的" + method + "方法");
		return obj;
	}
}
