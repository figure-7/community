create table ad
(
	id int auto_increment,
	title varchar(256) default null null,
	url varchar(512) default null null,
	image varchar(256) default null null,
	gmt_start bigint null,
	gmt_end bigint null,
	gmt_create bigint null,
	gmt_modified bigint null,
	status int null,
	pos varchar(10) not null,
	constraint table_name_pk
		primary key (id)
);

