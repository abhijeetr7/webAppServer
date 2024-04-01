package com.backend.webappserver.data.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tbcommonmaster")
public class Tbcommonmaster {

	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
   private Integer id;
	
    @Column(name="shortname")
   private String shortname;
    
    @Column(name="value")
   private String value;
    
    @Column(name="dependancyjson")
    private String dependancyjson;
    
    @Column(name="typeid")
   private Integer typeid;
    
    @Column(name="userid")
   private Integer userid;
    
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
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

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getDependancyjson() {
		return dependancyjson;
	}

	public void setDependancyjson(String dependancyjson) {
		this.dependancyjson = dependancyjson;
	}
	

}
