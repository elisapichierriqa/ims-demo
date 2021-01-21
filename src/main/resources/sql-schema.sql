drop database if exists ims;
create database if not exists ims;
create table if not exists ims.customers(id int primary key auto_increment, first_name varchar(40), last_name varchar(40));
create table if not exists ims.items(id int primary key auto_increment, item_name varchar(40), item_value double);
create table if not exists ims.orders(orderID int primary key auto_increment, customerID int NOT NULL, postcode varchar(40), foreign key(customerID) references customers(id));
create table if not exists ims.orderline(orderlineID int primary key auto_increment, orderID int NOT NULL, itemID int NOT NULL, customerID int NOT NULL, item_value int NOT NULL, foreign key(orderID) references orders(orderID), foreign key(itemID) references items(id));
