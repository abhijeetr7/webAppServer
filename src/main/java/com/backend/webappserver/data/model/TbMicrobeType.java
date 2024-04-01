package com.backend.webappserver.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//tbMicrobeTypeMaster
@Entity
@Table(name = "tbMicrobeType")
public class TbMicrobeType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "microbeCode")
	private Integer microbeCode;
	
	@Column(name = "microbeNmae")
	private Integer microbeNmae;
	
	@Column(name = "microbeType")
	private Integer microbeType;
	
	@Column(name = "activestatus")
	private Character activestatus;
	
	@Column(name = "adduserid")
	private Integer adduserid;
	
	@Column(name = "adddate")
	private Integer adddate;
	
	@Column(name = "edituserid")
	private Integer edituserid;
	
	@Column(name = "editdate")
	private Integer editdate;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMicrobeCode() {
		return microbeCode;
	}

	public void setMicrobeCode(Integer microbeCode) {
		this.microbeCode = microbeCode;
	}

	public Integer getMicrobeNmae() {
		return microbeNmae;
	}

	public void setMicrobeNmae(Integer microbeNmae) {
		this.microbeNmae = microbeNmae;
	}
	
	

	public Integer getMicrobeType() {
		return microbeType;
	}

	public void setMicrobeType(Integer microbeType) {
		this.microbeType = microbeType;
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

	public Integer getAdddate() {
		return adddate;
	}

	public void setAdddate(Integer adddate) {
		this.adddate = adddate;
	}

	public Integer getEdituserid() {
		return edituserid;
	}

	public void setEdituserid(Integer edituserid) {
		this.edituserid = edituserid;
	}

	public Integer getEditdate() {
		return editdate;
	}

	public void setEditdate(Integer editdate) {
		this.editdate = editdate;
	}

	
}
