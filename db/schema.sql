drop table if exists accounts, users;
drop sequence if exists account_seq;

create sequence account_seq start with 20659 increment by 13 minvalue 20000;

CREATE TABLE users(
    id serial primary key, 
    username varchar unique not null, 
    password varchar not null, 
    name varchar,
    permission SMALLINT not null);

CREATE TABLE accounts(
    accountnumber integer default nextval('account_seq') not null primary key, 
    balance numeric (15, 2),
    accounttype SMALLINT not null,
    approved boolean not null,
    accountowner varchar references users(username) on delete cascade 
    );

--CREATE TABLE link()


--ALTER TABLE users ADD accountno integer references accounts(accountnumber);


insert into users(username, password, name, permission) values ('mikeeroni', 'killemall', 'mike kostopolous', 1);
insert into users(username, password, permission) VALUES('michaleno18', 'iammichael', 1);
insert into users(username, password, permission) values('admin', 'password', 3);
insert into users(username, password, permission) values('employee1', 's3Cur3pAss', 2);
insert into users(username, password, permission) values('customer3', 'scruglebutt', 1);
insert into accounts values(nextval('account_seq'), 0, 1, 'f', 'mikeeroni');
insert into accounts values(nextval('account_seq'), 235.89, 0, 'f','mikeeroni');
insert into accounts values(nextval('account_seq'), 288.33, 1, 'f','michaleno18');
insert into accounts values(nextval('account_seq'), 3821.12, 1, 't','admin');

select username from users where username='michaleno18';
select * from accounts;

update accounts set balance=100.32 where accountOwner='mike' and accounttype=1;
update users set password='passWord123', name='timmothy' where username='michaleno18';
update users set name='johnny' where username='admin';

delete from accounts where accountowner='mikeeroni';

select * from users;
select accounts.accountnumber, users.username, users.password, accounts.balance, accounts.accounttype, accounts.approved
From accounts 
inner join users on accountowner = username;