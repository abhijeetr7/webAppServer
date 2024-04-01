package com.backend.webappserver.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "definepages")
public class DefinePages implements Serializable{

	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name="filename")
	private String filename;
	
	@Column(name="modulename")
	private String modulename;
	
	
	@Column(name="dspname")
	private String dspname;
	
	@Column(name="activeStatus")
	private String activeStatus;
	
	@Column(name="package")
	private String packagename;
	
	@Column(name="reportname")
	private String reportname;
	
	@Column(name = "moduleid")
	private Integer moduleid;
	
	@Column(name = "submoduleid")
	private Integer submoduleid;
	
	  @Column(name = "type")
	    private String type;
	    

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getModulename() {
		return modulename;
	}

	public void setModulename(String modulename) {
		this.modulename = modulename;
	}

	public String getDspname() {
		return dspname;
	}

	public void setDspname(String dspname) {
		this.dspname = dspname;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getPackagename() {
		return packagename;
	}

	public void setPackagename(String packagename) {
		this.packagename = packagename;
	}

	public String getReportname() {
		return reportname;
	}

	public void setReportname(String reportname) {
		this.reportname = reportname;
	}

	public Integer getModuleid() {
		return moduleid;
	}

	public void setModuleid(Integer moduleid) {
		this.moduleid = moduleid;
	}

	public Integer getSubmoduleid() {
		return submoduleid;
	}

	public void setSubmoduleid(Integer submoduleid) {
		this.submoduleid = submoduleid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
}
