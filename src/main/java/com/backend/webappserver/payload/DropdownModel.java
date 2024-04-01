package com.backend.webappserver.payload;

import java.util.Date;

public class DropdownModel{

	private Integer id;
	private String name;
	private Integer customertypeID;
	private String customerName;

	private String resourceName;
	private Character isreporting;
	private Integer reportingmanager;
	private Integer resourceID;
	private Integer resourceid;
	private String taskname;
	private Date fromdate1;
	private Date finishdate1;
	private boolean toggle;
	private boolean actualattendance;
	
	public Integer getResourceid() {
		return resourceid;
	}
	public void setResourceid(Integer resourceid) {
		this.resourceid = resourceid;
	}
	public Date getFromdate1() {
		return fromdate1;
	}
	public Date getFinishdate1() {
		return finishdate1;
	}
	public void setFromdate1(Date fromdate1) {
		this.fromdate1 = fromdate1;
	}
	public void setFinishdate1(Date finishdate1) {
		this.finishdate1 = finishdate1;
	}
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	private boolean confimedAttencance;


	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	private String remarks;
	private Integer meetingid;
 

	public Integer getMeetingid() {
		return meetingid;
	}
	public void setMeetingid(Integer meetingid) {
		this.meetingid = meetingid;

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCustomertypeID() {
		return customertypeID;
	}
	public void setCustomertypeID(Integer customertypeID) {
		this.customertypeID = customertypeID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	


	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;

	}
	public Character getIsreporting() {
		return isreporting;
	}
	public Integer getReportingmanager() {
		return reportingmanager;
	}
	public void setIsreporting(Character isreporting) {
		this.isreporting = isreporting;
	}
	public void setReportingmanager(Integer reportingmanager) {
		this.reportingmanager = reportingmanager;
	}
	public Integer getResourceID() {
		return resourceID;
	}
	public void setResourceID(Integer resourceID) {
		this.resourceID = resourceID;
	}
	public boolean isConfimedAttencance() {
		return confimedAttencance;
	}
	public void setConfimedAttencance(boolean confimedAttencance) {
		this.confimedAttencance = confimedAttencance;
	}
	public boolean isToggle() {
		return toggle;
	}
	public void setToggle(boolean toggle) {
		this.toggle = toggle;
	}
	public boolean isActualattendance() {
		return actualattendance;
	}
	public void setActualattendance(boolean actualattendance) {
		this.actualattendance = actualattendance;
	}
	

	
	
}
