--/////Get DCR By Resource and Status//////////

DELIMITER //
CREATE  PROCEDURE findDcrReport(IN frmdate date,IN todate date,IN resourcelst varchar(500),IN status varchar(10))
BEGIN

IF status="Open" then
select usrts.dueDate,usrts.type,usrts.desciption,con.firstName,
acc.name as customerName,pip.stageCode,usrts.followuptaskdate,usrts.userTaskID,usrts.assignedBy from tbusertask usrts
 join tbcontact con on usrts.contactID=con.contactID
 join tbaccount acc on usrts.customerID= acc.accountID
 join tbpipeline pip on usrts.stageid=pip.stageID
where con.activeStatus='Y' and acc.activeStatus='Y' and pip.activeStatus='Y' 
and usrts.dueDate BETWEEN frmdate AND todate
and usrts.openCloseStatus='Y' and FIND_IN_SET(usrts.userID,resourcelst);

ELSE

select usrts.dueDate,usrts.type,usrts.desciption,
con.firstName,acc.name as customerName,
pip.stageCode,usrts.followuptaskdate,usrts.userTaskID,usrts.assignedBy from tbusertask usrts
 join tbcontact con on usrts.contactID=con.contactID
 join tbaccount acc on usrts.customerID= acc.accountID
 join tbpipeline pip on usrts.stageid=pip.stageID
where con.activeStatus='Y' and acc.activeStatus='Y' and pip.activeStatus='Y' 
and usrts.dueDate BETWEEN frmdate AND todate   
and usrts.openCloseStatus='N' and FIND_IN_SET(usrts.userID , resourcelst);
END IF;

END//

--//////// Get All DCR BY Resource and All status//////////

DELIMITER //
CREATE PROCEDURE findAllDcrReport(IN frmdate date,IN todate date,IN resourcelst varchar(500))
BEGIN
select usrts.dueDate,usrts.type,usrts.desciption,
con.firstName,acc.name as customerName,pip.stageCode,
usrts.followuptaskdate,usrts.userTaskID,usrts.assignedBy from tbusertask usrts
  join tbcontact con on usrts.contactID=con.contactID
  join tbaccount acc on usrts.customerID= acc.accountID
  join tbpipeline pip on usrts.stageid=pip.stageID
where con.activeStatus='Y' and acc.activeStatus='Y' and pip.activeStatus='Y'
and usrts.dueDate BETWEEN frmdate AND todate and FIND_IN_SET(usrts.userID,resourcelst);
END//

DELIMITER //
CREATE  PROCEDURE findBranchByArea(IN arealst varchar(9000))
BEGIN
select branch.branchID,branch.branchName  from tbteamarea area
left join tbteammaster master on master.teamMasterID = area.teamMasterID
left join tbbranch branch on branch.branchID = master.BranchID
where area.activeStatus='Y'  and branch.activeStatus='Y' and FIND_IN_SET(area.areaID, arealst) group by branch.branchID;
END//


DELIMITER //
CREATE  PROCEDURE findResourceByBranch(IN branchlst varchar(500))
BEGIN
select res.resourceID,res.Name from tbresource res
left join tbbranch branch on res.userPrefix=branch.branchID
where branch.activeStatus='Y' and res.activeStatus='Y' and res.activeInactive='Y' and FIND_IN_SET(branch.branchID, branchlst);
END//

--//////////// DCR Summary REport////////

DELIMITER //
CREATE  PROCEDURE findDcrSummaryReport(IN fromDate date,IN toDate date,IN resourcelst varchar(500))
BEGIN
select (select count(*) from tbusertask t1 where t1.openCloseStatus='Y'
and t1.duedate between fromDate and toDate and FIND_IN_SET(t1.userID,resourcelst)) as open,
(select count(*) from tbusertask t2 where t2.openCloseStatus='N'
and t2.duedate between fromDate and toDate and FIND_IN_SET(t2.userID,resourcelst)) as close,
(select count(*) from tbusertask t3 where t3.duedate between fromDate and toDate
and FIND_IN_SET(t3.userID,resourcelst)) as allc,res.Name as resname,res.branchname
from tbusertask utask 
left join tbresource res on res.resourceID = utask.userID
where res.activeStatus='Y' and res.activeInactive='Y' and FIND_IN_SET(utask.userID,resourcelst) group by res.resourceID;
END//

--//////////find Engineer Wise Quotation  Report

--DELIMITER //
--CREATE PROCEDURE findEngineerWiseQuoReport(IN frmdate date,IN todate date,IN resourcelst varchar(500),IN status varchar(10))
--BEGIN
--IF status="All" then
--select qut.startDate,qut.accountname,qut.totalAmount,res.Name,tbpro.prospectOpportunityCode,qut.quoteStatus from tbquotation qut
--left join tbresource res on qut.userID=res.resourceID
--left join tbprospectopportunity tbpro on tbpro.prospectOpportunityID =qut.prospectOpportunityID
--where res.activeStatus='Y' and qut.activeStatus='Y' and tbpro.activeStatus='Y' and qut.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(qut.userID,resourcelst);
--END IF;
--
--IF status="Open" then
--select qut.startDate,qut.accountname,qut.totalAmount,res.Name,tbpro.prospectOpportunityCode,qut.quoteStatus from tbquotation qut
--left join tbresource res on qut.userID=res.resourceID
--left join tbprospectopportunity tbpro on tbpro.prospectOpportunityID =qut.prospectOpportunityID
--where res.activeStatus='Y' and qut.activeStatus='Y' and tbpro.activeStatus='Y' and qut.quoteStatus = '-' and qut.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(qut.userID,resourcelst);
--END IF;
--
--IF status="Won" then
--select qut.startDate,qut.accountname,qut.totalAmount,res.Name,tbpro.prospectOpportunityCode,qut.quoteStatus from tbquotation qut
--left join tbresource res on qut.userID=res.resourceID
--left join tbprospectopportunity tbpro on tbpro.prospectOpportunityID =qut.prospectOpportunityID
--where res.activeStatus='Y' and qut.activeStatus='Y' and tbpro.activeStatus='Y' and qut.quoteStatus = 'W' and qut.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(qut.userID,resourcelst);
--END IF;
--
--IF status="Lost" then
--select qut.startDate,qut.accountname,qut.totalAmount,res.Name,tbpro.prospectOpportunityCode,qut.quoteStatus from tbquotation qut
--left join tbresource res on qut.userID=res.resourceID
--left join tbprospectopportunity tbpro on tbpro.prospectOpportunityID =qut.prospectOpportunityID
--where res.activeStatus='Y' and qut.activeStatus='Y' and tbpro.activeStatus='Y' and qut.quoteStatus = 'L' and qut.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(qut.userID,resourcelst);
--END IF;
--
--IF status="Abandoned" then
--select qut.startDate,qut.accountname,qut.totalAmount,res.Name,tbpro.prospectOpportunityCode,qut.quoteStatus from tbquotation qut
--left join tbresource res on qut.userID=res.resourceID
--left join tbprospectopportunity tbpro on tbpro.prospectOpportunityID =qut.prospectOpportunityID
--where res.activeStatus='Y' and qut.activeStatus='Y' and tbpro.activeStatus='Y' and qut.quoteStatus = 'A' and qut.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(qut.userID,resourcelst);
--END IF;
--
--END//


--/////////Autocomplete for customer name/////////

DELIMITER //
CREATE  PROCEDURE findbycustomer(IN message VARCHAR(100))
BEGIN
SELECT * FROM tbquotation WHERE activeStatus='Y' and accountname like CONCAT('%',message,'%');
END//



--///////// Find All Quot Report By customerId And frmdate , todate/////////

DELIMITER //
CREATE PROCEDURE findAllQuotReport(IN frmdate date,IN todate date,IN customerId int(10), IN type varchar(20),IN citylst varchar(9000))
BEGIN
IF type='cust' then
select quot.quotationID,quot.accountname,quot.quotationCode from tbquotation quot
left join tbprospectopportunity pros on quot.prospectOpportunityID = pros.prospectOpportunityID
left join tblocality loc on pros.localityID = loc.localityID
where quot.accountID=customerId  and loc.city = citylst and quot.activeStatus='Y' and pros.activeStatus='Y' and loc.activeStatus='Y';

ELSE
select quot.quotationID,quot.accountname,quot.quotationCode from tbquotation quot
left join tbprospectopportunity pros on quot.prospectOpportunityID = pros.prospectOpportunityID
left join tblocality loc on pros.localityID = loc.localityID
where loc.city = citylst and quot.activeStatus='Y' and pros.activeStatus='Y' and loc.activeStatus='Y' and quot.dateTime BETWEEN frmdate AND todate;
END IF;
END//

--/////// Find Customer Quot Report By customerId And frmdate , todate////////
DELIMITER //
CREATE PROCEDURE findCustomerQuotReport(IN frmdate date,IN todate date,IN customerId int(10),IN citylst varchar(9000))
BEGIN
select quot.quotationID,quot.accountname,quot.quotationCode from tbquotation quot
left join tbprospectopportunity pros on quot.prospectOpportunityID = pros.prospectOpportunityID
left join tblocality loc on pros.localityID = loc.localityID
where loc.city = citylst and quot.activeStatus='Y' and pros.activeStatus='Y' and loc.activeStatus='Y' and 
quot.dateTime BETWEEN frmdate AND todate and quot.accountID = customerId;
END//

