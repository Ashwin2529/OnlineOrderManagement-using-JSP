package com.onlineordermanagement.bean;

public class Itembean {
	private int itemId;
	private String itemName;
	private String itemCategory;
	private float itemPrice;
	private int itemQuantity;
	private int itemSalesCnt;
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemCategory() {
		return itemCategory;
	}
	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
	public float getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public int getItemSalesCnt() {
		return itemSalesCnt;
	}
	public void setItemSalesCnt(int itemSalesCnt) {
		this.itemSalesCnt = itemSalesCnt;
	}
}
