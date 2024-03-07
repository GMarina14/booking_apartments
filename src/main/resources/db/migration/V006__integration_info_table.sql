create table if not exists  integration_info(
 id varchar,
 path_value varchar,
 key_value varchar
);

insert into integration_info(id,path_value, key_value  )
values('GEO','https://api.opencagedata.com/geocode/v1/json?q=%s+%s&key=%s', 'ZGZjYjY3ZmJiM2I3NGQzYjhjMDFkYmEyYTNlY2VmZTA=' );