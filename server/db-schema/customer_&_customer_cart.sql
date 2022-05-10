### REGISTERED CUSTOMER ###
drop table registered_customer;

create table registered_customer(
	id int primary key auto_increment,
    cart_id char(8) unique,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    phone_number char(32) unique,
	email_address varchar(255) not null unique, 
	date_created date default (current_date),
    username varchar(255) not null unique,
    password varchar(255) not null,
    is_enabled boolean not null default true
);

insert into registered_customer
(
first_name,
last_name,
phone_number,
email_address,
username,
password
)
values
(
"thomas",
"developer",
"3609991234",
"thomas.developer@email.com",
"tomdev09",
"$2a$10$rLH7IADK.DM/QjvGYCt2T.8uwxoZwf1ju4OG54B2hhtPsUr/QnLnm"
);

select * from registered_customer;


### CUSTOMER CART ###
drop table cart;

create table cart(
	id char(8) primary key,
    registered_customer_id int not null,
    
    foreign key (registered_customer_id) references registered_customer(id)
);

select * from cart;

### add fk constraint
alter table registered_customer
add foreign key (cart_id) references cart(id);


### CUSTOMER (NOTE: THIS REPRESENTS AN ABSTRACT CLASS) ###
drop table customer;

create table customer(
	id int primary key auto_increment,
    first_name varchar(255) not null,
    last_name varchar(255) not null
);


### STORED PROCEDURE : CART CREATION FOR REGISTERED CX ###
DELIMITER //
CREATE PROCEDURE CreateCartForRegisteredCustomer(
	IN cartId char(8),
    IN registeredCustomerId int
)
BEGIN
	insert into cart(id, registered_customer_id) values(cartId, registeredCustomerId);
	update registered_customer set cart_id = cartId where id = cartId;
END //
DELIMITER ;

CALL CreateCartForRegisteredCustomer('1', 1);


### CART ITEM ###
drop table cart_item;

create table cart_item(
	cart_id char(8),
    product_item_id int,
    quantity int not null,
    
    foreign key (cart_id) references cart(id)
);

insert into cart_item (cart_id, product_item_id, quantity)
values('1', 1, 8);
insert into cart_item (cart_id, product_item_id, quantity)
values('1', 2, 2);

select * from cart_item;


