## 码匠社区

## 资料 网址略

## 工具 网址略

## 脚本
```SQL
create table user
(
    id           int auto_increment,
    account_id   varchar(100) null,
    name         varchar(50)  null,
    token        char(36)     null,
    gmt_create   bigint       null,
    gmt_modified bigint       null,
    constraint id
        unique (id)
);

```
