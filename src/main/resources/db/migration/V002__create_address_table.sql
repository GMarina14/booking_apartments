create sequence address_sequence start 2 increment 1;

create table if not exists address(
    id int8  primary key not null,
    zip_code varchar(50),
    country varchar(50),
    region varchar(50),
    city varchar(50),
    street varchar(50),
    street_number varchar(50),
    apartment_number varchar(50),
    path_description varchar
);
insert into address (id,zip_code, country, region,city, street,street_number, apartment_number, path_description)
values (1, '115604','Russia', 'Moscow FO', 'Moscow', 'Parkovaya', '5', '14','https://www.google.com/maps/@55.6040192,37.76512,11z?entry=ttu');


