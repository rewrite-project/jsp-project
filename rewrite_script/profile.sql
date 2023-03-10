use rewrite;
create table tbl_profile(
	member_id int unsigned auto_increment primary key,
	profile_location varchar(500),
	profile_job varchar(500),
	profile_salary int,
	profile_hobby varchar(500),
	profile_mbti varchar(500),
	profile_height int,
	profile_child char(1) default 'n',
	profile_married char(1) default 'y',
	constraint fk_profile_member foreign key(member_id)
	references tbl_member(member_id) on delete cascade
);