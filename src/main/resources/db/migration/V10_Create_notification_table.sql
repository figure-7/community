create table notification
(
    id         bigint auto_increment
        primary key,
    notifier   bigint        not null,
    receiver   bigint        not null,
    outerId    bigint        null,
    type       int           not null,
    gmt_create bigint        null,
    status     int default 0 not null
);
alter table notification modify id bigint auto_increment;

alter table notification modify notifier bigint not null;

alter table notification modify receiver bigint not null;

alter table notification modify outerId bigint not null;

alter table notification modify type int not null;

alter table notification modify gmt_create bigint not null;

alter table notification modify status int default 0 not null;

