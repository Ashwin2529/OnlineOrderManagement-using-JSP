package com.onlineordermanagement.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.onlineordermanagement.bean.Itembean;
import com.onlineordermanagement.dao.LoginDB;
import com.opensymphony.xwork2.ActionSupport;

public class ViewItmDetails extends ActionSupport {
	private static final long serialVersionUID = 1L;
	ResultSet rs1 = null;
	Itembean itemBean = null;
	List<Itembean> itembeanList = null;
	LoginDB loginDB = new LoginDB();
	
	public String execute()throws Exception {
		itembeanList = new ArrayList<>();
		rs1 = loginDB.viewItem();
		while(rs1.next()) {
			itemBean = new Itembean();
			itemBean.setItemId(rs1.getInt("item_id"));
			itemBean.setItemName(rs1.getString("item_name"));
			itemBean.setItemCategory(rs1.getString("item_category"));
			itemBean.setItemPrice(rs1.getFloat("item_price"));
			itemBean.setItemQuantity(rs1.getInt("item_quantity"));
			itemBean.setItemSalesCnt(rs1.getInt("item_sales_count"));
			itembeanList.add(itemBean);
		}
		return "ItemDetails";
	}

	public List<Itembean> getItembeanList() {
		return itembeanList;
	}

	public void setItembeanList(List<Itembean> itembeanList) {
		this.itembeanList = itembeanList;
	}
	
}
