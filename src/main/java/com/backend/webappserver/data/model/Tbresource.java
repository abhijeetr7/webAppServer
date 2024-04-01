/**
 * 
 */
package com.backend.webappserver.data.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbresource")
public class Tbresource implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "resourceID")
	private Integer resourceID;

	@Column(name = "Salutation")
	private String Salutation;

	@Column(name = "Name")
	private String name;

	@Column(name = "mobile")
	private String mobile;

	@Column(name = "loginName")
	private String loginName;

	@Column(name = "password")
	private String password;

	@Column(name = "activeStatus")
	private Character activeStatus;

	@Column(name = "seflag")
	private Character seflag = new Character('N');

	@Column(name = "employeecode")
	private String employeecode;

	@Column(name = "gender")
	private String gender;
	@Column(name = "firstname")
	private String firstname;

	@Column(name = "middlename")
	private String middlename;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "address")
	private String Address;

	@Column(name = "mobile2")
	private String mobile2;

	@Column(name = "clusterunittype")
	private Integer clusterunittype;

	@Column(name = "tbdepartment")
	private Integer tbdepartment;

	@Column(name = "tbdesignation")
	private Integer tbdesignation;

	@Column(name = "head")
	private Character head;

	@Column(name = "isreporting")
	private Character isreporting;

	@Column(name = "tbband")
	private Integer tbband;

	@Column(name = "reportingmanager")
	private Integer reportingmanager;

	@Column(name = "selfaccess")
	private String selfaccess;

	@Column(name = "assistantaccess")
	private String assistantaccess;

	@Column(name = "selfactive")
	private Character selfactive;

	@Column(name = "assistantactive")
	private Character assistantactive;

	@Column(name = "cancreateproject")
	private Character cancreateproject;

	@Column(name = "adduserid")
	private Integer adduserid;

	@Column(name = "adddate")
	private Date adddate;

	@Column(name = "edituserid")
	private Integer edituserid;

	@Column(name = "editdate")
	private Date editdate;

	@Column(name = "groupClusterUnit")
	private String groupClusterUnit;

	@Column(name = "usergroupid")
	private Integer usergroupid;

	@Column(name = "eMail")
	private String email;

	@Column(name = "activeInactive")
	private Character activeInactive;

	@Column(name = "mobile1")
	private String mobile1;
	
	
	@Column(name = "resigndate")
	private Date resigndate;
	@Column(name = "joiningdate")
	private Date joiningdate;
	@Column(name = "birthdate")
	private Date birthdate;

	public Integer getResourceID() {
		return resourceID;
	}

	public void setResourceID(Integer resourceID) {
		this.resourceID = resourceID;
	}

	public String getSalutation() {
		return Salutation;
	}

	public void setSalutation(String salutation) {
		Salutation = salutation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Character getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(Character activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Character getSeflag() {
		return seflag;
	}

	public void setSeflag(Character seflag) {
		this.seflag = seflag;
	}

	public String getEmployeecode() {
		return employeecode;
	}

	public void setEmployeecode(String employeecode) {
		this.employeecode = employeecode;
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

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getMobile2() {
		return mobile2;
	}

	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}

	public Integer getClusterunittype() {
		return clusterunittype;
	}

	public void setClusterunittype(Integer clusterunittype) {
		this.clusterunittype = clusterunittype;
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

	public Character getHead() {
		return head;
	}

	public void setHead(Character head) {
		this.head = head;
	}

	public Character getIsreporting() {
		return isreporting;
	}

	public void setIsreporting(Character isreporting) {
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

	public String getSelfaccess() {
		return selfaccess;
	}

	public void setSelfaccess(String selfaccess) {
		this.selfaccess = selfaccess;
	}

	public String getAssistantaccess() {
		return assistantaccess;
	}

	public void setAssistantaccess(String assistantaccess) {
		this.assistantaccess = assistantaccess;
	}

	public Character getSelfactive() {
		return selfactive;
	}

	public void setSelfactive(Character selfactive) {
		this.selfactive = selfactive;
	}

	public Character getAssistantactive() {
		return assistantactive;
	}

	public void setAssistantactive(Character assistantactive) {
		this.assistantactive = assistantactive;
	}

	public Character getCancreateproject() {
		return cancreateproject;
	}

	public void setCancreateproject(Character cancreateproject) {
		this.cancreateproject = cancreateproject;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Character getActiveInactive() {
		return activeInactive;
	}

	public void setActiveInactive(Character activeInactive) {
		this.activeInactive = activeInactive;
	}

	public String getMobile1() {
		return mobile1;
	}

	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	

}
