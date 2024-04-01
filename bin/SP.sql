######GET Menu List
DELIMITER //
CREATE  PROCEDURE getMenuTree(IN p_id  VARCHAR(100))
BEGIN
select   *
from    (select * from tbmenu
         order by parentid, id) json_sorted,
        (select @pv := p_id) initialisation
where   find_in_set(parentid, @pv)  
and     length(@pv := concat(@pv, ',', id));

END//


//RESOURCE LOCATIONS BY RESOURCE ID

DELIMITER //
CREATE  PROCEDURE findLocationsByResource(IN resource int(11))
BEGIN
SELECT * FROM tbresourcelocationrights WHERE activeStatus='Y' and  assignBy= resourceLocationRightsID;
END//

//FIND LOCALES BY AREA ID

DELIMITER //
CREATE  PROCEDURE findLocalesByArea(IN area int(11))
BEGIN
SELECT * FROM tblocale WHERE activeStatus='Y' and  areaID=area;
END//


//FIND LOCATIONS BY RESOURCE AND LOCALE

DELIMITER //
CREATE  PROCEDURE findbyresourceandlocaleid(IN resource int(11), IN locale int(11))
BEGIN
SELECT * FROM tbresourcelocationrights WHERE activeStatus='Y' and assignBy=resource and  localeID=locale ;
END//


//FIND PRODUCT CATEGORY BY RESOURCE

DELIMITER //
CREATE  PROCEDURE findprocatbyresorce(IN resource int(11))
BEGIN
SELECT * FROM tbresourceproductcategoryright WHERE activeStatus='Y' and assignBy=resource;
END//


FIND By product categoy and resource id

DELIMITER //
CREATE  PROCEDURE findbyprocatandresorce(IN resource int(11), IN catid int(11))
BEGIN
SELECT * FROM tbresourceproductcategoryright WHERE  assignBy=resource and productCategoryID=catid;
END//


//find teamarea by teamid

DELIMITER //
CREATE  PROCEDURE findTeamareaByTeamid(IN teamid int(11))
BEGIN
SELECT * FROM tbteamarea WHERE  teamMasterID=teamid and activeStatus='Y';
END//


--------//find area by region id

DELIMITER //
CREATE  PROCEDURE findByregionid(IN regid int(11))
BEGIN
SELECT * FROM tbarea WHERE  regionID=regid and activeStatus='Y';
END//


//find product category by team id

DELIMITER //
CREATE  PROCEDURE findPCbyTeamid(IN teamid int(11))
BEGIN
SELECT * FROM tbteamproductcategory WHERE  teamMasterID=teamid and activeStatus='Y';
END//


//find members of team

DELIMITER //
CREATE  PROCEDURE findmemberbyTeamid(IN teamid int(11))
BEGIN
SELECT * FROM tbteammember WHERE  teamMasterID=teamid and activeStatus='Y';
END//

//Locale id by areaids

DELIMITER //
CREATE  PROCEDURE findLocalesByAreaids(IN areaids varchar(500))
BEGIN
SELECT localeID FROM tblocale WHERE activeStatus='Y' and FIND_IN_SET(areaID, areaids);
END//


//Resources by localeids

DELIMITER //
CREATE  PROCEDURE findResourcesByLocales(IN locals varchar(500))
BEGIN
SELECT assignBy FROM tbresourcelocationrights WHERE activeStatus='Y' and FIND_IN_SET(localeID, locals) group by assignBy;
END//


//Find resources by product category

DELIMITER //
CREATE  PROCEDURE findResourcesByProductcate(IN procat varchar(500))
BEGIN
SELECT assignBy FROM tbresourceproductcategoryright WHERE activeStatus='Y' and FIND_IN_SET(productCategoryID, procat) group by assignBy;
END//


//Get resources by customer types

DELIMITER //
CREATE  PROCEDURE findResourcesByType(IN ty varchar(500))
BEGIN
SELECT resourceid FROM tbresourcecustomertype WHERE activeStatus='Y' and FIND_IN_SET(typeid, ty);
END//


//Get types by resources

DELIMITER //
CREATE  PROCEDURE findTypesByResources(IN res varchar(500))
BEGIN
SELECT * FROM tbresourcecustomertype WHERE activeStatus='Y' and FIND_IN_SET(resourceid, res);
END//

----------//get teams by resource 

DELIMITER //
CREATE  PROCEDURE findTeamsByresource(IN uid int(10))
BEGIN
SELECT * FROM tbteammember WHERE activeStatus='Y' and userID=uid order by hierarchy desc;
END//


---------//get members of teams by resource

DELIMITER //
CREATE PROCEDURE findbyteamandhierarchy(IN tbteammaster int(10), IN hierar int(10), IN tbresource int(10))
BEGIN
 SELECT * FROM tbteammember WHERE teamMasterID=tbteammaster and  activeStatus='Y' and hierarchy > hierar or userID=tbresource;
END//


--------------------------get opportunities by resources***************

DELIMITER //
CREATE PROCEDURE findOpportunityByresources(IN res varchar(1000))
BEGIN 
select pros.prospectOpportunityID,pros.prospectOpportunityName,pipe.stageCode,acc.name,reso.Name as re,loclty.localityName as loc,city.name as city,pros.statusFlag,pros.startDate from tbprospectopportunity pros
left join tbpipeline pipe on pipe.stageID = pros.stageID
left join tbusertask usrtask on usrtask.prospectOpportunityID = pros.prospectOpportunityID
left join tbaccount acc on acc.accountID = pros.accountID
left join tbresource reso on reso.resourceID = pros.userID
left join tblocality loclty on loclty.localityID = acc.localityid
left join tbcity city on city.id = loclty.city
where FIND_IN_SET(pros.assignedBy, res) and pros.activeStatus = 'Y' and pipe.funnel='Y' group by pros.prospectOpportunityID order by pros.prospectOpportunityID desc;
END//
--get opportunities by resources


--get opportunities by resources///
--

--DELIMITER //
--CREATE PROCEDURE findOpportunityByresources(IN res varchar(1000))
--BEGIN 
--select pros.prospectOpportunityID,pros.prospectOpportunityName,pipe.stageCode,acc.name,reso.Name as re,loclty.localityName as loc,city.name as city,pros.statusFlag from tbprospectopportunity pros
--left join tbpipeline pipe on pipe.stageID = pros.stageID
--left join tbaccount acc on acc.accountID = pros.accountID
--left join tbresource reso on reso.resourceID = pros.userID
--left join tblocality loclty on loclty.localityID = acc.localityid
--left join tbcity city on city.id = loclty.city
--where FIND_IN_SET(pros.userID, res) and pros.activeStatus = 'Y' and pipe.funnel='Y' group by pros.prospectOpportunityID;
--END//

--//Find All Activities
--
--DELIMITER //
--CREATE  PROCEDURE findActivities()
--BEGIN
--select task.taskID,pipe.stageID,pipe.stageCode,task.taskName,pdtl.actionflag from tbpipelinedtl pdtl
--left join tbpipeline pipe on pipe.stageID=pdtl.stageID
--left join tbtask task on task.taskID = pdtl.taskID
--where pipe.activeStatus='Y' and pdtl.activeStatus='Y' order by task.hierarchy;
--END//


// Pincode like 
DELIMITER //
CREATE  PROCEDURE findbyPincode(IN code VARCHAR(100))
BEGIN
      SELECT * FROM tblocality WHERE activeStatus='Y' and pincode like CONCAT('%',code,'%');
END//

///Product Like 
DELIMITER //
CREATE  PROCEDURE findbyproductCode(IN code VARCHAR(100))
BEGIN
      SELECT * FROM tbproduct WHERE activeStatus='Y' and productCode like CONCAT('%',code,'%');
END//


DELIMITER //
CREATE  PROCEDURE findByresourceidAndteamidandcatecory(IN resource int(11), IN team int(11), IN financialyear int(11),IN categoris int(11))
BEGIN
SELECT * FROM tbresourcetarget WHERE activeStatus='Y' and resourceid=resource and  teamid=team and financialyearid=financialyear and productCategoryID=categoris;
END//

/// Product Categories

DELIMITER //
CREATE  PROCEDURE findbycategories(IN messagString VARCHAR(100))
BEGIN
      SELECT * FROM tbproductcategory WHERE activeStatus='Y' and name like CONCAT('%',messagString,'%');
END//


DELIMITER //
CREATE PROCEDURE findBySearchkeyword (IN searchstring VARCHAR(100))
BEGIN
SELECT * FROM tbaccount WHERE activeStatus='Y' and searchkeyword like CONCAT('%',searchstring,'%');
END//


////get all Service Call***********

--DELIMITER //
--CREATE  PROCEDURE findServiceCallByresources(IN res varchar(1000))
--BEGIN
--select tbservice.serviceCallID,tbservice.serviceCallNo,acc.name,reso.Name as resource,tbservice.callCommitDate,tbservice.callStatus,acc.accountID  from tbservicecallentry tbservice
--left join tbaccount acc on acc.accountID = tbservice.accountID
--left join tbresource reso on reso.resourceID = tbservice.assignedBy
--left join tbproduct prod on prod.productID=tbservice.productID
--where FIND_IN_SET(tbservice.assignedBy, res) and tbservice.activeStatus='Y' order by tbservice.serviceCallNo desc;
--END//


######Number 
DELIMITER //
CREATE  PROCEDURE updatenumber(IN prifix VARCHAR(100))
BEGIN
 UPDATE tbenquiryname
SET bsrno = bsrno+1
WHERE activeStatus='Y' and document=prifix;
SELECT bsrno FROM tbenquiryname WHERE ActiveStatus='Y' and document=prifix limit 1;
END//


///Product Like By PC
DELIMITER //
CREATE  PROCEDURE findbyproductCodeAndTbproductcategory(IN code VARCHAR(100), IN prodcateogryId int(11))
BEGIN
      SELECT * FROM tbproduct WHERE activeStatus='Y' and productCode like CONCAT('%',code,'%') and productCategoryID=prodcateogryId;
END//

-----------//GET Order for dispatch

DELIMITER //
CREATE  PROCEDURE findallAcceptedOrders()
BEGIN
select MAX(hdr.orderaccehdrID),MAX(hdr.orderNo),MAX(hdr.orderDate),MAX(acc.name),MAX(ctype.type),MAX(dtl.ordercomplete),MAX(hdr.accountID) from tborderacceptancehdr hdr 
left join tbaccount acc on acc.accountID=hdr.accountID
left join tbcustomertypeworkflow wrkflow on wrkflow.customertypeid = acc.customertypeid
left join tbcustomertype ctype on ctype.id = acc.customertypeid
left join tborderacceptancedtl dtl on dtl.orderaccehdrID = hdr.orderaccehdrID
where hdr.orderApprove='A' and hdr.activeStatus='Y' group by hdr.orderaccehdrID order by hdr.dateTime desc ;
END//



