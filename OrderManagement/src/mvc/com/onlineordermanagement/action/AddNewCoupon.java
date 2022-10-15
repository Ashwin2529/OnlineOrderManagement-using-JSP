package com.onlineordermanagement.action;

import com.onlineordermanagement.dao.LoginDB;
import com.opensymphony.xwork2.ActionSupport;

public class AddNewCoupon extends ActionSupport {
	private static final long serialVersionUID = -3827439829486925185L;
	
	private String newCouponName, newCouponCategory, msg;
	private int newCouponValue;
	
	public String getNewCouponName() {
		return newCouponName;
	}
	public void setNewCouponName(String newCouponName) {
		this.newCouponName = newCouponName;
	}
	public String getNewCouponCategory() {
		return newCouponCategory;
	}
	public void setNewCouponCategory(String newCouponCategory) {
		this.newCouponCategory = newCouponCategory;
	}
	public int getNewCouponValue() {
		return newCouponValue;
	}
	public void setNewCouponValue(String newCouponValue) {
		this.newCouponValue = Integer.parseInt(newCouponValue);
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String execute() throws Exception{
		LoginDB loginDB = new LoginDB();
		msg = loginDB.AddCpn(newCouponName, newCouponCategory, newCouponValue);
		return "success";
	}
}
