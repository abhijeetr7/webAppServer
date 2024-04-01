package com.backend.webappserver.data.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbbmsconfiguration")
public class Tbbmsconfiguration {
	
	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
   private Integer id;

    @Column(name="overduetask")
   private Integer overduetask;


    @Column(name="projecttasks")
   private Integer projecttasks;

    @Column(name="trmtasks")
   private Integer trmtasks;

    @Column(name="participantproject")
   private Integer participantproject;
    
    @Column(name="editproject")
    private Integer editproject;
    
    @Column(name="krabscpillar")
    private Integer krabscpillar;
    
    @Column(name="kraindividualmin")
    private Integer kraindividualmin;
     
     @Column(name="kraindividualmax")
     private Integer kraindividualmax;
     
     @Column(name="kraweightagemin")
     private Integer kraweightagemin;
     
     @Column(name="kraweightagemax")
     private Integer kraweightagemax;
      
      @Column(name="kpiperindividualkramin")
      private Integer kpiperindividualkramin;
      
      @Column(name="kpiperindividualkramax")
      private Integer kpiperindividualkramax;

    @Column(name = "ActiveStatus")
    private Character activeStatus='Y';

    @Column(name="adduserid")
   private Integer adduserid;

    @Column(name="adddate")
   private Date adddate;

    @Column(name="edituserid")
   private Integer edituserid;

    @Column(name="editdate")
   private Date editdate;

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
    
    

}