--///////
DELIMITER //
CREATE  PROCEDURE findStockLedger(IN frmdate date,IN todate date,IN Id int(10),IN chkAllitem varchar(10))
BEGIN
IF chkAllitem = "true" then
select * from tbstocktransaction where activeStatus = 'Y' and dateTime BETWEEN frmdate AND todate;
ELSE
select * from tbstocktransaction where itemid = Id and activeStatus = 'Y';
END IF;
END//

----// Find All Opportunity Report/////////
DELIMITER //
CREATE PROCEDURE findAllOppntyReport(IN frmdate date,IN todate date,IN resource varchar(1000))
BEGIN
select oppnty.prospectOpportunityName,oppnty.statusFlag,oppnty.dateTime,
acc.name,res.Name as resname,pip.stageCode from tbprospectopportunity oppnty
left join tbaccount acc on oppnty.accountID = acc.accountID
left join tbpipeline pip on oppnty.stageID = pip.stageID
left join tbresource res on oppnty.userID = res.resourceID
where oppnty.activeStatus = 'Y' and acc.activeStatus = 'Y' and pip.activeStatus='Y' and 
res.activeStatus = 'Y' and oppnty.dateTime Between frmdate and todate and FIND_IN_SET(oppnty.userID,resource);
END//

--///////////////Find Open Status And Close Status Opportunity Report////////
DELIMITER //
CREATE PROCEDURE findOppntyReport(IN frmdate date,IN todate date,IN resource varchar(1000),IN status varchar(10))
BEGIN

IF status="Open" then
select oppnty.prospectOpportunityName,oppnty.statusFlag,oppnty.dateTime,
acc.name,acc.telephone1,acc.locality,res.Name as resname,pip.stageCode from tbprospectopportunity oppnty
left join tbaccount acc on oppnty.accountID = acc.accountID
left join tbpipeline pip on oppnty.stageID = pip.stageID
left join tbresource res on oppnty.userID = res.resourceID
where oppnty.activeStatus = 'Y' and acc.activeStatus = 'Y' and pip.activeStatus='Y' and 
res.activeStatus = 'Y' and oppnty.statusFlag = 'Y' and oppnty.dateTime Between frmdate and todate and FIND_IN_SET(oppnty.userID,resource);
END IF;

IF status="Close" then
select oppnty.prospectOpportunityName,oppnty.statusFlag,oppnty.dateTime,
acc.name,acc.telephone1,acc.locality,res.Name as resname,pip.stageCode from tbprospectopportunity oppnty
left join tbaccount acc on oppnty.accountID = acc.accountID
left join tbpipeline pip on oppnty.stageID = pip.stageID
left join tbresource res on oppnty.userID = res.resourceID
where oppnty.activeStatus = 'Y' and acc.activeStatus = 'Y' and pip.activeStatus='Y' and 
res.activeStatus = 'Y' and oppnty.statusFlag = 'N' and oppnty.dateTime Between frmdate and todate and FIND_IN_SET(oppnty.userID,resource);
END IF;

IF status="Won" then
select oppnty.prospectOpportunityName,oppnty.statusFlag,oppnty.dateTime,
acc.name ,acc.telephone1,acc.locality,res.Name as resname,pip.stageCode from tbprospectopportunity oppnty
left join tbaccount acc on oppnty.accountID = acc.accountID
left join tbpipeline pip on oppnty.stageID = pip.stageID
left join tbresource res on oppnty.userID = res.resourceID
where oppnty.activeStatus = 'Y' and acc.activeStatus = 'Y' and pip.activeStatus='Y' and 
res.activeStatus = 'Y' and oppnty.statusFlag = 'W' and oppnty.dateTime Between frmdate and todate and FIND_IN_SET(oppnty.userID,resource);
END IF;

IF status="Lost" then
select oppnty.prospectOpportunityName,oppnty.statusFlag,oppnty.dateTime,
acc.name ,acc.telephone1,acc.locality,res.Name as resname,pip.stageCode from tbprospectopportunity oppnty
left join tbaccount acc on oppnty.accountID = acc.accountID
left join tbpipeline pip on oppnty.stageID = pip.stageID
left join tbresource res on oppnty.userID = res.resourceID
where oppnty.activeStatus = 'Y' and acc.activeStatus = 'Y' and pip.activeStatus='Y' and 
res.activeStatus = 'Y' and oppnty.statusFlag = 'L' and oppnty.dateTime Between frmdate and todate and FIND_IN_SET(oppnty.userID,resource);
END IF;

IF status="Abandoned" then
select oppnty.prospectOpportunityName,oppnty.statusFlag,oppnty.dateTime,
acc.name ,acc.telephone1,acc.locality,res.Name as resname,pip.stageCode from tbprospectopportunity oppnty
left join tbaccount acc on oppnty.accountID = acc.accountID
left join tbpipeline pip on oppnty.stageID = pip.stageID
left join tbresource res on oppnty.userID = res.resourceID
where oppnty.activeStatus = 'Y' and acc.activeStatus = 'Y' and pip.activeStatus='Y' and 
res.activeStatus = 'Y' and oppnty.statusFlag = 'A' and oppnty.dateTime Between frmdate and todate and FIND_IN_SET(oppnty.userID,resource);
END IF;
END//

--/////////Autocomplete for stock transaction Item name//////////
DELIMITER //
CREATE  PROCEDURE findbystocktracitemName(IN message VARCHAR(100))
BEGIN
SELECT * FROM tbstocktransaction WHERE activeStatus='Y' and itemname like CONCAT('%',message,'%');
END//

---/////////////////////
DELIMITER //
CREATE PROCEDURE findProdCatByBranch(IN branchlst varchar(500))
BEGIN
select pcat.productCategoryID,pcat.name from tbteammaster master
left join tbteamproductcategory tempcat on master.teamMasterID = tempcat.teamMasterID
left join tbproductcategory pcat on tempcat.teamProductCategoryID = pcat.productCategoryID
where pcat.activeStatus ='Y' and tempcat.activeStatus ='Y' and master.activeStatus ='Y' and FIND_IN_SET(master.BranchID,branchlst) group by pcat.productCategoryID;
END//

--////////////////Order In Hand Report///////////
DELIMITER //
CREATE  PROCEDURE findOrdInHandReport(IN frmdate date,IN todate date,IN productCategory varchar(100),IN branchName varchar(100))
BEGIN
select Max(acc.name),Max(loc.localityName),Max(prod.productCode),Max(brn.branchName),
Max(quotProd.quantity),Max(quotProd.netamount),Max(quotProd.uom),Max(quotProd.finalAmount)
from tbprospectopportunity prosOpp
left join tbquotation quot on quot.prospectOpportunityID = prosOpp.prospectOpportunityID
left join tbquotationproduct quotProd on quotProd.quotationID = quot.quotationID
left join tbproductcategory prodCat on prodCat.productCategoryID = quotProd.productCategoryID
left join tbproduct prod on quotProd.productID = prod.productID
left join tbaccount acc on acc.accountID = quot.accountID
left join tblocality loc on acc.localityid = loc.localityID
left join tbresource res on quot.userID = res.resourceID
left join tbbranch brn on brn.branchID = acc.branchID
where acc.activeStatus = 'Y' and loc.activeStatus = 'Y' and prod.activeStatus = 'Y' and brn.activeStatus = 'Y'
and quotProd.activeStatus = 'Y' and prosOpp.activeStatus = 'Y' and prodCat.activeStatus = 'Y' and 
res.activeStatus = 'Y' and quot.activeStatus = 'Y' and quot.quoteStatus='W' and prosOpp.createddate BETWEEN frmdate AND todate 
and FIND_IN_SET(prodCat.productCategoryID,productCategory) and FIND_IN_SET(brn.branchID,branchName)
group by acc.name,loc.localeName,prod.productCode;
END//

---//////////////
DELIMITER //
CREATE PROCEDURE findCorporateSumyReport(IN frmdate date,IN todate date,IN industry varchar(100))
BEGIN
select ordInvHdr.partyname,prod.itemname,ordInvDtl.price,ordInvDtl.qty,ordInvDtl.invoiceNo,
ordInvDtl.invoiceDate,ordInvDtl.totalamount,super.name,ordInvHdr.supplierName from tborderinvoicedtl ordInvDtl
left join tborderinvoicehdr ordInvHdr on ordInvHdr.orderinvoicehdrID = ordInvDtl.orderinvoicehdrID
left join tbaccount acc on ordInvHdr.accountID = acc.accountID
left join tbproduct prod on ordInvDtl.productID = prod.productID
left join tbcustomertypeworkflow custWfo on custWfo.customertypeid = acc.customertypeid
right join tbaccount super on acc.parentAccountID = super.accountID
where ordInvHdr.activeStatus = 'Y' and acc.activeStatus = 'Y' and prod.activeStatus = 'Y' and 
ordInvDtl.activeStatus = 'Y' and ordInvDtl.dateTime BETWEEN frmdate AND todate 
and FIND_IN_SET(custWfo.industryid,industry);
END//

---///////////////////////

DELIMITER //
CREATE  PROCEDURE findbyParantAccName(IN message VARCHAR(100))
BEGIN
SELECT * FROM tbaccount WHERE activeStatus='Y' and name like CONCAT('%',message,'%');
END//