////Get installationlst
--DELIMITER //
--CREATE  PROCEDURE findallinstallation()
--BEGIN
--SELECT * FROM tborderacceptancehdr hdr WHERE activeStatus='Y' and installationflag='Y' order by hdr.orderaccehdrID desc;
--END //


/////// Service charges template

DELIMITER //
CREATE PROCEDURE findAllproduct()
BEGIN
SELECT MAX(sp.id),MAX(sp.prodCatID),MAX(sp.prodCatname),MAX(sp.productID) FROM tbspare sp WHERE sp.activeStatus='Y' GROUP BY sp.productID ;
END//

----------------//find Assigned By Id By Quotation id
DELIMITER //
CREATE  PROCEDURE findAssignedIdByQuotationid(IN quoid int(10))
BEGIN
select pros.assignedBy from tbprospectopportunity pros
left join tbquotation quo on quo.prospectOpportunityID = pros.prospectOpportunityID
where quo.quotationID=quoid;
END//


////Get Sum
DELIMITER //
CREATE  PROCEDURE gettotal(IN  marketingcostId int(10))
BEGIN
SELECT max(percentage) from tbcostheadpertemplate 
WHERE marketingcostid != 0 and activeStatus='Y'
Group by costhead;
END//


/////////////Item category And Itemsub category Ad item Name////////
DELIMITER //
CREATE  PROCEDURE findbyitemcatAnditemname(IN itemcaid int(10), IN trnid int(10), IN message varchar(50))
BEGIN
SELECT * FROM tbproduct WHERE activeStatus='Y' and itemcategoryid=itemcaid and itemname like CONCAT('%',message,'%')  and itemsubcategoryID=trnid;
END//



//////like copy item master
DELIMITER //
CREATE PROCEDURE findbyitemname(IN message varchar(50))
BEGIN
SELECT * FROM tbproduct WHERE activeStatus='Y' and itemname like CONCAT('%',message,'%');
END//

//////get installation By resource 
DELIMITER //
CREATE  PROCEDURE getinstallation(IN userid int(10))
BEGIN
SELECT * FROM tbinstallationresource WHERE activeStatus='Y' and resourceID=userid group by tbinstallations;
END//


//Get Dealers by locality
DELIMITER //
CREATE  PROCEDURE findBylocalityid(IN locltyid int(10))
BEGIN
select dtls.dealersdtlId,dtls.name from tbdealersgeography geo
left join tbdealersdetails dtls on dtls.dealersdtlId=geo.dealersId
where geo.localityid=locltyid and dtls.activeStatus='Y' and geo.activeStatus='Y';
END//


/////// Current Lead by account and product

 DELIMITER //
CREATE  PROCEDURE findCurrentLeadbyaccountandproduct(IN accid int(11),IN locid int(11),IN proID varchar(100),IN productCatID varchar(100))
BEGIN
IF proID!=null then
select pros.prospectOpportunityName from tbprospectopportunity pros
 join tbprosoppproductcategory tbc on pros.prospectOpportunityID=tbc.prospectOpportunityID
 where pros.accountID=accid and FIND_IN_SET(tbc.productID, proID) and pros.localityID=locid  and pros.activeStatus='Y' and pros.statusFlag='Y';
 ELSE
 select pros.prospectOpportunityName from tbprospectopportunity pros
 join tbprosoppproductcategory tbc on pros.prospectOpportunityID=tbc.prospectOpportunityID
 where pros.accountID=accid and FIND_IN_SET(tbc.productCategoryID, productCatID) and pros.localityID=locid and pros.activeStatus='Y' and pros.statusFlag='Y';
 
 END IF;

END//

/////////////Overdue Activity

DELIMITER //
CREATE  PROCEDURE findbyduedateAndassignByAndStatus(IN duedate date,  IN tbassignBy int(10), IN Y char(1))
BEGIN
SELECT * FROM tbusertask WHERE dueDate= duedate  and assignedBy=tbassignBy and openCloseStatus = 'Y'
Order By tbusertask.dueDate desc;
END//



//////////// Activity next 30 days


DELIMITER //
CREATE  PROCEDURE findbyduedateandTbassignBy(IN duedate date,IN tbassignBy int(10), IN Y char(1))
BEGIN
SELECT * FROM tbusertask WHERE dueDate= duedate and assignedBy=tbassignBy and openCloseStatus = 'Y'
Order By tbusertask.dueDate desc;
END//

///////////

////////////Approved Overdue Activitise

DELIMITER //
CREATE  PROCEDURE findByapproveflagandappresouceId(IN approveResourceid int(10), IN N char(1), IN date date)
BEGIN
SELECT * FROM tbquotation WHERE activeStatus='Y'and approvalresourceid=approveResourceid and appovedflag = 'N' and startDate=date
Order By tbquotation.startDate desc;
END//

/////////

//////////////////////// Invoice date

DELIMITER //
CREATE  PROCEDURE findByDealerid(IN id int(10))
BEGIN
SELECT * FROM tborderinvoicehdr WHERE activeStatus='Y'and dealerid=id and unPaidAmount > 0
Order By tborderinvoicehdr.invoiceDate desc;
END//



////Get all Payment Receipts
DELIMITER //
CREATE  PROCEDURE getAllPaymentReceipt()
BEGIN
 select * from tbpaymentreceipthdr where activeStatus='Y' order by id desc;
END//


//Get Customers For Payment receipt


DELIMITER //
CREATE  PROCEDURE findCustomerForPayment(IN messagString VARCHAR(100))
BEGIN
select * from tbaccount where name like CONCAT('%',messagString,'%') and activeStatus='Y';
END//


////Vendor name

DELIMITER //
CREATE PROCEDURE findByVendorName(IN vendor VARCHAR(100))
BEGIN
      SELECT * FROM tbaccount WHERE activeStatus='Y' and vendorflag = 'Y' and name like CONCAT('%',vendor,'%');
END//


///////get item name

DELIMITER //
CREATE  PROCEDURE findbyitemnameAndTbproductcategory(IN itemName VARCHAR(100), IN productcategoryId int(11))
BEGIN
      SELECT * FROM tbproduct WHERE activeStatus='Y' and itemname like CONCAT('%',itemName,'%') and productCategoryID=productcategoryId;
END//


///////Get all conversion template
DELIMITER //
CREATE  PROCEDURE findconversiontemplateall()
BEGIN
SELECT MAX(id),MAX(shortname),MAX(formulaname) FROM tbConversionTemplate WHERE activeStatus='Y' group by shortname;
END//



//Get INVOICES Of Party

DELIMITER //
CREATE  PROCEDURE findInvoiceByParty(IN trnid int(10))
BEGIN
 	select * from tborderinvoicehdr where accountID=trnid and unPaidAmount > 0 and activeStatus='Y';
END//







*****DEALER PO TO OA

DELIMITER //
CREATE PROCEDURE findPendingDealerPO()
BEGIN
select MAX(phdr.dealerpurhdrid),MAX(phdr.purchaseOrderno),MAX(phdr.datetime),MAX(phdr.total),MAX(acc.name),MAX(ctype.type),MAX(phdr.approvedorderflg) from tbdealerPurchaesOrderhdr phdr 
left join tbaccount acc on acc.accountID = phdr.accountId
left join tbdealerPurchaesOrderdtl pdtl on pdtl.dealerpurhdrid = phdr.dealerpurhdrid 
left join tbcustomertypeworkflow wrk on wrk.customertypeid=acc.customertypeid
left join tbcustomertype ctype on ctype.id = wrk.customertypeid
where phdr.activeStatus='Y' and pdtl.activeStatus='Y' and acc.activeStatus='Y' group by phdr.dealerpurhdrid;
END//


//Suppliers

DELIMITER //
CREATE  PROCEDURE findSupplierLike(IN message varchar(30), IN trnid int(10))
BEGIN
 	select * from tbaccount where name like CONCAT('%',message,'%') and dealerflag="N" and activeStatus='Y' and customertypeid=trnid; 
END//



//Find PO Suppliers

DELIMITER //
CREATE  PROCEDURE findPOSuppliersLike(IN messagString VARCHAR(100), IN posta VARCHAR(20))
BEGIN
select * from tbpohdr where postatus=posta and suppliername like CONCAT('%',messagString,'%') and activeStatus='Y';
END//



//Find customer like

DELIMITER //
CREATE  PROCEDURE findByCustomername(IN customer VARCHAR(100))
BEGIN
      SELECT * FROM tbaccount WHERE activeStatus='Y' and name like CONCAT('%',customer,'%');
END//


//Inventory Locations by subcategory id

DELIMITER //
CREATE  PROCEDURE findInventoryLocationsBySubcatid(IN subcat varchar(1000))
BEGIN
select loc.id,loc.locationname from tbinventorylocationdtls invdtls
left join tbinventorylocation loc on loc.id = invdtls.inventorylocationid
where FIND_IN_SET(invdtls.itemsubcategoryid, subcat) and invdtls.activeStatus='Y' and loc.activeStatus = 'Y';
END//


//GET ALL GRNs

DELIMITER //
CREATE  PROCEDURE getAllGrns()
BEGIN
select * from tbgrn where activeStatus='Y' group by grnno order by createdDate desc;
END//



//GET PURCHASE RETURN AND SALES RETURNS

DELIMITER //
CREATE  PROCEDURE findbyTransactionreferance(IN message VARCHAR(100))
BEGIN
      SELECT * FROM tbstocktransaction where referance=message and activeStatus='Y' group by documentNo order by id desc;
END//

//Supplier Like for Return

DELIMITER //
CREATE  PROCEDURE findBySupplierlikeForReturn(IN message VARCHAR(100), IN type VARCHAR(100))
BEGIN
      SELECT * FROM tbstocktransaction where  partyname like CONCAT('%',message,'%') and documentType=type group by documentNo;
END//


//Supplier wise gin

DELIMITER //
CREATE  PROCEDURE getAllItemsOfSupplier(IN trnid int(10), IN type varchar(50))
BEGIN
      SELECT * FROM tbstocktransaction where partyid=trnid and documentType=type  order by datetime desc;
END//



///////Get Resource Name

DELIMITER //
CREATE  PROCEDURE findByResourcename(IN resource VARCHAR(100))
BEGIN
      SELECT * FROM tbresource WHERE activeStatus='Y' and name like CONCAT('%',resource,'%');
END//

//////AllitemName

DELIMITER //
CREATE  PROCEDURE findbyallitemname(IN message varchar(50))
BEGIN
SELECT * FROM tbproduct WHERE activeStatus='Y' and itemname like CONCAT('%',message,'%');
END//


//GetAllLocalities

