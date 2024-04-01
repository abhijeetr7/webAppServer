package com.backend.webappserver.payload;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BmsConfigurationModel {
	
	
   private Integer id;
   private Integer overduetask;
   private Integer projecttasks;
   private Integer trmtasks;
   private Integer participantproject;
   private Integer editproject;
   private Integer krabscpillar;
   private Integer kraindividualmin;
   private Integer kraindividualmax;
   private Integer kraweightagemin;
   private Integer kraweightagemax;
   private Integer kpiperindividualkramin;
   private Integer kpiperindividualkramax;
   private Character activeStatus;
   private Integer adduserid;
   private Date adddate;
   private Integer edituserid;
   private Date editdate;
	private String status;
	private String status1;
	private String message;
	private Integer userID;
   
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
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getOverduetask() {
	return overduetask;
}
public void setOverduetask(Integer overduetask) {
	this.overduetask = overduetask;
}
public Integer getProjecttasks() {
	return projecttasks;
}
public void setProjecttasks(Integer projecttasks) {
	this.projecttasks = projecttasks;
}
public Integer getTrmtasks() {
	return trmtasks;
}
public void setTrmtasks(Integer trmtasks) {
	this.trmtasks = trmtasks;
}
public Integer getParticipantproject() {
	return participantproject;
}
public void setParticipantproject(Integer participantproject) {
	this.participantproject = participantproject;
}
public Integer getEditproject() {
	return editproject;
}
public void setEditproject(Integer editproject) {
	this.editproject = editproject;
}
public Integer getKrabscpillar() {
	return krabscpillar;
}
public void setKrabscpillar(Integer krabscpillar) {
	this.krabscpillar = krabscpillar;
}
public Integer getKraindividualmin() {
	return kraindividualmin;
}
public void setKraindividualmin(Integer kraindividualmin) {
	this.kraindividualmin = kraindividualmin;
}
public Integer getKraindividualmax() {
	return kraindividualmax;
}
public void setKraindividualmax(Integer kraindividualmax) {
	this.kraindividualmax = kraindividualmax;
}
public Integer getKraweightagemin() {
	return kraweightagemin;
}
public void setKraweightagemin(Integer kraweightagemin) {
	this.kraweightagemin = kraweightagemin;
}
public Integer getKraweightagemax() {
	return kraweightagemax;
}
public void setKraweightagemax(Integer kraweightagemax) {
	this.kraweightagemax = kraweightagemax;
}
public Integer getKpiperindividualkramin() {
	return kpiperindividualkramin;
}
public void setKpiperindividualkramin(Integer kpiperindividualkramin) {
	this.kpiperindividualkramin = kpiperindividualkramin;
}
public Integer getKpiperindividualkramax() {
	return kpiperindividualkramax;
}
public void setKpiperindividualkramax(Integer kpiperindividualkramax) {
	this.kpiperindividualkramax = kpiperindividualkramax;
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
public Integer getUserID() {
	return userID;
}
public void setUserID(Integer userID) {
	this.userID = userID;
}

   
}
