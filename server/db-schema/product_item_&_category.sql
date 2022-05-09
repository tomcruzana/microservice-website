### PRODUCT_ITEM_CATEGORY ###
drop table product_category;

create table product_category(
    name varchar(128) not null unique primary key
);

insert into product_category (name) values (upper("Appliances"));
insert into product_category (name) values (upper("Apps & Games"));
insert into product_category (name) values (upper("Arts, Crafts, & Sewing"));
insert into product_category (name) values (upper("Automotive Parts & Accessories"));
insert into product_category (name) values (upper("Beauty & Personal Care"));
insert into product_category (name) values (upper("Books"));
insert into product_category (name) values (upper("CDs & Vinyl"));
insert into product_category (name) values (upper("Cell Phones & Accessories"));
insert into product_category (name) values (upper("Clothing, Shoes and Jewelry"));
insert into product_category (name) values (upper("Collectibles & Fine Art"));
insert into product_category (name) values (upper("Computers"));
insert into product_category (name) values (upper("Electronics"));
insert into product_category (name) values (upper("Garden & Outdoor"));
insert into product_category (name) values (upper("Grocery & Gourmet Food"));
insert into product_category (name) values (upper("Handmade"));
insert into product_category (name) values (upper("Health, Household & Baby Care"));
insert into product_category (name) values (upper("Home & Kitchen"));
insert into product_category (name) values (upper("Industrial & Scientific"));
insert into product_category (name) values (upper("Kindle"));
insert into product_category (name) values (upper("Luggage & Travel Gear"));
insert into product_category (name) values (upper("Movies & TV"));
insert into product_category (name) values (upper("Musical Instruments"));
insert into product_category (name) values (upper("Office Products"));
insert into product_category (name) values (upper("Pet Supplies"));
insert into product_category (name) values (upper("Sports & Outdoors"));
insert into product_category (name) values (upper("Tools & Home Improvement"));
insert into product_category (name) values (upper("Toys & Games"));
insert into product_category (name) values (upper("Video Games"));

select * from product_category;


### PRODUCT_ITEM ###
drop table product_item;

create table product_item(
	id int primary key auto_increment,
    product_category_name varchar(128),
    title varchar(255) not null,
    description varchar(512) not null,
	photo blob not null, 
	price decimal(13,2) not null default 0.00,
    stock_quantity int default 0,
    rating decimal(2,1) check(rating>= 0 AND rating<= 5) default 0,
    
    foreign key (product_category_name)  references product_category(name)
);

insert into product_item
(product_category_name, title, description, photo, price, stock_quantity, rating)
values
(UPPER("ELECTRONICS"), "laptop", "lorem ipsum dolor amet", "test", 799.99, 12, 4.5);

select * from product_item;


### PRODUCT_CART_JUNCTION
create table product_cart_junction(
	product_id int not null,
    customer_cart_id int not null,
    foreign key (product_id) references product_item(id)
    ### cant fk customer_cart_id since it will be stored in a different db 
);

drop table product_cart_junction;