DELIMITER //
CREATE PROCEDURE getAlllocalities(IN offset int(50),IN row_count int(50))
BEGIN
select loc.localityID,loc.localityName,loc.pincode,cy.name from tblocality loc 
left join tbcity cy on cy.id=loc.city
where loc.activeStatus='Y' and cy.activeStatus = 'Y' LIMIT offset,row_count;
END//


--//Localities By city Search  

DELIMITER //
CREATE PROCEDURE getLocalityByCityLike(IN sendstring VARCHAR(100),IN offset int(50),IN row_count int(50))
BEGIN
select loc.localityID,loc.localityName,loc.pincode,cy.name from tblocality loc 
left join tbcity cy on cy.id=loc.city
where loc.activeStatus='Y' and cy.name like CONCAT('%',sendstring,'%') LIMIT offset,row_count;
END//

--//Localities By Pincode OR Locality Search  
DELIMITER //
CREATE PROCEDURE getLocalityByTypeLike(IN sendstring VARCHAR(100),IN message VARCHAR(100),IN offset int(50),IN row_count int(50))
BEGIN
IF message='Locality' then
select loc.localityID,loc.localityName,loc.pincode,cy.name from tblocality loc 
left join tbcity cy on cy.id=loc.city
where loc.activeStatus='Y' and  loc.localityName like CONCAT('%',sendstring,'%') LIMIT offset,row_count;
ELSE
select loc.localityID,loc.localityName,loc.pincode,cy.name from tblocality loc 
left join tbcity cy on cy.id=loc.city
where loc.activeStatus='Y' and  loc.pincode like CONCAT('%',sendstring,'%') LIMIT offset,row_count;
END IF;
END//

--//Find All Activities By customer type
--distinct removed orderby add
DELIMITER //
CREATE  PROCEDURE findallActivitesbyCustType(IN customerType int(20))
select task.taskID,pipe.stageID,pipe.stageCode,task.taskName,pdtl.actionflag from 
tbpipelinedtl pdtl
left join tbpipeline pipe on pipe.stageID=pdtl.stageID
left join tbtask task on task.taskID = pdtl.taskID 
INNER JOIN tbactivitydtl actdtl on task.taskID = actdtl.tbtaskId
where pipe.activeStatus='Y' and pdtl.activeStatus='Y' and actdtl.activeStatus = 'Y' 
and actdtl.customertypeid = customerType order by task.hierarchy;
END//



--DELIMITER //   
--CREATE PROCEDURE findOpportunityByresources(IN res varchar(1000))
--BEGIN 
--select pros.prospectOpportunityID,pros.prospectOpportunityName,pros.dateTime,pipe.stageCode,acc.name,reso.Name as re,loclty.localityName as loc,city.name as city,pros.statusFlag,pros.accountID from tbprospectopportunity pros
--left join tbpipeline pipe on pipe.stageID = pros.stageID
--left join tbaccount acc on acc.accountID = pros.accountID
--left join tbresource reso on reso.resourceID = pros.userID
--left join tblocality loclty on loclty.localityID = acc.localityid
--left join tbcity city on city.id = loclty.city
--where FIND_IN_SET(pros.userID, res) and pros.activeStatus = 'Y' and pipe.funnel='Y' group by pros.prospectOpportunityID order by pros.prospectOpportunityID desc;
--END//

DELIMITER //
CREATE  PROCEDURE findSpareItemName(IN code VARCHAR(1000), IN prodcateogryId int(11))
BEGIN
SELECT tbpord.* FROM tbproduct tbpord
left join tbitemSubCategory isub on isub.id = tbpord.itemsubcategoryID
WHERE tbpord.activeStatus ='Y' and itemname like CONCAT('%',code,'%') and tbpord.itemsubcategoryID=prodcateogryId;
END//

--DELIMITER //
--CREATE  PROCEDURE findCityByAreaid(IN areaid int(11))
--BEGIN
--SELECT ct.id,ct.name FROM tblocale loc
-- left join tbcity ct on ct.id = loc.city
--WHERE loc.activeStatus='Y' and ct.activeStatus = 'Y' and FIND_IN_SET(loc.areaID,areaid);
--END//

DELIMITER //
CREATE  PROCEDURE getLocaleAndPincodeByCity(IN cityid varchar(11))
BEGIN
select distinct localeid,localeName,pincode from tblocality 
where activeStatus='Y' and city = cityid order by localeName asc;
END//

DELIMITER //  
CREATE PROCEDURE getteammembersales(IN pincode varchar(11),IN hierarchy varchar(11))
BEGIN
select tbteammaster.teamCode,tbresource.resourceID,tbresource.Name,tbteammaster.teamMasterID from tbteammaster  as tbteammaster
inner join tbteammember as tbteammember on tbteammaster.teamMasterID =tbteammember.teamMasterID
inner join tbteamarea as tbteamarea   on tbteamarea.teamMasterID =tbteammember.teamMasterID
inner join tbresource as tbresource on tbresource.resourceID = tbteammember.userID
where tbteammaster.sales = 'Y' and tbteammaster.activeStatus = 'Y' and tbteammember.activeStatus = 'Y' 
and tbteamarea.activeStatus = 'Y' and tbresource.activeStatus ='Y' 
and tbresource.activeInactive = 'Y' and tbteamarea.pincode = pincode and tbteammember.hierarchy > hierarchy;
END//

DELIMITER //  
CREATE PROCEDURE getteammemberservice(IN pincode varchar(11),IN hierarchy varchar(11))
BEGIN
select tbteammaster.teamCode,tbresource.resourceID,tbresource.Name,tbteammaster.teamMasterID from tbteammaster  as tbteammaster
inner join tbteammember as tbteammember on tbteammaster.teamMasterID =tbteammember.teamMasterID
inner join tbteamarea as tbteamarea   on tbteamarea.teamMasterID =tbteammember.teamMasterID
inner join tbresource as tbresource on tbresource.resourceID = tbteammember.userID
where tbteammaster.service = 'Y' and tbteammaster.activeStatus = 'Y' and tbteammember.activeStatus = 'Y' 
and tbteamarea.activeStatus = 'Y' and tbteamarea.pincode = pincode and tbresource.activeStatus ='Y' 
and tbresource.activeInactive = 'Y' and tbteammember.hierarchy > hierarchy order by tbteammember.hierarchy asc;
END//


DELIMITER //  
CREATE PROCEDURE getpincode(IN locale int(11))
BEGIN
select distinct pincode from tblocality 
where activeStatus='Y' and localeid = locale LIMIT 1;
END//

DELIMITER //  
CREATE PROCEDURE getteammemberinstallation(IN pincode varchar(11),IN hierarchy varchar(11))
BEGIN
select distinct tbteammaster.teamCode,tbresource.resourceID,tbresource.Name,tbteammaster.teamMasterID from tbteammaster  as tbteammaster
inner join tbteammember as tbteammember on tbteammaster.teamMasterID =tbteammember.teamMasterID
inner join tbteamarea as tbteamarea   on tbteamarea.teamMasterID =tbteammember.teamMasterID
inner join tbresource as tbresource on tbresource.resourceID = tbteammember.userID
where tbteammaster.installation = 'Y' and tbteammaster.activeStatus = 'Y' and tbteammember.activeStatus = 'Y' 
and tbteamarea.activeStatus = 'Y' and tbteamarea.pincode = pincode and tbresource.activeStatus ='Y' 
and tbresource.activeInactive = 'Y' and tbteammember.hierarchy > hierarchy;
END//

DELIMITER //  
CREATE PROCEDURE getteamhierarchy(IN pincode varchar(11),IN userID varchar(11))
BEGIN
select hierarchy from tbteammember  as tbteammember
inner join tbteamarea as tbteamarea   on tbteamarea.teamMasterID =tbteammember.teamMasterID
where tbteamarea.pincode = pincode and tbteammember.userID = userID and tbteamarea.activeStatus = 'Y' 
and tbteammember.activeStatus = 'Y';
END//


DELIMITER //
CREATE PROCEDURE findBySearchkeyword (IN searchstring VARCHAR(100))
BEGIN
SELECT * FROM tbaccount WHERE activeStatus='Y'and dealerflag='N' and vendorflag='N' and searchkeyword like CONCAT('%',searchstring,'%');
END//

----findallActivitesbyCustType
---------findallinstallation

DELIMITER //   
CREATE PROCEDURE findSupervisorAuth()
BEGIN 
select min(hierarchy) from tbteammember tbmem
left join tbteammaster tbmas on tbmas.teamMasterID = tbmem.teamMasterID
where tbmem.activeStatus = 'Y' and tbmas.activeStatus = 'Y' and assigntoflag = 'Y';
END//

DELIMITER //
CREATE PROCEDURE getteamhierarchyByinstallation(IN pincode varchar(11),IN userID varchar(11))
BEGIN
select hierarchy from tbteammember  as tbteammember
inner join tbteamarea as tbteamarea  on tbteamarea.teamMasterID =tbteammember.teamMasterID
inner join tbteammaster as tbteammaster on tbteammaster.teamMasterID = tbteammember.teamMasterID
where tbteamarea.pincode = pincode and tbteammember.userID = userID and tbteamarea.activeStatus = 'Y' 
and tbteammember.activeStatus = 'Y' and tbteammaster.activeStatus = 'Y' and tbteammaster.installation = 'Y';
END//

DELIMITER //
CREATE PROCEDURE findByTop10 ()
BEGIN
SELECT  * FROM tbaccount WHERE  activeStatus='Y' 
and dealerflag='N' and vendorflag='N' order by lastModifiedDate desc LIMIT 10;
END//

----getteammemberservice
--findSpareItemName
--findServiceCallByresources

--DELIMITER //   
--CREATE PROCEDURE findOpportunityByresources(IN res varchar(1000))
--BEGIN 
--select pros.prospectOpportunityID,pros.prospectOpportunityName,pros.dateTime,pipe.stageCode,acc.name,reso.Name as re,loclty.localityName as loc,city.name as city,pros.statusFlag,pros.accountID,acc.telephone1 from tbprospectopportunity pros
--left join tbpipeline pipe on pipe.stageID = pros.stageID
--left join tbaccount acc on acc.accountID = pros.accountID
--left join tbresource reso on reso.resourceID = pros.userID
--left join tblocality loclty on loclty.localityID = pros.localityid
--left join tbcity city on city.id = loclty.city
--where FIND_IN_SET(pros.userID, res) and pros.activeStatus = 'Y' and pipe.funnel='Y' group by pros.prospectOpportunityID order by pros.prospectOpportunityID desc;
--END//


