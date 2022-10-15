package com.onlineordermanagement.bean;

public class Cartbean {
	private int order_id, orderUsrId, orderItemId, orderItemQuant;
	private float ordered_total_price;
	private String orderedDate;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getOrderUsrId() {
		return orderUsrId;
	}
	public void setOrderUsrId(int orderUsrId) {
		this.orderUsrId = orderUsrId;
	}
	public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getOrderItemQuant() {
		return orderItemQuant;
	}
	public void setOrderItemQuant(int orderItemQuant) {
		this.orderItemQuant = orderItemQuant;
	}
	public float getOrdered_total_price() {
		return ordered_total_price;
	}
	public void setOrdered_total_price(float ordered_total_price) {
		this.ordered_total_price = ordered_total_price;
	}
	public String getOrderedDate() {
		return orderedDate;
	}
	public void setOrderedDate(String orderedDate) {
		this.orderedDate = orderedDate;
	}
	
	
}
