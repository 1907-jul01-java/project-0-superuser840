drop table if exists accounts, users;
drop sequence if exists account_seq;

create sequence account_seq start with 20659 increment by 13 minvalue 20000;

CREATE TABLE users(
    id serial primary key, 
    username varchar unique not null, 
    password varchar, 
    name varchar,
    permission SMALLINT not null);

CREATE TABLE accounts(
    accountNumber integer default nextval('account_seq') not null primary key, 
    balance numeric (15, 2),
    accountOwner varchar references users(username) on delete cascade, 
    accounttype smallint not null,
    approved bit);

--CREATE TABLE link()


ALTER TABLE users ADD accountno integer references accounts(accountnumber);


insert into users(username, password, permission) values('mike', 'killemall', 2);
insert into users(username, password, permission) VALUEs('michaleno18', 'iammichael', 1);
insert into users(username, password, permission) values('admin', 'password', 3);
insert into accounts values(nextval('account_seq'), 0, 'mike', 1);
insert into accounts (accountnumber, balance, accountowner, accounttype)values(nextval('account_seq'), 235.89, 'mike', 2);
insert into accounts(balance, accountOwner, accounttype) values(288.33, 'admin', 1);
insert into accounts(accountNumber, balance, accountOwner, accounttype) values(nextval('account_seq'), 3821.12, 'admin', 1);


update accounts set balance=100.32 where accountOwner='mike' and accounttype=1;
select * from accounts;
select accounts.accountnumber, users.username, users.password, accounts.balance
From users 
inner join accounts on accountowner = username;