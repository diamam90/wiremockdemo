create table statistics
(
    id                  serial
        primary key,
    request_description varchar(255),
    request_time        timestamp,
    url                 varchar(255)
);
