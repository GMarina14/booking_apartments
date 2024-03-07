create sequence user_registration_form_sequence start 2 increment 1;

create TABLE IF NOT EXISTS user_registration_form(
    id INT8  PRIMARY KEY NOT NULL,
    nickname varchar(255),
    username varchar(255),
    password varchar(255),
    token varchar(255)
);
insert into user_registration_form
values (1, 'test','test', 'test','ODBlZDRhZDQtODY0YS00YjQxLTg0YzktMWE3M2NjZmY1NmRlfDIwMzQtMDItMTFUMTk6NTQ6MjkuNjc5Nzg1NzAw');
