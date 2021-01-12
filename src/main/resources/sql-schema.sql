create database if not exists ims;
create table if not exists ims.customers(customerID int primary key auto_increment, first_name varchar(40), surname varchar(40));
create table if not exists ims.items(itemID int primary key auto_increment, item_name varchar(40));
create table if not exists ims.orders(orderID int primary key auto_increment, customerID int, itemID int));