--IN offset int(50),IN row_count int(50)
DELIMITER //
CREATE  PROCEDURE findallinstallation(IN res varchar(1000),IN offset int(50),IN row_count int(50))
BEGIN
SELECT * FROM tborderacceptancehdr hdr
WHERE  FIND_IN_SET(hdr.userID, res) and hdr.activeStatus='Y' 
and hdr.installationflag='Y' and hdr.installationsID = '1' order by hdr.orderaccehdrID desc LIMIT offset,row_count;
END //

DELIMITER //
CREATE PROCEDURE findallinstallationinInst(IN res varchar(1000),IN offset int(50),IN row_count int(50))
BEGIN
SELECT * FROM tbinstallations inst
left join tborderacceptancehdr hdr on hdr.orderaccehdrID = inst.orderAcceptabceID
WHERE  FIND_IN_SET(inst.ownerID, res) and inst.activeStatus='Y' and hdr.activeStatus='Y'
and hdr.installationflag='Y' and hdr.installationsID > '1' order by hdr.orderaccehdrID desc LIMIT offset,row_count;
END //

----------For Quotation Dashboard--------------
DELIMITER //   
CREATE PROCEDURE findQuotationDashboard(IN res varchar(1000))
BEGIN 
select pros.prospectOpportunityID,pros.prospectOpportunityName,pipe.stageCode,acc.name,reso.Name as re,pros.statusFlag,pros.accountID,quo.quotationCode from tbprospectopportunity pros
left join tbpipeline pipe on pipe.stageID = pros.stageID
left join tbaccount acc on acc.accountID = pros.accountID
left join tbresource reso on reso.resourceID = pros.userID
left join tbquotation quo on quo.prospectOpportunityID = pros.prospectOpportunityID
where FIND_IN_SET(pros.userID, res) and pros.activeStatus = 'Y' and pipe.funnel='Y' order by pros.prospectOpportunityID desc;
END//

----------Updated Dispatch orders stored procedure----------
DELIMITER //
CREATE PROCEDURE findallAcceptedOrders(IN res varchar(1000), IN offset int(50), IN row_count int(50))
BEGIN
select MAX(hdr.orderaccehdrID),MAX(hdr.orderNo),MAX(hdr.orderDate),MAX(acc.name),MAX(ctype.type),MAX(dtl.ordercomplete),MAX(hdr.accountID) from tborderacceptancehdr hdr 
left join tbaccount acc on acc.accountID=hdr.accountID
left join tbcustomertypeworkflow wrkflow on wrkflow.customertypeid = acc.customertypeid
left join tbcustomertype ctype on ctype.id = acc.customertypeid
left join tborderacceptancedtl dtl on dtl.orderaccehdrID = hdr.orderaccehdrID
where hdr.orderApprove='A' and hdr.activeStatus='Y' and acc.activeStatus = 'Y'
and ctype.activeStatus ='Y' and dtl.activeStatus = 'Y' and wrkflow.activeStatus = 'Y' 
and FIND_IN_SET(hdr.userID, res) group by hdr.orderaccehdrID 
order by hdr.dateTime desc LIMIT offset,row_count;
END//

-----------------For orders Count stored procedures--------------------
DELIMITER //
CREATE PROCEDURE findOrdersCount(IN res varchar(1000))
BEGIN
select count(*) from tborderacceptancehdr hdr 
where FIND_IN_SET(userID, res) and hdr.orderApprove='A' and hdr.activeStatus='Y';
END//

-------------For Dispatch orders Search Stored Procedures-------------

DELIMITER //
CREATE  PROCEDURE getAllCustomerLike(IN sendstring VARCHAR(100))
BEGIN
select MAX(hdr.orderaccehdrID),MAX(hdr.orderNo),MAX(hdr.orderDate),MAX(acc.name),MAX(ctype.type),MAX(dtl.ordercomplete),MAX(hdr.accountID) from tborderacceptancehdr hdr 
left join tbaccount acc on acc.accountID=hdr.accountID
left join tbcustomertypeworkflow wrkflow on wrkflow.customertypeid = acc.customertypeid
left join tbcustomertype ctype on ctype.id = acc.customertypeid
left join tborderacceptancedtl dtl on dtl.orderaccehdrID = hdr.orderaccehdrID
where hdr.orderApprove='A' and hdr.activeStatus='Y' and acc.name like CONCAT('%',sendstring,'%')  group by hdr.orderaccehdrID order by hdr.dateTime desc;
END//

DELIMITER //
CREATE  PROCEDURE getOrdersByTypeSearch(IN sendstring VARCHAR(100),IN message VARCHAR(100),IN offset int(50),IN row_count int(50))
BEGIN
IF message='Customer Type' then
select MAX(hdr.orderaccehdrID),MAX(hdr.orderNo),MAX(hdr.orderDate),MAX(acc.name),MAX(ctype.type),MAX(dtl.ordercomplete),MAX(hdr.accountID) from tborderacceptancehdr hdr 
left join tbaccount acc on acc.accountID=hdr.accountID
left join tbcustomertypeworkflow wrkflow on wrkflow.customertypeid = acc.customertypeid
left join tbcustomertype ctype on ctype.id = acc.customertypeid
left join tborderacceptancedtl dtl on dtl.orderaccehdrID = hdr.orderaccehdrID
where hdr.orderApprove='A' and hdr.activeStatus='Y' and ctype.type like CONCAT('%',sendstring,'%')  group by hdr.orderaccehdrID order by hdr.dateTime desc LIMIT offset,row_count;

ELSE
select MAX(hdr.orderaccehdrID),MAX(hdr.orderNo),MAX(hdr.orderDate),MAX(acc.name),MAX(ctype.type),MAX(dtl.ordercomplete),MAX(hdr.accountID) from tborderacceptancehdr hdr 
left join tbaccount acc on acc.accountID=hdr.accountID
left join tbcustomertypeworkflow wrkflow on wrkflow.customertypeid = acc.customertypeid
left join tbcustomertype ctype on ctype.id = acc.customertypeid
left join tborderacceptancedtl dtl on dtl.orderaccehdrID = hdr.orderaccehdrID
where hdr.orderApprove='A' and hdr.activeStatus='Y' and acc.telephone1 like CONCAT('%',sendstring,'%')  group by hdr.orderaccehdrID order by hdr.dateTime desc LIMIT offset,row_count;
END IF;
END//

-------------Updated strored procedure for order acceptance------------
DELIMITER //
CREATE PROCEDURE findByActiveStatusAndQuoteStatus(IN s2 varchar(1000),IN offset int(50),IN row_count int(50))
BEGIN
SELECT MAX(quo.quotationID),MAX(quo.quotationCode),MAX(quo.startDate),MAX(quo.totalAmount), 
MAX(acc.name),MAX(quo.versionNo),MAX(ctype.type),MAX(quo.appovedflag) FROM tbquotation quo 
left join tbaccount acc on acc.accountID = quo.accountID
left join tbquotationproduct quopro on quopro.quotationID = quo.quotationID
left join tbcustomertypeworkflow wrk on wrk.customertypeid=acc.customertypeid
left join tbcustomertype ctype on ctype.id = wrk.customertypeid
WHERE FIND_IN_SET(acc.customertypeid,s2) and quo.activeStatus='Y' and quo.quoteStatus='W' and quopro.acceptall='N' group by 
quo.quotationID order by quo.quotationID desc LIMIT offset,row_count;
END//

-------------------------Updated DEALER PO TO OA-------------------
--DELIMITER //
--CREATE PROCEDURE findPendingDealerPO(IN offset int(50),IN row_count int(50))
--BEGIN
--select MAX(phdr.dealerpurhdrid),MAX(phdr.purchaseOrderno),MAX(phdr.datetime),MAX(phdr.total),MAX(acc.name),MAX(ctype.type),MAX(phdr.approvedorderflg) from tbdealerPurchaesOrderhdr phdr 
--left join tbaccount acc on acc.accountID = phdr.accountId
--left join tbdealerPurchaesOrderdtl pdtl on pdtl.dealerpurhdrid = phdr.dealerpurhdrid 
--left join tbcustomertypeworkflow wrk on wrk.customertypeid=acc.customertypeid
--left join tbcustomertype ctype on ctype.id = wrk.customertypeid
--where phdr.activeStatus='Y' and pdtl.activeStatus='Y' and acc.activeStatus='Y' group by phdr.dealerpurhdrid LIMIT offset,row_count;
--END//

-------------------Stored procedure for orderacceptance count---------------
DELIMITER //
CREATE  PROCEDURE findOrdersAccepatnceCount()
BEGIN
select count(*) from tbquotation quo 
where quo.activeStatus='Y' and quo.quoteStatus='W';
END//

------------------Stored procedure for DealerOrderCount----------------
DELIMITER //
CREATE  PROCEDURE findDealerOrderCount()
BEGIN
select count(*) from tbdealerPurchaesOrderhdr phdr 
where phdr.activeStatus='Y';
END//

-------------Stored Procedure for searching the records for customers via customer name.--------------
DELIMITER //
CREATE PROCEDURE getAllAcceptCustomerLike(IN sendstring VARCHAR(100))
BEGIN
SELECT MAX(quo.quotationID),MAX(quo.quotationCode),MAX(quo.startDate),MAX(quo.totalAmount),MAX(acc.name),MAX(quo.versionNo),MAX(ctype.type),MAX(quo.appovedflag) FROM tbquotation quo 
left join tbaccount acc on acc.accountID = quo.accountID
left join tbquotationproduct quopro on quopro.quotationID = quo.quotationID
left join tbcustomertypeworkflow wrk on wrk.customertypeid=acc.customertypeid
left join tbcustomertype ctype on ctype.id = wrk.customertypeid
WHERE quo.activeStatus='Y' and quo.quoteStatus='W' and quopro.acceptall='N' and acc.name like CONCAT('%',sendstring,'%') group by quo.quotationID;
END//

-------------Stored Procedure for searching the records for dealer via dealer name.--------------
DELIMITER //
CREATE PROCEDURE getAllAcceptCustomerLikefordealer(IN sendstring VARCHAR(100),IN offset int(50),IN row_count int(50))
BEGIN
select phdr.dealerpurhdrid,phdr.purchaseOrderno,phdr.datetime,phdr.total,acc.name,ctype.type,phdr.approvedorderflg from tbdealerPurchaesOrderhdr phdr 
left join tbaccount acc on acc.accountID = phdr.accountId
left join tbdealerPurchaesOrderdtl pdtl on pdtl.dealerpurhdrid = phdr.dealerpurhdrid 
left join tbcustomertypeworkflow wrk on wrk.customertypeid=acc.customertypeid
left join tbcustomertype ctype on ctype.id = wrk.customertypeid
where phdr.activeStatus='Y' and pdtl.activeStatus='Y' and acc.activeStatus='Y' and acc.name like CONCAT('%',sendstring,'%') LIMIT offset,row_count;
END//

