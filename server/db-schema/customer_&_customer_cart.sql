### CUSTOMER CART
drop table customer_cart;

create table customer_cart(
	id int primary key
);

select * from customer_cart;


### CUSTOMER 
drop table customer;

create table customer(
	id int primary key auto_increment,
    customer_cart_id int unique,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    phone_number char(32) unique,
	email_address varchar(255) not null unique, 
	date_created date default (current_date),
    username varchar(255) not null unique,
    password varchar(255) not null,
    is_enabled boolean not null default true,
    foreign key (customer_cart_id) references customer_cart(id)
);

insert into customer
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

### cart creation logic
insert into customer_cart(id) values((select id from customer where username = "tomdev09"));
update customer set customer_cart_id = 1 where id = 1;

select * from customer;