create sequence product_info_sequence  start 2 increment 1;

create table if not exists product_info(
 id INT8  PRIMARY KEY NOT NULL,
 is_active boolean,
 discount_info varchar,
 discount float
);

insert into product_info(id, is_active, discount_info,discount)
values(1, true, 'guest in city', 15.5);