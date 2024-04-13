create sequence image_sequence start 2 increment 1;

create TABLE IF NOT EXISTS image(
    id int8 PRIMARY KEY NOT NULL,
    image bytea
);


insert into image(id, image)
values(1,'186x268 JPEG image 15,24 kB');

