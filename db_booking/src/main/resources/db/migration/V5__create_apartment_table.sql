create sequence apartment_sequence  start 2 increment 1;

create TABLE IF NOT EXISTS apartment(
    id INT8  PRIMARY KEY NOT NULL,
    property_name varchar(50),
    available boolean,
    price float,
    payment_options INT4,
    rooms_quantity INT4,
    occupancy INT4,
    room_type varchar,
    free_cancellation_days INT4,
    address_entity_id INT8 REFERENCES address(id),
    facilities_entity_id INT8 REFERENCES facilities(id),
    image_id INT8 REFERENCES image(id)
);

insert into apartment (id,property_name, available,price,payment_options,rooms_quantity, occupancy, room_type, free_cancellation_days, address_entity_id, facilities_entity_id, image_id)
values (1, 'property', true, 14500.0, 2, 2, 2,'APARTMENT', 10, 1,1,1);