--//////--------------Updated VisitDetail Summary Report------------------
DELIMITER //
CREATE PROCEDURE findVisitDetailSumyReport(IN frmdate date,IN todate date,IN industry varchar(100),IN authName varchar(100))
BEGIN
select usrTsk.dueDate ,usrTsk.desciption ,usrTsk.followuptaskdate , usrTsk.genactivity,task.taskName, acc.name from tbusertask usrTsk
left join tbaccount acc on usrTsk.customerID = acc.accountID
left join tbtask task on task.taskID = usrTsk.followUpTaskID
left join tbaccount super on acc.parentAccountID = super.accountID 
where usrTsk.openCloseStatus = 'N' and acc.activeStatus = 'Y' and usrTsk.dueDate BETWEEN frmdate AND todate 
and FIND_IN_SET(acc.industry,industry) and FIND_IN_SET(acc.accountID,authName);
END//

---////////////

DELIMITER //
CREATE  PROCEDURE findparentAccounID(IN message int(10))
BEGIN
SELECT * FROM tbaccount WHERE activeStatus='Y' and parentAccountID like CONCAT('%',message,'%');
END//

--------------------Updated InstallationSummaryReport StoredProcedure---------------------

DELIMITER //
CREATE PROCEDURE findInstallationSummaryReport(IN frmdate date,IN todate date,IN resourcelst varchar(500),IN status varchar(10))
BEGIN
IF status= "Completed" then
select insta.dateTime,insta.completed,ctype.type,acc.name as custname ,prod.descrption,insta.installationNo,res.Name from 
tbinstallations insta 
left join tbaccount acc on insta.accountID= acc.accountID
left join tbcustomertype ctype on acc.customertypeid = ctype.id  
left join tbinstallationresource instares on  insta.installationID = instares.tbinstallations 
left join tbproduct prod on instares.productID = prod.productID 
left join tbresource res on insta.ownerID = res.resourceID
where insta.activeStatus='Y' and ctype.activeStatus='Y' and acc.activeStatus='Y' and instares.activeStatus='Y'
and prod.activeStatus = 'Y' and insta.completed = 'Y' and insta.dateTime BETWEEN frmdate AND todate 
and FIND_IN_SET(insta.ownerID,resourcelst);

ELSE IF status = "On Going" then

select insta.dateTime,insta.completed,ctype.type,acc.name as custname ,prod.descrption,insta.installationNo,res.Name from 
tbinstallations insta 
left join tbaccount acc on insta.accountID= acc.accountID
left join tbcustomertype ctype on acc.customertypeid = ctype.id  
left join tbinstallationresource instares on  insta.installationID = instares.tbinstallations 
left join tbproduct prod on instares.productID = prod.productID 
left join tbresource res on insta.ownerID = res.resourceID
where insta.activeStatus='Y' and ctype.activeStatus='Y' and acc.activeStatus='Y' and instares.activeStatus='Y'
and prod.activeStatus = 'Y' and insta.completed = 'N' and insta.dateTime BETWEEN frmdate AND todate 
and FIND_IN_SET(insta.ownerID,resourcelst);
END IF;
END IF;
END//
--------------Updated Unassigned procedure------------
DELIMITER //
CREATE  PROCEDURE findAllInstallationSummaryReport(IN frmdate date,IN todate date,IN resourcelst varchar(500))
BEGIN
select orderhdr.dateTime,orderhdr.installationsID,ctype.type,acc.name as custname,product.descrption,orderhdr.activeStatus,orderhdr.activeStatus as activeStatus1  from 
tborderacceptancehdr orderhdr 
left join tbaccount acc on orderhdr.accountID= acc.accountID
left join tbcustomertype ctype on acc.customertypeid = ctype.id
left join tborderacceptancedtl orderdtl on orderdtl.orderaccehdrID = orderhdr.orderaccehdrID
left join tbproduct product on orderdtl.productID = product.productID
where orderhdr.activeStatus='Y' and ctype.activeStatus='Y' and acc.activeStatus='Y'
and orderhdr.installationsID = '1' and orderhdr.dateTime BETWEEN frmdate AND todate; 
END//

DELIMITER //
CREATE  PROCEDURE findBranchByCity(IN citylst varchar(500))
BEGIN
select branch.branchID,branch.branchName  from tbteamarea area
left join tbteammaster master on master.teamMasterID = area.teamMasterID
left join tbbranch branch on branch.branchID = master.BranchID
where area.activeStatus='Y'  and branch.activeStatus='Y' and FIND_IN_SET(area.cityid, citylst) group by branch.branchID;
END//


DELIMITER //
CREATE  PROCEDURE findOrdInHandReport(IN frmdate date,IN todate date,IN productCategory varchar(100),IN branchName varchar(9000))
BEGIN
select orderhdr.dateTime,orderhdr.orderNo,acc.name,prod.productCode,brn.branchName,
orderdtl.qty,orderdtl.unitName,orderdtl.value,orderdtl.ordercomplete
from tborderacceptancehdr orderhdr
left join tborderacceptancedtl orderdtl on orderdtl.orderaccehdrID = orderhdr.orderaccehdrID
left join tbproduct prod on prod.productID = orderdtl.productID
left join tbaccount acc on acc.accountID = orderhdr.accountID
left join tbteamarea area on area.pincode = orderhdr.pincode
left join tbteammaster master on master.teamMasterID = area.teamMasterID
left join tbbranch brn on brn.branchID = master.branchID
where acc.activeStatus = 'Y' and orderdtl.activeStatus = 'Y' and area.activeStatus = 'Y'
and master.activeStatus = 'Y' and prod.activeStatus = 'Y' and brn.activeStatus = 'Y' 
and orderdtl.ordercomplete = 'Y' and master.sales = 'Y' and orderhdr.dateTime BETWEEN frmdate AND todate 
and FIND_IN_SET(orderdtl.productCatID,productCategory);
END//


----//////// findCityByArea
DELIMITER //
CREATE  PROCEDURE findCityByArea(IN arealst varchar(9000))
BEGIN
select distinct ct.id,ct.name from tbcity ct
left join tbteamarea team on team.cityid = ct.id
where team.activeStatus='Y' and ct.activeStatus = 'Y' and FIND_IN_SET(team.areaID, arealst);
END//

DELIMITER //
CREATE PROCEDURE findTeamByBranch (IN branchlst VARCHAR(500), IN userid VARCHAR(10), IN teamtype VARCHAR(20))
BEGIN
IF teamtype= "sales" then
select tmaster.teamMasterID,tmaster.teamCode from tbteammaster tmaster
left join tbteammember tmember on tmember.teamMasterID = tmaster.teamMasterID
where tmember.activeStatus='Y' and tmaster.activeStatus='Y' and tmaster.sales ='Y' and FIND_IN_SET(tmaster.BranchID, branchlst)
and  FIND_IN_SET(tmember.userID, userid);
END IF;

IF teamtype= "service" then
select tmaster.teamMasterID,tmaster.teamCode from tbteammaster tmaster
left join tbteammember tmember on tmember.teamMasterID = tmaster.teamMasterID
where tmember.activeStatus='Y' and tmaster.activeStatus='Y' and tmaster.service ='Y' and FIND_IN_SET(tmaster.BranchID, branchlst)
and  FIND_IN_SET(tmember.userID, userid);
END IF;

IF teamtype= "installation" then
select tmaster.teamMasterID,tmaster.teamCode from tbteammaster tmaster
left join tbteammember tmember on tmember.teamMasterID = tmaster.teamMasterID
where tmember.activeStatus='Y' and tmaster.activeStatus='Y' and tmaster.installation = 'Y' and FIND_IN_SET(tmaster.BranchID, branchlst)
and  FIND_IN_SET(tmember.userID, userid);
END IF;
END//


----//////
DELIMITER //
CREATE PROCEDURE findResourceHierchy(IN userid varchar(10))
BEGIN
select distinct hierarchy from tbteammember tmember
where FIND_IN_SET(tmember.userID,userid) and tmember.activeStatus='Y';
END//

------/////
--DELIMITER //
--CREATE PROCEDURE findResourceByTeam(IN teamlst varchar(1000),IN hierarchy varchar(10))
--BEGIN
--select res.resourceID,res.Name from tbteammaster tmaster
--left join tbteammember tmember on tmaster.teamMasterID = tmember.teamMasterID 
--left join tbresource res on tmember.userID = res.resourceID
--where tmaster.activeStatus='Y'  and tmember.activeStatus='Y' and res.activeStatus='Y'
--and res.activeInactive='Y' and tmember.hierarchy >= hierarchy and FIND_IN_SET(tmaster.teamMasterID,teamlst) order by res.Name ASC;
--END//

DELIMITER //
CREATE  PROCEDURE findResourceByTeam(IN teamlst varchar(1000),IN hierarchy varchar(10))
BEGIN
select res.resourceID,res.Name from tbteammaster tmaster
left join tbteammember tmember on tmaster.teamMasterID = tmember.teamMasterID 
left join tbresource res on tmember.userID = res.resourceID
where tmaster.activeStatus='Y'  and tmember.activeStatus='Y' and res.activeStatus='Y'
and res.activeInactive='Y' and tmember.hierarchy > hierarchy and FIND_IN_SET(tmaster.teamMasterID,teamlst)
order by res.Name ASC;
END//

