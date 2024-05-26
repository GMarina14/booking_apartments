create sequence booking_info_sequence  start 2 increment 1;

create table if not exists booking_info(
 id INT8  PRIMARY KEY NOT NULL,
 start_date TIMESTAMP,
 end_date TIMESTAMP,
 apartment_id INT8 REFERENCES apartment(id),
 user_registration_form_id INT8 REFERENCES user_registration_form(id),
 price float,
 product_info_id INT8 REFERENCES product_info(id)
);

insert into booking_info(id, start_date, end_date, apartment_id, user_registration_form_id, price, product_info_id)
values(1, '2024-04-10 10:39:37', '2023-04-15 10:39:37', 1, 1, 14500.0, 1);