-------------Stored Procedure for searching the records for customers via customer type.--------------
DELIMITER //
CREATE PROCEDURE getAllAcceptCustomerTypeLike(IN sendstring VARCHAR(100),IN message VARCHAR(100),IN offset int(50),IN row_count int(50))
BEGIN
IF message='Customer type' then
SELECT MAX(quo.quotationID),MAX(quo.quotationCode),MAX(quo.startDate),MAX(quo.totalAmount),MAX(acc.name),MAX(quo.versionNo),MAX(ctype.type),MAX(quo.appovedflag) FROM tbquotation quo 
left join tbaccount acc on acc.accountID = quo.accountID
left join tbquotationproduct quopro on quopro.quotationID = quo.quotationID
left join tbcustomertypeworkflow wrk on wrk.customertypeid=acc.customertypeid
left join tbcustomertype ctype on ctype.id = wrk.customertypeid
WHERE quo.activeStatus='Y' and quo.quoteStatus='W' and quopro.acceptall='N' and ctype.type like CONCAT('%',sendstring,'%') group by quo.quotationID LIMIT offset,row_count;
END IF;
END//

-------------Stored Procedure for searching the records for dealer via dealer type.--------------
DELIMITER //
CREATE PROCEDURE getAllAcceptCustomerTypeLikeDealer(IN sendstring VARCHAR(100),IN message VARCHAR(100),IN offset int(50),IN row_count int(50))
BEGIN
IF message='Customer type' then
select MAX(phdr.dealerpurhdrid),MAX(phdr.purchaseOrderno),MAX(phdr.datetime),MAX(phdr.total),MAX(acc.name),MAX(ctype.type),MAX(phdr.approvedorderflg) from tbdealerPurchaesOrderhdr phdr 
left join tbaccount acc on acc.accountID = phdr.accountId
left join tbdealerPurchaesOrderdtl pdtl on pdtl.dealerpurhdrid = phdr.dealerpurhdrid 
left join tbcustomertypeworkflow wrk on wrk.customertypeid=acc.customertypeid
left join tbcustomertype ctype on ctype.id = wrk.customertypeid
where phdr.activeStatus='Y' and pdtl.activeStatus='Y' and acc.activeStatus='Y' and ctype.type like CONCAT('%',sendstring,'%') group by phdr.dealerpurhdrid LIMIT offset,row_count;
END IF;
END//


---------------Stored procedure for Updated Service Call--------------
DELIMITER //
CREATE PROCEDURE findServiceCallByresources(IN res varchar(1000),IN offset int(50),IN row_count int(50))
BEGIN
select tbservice.serviceCallID,tbservice.serviceCallNo,acc.name,reso.Name as resource,tbservice.callCommitDate,tbservice.callStatus,acc.accountID,acc.telephone1,tbservice.dateTime from tbservicecallentry tbservice
left join tbaccount acc on acc.accountID = tbservice.accountID
left join tbresource reso on reso.resourceID = tbservice.assignedBy
left join tbproduct prod on prod.productID=tbservice.productID
where FIND_IN_SET(tbservice.assignedBy, res) and tbservice.activeStatus='Y' order by tbservice.serviceCallID desc LIMIT offset,row_count;
END//

--------------------Stored procedure for service call count----------
DELIMITER //
CREATE PROCEDURE findServiceCallCount()
BEGIN
select count(*) from tbservicecallentry tbservice
where tbservice.activeStatus='Y';
END//

---------------------Service call search stored procedure via customer Name---------------
--DELIMITER //
--CREATE  PROCEDURE getAllServiceCustomerLike(IN res varchar(1000),IN sendstring VARCHAR(100))
--BEGIN
--select tbservice.serviceCallID,tbservice.serviceCallNo,acc.name,reso.Name as resource,tbservice.callCommitDate,tbservice.callStatus,acc.accountID,acc.telephone1  from tbservicecallentry tbservice
--left join tbaccount acc on acc.accountID = tbservice.accountID
--left join tbresource reso on reso.resourceID = tbservice.assignedBy
--left join tbproduct prod on prod.productID=tbservice.productID
--where FIND_IN_SET(tbservice.assignedBy, res) and tbservice.activeStatus='Y' and acc.name like CONCAT('%',sendstring,'%') order by tbservice.serviceCallNo desc;
--END//

DELIMITER //   
CREATE PROCEDURE findOpportunityCount(IN res varchar(1000))
BEGIN 
select count(*) from tbprospectopportunity 
where FIND_IN_SET(userID, res) and activeStatus = 'Y';
END// 

DELIMITER //   
CREATE PROCEDURE findOpportunityByresources(IN res varchar(1000),IN offset int(50),IN row_count int(50))
BEGIN 
select pros.prospectOpportunityID,pros.prospectOpportunityName,pros.dateTime,
pipe.stageCode,acc.name,reso.Name as re,loclty.localityName as loc,city.name as city,
pros.statusFlag,pros.accountID,acc.telephone1,pros.pincode,pros.unitNumber,pros.buildingName,pros.address from tbprospectopportunity pros
left join tbpipeline pipe on pipe.stageID = pros.stageID
left join tbaccount acc on acc.accountID = pros.accountID
left join tbresource reso on reso.resourceID = pros.userID
left join tblocality loclty on loclty.localityID = pros.localityid
left join tbcity city on city.id = loclty.city
where FIND_IN_SET(pros.userID, res) and pros.activeStatus = 'Y' and pipe.funnel='Y'
group by pros.prospectOpportunityID order by pros.prospectOpportunityID desc LIMIT offset,row_count;
END// 

DELIMITER //   
CREATE PROCEDURE findopportunitiesSearchLike(IN res varchar(1000),IN offset int(50),IN row_count int(50),IN sendstring VARCHAR(100),In message VARCHAR(100))
BEGIN 
IF message="Enquiry Number" then
select pros.prospectOpportunityID,pros.prospectOpportunityName,pros.dateTime,
pipe.stageCode,acc.name,reso.Name as re,loclty.localityName as loc,city.name as city,
pros.statusFlag,pros.accountID,acc.telephone1,pros.pincode,pros.unitNumber,pros.buildingName,pros.address from tbprospectopportunity pros
left join tbpipeline pipe on pipe.stageID = pros.stageID
left join tbaccount acc on acc.accountID = pros.accountID
left join tbresource reso on reso.resourceID = pros.userID
left join tblocality loclty on loclty.localityID = pros.localityid
left join tbcity city on city.id = loclty.city
where FIND_IN_SET(pros.userID,res) and pros.activeStatus = 'Y' and pipe.funnel='Y' and pros.prospectOpportunityName = sendstring
group by pros.prospectOpportunityID order by pros.prospectOpportunityID desc LIMIT offset,row_count;
END IF;

IF message="Enquiry Name" then
select pros.prospectOpportunityID,pros.prospectOpportunityName,pros.dateTime,
pipe.stageCode,acc.name,reso.Name as re,loclty.localityName as loc,city.name as city,
pros.statusFlag,pros.accountID,acc.telephone1,pros.pincode,pros.unitNumber,pros.buildingName,pros.address from tbprospectopportunity pros
left join tbpipeline pipe on pipe.stageID = pros.stageID
left join tbaccount acc on acc.accountID = pros.accountID
left join tbresource reso on reso.resourceID = pros.userID
left join tblocality loclty on loclty.localityID = pros.localityid
left join tbcity city on city.id = loclty.city
where FIND_IN_SET(pros.userID,res) and pros.activeStatus = 'Y' and pipe.funnel='Y' and acc.name like CONCAT('%',sendstring,'%')
group by pros.prospectOpportunityID order by pros.prospectOpportunityID desc LIMIT offset,row_count;
END IF;

IF message="Mobile Number" then
select pros.prospectOpportunityID,pros.prospectOpportunityName,pros.dateTime,
pipe.stageCode,acc.name,reso.Name as re,loclty.localityName as loc,city.name as city,
pros.statusFlag,pros.accountID,acc.telephone1,pros.pincode,pros.unitNumber,pros.buildingName,pros.address from tbprospectopportunity pros
left join tbpipeline pipe on pipe.stageID = pros.stageID
left join tbaccount acc on acc.accountID = pros.accountID
left join tbresource reso on reso.resourceID = pros.userID
left join tblocality loclty on loclty.localityID = pros.localityid
left join tbcity city on city.id = loclty.city
where FIND_IN_SET(pros.userID,res) and pros.activeStatus = 'Y' and pipe.funnel='Y' and acc.telephone1 like CONCAT('%',sendstring,'%')
group by pros.prospectOpportunityID order by pros.prospectOpportunityID desc LIMIT offset,row_count;
END IF;

IF message="Assigned To" then
select pros.prospectOpportunityID,pros.prospectOpportunityName,pros.dateTime,
pipe.stageCode,acc.name,reso.Name as re,loclty.localityName as loc,city.name as city,
pros.statusFlag,pros.accountID,acc.telephone1,pros.pincode,pros.unitNumber,pros.buildingName,pros.address from tbprospectopportunity pros
left join tbpipeline pipe on pipe.stageID = pros.stageID
left join tbaccount acc on acc.accountID = pros.accountID
left join tbresource reso on reso.resourceID = pros.userID
left join tblocality loclty on loclty.localityID = pros.localityid
left join tbcity city on city.id = loclty.city
where FIND_IN_SET(pros.userID,res) and pros.activeStatus = 'Y' and pipe.funnel='Y' and reso.Name like CONCAT('%',sendstring,'%')
group by pros.prospectOpportunityID order by pros.prospectOpportunityID desc LIMIT offset,row_count;
END IF;

IF message="Stage" then
select pros.prospectOpportunityID,pros.prospectOpportunityName,pros.dateTime,
pipe.stageCode,acc.name,reso.Name as re,loclty.localityName as loc,city.name as city,
pros.statusFlag,pros.accountID,acc.telephone1,pros.pincode,pros.unitNumber,pros.buildingName,pros.address from tbprospectopportunity pros
left join tbpipeline pipe on pipe.stageID = pros.stageID
left join tbaccount acc on acc.accountID = pros.accountID
left join tbresource reso on reso.resourceID = pros.userID
left join tblocality loclty on loclty.localityID = pros.localityid
left join tbcity city on city.id = loclty.city
where FIND_IN_SET(pros.userID,res) and pros.activeStatus = 'Y' and pipe.funnel='Y' and pipe.stageCode like CONCAT('%',sendstring,'%')
group by pros.prospectOpportunityID order by pros.prospectOpportunityID desc LIMIT offset,row_count;
END IF;

