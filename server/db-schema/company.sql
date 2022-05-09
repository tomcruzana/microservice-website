### COMPANY 
drop table company;

create table company(
	id int primary key auto_increment,
    owner_first_name varchar(255) not null,
    owner_last_name varchar(255) not null,
    email_address varchar(255) not null unique, 
    phone_number char(32) not null unique,
	slogan tinytext not null,
	business_hour_start time not null default "08:00:00",
    business_hour_end time not null default "05:00:00",
    business_days char(20),
	street varchar(255) not null,
	zip char(10) not null,
    state char(2) not null,
    country varchar(255) not null,
    city varchar(255) not null
);

insert into company
(
owner_first_name,
owner_last_name,
email_address,
phone_number,
slogan,
business_days,
street, zip, state, country, city
)
values
(
"thomas",
"developer",
"3609991234",
"thomas.developer@email.com",
"take it or leave it, we still love your business! please come again.",
"M - F",
"3550 southwest ave", "38225", "SE", "United Stated of Japan", "Heineken"
);

select * from company;
