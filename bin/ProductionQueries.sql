create table tbproductionplanhdr(
	id int(11) AUTO_INCREMENT NOT NULL,
	planID  varchar(100) DEFAULT null,
	plandate date DEFAULT null,
	inventoryLocID int(11) DEFAULT null,
	complateflag char(1) DEFAULT 'Y',
	dateTime datetime DEFAULT NULL,
	conversiondone char(1) default 'N';
	requisitionsend char(1) default 'N';
	activeStatus char(1) DEFAULT 'Y',
    primary key(id)
);

create table tbproductionplandtl(
	id int(11) AUTO_INCREMENT NOT NULL,
	planID  int(11) DEFAULT null,
	itemid int(11) default null,
	itemname varchar(100) default null,
	productionquantity int(11) default null,
	planquantity int(11) default null,
	userid int(11) default null,
	dateTime datetime DEFAULT NULL,
	activeStatus char(1) DEFAULT 'Y',
    primary key(id)
);


CREATE TABLE tbplanconversionhdr (
	id int(10) NOT NULL auto_increment,
	userid int(10) DEFAULT NULL,
	date datetime DEFAULT NULL,
	activeStatus char(1) DEFAULT NULL,
	planid int(10) DEFAULT NULL,
	conversiontemplateid int(10) DEFAULT NULL,
	itemid int(10) DEFAULT NULL,
	quantity int(10) DEFAULT NULL,
	PRIMARY KEY (id)
);


CREATE TABLE tbplanconversiondtl (
	id int(10) NOT NULL auto_increment,
	userid int(10) DEFAULT NULL,
	date datetime DEFAULT NULL,
	activeStatus char(1) DEFAULT NULL,
	planid int(10) DEFAULT NULL,
	planconversionhdr int(10) DEFAULT NULL,
	itemid int(10) DEFAULT NULL,
	reqiredquantity int(10) DEFAULT NULL,
	quantity int(10) DEFAULT NULL,
	PRIMARY KEY (id)
);