IF sendstring="Open" then
select pros.prospectOpportunityID,pros.prospectOpportunityName,pros.dateTime,
pipe.stageCode,acc.name,reso.Name as re,loclty.localityName as loc,city.name as city,
pros.statusFlag,pros.accountID,acc.telephone1,pros.pincode,pros.unitNumber,pros.buildingName,pros.address from tbprospectopportunity pros
left join tbpipeline pipe on pipe.stageID = pros.stageID
left join tbaccount acc on acc.accountID = pros.accountID
left join tbresource reso on reso.resourceID = pros.userID
left join tblocality loclty on loclty.localityID = pros.localityid
left join tbcity city on city.id = loclty.city
where FIND_IN_SET(pros.userID,res) and pros.activeStatus = 'Y' and pipe.funnel='Y' and pros.statusFlag ='Y'
group by pros.prospectOpportunityID order by pros.prospectOpportunityID desc LIMIT offset,row_count;
END IF;

IF sendstring="Close" then
select pros.prospectOpportunityID,pros.prospectOpportunityName,pros.dateTime,
pipe.stageCode,acc.name,reso.Name as re,loclty.localityName as loc,city.name as city,
pros.statusFlag,pros.accountID,acc.telephone1,pros.pincode,pros.unitNumber,pros.buildingName,pros.address from tbprospectopportunity pros
left join tbpipeline pipe on pipe.stageID = pros.stageID
left join tbaccount acc on acc.accountID = pros.accountID
left join tbresource reso on reso.resourceID = pros.userID
left join tblocality loclty on loclty.localityID = pros.localityid
left join tbcity city on city.id = loclty.city
where FIND_IN_SET(pros.userID,res) and pros.activeStatus = 'Y' and pipe.funnel='Y' and pros.statusFlag ='N'
group by pros.prospectOpportunityID order by pros.prospectOpportunityID desc LIMIT offset,row_count;
END IF;

IF sendstring="Won" then
select pros.prospectOpportunityID,pros.prospectOpportunityName,pros.dateTime,
pipe.stageCode,acc.name,reso.Name as re,loclty.localityName as loc,city.name as city,
pros.statusFlag,pros.accountID,acc.telephone1,pros.pincode,pros.unitNumber,pros.buildingName,pros.address from tbprospectopportunity pros
left join tbpipeline pipe on pipe.stageID = pros.stageID
left join tbaccount acc on acc.accountID = pros.accountID
left join tbresource reso on reso.resourceID = pros.userID
left join tblocality loclty on loclty.localityID = pros.localityid
left join tbcity city on city.id = loclty.city
where FIND_IN_SET(pros.userID,res) and pros.activeStatus = 'Y' and pipe.funnel='Y' and 
pros.statusFlag ='W' group by pros.prospectOpportunityID order by pros.prospectOpportunityID desc LIMIT offset,row_count;
END IF;

IF sendstring="Lost" then
select pros.prospectOpportunityID,pros.prospectOpportunityName,pros.dateTime,
pipe.stageCode,acc.name,reso.Name as re,loclty.localityName as loc,city.name as city,
pros.statusFlag,pros.accountID,acc.telephone1,pros.pincode,pros.unitNumber,pros.buildingName,pros.address from tbprospectopportunity pros
left join tbpipeline pipe on pipe.stageID = pros.stageID
left join tbaccount acc on acc.accountID = pros.accountID
left join tbresource reso on reso.resourceID = pros.userID
left join tblocality loclty on loclty.localityID = pros.localityid
left join tbcity city on city.id = loclty.city
where FIND_IN_SET(pros.userID,res) and pros.activeStatus = 'Y' and pipe.funnel='Y' and pros.statusFlag ='L'
group by pros.prospectOpportunityID order by pros.prospectOpportunityID desc LIMIT offset,row_count;
END IF;

IF sendstring="Abandoned" then
select pros.prospectOpportunityID,pros.prospectOpportunityName,pros.dateTime,
pipe.stageCode,acc.name,reso.Name as re,loclty.localityName as loc,city.name as city,
pros.statusFlag,pros.accountID,acc.telephone1,pros.pincode,pros.unitNumber,pros.buildingName,pros.address from tbprospectopportunity pros
left join tbpipeline pipe on pipe.stageID = pros.stageID
left join tbaccount acc on acc.accountID = pros.accountID
left join tbresource reso on reso.resourceID = pros.userID
left join tblocality loclty on loclty.localityID = pros.localityid
left join tbcity city on city.id = loclty.city
where FIND_IN_SET(pros.userID,res) and pros.activeStatus = 'Y' and pipe.funnel='Y' 
and pros.statusFlag ='A' group by pros.prospectOpportunityID order by pros.prospectOpportunityID desc LIMIT offset,row_count;
END IF;
END//


DELIMITER //
CREATE PROCEDURE findinstallationSearch(IN res varchar(1000),IN offset int(50),
IN row_count int(50),IN sendstring VARCHAR(100),In message VARCHAR(100))
BEGIN
IF message="Customer Name" then
SELECT distinct hdr.orderNo,acc.name,acc.telephone1,ihdr.invoiceDate,ihdr.invoiceNo,
hdr.installationsID,hdr.orderaccehdrID,hdr.quotationID,hdr.address FROM tborderacceptancehdr hdr
left join tbaccount acc on acc.accountID = hdr.accountID
left join tbcustomertypeworkflow ctypewflw on ctypewflw.customertypeid = acc.customertypeid
left join tborderacceptancedtl odlt on odlt.orderaccehdrID = hdr.orderaccehdrID
left join tbproduct prod on prod.productID = odlt.productID
left join tborderinvoicehdr ihdr on ihdr.orderacceptanceID = hdr.orderaccehdrID
WHERE hdr.activeStatus='Y' 
and hdr.installationflag='Y' and ctypewflw.installation = "Company"
and prod.installation = 'Y' and prod.activeStatus = 'Y' and acc.activeStatus ='Y'
and odlt.activeStatus = 'Y' and ihdr.activeStatus = 'Y'
and acc.name like CONCAT('%',sendstring,'%');
END IF;

IF message="Mobile Number" then
SELECT distinct hdr.orderNo,acc.name,acc.telephone1,ihdr.invoiceDate,ihdr.invoiceNo,
hdr.installationsID,hdr.orderaccehdrID,hdr.quotationID,hdr.address FROM tborderacceptancehdr hdr
left join tbaccount acc on acc.accountID = hdr.accountID
left join tbcustomertypeworkflow ctypewflw on ctypewflw.customertypeid = acc.customertypeid
left join tborderacceptancedtl odlt on odlt.orderaccehdrID = hdr.orderaccehdrID
left join tbproduct prod on prod.productID = odlt.productID
left join tborderinvoicehdr ihdr on ihdr.orderacceptanceID = hdr.orderaccehdrID
WHERE hdr.activeStatus='Y' 
and hdr.installationflag='Y' and ctypewflw.installation = "Company"
and prod.installation = 'Y' and prod.activeStatus = 'Y' and acc.activeStatus ='Y'
and odlt.activeStatus = 'Y' and ihdr.activeStatus = 'Y'
and acc.telephone1 like CONCAT('%',sendstring,'%');
END IF;

IF message="Invoice Number" then
SELECT distinct hdr.orderNo,acc.name,acc.telephone1,ihdr.invoiceDate,ihdr.invoiceNo,
hdr.installationsID,hdr.orderaccehdrID,hdr.quotationID,hdr.address FROM tborderacceptancehdr hdr
left join tbaccount acc on acc.accountID = hdr.accountID
left join tbcustomertypeworkflow ctypewflw on ctypewflw.customertypeid = acc.customertypeid
left join tborderacceptancedtl odlt on odlt.orderaccehdrID = hdr.orderaccehdrID
left join tbproduct prod on prod.productID = odlt.productID
left join tborderinvoicehdr ihdr on ihdr.orderacceptanceID = hdr.orderaccehdrID
WHERE  hdr.activeStatus='Y' 
and hdr.installationflag='Y' and ctypewflw.installation = "Company"
and prod.installation = 'Y' and prod.activeStatus = 'Y' and acc.activeStatus ='Y'
and odlt.activeStatus = 'Y' and ihdr.activeStatus = 'Y'
and ihdr.invoiceNo = sendstring;
END IF;

IF sendstring="Pending" then
SELECT distinct hdr.orderNo,acc.name,acc.telephone1,ihdr.invoiceDate,ihdr.invoiceNo,
hdr.installationsID,hdr.orderaccehdrID,hdr.quotationID,hdr.address FROM tborderacceptancehdr hdr
left join tbaccount acc on acc.accountID = hdr.accountID
left join tbcustomertypeworkflow ctypewflw on ctypewflw.customertypeid = acc.customertypeid
left join tborderacceptancedtl odlt on odlt.orderaccehdrID = hdr.orderaccehdrID
left join tbproduct prod on prod.productID = odlt.productID
left join tborderinvoicehdr ihdr on ihdr.orderacceptanceID = hdr.orderaccehdrID
WHERE  FIND_IN_SET(hdr.userID, res) and hdr.activeStatus='Y' 
and hdr.installationflag='Y' and ctypewflw.installation = "Company"
and prod.installation = 'Y' and prod.activeStatus = 'Y' and acc.activeStatus ='Y'
and odlt.activeStatus = 'Y' and ihdr.activeStatus = 'Y'
and hdr.installationsID ='1' LIMIT offset,row_count;
END IF;

IF sendstring="On Going" then
SELECT distinct hdr.orderNo,acc.name,acc.telephone1,ihdr.invoiceDate,ihdr.invoiceNo,
hdr.installationsID,hdr.orderaccehdrID,hdr.quotationID,hdr.address FROM tbinstallations inst
left join tborderacceptancehdr hdr on hdr.orderaccehdrID = inst.orderAcceptabceID
left join tbaccount acc on acc.accountID = hdr.accountID
left join tbcustomertypeworkflow ctypewflw on ctypewflw.customertypeid = acc.customertypeid
left join tborderacceptancedtl odlt on odlt.orderaccehdrID = hdr.orderaccehdrID
left join tbproduct prod on prod.productID = odlt.productID
left join tborderinvoicehdr ihdr on ihdr.orderacceptanceID = hdr.orderaccehdrID
WHERE FIND_IN_SET(inst.ownerID, res) and hdr.activeStatus='Y' 
and hdr.installationflag='Y' and ctypewflw.installation = "Company"
and prod.installation = 'Y' and prod.activeStatus = 'Y' and acc.activeStatus ='Y'
and odlt.activeStatus = 'Y' and ihdr.activeStatus = 'Y' and inst.activeStatus = 'Y'
and hdr.installationsID = '2' LIMIT offset,row_count;
END IF;

