### EMPLOYEE ROLE
drop table employee_role;

create table employee_role(
	name varchar(255) not null primary key unique
);

insert into employee_role (name)
values (upper("admin"));
insert into employee_role (name)
values (upper("guest"));
insert into employee_role (name)
values (upper("customer"));

select * from employee_role;


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
    employee_role_name varchar(255) not null,
    
    foreign key (employee_role_name) references employee_role(name)
);

insert into employee
(
first_name,
last_name,
email_address,
phone_number,
username,
password,
employee_role_name
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

select * from employee inner join employee_role on employee.employee_role_name = employee_role.name;
