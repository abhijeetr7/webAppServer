package com.backend.webappserver.payload;

import java.util.Date;

import javax.persistence.Column;

public class MicrobeMasterModel {
	public Integer id;
	public Integer userid;
	public Integer resourceid;
	public String microbeCode;
	public String microbeNmae;
	private Character activestatus;
	public Integer adduserid;
	public Date adddate;
	public Integer edituserid;
	public Date editdate;
	public String microbeType;
	private Integer typeid;
	private Integer bactid;
	private String genus;
	private String species;
	private String message;
	private String status;
	private Integer srno;
	private Integer pageno;
	private Integer totalItems;
	private String bacteria;
	private Integer trnid;
	private String  shortname;
	private String  value;
	private String rescoremessage;
	private String status1;
	private String searchText;
	private Integer speciesid;
	private Integer genusid;
	private String samplenov;
	private String sampleinno;
	private String sampleno;



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMicrobeCode() {
		return microbeCode;
	}

	public void setMicrobeCode(String microbeCode) {
		this.microbeCode = microbeCode;
	}

	public String getMicrobeNmae() {
		return microbeNmae;
	}

	public void setMicrobeNmae(String microbeNmae) {
		this.microbeNmae = microbeNmae;
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

	public String getMicrobeType() {
		return microbeType;
	}

	public void setMicrobeType(String microbeType) {
		this.microbeType = microbeType;
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

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getResourceid() {
		return resourceid;
	}

	public void setResourceid(Integer resourceid) {
		this.resourceid = resourceid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getSrno() {
		return srno;
	}

	public void setSrno(Integer srno) {
		this.srno = srno;
	}

	public Integer getPageno() {
		return pageno;
	}

	public void setPageno(Integer pageno) {
		this.pageno = pageno;
	}

	public Integer getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}

	public String getBacteria() {
		return bacteria;
	}

	public void setBacteria(String bacteria) {
		this.bacteria = bacteria;
	}

	public Integer getTrnid() {
		return trnid;
	}

	public void setTrnid(Integer trnid) {
		this.trnid = trnid;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRescoremessage() {
		return rescoremessage;
	}

	public void setRescoremessage(String rescoremessage) {
		this.rescoremessage = rescoremessage;
	}

	public String getStatus1() {
		return status1;
	}

	public void setStatus1(String status1) {
		this.status1 = status1;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public Integer getSpeciesid() {
		return speciesid;
	}

	public void setSpeciesid(Integer speciesid) {
		this.speciesid = speciesid;
	}

	public Integer getGenusid() {
		return genusid;
	}

	public void setGenusid(Integer genusid) {
		this.genusid = genusid;
	}

	public String getSamplenov() {
		return samplenov;
	}

	public void setSamplenov(String samplenov) {
		this.samplenov = samplenov;
	}

	public String getSampleinno() {
		return sampleinno;
	}

	public void setSampleinno(String sampleinno) {
		this.sampleinno = sampleinno;
	}

	public String getSampleno() {
		return sampleno;
	}

	public void setSampleno(String sampleno) {
		this.sampleno = sampleno;
	}

}
