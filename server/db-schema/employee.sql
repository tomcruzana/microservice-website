### EMPLOYEE ROLE
drop table user_role;

create table user_role(
	name varchar(255) not null primary key unique
);

insert into user_role (name)
values (upper("admin"));
insert into user_role (name)
values (upper("guest"));
insert into user_role (name)
values (upper("customer"));

select * from user_role;


### COMPANY 
drop table employee;

create table employee(
	id int primary key auto_increment,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    email_address varchar(255) not null unique, 
    phone_number char(32) unique,
	username varchar(255) not null unique,
    password varchar(255) not null,
    is_enabled boolean not null default true,
    user_role_name varchar(255) not null,
    date_hired date not null default (current_date),
    
    foreign key (user_role_name) references user_role(name)
);

insert into employeesert
(
first_name,
last_name,
email_address,
phone_number,
username,
password,
user_role_name
)
values
(
"harold",
"reyes",
"harold.reyes@email.com",
"5361234511",
"hreyes11",
"$2a$12$nSA4W3X/lATK01ioARo01.fy7Ef6pyUm5/dQ3U9okWRxrgPvNWq6y",
upper("admin")
);

select * from employee;

select * from employee inner join user_role on employee.user_role_name = user_role.name;
