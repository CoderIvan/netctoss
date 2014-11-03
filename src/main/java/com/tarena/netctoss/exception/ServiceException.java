package com.tarena.netctoss.exception;

/**
 * 自定义业务异常
 * 
 * @author Ivan
 * 
 */
public class ServiceException extends Exception {
	private static final long serialVersionUID = 1L;

	public ServiceException(String message) {
		super(message);
	}
}
