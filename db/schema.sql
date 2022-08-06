create table posts (
       id serial primary key,
       name varchar(2000),
       description text,
       created timestamp without time zone not null default now()
);

insert into posts (name) values ('О чем этот форум?');
insert into posts (name) values ('Правила форума.');

create table users (
                       id serial primary key,
                       username varchar(2000),
                       email varchar(255),
                       password varchar(255)
);

insert into users (username, email, password) values ('123', '123', '123');