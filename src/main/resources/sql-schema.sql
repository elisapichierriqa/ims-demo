CREATE DATABASE IF NOT EXISTS ims;
CREATE TABLE IF NOT EXISTS ims.customers (
    customerID LONG PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(40),
    last_name VARCHAR(40)
);
CREATE TABLE IF NOT EXISTS ims.items (
    itemID LONG PRIMARY KEY AUTO_INCREMENT,
    item_name VARCHAR(40)
);
CREATE TABLE ims.orders (
    orderID LONG NOT NULL PRIMARY KEY AUTO_INCREMENT,
    customerID LONG NOT NULL,
    FOREIGN KEY (customerID)
        REFERENCES customers(customerID),
        itemID LONG NOT NULL,
    FOREIGN KEY (itemID)
        REFERENCES items(itemID)
);
CREATE TABLE IF NOT EXISTS ims.orderline (
    orderlineID LONG PRIMARY KEY AUTO_INCREMENT,
    orderID LONG NOT NULL,
    itemID LONG NOT NULL,
    customerID LONG NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (orderID)
        REFERENCES orders (orderID),
    FOREIGN KEY (itemID)
        REFERENCES items (itemID)
);