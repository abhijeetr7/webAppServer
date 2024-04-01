package com.backend.webappserver.data.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbuseractivityactivityacess")
public class Tbuseractivityactivityacess implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id")
	private Integer id;
	
	@Column(name = "resourceID")
	private Integer resourceID;
	
	@Column(name = "shortname")
	public String shortname;
	
	@Column(name = "activityname")
	public String activityname;
	
	@Column(name = "activityid")
	public Integer activityid;
	
	@Column(name = "sequence")
	public Integer sequence;
	
	@Column(name = "permissions")
	private String permissions;

	@Column(name = "adduserid")
	public Integer adduserid;
	
	@Column(name = "edituserid")
	public Integer edituserid;
	
	@Column(name = "adddate")
	public Date adddate;
	
	@Column(name = "editdate")
	public Date editdate;
	
	@Column(name = "activeStatus")
	private Character activeStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getActivityname() {
		return activityname;
	}

	public void setActivityname(String activityname) {
		this.activityname = activityname;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
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

	public Integer getResourceID() {
		return resourceID;
	}

	public void setResourceID(Integer resourceID) {
		this.resourceID = resourceID;
	}

	public Integer getActivityid() {
		return activityid;
	}

	public void setActivityid(Integer activityid) {
		this.activityid = activityid;
	}
	
	
}
