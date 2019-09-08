use  java;
drop table product;
create table product 
(
pid int NOT NULL AUTO_INCREMENT,
pname varchar(45) NOT NULL,
pdescription varchar(1000) NOT NULL,
PRIMARY KEY (pid)
)
;

Insert into product (pname,pdescription) values ('cashews','cashews from Mexico');
Insert into product (pname,pdescription) values ('rice','rice from India');
Insert into product (pname,pdescription) values ('blackbeans','blackbeans from Isreal');
commit;
select * from product;
