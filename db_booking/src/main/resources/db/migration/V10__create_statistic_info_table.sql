create sequence statistic_info_sequence start 2 increment 1;

create table if not exists statistic_info(
 id INT8  PRIMARY KEY NOT NULL,
 apartment_id INT8 REFERENCES apartment(id),
 quantity_of_bookings INT,
 rental_income float,
 income_after_discount float
 );

insert into statistic_info (id,apartment_id, quantity_of_bookings,rental_income,income_after_discount)
values (1, 1, 1, 4500.0, 4000.0);