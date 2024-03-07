create sequence facilities_sequence start 2 increment 1;

create table if not exists facilities(
    id int8  primary key not null,
    wi_fi boolean,
    parking boolean,
    air_conditioning boolean,
    housekeeping boolean,
    terrace boolean,
    garden boolean,
    beach boolean,
    heating boolean,
    swimming_pool boolean,
    bar boolean
);

insert into facilities(id, wi_fi, parking,air_conditioning, housekeeping, terrace, garden, beach,heating,swimming_pool, bar)
values(1, true, false, true, true, false, false, true, false, false, true);