DELIMITER //
CREATE PROCEDURE findResourceByTeamanduserid(IN teamlst varchar(1000),IN userid varchar(10))
BEGIN
select res.resourceID,res.Name from tbteammaster tmaster
left join tbteammember tmember on tmaster.teamMasterID = tmember.teamMasterID 
left join tbresource res on tmember.userID = res.resourceID
where tmaster.activeStatus='Y'  and tmember.activeStatus='Y' and res.activeStatus='Y'
and res.activeInactive='Y' and FIND_IN_SET(tmember.userID,userid) 
and FIND_IN_SET(tmaster.teamMasterID,teamlst) order by res.Name ASC;
END//


--//////////find Engineer Wise Quotation Detail Report
DELIMITER //
CREATE PROCEDURE findEngineerWiseQuoDtlReport (IN frmdate DATE, IN todate DATE, IN resourcelst VARCHAR(500), IN status VARCHAR(10))
BEGIN
IF status="All" then
select qut.dateTime,qut.accountname,qut.totalAmount,res.Name,tbpro.prospectOpportunityCode,qut.quoteStatus,tbpro.description,qut.quotationID from tbquotation qut
left join tbresource res on qut.userID=res.resourceID
left join tbprospectopportunity tbpro on tbpro.prospectOpportunityID =qut.prospectOpportunityID
where res.activeStatus='Y' and qut.activeStatus='Y' and tbpro.activeStatus='Y' and qut.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(qut.userID,resourcelst);
END IF;

IF status="Undecided" then
select qut.dateTime,qut.accountname,qut.totalAmount,res.Name,tbpro.prospectOpportunityCode,qut.quoteStatus,tbpro.description,qut.quotationID from tbquotation qut
left join tbresource res on qut.userID=res.resourceID
left join tbprospectopportunity tbpro on tbpro.prospectOpportunityID =qut.prospectOpportunityID
where res.activeStatus='Y' and qut.activeStatus='Y' and tbpro.activeStatus='Y' and tbpro.stageID = '2' and qut.quoteStatus = '-' and qut.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(qut.userID,resourcelst);
END IF;

IF status="Won" then
select qut.dateTime,qut.accountname,qut.totalAmount,res.Name,tbpro.prospectOpportunityCode,qut.quoteStatus,tbpro.description,qut.quotationID from tbquotation qut
left join tbresource res on qut.userID=res.resourceID
left join tbprospectopportunity tbpro on tbpro.prospectOpportunityID = qut.prospectOpportunityID
where res.activeStatus ='Y' and qut.activeStatus ='Y' and tbpro.activeStatus ='Y' and qut.quoteStatus = 'W' and qut.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(qut.userID,resourcelst);
END IF;

IF status="Postponed" then
select qut.dateTime,qut.accountname,qut.totalAmount,res.Name,tbpro.prospectOpportunityCode,qut.quoteStatus,tbpro.description,qut.quotationID from tbquotation qut
left join tbresource res on qut.userID=res.resourceID
left join tbprospectopportunity tbpro on tbpro.prospectOpportunityID =qut.prospectOpportunityID
where res.activeStatus='Y' and qut.activeStatus='Y' and tbpro.activeStatus='Y' and qut.quoteStatus = 'A' and qut.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(qut.userID,resourcelst);
END IF;

IF status="Completed" then
select qut.dateTime,qut.accountname,qut.totalAmount,res.Name,tbpro.prospectOpportunityCode,tbinst.completed,tbpro.description,qut.quotationID from tbquotation qut
left join tbresource res on qut.userID=res.resourceID
left join tbprospectopportunity tbpro on tbpro.prospectOpportunityID = qut.prospectOpportunityID
left join tborderacceptancehdr tbohdr on tbohdr.quotationID = qut.quotationID
left join tbinstallations tbinst on tbinst.orderAcceptabceID = tbohdr.orderaccehdrID
where res.activeStatus='Y' and qut.activeStatus='Y' and tbpro.activeStatus='Y'
and tbinst.completed = 'Y' and tbinst.activeStatus = 'Y' and tbohdr.activeStatus = 'Y'
and qut.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(qut.userID,resourcelst);
END IF;

END//



DELIMITER //
CREATE PROCEDURE findEngineerWiseQuoDtl(IN quotatioid varchar(10))
BEGIN
select qutProd.productName,qutProd.quantity,qutProd.finalAmount,qutProd.uom,qutProd.productID from tbquotationproduct qutProd
where qutProd.activeStatus='Y' and FIND_IN_SET(qutProd.quotationID,quotatioid);
END//

DELIMITER //
CREATE PROCEDURE findproductSummary(IN productlst VARCHAR(1000), IN resource VARCHAR(500), IN frmdate DATE, IN todate DATE ,IN id VARCHAR(16383))
BEGIN
select qutProd.productName,SUM(qutProd.quantity),SUM(qutProd.finalAmount) from tbquotationproduct qutProd
where qutProd.activeStatus='Y' and qutProd.dateTime BETWEEN frmdate AND todate 
and FIND_IN_SET(qutProd.userID,resource) and FIND_IN_SET(qutProd.productID,productlst)
and FIND_IN_SET(qutProd.quotationID,id) group by qutProd.productName order by qutProd.productName Asc;
END//

--///// Executive wise Open/Lost Report
DELIMITER //
CREATE PROCEDURE findEngineerWiseQuoReport(IN resourcelst varchar(500),IN status varchar(10))
BEGIN

IF status="Open" then
select tbpro.dateTime,acc.name as accName,res.Name,tbpro.prospectOpportunityCode,cont.mobile,loc.localityName from tbprospectopportunity tbpro
left join tbresource res on tbpro.assignedBy =res.resourceID
left join tbaccount acc on acc.accountID = tbpro.accountID
left join tblocality loc on loc.localityID = tbpro.localityID
left join tbcontact cont on cont.contactID = tbpro.contactID
where res.activeStatus='Y' and tbpro.activeStatus='Y' and tbpro.stageID = '1' and tbpro.statusFlag = 'Y'
and cont.activeStatus = 'Y' and loc.activeStatus = 'Y' and acc.activeStatus = 'Y' and FIND_IN_SET(tbpro.assignedBy,resourcelst);
END IF;

IF status="Lost" then
select qut.startDate,qut.accountname,res.Name,tbpro.prospectOpportunityCode,cont.mobile,qut.lossReason from tbquotation qut
left join tbresource res on qut.userID=res.resourceID
left join tbprospectopportunity tbpro on tbpro.prospectOpportunityID = qut.prospectOpportunityID
left join tbcontact cont on cont.contactID = tbpro.contactID
where res.activeStatus='Y' and qut.activeStatus='Y' and tbpro.activeStatus='Y' and qut.quoteStatus = 'L' and FIND_IN_SET(qut.userID,resourcelst);
END IF;

END//


--/****Area Wise Performance Report*******/

DELIMITER //
CREATE PROCEDURE findAreaWisePerformanceReport (IN locale VARCHAR(500), IN frmdate DATE, IN todate DATE, IN resourcelst VARCHAR(500))
BEGIN

select  
(select count(*) from tbprospectopportunity tbpro
where tbpro.activeStatus='Y' and tbpro.dateTime BETWEEN frmdate AND todate 
and FIND_IN_SET(tbpro.localeid,locale)) as Totallead,

(select count(*) from tbprospectopportunity tbpro
left join tblocale loc on loc.localeID = tbpro.localeid
where tbpro.activeStatus='Y' and tbpro.stageID = '1' and tbpro.statusFlag = 'Y'
and tbpro.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(tbpro.localeid,locale)) as Open,

(select count(*) from tbquotation qut
left join tbprospectopportunity tbpro on tbpro.prospectOpportunityID = qut.prospectOpportunityID
where qut.activeStatus='Y' and qut.quoteStatus = 'L' and tbpro.activeStatus = 'Y' 
and qut.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(tbpro.localeid,locale) 
and FIND_IN_SET(tbpro.assignedBy,resourcelst)) as Lost,

(select count(*) from tbquotation qut
left join tbprospectopportunity tbpro on tbpro.prospectOpportunityID = qut.prospectOpportunityID
where qut.activeStatus='Y' and tbpro.activeStatus='Y' and tbpro.stageID = '2' and qut.quoteStatus = '-'
and qut.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(tbpro.localeid,locale)
and FIND_IN_SET(tbpro.assignedBy,resourcelst)) as Undecided,

(select count(*) from tbquotation qut
left join tbprospectopportunity tbpro on tbpro.prospectOpportunityID = qut.prospectOpportunityID
where qut.activeStatus ='Y' and qut.quoteStatus = 'W' and tbpro.activeStatus='Y'
and qut.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(tbpro.localeid,locale)
and FIND_IN_SET(tbpro.assignedBy,resourcelst)) as Won,

(select count(*) from tbquotation qut
left join tbprospectopportunity tbpro on tbpro.prospectOpportunityID = qut.prospectOpportunityID
where qut.activeStatus='Y' and qut.quoteStatus = 'A' and tbpro.activeStatus='Y'
and qut.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(tbpro.localeid,locale)
and FIND_IN_SET(tbpro.assignedBy,resourcelst)) as Postpond,

(select count(*) from tbquotation qut
left join tbprospectopportunity tbpro on tbpro.prospectOpportunityID = qut.prospectOpportunityID
left join tborderacceptancehdr tbohdr on tbohdr.quotationID = qut.quotationID
left join tbinstallations tbinst on tbinst.orderAcceptabceID = tbohdr.orderaccehdrID
where qut.activeStatus='Y' and tbpro.activeStatus='Y' and tbinst.completed = 'Y'
and tbinst.activeStatus = 'Y' and tbohdr.activeStatus = 'Y' and tbohdr.installationsID > 2
and tbinst.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(tbpro.localeid, locale)
and FIND_IN_SET(tbpro.assignedBy,resourcelst)) as Completed,

