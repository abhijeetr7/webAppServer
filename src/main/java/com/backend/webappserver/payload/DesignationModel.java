package com.backend.webappserver.payload;

import java.util.Date;

public class DesignationModel {

	private Integer id;
	private String designationcode;
	private String designationname;
	private Character activeStatus;
	private Integer adduserid;
	private Date addddate;
	private Integer edituserid;
	private Date editDate;
	private String SearchText;
	private String status;
	private String status1;
	private Integer userID;
	private String message;
	private String rescoremessage;
	private Integer srno;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatus1() {
		return status1;
	}
	public void setStatus1(String status1) {
		this.status1 = status1;
	}
	
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRescoremessage() {
		return rescoremessage;
	}
	public void setRescoremessage(String rescoremessage) {
		this.rescoremessage = rescoremessage;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDesignationcode() {
		return designationcode;
	}
	public void setDesignationcode(String designationcode) {
		this.designationcode = designationcode;
	}
	public String getDesignationname() {
		return designationname;
	}
	public void setDesignationname(String designationname) {
		this.designationname = designationname;
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
	public Date getAddddate() {
		return addddate;
	}
	public void setAddddate(Date addddate) {
		this.addddate = addddate;
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
