### ID GENERATOR ###
drop table id_gen;

create table id_gen(
	gen_name varchar(60) primary key,
	gen_val int
)

select * from id_gen;

### REGISTERED CUSTOMER ###
drop table registered_customer;

create table registered_customer(
	id int primary key,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    phone_number char(32) unique,
	email_address varchar(255) not null unique, 
	date_created date default (current_date),
    username varchar(255) not null unique,
    password varchar(255) not null,
    is_enabled boolean not null default true
);

### WARN! Make sure there's an existing id in the id_gen table
### since we're using generation.TABLE strategy in the backend
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
    registered_customer_id int not null unique,
    
    foreign key (registered_customer_id) references registered_customer(id)
);

select * from cart;


### CUSTOMER (NOTE: THIS REPRESENTS AN ABSTRACT CLASS) ###
drop table customer;

create table customer(
	id int primary key,
    first_name varchar(255) not null,
    last_name varchar(255) not null
);

select * from customer;

### STORED PROCEDURE : CART CREATION FOR REGISTERED CX ###
DELIMITER //
CREATE PROCEDURE CreateCartForRegisteredCustomer(
	IN cartId char(8),
    IN registeredCustomerId int
)
BEGIN
	insert into cart(id, registered_customer_id) values(CONCAT("CART", cartId), registeredCustomerId);
END //
DELIMITER ;

CALL CreateCartForRegisteredCustomer("2", 2);


### CART ITEM ###
drop table cart_item;

create table cart_item(
	id int auto_increment primary key,
	cart_id char(8),
    product_item_id int,
    quantity int not null,
    
    foreign key (cart_id) references cart(id)
);

insert into cart_item (cart_id, product_item_id, quantity)
values('CART1', 1, 8);
insert into cart_item (cart_id, product_item_id, quantity)
values('CART1', 2, 2);

select * from cart_item;

# show all items in a specific cart
SELECT * FROM CART_ITEM INNER JOIN CART ON CART_ITEM.CART_ID = CART.ID WHERE CART_ITEM.CART_ID = "CART5";
