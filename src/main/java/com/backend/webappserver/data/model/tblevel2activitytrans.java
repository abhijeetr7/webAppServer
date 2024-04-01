package com.backend.webappserver.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name= "tblevel2activitytrans")
public class tblevel2activitytrans {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "isolatecode")
	private String isolatecode;
	
	@Column(name = "pncode")
	private String pncode;
	
	
	@Column(name = "sampleno")
	private String sampleno;
	
	@Column(name = "activesatus")
	private Character  activesatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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


	public Character getActivesatus() {
		return activesatus;
	}

	public void setActivesatus(Character activesatus) {
		this.activesatus = activesatus;
	}

	public String getSampleno() {
		return sampleno;
	}

	public void setSampleno(String sampleno) {
		this.sampleno = sampleno;
	}
	
	
	
	
}
