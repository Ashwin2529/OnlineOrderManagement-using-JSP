package com.onlineordermanagement.action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.onlineordermanagement.dao.LoginDB;
import com.opensymphony.xwork2.ActionSupport;

public class CustLogin extends ActionSupport implements SessionAware{
	private static final long SERIAL_VERSION_UID = 1L;

	private int custId;
	private String tempCustId, custPassword;
	private String msg;
	private SessionMap<String, Object> sessionMap_cust;
	
	public SessionMap<String, Object> getSessionMap_cust() {
		return sessionMap_cust;
	}
	public void setSessionMap_cust(SessionMap<String, Object> sessionMap_cust) {
		this.sessionMap_cust = sessionMap_cust;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(String custId) {
		this.custId = Integer.parseInt(custId);
		tempCustId = custId;
	}
	public String getCustPassword() {
		return custPassword;
	}
	public void setCustPassword(String custPassword) {
		Encrypt encryption = new Encrypt();
		this.custPassword = encryption.encrypt(custPassword);
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public void setSession(Map<String, Object> map) {
		sessionMap_cust = (SessionMap<String, Object>) map;
	}
	public String execute() throws Exception{
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		LoginDB loginDB = new LoginDB();
		if(tempCustId!=null) {
			if(loginDB.custAuthentication(custId, custPassword)) 
			{
				sessionMap_cust.put("custId", tempCustId);
				msg="Login Successful";
				return "success";
			}
			else
			{
				return "error";
			}
		}
		else {
			String getSessions = (String)session.getAttribute("custId");
			if(getSessions != null) {
				return "success";
			}
			else {
				return "error";
			}
		}	
	}
	public String logout() {
		sessionMap_cust.remove("custId");
		sessionMap_cust.invalidate();
		return "success";
	}
}
