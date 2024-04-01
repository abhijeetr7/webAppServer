package com.backend.webappserver.data.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbresource")
public class TbemployeeMaster {

	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	 @Column(name="ID")
	   private Integer id;
	
    public Integer getID() {
		return id;
	}

	public void setID(Integer iD) {
		id = id;
	}

	@Column(name="employeecode")
   private String employeecode;

    @Column(name="Salutation")
   private String Salutation;

    @Column(name="gender")
   private Character gender;
    
    @Column(name="firstname")
    private String firstname;
    
    @Column(name="middlename")
    private String middlename;
    
    @Column(name="lastname")
    private String lastname;
    
    @Column(name="Address")
    private String Address;    
    
    @Column(name="mobile")
    private String mobile; 
    
    @Column(name="mobile2")
    private String mobile2; 
    
    @Column(name="eMail")
    private String email; 
    
    @Column(name="groupclusterunittype")
    private String groupclusterunittype; 
    
    @Column(name="groupclusterunit")
    private Integer groupclusterunit;
    
    @Column(name="tbdepartment")
    private Integer tbdepartment;     
    
    @Column(name="tbdesignation")
    private Integer tbdesignation;
    
    @Column(name="head")
    private Character head;
    
    @Column(name="isreporting")
    private Character isreporting;
   
    @Column(name = "tbband")
    private Integer tbband;
    
    @Column(name="reportingmanager")
    private Integer reportingmanager;
    
    @Column(name="selfaccess")
    private String selfaccess;
    
    @Column(name="assistantaccess")
    private String assistantaccess;
    
    @Column(name="showinreport")
    private Character selfactive;
    
    
    @Column(name="assistantactive")
    private Character assistantactive	;
    
    
    @Column(name="cancreateproject")
    private Character cancreateproject;
    
    @Column(name="activeInactive")
    private Character activeInactive;
    
    @Column(name="userid")
    private Integer userid;
    
    @Column(name="timestamp")
    private Date timestamp;
    
    @Column(name = "ActiveStatus")
    private Character ActiveStatus='Y';

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

	public Character getGender() {
		return gender;
	}

	public void setGender(Character gender) {
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

	public String getGroupclusterunittype() {
		return groupclusterunittype;
	}

	public void setGroupclusterunittype(String groupclusterunittype) {
		this.groupclusterunittype = groupclusterunittype;
	}

	public Integer getGroupclusterunit() {
		return groupclusterunit;
	}

	public void setGroupclusterunit(Integer groupclusterunit) {
		this.groupclusterunit = groupclusterunit;
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

   
    
    
    
    
    
    
	
    
}
