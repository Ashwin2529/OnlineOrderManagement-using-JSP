package com.onlineordermanagement.action;

import com.onlineordermanagement.dao.LoginDB;
import com.opensymphony.xwork2.ActionSupport;

public class BillOrder extends ActionSupport{
	private int orderUsrId;
	private String gnrlCpn, msg;
	
	public int getOrderUsrId() {
		return orderUsrId;
	}
	public void setOrderUsrId(int orderUsrId) {
		this.orderUsrId = orderUsrId;
	}
	public String getGnrlCpn() {
		return gnrlCpn;
	}
	public void setGnrlCpn(String gnrlCpn) {
		this.gnrlCpn = gnrlCpn;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String execute() throws Exception{
		LoginDB loginDB = new LoginDB();
		msg = loginDB.billOrder(orderUsrId, gnrlCpn);
		return "success";
	}
	
}
