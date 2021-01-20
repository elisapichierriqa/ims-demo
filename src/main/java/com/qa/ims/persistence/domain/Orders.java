package com.qa.ims.persistence.domain;

public class Orders {
	private String orderID;
	private String customerID;
	private String itemID;
	
	
public Orders(String orderID, String customerID, String itemID) {
	this.orderID = orderID;
	this.customerID = customerID;
	this.itemID = itemID;
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

public String getCustomerID() {
	return customerID;
}

public void setCustomerID(String customerID) {
	this.customerID = customerID;
}

public void setItemID(String itemID) {
	this.itemID = itemID;
}
public String toString() {
	return "order ID:" + orderID + " customer ID:" + customerID + " item ID:" + itemID;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
	result = prime * result + ((customerID == null) ? 0 : customerID.hashCode());
	result = prime * result + ((itemID == null) ? 0 : itemID.hashCode());
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
	Orders other = (Orders) obj;
	if (orderID == null) {
		if (other.orderID != null)
			return false;
	} else if (!orderID.equals(other.orderID))
		return false;
	if (customerID == null) {
		if (other.customerID != null)
			return false;
	} else if (!customerID.equals(other.customerID))
		return false;
	if (itemID == null) {
		if (other.itemID != null)
			return false;
	} else if (!itemID.equals(other.itemID))
		return false;
	return true;
}

public Double getItem_value() {
	// TODO Auto-generated method stub
	return null;
}

}
