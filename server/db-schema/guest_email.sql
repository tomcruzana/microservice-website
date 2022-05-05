drop table guest_email;

create table guest_email(
	email_address varchar(255) not null unique primary key, 
	date_created date default (current_date)
);

insert into guest_email
(
email_address
)
values
(
"john.smith@email.com"
);

select * from guest_email;