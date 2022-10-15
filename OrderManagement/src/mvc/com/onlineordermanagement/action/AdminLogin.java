package com.onlineordermanagement.action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;  
import org.apache.struts2.interceptor.SessionAware;

import com.onlineordermanagement.dao.LoginDB;
import com.opensymphony.xwork2.ActionSupport;  

public class AdminLogin extends ActionSupport implements SessionAware{
	private static final long SERIAL_VERSION_UID = 1L;
	private int userId;
	private String tempuserId, userPassword;
	private LoginDB loginDB;
	private Encrypt encryption;
	private SessionMap<String, Object> sessionMap;
	
	public SessionMap<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(SessionMap<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	
	public int getUserId() {
		return userId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	
	
	public void setUserId(String userId) {
		this.userId = Integer.parseInt(userId);
		tempuserId = userId;
	}
	
	public void setUserPassword(String userPassword) {
		encryption = new Encrypt();
		this.userPassword=encryption.encrypt(userPassword);
	}
	@Override
	public void setSession(Map<String, Object> map) {
		sessionMap = (SessionMap<String, Object>) map;
	}
	public String execute() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		loginDB = new LoginDB();
		if(tempuserId!=null) {
			if(loginDB.userAuthentication(userId, userPassword)) {
				sessionMap.put("userId", tempuserId);
				return "success";
			}
			else
			{
				return "error";
			}
		}
		else {
			String getSessions = (String)session.getAttribute("userId");
			if(getSessions != null) {
				return "success";
			}
			else {
				return "error";
			}
		}
		
	}
	public String logout() {
		
		sessionMap.remove("userId");
		sessionMap.invalidate();
		
		return "success";
	}
}