(select count(*) from tbquotation qut
left join tbprospectopportunity tbpro on tbpro.prospectOpportunityID = qut.prospectOpportunityID
left join tborderacceptancehdr tbohdr on tbohdr.quotationID = qut.quotationID
where qut.activeStatus='Y' and tbpro.activeStatus='Y' and tbohdr.activeStatus = 'Y' 
and tbohdr.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(tbpro.localeid, locale) and
FIND_IN_SET(tbpro.assignedBy,resourcelst) and tbohdr.installationsID IN('1','2')) as UnderInstallation
;
END//



DELIMITER //
CREATE  PROCEDURE getLocaleByCity(IN cityid varchar(11))
BEGIN
select distinct localeid,localeName from tblocality 
where activeStatus='Y' and city = cityid order by localeName asc;
END//


--/////////////Referencers Repport /////////////////////////
DELIMITER //
CREATE PROCEDURE findAllReferncersReport (IN frmdate DATE, IN todate DATE, IN sourcedetailID int(10),IN status VARCHAR(20))
BEGIN

IF status="All" then
select tbpro.prospectOpportunityCode, acc.name ,sdtl.name as refName,tbpro.dateTime,tbpro.statusFlag,pip.stageCode,tbinst.completed from tbprospectopportunity tbpro
left join tbquotation qut on tbpro.prospectOpportunityID = qut.prospectOpportunityID
left join tbaccount acc on tbpro.accountID = acc.accountID
left join tbcampaignDetail sdtl on sdtl.id = tbpro.sourcedetailsID
left join tbpipeline pip on tbpro.stageID = pip.stageID
left join tborderacceptancehdr tbohdr on tbohdr.quotationID = qut.quotationID
left join tbinstallations tbinst on tbinst.orderAcceptabceID = tbohdr.orderaccehdrID
where qut.activeStatus='Y' and tbpro.activeStatus='Y' and sdtl.activeStatus = 'Y'
and tbpro.dateTime BETWEEN frmdate and todate and FIND_IN_SET(tbpro.sourcedetailsID,sourcedetailID);
END IF;

IF status="Open" then
select tbpro.prospectOpportunityCode, acc.name ,sdtl.name as refName,tbpro.dateTime,tbpro.statusFlag,pip.stageCode from tbprospectopportunity tbpro
left join tbaccount acc on tbpro.accountID = acc.accountID
left join tbcampaignDetail sdtl on sdtl.id = tbpro.sourcedetailsID
left join tbpipeline pip on tbpro.stageID = pip.stageID
where tbpro.activeStatus='Y' and tbpro.stageID = '1' and sdtl.activeStatus = 'Y'
and tbpro.dateTime BETWEEN frmdate and todate and FIND_IN_SET(tbpro.sourcedetailsID,sourcedetailID);
END IF;

IF status="Undecided" then
select tbpro.prospectOpportunityCode, acc.name ,sdtl.name as refName,tbpro.dateTime,tbpro.statusFlag,pip.stageCode from tbprospectopportunity tbpro
left join tbquotation qut on tbpro.prospectOpportunityID = qut.prospectOpportunityID
left join tbaccount acc on tbpro.accountID = acc.accountID
left join tbcampaignDetail sdtl on sdtl.id = tbpro.sourcedetailsID
left join tbpipeline pip on tbpro.stageID = pip.stageID
where qut.activeStatus='Y' and tbpro.activeStatus='Y' and tbpro.stageID = '2' and qut.quoteStatus = '-' and sdtl.activeStatus = 'Y'
and tbpro.dateTime BETWEEN frmdate and todate and FIND_IN_SET(tbpro.sourcedetailsID,sourcedetailID);
END IF;

IF status="Won" then
select tbpro.prospectOpportunityCode, acc.name ,sdtl.name as refName,tbpro.dateTime,tbpro.statusFlag,pip.stageCode from tbprospectopportunity tbpro
left join tbquotation qut on tbpro.prospectOpportunityID = qut.prospectOpportunityID
left join tbaccount acc on tbpro.accountID = acc.accountID
left join tbcampaignDetail sdtl on sdtl.id = tbpro.sourcedetailsID
left join tbpipeline pip on tbpro.stageID = pip.stageID
where qut.activeStatus='Y' and tbpro.activeStatus='Y' and qut.quoteStatus = 'W' and sdtl.activeStatus = 'Y'
and tbpro.dateTime BETWEEN frmdate and todate and FIND_IN_SET(tbpro.sourcedetailsID,sourcedetailID);
END IF;

IF status="Lost" then
select tbpro.prospectOpportunityCode, acc.name ,sdtl.name as refName,tbpro.dateTime,tbpro.statusFlag,pip.stageCode from tbprospectopportunity tbpro
left join tbquotation qut on tbpro.prospectOpportunityID = qut.prospectOpportunityID
left join tbaccount acc on tbpro.accountID = acc.accountID
left join tbcampaignDetail sdtl on sdtl.id = tbpro.sourcedetailsID
left join tbpipeline pip on tbpro.stageID = pip.stageID
where qut.activeStatus='Y' and tbpro.activeStatus='Y' and qut.quoteStatus = 'L' and sdtl.activeStatus = 'Y'
and tbpro.dateTime BETWEEN frmdate and todate and FIND_IN_SET(tbpro.sourcedetailsID,sourcedetailID);
END IF;

IF status="Postponed" then
select tbpro.prospectOpportunityCode, acc.name ,sdtl.name as refName,tbpro.dateTime,tbpro.statusFlag,pip.stageCode from tbprospectopportunity tbpro
left join tbquotation qut on tbpro.prospectOpportunityID = qut.prospectOpportunityID
left join tbaccount acc on tbpro.accountID = acc.accountID
left join tbcampaignDetail sdtl on sdtl.id = tbpro.sourcedetailsID
left join tbpipeline pip on tbpro.stageID = pip.stageID
where qut.activeStatus='Y' and tbpro.activeStatus='Y' and qut.quoteStatus = 'A' and sdtl.activeStatus = 'Y'
and tbpro.dateTime BETWEEN frmdate and todate and FIND_IN_SET(tbpro.sourcedetailsID,sourcedetailID);
END IF;

IF status="Completed" then
select tbpro.prospectOpportunityCode, acc.name ,sdtl.name as refName,tbpro.dateTime,tbpro.statusFlag,pip.stageCode,tbinst.completed from tbprospectopportunity tbpro
left join tbquotation qut on tbpro.prospectOpportunityID = qut.prospectOpportunityID
left join tbaccount acc on tbpro.accountID = acc.accountID
left join tbcampaignDetail sdtl on sdtl.id = tbpro.sourcedetailsID
left join tbpipeline pip on tbpro.stageID = pip.stageID
left join tborderacceptancehdr tbohdr on tbohdr.quotationID = qut.quotationID
left join tbinstallations tbinst on tbinst.orderAcceptabceID = tbohdr.orderaccehdrID
where qut.activeStatus='Y' and tbpro.activeStatus='Y' and qut.quoteStatus = 'W' and sdtl.activeStatus = 'Y'
and tbinst.completed = 'Y' and tbinst.activeStatus = 'Y' and tbohdr.activeStatus = 'Y'
and tbpro.dateTime BETWEEN frmdate and todate and FIND_IN_SET(tbpro.sourcedetailsID,sourcedetailID);
END IF;

IF status="Under Installation" then
select tbpro.prospectOpportunityCode, acc.name ,sdtl.name as refName,tbpro.dateTime,tbpro.statusFlag,pip.stageCode,tbinst.completed from tbprospectopportunity tbpro
left join tbquotation qut on tbpro.prospectOpportunityID = qut.prospectOpportunityID
left join tbaccount acc on tbpro.accountID = acc.accountID
left join tbcampaignDetail sdtl on sdtl.id = tbpro.sourcedetailsID
left join tbpipeline pip on tbpro.stageID = pip.stageID
left join tborderacceptancehdr tbohdr on tbohdr.quotationID = qut.quotationID
left join tbinstallations tbinst on tbinst.orderAcceptabceID = tbohdr.orderaccehdrID
where qut.activeStatus='Y' and tbpro.activeStatus='Y' and qut.quoteStatus = 'W' and sdtl.activeStatus = 'Y'
and tbinst.completed = 'N' and tbinst.activeStatus = 'Y' and tbohdr.activeStatus = 'Y'
and tbpro.dateTime BETWEEN frmdate and todate and FIND_IN_SET(tbpro.sourcedetailsID,sourcedetailID);
END IF;
END//

DELIMITER //
CREATE PROCEDURE findTeamByCustomerType (IN cytpeid VARCHAR(10))
BEGIN
select distinct tmaster.teamMasterID,tmaster.teamCode from tbteammaster tmaster
left join tbteamcustomertype tctype on tctype.teamMasterID = tmaster.teamMasterID
where tctype.activeStatus='Y' and tmaster.activeStatus='Y' and FIND_IN_SET(tctype.customertypeID, cytpeid);
END//

