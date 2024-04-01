alter table definepages add column moduleid int(11) default null;
alter table definepages add column productpageID int(11) default null;
alter table definepages add column submoduleid int(11) default null;


create table tbcustomermoduleflag(
	 id int(11) AUTO_INCREMENT NOT NULL,
	 moduleflag varchar(100) DEFAULT NULL,
	 moduleflagName varchar(100) DEFAULT NULL,
	 status char(1) DEFAULT NULL,
	 moduleId int(10) DEFAULT NULL,
	 userID int(10),
	 dateTime datetime,
	 activeStatus char(1) DEFAULT 'Y',
     primary key(id)
 );
 
 CREATE TABLE tbCustomerModules (
	id int(10)  auto_increment NOT NULL,
	modulesID int(11) DEFAULT NULL,
	modulename varchar(100) DEFAULT NULL,
	relationwarecustomer int(11) DEFAULT NULL,
	dateTime datetime DEFAULT NULL,
	activeStatus char(1) DEFAULT NULL,
	userID int(11) DEFAULT NULL,
	PRIMARY KEY (id)
);
CREATE TABLE tbcustomersubmodules (
	id int(10)  auto_increment NOT NULL,
	submodulename varchar(100) DEFAULT NULL,
	moduleid int(10) DEFAULT NULL,
	submoduleid int(10) DEFAULT NULL,
	date datetime DEFAULT NULL,
	activeStatus char(1) DEFAULT NULL,
	userid int(10) DEFAULT NULL,
	PRIMARY KEY (id)
) ;


alter table definepages add column productpageID int(10) default null;

alter table tbCustomerModules add column tbproductModuleID int(10) DEFAULT NULL;

 alter table tbcustomermoduleflag add column subModuleId int(10) DEFAULT NULL;
  alter table tbcustomermoduleflag add column type varchar(50) DEFAULT NULL;
 alter table tbcustomermoduleflag add column maxvalues varchar(50) DEFAULT NULL;
alter table tbmenu add column pageId int(11) default null;
alter table tbcustomermoduleflag add column productsubmoduleflagID int(10) DEFAULT NULL;

alter table tbcustomermoduleflag add column customervalue varchar(50) DEFAULT NULL;
