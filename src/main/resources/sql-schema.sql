CREATE DATABASE IF NOT EXISTS ims;
CREATE TABLE IF NOT EXISTS ims.customers (
    customerID INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(40),
    last_name VARCHAR(40)
);
CREATE TABLE IF NOT EXISTS ims.items (
    itemID INT PRIMARY KEY AUTO_INCREMENT,
    item_name VARCHAR(40)
);
CREATE TABLE IF NOT EXISTS ims.orders (
    orderID INT PRIMARY KEY AUTO_INCREMENT,
    FOREIGN KEY (customerID)
        REFERENCES customers (customerID),
    FOREIGN KEY (itemID)
        REFERENCES items (itemID)
);
CREATE TABLE IF NOT EXISTS ims.orderline (
    orderlineID INT PRIMARY KEY AUTO_INCREMENT,
    orderID INT NOT NULL,
    itemID INT NOT NULL,
    customerID INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (orderID)
        REFERENCES orders (orderID),
    FOREIGN KEY (itemID)
        REFERENCES items (itemID)
);