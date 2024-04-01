package com.backend.webappserver.data.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbactivity")
public class Tbactivity {


	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
   private Integer id;

    @Column(name="shortname")
   private String shortname;

    @Column(name="activityname")
   private String activityname;

    @Column(name = "status")
    private Character status;

    @Column(name="adduserid")
   private Integer adduserid;

    @Column(name="adddate")
   private Date adddate;
    
    @Column(name="sequence")
    private Integer sequence;

    @Column(name="edituserid")
   private Integer edituserid;

    @Column(name="editdate")
   private Date editdate;
    
//    @Column(name="version")
//    private String version;
    
    @Column(name="activitylevel")
  private String activitylevel;
    
    @Column(name="parameters")
	 private String parameters;

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

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
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

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
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

//	public String getVersion() {
//		return version;
//	}
//
//	public void setVersion(String version) {
//		this.version = version;
//	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public String getActivitylevel() {
		return activitylevel;
	}

	public void setActivitylevel(String activitylevel) {
		this.activitylevel = activitylevel;
	}
    
    
}
