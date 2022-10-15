package com.onlineordermanagement.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.onlineordermanagement.bean.Cartbean;
import com.onlineordermanagement.bean.Couponbean;
import com.onlineordermanagement.dao.LoginDB;
import com.opensymphony.xwork2.ActionSupport;

public class ViewCart extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private int orderUsrId;
	ResultSet rs = null;
	Cartbean cartBean = null;
	List<Cartbean> cartBeanList = null;
	LoginDB loginDB = new LoginDB();
	
	
	
	public int getOrderUsrId() {
		return orderUsrId;
	}

	public void setOrderUsrId(int orderUsrId) {
		this.orderUsrId = orderUsrId;
	}

	public String execute()throws Exception {
		cartBeanList = new ArrayList<>();
		rs = loginDB.viewCart(orderUsrId);
		while(rs.next()) {
			cartBean = new Cartbean();
			cartBean.setOrder_id(rs.getInt("order_id"));
			cartBean.setOrderUsrId(rs.getInt("user_id"));
			cartBean.setOrderItemId(rs.getInt("ordered_item_id"));
			cartBean.setOrderItemQuant(rs.getInt("ordered_item_quantity"));
			cartBean.setOrdered_total_price(rs.getFloat("total_price"));
			cartBean.setOrderedDate(rs.getString("ordered_date"));
			cartBeanList.add(cartBean);
		}
		return "CartDetails";
	}

	public List<Cartbean> getCartBeanList() {
		return cartBeanList;
	}

	public void setCartBeanList(List<Cartbean> cartBeanList) {
		this.cartBeanList = cartBeanList;
	}
}
