create database if not exists IMS;
create table if not exists ims.customers(customerID INT primary key auto_increment, first_name VARCHAR(40), surname VARCHAR(40));
create table if not exists ims.items(itemID INT primary key auto_increment, item_name VARCHAR(40));
create table if not exists ims.orders(orderID INT primary key auto_increment, foreign key (customerID) references customers(customerID), foreign key (itemID) references items(itemID)));
create table if not exists ims.orderline(orderlineID INT primary key auto_increment, orderID INT NOT NULL, itemID INT NOT NULL, customerID INT NOT NULL, quantity INT NOT NULL, foreign key (orderID) references orders(orderID), foreign key(itemID) references items(itemID));
