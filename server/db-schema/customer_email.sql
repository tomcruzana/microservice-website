drop table customer_email;

create table customer_email(
	email_address varchar(255) not null unique primary key, 
	date_created date default (current_date)
);

insert into customer_email
(
email_address
)
values
(
"john.smith@email.com"
);

select * from customer_email;