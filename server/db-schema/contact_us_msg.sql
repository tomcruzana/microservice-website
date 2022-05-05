drop table contact_us_msg;

create table contact_us_msg(
	id int primary key auto_increment, 
	date_time_created timestamp default (current_timestamp),
	sender_name varchar(255) not null,
    email_address varchar(255) not null,
    email_subject varchar(255) not null default "EMAIL SUBJECT",
    email_message text not null
);

insert into contact_us_msg (
sender_name,
email_address,
email_message
)
values(
"john smith",
"john.smith@email.com",
"Hi! I just wanna say, GOOD JOB!"
);

select * from contact_us_msg;