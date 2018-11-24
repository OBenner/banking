
DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS accounts;



create table users (
    username varchar(50) not null primary key,
    password varchar(120) not null,
    email varchar(50),
    phone varchar(120),
    enabled boolean not null
);

create table accounts (
    username varchar(50) not null,
    code varchar(50) not null,
    accountNumber varchar(50) not null,
    amount DOUBLE,
    foreign key (username) references users (username)
);

create table authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    foreign key (username) references users (username)
);
