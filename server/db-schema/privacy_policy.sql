drop table privacy_policy;

create table privacy_policy(
	id int primary key auto_increment, 
	date_created date default (current_date),
    title varchar(255) default "privacy policy",
    description text not null
);

insert into privacy_policy (
description
)
values(
"Our company recognises the importance of maintaining your privacy. We value your privacy and appreciate your trust in us. This Privacy Policy applies to current and former visitors to our website and to our online customers. By visiting and/or using our website, you agree to this Privacy Policy.This Privacy Policy explains the information practices that apply to personally identifiable information that we collect about you as an individual, when you visit and/or use our website. Any information that we collect about you while you are visiting or using our website will be handeled in accordance with this company Privacy Policy and will not be shared except in accordance with this company Privacy Policy."
);

select * from privacy_policy;