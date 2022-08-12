create table posts (
       id serial primary key,
       name varchar(2000),
       description text,
       created timestamp without time zone not null default now()
);


-- CREATE TABLE authorities (
--                              id serial primary key,
--                              authority VARCHAR(50) NOT NULL unique
-- );
--
-- insert into authorities (authority) values ('ROLE_USER');
-- insert into authorities (authority) values ('ROLE_ADMIN');
--
--
-- create table users (
--                        id serial primary key,
--                        username VARCHAR(255) NOT NULL unique,
--                        email varchar(255),
--                        password varchar(255) not null,
--                        enabled boolean default true,
--                        authority_id int not null references authorities(id)
-- );