DELIMITER //
CREATE PROCEDURE findCustomerTypeByUserid (IN userid int(10))
BEGIN
select distinct tctype.customertypeID from tbteammember tmembr
left join tbteamcustomertype tctype on tctype.teamMasterID = tmembr.teamMasterID
where tctype.activeStatus='Y' and tmembr.activeStatus='Y' and FIND_IN_SET(tmembr.userID, userid);
END//


---------Team Pereformance Report ------------------

DELIMITER //
CREATE PROCEDURE findTeamWisePerformanceReport (IN frmdate DATE, IN todate DATE, IN resource VARCHAR(500))
BEGIN

select 
(select count(*) from tbprospectopportunity tbpro
where tbpro.activeStatus='Y' and tbpro.dateTime BETWEEN frmdate AND todate 
and FIND_IN_SET(tbpro.assignedBy,resource)) as Totallead,

(select count(*) from tbprospectopportunity tbpro
where tbpro.activeStatus='Y' and tbpro.stageID = '1' and tbpro.statusFlag = 'Y'
and tbpro.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(tbpro.assignedBy,resource)) as Open,

(select count(*) from tbprospectopportunity tbpro
where tbpro.activeStatus='Y' and tbpro.statusFlag = 'L'
and tbpro.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(tbpro.assignedBy,resource) 
) as Lost,

(select count(*) from tbprospectopportunity tbpro
where tbpro.activeStatus='Y' and tbpro.stageID = '2' and tbpro.statusFlag = 'Y'
and tbpro.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(tbpro.assignedBy,resource)) as Undecided,

(select count(*) from tbprospectopportunity tbpro
where tbpro.activeStatus='Y' and tbpro.statusFlag = 'W'
and tbpro.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(tbpro.assignedBy,resource)
) as Won,

(select count(*) from tbprospectopportunity tbpro
where tbpro.activeStatus='Y' and tbpro.statusFlag = 'A'
and tbpro.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(tbpro.assignedBy,resource)
) as Postpond,

(select count(*) from tbquotation qut
left join tbprospectopportunity tbpro on tbpro.prospectOpportunityID = qut.prospectOpportunityID
left join tborderacceptancehdr tbohdr on tbohdr.quotationID = qut.quotationID
left join tbinstallations tbinst on tbinst.orderAcceptabceID = tbohdr.orderaccehdrID
where qut.activeStatus='Y' and tbpro.activeStatus='Y' and tbinst.completed = 'Y'
and tbinst.activeStatus = 'Y' and tbohdr.activeStatus = 'Y' and tbohdr.installationsID > 2
and tbinst.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(tbpro.assignedBy,resource)
) as Completed,

(select count(*) from tbquotation qut
left join tbprospectopportunity tbpro on tbpro.prospectOpportunityID = qut.prospectOpportunityID
left join tborderacceptancehdr tbohdr on tbohdr.quotationID = qut.quotationID
where qut.activeStatus='Y' and tbpro.activeStatus='Y' and tbohdr.activeStatus = 'Y' 
and tbohdr.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(tbpro.assignedBy,resource) and
tbohdr.installationsID IN('1','2')) as UnderInstallation
;
END//

/////Stored Procedure for open/close service enquiries report////
-- and FIND_IN_SET(qut.assignedto,resource)

--DELIMITER //
--CREATE PROCEDURE findOpenCloseServiceEnquiry (IN frmdate DATE, IN todate DATE, IN resource VARCHAR(1000), IN status VARCHAR(20))
--BEGIN
--
--IF status="Open" then
--select servicecallentry.dateTime,acc.name,res.Name as resname,servicecallentry.serviceCallNo,acc.telephone1,
--servicecallentry.callStatus, qut.invoicesend from tbservicecallentry servicecallentry
--left join tbaccount acc on servicecallentry.accountID = acc.accountID
--left join tbresource res on servicecallentry.assignedBy = res.resourceID
--left join tbsparequotation qut on qut.servicecallID = servicecallentry.serviceCallID
--where qut.servicecallID IS NULL and servicecallentry.activeStatus = 'Y' and acc.activeStatus = 'Y' and 
--res.activeStatus = 'Y' and servicecallentry.callStatus = 'Y' 
--and servicecallentry.dateTime Between frmdate and todate ;
--END IF;
--
--IF status="In Progress" then
--select servicecallentry.dateTime,acc.name,res.Name as resname,servicecallentry.serviceCallNo,acc.telephone1,
--servicecallentry.callStatus, qut.invoicesend from tbservicecallentry servicecallentry
--left join tbaccount acc on servicecallentry.accountID = acc.accountID
--left join tbresource res on servicecallentry.assignedBy = res.resourceID
--left join tbsparequotation qut on qut.servicecallID = servicecallentry.serviceCallID
--left join tbsparequotationproduct squt on squt.quotationID = qut.quotationid
--where squt.quotationID IS NULL and servicecallentry.activeStatus = 'Y' and acc.activeStatus = 'Y' and 
--res.activeStatus = 'Y' and servicecallentry.callStatus = 'Y' and qut.invoicesend = 'N'
--and servicecallentry.dateTime Between frmdate and todate 
--and FIND_IN_SET(servicecallentry.assignedBy,resource);
--END IF;
--
--IF status="Rejected" then
--select servicecallentry.dateTime,acc.name,res.Name as resname,servicecallentry.serviceCallNo,acc.telephone1,
--servicecallentry.callStatus, qut.invoicesend from tbservicecallentry servicecallentry
--left join tbaccount acc on servicecallentry.accountID = acc.accountID
--left join tbresource res on servicecallentry.assignedBy = res.resourceID
--left join tbsparequotation qut on qut.servicecallID = servicecallentry.serviceCallID
--where servicecallentry.activeStatus = 'Y' and acc.activeStatus = 'Y' and 
--res.activeStatus = 'Y' and qut.activeStatus = 'Y' and servicecallentry.callStatus = 'N'
--and qut.invoicesend = 'N' and servicecallentry.dateTime Between frmdate and todate
--and FIND_IN_SET(servicecallentry.assignedBy,resource);
--END IF;
--END//

--/////Stored Procedure for open/close service enquiries report(All)////
--DELIMITER //
--CREATE PROCEDURE findAllServiceEnquiryReport(IN frmdate date,IN todate date,IN resource varchar(1000))
--BEGIN
--select servicecallentry.callDate,acc.name,res.Name as resname,servicecallentry.serviceCallNo,acc.telephone1,
--servicecallentry.callStatus from tbservicecallentry servicecallentry
--left join tbaccount acc on servicecallentry.accountID = acc.accountID
--left join tbresource res on servicecallentry.assignedBy = res.resourceID
--where servicecallentry.activeStatus = 'Y' and acc.activeStatus = 'Y' and
--res.activeStatus = 'Y' and servicecallentry.dateTime Between frmdate and todate and FIND_IN_SET(servicecallentry.assignedBy,resource);
--END// 

DELIMITER //
CREATE PROCEDURE findCloseServiceEnquiry (IN frmdate DATE, IN todate datetime, IN resource VARCHAR(1000), IN status VARCHAR(20))
BEGIN

IF status="In Progress" then
select servicecallentry.dateTime,acc.name,res.Name as resname,servicecallentry.serviceCallNo,acc.telephone1,
servicecallentry.callStatus, qut.invoicesend,loc.localityName from tbservicecallentry servicecallentry
left join tbaccount acc on servicecallentry.accountID = acc.accountID
left join tblocality loc on servicecallentry.localityID=loc.localityID
left join tbresource res on servicecallentry.assignedBy = res.resourceID
left join tbsparequotation qut on qut.servicecallID = servicecallentry.serviceCallID
where servicecallentry.activeStatus = 'Y' and acc.activeStatus = 'Y' and 
res.activeStatus = 'Y' and servicecallentry.callStatus = 'Y' and qut.invoicesend = 'N'
and qut.activityflag = 'Q' and servicecallentry.dateTime Between frmdate and todate 
and FIND_IN_SET(qut.assignedto,resource);
END IF;

IF status="Rejected" then
select servicecallentry.dateTime,acc.name,res.Name as resname,servicecallentry.serviceCallNo,acc.telephone1,
servicecallentry.callStatus, qut.invoicesend,loc.localityName from tbservicecallentry servicecallentry
left join tbaccount acc on servicecallentry.accountID = acc.accountID
left join tblocality loc on servicecallentry.localityID=loc.localityID
left join tbresource res on servicecallentry.assignedBy = res.resourceID
left join tbsparequotation qut on qut.servicecallID = servicecallentry.serviceCallID
where servicecallentry.activeStatus = 'Y' and acc.activeStatus = 'Y' and 
res.activeStatus = 'Y' and qut.activeStatus = 'Y' and servicecallentry.callStatus = 'N'
and qut.invoicesend = 'N' and servicecallentry.dateTime Between frmdate and todate
and FIND_IN_SET(servicecallentry.assignedBy,resource);
END IF;
END//


DELIMITER //
CREATE PROCEDURE findAssignedOpenServiceEnquiry (IN frmdate DATE, IN todate datetime, IN resource VARCHAR(1000), IN status VARCHAR(20))
BEGIN
select servicecallentry.dateTime,acc.name,res.Name as resname,servicecallentry.serviceCallNo,acc.telephone1,
servicecallentry.callStatus, qut.invoicesend,loc.localityName from tbservicecallentry servicecallentry
left join tbaccount acc on servicecallentry.accountID = acc.accountID
left join tbresource res on servicecallentry.assignedBy = res.resourceID
left join tbsparequotation qut on qut.servicecallID = servicecallentry.serviceCallID
left join tblocality loc on servicecallentry.localityID=loc.localityID
where qut.activityflag = 'A' and servicecallentry.activeStatus = 'Y' and acc.activeStatus = 'Y' and 
res.activeStatus = 'Y' and servicecallentry.callStatus = 'Y' 
and servicecallentry.dateTime Between frmdate and todate and FIND_IN_SET(servicecallentry.assignedBy,resource);
END//

