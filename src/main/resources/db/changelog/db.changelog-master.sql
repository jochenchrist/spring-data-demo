--liquibase formatted sql

--changeset jochen:1
create table address (address_id varchar(255) not null, city varchar(255), street varchar(255), zip_code varchar(255), customer_id varchar(255), primary key (address_id));
create table customer (id varchar(255) not null, birthday date, email_address varchar(255), name varchar(40), sap_customer_id varchar(255), score bigint, scoring_result varchar(255), status varchar(255), primary key (id));
create index IDXet6863g0otfpmben3h9hsnmsw on customer (email_address);
alter table address add constraint FK93c3js0e22ll1xlu21nvrhqgg foreign key (customer_id) references customer;

