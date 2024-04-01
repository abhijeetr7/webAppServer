package com.backend.webappserver.payload;

import java.util.Date;

public class UnitOfMeasureModel {

	private Integer id;
	private String code;
	private String unitmeasure;
	private String unittype;
	private Character activeStatus;
	private Integer adduserid;
	private Integer edituserid;
	private Date adddate;
	private Date editdate;
	private Integer userID;
	private String status;
	private String status1;
	private String message;
	private String rescoremessage;
	private String searchText;
	private String unittypename;
	
	
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUnitmeasure() {
		return unitmeasure;
	}
	public void setUnitmeasure(String unitmeasure) {
		this.unitmeasure = unitmeasure;
	}
	public String getUnittype() {
		return unittype;
	}
	public void setUnittype(String unittype) {
		this.unittype = unittype;
	}
	
	public Integer getAdduserid() {
		return adduserid;
	}
	public void setAdduserid(Integer adduserid) {
		this.adduserid = adduserid;
	}
	public Integer getEdituserid() {
		return edituserid;
	}
	public void setEdituserid(Integer edituserid) {
		this.edituserid = edituserid;
	}
	public Date getAdddate() {
		return adddate;
	}
	public void setAdddate(Date adddate) {
		this.adddate = adddate;
	}
	public Date getEditdate() {
		return editdate;
	}
	public void setEditdate(Date editdate) {
		this.editdate = editdate;
	}
	public Character getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(Character activeStatus) {
		this.activeStatus = activeStatus;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	public String getUnittypename() {
		return unittypename;
	}
	public void setUnittypename(String unittypename) {
		this.unittypename = unittypename;
	}
	
	
	
}
