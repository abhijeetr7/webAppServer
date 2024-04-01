package com.backend.webappserver.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name ="tbactivitytrans")
public class Tbactivitytrans {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "sampinvid")
	private Integer sampinvid;
	
	@Column(name = "sampleinno")
	private String sampleinno;
	
	@Column(name = "sampleno")
	private String sampleno;
	
	@Column(name = "samplenov")
	private String samplenov;
	
	@Column(name = "organismtype")
	private String organismtype;
	
	@Column(name = "identifiedgenus")
	private String identifiedgenus;
	
	@Column(name = "species")
	private String species;
	
	@Column(name = "svparams")
	private String svparams;
	
	@Column(name = "wflowtrns")
	private String wflowtrns;
	
	@Column(name = "status")
	private Character status;
	
	@Column(name = "activesatus")
	private Character activesatus;

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
	
	

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
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
	
	
	
	
}
