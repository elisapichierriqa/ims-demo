package com.qa.ims.persistence.domain;

public class Orderline {
	
	private Long orderlineID;
	private Long orderID;
	private Long itemID;
	private Long customerID;
	private int quantity;
	
public Orderline(Long orderlineID, Long orderID, Long itemID, Long customerID, int quantity) {
	this.orderlineID = orderlineID;
	this.orderID = orderID;
	this.itemID = itemID;
	this.customerID = customerID;
	this.quantity = quantity;
}

public Long getOrderlineID() {
	return orderlineID;
}

public void setOrderlineID(Long orderlineID) {
	this.orderlineID = orderlineID;
}

public Long getOrderID() {
	return orderID;
}

public void setOrderID(Long orderID) {
	this.orderID = orderID;
}

public Long getItemID() {
	return itemID;
}

public void setItemID(Long itemID) {
	this.itemID = itemID;
}

public Long getCustomerID() {
	return customerID;
}

public void setCustomerID(Long customerID) {
	this.customerID = customerID;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}
}
