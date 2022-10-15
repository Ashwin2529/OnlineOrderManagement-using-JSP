package com.onlineordermanagement.action;

import java.sql.ResultSet;
import java.util.*;

import com.onlineordermanagement.bean.UserBean;
import com.onlineordermanagement.dao.LoginDB;
import com.opensymphony.xwork2.ActionSupport;

public class ViewCustDetails extends ActionSupport{
	private static final long serialVersionUID = 1L;
	ResultSet rs = null;
	UserBean userBean = null;
	List<UserBean> beanList = null;
	LoginDB loginDB = new LoginDB();
	
	public String execute()throws Exception {
		beanList = new ArrayList<>();
		rs = loginDB.viewCust();
		while(rs.next()) {
			userBean = new UserBean();
			userBean.setUserId(rs.getInt("user_id"));
			userBean.setUserName(rs.getString("user_name"));
			userBean.setUserRole(rs.getString("user_role"));
			beanList.add(userBean);
		}
		return "CustomerDetails";
	}

	public List<UserBean> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<UserBean> beanList) {
		this.beanList = beanList;
	}
	
}
