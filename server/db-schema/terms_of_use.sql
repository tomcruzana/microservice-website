drop table terms_of_use;

create table terms_of_use(
	id int primary key auto_increment, 
	date_created date default (current_date),
    title varchar(255) default "terms of use",
    description text not null
);

insert into terms_of_use (
description
)
values(
CONCAT_WS(
" ",
"Please read these Terms of Use carefully. These Terms of Use govern your access and use of this Site. By accessing or using this Site you confirm that you are competent to contract under the relevant local laws and that you agree to be bound by these Terms of Use and to any additional guidelines, restrictions, or rules that may be posted in connection with specific sections or services of this Site. All such additional posted guidelines, restrictions, or rules are hereby incorporated by reference into these Terms of Use.The company reserves the right to make changes to this Site and to these Terms of Use at any time without prior notice. You should review these Terms of Use each time you access this Site."
"You also agree that we may provide all legal communications and notices to you electronically by posting them on our website or, at our election, by sending an e-mail to the e-mail address you provided to us when you registered at our website. You may withdraw your consent to receive communications from us electronically by contacting customer care. However, if you withdraw your consent to receive our communications electronically, you must discontinue your use of your account.",
"This Site contains graphics, photographs, images, document layouts, artwork, text, fonts, and other information (referred to herein as “Content”). This Site and all Content are the copyrighted property by the company. All rights in this Site and its Content are reserved worldwide. It is strictly prohibited to retain, copy, distribute, publish, or use any portion of the Content except as expressly allowed in these Terms of Use."
));

select * from terms_of_use;