IF sendstring="Completed" then
SELECT distinct hdr.orderNo,acc.name,acc.telephone1,ihdr.invoiceDate,ihdr.invoiceNo,
hdr.installationsID,hdr.orderaccehdrID,hdr.quotationID,hdr.address FROM tbinstallations inst
left join tborderacceptancehdr hdr on hdr.orderaccehdrID = inst.orderAcceptabceID
left join tbaccount acc on acc.accountID = hdr.accountID
left join tbcustomertypeworkflow ctypewflw on ctypewflw.customertypeid = acc.customertypeid
left join tborderacceptancedtl odlt on odlt.orderaccehdrID = hdr.orderaccehdrID
left join tbproduct prod on prod.productID = odlt.productID
left join tborderinvoicehdr ihdr on ihdr.orderacceptanceID = hdr.orderaccehdrID
WHERE FIND_IN_SET(inst.ownerID, res) and hdr.activeStatus='Y' 
and hdr.installationflag='Y' and ctypewflw.installation = "Company"
and prod.installation = 'Y' and prod.activeStatus = 'Y' and acc.activeStatus ='Y'
and odlt.activeStatus = 'Y' and ihdr.activeStatus = 'Y' and inst.activeStatus = 'Y'
and hdr.installationsID > '2' LIMIT offset,row_count;
END IF;
END //

DELIMITER //
CREATE PROCEDURE pendingInstcount(IN res varchar(1000))
BEGIN
SELECT count(*) FROM tborderacceptancehdr hdr
left join tborderinvoicehdr ihdr on ihdr.orderacceptanceID = hdr.orderaccehdrID
left join tborderinvoicedtl idtl on idtl.orderinvoicehdrID = ihdr.orderinvoicehdrID
WHERE FIND_IN_SET(hdr.userID, res) and hdr.activeStatus = 'Y' and hdr.installationsID =1 
and hdr.installationflag = 'Y' and ihdr.activeStatus = 'Y' and idtl.activeStatus = 'Y';
END //

DELIMITER //
CREATE PROCEDURE Instcount(IN res varchar(1000))
BEGIN
SELECT count(*) FROM tbinstallations inst 
left join tborderacceptancehdr hdr on hdr.orderaccehdrID = inst.orderAcceptabceID
WHERE FIND_IN_SET(inst.ownerID, res) and inst.activeStatus = 'Y' and hdr.activeStatus = 'Y'
and hdr.installationsID >1;
END //

DELIMITER //
CREATE PROCEDURE getlocalityCount()
BEGIN
select count(*) from tblocality loc 
where loc.activeStatus='Y';
END//

DELIMITER //
CREATE PROCEDURE findAllSpareItem(IN terrid int(11))
BEGIN
SELECT tbpord.* FROM tbproduct tbpord
left join tbitemSubCategory isub on isub.id = tbpord.itemsubcategoryID
WHERE tbpord.activeStatus ='Y' and tbpord.itemsubcategoryID=terrid;
END//


--DELIMITER //
--CREATE PROCEDURE findbyteamandhierarchySer(IN tbteammaster int(10), IN hierar int(10))
--BEGIN
--SELECT * FROM tbteammember WHERE hierarchy >= hierar and teamMasterID=tbteammaster and activeStatus='Y' ;
--END//

----------Updated Find Dealer by locality
DELIMITER //
CREATE PROCEDURE findBylocalityid(IN locltyid int(10))
BEGIN
	select acc.accountID,acc.name from tbdealersgeography geo
	left join tbaccount acc on acc.accountID = geo.dealersId
	where geo.localityid = locltyid and acc.dealerflag = 'Y' and acc.activeStatus = 'Y' and geo.activeStatus='Y';
END//

DELIMITER //
CREATE PROCEDURE findDealerBycity(IN city int(11))
BEGIN
SELECT distinct  dealersId FROM tbaccount tbacc
left join tbdealersgeography tbdgeo on tbdgeo.dealersId = tbacc.accountID
WHERE tbdgeo.cityid = city and tbdgeo.activeStatus = 'Y' and tbacc.activeStatus ='Y' and tbacc.dealerflag = 'Y';
END//

DELIMITER //
CREATE PROCEDURE findDealerBycity1(IN city int(11))
BEGIN
SELECT distinct tbacc.accountID,tbacc.name FROM tbaccount tbacc
left join tbdealersgeography tbdgeo on tbdgeo.dealersId = tbacc.accountID
WHERE tbdgeo.cityid = city and tbdgeo.activeStatus = 'Y' and tbacc.activeStatus ='Y' and tbacc.dealerflag = 'Y';
END//

DELIMITER //   
CREATE PROCEDURE findBySumCostHeadValue(IN id varchar(1000))
BEGIN 
select sum(costsubheadvalue) as costheadvalue from tbmarketingSubHeadbudgetdtl 
where costsubheadid = id and activeStatus = 'Y';
END//

DELIMITER //
CREATE PROCEDURE findCostHeadPercentage(IN ID int(10))
BEGIN
SELECT distinct marketingcostid, costhead, percentage FROM tbcostheadpertemplate 
WHERE activeStatus='Y' and FIND_IN_SET(marketingcostid, ID);
END//

DELIMITER //
CREATE PROCEDURE getRegion(IN cityid int(11))
BEGIN
SELECT distinct regionId FROM tblocality WHERE city = cityid and activeStatus = 'Y';
END// 

DELIMITER //
CREATE PROCEDURE getAllGrn ()
BEGIN
select distinct grnno,partyname,pono,poid,grnstatus,createdDate from tbgrn;
END//

--Fromcustomer//

DELIMITER // 
CREATE  PROCEDURE  getfromcustomerLike (IN message varchar(30), IN trnid int(10))
BEGIN
 	select * from tbaccount where name like CONCAT('%',message,'%') and dealerflag="N" and activeStatus='Y' ; 
END//

--Tocustomer//

DELIMITER // 
CREATE  PROCEDURE  getTocustomerLike (IN message varchar(30), IN trnid int(10))
BEGIN
 	select * from tbaccount where name like CONCAT('%',message,'%') and dealerflag="N" and activeStatus='Y' ; 
END//



-----------------------findcustomermearge-----------------------------
DELIMITER // 
 create Procedure findcustomermearge(IN trnid int(50))
  Begin
 select pros.prospectOpportunitycode,pros.accountID,pipe.stageCode,res.Name ,pros.statusflag  from tbprospectopportunity pros
 
 left join tbpipeline pipe on pipe.stageID = pros.stageID
 left join tbaccount acc on acc.accountID = pros.accountID
 left join tbresource res on res.resourceID=pros.assignedBy
 where FIND_IN_SET(pros.accountID,trnid) and pros.activeStatus = 'Y' and pipe.funnel='Y' and acc.activeStatus = 'Y' and res.activeStatus='Y';
 END//
-------------------------findinstallcustomermearge----------------------
DELIMITER //
CREATE PROCEDURE findinstallcustomermearge (trnid int(50))
BEGIN
SELECT tbins.installationNo,tbins.orderAcceptanceNo,tbins.completed from tbinstallations tbins
left join tbaccount acc on acc.accountID = tbins.accountID
left join tborderacceptancehdr tbhdr on tbhdr.orderaccehdrID = tbins.orderAcceptabceID
where FIND_IN_SET(tbins.accountID, trnid) and tbins.activeStatus ='Y' and tbhdr.activeStatus ='Y'
and tbhdr.installationflag ='Y' and tbhdr.installationsID > '1';
END//

------------------------findinspending----------------------------------------
DELIMITER //
CREATE PROCEDURE findinspending(accID int(50))
BEGIN
SELECT tbhdr.orderNo,tbhdr.accountID from tborderacceptancehdr tbhdr
left join tbaccount acc on acc.accountID=tbhdr.accountID
where FIND_IN_SET(tbhdr.accountID,accID) and tbhdr.activeStatus ='Y'
and tbhdr.installationsID =1;
END//
-------------------------findservicecustomermearge---------------------------
DELIMITER //
CREATE PROCEDURE findservicecustomermearge(IN accID int(50))
BEGIN
select tbse.dateTime,tbse.serviceCallNo,tbse.activeStatus,tbsp.invoicesend from tbservicecallentry tbse 
left join tbaccount acc on acc.accountID=tbse.accountID
left join tbsparequotation tbsp on tbsp.servicecallID = tbse.serviceCallID
where FIND_IN_SET(tbse.accountID,accID) and tbse.activeStatus='Y' and acc.activeStatus='Y' and tbsp.activeStatus='Y';
END //

---------------------------findcustomermeargeaccount --------------------------
DELIMITER //
CREATE PROCEDURE findcustomermeargeaccount (IN accID int(50))
BEGIN
select acc.name,acc.locality,acc.telephone1 from tbaccount acc
where FIND_IN_SET(acc.accountID,accID) and acc.activeStatus ='Y';
END //

DELIMITER //
CREATE PROCEDURE findCustomerInvLike (IN frmdate DATE, IN todate DATE, IN message VARCHAR(30))
BEGIN
select * from tborderinvoicehdr where partyname like CONCAT('%',message,'%') and activeStatus='Y' 
and dateTime Between frmdate and todate;
END//

--------------------Reassign Enquiry-----------------------
DELIMITER //   
CREATE PROCEDURE findOpportunityByresourcesforenquiry(IN res varchar(1000))
BEGIN 
select pros.prospectOpportunityID,pros.prospectOpportunityName,pros.dateTime,
pipe.stageCode,acc.name,reso.Name as re,
pros.statusFlag,pros.accountID from tbprospectopportunity pros
left join tbpipeline pipe on pipe.stageID = pros.stageID
left join tbaccount acc on acc.accountID = pros.accountID
left join tbresource reso on reso.resourceID = pros.userID
left join tblocality loclty on loclty.localityID = pros.localityid
left join tbcity city on city.id = loclty.city
where FIND_IN_SET(pros.assignedBy,res) and pros.activeStatus = 'Y' and pipe.funnel='Y' and pros.statusFlag = 'Y'
group by pros.prospectOpportunityID order by pros.prospectOpportunityID desc;
END// 

------------------ServicecallReassignenquiry--------------------
DELIMITER //
CREATE PROCEDURE findServiceCallByresourceforReassignenquiry(IN res varchar(1000))
BEGIN
select tbservice.serviceCallID,tbservice.serviceCallNo,acc.name,reso.Name as resource,tbservice.callCommitDate,tbservice.callStatus  from tbservicecallentry tbservice
left join tbaccount acc on acc.accountID = tbservice.accountID
left join tbresource reso on reso.resourceID = tbservice.assignedBy
left join tbproduct prod on prod.productID=tbservice.productID
where FIND_IN_SET(tbservice.assignedBy, res) and tbservice.activeStatus='Y' and tbservice.callStatus = 'Y' order by tbservice.serviceCallID desc;
END//


