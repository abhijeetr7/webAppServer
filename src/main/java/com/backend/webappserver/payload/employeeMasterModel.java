package com.backend.webappserver.payload;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;

public class employeeMasterModel {
	private Integer id;
	private Integer resourceID;
	private String employeecode;
	private String Salutation;
	private String gender;
	private String firstname;
	private String middlename;
	private String lastname;
	private String address;
	private String mobile;
	private String mobile1;
	private String mobile2;
	private String email;
	private String clusterunittype;
	private Integer clusterunit;
	private Integer tbdepartment;
	private Integer tbdesignation;
	private Boolean head;
	private Boolean isreporting;
	private Integer tbband;
	private Integer reportingmanager;
	private String selfaccess;
	private String assistantaccess;
	private Boolean selfactive;
	private Boolean assistantactive;
	private Boolean cancreateproject;
	private Character activeInactive;
	private Integer userid;
	private Date timestamp;
	private Character ActiveStatus;
	private Integer adduserid;
	private Date adddate;
	private Integer edituserid;
	private Date editdate;
	private String msg;
	private String password;
	private Integer userID;
	private String message;
	private String status;
	private String selfaccessforuser;
	private String selfaccessforassistant;
	private String ResourceName;
	private String searchText;
	private String status1;
	private String rescoremessage;
	private String loginName;
	private String unitName;
	private String bandname;
	private String name;
	private String reportingmanagername;
	private Integer clusterunit1;
	private String groupClusterUnit;
	private Integer usergroupid;
	private Integer pageno;
	private Integer totalItems;
	private Date resigndate;
	private Date joiningdate;
	private Date birthdate;
	private String birthdate1;
	private Integer srno;
	

	public String getBirthdate1() {
		return birthdate1;
	}

	public void setBirthdate1(String birthdate1) {
		this.birthdate1 = birthdate1;
	}

	public Integer getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}

	public Integer getClusterunit1() {
		return clusterunit1;
	}

	public void setClusterunit1(Integer clusterunit1) {
		this.clusterunit1 = clusterunit1;
	}

	public String getReportingmanagername() {
		return reportingmanagername;
	}

	public void setReportingmanagername(String reportingmanagername) {
		this.reportingmanagername = reportingmanagername;
	}

	public String getStatus1() {
		return status1;
	}

	public void setStatus1(String status1) {
		this.status1 = status1;
	}

	public String getRescoremessage() {
		return rescoremessage;
	}

	public void setRescoremessage(String rescoremessage) {
		this.rescoremessage = rescoremessage;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	private String resourceName;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getResourceID() {
		return resourceID;
	}

	public void setResourceID(Integer resourceID) {
		this.resourceID = resourceID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
	}

	public String getSalutation() {
		return Salutation;
	}

	public void setSalutation(String salutation) {
		Salutation = salutation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMobile2() {
		return mobile2;
	}

	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getClusterunit() {
		return clusterunit;
	}

	public void setClusterunit(Integer clusterunit) {
		this.clusterunit = clusterunit;
	}

	public Integer getTbdepartment() {
		return tbdepartment;
	}

	public void setTbdepartment(Integer tbdepartment) {
		this.tbdepartment = tbdepartment;
	}

	public Integer getTbdesignation() {
		return tbdesignation;
	}

	public void setTbdesignation(Integer tbdesignation) {
		this.tbdesignation = tbdesignation;
	}

	public Boolean getIsreporting() {
		return isreporting;
	}

	public void setIsreporting(Boolean isreporting) {
		this.isreporting = isreporting;
	}

	public Integer getTbband() {
		return tbband;
	}

	public void setTbband(Integer tbband) {
		this.tbband = tbband;
	}

	public Integer getReportingmanager() {
		return reportingmanager;
	}

	public void setReportingmanager(Integer reportingmanager) {
		this.reportingmanager = reportingmanager;
	}

	public String getAssistantaccess() {
		return assistantaccess;
	}

	public void setAssistantaccess(String assistantaccess) {
		this.assistantaccess = assistantaccess;
	}

	public Boolean getSelfactive() {
		return selfactive;
	}

	public void setSelfactive(Boolean selfactive) {
		this.selfactive = selfactive;
	}

	public Boolean getAssistantactive() {
		return assistantactive;
	}

	public void setAssistantactive(Boolean assistantactive) {
		this.assistantactive = assistantactive;
	}

	public Boolean getCancreateproject() {
		return cancreateproject;
	}

	public void setCancreateproject(Boolean cancreateproject) {
		this.cancreateproject = cancreateproject;
	}

	public Character getActiveInactive() {
		return activeInactive;
	}

	public void setActiveInactive(Character activeInactive) {
		this.activeInactive = activeInactive;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Character getActiveStatus() {
		return ActiveStatus;
	}

	public void setActiveStatus(Character activeStatus) {
		ActiveStatus = activeStatus;
	}

	public Integer getAdduserid() {
		return adduserid;
	}

	public void setAdduserid(Integer adduserid) {
		this.adduserid = adduserid;
	}

	public Date getAdddate() {
		return adddate;
	}

	public void setAdddate(Date adddate) {
		this.adddate = adddate;
	}

	public Integer getEdituserid() {
		return edituserid;
	}

	public void setEdituserid(Integer edituserid) {
		this.edituserid = edituserid;
	}

	public Date getEditdate() {
		return editdate;
	}

	public void setEditdate(Date editdate) {
		this.editdate = editdate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getHead() {
		return head;
	}

	public void setHead(Boolean head) {
		this.head = head;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getSelfaccess() {
		return selfaccess;
	}

	public void setSelfaccess(String selfaccess) {
		this.selfaccess = selfaccess;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSelfaccessforuser() {
		return selfaccessforuser;
	}

	public void setSelfaccessforuser(String selfaccessforuser) {
		this.selfaccessforuser = selfaccessforuser;
	}

	public String getSelfaccessforassistant() {
		return selfaccessforassistant;
	}

	public void setSelfaccessforassistant(String selfaccessforassistant) {
		this.selfaccessforassistant = selfaccessforassistant;
	}

	public String getResourceName() {
		return ResourceName;
	}

	public void setResourceName(String resourceName) {
		ResourceName = resourceName;

	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getMobile1() {
		return mobile1;
	}

	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getBandname() {
		return bandname;
	}

	public void setBandname(String bandname) {
		this.bandname = bandname;
	}

	public String getClusterunittype() {
		return clusterunittype;
	}

	public void setClusterunittype(String clusterunittype) {
		this.clusterunittype = clusterunittype;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroupClusterUnit() {
		return groupClusterUnit;
	}

	public void setGroupClusterUnit(String groupClusterUnit) {
		this.groupClusterUnit = groupClusterUnit;
	}

	public Integer getUsergroupid() {
		return usergroupid;
	}

	public void setUsergroupid(Integer usergroupid) {
		this.usergroupid = usergroupid;
	}

	public Integer getPageno() {
		return pageno;
	}

	public void setPageno(Integer pageno) {
		this.pageno = pageno;
	}

	public Date getResigndate() {
		return resigndate;
	}

	public void setResigndate(Date resigndate) {
		this.resigndate = resigndate;
	}

	public Date getJoiningdate() {
		return joiningdate;
	}

	public void setJoiningdate(Date joiningdate) {
		this.joiningdate = joiningdate;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Integer getSrno() {
		return srno;
	}

	public void setSrno(Integer srno) {
		this.srno = srno;
	}

	
}
