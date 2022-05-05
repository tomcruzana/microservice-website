drop table customer;

create table customer(
	id int primary key auto_increment,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    phone_number char(32) unique,
	email_address varchar(255) not null unique, 
	date_created date default (current_date),
    username varchar(255) not null,
    password varchar(255) not null
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

select * from customer;