  drop sequence sss_num_seq;
  drop table sss_order_item;
  drop table sss_order;
  drop table sss_customer;
  
  
  
  create table sss_customer (
  id number,
  customerid number unique not null,
  firstname varchar(255),
  lastname varchar(255),
  contactnumber number(12),
  emailid varchar(255),
  CONSTRAINT sss_customer_pk PRIMARY KEY (id)
  );
  
  create  sequence sss_num_seq start with 1 increment by 1 nomaxvalue;
  
  /*
 create or replace trigger sss_cust_trigger
  before insert on sss_customer
  for each row
     begin
      if :new.id is null
      then
         select sss_num_seq.nextval into :new.id from dual;
      end if;
     end;
  /
  */
  
  create table sss_order (
  	id  number,
    orderid    number unique not null,  
    customerid number not null,
    totalprice number,
    constraint sss_order_pk PRIMARY KEY (id),
    constraint sss_order_fk1 foreign key (customerid) references sss_customer(customerid) 
    );
  
  
  create table sss_order_item(
    id number,
  	orderid number,
    itemcode varchar2(10),
    quantity number,
    price number,
    constraint sss_order_items PRIMARY KEY (id),
    constraint sss_order_items_fk1 foreign key (orderid) references sss_order(orderid)
  );
  
  
  
  /*
insert into sss_customer (customerid,firstname,lastname,contactnumber,emailid) values(11,'john','smith',9845112345,'jsmith@abc.xom');
insert into sss_customer (customerid,firstname,lastname,contactnumber,emailid) values(12,'peter','david',9845112346,'pdavid@abc.xom');
insert into sss_order(orderid,itemcode,quantity,price) values (11,'book',10,100);
insert into sss_order(orderid,itemcode,quantity,price) values (11,'cd',20,200);
insert into sss_cust_order(customerid,orderid,totalprice) values (11,1);
*/