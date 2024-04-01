package com.backend.webappserver.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbusergroup")
public class Tbusergroup implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	Integer id;

	@Column(name = "usergroup")
	String usergroup;

	@Column(name = "activstatus")
	Character activstatus = 'Y';
	
	@Column(name = "jsonstring")
	String jsonstring ;

	/**
	 * @return the activstatus
	 * 
	 *         /**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the usergroup
	 */
	public String getUsergroup() {
		return usergroup;
	}

	/**
	 * @param usergroup the usergroup to set
	 */
	public void setUsergroup(String usergroup) {
		this.usergroup = usergroup;
	}

	public Character getActivestatus() {
		return activstatus;
	}

	public void setActivestatus(Character activeStatus) {
		this.activstatus = activeStatus;
	}

	public String getJsonstring() {
		return jsonstring;
	}

	public void setJsonstring(String jsonstring) {
		this.jsonstring = jsonstring;
	}

}
