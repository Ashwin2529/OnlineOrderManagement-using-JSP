package com.onlineordermanagement.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.onlineordermanagement.bean.Cartbean;
import com.onlineordermanagement.bean.OrderBean;
import com.onlineordermanagement.dao.LoginDB;
import com.opensymphony.xwork2.ActionSupport;

public class ViewOrderHistory extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private int orderUsrId;

	ResultSet rs = null;
	OrderBean orderBean = null;
	List<OrderBean> orderBeanList = null;
	LoginDB loginDB = new LoginDB();
	
	public int getOrderUsrId() {
		return orderUsrId;
	}

	public void setOrderUsrId(String orderUsrId) {
		this.orderUsrId = Integer.parseInt(orderUsrId);
	}
	
	public String execute()throws Exception {
		orderBeanList = new ArrayList<>();
		rs = loginDB.orderHist(orderUsrId);
		while(rs.next()) {
			orderBean = new OrderBean();
			orderBean.setOrder_id(rs.getInt("order_id"));
			orderBean.setOrderUsrId(rs.getInt("user_id"));
			orderBean.setOrderItemId(rs.getInt("ordered_item_id"));
			orderBean.setOrderItemQuant(rs.getInt("ordered_item_quantity"));
			orderBean.setOrdered_total_price(rs.getFloat("total_price"));
			orderBean.setOrderedDate(rs.getString("ordered_date"));
			orderBeanList.add(orderBean);
		}
		return "success";
	}
	
	

	public List<OrderBean> getOrderBeanList() {
		return orderBeanList;
	}

	public void setOrderBeanList(List<OrderBean> orderBeanList) {
		this.orderBeanList = orderBeanList;
	}
	
}
