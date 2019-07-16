drop table if exists accounts, users;
drop sequence if exists account_seq;

create sequence account_seq start with 20659 increment by 13 minvalue 20000;

CREATE TABLE users(id serial primary key, username varchar, password varchar, permission tinyint);
CREATE TABLE accounts(accountNumber integer default nextval('account_seq'::regclass) not null, balance numeric(15, 2));
