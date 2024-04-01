package com.backend.webappserver.data.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbunitofmeasure")
public class Tbunitofmeasure {

	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
   private Integer id;

    @Column(name="code")
   private String code;

    @Column(name="unitmeasures")
   private String unitmeasures;
    
    @Column(name="unittype")
   private String unittype;

    @Column(name = "ActiveStatus")
    private Character ActiveStatus='Y';

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUnitmeasures() {
		return unitmeasures;
	}

	public void setUnitmeasures(String unitmeasures) {
		this.unitmeasures = unitmeasures;
	}

	public String getUnittype() {
		return unittype;
	}

	public void setUnittype(String unittype) {
		this.unittype = unittype;
	}

	public Character getActiveStatus() {
		return ActiveStatus;
	}

	public void setActiveStatus(Character activeStatus) {
		ActiveStatus = activeStatus;
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
