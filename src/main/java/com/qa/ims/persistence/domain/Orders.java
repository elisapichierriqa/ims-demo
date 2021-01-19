package com.qa.ims.persistence.domain;

public class Orders {
	private Long orderID;
	private Long customerID;
	private Long itemID;
	
public Orders(Long orderID, Long customerID, Long itemID) {
	this.orderID = orderID;
	this.customerID = customerID;
	this.itemID = itemID;
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

public Long getCustomerID() {
	return customerID;
}

public void setCustomerID(Long customerID) {
	this.customerID = customerID;
}

public void setItemID(Long itemID) {
	this.itemID = itemID;
}

}
