
/*select curdate();
select concat('e','q');

create table product_agreement(
parent_productid int primary key,
agreementid int primary key,
drop table parent_children_products;
foreign key (parent_productid) references Product.productid,
foreign key (agreementid) references Agreement.agreementid
);
*/
/*create database licences;*/
use licences;

drop table agreements;
drop table product;

create table Product(
productid integer primary key auto_increment,
name varchar(30) not null,
price decimal(10,2) default 0.0 not null,
parent_productid int default null,
start_date date default (curdate()) not null,
end_date date,
constraint fk_parent foreign key (parent_productid) references Product(productid),
constraint no_negatives check (not (price<0.0))
);
create table Agreements(
AgreementID int primary key auto_increment,
Name varchar(60) default (concat('Agreement ',date_format(curdate(),'%d-%m-%y'))) not null,
signed_by varchar(30) not null,
Product int not null,
constraint fk_product foreign key (product) references product(productid)
);

insert into Product(name)values('office');
/*insert into Product(name,price)values('office2',-2.0);*/
Select * from Product;
insert into Product(name,parent_productid)values('excel',1),('powerpoint',1),('word',1);
Select * from Product;
insert into Product(name)values('office365');
insert into Product(name,parent_productid)values('excel',5),('powerpoint',5),('word',5),('Activve Directory',5);
Select * from Product;
/*
SET @office_name = (SELECT name FROM Product WHERE name = 'office');
update Product set parent_productid=@office_name 
where productid in (select productid from Product 
where name in ('excel','powerpoint','word'));
*/
insert into Agreements(signed_by,product) values ('me',(SELECT name FROM Product WHERE name = 'office'));
select * from Agreements;
select * from Product where 1 = (parent_productid);
Select * from Product where 1 = Product.parent_productid
/*
create table Product;
*/