DELIMITER //
CREATE PROCEDURE findOpenServiceEnquiry (IN frmdate DATE, IN todate datetime, IN resource VARCHAR(1000), IN status VARCHAR(20))
BEGIN
select servicecallentry.dateTime,acc.name,res.Name as resname,servicecallentry.serviceCallNo,acc.telephone1,
servicecallentry.callStatus, qut.invoicesend,loc.localityName from tbservicecallentry servicecallentry
left join tbaccount acc on servicecallentry.accountID = acc.accountID
left join tbresource res on servicecallentry.assignedBy = res.resourceID
left join tbsparequotation qut on qut.servicecallID = servicecallentry.serviceCallID
left join tblocality loc on servicecallentry.localityID=loc.localityID
where qut.servicecallID IS NULL and servicecallentry.activeStatus = 'Y' and acc.activeStatus = 'Y' and 
res.activeStatus = 'Y' and servicecallentry.callStatus = 'Y' 
and servicecallentry.dateTime Between frmdate and todate and FIND_IN_SET(servicecallentry.assignedBy,resource);
END//

--------------------------------Service Completed Enquiers Report ------------------------------------

DELIMITER //
CREATE PROCEDURE findEngineerWiseServiceQuoDtlReport (IN frmdate DATE, IN todate DATE, IN resourcelst VARCHAR(500))
BEGIN
select qut.dateTime,qut.accountname,qut.totalAmount,res.Name,tbscall.serviceCallNo,qut.closecall,qut.invoicesend,qut.observationandanalysis, qut.quotationid,loc.localityName from tbsparequotation qut
left join tbresource res on qut.userID=res.resourceID
left join tbservicecallentry tbscall on tbscall.serviceCallID = qut.servicecallID
left join tblocality loc on tbscall.localityID = loc.localityID
where res.activeStatus = 'Y' and qut.activeStatus = 'Y' and tbscall.activeStatus = 'Y' 
and qut.invoicesend = 'Y' and qut.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(qut.userID,resourcelst);
END//

---------------------------------------------------------------------------------------------------------
DELIMITER //
CREATE PROCEDURE findEngineerWiseServiceQuoDtl(IN quotatioid varchar(10))
BEGIN
select spare.code,qutProd.quantity,qutProd.amount,qutProd.uom,qutProd.spareid,prod.productCode from tbsparequotationproduct qutProd
left join tbspare spare on spare.id = qutProd.spareid
left join tbproduct prod on prod.productID = qutProd.productID
where qutProd.activeStatus='Y' and spare.activeStatus = 'Y' and FIND_IN_SET(qutProd.quotationID,quotatioid);
END//

---------------------------------------------------------------------------------------------------------
DELIMITER //
CREATE PROCEDURE findServiceproductSummary(IN productlst VARCHAR(1000), IN resource VARCHAR(500), IN frmdate DATE, IN todate DATE ,IN id VARCHAR(16383))
BEGIN
select spare.code, SUM(qutProd.quantity),SUM(qutProd.amount) from tbsparequotationproduct qutProd
left join tbspare spare on spare.id = qutProd.spareid
where qutProd.activeStatus='Y' and qutProd.dateTime BETWEEN frmdate AND todate 
and FIND_IN_SET(qutProd.userID,resource) and FIND_IN_SET(qutProd.spareid,productlst)
and FIND_IN_SET(qutProd.quotationID,id) group by spare.code order by spare.code Asc;
END//

--------------------------------Service Team Performance Report ------------------------------------
DELIMITER //
CREATE PROCEDURE findPerformanceReportOfService (IN frmdate DATE, IN todate DATE, IN resource VARCHAR(500))
BEGIN

select 
(select count(*) from tbservicecallentry tbser
where tbser.activeStatus='Y' and tbser.dateTime BETWEEN frmdate AND todate 
and FIND_IN_SET(tbser.assignedBy,resource)) as Totallead,

(select count(*) from tbservicecallentry tbser
left join tbsparequotation qut on qut.servicecallID = tbser.serviceCallID
where qut.servicecallID IS NULL and tbser.activeStatus='Y' and tbser.callStatus = 'Y'
and tbser.dateTime BETWEEN frmdate AND todate and
FIND_IN_SET(tbser.assignedBy,resource)) as Open,

(select count(*) from tbservicecallentry tbser
left join tbsparequotation qut on qut.servicecallID = tbser.serviceCallID
where tbser.activeStatus='Y' and qut.activeStatus = 'Y' and qut.activityflag = 'A' and tbser.callStatus = 'Y'
and qut.invoicesend = 'N' and tbser.dateTime BETWEEN frmdate AND todate and
FIND_IN_SET(tbser.assignedBy,resource)) as OpenAssigned,

(select count(*) from tbservicecallentry tbser
left join tbsparequotation qut on qut.servicecallID = tbser.serviceCallID
where tbser.activeStatus='Y' and tbser.callStatus = 'Y' and qut.invoicesend = 'N'
and qut.activityflag = 'Q' and tbser.dateTime BETWEEN frmdate AND todate and
FIND_IN_SET(tbser.assignedBy,resource)) as Inprogress,
 
(select count(*) from tbservicecallentry tbser
left join tbsparequotation qut on qut.servicecallID = tbser.serviceCallID
where tbser.activeStatus='Y' and qut.activeStatus = 'Y' and tbser.callStatus = 'N'
and qut.invoicesend = 'N' and tbser.dateTime BETWEEN frmdate AND 
todate and FIND_IN_SET(tbser.assignedBy,resource)) as Rejected,

(select count(*) from tbservicecallentry tbser
left join tbsparequotation qut on qut.servicecallID = tbser.serviceCallID
where tbser.activeStatus='Y' and qut.activeStatus = 'Y' and tbser.callStatus = 'N'
and qut.invoicesend = 'Y' and tbser.dateTime BETWEEN frmdate AND 
todate and FIND_IN_SET(tbser.assignedBy,resource)) as Completed
;
END//

-----------------------------------------------------------------------------------------------------------

--findEngineerWiseServiceQuoDtlReport

