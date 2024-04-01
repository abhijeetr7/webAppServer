package com.backend.webappserver.data.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbMicrobeTypeMaster")
public class TbMicrobeTypeMaster {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "typeid")
	private Integer typeid;

	@Column(name = "bactid")
	private Integer bactid;

	@Column(name = "genus")
	private String genus;

	@Column(name = "species")
	private String species;

	@Column(name = "activestatus")
	private Character activestatus;

	@Column(name = "adduserid")
	private Integer adduserid;

	@Column(name = "adddate")
	private Date adddate;

	@Column(name = "edituserid")
	private Integer edituserid;

	@Column(name = "editdate")
	private Date editdate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public Integer getBactid() {
		return bactid;
	}

	public void setBactid(Integer bactid) {
		this.bactid = bactid;
	}

	public String getGenus() {
		return genus;
	}

	public void setGenus(String genus) {
		this.genus = genus;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public Character getActivestatus() {
		return activestatus;
	}

	public void setActivestatus(Character activestatus) {
		this.activestatus = activestatus;
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
