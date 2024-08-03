create table if not exists  integration_info(
 id varchar,
 path_value varchar,
 key_value varchar
);

insert into integration_info(id,path_value, key_value  )
values('GEO','https://api.opencagedata.com/geocode/v1/json?q=%s+%s&key=%s', 'ZGZjYjY3ZmJiM2I3NGQzYjhjMDFkYmEyYTNlY2VmZTA=' );
insert into integration_info(id,path_value, key_value  )
values('DISCOUNT', 'http://localhost:9098/get-discount?id=%s', 'S3BDUUVFcWE3dlQwUEk2ZkhhWDdCQjR1ME9adWhhV2s0MWVaWEZVTzBMakU0SFFITUplVHBKZlMyZ3lqRTJLSw==');