-------------------------InstallationReassignenquiry------------------
DELIMITER //
CREATE PROCEDURE findallinstallationforReassignenquiry(IN res varchar(1000))
BEGIN
SELECT hdr.orderaccehdrID,hdr.orderNo,hdr.orderDate,hdr.accountname,hdr.installationsID FROM tborderacceptancehdr hdr
WHERE  FIND_IN_SET(hdr.userID, res) and hdr.activeStatus='Y' 
and hdr.installationflag='Y' and hdr.installationsID = '1' order by hdr.orderaccehdrID desc;
END //


------------------Team wise Resources-----------------------
DELIMITER //
CREATE  PROCEDURE findByResourceNameforReassign(IN teamid int(50))
BEGIN
select distinct tbteammaster.teamCode,tbresource.resourceID,tbresource.Name,tbteammaster.teamMasterID from tbteammaster  as tbteammaster
inner join tbteammember as tbteammember on tbteammaster.teamMasterID =tbteammember.teamMasterID
inner join tbteamarea as tbteamarea  on tbteamarea.teamMasterID =tbteammember.teamMasterID
inner join tbresource as tbresource on tbresource.resourceID = tbteammember.userID
where FIND_IN_SET(tbteammaster.teamMasterID, teamid) and tbteammaster.activeStatus = 'Y' and tbteammember.activeStatus = 'Y'
and tbresource.activeStatus ='Y';
END//

---findOrdersCount
---findallAcceptedOrders


DELIMITER //
CREATE PROCEDURE findbyteamandhierarchyforDespatch(IN tbteammaster int(10), IN hierar int(10), IN tbresource int(10))
BEGIN
 SELECT * FROM tbteammember WHERE teamMasterID=tbteammaster and  activeStatus='Y' and hierarchy >= hierar or userID=tbresource;
END//

alter table tbmarketingProposaldtl add column qty decimal(10,2) DEFAULT 0.00;
UPDATE definepages SET activeStatus = 'Y' WHERE ID = 90//
-------------------------------------------------------------------------------------------
DELIMITER //
CREATE PROCEDURE getStateByRegion(IN regionid int(11))
BEGIN
SELECT distinct state,statename FROM tblocality locality WHERE FIND_IN_SET(regionid,locality.regionId) and locality.activeStatus = 'Y';
END//
-------------------------------------------------------------------------------------------
DELIMITER //
CREATE PROCEDURE getAreaByState(IN stateid int(11))
BEGIN
SELECT distinct areaId FROM tblocality locality WHERE FIND_IN_SET(locality.state,stateid) and locality.activeStatus = 'Y';
END//
-------------------------------------------------------------------------------------------
DELIMITER //
CREATE PROCEDURE getCityByArea(IN areaid int(11))
BEGIN
SELECT distinct city,cityname FROM tblocality locality WHERE FIND_IN_SET(locality.areaId,areaid) and locality.activeStatus = 'Y';
END//
-------------------------------New CallCenterDashboard Stored Procedure-------------------------------
DELIMITER //
CREATE PROCEDURE findByCtypeSearchkeyword (IN searchstring VARCHAR(100),IN ctype varchar(1000))
BEGIN
SELECT * FROM tbaccount as acc WHERE FIND_IN_SET(acc.customertypeid, ctype) and acc.activeStatus='Y' and searchkeyword like CONCAT('%',searchstring,'%');
END//


DELIMITER //
CREATE PROCEDURE findByTop10 (IN ctype varchar(1000))
BEGIN
SELECT * FROM tbaccount as acc WHERE FIND_IN_SET(acc.customertypeid, ctype) and acc.activeStatus ='Y' 
and acc.dealerflag='N' and acc.vendorflag='N' order by acc.lastModifiedDate desc LIMIT 10;
END//

------------------------Latest Service Call Dashboard Stored Procedures--------------------------
DELIMITER //
CREATE PROCEDURE getAllServiceCustomerSearch(IN res varchar(1000),IN offset int(50),IN row_count int(50),IN sendstring VARCHAR(100),IN message VARCHAR(100))
BEGIN
If message = 'Customer Name' then
select tbservice.serviceCallID,tbservice.serviceCallNo,acc.name,reso.Name as resource,tbservice.callCommitDate,tbservice.callStatus,acc.accountID,acc.telephone1,tbservice.dateTime  from tbservicecallentry tbservice
left join tbaccount acc on acc.accountID = tbservice.accountID
left join tbresource reso on reso.resourceID = tbservice.assignedBy
left join tbproduct prod on prod.productID=tbservice.productID
where FIND_IN_SET(tbservice.assignedBy, res) and tbservice.activeStatus='Y' and acc.name like CONCAT('%',sendstring,'%') order by tbservice.serviceCallNo desc LIMIT offset,row_count ;
END IF;

IF message='Service Call Number' then
select tbservice.serviceCallID,tbservice.serviceCallNo,acc.name,reso.Name as resource,tbservice.callCommitDate,tbservice.callStatus,acc.accountID,acc.telephone1,tbservice.dateTime  from tbservicecallentry tbservice
left join tbaccount acc on acc.accountID = tbservice.accountID
left join tbresource reso on reso.resourceID = tbservice.assignedBy
left join tbproduct prod on prod.productID=tbservice.productID
where FIND_IN_SET(tbservice.assignedBy, res) and tbservice.activeStatus='Y' and tbservice.serviceCallNo like CONCAT('%',sendstring,'%') order by tbservice.serviceCallNo desc LIMIT offset,row_count;
END IF;

IF message='Mobile Number' then
select tbservice.serviceCallID,tbservice.serviceCallNo,acc.name,reso.Name as resource,tbservice.callCommitDate,tbservice.callStatus,acc.accountID,acc.telephone1,tbservice.dateTime  from tbservicecallentry tbservice
left join tbaccount acc on acc.accountID = tbservice.accountID
left join tbresource reso on reso.resourceID = tbservice.assignedBy
left join tbproduct prod on prod.productID=tbservice.productID
where FIND_IN_SET(tbservice.assignedBy, res) and tbservice.activeStatus='Y' and acc.telephone1 like CONCAT('%',sendstring,'%') order by tbservice.serviceCallNo desc LIMIT offset,row_count;
END IF;

IF message='Resource Name' then
select tbservice.serviceCallID,tbservice.serviceCallNo,acc.name,reso.Name as resource,tbservice.callCommitDate,tbservice.callStatus,acc.accountID,acc.telephone1,tbservice.dateTime  from tbservicecallentry tbservice
left join tbaccount acc on acc.accountID = tbservice.accountID
left join tbresource reso on reso.resourceID = tbservice.assignedBy
left join tbproduct prod on prod.productID=tbservice.productID
where FIND_IN_SET(tbservice.assignedBy, res) and tbservice.activeStatus='Y' and reso.Name like CONCAT('%',sendstring,'%') order by tbservice.serviceCallNo desc LIMIT offset,row_count;
END IF;
END//


DELIMITER //
CREATE PROCEDURE findServiceCallCount(IN res varchar(1000))
BEGIN
select count(*) from tbservicecallentry tbservice
where FIND_IN_SET(tbservice.assignedBy,res) and  tbservice.activeStatus ='Y';
END//
----------------------------------------------------------------getallcity----------
DELIMITER //
CREATE PROCEDURE getallcity(IN offset int(50),in row_count int(50))
begin
select cit.id,cit.code,cit.name as cityname,cou.name as countryname,sta.Name as state from tbcity cit
left join tbcountry cou on cou.id = cit.countryid
left join tbstate sta on sta.stateID = cit.stateid
where cit.activeStatus = 'Y' LIMIT offset, row_count;
END //

-------------------------------------------citycount---------------------------------
DELIMITER //
CREATE PROCEDURE getcityCount()
BEGIN
select count(*) from tbcity city 
where city.activeStatus='Y';
END //
--------------------------------------------citysearch--------------------------------

DELIMITER //
CREATE PROCEDURE getcityByTypeLike(IN sendstring VARCHAR(100),IN message VARCHAR(100),IN offset int(50),IN row_count int(50))
BEGIN
IF message='City Code' then
select distinct cy.id,cy.code,cy.name,cy.stateName,cou.name as countryname  from tbcity cy
left join tbcountry cou on cou.id = cy.countryid
where cy.activeStatus='Y' and cou.activeStatus='Y' and cy.code like CONCAT('%',sendstring,'%') LIMIT offset,row_count;
END IF;

IF message='City Name' then
select distinct cy.id,cy.code,cy.name,cy.stateName,cou.name as countryname  from tbcity cy
left join tbcountry cou on cou.id = cy.countryid
where cy.activeStatus='Y' and cou.activeStatus='Y' and cy.name like CONCAT('%',sendstring,'%') LIMIT offset,row_count;
END IF;

IF message='State' then
select distinct cy.id,cy.code,cy.name,cy.stateName,cou.name as countryname  from tbcity cy
left join tbcountry cou on cou.id = cy.countryid
where cy.activeStatus='Y' and cou.activeStatus='Y' and cy.stateName like CONCAT('%',sendstring,'%') LIMIT offset,row_count;
END IF;

IF message='Country' then
select distinct cy.id,cy.code,cy.name,cy.stateName,cou.name as countryname  from tbcity cy
left join tbcountry cou on cou.id = cy.countryid
where cy.activeStatus='Y' and cou.activeStatus='Y' and cou.name like CONCAT('%',sendstring,'%') LIMIT offset,row_count;
END IF;
END//


DELIMITER //
CREATE PROCEDURE findStorekeeperid(IN userid int(50))
BEGIN
select * from tbaccount acc
left join tbinventorylocation inv on inv.id = acc.deliverylocid
where FIND_IN_SET(inv.storekeeperid,userid) and inv.activeStatus ='Y' and acc.activeStatus = 'Y';
END//
-------------------------------findPendingDealerPO---------------------
DELIMITER //
CREATE PROCEDURE findPendingDealerPO(IN s2 varchar(1000),IN offset int(50),IN row_count int(50))
BEGIN
select MAX(phdr.dealerpurhdrid),MAX(phdr.purchaseOrderno),MAX(phdr.datetime),MAX(phdr.total),MAX(acc.name),MAX(ctype.type),MAX(phdr.approvedorderflg) from tbdealerPurchaesOrderhdr phdr 
left join tbaccount acc on acc.accountID = phdr.accountId
left join tbdealerPurchaesOrderdtl pdtl on pdtl.dealerpurhdrid = phdr.dealerpurhdrid 
left join tbcustomertypeworkflow wrk on wrk.customertypeid=acc.customertypeid
left join tbcustomertype ctype on ctype.id = wrk.customertypeid
where FIND_IN_SET(acc.customertypeid,s2) and phdr.activeStatus='Y' and pdtl.activeStatus='Y' and acc.activeStatus='Y' group by phdr.dealerpurhdrid LIMIT offset,row_count;
END//

-----------------------------


--findServiceCallByresources
--getAllServiceCustomerSearch
--findByActiveStatusAndQuoteStatus
--findPendingDealerPO

