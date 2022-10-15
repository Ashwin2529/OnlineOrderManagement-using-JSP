package com.onlineordermanagement.action;

import com.onlineordermanagement.dao.LoginDB;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateItem extends ActionSupport{
private static final long serialVersionUID = -3827439829486925185L;
	
	private int updtItemId;
	private String updtItemName;
	private String updtItemCategory;
	private float updtItemPrice;
	private int updtItemQuantity;
	private String msg;
	
	public int getUpdtItemId() {
		return updtItemId;
	}
	public void setUpdtItemId(String updtItemId) {
		this.updtItemId = Integer.parseInt(updtItemId);
	}
	public String getUpdtItemName() {
		return updtItemName;
	}
	public void setUpdtItemName(String updtItemName) {
		this.updtItemName = updtItemName;
	}
	public String getUpdtItemCategory() {
		return updtItemCategory;
	}
	public void setUpdtItemCategory(String updtItemCategory) {
		this.updtItemCategory = updtItemCategory;
	}
	public float getUpdtItemPrice() {
		return updtItemPrice;
	}
	public void setUpdtItemPrice(String updtItemPrice) {
		this.updtItemPrice = Float.parseFloat(updtItemPrice);
	}
	public int getUpdtItemQuantity() {
		return updtItemQuantity;
	}
	public void setUpdtItemQuantity(String updtItemQuantity) {
		this.updtItemQuantity = Integer.parseInt(updtItemQuantity);
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String execute() throws Exception {
		LoginDB loginDB = new LoginDB();
		msg = loginDB.UpdtItem(updtItemId, updtItemName, updtItemCategory, updtItemPrice, updtItemQuantity);
		return "success";
	}
}
