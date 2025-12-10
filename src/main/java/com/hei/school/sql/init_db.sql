create database product_management_db;

create user product_manager_user with password '123456';

grant connect on database product_management_db to product_manager_user;

\ c product_management_db grant grant all privileges on database product_management_db to product_manager_user;