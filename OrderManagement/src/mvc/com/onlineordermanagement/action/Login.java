package com.onlineordermanagement.action;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport {
	private static final long SERIAL_VERSION_UID = 1L;
	
	public String logout() {
		return "success";
	}
}
