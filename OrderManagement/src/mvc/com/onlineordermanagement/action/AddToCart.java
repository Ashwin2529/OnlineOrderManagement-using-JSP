package com.onlineordermanagement.action;

import com.onlineordermanagement.dao.LoginDB;
import com.opensymphony.xwork2.ActionSupport;

public class AddToCart extends ActionSupport{
	private int orderUsrId, orderItemId, orderItemQuant;
	private String itmCpn, msg;
	
	public int getOrderUsrId() {
		return orderUsrId;
	}
	public void setOrderUsrId(String orderUsrId) {
		this.orderUsrId = Integer.parseInt(orderUsrId);
	}
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(String orderItemId) {
		this.orderItemId = Integer.parseInt(orderItemId);
	}
	public int getOrderItemQuant() {
		return orderItemQuant;
	}
	public void setOrderItemQuant(String orderItemQuant) {
		this.orderItemQuant = Integer.parseInt(orderItemQuant);
	}
	public String getItmCpn() {
		return itmCpn;
	}
	public void setItmCpn(String itmCpn) {
		this.itmCpn = itmCpn;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String execute() throws Exception{
		LoginDB loginDB = new LoginDB();
		msg = loginDB.addToCart(orderUsrId, orderItemId, orderItemQuant, itmCpn);
		return "success";
	}
	
}
