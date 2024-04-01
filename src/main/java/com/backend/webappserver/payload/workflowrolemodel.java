package com.backend.webappserver.payload;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class workflowrolemodel {
	public String shortname;
	public Integer hierarchy;
	public String role;
	public Integer id;
	public Integer userid;
	public Date adddate;
	private String status;
	private String message;
	private String status1;
	private Character activeStatus;
	private String rescoremessage;
	private boolean chkselect;
	private boolean add;
	private boolean edit;
	private boolean delete;
	private boolean view;
	private boolean approve;
	private boolean Microbe;
	private Integer srno;

	
	public Character getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(Character activeStatus) {
		this.activeStatus = activeStatus;
	}
	public String getShortname() {
		return shortname;
	}
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Date getAdddate() {
		return adddate;
	}
	public void setAdddate(Date adddate) {
		this.adddate = adddate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatus1() {
		return status1;
	}
	public void setStatus1(String status1) {
		this.status1 = status1;
	}
	public Integer getHierarchy() {
		return hierarchy;
	}
	public void setHierarchy(Integer hierarchy) {
		this.hierarchy = hierarchy;
	}
	public String getRescoremessage() {
		return rescoremessage;
	}
	public void setRescoremessage(String rescoremessage) {
		this.rescoremessage = rescoremessage;
	}

	public Integer getSrno() {
		return srno;
	}
	public void setSrno(Integer srno) {
		this.srno = srno;
	}
	public boolean isChkselect() {
		return chkselect;
	}
	public void setChkselect(boolean chkselect) {
		this.chkselect = chkselect;
	}
	public boolean isAdd() {
		return add;
	}
	public void setAdd(boolean add) {
		this.add = add;
	}
	public boolean isEdit() {
		return edit;
	}
	public void setEdit(boolean edit) {
		this.edit = edit;
	}
	public boolean isDelete() {
		return delete;
	}
	public void setDelete(boolean delete) {
		this.delete = delete;
	}
	public boolean isView() {
		return view;
	}
	public void setView(boolean view) {
		this.view = view;
	}
	public boolean isApprove() {
		return approve;
	}
	public void setApprove(boolean approve) {
		this.approve = approve;
	}
	public boolean isMicrobe() {
		return Microbe;
	}
	public void setMicrobe(boolean microbe) {
		Microbe = microbe;
	}

	
	

	
	
	
}