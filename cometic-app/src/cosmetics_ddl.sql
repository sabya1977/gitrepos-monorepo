CREATE DATABASE cosmetics;
-- 
CREATE TABLE products (
  prod_id varchar(30) DEFAULT NULL,
  prod_name varchar(60) DEFAULT NULL,
  unit_price int DEFAULT NULL,
  stock int DEFAULT NULL,
  discount int DEFAULT NULL,
  brand_name varchar(40) DEFAULT NULL
);
------------------------------------------------------------------------------------------+
CREATE TABLE orders (
  order_id int DEFAULT NULL,
  prod_id varchar(30) DEFAULT NULL,
  tot_item int DEFAULT NULL,
  tot_price int DEFAULT NULL,
  cust_name varchar(60) DEFAULT NULL,
  pin_code varchar(10) DEFAULT NULL,
  mob_no varchar(10) DEFAULT NULL
);