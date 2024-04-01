package com.backend.webappserver.payload;

import java.util.Date;

public class DepartmentModel {

	private Integer id;
	private String departmentCode;
	private String departmentName;
	private Character activeStatus;
	private Integer adduserid;
	private Date addDate;
	private Integer edituserid;
	private Date editDate;
	private Integer userID;
	
	private String status;
	private String message;
	private String status1;
	private String rescoremessage;

	private String SearchText;
	private Integer srno;
	
	public String getStatus1() {
		return status1;
	}
	public String getRescoremessage() {
		return rescoremessage;
	}
	public void setStatus1(String status1) {
		this.status1 = status1;
	}
	public void setRescoremessage(String rescoremessage) {
		this.rescoremessage = rescoremessage;
	}
	public String getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Character getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(Character activeStatus) {
		this.activeStatus = activeStatus;
	}
	public Integer getAdduserid() {
		return adduserid;
	}
	public void setAdduserid(Integer adduserid) {
		this.adduserid = adduserid;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public Integer getEdituserid() {
		return edituserid;
	}
	public void setEdituserid(Integer edituserid) {
		this.edituserid = edituserid;
	}
	public Date getEditDate() {
		return editDate;
	}
	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}
	public String getSearchText() {
		return SearchText;
	}
	public void setSearchText(String searchText) {
		SearchText = searchText;
	}
	public Integer getSrno() {
		return srno;
	}
	public void setSrno(Integer srno) {
		this.srno = srno;
	}
	
	
}
