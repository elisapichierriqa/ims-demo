package com.qa.ims.persistence.domain;

public class Orderline {
	
	private Long orderlineID;
	private Long orderID;
	private Long itemID;
	private Long customerID;
	private Double item_value;
	
	
public Orderline(Long orderlineID, Long orderID, Long itemID, Long customerID) {
	this.orderlineID = orderlineID;
	this.orderID = orderID;
	this.itemID = itemID;
	this.customerID = customerID;

}
public Orderline(Long itemID, Long orderID, Double item_value) {
	//super();
	this.itemID = itemID;
	this.orderID = orderID;
	this.item_value = item_value;
}

public Long getCustomerID() {
	return customerID;
}
public void setCustomerID(Long customerID) {
	this.customerID = customerID;
}
public Double getItem_value() {
	return item_value;
}
public void setItem_value(Double item_value) {
	this.item_value = item_value;
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
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((orderlineID == null) ? 0 : orderlineID.hashCode());
	result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Orderline other = (Orderline) obj;
	if (orderlineID == null) {
		if (other.itemID != null)
			return false;
	} else if (!itemID.equals(other.itemID))
		return false;
	if (orderID == null) {
		if (other.orderID != null)
			return false;
	} else if (orderlineID.equals(other.orderlineID))
		return false;
	if (item_value == null) {
		if (other.item_value != null)
			return false;
	} else if (!item_value.equals(other.item_value))
		return false;
	return true;
}
}
