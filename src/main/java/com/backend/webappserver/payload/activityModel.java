package com.backend.webappserver.payload;

import java.util.Date;

import javax.persistence.Column;

public class activityModel {

	private Integer id;
	private String shortname;
	private String activityname;
	private Integer activityID;
	private Character status;
	private Integer adduserid;
	private Date adddate;
	private Integer sequence;
	private Integer edituserid;
	private Date editdate;
	private String message;
	private String status1;
	private String rescoremessage;
	private String SearchText;
	private Integer userID;	
	private String Status2;
	private Integer trnid;
	private Integer srno;
	private String Status3;
	private String Status4;
	private String activitylevel;
	private String samplenov;
	private String sampleinno;
	private String sampleno;
	private boolean chkselect;
	private boolean add;
	private boolean edit;
	private boolean delete;
	private boolean view;
	private String rescoremessage3;
	public Integer roleid;
	public Integer userid;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getShortname() {
		return shortname;
	}
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	public String getActivityname() {
		return activityname;
	}
	public void setActivityname(String activityname) {
		this.activityname = activityname;
	}
	public Character getStatus() {
		return status;
	}
	public void setStatus(Character status) {
		this.status = status;
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
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
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
	public String getRescoremessage() {
		return rescoremessage;
	}
	public void setRescoremessage(String rescoremessage) {
		this.rescoremessage = rescoremessage;
	}
	public String getSearchText() {
		return SearchText;
	}
	public void setSearchText(String searchText) {
		SearchText = searchText;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getStatus2() {
		return Status2;
	}
	public void setStatus2(String status2) {
		Status2 = status2;
	}
	public Integer getTrnid() {
		return trnid;
	}
	public void setTrnid(Integer trnid) {
		this.trnid = trnid;
	}
	public Integer getSrno() {
		return srno;
	}
	public void setSrno(Integer srno) {
		this.srno = srno;
	}
	public String getStatus3() {
		return Status3;
	}
	public void setStatus3(String status3) {
		Status3 = status3;
	}
	public String getStatus4() {
		return Status4;
	}
	public void setStatus4(String status4) {
		Status4 = status4;
	}
	public Integer getActivityID() {
		return activityID;
	}
	public void setActivityID(Integer activityID) {
		this.activityID = activityID;
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
	public String getRescoremessage3() {
		return rescoremessage3;
	}
	public void setRescoremessage3(String rescoremessage3) {
		this.rescoremessage3 = rescoremessage3;
	}
	public String getActivitylevel() {
		return activitylevel;
	}
	public void setActivitylevel(String activitylevel) {
		this.activitylevel = activitylevel;
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
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	

	
}
