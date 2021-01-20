package com.qa.ims.persistence.domain;

public class Orderline {
	
	private String orderlineID;
	private String orderID;
	private String itemID;
	private String customerID;
	private int quantity;
	
public Orderline(String orderlineID, String orderID, String itemID, String customerID, int quantity) {
	this.orderlineID = orderlineID;
	this.orderID = orderID;
	this.itemID = itemID;
	this.customerID = customerID;
	this.quantity = quantity;
}

public String getOrderlineID() {
	return orderlineID;
}

public void setOrderlineID(String orderlineID) {
	this.orderlineID = orderlineID;
}

public String getOrderID() {
	return orderID;
}

public void setOrderID(String orderID) {
	this.orderID = orderID;
}

public String getItemID() {
	return itemID;
}

public void setItemID(String itemID) {
	this.itemID = itemID;
}

public String getCustomerID() {
	return customerID;
}

public void setCustomerID(String customerID) {
	this.customerID = customerID;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}
}
