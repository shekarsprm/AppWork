package com.iws.appportal.exceptions;

public class ServiceException extends Exception {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServiceException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public ServiceException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public ServiceException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public ServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(String args, Throwable th, boolean flag1, boolean flag2) {
		super(args, th, flag1, flag2);
	}
}
