package com.backend.webappserver.data.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbsampleinverd")
public class Tbsampleinverd {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "sampleinno")
	private String sampleinno;

	@Column(name = "samplecollectedby")
	private String samplecollectedby;
	@Column(name = "sampledby")
	private String sampledby;

	@Column(name = "samplingdate")
	private Date samplingdate;

	@Column(name = "samplecollectdate")
	private Date samplecollectdate;

	@Column(name = "sampleno")
	private String sampleno;

	@Column(name = "samplenov")
	private String samplenov;

	@Column(name = "adduserid")
	private Integer adduserid;

	@Column(name = "active")
	private Character active;

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

	

	public Integer getAdduserid() {
		return adduserid;
	}

	public void setAdduserid(Integer adduserid) {
		this.adduserid = adduserid;
	}

	public Character getActive() {
		return active;
	}

	public void setActive(Character active) {
		this.active = active;
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

	public Date getSamplingdate() {
		return samplingdate;
	}

	public void setSamplingdate(Date samplingdate) {
		this.samplingdate = samplingdate;
	}

	public Date getSamplecollectdate() {
		return samplecollectdate;
	}

	public void setSamplecollectdate(Date samplecollectdate) {
		this.samplecollectdate = samplecollectdate;
	}

	public String getSamplecollectedby() {
		return samplecollectedby;
	}

	public void setSamplecollectedby(String samplecollectedby) {
		this.samplecollectedby = samplecollectedby;
	}

	public String getSampledby() {
		return sampledby;
	}

	public void setSampledby(String sampledby) {
		this.sampledby = sampledby;
	}

	public String getSamplenov() {
		return samplenov;
	}

	public void setSamplenov(String samplenov) {
		this.samplenov = samplenov;
	}

}