DELIMITER //
CREATE PROCEDURE getLocaleByTeam(IN teamid varchar(11))
BEGIN
select loc.localeid,loc.localeName from tbteammaster teammstr
left join tbteamarea tbarea on tbarea.teamMasterID = teammstr.teamMasterID
left join tblocale loc on tbarea.localeid = loc.localeID
where tbarea.activeStatus = 'Y' and teammstr.activeStatus = 'Y'
and loc.activeStatus = 'Y' and FIND_IN_SET(teammstr.teamMasterID,teamid);
END//
----------------------------------------update  getLocaleByCity
DELIMITER //
CREATE  PROCEDURE getLocaleByCity(IN cityid varchar(500))
BEGIN
select distinct tbloc.localeid,tbloc.localeName from tbprospectopportunity tbpro
left join tblocality tbloc on  tbloc.localeid =tbpro.localeID
left join tbresource res on res.resourceID = tbpro.assignedBy
where tbpro.activeStatus ='Y' and tbloc.activeStatus='Y' and FIND_IN_SET(tbpro.localeID,locale) and FIND_IN_SET(tbpro.assignedBy,resourcelst) and city = cityid order by localeName asc;
END//
--------------------------------------------findByResorceforReport(
DELIMITER //
CREATE  PROCEDURE findLocationsByResource(IN resourceID varchar(500))
BEGIN
select distinct loc.localeID,loc.localeName from tbresourcelocationrights tree
left join tbresource res on res.resourceID = tree.assignBy
left join tblocale loc on loc.localeID = tree.localeID
where loc.activeStatus='Y'and res.activeStatus='Y'and tree.activeStatus ='Y'
and FIND_IN_SET(tree.assignBy,resourceID);
END//
---------------------------------------------updated findEngineerWiseQuoReport-----------
DELIMITER //
CREATE PROCEDURE findEngineerWiseQuoReport(IN resourcelst varchar(500),IN status varchar(10))
BEGIN

IF status="Open" then
select tbpro.dateTime,acc.name as accName,res.Name,tbpro.prospectOpportunityCode,tbpro.statusFlag,cont.mobile,loc.localityName from tbprospectopportunity tbpro
left join tbresource res on tbpro.assignedBy =res.resourceID
left join tbaccount acc on acc.accountID = tbpro.accountID
left join tblocality loc on loc.localityID = tbpro.localityID
left join tbcontact cont on cont.contactID = tbpro.contactID
where res.activeStatus='Y' and tbpro.activeStatus='Y' and tbpro.stageID = '1' and tbpro.statusFlag = 'Y'
and cont.activeStatus = 'Y' and loc.activeStatus = 'Y' and acc.activeStatus = 'Y' and FIND_IN_SET(tbpro.assignedBy,resourcelst);
END IF;

IF status="Lost" then
select qut.startDate,qut.accountname,res.Name,tbpro.prospectOpportunityCode,tbpro.statusFlag,cont.mobile,qut.lossReason from tbquotation qut
left join tbresource res on qut.userID=res.resourceID
left join tbprospectopportunity tbpro on tbpro.prospectOpportunityID = qut.prospectOpportunityID
left join tbcontact cont on cont.contactID = tbpro.contactID
where res.activeStatus='Y' and qut.activeStatus='Y' and tbpro.activeStatus='Y' and qut.quoteStatus = 'L' or qut.quoteStatus = 'A' and FIND_IN_SET(qut.userID,resourcelst);
END IF;

END//
----------------------

DELIMITER //
CREATE  PROCEDURE findLocationsByResource1(IN resource int(11))
BEGIN
select distinct loc.localeID,loc.localeName from tbresourcelocationrights tree
left join tbresource res on res.resourceID = tree.assignBy
left join tblocality loc on loc.localeID = tree.localeID
where  tree.activeStatus ='Y'and FIND_IN_SET(tree.assignBy,resource);
END//
----------------------------Area wise Update--------
DELIMITER //
CREATE PROCEDURE findAreaWisePerformanceReport (IN locale VARCHAR(500), IN frmdate DATE, IN todate DATE, IN resourcelst varchar(5000) )
BEGIN
select distinct 
(select count(*) from tbprospectopportunity tbpro
left join tbresource res on res.resourceID = tbpro.assignedBy
where tbpro.activeStatus='Y' and tbpro.dateTime BETWEEN frmdate AND todate
and FIND_IN_SET(tbpro.localeid,locale)
and FIND_IN_SET(tbpro.assignedBy,resourcelst)) as Totallead,

(select  count(*) from tbprospectopportunity tbpro
where tbpro.dateTime BETWEEN frmdate AND todate and tbpro.prospectOpportunityID not in(select tbquotation.prospectOpportunityID from tbquotation) and tbpro.activeStatus='Y'  and tbpro.statusFlag = 'Y'
and FIND_IN_SET(tbpro.localeid,locale) and FIND_IN_SET(tbpro.assignedBy,resourcelst)) as Open,

(select count(*) from tbquotation qut
left join tbprospectopportunity tbpro on tbpro.prospectOpportunityID = qut.prospectOpportunityID
where tbpro.dateTime BETWEEN frmdate AND todate and qut.activeStatus='Y'  and qut.quoteStatus = '-'
and FIND_IN_SET(tbpro.localeid,locale)
and FIND_IN_SET(tbpro.assignedBy,resourcelst)) as Undecided,

(select count(*) from tbquotation qut
left join tbprospectopportunity tbpro on tbpro.prospectOpportunityID = qut.prospectOpportunityID
where qut.activeStatus='Y' and qut.quoteStatus = 'L'and qut.quoteStatus='C' and tbpro.activeStatus = 'Y' 
and tbpro.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(tbpro.localeid,locale) 
and FIND_IN_SET(tbpro.assignedBy,resourcelst)) as Lost,


(select count(*)from tbquotation qut
left join tbprospectopportunity tbpro on tbpro.prospectOpportunityID = qut.prospectOpportunityID
where tbpro.activeStatus ='Y' and qut.quoteStatus = 'W' and tbpro.activeStatus='Y'
and tbpro.dateTime BETWEEN frmdate AND todate  and qut.quotationID not in(select tborderacceptancehdr.quotationID from tborderacceptancehdr)
and FIND_IN_SET(tbpro.localeid,locale)
and FIND_IN_SET(tbpro.assignedBy,resourcelst)) as Won,

(select count(*) from tbquotation qut
left join tbprospectopportunity tbpro on tbpro.prospectOpportunityID = qut.prospectOpportunityID
where tbpro.dateTime BETWEEN frmdate AND todate 
 and qut.activeStatus='Y' and qut.quoteStatus = 'A' and tbpro.activeStatus='Y'
 and FIND_IN_SET(tbpro.localeid,locale)
and FIND_IN_SET(tbpro.assignedBy,resourcelst)) as Postpond,

(select  count(*) from tbquotation qut
left join tbprospectopportunity tbpro on tbpro.prospectOpportunityID = qut.prospectOpportunityID
left join tborderacceptancehdr tbohdr on tbohdr.quotationID = qut.quotationID
left join tbinstallations tbinst on tbinst.orderAcceptabceID = tbohdr.orderaccehdrID
where tbpro.dateTime BETWEEN frmdate AND todate and qut.activeStatus='Y' and tbpro.activeStatus='Y' and tbinst.completed = 'Y'
and tbinst.activeStatus = 'Y' and tbohdr.activeStatus = 'Y' and tbohdr.installationsID > 2
and FIND_IN_SET(tbpro.localeid,locale)
and FIND_IN_SET(tbpro.assignedBy,resourcelst)) as Completed,

(select count(*) from tbquotation qut
left join tbprospectopportunity tbpro on tbpro.prospectOpportunityID = qut.prospectOpportunityID
left join tborderacceptancehdr tbohdr on tbohdr.quotationID = qut.quotationID
left join tbinstallations tbinst on tbinst.orderAcceptabceID = tbohdr.orderaccehdrID
left join tbresource res on res.resourceID = tbpro.assignedBy 
where  tbpro.dateTime BETWEEN frmdate AND todate
and qut.activeStatus='Y' and tbpro.activeStatus='Y' and tbohdr.activeStatus = 'Y' 
  and FIND_IN_SET(tbpro.localeid,locale) and
  FIND_IN_SET(tbpro.assignedBy,resourcelst) and tbohdr.installationsID IN('1','2')) as UnderInstallation
;
END//

----------------------updated----------findTeamWisePerformanceReport------------------------ 
CREATE PROCEDURE findTeamWisePerformanceReport (IN frmdate DATE, IN todate DATE, IN resource VARCHAR(500)) 
BEGIN  
select distinct  
(select count(*) from tbprospectopportunity tbpro left join tbresource res on res.resourceID = tbpro.assignedBy where tbpro.activeStatus='Y' and tbpro.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(tbpro.assignedBy,resource)) as Totallead, 

 (select count(*) from tbprospectopportunity tbpro left join tbresource res on res.resourceID = tbpro.assignedBy where  tbpro.prospectOpportunityID not in(select tbquotation.prospectOpportunityID from tbquotation)  and tbpro.activeStatus='Y'  and tbpro.statusFlag = 'Y' and tbpro.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(tbpro.assignedBy,resource)) as Open, 
 
  (select count(*) from tbquotation qut left join tbprospectopportunity tbpro on tbpro.prospectOpportunityID = qut.prospectOpportunityID where qut.quotationID not in(select tborderacceptancehdr.quotationID from tborderacceptancehdr) and tbpro.activeStatus='Y' and tbpro.statusFlag = 'L' and tbpro.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(tbpro.assignedBy,resource)  ) as Lost, 
  
   (select count(*) from tbquotation qut left join tbprospectopportunity tbpro on tbpro.prospectOpportunityID = qut.prospectOpportunityID where qut.quotationID not in(select tborderacceptancehdr.quotationID from tborderacceptancehdr)  and tbpro.activeStatus='Y'   and qut.quoteStatus ='-' and tbpro.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(tbpro.assignedBy,resource)) as Undecided, 
    
   (select count(*) from tbquotation qut left join tbprospectopportunity tbpro on tbpro.prospectOpportunityID = qut.prospectOpportunityID where qut.quotationID not in(select tborderacceptancehdr.quotationID from tborderacceptancehdr) and tbpro.activeStatus='Y' and tbpro.statusFlag = 'W' and tbpro.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(tbpro.assignedBy,resource) ) as Won, 
    
   (select count(*) from tbquotation qut left join tbprospectopportunity tbpro on tbpro.prospectOpportunityID = qut.prospectOpportunityID where tbpro.activeStatus='Y' and tbpro.statusFlag = 'A' and tbpro.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(tbpro.assignedBy,resource) ) as Postpond, 
    
   (select count(*) from tbquotation qut left join tbprospectopportunity tbpro on tbpro.prospectOpportunityID = qut.prospectOpportunityID left join tborderacceptancehdr tbohdr on tbohdr.quotationID = qut.quotationID left join tbinstallations tbinst on tbinst.orderAcceptabceID = tbohdr.orderaccehdrID left join tbresource res on res.resourceID = tbpro.assignedBy where qut.activeStatus='Y' and tbpro.activeStatus='Y' and tbinst.completed = 'Y' and tbinst.activeStatus = 'Y' and tbohdr.activeStatus = 'Y' and tbohdr.installationsID > 2 and tbpro.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(tbpro.assignedBy,resource) ) as Completed, 
   
    (select count(*) from tbquotation qut left join tbprospectopportunity tbpro on tbpro.prospectOpportunityID = qut.prospectOpportunityID left join tborderacceptancehdr tbohdr on tbohdr.quotationID = qut.quotationID left join tbinstallations tbinst on tbinst.orderAcceptabceID = tbohdr.orderaccehdrID left join tbresource res on res.resourceID = tbpro.assignedBy where qut.activeStatus='Y' and tbpro.activeStatus='Y' and tbohdr.activeStatus = 'Y'  and tbpro.dateTime BETWEEN frmdate AND todate and FIND_IN_SET(tbpro.assignedBy,resource) and tbohdr.installationsID IN('1','2')) as UnderInstallation ;
 END//





-------remain to server update ------------
---------findEngineerWiseQuoReport(1022)-----
------------findProdCatByBranch(253)-----------
------------findLocationsByResource1(1048)-----------

