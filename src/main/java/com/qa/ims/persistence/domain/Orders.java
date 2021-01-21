package com.qa.ims.persistence.domain;

public class Orders {
	private Long orderID;
	private Long customerID;
	private String postcode;
	private Long itemID;
	
	
public Orders(Long orderID, Long customerID, String postcode) {
	this.orderID = orderID;
	this.customerID = customerID;
	this.postcode = postcode;
}


public Orders(Long orderID, Long customerID, Long itemID, String postcode) {
	this.orderID = orderID;
	this.customerID = customerID;
	this.itemID = itemID;
	this.postcode = postcode;
}


public Long getOrderID() {
	return orderID;
}

public void setOrderID(Long orderID) {
	this.orderID = orderID;
}

public Long getCustomerID() {
	return customerID;
}

public void setCustomerID(Long customerID) {
	this.customerID = customerID;
}


public String toString() {
	return "order ID:" + orderID + " item ID:" + itemID + "customer ID:" + customerID + "postcode:" + postcode;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
	result = prime * result + ((customerID == null) ? 0 : customerID.hashCode());
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
	return true;
}

public String getPostcode() {
	return postcode;
}

public void setPostcode(String postcode) {
	this.postcode = postcode;
}


public Long getItemID() {
	return itemID;
}


public void setItemID(Long itemID) {
	this.itemID = itemID;
}

}
