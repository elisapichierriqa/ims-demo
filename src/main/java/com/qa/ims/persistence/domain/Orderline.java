package com.qa.ims.persistence.domain;

public class Orderline {
	
	private Long orderlineID;
	private Long orderID;
	private Long itemID;
	
public Orderline(Long orderlineID, Long orderID, Long itemID) {
	this.orderlineID = orderlineID;
	this.orderID = orderID;
	this.itemID = itemID;

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
	Items other = (Items) obj;
	if (orderlineID == null) {
		if (other.orderlineID != null)
			return false;
	} else if (!orderlineID.equals(other.orderlineID))
		return false;
	if (orderID == null) {
		if (other.orderID != null)
			return false;
	} else if (orderID.equals(other.orderID))
		return false;
	if (itemID == null) {
		if (other.itemID != null)
			return false;
	} else if (!itemID.equals(other.itemID))
		return false;
	return true;
}
}
