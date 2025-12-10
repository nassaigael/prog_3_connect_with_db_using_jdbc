create table Product (
    id serial primary key,
    name varchar(250) not null,
    price numeric(10, 2) not null,
    creation_datetime timestamp not null
);

create table Product_category(
    id serial primary key,
    name varchar(250) not null,
    product_id int not null references Product(id)
);