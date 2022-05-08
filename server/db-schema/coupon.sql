drop table coupon;

create table coupon(
	id int primary key auto_increment, 
	date_created date default (current_date),
	code varchar(255) not null unique,
    discount decimal(13,2) not null,
    is_active tinyint not null default 1
);

insert into coupon
(
code,
discount
)
values
(
upper("zxvlabs"),
15.5
);

insert into coupon
(
code,
discount
)
values
(
upper("orland50"),
23.07
);

insert into coupon
(
code,
discount,
is_active
)
values
(
upper("chicky90"),
23.07,
0
);

select * from coupon;