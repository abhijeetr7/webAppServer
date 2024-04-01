package com.backend.webappserver.payload;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ResourceModel {
	private Integer srno;
	private String name;
	private Integer key;
	private Integer resourceID;
	private Integer designationID;
	private Integer deptID;
	private String activeStatus;
	private String branchname;
	private String activestatus;
	private String designationName;
	private String deptName;
	private Integer reportsToID;
	private Double costRate;
	private String createddate;
	private String email;
	private String telephone;
	private String mobile;
	private String activeInactive;
	private String loginName;
	private String password;
	private Date birthdate;
	private String accesstype;
	private boolean showinchkselect;
	private boolean isadmincheck;
	private boolean seflag;
	private Integer usergroupid;
	private String imeinumber;
	private String vehicletype;
	private String usergroup;
	private Integer branchid;
	private Integer id;
	private String salutation;
	private String department;
	private String reportstoname;
	private Date dateTime;
	private String status;
	private String message;
	private Date expencestartdate;
	private Date expencestartseconddate;
	private Integer userprefix;
	private Integer userid;
	private Integer userPrefixId;

	private String regionname;
	private Integer regionid;
	private String regionString;

	private boolean chkselectres;
	private Integer hierarchy;
	private Integer callEscalationDays;
	private boolean approval;
	private BigDecimal discount;
	
	private Integer salelocationid;
	private Integer spalocationid;
	private String sparelocationname;
	private String salelocationname;
	private String customervalue;
	private boolean chkassignto;
	private Integer cityid;
	private boolean allLocaleInRegion;
	private Integer pageno;
	private Integer dealeid;
	private Integer reportingmanager;
	private String resourceName;
	private String iandiAndkpicreatemaxdate;

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public Integer getDealeid() {
		return dealeid;
	}

	public void setDealeid(Integer dealeid) {
		this.dealeid = dealeid;
	}

	List<ResourceModel> resmodel = new ArrayList<ResourceModel>();
	List<DropdownModel> deptlst = new ArrayList<DropdownModel>();
	List<DropdownModel> desiglst = new ArrayList<DropdownModel>();
	List<DropdownModel> reportingtolst = new ArrayList<DropdownModel>();
	List<DropdownModel> activeinaclst = new ArrayList<DropdownModel>();
	List<DropdownModel> branlst = new ArrayList<DropdownModel>();
	List<DropdownModel> usergrolst = new ArrayList<DropdownModel>();

	List<ResourceModel> regionlst = new ArrayList<ResourceModel>();
	

	List<Integer> savedlocale = new ArrayList<Integer>();
	List<Integer> unsavedlocale = new ArrayList<Integer>();


	List<ResourceModel> lstuser = new ArrayList<ResourceModel>();



	List<DropdownModel> sparelocationlst = new ArrayList<DropdownModel>();
	List<Integer> regionNumlst = new ArrayList<Integer>();

	public List<DropdownModel> getSparelocationlst() {
		return sparelocationlst;
	}

	public void setSparelocationlst(List<DropdownModel> sparelocationlst) {
		this.sparelocationlst = sparelocationlst;
	}

	
	public boolean isChkselectres() {
		return chkselectres;
	}

	public void setChkselectres(boolean chkselectres) {
		this.chkselectres = chkselectres;
	}

	public Integer getHierarchy() {
		return hierarchy;
	}

	public void setHierarchy(Integer hierarchy) {
		this.hierarchy = hierarchy;
	}

	public Integer getCallEscalationDays() {
		return callEscalationDays;
	}

	public void setCallEscalationDays(Integer callEscalationDays) {
		this.callEscalationDays = callEscalationDays;
	}

	public boolean isApproval() {
		return approval;
	}

	public void setApproval(boolean approval) {
		this.approval = approval;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	

	public List<Integer> getSavedlocale() {
		return savedlocale;
	}

	public void setSavedlocale(List<Integer> savedlocale) {
		this.savedlocale = savedlocale;
	}

	public List<Integer> getUnsavedlocale() {
		return unsavedlocale;
	}

	public void setUnsavedlocale(List<Integer> unsavedlocale) {
		this.unsavedlocale = unsavedlocale;
	}

	public List<ResourceModel> getRegionlst() {
		return regionlst;
	}

	public void setRegionlst(List<ResourceModel> regionlst) {
		this.regionlst = regionlst;
	}

	public String getRegionname() {
		return regionname;
	}

	public void setRegionname(String regionname) {
		this.regionname = regionname;
	}

	public Integer getRegionid() {
		return regionid;
	}

	public void setRegionid(Integer regionid) {
		this.regionid = regionid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActivestatus() {
		return activestatus;
	}

	public void setActivestatus(String activestatus) {
		this.activestatus = activestatus;
	}

	public Integer getDesignationID() {
		return designationID;
	}

	public void setDesignationID(Integer designationID) {
		this.designationID = designationID;
	}

	public Integer getDeptID() {
		return deptID;
	}

	public void setDeptID(Integer deptID) {
		this.deptID = deptID;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getBranchname() {
		return branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	public List<ResourceModel> getResmodel() {
		return resmodel;
	}

	public void setResmodel(List<ResourceModel> resmodel) {
		this.resmodel = resmodel;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Integer getResourceID() {
		return resourceID;
	}

	public void setResourceID(Integer resourceID) {
		this.resourceID = resourceID;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getAccesstype() {
		return accesstype;
	}

	public void setAccesstype(String accesstype) {
		this.accesstype = accesstype;
	}

	public boolean isShowinchkselect() {
		return showinchkselect;
	}

	public void setShowinchkselect(boolean showinchkselect) {
		this.showinchkselect = showinchkselect;
	}

	public boolean isIsadmincheck() {
		return isadmincheck;
	}

	public void setIsadmincheck(boolean isadmincheck) {
		this.isadmincheck = isadmincheck;
	}

	public Integer getUsergroupid() {
		return usergroupid;
	}

	public void setUsergroupid(Integer usergroupid) {
		this.usergroupid = usergroupid;
	}

	public String getImeinumber() {
		return imeinumber;
	}

	public void setImeinumber(String imeinumber) {
		this.imeinumber = imeinumber;
	}

	public String getVehicletype() {
		return vehicletype;
	}

	public void setVehicletype(String vehicletype) {
		this.vehicletype = vehicletype;
	}

	public Double getCostRate() {
		return costRate;
	}

	public void setCostRate(Double costRate) {
		this.costRate = costRate;
	}

	public Integer getReportsToID() {
		return reportsToID;
	}

	public void setReportsToID(Integer reportsToID) {
		this.reportsToID = reportsToID;
	}

	public List<DropdownModel> getDeptlst() {
		return deptlst;
	}

	public void setDeptlst(List<DropdownModel> deptlst) {
		this.deptlst = deptlst;
	}

	public Integer getKey() {
		return key;
	}

	public void setKey(Integer key) {
		this.key = key;
	}

	public List<DropdownModel> getDesiglst() {
		return desiglst;
	}

	public void setDesiglst(List<DropdownModel> desiglst) {
		this.desiglst = desiglst;
	}

	public List<DropdownModel> getReportingtolst() {
		return reportingtolst;
	}

	public void setReportingtolst(List<DropdownModel> reportingtolst) {
		this.reportingtolst = reportingtolst;
	}

	public List<DropdownModel> getActiveinaclst() {
		return activeinaclst;
	}

	public void setActiveinaclst(List<DropdownModel> activeinaclst) {
		this.activeinaclst = activeinaclst;
	}

	public List<DropdownModel> getBranlst() {
		return branlst;
	}

	public void setBranlst(List<DropdownModel> branlst) {
		this.branlst = branlst;
	}

	public List<DropdownModel> getUsergrolst() {
		return usergrolst;
	}

	public void setUsergrolst(List<DropdownModel> usergrolst) {
		this.usergrolst = usergrolst;
	}

	public String getUsergroup() {
		return usergroup;
	}

	public void setUsergroup(String usergroup) {
		this.usergroup = usergroup;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getReportstoname() {
		return reportstoname;
	}

	public void setReportstoname(String reportstoname) {
		this.reportstoname = reportstoname;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getExpencestartdate() {
		return expencestartdate;
	}

	public void setExpencestartdate(Date expencestartdate) {
		this.expencestartdate = expencestartdate;
	}

	public Date getExpencestartseconddate() {
		return expencestartseconddate;
	}

	public void setExpencestartseconddate(Date expencestartseconddate) {
		this.expencestartseconddate = expencestartseconddate;
	}

	public String getActiveInactive() {
		return activeInactive;
	}

	public void setActiveInactive(String activeInactive) {
		this.activeInactive = activeInactive;
	}

	public Integer getSrno() {
		return srno;
	}

	public void setSrno(Integer srno) {
		this.srno = srno;
	}

	public Integer getBranchid() {
		return branchid;
	}

	public void setBranchid(Integer branchid) {
		this.branchid = branchid;
	}

	public Integer getUserprefix() {
		return userprefix;
	}

	public void setUserprefix(Integer userprefix) {
		this.userprefix = userprefix;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getRegionString() {
		return regionString;
	}

	public void setRegionString(String regionString) {
		this.regionString = regionString;
	}

	public List<ResourceModel> getLstuser() {
		return lstuser;
	}

	public void setLstuser(List<ResourceModel> lstuser) {
		this.lstuser = lstuser;
	}

	public boolean isSeflag() {
		return seflag;
	}

	public void setSeflag(boolean seflag) {
		this.seflag = seflag;
	}

	public Integer getUserPrefixId() {
		return userPrefixId;
	}

	public void setUserPrefixId(Integer userPrefixId) {
		this.userPrefixId = userPrefixId;
	}

	public String getCustomervalue() {
		return customervalue;
	}

	public void setCustomervalue(String customervalue) {
		this.customervalue = customervalue;
	}

	public String getSalelocationname() {
		return salelocationname;
	}

	public void setSalelocationname(String salelocationname) {
		this.salelocationname = salelocationname;
	}

	public String getSparelocationname() {
		return sparelocationname;
	}

	public void setSparelocationname(String sparelocationname) {
		this.sparelocationname = sparelocationname;
	}

	public Integer getSpalocationid() {
		return spalocationid;
	}

	public void setSpalocationid(Integer spalocationid) {
		this.spalocationid = spalocationid;
	}

	public Integer getSalelocationid() {
		return salelocationid;
	}

	public void setSalelocationid(Integer salelocationid) {
		this.salelocationid = salelocationid;
	}

	public boolean isChkassignto() {
		return chkassignto;
	}

	public void setChkassignto(boolean chkassignto) {
		this.chkassignto = chkassignto;
	}

	
	public Integer getCityid() {
		return cityid;
	}

	public void setCityid(Integer cityid) {
		this.cityid = cityid;
	}

	

	public List<Integer> getRegionNumlst() {
		return regionNumlst;
	}

	public void setRegionNumlst(List<Integer> regionNumlst) {
		this.regionNumlst = regionNumlst;
	}

	public boolean isAllLocaleInRegion() {
		return allLocaleInRegion;
	}

	public void setAllLocaleInRegion(boolean allLocaleInRegion) {
		this.allLocaleInRegion = allLocaleInRegion;
	}

	public Integer getPageno() {
		return pageno;
	}

	public void setPageno(Integer pageno) {
		this.pageno = pageno;
	}

	public Integer getReportingmanager() {
		return reportingmanager;
	}

	public void setReportingmanager(Integer integer) {
		this.reportingmanager = integer;
	}

	public String getIandiAndkpicreatemaxdate() {
		return iandiAndkpicreatemaxdate;
	}

	public void setIandiAndkpicreatemaxdate(String iandiAndkpicreatemaxdate) {
		this.iandiAndkpicreatemaxdate = iandiAndkpicreatemaxdate;
	}
	


}
