create table tbdynamicForm(
	 id int(11) AUTO_INCREMENT NOT NULL,
	 masterName varchar(100) DEFAULT NULL,
	 tableName varchar(100) DEFAULT NULL,
	 inputName varchar(100) DEFAULT NULL,
	 component varchar(100) DEFAULT NULL,
	 dataType varchar(100) DEFAULT NULL,
	 maxLength int(10) DEFAULT NULL,
	 query varchar(500) DEFAULT NULL,
	 mandatory char(1) DEFAULT NULL,
	 validationMsg varchar(500) DEFAULT NULL,
	 sequence int(10) DEFAULT NULL,
	 activeStatus char(1) DEFAULT 'Y',
     primary key(id)
);
 
ALTER TABLE tbpipelinedtl ADD COLUMN sequence INT(10) DEFAULT NULL;

create table tbdropdown(
	id int(11) AUTO_INCREMENT NOT NULL,
	name varchar(50) DEFAULT NULL,
	type varchar(50) DEFAULT NULL,
	page varchar(50) DEFAULT NULL,
	activeStatus char(1) DEFAULT 'Y',
    primary key(id)
);

create table tbcountry (
	id int AUTO_INCREMENT NOT NULL,
	code varchar(50) DEFAULT NULL,
	name varchar(100) DEFAULT NULL,
	dateTime datetime DEFAULT NULL,
	activeStatus char(1) DEFAULT 'Y',
	primary key(id)
);

alter table tbstate modify column Country int(10) DEFAULT NULL;

create table tbcity (
	id int AUTO_INCREMENT NOT NULL,
	code varchar(50) DEFAULT NULL,
	name varchar(100) DEFAULT NULL,
	countryid int(10) DEFAULT NULL,
	stateid int(10) DEFAULT NULL,
	dateTime datetime DEFAULT NULL,
	activeStatus char(1) DEFAULT 'Y',
	primary key(id)
);

alter table tblocality add column country int(10) DEFAULT NULL;
alter table tblocality add column state int(10) DEFAULT NULL;
alter table tblocality add column city int(10) DEFAULT NULL;
alter table tblocality add column localeid int(10) DEFAULT NULL;
alter table tblocality add column pincode varchar(20) DEFAULT NULL;

alter table tblocale add column city int(10) DEFAULT NULL;

create table tbcustomertype (
	id int AUTO_INCREMENT NOT NULL,
	code varchar(30) DEFAULT NULL,
	type varchar(50) DEFAULT NULL,
	dateTime datetime DEFAULT NULL,
	activeStatus char(1) DEFAULT 'Y',
	primary key(id)
);

create table tbcustomertypeworkflow(
	id int(11) AUTO_INCREMENT NOT NULL,
	customertypeid int(11) DEFAULT NULL,
	salesTC char(1) DEFAULT 'N',
	salesSQ char(1) DEFAULT 'N',
	salesGSTS char(1) DEFAULT 'N',
	salesmail char(1) DEFAULT 'N',
	salessms char(1) DEFAULT 'N',
	orderAcceptance varchar(50) DEFAULT NULL,
	installation varchar(50) DEFAULT NULL,
	service varchar(50) DEFAULT NULL,
	serviceTC char(1) DEFAULT 'N',
	serviceSQ char(1) DEFAULT 'N',
	servcieGSTS char(1) DEFAULT 'N',
	servicemail char(1) DEFAULT 'N',
	servicesms char(1) DEFAULT 'N',
	userid int(11) DEFAULT NULL,
	dateTime datetime DEFAULT NULL,
	activeStatus char(1) DEFAULT 'Y',
	primary key(id)
);

create table tbresourcecustomertype(
	id int(11) AUTO_INCREMENT NOT NULL,
	typeid int(11) DEFAULT NULL,
	resourceid int(11) DEFAULT NULL,
	userid int(11) DEFAULT NULL,
	activeStatus char(1) DEFAULT 'Y',
	dateTime datetime DEFAULT NULL,
    primary key(id)
);

alter table tbaccount add column maplocation varchar(100) default null;
alter table tbaccount add column localityid int(11) default null;
alter table tbresource add column profileInstallation int(10) DEFAULT 0;

alter table tbaccount add column searchkeyword varchar(100) DEFAULT NULL;
alter table tbaccount add column customer char(1) DEFAULT NULL;
alter table tbaccount add column customertypeid int(11) default null;
alter table tbaccount add column constitutionid int default null;


CREATE TABLE tbgstdetails (
    id int(10) NOT NULL auto_increment,
    gsthdrid int(10),
    gstelementid int(10),
    persentage decimal(10,2),
    userid int(10),
    date date,
    activeStatus char(1),
    name varchar(100),
    PRIMARY KEY (id)
);

alter table tbcity add column userid int(10) DEFAULT NULL;

CREATE TABLE tbgsthdr (
    id int(10) NOT NULL auto_increment,
    code varchar(150),
    name varchar(500),
    userId int(10),
    date date,
    activeStatus char(1),
    persentage decimal(10,2),
    PRIMARY KEY (id)
);

alter table tbcampaign add column detail char(1) DEFAULT NULL;
ALTER TABLE tbregion RENAME COLUMN id TO regionID;
ALTER TABLE tbregion RENAME COLUMN name TO regionName;
ALTER TABLE tbregion RENAME COLUMN code TO regionCode;

alter table tbregion add column createddate Date DEFAULT NULL;
alter table tbregion add column activestatus char(1) DEFAULT NULL;
alter table tbregion add column dateTime Date DEFAULT NULL;
alter table tbregion add column userID int(10) DEFAULT NULL;
alter table tbregion RENAME column activeStatus char(1) DEFAULT 'Y';
alter table tbresourcetarget add column regionid int(10) DEFAULT NULL;
alter table tbresourcetarget add column areaid int(10) DEFAULT NULL;
alter table tbresourcetarget add column teamid int(10) DEFAULT NULL;

alter table tbresourcetarget add column currencyid int(10) DEFAULT NULL;
alter table tbresourcetarget add column targetflag char(1) DEFAULT NULL;
alter table tbcampaign add column detail char(1) DEFAULT NULL;
alter table tbregion RENAME column activeStatus char(1) DEFAULT 'Y';
alter table tbfinancialyear modify column activestatus char(1) DEFAULT "Y";
alter table tbcustomertypeworkflow add column payment varchar(100) DEFAULT null;
alter table tbmodeoftransport modify column userID int(10) DEFAULT NULL;
alter table tbmodeoftransport modify column activeStatus char(1) DEFAULT 'Y';

alter table tbresourcetarget add column productCategoryID int(10) DEFAULT NULL;
alter table tbresourcetarget modify column q1value varchar(30) DEFAULT NULL;
alter table tbresourcetarget modify column q2value varchar(30) DEFAULT NULL;
alter table tbresourcetarget modify column q3value varchar(30) DEFAULT NULL;
alter table tbresourcetarget modify column q4value varchar(30) DEFAULT NULL;

alter table tbcustomertypeworkflow add column chkSalesEnq char(1) DEFAULT 'N';
alter table tbcustomertypeworkflow add column chknoofemployee char(1) DEFAULT 'N';
alter table tbcustomertypeworkflow add column mandchkemp char(1) DEFAULT 'N';
alter table tbcustomertypeworkflow add column chkanualtrnovr char(1) DEFAULT 'N';
alter table tbcustomertypeworkflow add column mandchktrnovr char(1) DEFAULT 'N';
alter table tbcustomertypeworkflow add column chkindstype char(1) DEFAULT 'N';
alter table tbcustomertypeworkflow add column mandindtype char(1) DEFAULT 'N';
alter table tbcustomertypeworkflow add column industryid int(10) DEFAULT null;

create table tbmarketingcosthead (
    id int(10) NOT NULL auto_increment,
	userid int(10) DEFAULT NULL,
	code varchar(10) DEFAULT NULL ,
	costhead varchar(50) DEFAULT NULL,
	description varchar(100) DEFAULT NULL,
	dateTime date DEFAULT NULL,
	activestatus char(1) DEFAULT 'Y',
	primary key(id)
);	

create table tbmarketingcostsubhead (
    id int(10) NOT NULL auto_increment,
	userid int(10) DEFAULT NULL,
	marketingcostid int (10) DEFAULT NULL,
	code varchar(50) DEFAULT NULL,
	name varchar(50) DEFAULT NULL,
	description varchar(100) DEFAULT NULL,
	value char(1)DEFAULT 'Y',
	uomid int(10) DEFAULT NULL,
	uomname varchar(50) DEFAULT NULL,
	rate int(10) DEFAULT NULL,
	dateTime date DEFAULT NULL,
	activestatus char(1) DEFAULT 'Y',
	primary key(id)
);	

ALTER TABLE tbtask add column  actionTask varchar(20) DEFAULT NULL;
alter table tbproductCurrency add column date date DEFAULT NULL;
alter table tbcustomermoduleflag add column customervalue varchar(25) default null;
alter table tbaccwisemcdetls add column localityID int DEFAULT NULL;
alter table tbaccwisemcdetls add column address varchar(100) DEFAULT NULL;
alter table tbaccwisemcdetls add column pincode varchar(30) DEFAULT NULL;
alter table tbprospectopportunity add column  pincode varchar(100) default null;
alter table tbprospectopportunity add column address varchar(1000) default null;
alter table tbprospectopportunity add column sourcedetailsID int default null;
alter table tbresource add column discountAllowed decimal(10,2) DEFAULT NULL;
alter table TbCategoryTermsCondition add column customerTypeId int(10) DEFAULT NULL;
alter table tbproduct add column uom int(10) DEFAULT NULL;
alter table tbcustomertypeworkflow add column chkdealer char(1) DEFAULT 'N';
alter table tbproductCurrency add column effectivedate  date DEFAULT NULL;
alter table tbpipeline drop column descisionflag;
alter table tbaccwisemcdetls add column googlemap varchar(100) default null;
alter table tbprospectopportunity add column googlemap varchar(100) default null;
alter table tbspare add column productID int default null;

alter table tbquotation add column installationflag char(1);
alter table tbquotation add column serviceflag char(1);
alter table tborderinvoicehdr add column address varchar(1000) default null;
alter table tborderinvoicehdr add column remark varchar(100) default null;

alter table tborderinvoicedtl add column unitofmeasureId int(10);
alter table tborderinvoicedtl add column unitName varchar(100);

CREATE TABLE tbdealersdetails (
	dealersdtlId int(10) NOT NULL auto_increment,
	userID int(10) Default Null,
	code varchar(20),
    name varchar(100),
    status varchar(100),
    address text(1000),
    pincode varchar(20),
    city varchar(20),
    locality varchar(300),
    state varchar(100),
    country varchar(100),
    googlemaplocation varchar(100),
    landline varchar(200),
    email varchar(100),
    website varchar(50),
    constitutionid int(10),
    currencyid int(10),
    about varchar(300),
	gstNo varchar(20) Default Null,
	gstType char(1) ,
	panNo varchar(20),
	paymentTerm varchar(100),
	activeStatus char(1) DEFAULT 'Y',	
	datetime date,
	creditAmount int(20),
	creditDays int(20),
PRIMARY KEY (dealersdtlId));

CREATE TABLE tbdealersproduct (
	id int(10) NOT NULL auto_increment,
	userID int(10),
	datetime date,
	activeStatus char(1) DEFAULT 'Y',
	productcategoryId int(10),
	productcategoryName varchar(100),
	productId int(10),
	productName varchar(100),
	commission float(12),
	transferprice float(12),
	currencyId int(10),
	currencyName varchar(100),
	dealersdtlID int(10),
	mrp int(10),
	PRIMARY KEY (id)
) ;


alter table tbdealersdetails add column constitutionName varchar(100);
alter table tbdealersdetails add column currencyName varchar(100);
alter table tbdealersdetails add column localityID int(10);

create table tbdealercontact (
    id int(10) NOT NULL auto_increment,
	userId int(10) DEFAULT NULL,
	contactName varchar(50) DEFAULT NULL,
	designationName varchar(50) DEFAULT NULL,
	designationID int(10) DEFAULT NULL,
	country1 varchar(50) DEFAULT NULL,
	country1ID int(10) DEFAULT NULL,
	country2 varchar(50) DEFAULT NULL,
	country2ID int(10) DEFAULT NULL,
	mobile1ID int(10) DEFAULT NULL,
	mobile2ID int(10) DEFAULT NULL,
	email varchar(100) DEFAULT NULL,
	principalcontact char(1)DEFAULT 'N',
	dateTime date DEFAULT NULL,
	activestatus char(1) DEFAULT 'Y',
	primary key(id)
);	

rename table tbdemoquotation to tbquotionhistory;
rename table tbdemoquotationproduct to tbquotationproducthistory;
rename table tbdemoquotationTermsCondition to tbquotationtermsconditionhistory;
rename table tbdemoquotationconfigration to tbquotationconfigrationhistory;

alter table tbdealersdetails add column customertypewfID int(10);
alter table tbdealersproduct add column mrp int(10);
alter table tbdealersproduct modify column commission float(10) DEFAULT NULL;
alter table tbdealersproduct modify column transferprice float(10) DEFAULT NULL;

