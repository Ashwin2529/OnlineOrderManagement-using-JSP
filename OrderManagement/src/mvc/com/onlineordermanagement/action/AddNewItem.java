package com.onlineordermanagement.action;

import com.onlineordermanagement.dao.LoginDB;
import com.opensymphony.xwork2.ActionSupport;

public class AddNewItem extends ActionSupport{
	private static final long serialVersionUID = -3827439829486925185L;
	
	private int newItemId;
	private String newItemName;
	private String newItemCategory;
	private float newItemPrice;
	private int newItemQuantity;
	private String msg;
	
	public int getNewItemId() {
		return newItemId;
	}
	public void setNewItemId(String newItemId) {
		this.newItemId = Integer.parseInt(newItemId);
	}
	public String getNewItemName() {
		return newItemName;
	}
	public void setNewItemName(String newItemName) {
		this.newItemName = newItemName;
	}
	public String getNewItemCategory() {
		return newItemCategory;
	}
	public void setNewItemCategory(String newItemCategory) {
		this.newItemCategory = newItemCategory;
	}
	public float getNewItemPrice() {
		return newItemPrice;
	}
	public void setNewItemPrice(String newItemPrice) {
		this.newItemPrice = Float.parseFloat(newItemPrice);
	}
	public int getNewItemQuantity() {
		return newItemQuantity;
	}
	public void setNewItemQuantity(String newItemQuantity) {
		this.newItemQuantity = Integer.parseInt(newItemQuantity);
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String execute() throws Exception {
		LoginDB loginDB = new LoginDB();
		msg = loginDB.AddItem(newItemId, newItemName, newItemCategory, newItemPrice, newItemQuantity);
		return "success";
	}
}
