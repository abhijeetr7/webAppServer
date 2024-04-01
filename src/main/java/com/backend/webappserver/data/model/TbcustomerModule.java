package com.backend.webappserver.data.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbCustomerModules")
public class TbcustomerModule implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "activeStatus")
	private Character activeStatus = 'Y';

	@Column(name = "dateTime")
	private Date dateTime;

	@Column(name = "userID")
	private Integer tbresource;

	@Column(name = "tbproductModuleID")
	private Integer tbproductModuleID;

	@Column(name = "modulename")
	private String modulename;

	@Column(name = "relationwarecustomer")
	private Integer tbrelationwarecustomerid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Character getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(Character activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Integer getTbresource() {
		return tbresource;
	}

	public void setTbresource(Integer tbresource) {
		this.tbresource = tbresource;
	}
	

	public Integer getTbproductModuleID() {
		return tbproductModuleID;
	}

	public void setTbproductModuleID(Integer tbproductModuleID) {
		this.tbproductModuleID = tbproductModuleID;
	}

	public String getModulename() {
		return modulename;
	}

	public void setModulename(String modulename) {
		this.modulename = modulename;
	}

	public Integer getTbrelationwarecustomerid() {
		return tbrelationwarecustomerid;
	}

	public void setTbrelationwarecustomerid(Integer tbrelationwarecustomerid) {
		this.tbrelationwarecustomerid = tbrelationwarecustomerid;
	}

}
