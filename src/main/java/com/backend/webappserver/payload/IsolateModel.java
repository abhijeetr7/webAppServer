package com.backend.webappserver.payload;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

public class IsolateModel {
	
	private Integer id;
	private Integer sampinvid;
	private String sampleinno;
	private String sampleno;
	private String samplenov;
	private String organismtype;
	private String microbeTypename;
	private String identifiedgenus;
	private String genus;
	private String species;
	private String svparams;
	private String wflowtrns;
	private Character status;
	private Character activesatus;
	public Integer edituserid;
	public Integer adduserid;
	private String message;
	private String statuss;
	private Integer srno;
	private Integer pageno;
	private Integer totalItems;
	private String searchText;
	private String isolatecode;
	private String pncode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSampinvid() {
		return sampinvid;
	}

	public void setSampinvid(Integer sampinvid) {
		this.sampinvid = sampinvid;
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

	public String getSamplenov() {
		return samplenov;
	}

	public void setSamplenov(String samplenov) {
		this.samplenov = samplenov;
	}

	public String getOrganismtype() {
		return organismtype;
	}

	public void setOrganismtype(String organismtype) {
		this.organismtype = organismtype;
	}

	public String getIdentifiedgenus() {
		return identifiedgenus;
	}

	public void setIdentifiedgenus(String identifiedgenus) {
		this.identifiedgenus = identifiedgenus;
	}

	public String getSvparams() {
		return svparams;
	}

	public void setSvparams(String svparams) {
		this.svparams = svparams;
	}

	public String getWflowtrns() {
		return wflowtrns;
	}

	public void setWflowtrns(String wflowtrns) {
		this.wflowtrns = wflowtrns;
	}

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	public Character getActivesatus() {
		return activesatus;
	}

	public void setActivesatus(Character activesatus) {
		this.activesatus = activesatus;
	}
	
	List<SampleinvertModel> samp = new ArrayList<SampleinvertModel>();

	public List<SampleinvertModel> getSamp() {
		return samp;
	}

	public void setSamp(List<SampleinvertModel> samp) {
		this.samp = samp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatuss() {
		return statuss;
	}

	public void setStatuss(String statuss) {
		this.statuss = statuss;
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

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public Integer getEdituserid() {
		return edituserid;
	}

	public void setEdituserid(Integer edituserid) {
		this.edituserid = edituserid;
	}

	public Integer getAdduserid() {
		return adduserid;
	}

	public void setAdduserid(Integer adduserid) {
		this.adduserid = adduserid;
	}

	public String getMicrobeTypename() {
		return microbeTypename;
	}

	public void setMicrobeTypename(String microbeTypename) {
		this.microbeTypename = microbeTypename;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getGenus() {
		return genus;
	}

	public void setGenus(String genus) {
		this.genus = genus;
	}

	public String getIsolatecode() {
		return isolatecode;
	}

	public void setIsolatecode(String isolatecode) {
		this.isolatecode = isolatecode;
	}

	public String getPncode() {
		return pncode;
	}

	public void setPncode(String pncode) {
		this.pncode = pncode;
	}
	
	
	

}