alter table tbcustomertypeworkflow add column chkdesignation char(1) default 'N';
alter table tbcustomertypeworkflow add column manddesignation char(1) default 'N';
alter table tbcustomertypeworkflow add column designationid int default null;

alter table tbsparequotation add column servicecallID int default null;
alter table tbsparequotation add column activityflag char(1) default null;
alter table tbsparequotation add column remark varchar(200) default null;
alter table tbsparequotation add column authorizationCode varchar(10) default null;
alter table tbsparequotation add column activityID int default null;

ALTER TABLE tbdealercontact ADD dealerid INT(10) DEFAULT NULL;

CREATE TABLE tbshippingaddress (
  id int(11) NOT NULL AUTO_INCREMENT,
  dealerid int(11) DEFAULT NULL,
  shortname varchar(200) DEFAULT NULL,
  address varchar(200) DEFAULT NULL,
  landmark varchar(200) DEFAULT NULL,
  pincode varchar(100) DEFAULT NULL,
  localityID int(11)DEFAULT null,
  localityname varchar(100) DEFAULT NULL,
  email varchar(100) DEFAULT NULL, 
  cityid int(11) DEFAULT NULL,
  city varchar(100) DEFAULT NULL,
  stateid int(11) DEFAULT NULL,
  state varchar(100) DEFAULT NULL,
  maplocation varchar(100) DEFAULT NULL,
  countryid int(11) DEFAULT NULL,
  country varchar(100) DEFAULT NULL,
  defaultflag char(1) DEFAULT NULL,
  userid int(10) DEFAULT NULL,
  date date DEFAULT NULL,
  mobile varchar(100) DEFAULT NULL,
  landline varchar(100) DEFAULT NULL,
  activeStatus char(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

create table tbitemcategory (
	id int AUTO_INCREMENT NOT NULL,
	itemcategorycode varchar(30) DEFAULT NULL,
	itemcategoryname varchar(50) DEFAULT NULL,
	userid int(10) DEFAULT NULL,
	dateTime datetime DEFAULT NULL,
	activeStatus char(1) DEFAULT 'Y',
	primary key(id)
);

create table tbitemSubCategory (
	id int AUTO_INCREMENT NOT NULL,
	itemcategoryid int(10) DEFAULT NULL,
	subcategorycode varchar(30) DEFAULT NULL,
	subcategoryname varchar(50) DEFAULT NULL,
	saleproductcategory char(1) DEFAULT 'N',
	productspare char(1) DEFAULT 'N',
	userid int(10) DEFAULT NULL,
	dateTime datetime DEFAULT NULL,
	activeStatus char(1) DEFAULT 'Y',
	primary key(id)
);

create table tbinventorylocation (
	id int AUTO_INCREMENT NOT NULL,
	locationcode varchar(30) DEFAULT NULL,
	locationname varchar(50) DEFAULT NULL,
	userid int(10) DEFAULT NULL,
	dateTime datetime DEFAULT NULL,
	activeStatus char(1) DEFAULT 'Y',
	primary key(id)
);

create table tbinventorylocationdtls (
	id int AUTO_INCREMENT NOT NULL,
	inventorylocationid int(10) DEFAULT NULL,
	itemcategoryid int(10) DEFAULT NULL,
	itemsubcategoryid int(10) DEFAULT NULL,
	userid int(10) DEFAULT NULL,
	dateTime datetime DEFAULT NULL,
	activeStatus char(1) DEFAULT 'Y',
	primary key(id)
);

ALTER TABLE tbdealercontact modify column  mobile1ID varchar(200) DEFAULT NULL;
ALTER TABLE tbdealercontact modify column  mobile2ID varchar(200) DEFAULT NULL;

CREATE TABLE tbdealerPurchaesOrderhdr (
	dealerpurhdrid int(10) NOT NULL auto_increment,
	customername varchar(100),
	userID int(10),
	activeStatus char(1) DEFAULT 'Y',
	datetime date,
	address varchar(100),
	creditDays int(10),
	creditLimit int(10),
	schemeId int(10),
	schemeCode varchar(100),
	discount int(10),
	Netorder int(10),
	Gst int(10),
	total int(10),
	fright int(10),
	termsconditionflag char(1),
	approvedorderflg char(1),
	financialyearId int(10),
	PRIMARY KEY (dealerpurhdrid)
);
alter table tbdealerPurchaesOrderhdr add column accountId int(10) DEFAULT NULL;

CREATE TABLE tbdealerPurchaesOrderdtl (
	dealerpurdtlid int(10) NOT NULL auto_increment,
    dealerpurhdrid int(10),
    productId int(10),
    productName varchar(100),
    productcategId int(10),
    prodcategoryname varchar(100),
    uomId int(10),
    uomName varchar(100),
    quantity int(10),
    price int(10),
    disscount int(10),
    gstid int(10),
    gstrate int(10),
    gstamount int(10),
    value int(10),
    totalevalue int(10),
    userID int(10),
	activeStatus char(1) DEFAULT 'Y',
	datetime date,
PRIMARY KEY (dealerpurdtlid)
);

alter table tbaccount add column creditdays int(10) DEFAULT NULL;
alter table tbaccount add column creditlimit int(10) DEFAULT NULL;

alter table tbservicecallentry add column localityID int DEFAULT NULL;
alter table tbservicecallentry add column address varchar(100) DEFAULT NULL;
alter table tbservicecallentry add column pincode varchar(30) DEFAULT NULL;
alter table tbservicecallentry add column reinstall char(1) DEFAULT 'N';

alter table tbsparequotation add column  followUp char(1) default 'N';
alter table tbsparequotation add column  followdate date default null;
alter table tbsparequotation add column  followassingto int(11) default null;
alter table tbsparequotation add column serviceOTP varchar(20) default null;
alter table tbsparequotation add column problemcateID int(11) default null;
alter table tbsparequotation add column observationandanalysis varchar(100) default null;
alter table tbsparequotation add column closecall char(1) default null;
alter table tbsparequotation add column closecallOTP varchar(20) default null;
alter table tbsparequotation add column cashreciveOTP varchar(20) default null;

alter table tbquotation add column appovedflag char(1) DEFAULT 'Y'; 
alter table tbquotation add column customertypeid int(10) DEFAULT null; 
alter table tbquotation add column accountname varchar(100) DEFAULT null;
alter table tbquotation add column approvedby varchar(20) DEFAULT NULL; 

alter table tbquotionhistory add column appovedflag char(1) DEFAULT 'Y'; 
alter table tbquotionhistory add column customertypeid int(10) DEFAULT null; 
alter table tbquotionhistory add column accountname varchar(100) DEFAULT null;
alter table tbquotionhistory add column approvedby varchar(20) DEFAULT NULL; 

alter table tbquotationproduct add column uomid int(10) default null;
alter table tbquotationproduct add column uom varchar(30) default null;
alter table tbspare add column gstheaderID int(11) default null;
alter table tbresource add column quotationApprovalid int(10) DEFAULT 0; 

CREATE TABLE tbspareinvoice (
    invoiceid int(10) NOT NULL auto_increment,
	quotationid int(10),
	accountID int(10),
	assignedto int(10),
	invoiceName varchar(100) ,
	startDate date DEFAULT null,
	closeDate date DEFAULT null,
	amount double,
	totaldiscount double,
	totalAmount double,
	lossReason varchar(100),
	activeStatus char(1) DEFAULT 'N',
	userID int(10),
	dateTime date DEFAULT null,
	approvalrequired char(1) DEFAULT 'N',
	approved char(1) DEFAULT 'Y',
	remark varchar(200),
	servicecallID int(10),
	problemcateID int(10),
	observationandanalysis varchar(100),
	PRIMARY KEY (invoiceid)
);

CREATE TABLE tbspareinvoiceproduct (
	invoiceProductID int(10) NOT NULL auto_increment,
	invoiceID int(10),
	productCategoryID int(10),
	productID int(10),
	defaultCurrency int(10),
	targetCurrency int(10),
	targetCurrencyExchangeRate double,
	taxgrouphdr int(10),
	price double,
	quantity int(10),
	discount double,
	revisedDiscount double,
	amount double,
	taxtotal double,
	grossAmount double,
	finalQuantity int(10),
	finalAmount double,
	activeStatus char(1) DEFAULT 'N',
	userID int(10),
	dateTime date DEFAULT null,
	PRIMARY KEY (invoiceProductID)
);

alter table tbsparequotation add column invoicesend char(1) default 'N';
alter table tbsparequotation add column serviceOTPverify char(1) default 'N';
alter table tbsparequotation add column closureOTPverify char(1) default 'N';
alter table tbquotation add column installationsInstructions varchar(1000) DEFAULT NULL; 
alter table tbquotation add column installationDate date DEFAULT NULL; 
alter table tbquotation add column installationTime varchar(100) DEFAULT NULL; 
alter table tbquotionhistory add column installationsInstructions varchar(1000) DEFAULT NULL; 
alter table tbquotionhistory add column installationDate date DEFAULT NULL; 
alter table tbquotionhistory add column installationTime varchar(100) DEFAULT NULL; 

CREATE TABLE tbdealersgeography (
	dealergeographyId int(10) NOT NULL auto_increment,
	userID int(10),
	countryid int(10),
	countryname varchar(100),
	regionid int(10),
	regionname varchar(100),
	cityname varchar(100),
	cityid int(10),
	stateid int(10),
	statename varchar(100),
	areaname varchar(100),
	areaid int(10),
	localeid int(10),
	localename varchar(100),
	localityname varchar(100),
	localityid int(10),
	dealersId int(10),
	activeStatus char(1) DEFAULT 'Y',
	datetime date,
	PRIMARY KEY (dealergeographyId)
) ;

create table tbitemmaster (
	id int AUTO_INCREMENT NOT NULL,
	itemcode varchar(200) DEFAULT NULL,
	itemname varchar(200) DEFAULT NULL,
	itemdescription varchar(200) DEFAULT NULL,
	itemType char(1) DEFAULT NULL,
	itemcategory varchar(200) DEFAULT NULL,
	itemcategoryid int(11) DEFAULT NULL,
	itemsubcategory varchar(200) DEFAULT NULL,
	itemsubcategoryid int(11) DEFAULT NULL,
	inventoryunitid int(11) DEFAULT NULL,
	inventoryunit varchar(200) DEFAULT NULL,
	productionunitid int(11) DEFAULT NULL,
	productionunit varchar(200) DEFAULT NULL,
	lengt int(11) DEFAULT NULL,
	breadth int(11) DEFAULT NULL,
	height int(11) DEFAULT NULL,
	diamensionUnitid int(11) DEFAULT NULL,
	diamensionUnit varchar(200) DEFAULT NULL,
	reorderLevel decimal(10,2) DEFAULT NULL,
	minimumOrderQty decimal(10,2) DEFAULT NULL,
	gstGroupid int(11) DEFAULT NULL,
	gstGrouppercentage int(11) DEFAULT NULL,
	hsnCode int(11) DEFAULT NULL,
	sacCode varchar(100) DEFAULT Null,
	unitConversion char(1) DEFAULT NULL,
	ucQuantity decimal(10,2) DEFAULT NULL,
	ucInventoryunitid int(11) DEFAULT NULL,
	ucInventoryunit varchar(200) DEFAULT NULL,
	convertsQuantity decimal(10,2) DEFAULT NULL,
	convertsInventoryunitid int(11) DEFAULT NULL,
	convertsInventoryunit varchar(200) DEFAULT NULL,
	bom char(1) DEFAULT NULL,
	userid int(10) DEFAULT NULL,
	dateTime datetime DEFAULT NULL,
	activeStatus char(1) DEFAULT 'Y',
	primary key(id)
	);
	
	create table tbbillofmaterial (
	id int AUTO_INCREMENT NOT NULL,
	itemid int(10) DEFAULT NULL,
	itemcode varchar(200) DEFAULT NULL,
	itemname varchar(200) DEFAULT NULL,
	uomid int(10) DEFAULT NULL,
	uom varchar(200) DEFAULT NULL,
	Quantity decimal(10,2) DEFAULT NULL,
	itemhdrid int(10) DEFAULT NULL,
	userid int(10) DEFAULT NULL,
	dateTime datetime DEFAULT NULL,
	activeStatus char(1) DEFAULT 'Y',
	primary key(id)
	);
	
	//Pranit
	alter table tbspare add column type varchar(25) default null;
	alter table tbspare add column itemmasterid int(10) default null;
	alter table tbproduct add column uom varchar(200) DEFAULT NULL; 
	alter table tbproduct add column itemmasterid int(10) default null;
	alter table tbspare add column quality int(25) DEFAULT NULL; 
	alter table tbspare add column description varchar(200) DEFAULT NULL; 


//vijay
alter table tbdealerPurchaesOrderhdr modify column approvedorderflg varchar(20);
alter table tbdealerPurchaesOrderhdr add column currentCreditlimit int(10); 

alter table tbdealersdetails add column currentCreditlimit int(10); 
alter table tbdealersdetails add column lastpaymentupdate Date; 
 
 
 
 CREATE TABLE tborderacceptancehdr (
	orderaccehdrID int(10) NOT NULL auto_increment,
	userID int(10),
	orderNo text(65535),
	orderDate date,
	accountID bigint(19),
	orderAmount decimal(12,2),
	dateTime datetime,
	activeStatus char(1),
	quotationID bigint(19),
	invoiceNo text(65535),
	invoiceDate date,
	invoiceDispatchDate date,
	quationRefNo text(65535),
	quationRefDate date,
	installationsID bigint(19),
	address varchar(1000),
	remark varchar(100),
	installationflag char(1),
	serviceflag char(1),
	orderApprove char(1),
	PRIMARY KEY (orderaccehdrID)
);


CREATE TABLE tborderacceptancedtl (
	orderaccedtlId int(10) NOT NULL auto_increment,
	orderaccehdrID bigint(19),
	userID int(10),
	productID bigint(19),
	productCatID bigint(19),
	qty decimal(12,2),
	dateTime datetime,
	activeStatus char(1),
	quotationproductID bigint(19),
	rate decimal(12,2),
	amt decimal(12,2),
	serialno varchar(50),
	invoiceNo varchar(200),
	invoiceDate date,
	value decimal(10,2),
	unitofmeasureId int(10),
	unitName varchar(100),
	PRIMARY KEY (orderaccedtlId)
);



create table tbcostheadpertemplate(
id int(10) NOT NULL auto_increment,
marketingcostid int(10),
costhead varchar(100),
percentage decimal(10,2),
marketingcostsubid int(10),
name varchar(100),
percentallocate decimal(10,2),
userid int(10),
datetime date,
activestatus char(1) default 'Y',
PRIMARY KEY (id)
);


alter table tbmarketingcostsubhead add column percentage decimal(10,2) DEFAULT NULL;




alter table tborderacceptancedtl add column supplyquantity decimal(10,2) DEFAULT 0;
alter table tborderacceptancedtl add column price decimal(10,2) DEFAULT 0;
alter table tborderacceptancedtl add column netamount decimal(10,2) DEFAULT 0;
alter table tborderacceptancedtl add column ordercomplete char(1) DEFAULT 'N';

alter table tborderacceptancehdr  add column customertypeID int(1) default null;
alter table tborderacceptancehdr  add column accountname varchar(100) default null;
alter table tborderinvoicehdr  add column orderacceptanceID int(1) default null;

alter table tborderinvoicehdr add column unPaidAmount decimal(10,2) default null;
alter table tborderinvoicehdr add column gstamount decimal(10,2) default 0;
alter table tborderinvoicehdr add column netamount decimal(10,2) default 0;
alter table tborderinvoicehdr add column grandtotal decimal(10,2) default 0;

alter table tborderinvoicedtl add column unitofmeasureId int(10) DEFAULT null;
alter table tborderinvoicedtl add column unitName varchar(50) DEFAULT null;
alter table tborderinvoicedtl add column supplyquantity decimal(10,2) DEFAULT 0;
alter table tborderinvoicedtl add column price decimal(10,2) DEFAULT 0;
alter table tborderinvoicedtl add column netamount decimal(10,2) DEFAULT 0;
alter table tborderinvoicedtl add column totalamount decimal(10,2) DEFAULT 0;
alter table tborderinvoicedtl change rate gstpercentage decimal(10,2) DEFAULT 0;
alter table tborderinvoicedtl change amt gstamount decimal(10,2) DEFAULT 0;
alter table tborderinvoicedtl change quotationproductID orderaccptancedtlid int(10) DEFAULT null;
alter table tborderacceptancedtl add column gstgroupid int(10) DEFAULT null;
alter table tborderinvoicedtl add column gstgroupid int(10) DEFAULT null;




create table tbmarketingbudgetareatemplate(
id int(10) NOT NULL auto_increment,
userid int(10),
financialyearId int(10),
financialYear varchar(100),
regionId int(10),
regionname varchar(100),
percentage decimal(10,2),
areaId int(10),
areaname varchar(100), 
percentage1 decimal(10,2),
cityid int(10),
cityname varchar(100),
percentage2 decimal(10,2),
datetime date,
activestatus char(1) DEFAULT 'Y',
PRIMARY KEY (id)
);

///Pranit
alter table tbdealersdetails add column vendor char(1) default null;
alter table tbdealersdetails add column currentCreditlimit int(10) DEFAULT NULL; 
alter table tbdealersdetails modify column constitutionName varchar(100) DEFAULT NULL;
alter table tbdealersdetails modify column currencyName varchar(100) DEFAULT NULL;
alter table tbdealersdetails modify column localityID int(10) DEFAULT NULL;

alter table tborderinvoicehdr add column inventorylocaltionid int(10) default null;


alter table tborderacceptancehdr add column localityID int(10) DEFAULT null;
alter table tbprospectopportunity add column localityID int(10) DEFAULT null;
alter table tborderacceptancehdr add column maplocaltion varchar(100) DEFAULT null;
alter table tbaccount add column landline varchar(50) DEFAULT null;


alter table tborderacceptancedtl add column discount decimal(10,2) DEFAULT 0;
alter table tborderinvoicedtl add column discount decimal(10,2) DEFAULT 0;

alter table tbquotation add column paymentterm varchar(20) default null;
alter table tborderacceptancehdr add column paymentterm varchar(20) default null;

alter table tbquotationproduct add column acceptedquantity decimal(10,2) DEFAULT 0;
alter table tbquotationproduct add column acceptall char(1) DEFAULT 'N';

alter table tbquotationproduct modify column quantity decimal(10,2) default 0;
alter table tbquotationproduct modify column finalQuantity decimal(10,2) default 0;
alter table tbquotationproducthistory modify column quantity decimal(10,2) default 0;
alter table tbquotationproducthistory modify column finalQuantity decimal(10,2) default 0;



alter table tbdealercontact modify column mobile1ID varchar(100) DEFAULT NULL;
alter table tbdealercontact modify column mobile2ID varchar(100) DEFAULT NULL;

alter table tborderinvoicedtl add column discountAmount decimal(10,2) default 0;
alter table tbquotationproduct add column discountAmount decimal(10,2) default 0;
alter table tborderacceptancedtl add column discountAmount decimal(10,2) default 0;

alter table tborderacceptancedtl add column listprice decimal(10,2) default 0;
alter table tborderinvoicedtl add column listprice decimal(10,2) default 0;

alter table tbgstdetails add column taxtype varchar(20) default null;

ALTER TABLE tbaccount CHANGE fax gstin varchar(100);


drop table tbinstallationresource;
create table tbinstallationresource (
	id int AUTO_INCREMENT NOT NULL,
	tbinstallations int(10) DEFAULT NULL,
	resourceID int(10) DEFAULT NULL,
	productID int(10) DEFAULT NULL,
	productcategorieID int(10) DEFAULT NULL,
	userID int(10) DEFAULT NULL,
	dateTime datetime DEFAULT NULL,
	activeStatus char(1) DEFAULT 'Y',
	primary key(id)
);

alter table tbquotation add column creditdays int(10) default 0;
alter table tbquotionhistory add column creditdays int(10) default 0;
alter table tborderacceptancehdr add column creditdays int(10) default 0;

alter table tborderacceptancehdr add column ponumber varchar(100) default null;
alter table tborderacceptancehdr add column podate date default null;
ALTER TABLE tbaccount CHANGE sapcode gsttype varchar(20);
alter table tbinstallations add column pincode varchar(100) default null;
alter table tbinstallations add column localityid int(11) default null;
alter table tbinstallations add column address varchar(100) default null;

alter table tbinstallations add column dcrdate date default null;
alter table tbinstallations add column dcrstarttime  varchar(50) default null;
alter table tbinstallations add column activityID int(11) default null;
alter table tbinstallations add column dcrremark  varchar(100) default null;
alter table tbinstallations add column googlemap  varchar(100) default null;
alter table tbinstallations add column followup char(1) default null;
alter table tbinstallations add column followupdate date default null;
alter table tbinstallations add column completed char(1) default null;
alter table tbinstallationresource add column completed char(1) default null;
alter table tbinstallations add column hourscount varchar(10) default null;
alter table  tbinstallationresource add column completeddateTime datetime default null;


alter table tborderacceptancehdr add column pincode varchar(30) default null;
alter table tborderinvoicehdr add column pincode varchar(30) default null;
alter table tborderinvoicehdr add column localityid int(10) default null;
alter table tbinstallations add column orderAcceptabceID int(11) default null;
alter table tbinstallationresource add column orderAcceptabceID int(11) default null;




create table tbpublictransaction (
	id int auto_increment not null,
	hashkey varchar(100) default null,
	customerid int(10) default null,
	refrenceID int(10) default null,
	transactiontype varchar(50) default null,
	dbname varchar(50) default null,
	actioncount int(10) default null,
	actiondatetime datetime default null,
	userid int(10) default null,
	datetime datetime default null,
	activestatus char(1) default 'Y',
	status char(1) default 'O',
	primary key(id)
);

alter table tbproduct add column serialnoFlag char(1) default 'N';





alter table tbinstallations add column branchid int(11) default null;

alter table tbquotation add column versionNo int(10) DEFAULT 0;
alter table tbquotionhistory add column versionNo int(10) DEFAULT 0;



alter table tbcostheadpertemplate add column mrkbudgettemphdr int(10);
alter table tbcostheadpertemplate add column mrkbudgettempdtl int(10);

CREATE TABLE tbmarketingBudgethdr (
	id int(10) NOT NULL auto_increment,
	userid int(10),
	allregionvalue decimal(10,2),
	financialyearId int(10),
	financialYear varchar(100),
	regionId int(10),
	regionname varchar(100),
	regionpercentage decimal(10,2),
	regionvalue decimal(10,2),
	areaId int(10),
	areaname varchar(100),
	areavalue decimal(10,2),
	mrkbudareatemphdrId int(10),
	datetime date,
	activestatus char(1) DEFAULT 'Y',
	PRIMARY KEY (id)
); 


CREATE TABLE tbmarketingBudgetdtl (
	id int(10) NOT NULL auto_increment,
	mrkbudgethdr int(10),
	userid int(10),
	cityid int(10),
	areaId int(10),
	cityname varchar(100),
	citypercentage decimal(10,2),
	cityvalue decimal(10,2),
	datetime date,
	activestatus char(1) DEFAULT 'Y',
	PRIMARY KEY (id)
);

CREATE TABLE tbmarketingHeadbudgetdtl (
	id int(10) NOT NULL auto_increment,
	mrkbudgethdr int(10),
	mrkbudgethdtl int(10),
	userid int(10),
	costheadid int(10),
	costhead varchar(100),
	costheadpercent decimal(10,2),
	costheadvalue decimal(10,2),
	datetime date,
	activestatus char(1) DEFAULT 'Y',
	PRIMARY KEY (id)
);

CREATE TABLE tbmarketingSubHeadbudgetdtl (
	id int(10) NOT NULL auto_increment,
	mrkbudgethdr int(10),
	mrkbudgethdtl int(10),
	mrkheadbudgetdtlid int(10),
	userid int(10),
	costsubheadid int(10),
	costsubheadname varchar(100),
	costsubheadpercent decimal(10,2),
	costsubheadvalue decimal(10,2),
	datetime date,
	activestatus char(1) DEFAULT 'Y',
	PRIMARY KEY (id)
);

alter table tbmarketingBudgetdtl add column areaId int(10) DEFAULT NULL;


CREATE TABLE tbmarketingBudDealerhdr (
	id int(10) NOT NULL auto_increment,
	userid int(10),
	allregionvalue decimal(10,2),
	financialyearId int(10),
	financialYear varchar(100),
	regionId int(10),
	regionname varchar(100),
	regionvalue decimal(10,2),
	areaId int(10),
	areaname varchar(100),
	areavalue decimal(10,2),
	city int(10),
	cityname varchar(100),
	cityvalue decimal(10,2),
	markBudgethdr int(10),
	datetime date,
	activestatus char(1) DEFAULT 'Y',
	PRIMARY KEY (id)
);

CREATE TABLE tbmarketingBudDealerdtl (
	id int(10) NOT NULL auto_increment,
	markBudDealerhdr int(10),
	userid int(10),
	dealerid int(10),
	dealerName varchar(100),
	percentage decimal(10,2),
	dealervalue decimal(10,2),
	datetime date,
	activestatus char(1) DEFAULT 'Y',
	PRIMARY KEY (id)
); 
CREATE TABLE tbmarketingHeadbuddealerdtl (
	id int(10) NOT NULL auto_increment,
	markBudDealerhdr int(10),
	markBudDealerdtl int(10),
	userid int(10),
	costheadid int(10),
	costhead varchar(100),
	costheadpercent decimal(10,2),
	costheadvalue decimal(10,2),
	datetime date,
	activestatus char(1) DEFAULT 'Y',
	PRIMARY KEY (id)
);

CREATE TABLE tbmarketingSubHeadbuddealerdtl (
	id int(10) NOT NULL auto_increment,
	markBudDealerhdr int(10),
	markBudDealerdtl int(10),
	markHeadbuddealerdtl int(10),
	userid int(10),
	costsubheadid int(10),
	costsubheadname varchar(100),
	costsubheadpercent decimal(10,2),
	costsubheadvalue decimal(10,2),
	datetime date,
	activestatus char(1) DEFAULT 'Y',
	PRIMARY KEY (id)
);


/////////
alter table tbitemmaster change id productID int(10) NOT NULL auto_increment;
alter table tbitemmaster change itemsubcategoryid productCategoryID int(10) default null;
alter table tbitemmaster change itemcode productCode varchar(100) default null;
alter table tbitemmaster change inventoryunitid uom int(10) default null;
alter table tbitemmaster change inventoryunit uomname varchar(100) default null;
alter table tbitemmaster change gstGroupid taxgrouphdr int(10) default null;
alter table tbitemmaster change itemdescription productName varchar(100) default null;

alter table tbitemmaster add column minimumPrice decimal(10,2) DEFAULT NULL;
alter table tbitemmaster add column priceEffectFrom date DEFAULT NULL;
alter table tbitemmaster add column warrantyMonths int(10) DEFAULT NULL;
alter table tbitemmaster add column HourFlag char(1) DEFAULT NULL;
alter table tbitemmaster add column discount decimal(10,2) DEFAULT NULL;
alter table tbitemmaster add column defaultCurrency int(10) DEFAULT NULL;
alter table tbitemmaster add column createddate date DEFAULT NULL;
alter table tbitemmaster add column bytepreport varchar(500) DEFAULT NULL;
alter table tbitemmaster add column machineimage varchar(500) DEFAULT NULL;
alter table tbitemmaster add column machineicon varchar(500) DEFAULT NULL;
alter table tbitemmaster add column spflag char(1) DEFAULT NULL;
alter table tbitemmaster Rename tbproduct 
alter table tbproduct add column serialnoFlag char(1) default 'N';

create table tbeventtype(
	id int AUTO_INCREMENT NOT NULL,
	code varchar(30) DEFAULT NULL,
	type varchar(100) DEFAULT NULL,
	userID int(10) DEFAULT NULL,
	dateTime datetime DEFAULT NULL,
	activeStatus char(1) DEFAULT 'Y',
	primary key(id)
);

create table tbmarketingProposalhdr(
	id int AUTO_INCREMENT NOT NULL,
	proposaltype varchar(20) DEFAULT NULL,
	resource int(10) DEFAULT NULL,
	eventtypeid int(10) DEFAULT NULL,
	shortname varchar(100) DEFAULT NULL,
	description varchar(500) DEFAULT NULL,
	expectedoutcome varchar(500) DEFAULT NULL,
	pincode  varchar(50) DEFAULT NULL,
	localityid int(10) DEFAULT NULL,
	proposedBy varchar(30) DEFAULT NULL,
	fromdate date DEFAULT NULL,
	todate date DEFAULT NULL,
	durationdays varchar(50) DEFAULT NULL,
	proposalStatus varchar(20) DEFAULT NULL,
	dealercontribution decimal(10,2) DEFAULT NULL,
	companycontribution decimal(10,2) DEFAULT NULL,
	proposaltotal decimal(10,2) DEFAULT NULL,
	approverid int(10) DEFAULT NULL,
	closeEvent char(1) DEFAULT 'N',
	userID int(10) DEFAULT NULL,
	dateTime datetime DEFAULT NULL,
	activeStatus char(1) DEFAULT 'Y',
	primary key(id)
);
create table tbmarketingProposaldtl(
	id int AUTO_INCREMENT NOT NULL,
	hdrid int(10) DEFAULT NULL,
	description varchar(200) DEFAULT NULL,
	amount decimal(10,2) DEFAULT NULL,
	sponser varchar(100) DEFAULT NULL,
	sponserid int(10) DEFAULT NULL,
	subheadid int(10) DEFAULT NULL,
	subheadname varchar(50) DEFAULT NULL,
	uomid int(10) DEFAULT NULL,
	uom varchar(50) DEFAULT NULL,
	userID int(10) DEFAULT NULL,
	dateTime datetime DEFAULT NULL,
	activeStatus char(1) DEFAULT 'Y',
	primary key(id)
);
CREATE TABLE tbmarketingbudgetareatemplatehdr (
	id int(10) NOT NULL auto_increment,
	userid int(10),
	financialyearId int(10),
	financialYear varchar(100),
	regionId int(10),
	regionname varchar(100),
	regionpercentage decimal(10,2),
	areaId int(10),
	areaname varchar(100),
	areapercentage decimal(10,2),
	datetime date,
	activestatus char(1) DEFAULT 'Y',
	PRIMARY KEY (id)
);

CREATE TABLE tbmarketingbudgetareatemplatedtl (
	id int(10) NOT NULL auto_increment,
	mrkbudgettemphdr int(10),
	userid int(10),
	cityid int(10),
	cityname varchar(100),
	citypercentage decimal(10,2),
	datetime date,
	activestatus char(1) DEFAULT 'Y',
	PRIMARY KEY (id)
);



CREATE TABLE tbmarketingbudgetareatemplatehdr (
    id int(10) NOT NULL auto_increment,
    userid int(10),
    financialyearId int(10),
    financialYear varchar(100),
    regionId int(10),
    regionname varchar(100),
    regionpercentage decimal(10,2),
    areaId int(10),
    areaname varchar(100),
    areapercentage decimal(10,2),
    datetime date,
    activestatus char(1) DEFAULT 'Y',
    PRIMARY KEY (id)
);


alter table tbmarketingProposaldtl add column approvedAmount decimal(10,2) DEFAULT NULL;
alter table tbmarketingProposaldtl add column disbursAmount decimal(10,2) DEFAULT NULL;
alter table tbmarketingProposaldtl add column disbursedBy int(10) DEFAULT NULL;
alter table tbservicecallentry add column activityID int(11) default null;
alter table tbprospectopportunity add column activityID int(11) default null;
alter table TbCategoryTermsCondition add column contitiontype varchar(10) default null; 

alter table tborderinvoicehdr add column problemcateID int(11) default null;
alter table tborderinvoicehdr add column observationandanalysis varchar(100) default null;
alter table tborderinvoicehdr add column remark varchar(100) default null;
alter table tborderinvoicehdr add column servicecallID int(11) default null;


alter table tbquotation add column otp varchar(50) DEFAULT NULL;
alter table tbquotation add column otpVerified char(1) DEFAULT null;
alter table tborderacceptancehdr add column approveType varchar(30) DEFAULT NULL;


alter table tborderinvoicehdr add column dealerPurchaseOrderhdrid int(10) DEFAULT NULL;
alter table tborderinvoicehdr add column invoiceType varchar(50) DEFAULT NULL;

alter table tbresource drop column quotationApprovalid ;

alter table tbresource drop column quotationApprovalid ;

alter table tbpipeline add column decisionflag char(1);


alter table tbresource drop column quotationApprovalid; 

alter table tbresource add column marketingApproval1 int(10) DEFAULT NULL;
alter table tbresource add column marketingApproval2 int(10) DEFAULT NULL;
alter table tbresource add column quotationApproval1 int(10) DEFAULT NULL;
alter table tbresource add column quotationApproval2 int(10) DEFAULT NULL;

alter table tbcustomertypeworkflow add column chkSupervisingAuth char(1) DEFAULT 'N';
alter table tbcustomertypeworkflow add column mandSupervisingAuth char(1) DEFAULT 'N';

alter table tbcustomertypeworkflow add column chksupplier char(1) DEFAULT 'N';


alter table tbinventorylocation add column productionLoc char(1) DEFAULT 'N';
alter table tbinventorylocation add column dispatchLoc char(1) DEFAULT 'N';
alter table tbinventorylocation add column rowMaterial char(1) DEFAULT 'N';

alter table tbcompany modify column dateTime datetime DEFAULT NULL;
alter table tbcompany add column gstnumber varchar(100) DEFAULT NULL;
alter table tbaccount add column buildingName varchar(100) DEFAULT NULL;
alter table tbaccount add column unitNumber varchar(100) DEFAULT NULL;
alter table tbenquiryname add column prefixCode varchar(100) DEFAULT NULL;

alter table tbinstallations drop column dcrdate;
alter table tbinstallations drop column dcrstarttime;
alter table tbinstallations drop column dcrremark;
alter table tbinstallations add column closureOTP varchar(10) default null;
alter table tbinstallations add column closureOTPverifyed char(1) default 'N';
alter table tbinstallations add column contactID int(10) default null;


CREATE TABLE tbConversionTemplatehdr (
    id int(10) NOT NULL auto_increment,
    userid int(10) DEFAULT null,
    datetime date ,
    activestatus char(1) DEFAULT 'Y',
    shortname varchar(50) DEFAULT null,
    formulaname varchar(100) DEFAULT null,
    itemcategorieID int(10) DEFAULT null,
    itemsubcategorieID int(10) DEFAULT null, 
    itemID int(10) DEFAULT null,
    itemUOMID int(10) DEFAULT null,
    itemUOM varchar(100) DEFAULT null,
    itemQuantity int(10) DEFAULT null,
    PRIMARY KEY (id)
);


CREATE TABLE tbConversionTemplatedtl (
    id int(10) NOT NULL auto_increment,
    userid int(10) DEFAULT null,
    datetime date ,
    activestatus char(1) DEFAULT 'Y',
    tbtemplatehdrID int(10) DEFAULT null,
    OMitemcategorieID int(10) DEFAULT null,
    OMitemsubcategorieID int(10) DEFAULT null, 
    OMitemID int(10) DEFAULT null,
    OMitemUOMID int(10) DEFAULT null,
    OMitemUOM varchar(100) DEFAULT null,
    OMitemQuantity int(10) DEFAULT null,
    PRIMARY KEY (id)
);


create table tbpohdr(
	id int(10) NOT NULL auto_increment,
	userid int(10) DEFAULT NULL,
	datetime datetime DEFAULT NULL,
	activeStatus char(1) DEFAULT 'Y',
	createdDate datetime DEFAULT NULL,
	podate date  DEFAULT NULL,
	pono varchar(100)  DEFAULT NULL,
	postatus varchar(50)  DEFAULT NULL,
	supplierid int(10) DEFAULT NULL,
	suppliername varchar(100)  DEFAULT NULL,	
	dispatchAddress varchar(300) DEFAULT NULL,
	totalnetamount decimal(10,2) DEFAULT NULL,
	totaltaxamount decimal(10,2) DEFAULT NULL,
	grandtotal decimal(10,2) DEFAULT NULL,
	PRIMARY KEY (id)
);
create table tbpodtl(
	id int(10) NOT NULL auto_increment,
	userid int(10) DEFAULT NULL,
	datetime datetime DEFAULT NULL,
	activeStatus char(1) DEFAULT 'Y',
	createdDate datetime DEFAULT NULL,
	pohdrid int(10)  DEFAULT NULL,
	pono varchar(100)  DEFAULT NULL,
	itemcateid int(10) DEFAULT NULL,
	itemsubcatid int(10) DEFAULT NULL,
	itemid int(10) DEFAULT NULL,
	itemname varchar(100) DEFAULT NULL,
	itemcode varchar(50) DEFAULT NULL,
	hsnc varchar(100) DEFAULT NULL,
	unitid int(10) DEFAULT NULL,
	unit varchar(50) DEFAULT NULL,
	taxgroupid int(10) DEFAULT NULL,
	taxpercent decimal(10,2) DEFAULT NULL,
	poqnty 	decimal(10,2) DEFAULT NULL,
	rate decimal(10,2) DEFAULT NULL,
	netamount decimal(10,2) DEFAULT NULL,
	gstamount decimal(10,2) DEFAULT NULL,
	totalamount decimal(10,2) DEFAULT NULL,
	PRIMARY KEY (id)
);
create table tbgrn(
	id int(10) NOT NULL auto_increment,
	userid int(10) DEFAULT NULL,
	datetime datetime DEFAULT NULL,
	createdDate datetime DEFAULT NULL,
	activeStatus char(1) DEFAULT 'Y',
	grnno varchar(50) DEFAULT NULL,
	grnstatus varchar(20) DEFAULT NULL,
	hashcode varchar(100) DEFAULT NULL,
	itemcateid int(10) DEFAULT NULL,
	itemsubcatid int(10) DEFAULT NULL,
	itemid int(10) DEFAULT NULL,
	itemname varchar(100) DEFAULT NULL,
	batchno varchar(100) DEFAULT NULL,
	poqnty decimal(10,2) DEFAULT NULL,
	invoiceqnty decimal(10,2) DEFAULT NULL,
	grnquantity decimal(10,2) DEFAULT NULL,
	rate decimal(10,2) DEFAULT NULL,
	netamount decimal(10,2) DEFAULT NULL,
	gstamount decimal(10,2) DEFAULT NULL,
	totalamount decimal(10,2) DEFAULT NULL,
	partyid int(10) DEFAULT NULL,
	partyname varchar(100) DEFAULT NULL,
	invoiceno varchar(100) DEFAULT NULL,
	invoicedate date DEFAULT NULL,
	referance varchar(100) DEFAULT NULL,
	locationid int(10) DEFAULT NULL,
	locationname varchar(100) DEFAULT NULL,
	poid int(10) DEFAULT NULL,
	pono varchar(100) DEFAULT NULL,
	chkverbal char(1) DEFAULT 'N',
	PRIMARY KEY (id)
);
create table tbstocktransaction(
	id int(10) NOT NULL auto_increment,
	userid int(10) DEFAULT NULL,
	datetime datetime DEFAULT NULL,
	activeStatus char(1) DEFAULT 'Y',
	transactionNo varchar(50) DEFAULT NULL,
	hashcode varchar(100) DEFAULT NULL,
	itemcateid int(10) DEFAULT NULL,
	itemsubcatid int(10) DEFAULT NULL,
	itemid int(10) DEFAULT NULL,
	itemname varchar(100) DEFAULT NULL,
	batchno varchar(100) DEFAULT NULL,
	grnquantity decimal(10,2) DEFAULT NULL,
	price decimal(10,2) DEFAULT NULL,
	partyid int(10) DEFAULT NULL,
	partyname varchar(100) DEFAULT NULL,
	invoiceno varchar(100) DEFAULT NULL,
	invoicedate date DEFAULT NULL,
	prevStock decimal(10,2) DEFAULT NULL,
	updateStock decimal(10,2) DEFAULT NULL,
	newStock decimal(10,2) DEFAULT NULL,
	operationType varchar(50) DEFAULT NULL,
	netamount decimal(10,2) DEFAULT NULL,
	taxamount decimal(10,2) DEFAULT NULL,
	grandtotal decimal(10,2) DEFAULT NULL,
	referance varchar(100) DEFAULT NULL,
	referanceNo varchar(100) DEFAULT NULL,
	documentType varchar(100) DEFAULT NULL,
	documentNo varchar(100) DEFAULT NULL,
	remarks varchar(500) DEFAULT NULL,
	PRIMARY KEY (id)
);
create table tbstocktable(
	id int(10) NOT NULL auto_increment,
	userid int(10) DEFAULT NULL,
	datetime datetime DEFAULT NULL,
	createdDate datetime DEFAULT NULL,
	stockno varchar(100) DEFAULT NULL,
	activeStatus char(1) DEFAULT 'Y',
	hashcode varchar(100) DEFAULT NULL,
	itemcateid int(10) DEFAULT NULL,
	itemsubcatid int(10) DEFAULT NULL,
	itemid int(10) DEFAULT NULL,
	itemname varchar(100) DEFAULT NULL,
	batchno varchar(100) DEFAULT NULL,
	price decimal(10,2) DEFAULT NULL,
	actualstock decimal(10,2) DEFAULT NULL,
	stockforsale decimal(10,2) DEFAULT NULL,
	unitid int(10) DEFAULT NULL,
	uom varchar(50) DEFAULT NULL, 
	PRIMARY KEY (id)
);

create table tbpaymentreceipthdr(
	id int(10) NOT NULL auto_increment,
	userid int(10) DEFAULT NULL,
	datetime datetime DEFAULT NULL,
	createdDate datetime DEFAULT NULL,
	activeStatus char(1) DEFAULT 'Y',
	paymentNo varchar(100) DEFAULT NULL,
 	partyid int(11) DEFAULT NULL,
	partyName varchar(100) DEFAULT NULL,
 	paymentType varchar(100) DEFAULT NULL,
 	bankName varchar(100) DEFAULT NULL,
  	paymentDate date DEFAULT NULL,
 	netAmount decimal(10,2) DEFAULT NULL,
 	bankCharges decimal(10,2) DEFAULT NULL,
 	grossAmount decimal(10,2) DEFAULT NULL,
 	balanceAmount decimal(10,2) DEFAULT NULL,
  	reference varchar(50) DEFAULT NULL,
	chequeNo varchar(100) DEFAULT NULL,
 	remarks varchar(500) DEFAULT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE tbpaymentreceiptdtl (
	id int(10) NOT NULL auto_increment,
	userid int(10) DEFAULT NULL,
	date datetime DEFAULT NULL,
	activeStatus char(1) DEFAULT NULL,
	paymentReceipthdrId int(10) DEFAULT NULL,
	invoicehdrId int(10) DEFAULT NULL,
	invoiceNo varchar(100) DEFAULT NULL,
	invoiceAmount decimal(10,2) DEFAULT NULL,
	paidAmount decimal(10,2) DEFAULT NULL,
	remainingInvoiceAmount decimal(10,2) DEFAULT NULL,
	paymentStatus varchar(50) DEFAULT NULL,
	PRIMARY KEY (id)
); 

alter table tborderinvoicehdr add column partyname varchar(100) DEFAULT NULL;
alter table tbpohdr add column receivedQuantity decimal(10,2) DEFAULT NULL;

 alter table tbdealerPurchaesOrderdtl add column acceptedQuantity decimal(10,2) DEFAULT NULL;
 alter table tbdealerPurchaesOrderdtl add column acceptedAll char(1) DEFAULT 'N';
 alter table TbCategoryTermsCondition add column tbpohdr int(10) DEFAULT NULL;
 
  CREATE TABLE tbpotermsandcondition (
	id int(10) NOT NULL auto_increment,
	descrption varchar(1000) DEFAULT NULL ,
	activeStatus char(1) DEFAULT 'Y',
	userID int(10) DEFAULT NULL,
	pohdrid int(10) DEFAULT NULL,
	PRIMARY KEY (id)
);
alter table tbpotermsandcondition add column categorytermconId int(10) DEFAULT NULL;

alter table tbaccount add column status varchar(40) DEFAULT NULL;
alter table tbaccount add column about varchar(100) DEFAULT NULL;
alter table tbaccount add column customertypewfId int(10) DEFAULT NULL;
alter table tbaccount add column currencyid int(10) DEFAULT NULL;
alter table tbaccount add column currencyname varchar(100) DEFAULT NULL;
alter table tbaccount add column dealerflag char(1) DEFAULT NULL;

alter table tbaccount Modify column constitution varchar(100) DEFAULT NULL;
alter table tbdealercontact add column username varchar(100) DEFAULT NULL;
alter table tbdealercontact add column password varchar(100) DEFAULT NULL;
alter table tbdealercontact add column login char(1) DEFAULT NULL;
alter table tbresource add column dealerId int(10) DEFAULT NULL;
alter table tbdealersdetails Modify column gstType varchar(100) DEFAULT NULL;

alter table tbtask add column sms char(1) Default 'N';
alter table tbtask add column email char(1) Default 'N';
alter table tbtask add column messageId int(10) DEFAULT Null;


CREATE TABLE messages (
    msg_id int(10) NOT NULL auto_increment,
    msgcode varchar(150),
    message varchar(500),
    deleted int(3) DEFAULT 0,
    templetId varchar(200),
    PRIMARY KEY (msg_id)
);

alter table tbstocktransaction add column inventorylocation varchar(100) DEFAULT Null;

alter table tbdealerPurchaesOrderdtl add column acceptedQuantity decimal(10,2) DEFAULT NULL;
alter table tbdealerPurchaesOrderdtl add column acceptedAll char(1) DEFAULT 'N';
alter table tbproduct modify column hsnCode varchar(100) default null;
alter table tbdealersdetails modify column gstType varchar(10) default null;

alter table tbsparequotation add column versionno int(11) default null;
create table tbsparequotationhistory (select *  from tbsparequotation);
truncate tbsparequotationhistory;
alter table tbsparequotationhistory add column tbsparequotationid int(11) default null;
alter table tbinstallations add column installtionunit varchar(100) default null;
alter table tbproduct add column itemcode varchar(100) default null;
alter table tbproduct change column productName  descrption varchar(100) default null;
alter table tbproduct add column salesproduct char(1) default null;
alter table tbproduct add column itemsubcategoryID int(11) default null;

drop table tbschemeconfiguration;

create table tbschemeconfiguration(
	id int(11) AUTO_INCREMENT NOT NULL,
 	activeStatus char(1) DEFAULT 'Y',
	dateTime datetime DEFAULT NULL,
	userid int(10) DEFAULT NULL,
	schemeCode varchar(100) DEFAULT NULL,
	schemeName varchar(100) DEFAULT NULL,
	customerTypeid int(10) DEFAULT NULL,
	description varchar(100) DEFAULT NULL,
	geographicsRefe char(1) DEFAULT 'N',
	countryId int(10) DEFAULT NULL,
 	regionId int(10) DEFAULT NULL,
	areaId int(10) DEFAULT NULL,
	cityid int(10) DEFAULT NULL,
	discountType varchar(30) DEFAULT NULL,
	percentage decimal(10,2) DEFAULT NULL,
	perTrnValue decimal(10,2) DEFAULT NULL,
	perMaxValue decimal(10,2) DEFAULT NULL,
	value decimal(10,2) DEFAULT NULL,
	valueTrnValue decimal(10,2) DEFAULT NULL,
	couponType varchar(50) DEFAULT NULL,
	couponQuantity int(10) DEFAULT NULL,
	quanType varchar(30) DEFAULT NULL,
	limitedQuan int(10) DEFAULT NULL,
	schemeValidity varchar(50) DEFAULT NULL,
	coupnsValidDays int(10) DEFAULT NULL,
	schemefrom date DEFAULT null,
	schemeto date DEFAULT null,
	foreCloseDate date DEFAULT null,
	foreClose varchar(500) DEFAULT NULL,
	foreCloseReason varchar(500) DEFAULT NULL,
	createdDate datetime DEFAULT NULL,
	primary key(id)
 );

   create table tbschemeconfigDtl(
 	id int(11) AUTO_INCREMENT NOT NULL,
 	activeStatus char(1) DEFAULT 'Y',
	dateTime datetime DEFAULT NULL,
	userid int(10) DEFAULT NULL,
	schemeid int(10) DEFAULT NULL,
	schemetype varchar(30) DEFAULT NULL,
	couponcode varchar(100) DEFAULT NULL,
	usecount int(10) DEFAULT NULL,
	totalCoupons  int(10) DEFAULT NULL,
 	primary key(id)
 );

create table tbresourceApprovals(
	id int(11) AUTO_INCREMENT NOT NULL,
 	activeStatus char(1) DEFAULT 'Y',
	dateTime datetime DEFAULT NULL,
	userid int(10) DEFAULT NULL,
	resourceid int(10) DEFAULT NULL,
	approvalType varchar(50) DEFAULT NULL,
	approverid int(10) DEFAULT NULL,
	sequance int(10) DEFAULT NULL,
	primary key(id)
);
alter table tbquotation add column approvers varchar(300) DEFAULT NULL;

alter table tborderinvoicehdr add column creditDate date DEFAULT NULL;

alter table tborderinvoicehdr add column creditDays int(10) DEFAULT NULL;

CREATE TABLE tbmaterialRequisitionhdr (
	id int(10) NOT NULL auto_increment,
	requisitionDate Date DEFAULT NULL,
	requisitionID varchar(100)  DEFAULT NULL,
	fromInventorylocation varchar(100)  DEFAULT NULL,
	toInventorylocation varchar(100)  DEFAULT NULL,
	requisitionNo int(40) DEFAULT NULL,
	status varchar(100)  DEFAULT NULL,
	userID int(10)  DEFAULT NULL,
	dateTime date  DEFAULT NULL,
	PRIMARY KEY (id)
) ;

CREATE TABLE tbmaterialRequisitiondtl (
	id int(10) NOT NULL auto_increment,
	itemcode varchar(100) DEFAULT NULL,
	itemname varchar(100)  DEFAULT NULL,
	itemcategoryid int(10)  DEFAULT NULL,
	itemSubcategoryid int(10)  DEFAULT NULL,
	uom varchar(100)  DEFAULT NULL,
	availablestock decimal(10,2)  DEFAULT NULL,
	quantityRequisitioned decimal(10,2) DEFAULT NULL,
	userID int(10)  DEFAULT NULL,
	dateTime date  DEFAULT NULL,
	PRIMARY KEY (id)
) ;

alter table tbcustomertypeworkflow add column chkUnitinstallation char(1) DEFAULT 'N';
alter table tbquotationproduct add column productName varchar(100) DEFAULT Null;

alter table tbmaterialRequisitionhdr add column requestorname varchar(100) ;
alter table tbdealerPurchaesOrderhdr modify column creditLimit decimal(10,2) Default null
alter table tbdealerPurchaesOrderhdr modify column Gst decimal(10,2) Default null;
alter table tbdealerPurchaesOrderhdr modify column total decimal(10,2) Default null;
alter table tbdealerPurchaesOrderhdr modify column fright decimal(10,2) Default null;
alter table tbdealerPurchaesOrderhdr modify column currentCreditlimit decimal(10,2) Default null;
alter table tbdealerPurchaesOrderhdr modify column Netorder decimal(10,2) Default null;

alter table tbdealerPurchaesOrderdtl modify column price decimal(10,2) Default null;
alter table tbdealerPurchaesOrderdtl modify column disscount decimal(10,2) Default null;
alter table tbdealerPurchaesOrderdtl modify column gstrate decimal(10,2) Default null;
alter table tbdealerPurchaesOrderdtl modify column gstamount decimal(10,2) Default null;
alter table tbdealerPurchaesOrderdtl modify column value decimal(10,2) Default null;
alter table tbdealerPurchaesOrderdtl modify column totalevalue decimal(10,2) Default null;

alter table tbdealerPurchaesOrderhdr add column purchaseOrderno varchar(100) DEFAULT NULL;

alter table tborderacceptancehdr add column gstType varchar(20) DEFAULT NULL;

alter table tborderacceptancehdr add column gstno varchar(100) DEFAULT NULL;
alter table tbaccwisemcdetls add column locality varchar(100) default null;

alter table tbproductionplanhdr  add column requisitioncreate char(1) default 'N'; 
alter table tbcustomertypeworkflow add column chkUnitinstallation char(1) default 'N';

CREATE TABLE tbplanconversionhdr (
	id int(10) NOT NULL auto_increment,
	userid int(10) default null,
	date datetime default null,
	activeStatus char(1) default 'N',
	planid int(10) default null,
	conversiontemplateid int(10) default null,
	itemid int(10) default null,
	quantity int(10) default null,
	bookingdone char(1) DEFAULT 'N',
	usedquantity int(10) default null,
	PRIMARY KEY (id)
);

CREATE TABLE tbplanconversiondtl (
	id int(10) NOT NULL auto_increment,
	userid int(10) default null,
	date datetime default null,
	activeStatus char(1) default 'Y',
	planid int(10) default null,
	planconversionhdr int(10) default null,
	itemid int(10) default null,
	reqiredquantity int(10) default null,
	quantity int(10) default null,
	 itemconversionquantity int(11) default null,
	usedquantity int(11) default null,
	PRIMARY KEY (id)
);

alter table tbplanconversionhdr add column templatedused char(1) default null;

alter table tbmaterialRequisitiondtl add column activestatus char(1) Default 'Y';
alter Table tbstocktable add column Locationid int(10) Default NULL;

alter table tbmaterialRequisitionhdr add column activestatus char(1) default 'Y';
alter table tbmaterialRequisitiondtl add column issuedquantity decimal(10,2) default NUll;
  
alter table tbstocktransaction add column fromlocationId int(10) default NUll;
alter table tbstocktransaction add column tolocationId int(10) default NUll;

alter table tbmaterialRequisitionhdr add column fromInventorylocationID int(11) default null;
alter table tbmaterialRequisitionhdr add column toInventorylocationID int(11) default null;
alter table tbmaterialRequisitiondtl add column itemID int(11) default null;
alter table tbmaterialRequisitiondtl add column tbmaterialRequisitionhdrID int(11) default null;

alter table tbmaterialRequisitionhdr add column palnID int(11) default null;

alter table tbstocktransaction add column fromlocationname varchar(100) default NUll;
alter table tbstocktransaction add column tolocationname varchar(100) default NUll;
alter table tbmaterialRequisitiondtl add column tbstocktransactionId int(10) default NUll;

alter table tbstocktable add column planID int(11) default null;
alter table tbproductionplandtl add column actualplanquantity int(11) default null;
alter table tbproductionplanhdr add column plancompletedateTime date default null;

CREATE TABLE tbmaterialPreRequisitiondtl (
	id int(10) NOT NULL auto_increment,
	itemcode varchar(100) default null,
	itemname varchar(100) default null,
	itemcategoryid int(10) default null,
	itemSubcategoryid int(10) default null,
	preRequisitionHdrID int(10) default null,
	uom varchar(100) default null,
	availablestock decimal(10,2) default null,
	quantityRequisitioned decimal(10,2) default null,
	userID int(10) default null,
	dateTime date default null,
	itemID int(10) default null,
	PRIMARY KEY (id)
) ;

CREATE TABLE tbmaterialPreRequisitionhdr (
	id int(10) NOT NULL auto_increment,
	requisitionDate date default null,
	palnID int(10) default null,
	requisitionID varchar(100) default null,
	fromInventorylocation varchar(100) default null,
	toInventorylocation varchar(100) default null,
	status varchar(100) default null,
	userID int(10) default null,
	dateTime date default null,
	fromInventorylocationID int(10) default null,
	toInventorylocationID int(10) default null,
	PRIMARY KEY (id)
);

CREATE TABLE tbproductionplandtl (
	id int(10) NOT NULL auto_increment,
	planID int(10) default null,
	itemid int(10) default null,
	itemname varchar(100) default null,
	productionquantity int(10) default null,
	planquantity int(10) default null,
	userid int(10) default null,
	dateTime datetime default null,
	activeStatus char(1) DEFAULT 'Y' ,
	actualplanquantity int(10) default null,
	PRIMARY KEY (id)
);

CREATE TABLE tbproductionplanhdr (
	id int(10) NOT NULL auto_increment,
	planID varchar(100) default null,
	plandate date default null,
	inventoryLocID int(10) default null,
	complateflag char(1) DEFAULT 'Y',
	dateTime datetime default null,
	activeStatus char(1) DEFAULT 'Y',
	conversiondone char(1) default null,
	requisitionsend char(1) default null,
	requisitioncreate char(1) DEFAULT 'N',
	plancompletedateTime date default null,
	PRIMARY KEY (id)
);

alter table tborderinvoicehdr add column gstType varchar(20) DEFAULT NULL;

alter table tborderinvoicehdr add column gstno varchar(100) DEFAULT NULL;
alter table tborderinvoicehdr add  column paymentterm varchar(50) DEFAULT NULL;

alter table tborderinvoicehdr add column supplierName varchar(100) DEFAULT NULL;
alter table tbaccount add column vendorflag char(1) Default null;
alter table tbcontact add column designationId int(10) Default null;

alter table tbpodtl add column receivedqnty decimal(10,2) DEFAULT NULL;
alter table tborderacceptancehdr add column costheadid int (10) default null;
alter table tborderacceptancehdr add column costSubheadid int (10) default null;
alter table tborderacceptancehdr add column costhead varchar (100) default null;
alter table tborderacceptancehdr add column costSubhead varchar (100) default null;

alter table tbgrn add column gstgrpid int(10) DEFAULT NULL;

alter table tbstocktransaction add column stockid int(10) DEFAULT NULL;

create table tbmaterialRejectReasons(
	id int(10) NOT NULL auto_increment,
	dateTime datetime default null,
	activeStatus char(1) DEFAULT 'Y',
	userID int(10) default null,
	reasonCode varchar(10) DEFAULT NULL,
	reason varchar(30) DEFAULT NULL,
	PRIMARY KEY (id)
);

alter table tbgrn add column uomid int(10) DEFAULT NULL;
alter table tbgrn add column uom varchar(50) DEFAULT NULL;
alter table tbmaterialPreRequisitionhdr add column activestatus char(1) default null;
alter table tbstocktransaction add column planID int(11) default null;


create table tbpaymentTransaction(
	id int(10) NOT NULL auto_increment,
	userid int(10) DEFAULT NULL,
	datetime datetime DEFAULT NULL,
	activeStatus char(1) DEFAULT 'Y',
	partyid int(10) DEFAULT NULL,
	partyname varchar(100) DEFAULT NULL,
	transactionNo varchar(50) DEFAULT NULL,
	invoiceid int(10) DEFAULT NULL,
	invoiceno varchar(100) DEFAULT NULL,
	invoicedate date DEFAULT NULL,
	netamount decimal(10,2) DEFAULT NULL,
	taxamount decimal(10,2) DEFAULT NULL,
	grandtotal decimal(10,2) DEFAULT NULL,
	prevLimit decimal(10,2) DEFAULT NULL,
	updateLimit decimal(10,2) DEFAULT NULL,
	newLimit decimal(10,2) DEFAULT NULL,
	operationType varchar(50) DEFAULT NULL,
	paymentreceiptid int(10) DEFAULT NULL,
	referance varchar(100) DEFAULT NULL,
	referanceNo varchar(100) DEFAULT NULL,
	remarks varchar(500) DEFAULT NULL,
	PRIMARY KEY (id)
);



CREATE TABLE tbspareIssuehdr (
	id int(10) NOT NULL auto_increment,
	userID int(10)  DEFAULT NULL,
	dateTime date  DEFAULT NULL,
	resourcename varchar(100)  DEFAULT NULL,
	resourceId int(10)  DEFAULT NULL,
	inventoryLocation varchar(100)  DEFAULT NULL,
	inventoryLocationId int(10)  DEFAULT NULL,
	activestatus char(1) Default 'Y',
   PRIMARY KEY (id)
);

CREATE TABLE tbspareIssuedtl (
	id int(10) NOT NULL auto_increment,
	userID int(10)  DEFAULT NULL,
	dateTime date  DEFAULT NULL,
	tbspareIssuehdrId int(10)  DEFAULT NULL,
	itemcategory varchar(100)  DEFAULT NULL,
	itemcategoryId int(10)  DEFAULT NULL,
	itemsubcategory varchar(100) DEFAULT NULL,
	itemsubcategoryID int(10) DEFAULT NULL,
	itemname varchar(100) DEFAULT NULL,
	itemId int(10) DEFAULT NULL,
	issuedquantity decimal(10,2) DEFAULT NULL,
	itemcode varchar(100) DEFAULT NULL,
	uom varchar(100) DEFAULT NULL,
	availablestock decimal(10,2) DEFAULT NULL,
	balance decimal(10,2) DEFAULT NULL,
	activestatus char(1) Default 'Y',
   PRIMARY KEY (id)
);

alter table tbinventorylocation add column spareLocation char(1) DEFAULT 'N';
alter table tbresource add column sparelocation varchar(100) Default Null;
alter table tbresource add column saleslocation varchar(100) Default Null;
alter table tbresource add column saleslocationId int(10) Default Null;
alter table tbresource add column sparelocationId int(10) Default Null;

alter table tbquotation add column schemeCode varchar(50) DEFAULT NULL;

alter table tbquotation add column schemeCode varchar(50) DEFAULT NULL;
alter table tbcategory Modify column categoryFlag varchar(100) default null;


CREATE TABLE tbactivitydtl (
	id int(10) NOT NULL auto_increment,
	customerType varchar(100) DEFAULT null,
	tbtaskId int(10) DEFAULT null,
	dateTime date DEFAULT null,
	userid int(10) default null,
	activeStatus char(1) DEFAULT 'Y',
	PRIMARY KEY (id)
);


alter table tbactivitydtl add column customertypeid int(10) Default Null;

alter table tbcontact modify column mobile varchar(50) Default null;

alter table tbcontact modify column designation varchar(100) Default null;
alter table tbcontact modify column firstName varchar(100) Default null;
alter table tbactivitydtl add column customertypeid int(10) Default Null;
alter table tblocale modify column localeName varchar(100) Default null;

alter table tblocality add column regionId int (10) Default Null;
alter table tblocality add column areaId int (10) Default Null;


alter table tbprospectopportunity add column buildingName varchar(100) DEFAULT NULL;
alter table tbprospectopportunity add column unitNumber varchar(100) DEFAULT NULL;
alter table tbusertask add column otp varchar(100) Default Null;
alter table tbusertask add column otpVerified char(1) Default Null;

alter table tbteammaster add column sales char(1) DEFAULT NULL;
alter table tbteammaster add column service char(1) DEFAULT NULL;
alter table tbteammaster add column installation char(1) DEFAULT NULL;
alter table tbproduct add column installation char(1) DEFAULT NULL;
alter table tbservicecallentry add column buildingName varchar(100) DEFAULT NULL;
alter table tbservicecallentry add column unitNumber varchar(100) DEFAULT NULL;


alter table tbspare add column spareID int(10) DEFAULT NULL;
alter table tbspare add column spareCode varchar(200) DEFAULT NULL; 
alter table tbspare add column spareName varchar(200) DEFAULT NULL; 
alter table tbspare add column spareProID int(10) DEFAULT NULL;

alter table tbsparequotation add column accountname varchar(500) DEFAULT NULL;
alter table tbsparequotation add column customertypeid int(10) DEFAULT NULL;
alter table tbsparequotationproduct add column uom varchar(50) DEFAULT NULL;
alter table tbsparequotationproduct add column uomid int(10) DEFAULT NULL;
alter table tbsparequotationproduct add column netamount decimal(10,2) DEFAULT NULL;

alter table tbcustomertypeworkflow add column approvedBy varchar(50) DEFAULT NULL;
alter table tborderinvoicehdr add column dispatchdetail varchar(500) Default Null;

alter table tbtask add column statusCode varchar(10) DEFAULT NULL;
UPDATE tbaccwisemcdetls SET amcWarrInstFlag = 'O';
alter table tbinstallationresource add column serialnumber varchar(50) DEFAULT NULL;
alter table tbaccwisemcdetls add column installclose char(1) DEFAULT NULL;

alter table tbaccwisemcdetls add column installBy varchar(50) DEFAULT NULL;
alter table tbaccwisemcdetls add column installByid int(10) DEFAULT NULL;
alter table tbinstallations add column installationApproved char(1) DEFAULT NULL;


alter table tbinstallationresource add column accountwisemcstatus char(1) default 'N';
alter table tbbranch add column Resource int(11) default null;
alter table tbteammember add column assigntoflag char(1) default 'N';
alter table messages add column displayname varchar(100) default null;

ALTER TABLE tbresourcelocationrights ADD COLUMN regionID INT(10) DEFAULT NULL;
ALTER TABLE tbresourcelocationrights ADD COLUMN cityID INT(10) DEFAULT NULL;
ALTER TABLE tbresourcelocationrights ADD COLUMN areaID INT(10) DEFAULT NULL;
ALTER TABLE tbresource ADD COLUMN allLocaleInRegion char(1) DEFAULT NULL;
alter table tbshippingaddress add column accountID int(10) DEFAULT NULL;
alter table tbshippingaddress add column gsttype varchar(50) DEFAULT NULL;
alter table tbshippingaddress add column gstno varchar(50) DEFAULT NULL;
alter table tbshippingaddress add column panno varchar(50) DEFAULT NULL;

alter table tborderacceptancehdr add column ConsigneeName varchar(100) Default Null;
alter table tborderacceptancehdr add column ConsigneeID int(10) Default Null;  
alter table tborderacceptancehdr add column panNo varchar(50) Default Null;

ALTER TABLE tbteamarea ADD COLUMN pincode INT(10) DEFAULT NULL;
ALTER TABLE tbteamarea ADD COLUMN localeid INT(10) DEFAULT NULL;
ALTER TABLE tbteamarea ADD COLUMN tblocality INT(10) DEFAULT NULL;
ALTER TABLE tbteamarea ADD COLUMN cityid INT(10) DEFAULT NULL;
alter table tbteamarea add column pincode int(10) DEFAULT NULL;


CREATE INDEX idx_searchkeyword ON tbaccount (searchkeyword);

CREATE TABLE tbteamcustomertype (
	teamCustomertypeID int(10) NOT NULL auto_increment,
	teamMasterID int(10),
	customertypeID int(10),
	activeStatus char(1) DEFAULT 'Y',
	dateTime datetime DEFAULT NULL,
	PRIMARY KEY (teamCustomertypeID)
);

alter table tbservicecallentry add column localeid int(10) DEFAULT NULL;



alter table tbsparequotationproduct add column spareid int(10) DEFAULT NULL;

alter table tbaccount drop column createddate;

ALTER TABLE tbaccount ADD createdBy INT(100) DEFAULT 0;
ALTER TABLE tbaccount ADD createdDate DATETIME;
ALTER TABLE tbaccount ADD lastModifiedBy INT(100) DEFAULT 0;
ALTER TABLE tbaccount ADD lastModifiedDate DATETIME;



ALTER TABLE tbspare ADD gstGrouppercentage INT(100) DEFAULT Null;

UPDATE tbmenu SET menuname = "Material Requisition Home" where ID = 161;
UPDATE tbmenu SET menuname = "Material Requisition Home" where ID = 247;
UPDATE tbmenu SET menuname = "Material Requisition Home" where ID = 333;
UPDATE tbmenu SET menuname = "Material Requisition Home" where ID = 365;
UPDATE tbmenu SET menuname = "Material Requisition Home" where ID = 499;
UPDATE tbmenu SET menuname = "Material Requisition Home" where ID = 551;
UPDATE tbmenu SET menuname = "Material Requisition Home" where ID = 627;
alter table tbinstallationresource add column installationselect char(1) default 'N';
alter table tbschemeconfigDtl add column balancecoupen int(11) DEFAULT NULL;
alter table tbcustomertypeworkflow add column schemeflag char(1) default 'N';
ALTER TABLE tbinstallations modify column address varchar(1000);

alter table tbquotationproduct add column rateWithdiscount double DEFAULT NULL;
alter table tborderacceptancedtl add column rateWithdiscount double DEFAULT NULL;
alter table tborderinvoicedtl add column rateWithdiscount double DEFAULT NULL;

--alter table tbmenu add column ismobile char(1) DEFAULT 'N';
alter table tbquotation add column showotpflag char(1) default 'N';
alter table tbinstallations add column showotpflag char(1) default 'N';
alter table tbsparequotation add column showotpflag char(1) default 'N';
alter table tbsparequotation add column showclosecallotpflag char(1) default 'N';

ALTER TABLE tbdealerPurchaesOrderdtl modify column  quantity decimal(10,2) DEFAULT 0.00;
ALTER TABLE tbdealerPurchaesOrderdtl modify column  price decimal(10,2) DEFAULT 0.00;
ALTER TABLE tbdealerPurchaesOrderdtl modify column  disscount decimal(10,2) DEFAULT 0.00;
ALTER TABLE tbdealerPurchaesOrderdtl modify column  gstrate decimal(10,2) DEFAULT 0.00;
ALTER TABLE tbdealerPurchaesOrderdtl modify column  gstamount decimal(10,2) DEFAULT 0.00;
ALTER TABLE tbdealerPurchaesOrderdtl modify column  value decimal(10,2) DEFAULT 0.00;
ALTER TABLE tbdealerPurchaesOrderdtl modify column  totalevalue decimal(10,2) DEFAULT 0.00;
alter table tbdealerPurchaesOrderdtl add column discountAmount decimal(10,2) default 0.00;
ALTER TABLE tbdealerPurchaesOrderhdr modify column Netorder decimal(10,2) DEFAULT 0.00;
ALTER TABLE tbdealerPurchaesOrderhdr modify column Gst decimal(10,2) DEFAULT 0.00;
ALTER TABLE tbdealerPurchaesOrderhdr modify column total decimal(10,2) DEFAULT 0.00;


alter table tbaccount add column bcreditlimit decimal(10,2) default 0.00;
alter table tbcategory modify column name varchar(100) DEFAULT NULL;

UPDATE definepages SET filename = 'Marketing Cost Sub-Head', dspname = 'Marketing Cost Sub-Head' WHERE ID = 35;
UPDATE tbmenu SET menuname = 'Marketing Cost Sub-Head', menupagename = 'Marketing Cost Sub-Head' WHERE ID = 45;
UPDATE tbmenu SET menuname = 'Marketing Cost Sub-Head', menupagename = 'Marketing Cost Sub-Head' WHERE ID = 134;
UPDATE tbmenu SET menuname = 'Marketing Cost Sub-Head', menupagename = 'Marketing Cost Sub-Head' WHERE ID = 220;
UPDATE tbmenu SET menuname = 'Marketing Cost Sub-Head', menupagename = 'Marketing Cost Sub-Head' WHERE ID = 306;
UPDATE tbmenu SET menuname = 'Marketing Cost Sub-Head', menupagename = 'Marketing Cost Sub-Head' WHERE ID = 388;
UPDATE tbmenu SET menuname = 'Marketing Cost Sub-Head', menupagename = 'Marketing Cost Sub-Head' WHERE ID = 472;
UPDATE tbmenu SET menuname = 'Marketing Cost Sub-Head', menupagename = 'Marketing Cost Sub-Head' WHERE ID = 516;
UPDATE tbmenu SET menuname = 'Marketing Cost Sub-Head', menupagename = 'Marketing Cost Sub-Head' WHERE ID = 600;
INSERT INTO definepages(ID, modulename, filename, dspname, activeStatus, package, reportname, productpageID, moduleid, submoduleid) VALUES (81, 'Masters', 'Marketing Cost Head', 'Marketing Cost Head', 'Y', null, null, null, 1, null);
--INSERT INTO tbmenu(ID, sequence, parentid, issubmenu, submenulimit, menuname, menupagename, package, resourcegroupid, userid, groupmenuid, landpage, activeStatus, pageId) VALUES (879, 2, 132, 'N', null, 'Marketing Cost Head', 'Marketing Cost Head', null, null, 1, null, 'N', 'Y', 81);

--INSERT INTO tbcustomermoduleflag (moduleflag, moduleflagName, status, moduleId, userID, dateTime, activeStatus, maxvalues, type, subModuleId, productsubmoduleflagID, customervalue) VALUES ('DM', 'Distribution Model', null, 1, 1, '2021-12-30 11:32:06', 'Y', null, 'I', 1, null, '');
UPDATE tbcompany SET pinCode = '411041', state = 'Maharashtra', country = 'India', telephone1 = '8888505404' WHERE companyID = 1;

UPDATE tbmenu SET menuname = 'Open / Lost Enquiries Report',
 menupagename = 'ExecutiveWiseQuotationSummaryReport' WHERE menuname = 'Executive Wise Quotation Summary Report';

UPDATE definepages SET filename = 'ExecutiveWiseQuotationSummaryReport',
dspname = 'Open / Lost Enquiries Report' WHERE ID = 75;

INSERT INTO dbeasydry.definepages (modulename, filename, dspname, activeStatus, package, reportname, productpageID, moduleid, submoduleid) VALUES ('Reports', 'ExecWiseQuotationDetailReport', 
'Executive Wise Quotation Detail Report', 'Y', null, null, null, 4, null);

alter table tbsparequotation add column schemecode varchar(50) DEFAULT NULL;
alter table tbsparequotationproduct add column discountAmount decimal(10,2) default 0.00;
alter table tbsparequotationproduct add column listprice decimal(10,2) default 0.00;

INSERT INTO messages (msgcode, message, deleted, templetId, displayname) VALUES ('Service Quotation', 'Estimated Repair cost is ${var}. Click on ${var1} to view Easy Dry quote and share the OTP ${var2} with our technician to confirm the order.', 0, '''1207164290803489799', 'Service Quotation');
ALTER TABLE tbmarketingProposalhdr ADD COLUMN cityid INT(10) DEFAULT NULL;
alter table tbmarketingProposalhdr add column Duration char(1) DEFAULT null;
alter table tbmarketingProposalhdr add column Daysormonth char(1) DEFAULT null;

alter table tbmarketingProposaldtl add column Date date default null;
alter table tbproblemcategory modify column activeStatus char(1) DEFAULT 'Y';
INSERT INTO definepages (modulename, filename, dspname, activeStatus, package, reportname, productpageID, moduleid, submoduleid) VALUES ('Reports', 'Area Performance Report', 'Area Performance Report', 'Y', null, null, null, 4, null);
alter table tbmarketingBudgethdr add column areapercentage decimal(10,2) DEFAULT NULL;

alter table tbmarketingcostsubhead modify column rate decimal(10,2) default null;
alter table tbmarketingSubHeadbudgetdtl add column qty decimal(10,2) DEFAULT NULL;
alter table tbmarketingSubHeadbudgetdtl add column rate decimal(10,2) DEFAULT NULL;
alter table tbmarketingSubHeadbudgetdtl add column uomName varchar(20) DEFAULT NULL;

alter table tbmarketingProposaldtl add column balance decimal(10,2) default 0.00;
alter table tbmarketingProposaldtl add column qty decimal(10,2) default 0.00;
alter table tbmarketingSubHeadbudgetdtl add column proposed decimal(10,2) default 0.00;
alter table tbmarketingSubHeadbudgetdtl add column balance decimal(10,2) default 0.00;
alter table tbmarketingSubHeadbudgetdtl add column disbursed decimal(10,2) default 0.00;
alter table tbmarketingProposaldtl add column budgeted decimal(10,2) default 0.00;
alter table tbmarketingProposaldtl add column finalamount decimal(10,2) default 0.00;
alter table tbmarketingSubHeadbudgetdtl modify column qty decimal(10,2) DEFAULT 0.00;
alter table tbmarketingSubHeadbudgetdtl modify column rate decimal(10,2) DEFAULT 0.00;

alter table tbmarketingSubHeadbuddealerdtl add column qty decimal(10,2) DEFAULT 0.00;
alter table tbmarketingSubHeadbuddealerdtl add column rate decimal(10,2) DEFAULT 0.00;
alter table tbmarketingSubHeadbuddealerdtl add column uomName varchar(20) DEFAULT NULL;

alter table tbmarketingBudDealerdtl add column areaId int(10) DEFAULT NULL;
alter table tbmarketingBudDealerdtl add column city int(10) DEFAULT NULL;
alter table tbmarketingBudDealerdtl add column cityname varchar(100) DEFAULT NULL;
alter table tbmarketingBudDealerdtl add column cityvalue decimal(10,2) DEFAULT 0.00;

UPDATE definepages SET filename = 'Event Type', dspname = 'Event Type' WHERE ID = 68;
UPDATE tbmenu SET menuname = 'Event Type', menupagename = 'Event Type' WHERE ID = 47;
UPDATE tbmenu SET menuname = 'Event Type', menupagename = 'Event Type' WHERE ID = 136;
UPDATE tbmenu SET menuname = 'Event Type', menupagename = 'Event Type' WHERE ID = 222;
UPDATE tbmenu SET menuname = 'Event Type', menupagename = 'Event Type' WHERE ID = 308;
UPDATE tbmenu SET menuname = 'Event Type', menupagename = 'Event Type' WHERE ID = 474;
UPDATE tbmenu SET menuname = 'Event Type', menupagename = 'Event Type' WHERE ID = 602;

INSERT INTO tbmenu (sequence, parentid, issubmenu, submenulimit, menuname, menupagename, package, resourcegroupid, userid, groupmenuid, landpage, activeStatus, pageId) VALUES (3, 120, 'N', null, 'Problem Category', 'Problem Category', null, null, 1, null, 'N', 'Y', 85);
INSERT INTO tbmenu (sequence, parentid, issubmenu, submenulimit, menuname, menupagename, package, resourcegroupid, userid, groupmenuid, landpage, activeStatus, pageId) VALUES (3, 206, 'N', null, 'Problem Category', 'Problem Category', null, null, 2, null, 'N', 'Y', 85);
INSERT INTO tbmenu (sequence, parentid, issubmenu, submenulimit, menuname, menupagename, package, resourcegroupid, userid, groupmenuid, landpage, activeStatus, pageId) VALUES (3, 292, 'N', null, 'Problem Category', 'Problem Category', null, null, 3, null, 'N', 'Y', 85);
INSERT INTO tbmenu (sequence, parentid, issubmenu, submenulimit, menuname, menupagename, package, resourcegroupid, userid, groupmenuid, landpage, activeStatus, pageId) VALUES (3, 458, 'N', null, 'Problem Category', 'Problem Category', null, null, 5, null, 'N', 'Y', 85);

--EventType
UPDATE tbmenu SET sequence = 6 WHERE ID = 47;
UPDATE tbmenu SET sequence = 6 WHERE ID = 136;
UPDATE tbmenu SET sequence = 6 WHERE ID = 222;
UPDATE tbmenu SET sequence = 6 WHERE ID = 308;
UPDATE tbmenu SET sequence = 6 WHERE ID = 474;
UPDATE tbmenu SET sequence = 6 WHERE ID = 602;

UPDATE tbmenu SET sequence = 5, parentid = 43 WHERE ID = 73;
UPDATE tbmenu SET sequence = 5, parentid = 132 WHERE ID = 165;
UPDATE tbmenu SET sequence = 5, parentid = 598 WHERE ID = 251;
UPDATE tbmenu SET sequence = 5, parentid = 304 WHERE ID = 337;
UPDATE tbmenu SET sequence = 5, parentid = 43 WHERE ID = 396;
UPDATE tbmenu SET sequence = 5, parentid = 43 WHERE ID = 404;
UPDATE tbmenu SET sequence = 5, parentid = 43 WHERE ID = 413;
UPDATE tbmenu SET sequence = 5, parentid = 43 WHERE ID = 424;
UPDATE tbmenu SET sequence = 5, parentid = 470 WHERE ID = 503;
UPDATE tbmenu SET sequence = 5, parentid = 598 WHERE ID = 631;

UPDATE tbmenu SET sequence = 3 WHERE ID = 45;
UPDATE tbmenu SET sequence = 3 WHERE ID = 220;
UPDATE tbmenu SET sequence = 3 WHERE ID = 306;
UPDATE tbmenu SET sequence = 3 WHERE ID = 388;
UPDATE tbmenu SET sequence = 3 WHERE ID = 472;
UPDATE tbmenu SET sequence = 3 WHERE ID = 516;
UPDATE tbmenu SET sequence = 3 WHERE ID = 600;

INSERT INTO tbmenu (sequence, parentid, issubmenu, submenulimit, menuname, menupagename, package, resourcegroupid, userid, groupmenuid, landpage, activeStatus, pageId) VALUES (2, 304, 'N', null, 'Marketing Cost Head', 'Marketing Cost Head', null, null, 3, null, 'N', 'Y', 81);
INSERT INTO tbmenu (sequence, parentid, issubmenu, submenulimit, menuname, menupagename, package, resourcegroupid, userid, groupmenuid, landpage, activeStatus, pageId) VALUES (2, 470, 'N', null, 'Marketing Cost Head', 'Marketing Cost Head', null, null, 5, null, 'N', 'Y', 81);
INSERT INTO tbmenu (sequence, parentid, issubmenu, submenulimit, menuname, menupagename, package, resourcegroupid, userid, groupmenuid, landpage, activeStatus, pageId) VALUES (2, 598, 'N', null, 'Marketing Cost Head', 'Marketing Cost Head', null, null, 2, null, 'N', 'Y', 81);

UPDATE tbmenu SET sequence = 4 WHERE ID = 46;
UPDATE tbmenu SET sequence = 4 WHERE ID = 307;
UPDATE tbmenu SET sequence = 4 WHERE ID = 473;
UPDATE tbmenu SET sequence = 4 WHERE ID = 601;
UPDATE tbmenu SET sequence = 5 WHERE ID = 631;

INSERT INTO definepages (modulename, filename, dspname, activeStatus, package, reportname, productpageID, moduleid, submoduleid) VALUES ('Reports', 'Team Performance Report', 'Team Performance Report', 'Y', null, null, null, 4, null);
INSERT INTO definepages (modulename, filename, dspname, activeStatus, package, reportname, productpageID, moduleid, submoduleid) VALUES ('Reports', 'ServiceExeWiseQuotationDtlReport', 'Executive Wise Service Quotation Detail Report', 'Y', null, null, null, 4, null);
INSERT INTO definepages (modulename, filename, dspname, activeStatus, package, reportname, productpageID, moduleid, submoduleid) VALUES ('Reports', 'OpenCloseServiceEnquiriesReport', 'Open Close Service Enquiries Report', 'Y', null, null, null, 4, null);

drop table tbitemmaster;
drop table excel;
drop table tbmarketingbudgetareatemplate;

alter table TbCategoryTermsCondition modify column categoryID int(10) DEFAULT NULL;
--ALTER TABLE tbservicecallentry ADD COLUMN callstage char(1) DEFAULT 'Y';

alter table tbmaterialRejectReasons Modify column reason varchar(300) DEFAULT NULL;
alter table tbmaterialRejectReasons Modify column reasonCode varchar(100) DEFAULT NULL;
alter table tbstocktransaction add column rejectedqty int(10) DEFAULT NULL;
alter table tbstocktransaction add column rejectedId int(10) DEFAULT NULL;
alter table tbstocktransaction add column rejectedName varchar(100) DEFAULT NULL;
alter table tbstocktransaction modify column rejectedqty decimal(10,2) DEFAULT NULL;

INSERT INTO definepages (modulename, filename, dspname, activeStatus, package, reportname, productpageID, moduleid, submoduleid) VALUES ('Reports', 'Performance Reprot of Technicians', 'Performance Reprot of Technicians', 'Y', null, null, null, 4, null);
UPDATE definepages SET dspname = 'Completed Enquiries' WHERE ID = 87;
select * from tbmenu where menuname = 'Executive Wise Service Quotation Detail Report';
UPDATE tbmenu SET menuname = 'Completed Enquiries' WHERE ID = 995;
UPDATE tbmenu SET menuname = 'Completed Enquiries' WHERE ID = 997;
UPDATE tbmenu SET menuname = 'Completed Enquiries' WHERE ID = 999;
UPDATE tbmenu SET menuname = 'Completed Enquiries' WHERE ID = 1002;

UPDATE definepages SET dspname = 'Pending / In Progress / Rejected Enquiries' WHERE ID = 88;
select * from tbmenu where menuname = "Open Close Service Enquiries Report"
UPDATE tbmenu SET menuname = 'Pending / In Progress / Rejected Enquiries' WHERE ID = 994;
UPDATE tbmenu SET menuname = 'Pending / In Progress / Rejected Enquiries' WHERE ID = 996;
UPDATE tbmenu SET menuname = 'Pending / In Progress / Rejected Enquiries' WHERE ID = 998;
UPDATE tbmenu SET menuname = 'Pending / In Progress / Rejected Enquiries' WHERE ID = 1001;

INSERT INTO definepages (modulename, filename, dspname, activeStatus, package, reportname, productpageID, moduleid, submoduleid) VALUES ('Transactions', 'Payment Receipt', 'Payment Receipt', '', null, null, null, 2, null);               
UPDATE tbmenu SET parentid = 169 WHERE ID = 757;

alter table tbmaterialRequisitiondtl add column fromInventorylocation varchar(100) DEFAULT NULL;
alter table tbmaterialRequisitiondtl add column fromInventorylocationID int(10) DEFAULT NULL;
ALTER TABLE tbmaterialRequisitionhdr modify column requisitionNo varchar(100) DEFAULT null;

alter table tbmaterialRequisitiondtl add column complete char(1) default 'N';

--INSERT INTO tbcustomermoduleflag (moduleflag, moduleflagName, status, moduleId, userID, dateTime, activeStatus, maxvalues, type, subModuleId, productsubmoduleflagID, customervalue) VALUES ('INVFlag', 'Inventory Integration', null, 1, 1, '2021-12-30 11:32:06', 'Y', null, 'C', 1, null, 'N');

alter table tbteammaster add column issueInvlocation varchar(100) DEFAULT NULL;
alter table tbteammaster add column issueInvlocationid int(10) DEFAULT NULL;

alter table tbteammaster add column supplyInvlocation varchar(100) DEFAULT NULL;
alter table tbteammaster add column supplyInvlocationid int(10) DEFAULT NULL;


-----------Queries For Good Receipt Note Form---------------	

UPDATE tbmenu SET menuname = 'Goods Receipt Note', menupagename = 'Goods Receipt Note' WHERE ID = 67;
UPDATE tbmenu SET menuname = 'Goods Receipt Note', menupagename = 'Goods Receipt Note' WHERE ID = 158;
UPDATE tbmenu SET menuname = 'Goods Receipt Note', menupagename = 'Goods Receipt Note' WHERE ID = 244;
UPDATE tbmenu SET menuname = 'Goods Receipt Note', menupagename = 'Goods Receipt Note' WHERE ID = 330;
UPDATE tbmenu SET menuname = 'Goods Receipt Note', menupagename = 'Goods Receipt Note' WHERE ID = 496;
UPDATE tbmenu SET menuname = 'Goods Receipt Note', menupagename = 'Goods Receipt Note' WHERE ID = 624;
UPDATE tbmenu SET menuname = 'Goods Receipt Note', menupagename = 'Goods Receipt Note' WHERE ID = 1071;

INSERT INTO definepages(ID, modulename, filename, dspname, activeStatus, package, reportname, productpageID, moduleid, submoduleid) VALUES (85, 'Masters', 'ReassignEnquiry', 'Reassign Enquiry', 'Y', null, null, null, 1, null);
INSERT INTO tbmenu(ID, sequence, parentid, issubmenu, submenulimit, menuname, menupagename, package, resourcegroupid, userid, groupmenuid, landpage, activeStatus, pageId) VALUES (889, 6, 100, 'N', null, 'Reassign Enquiry', 'Reassign Enquiry', null, null, 1, null, 'N', 'Y', 85);


alter table tbschemeconfigDtl add column prefix varchar(50) DEFAULT NULL;

--alter table tbdealercontact add column resourceid int(10) DEFAULT null;
alter table tbresource add column dealerContactid int(10) DEFAULT null;

drop TABLE tbinvgstdtl;

CREATE TABLE tbinvgstdtl (
	id int(10) NOT NULL auto_increment,
	invHdrId int(10) DEFAULT null,
	invNo varchar(100) DEFAULT null,
	invDate date DEFAULT null,
	gstgroupid int(10) default null,
	gstGroupPer decimal(10,2) default null, 
	gstGroupvalue decimal(10,2) default null,
	gsteleId int(10) default null,
	elementPer decimal(10,2) default null,
	eleValue decimal(10,2) default null,
	dateTime datetime DEFAULT null,
	userid int(10) default null,
	activeStatus char(1) DEFAULT 'Y',
	PRIMARY KEY (id)
);

alter table tbservicecallentry modify column address varchar(200) DEFAULT NULL;
alter table tbaccount add column paymentType varchar(20) Default null;
alter table tbdealerPurchaesOrderdtl add column ratewithdiscount decimal(10,2) DEFAULT NULL;
alter table tbdealerPurchaesOrderdtl add column listprice decimal(10,2) DEFAULT NULL;

alter table tbteammaster add column storekeeperid int(10) DEFAULT NULL;
alter table tbteammaster add column storekeepername varchar(500) DEFAULT NULL;
alter table tbaccount add column deliverylocid int(10) DEFAULT NULL;

alter table tbdealerPurchaesOrderhdr modify column address varchar(200) DEFAULT NULL;

alter table tbinventorylocation add column storekeeperid int(10) DEFAULT NULL;
alter table tbinventorylocation add column storekeepername varchar(500) DEFAULT NULL;
alter table tbinventorylocationdtls  drop column storekeeperid ;
alter table tbinventorylocationdtls  drop column storekeepername;
ALTER TABLE tbpodtl modify column  receivedqnty decimal(10,2) DEFAULT 0.00;
------------------------add deciml mrp delear-----------
alter table tbdealersproduct Modify column mrp  Decimal(10,2) DEFAULT NULL;
update tbdealersproduct set mrp ='156.25' where mrp='156.00';
alter table tbteammaster add column orderAccept char(1) default 'N';


