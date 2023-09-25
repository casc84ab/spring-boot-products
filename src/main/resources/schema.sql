DROP TABLE IF EXISTS product_price_entity;

CREATE TABLE product_price_entity (
id int not null auto_increment,
brand_id int,
start_date TIMESTAMP,
end_date TIMESTAMP,
price_list int,
product_id int,
priority int,
price numeric(20,2),
currency varchar(3),
primary key (id));