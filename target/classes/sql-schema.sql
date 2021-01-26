drop database if exists ims;
create database if not exists ims;
create table if not exists ims.customers(id int primary key auto_increment, first_name varchar(40), last_name varchar(40));
create table if not exists ims.items(id int primary key auto_increment, item_name varchar(40), item_value int);
create table if not exists ims.orders(orderID int primary key auto_increment, customerID int, itemID int, postcode varchar(40), foreign key(customerID) references customers(id), foreign key(itemID) references items(id));
create table if not exists ims.orderline(orderlineID int primary key auto_increment, orderID int, itemID int, item_value int, quantity int, foreign key(orderID) references orders(orderID), foreign key(itemID) references items(id), foreign key(item_value) references items(item_value));
