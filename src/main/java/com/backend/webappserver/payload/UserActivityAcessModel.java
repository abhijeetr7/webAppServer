package com.backend.webappserver.payload;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;



public class UserActivityAcessModel {
	public Integer id;
	public Integer roleid;
	private Integer srno;
	public String shortname;
	public String activityname;
	private Integer activityID;
	private Integer resourceId;
	private String permissions;
	public Integer sequence;
	private boolean chkselect;
	private boolean add;
	private boolean edit;
	private boolean delete;
	private boolean view;

	public Integer userid;
	public Integer adduserid;
	public Integer edituserid;
	public Date adddate;
	public Date editdate;
	private String status;
	private String message;
	private String status1;
	private Character activeStatus;
	private String rescoremessage;
	
    private List<activityModel> activitylst = new ArrayList<activityModel>();
    private List<UserActivityAcessModel> activityList1 = new ArrayList<UserActivityAcessModel>();
    private List<UserActivityAcessModel> usractivitylst = new ArrayList<UserActivityAcessModel>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSrno() {
		return srno;
	}
	public void setSrno(Integer srno) {
		this.srno = srno;
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
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
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
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getAdduserid() {
		return adduserid;
	}
	public void setAdduserid(Integer adduserid) {
		this.adduserid = adduserid;
	}
	public Integer getEdituserid() {
		return edituserid;
	}
	public void setEdituserid(Integer edituserid) {
		this.edituserid = edituserid;
	}
	public Date getAdddate() {
		return adddate;
	}
	public void setAdddate(Date adddate) {
		this.adddate = adddate;
	}
	public Date getEditdate() {
		return editdate;
	}
	public void setEditdate(Date editdate) {
		this.editdate = editdate;
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
	public Character getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(Character activeStatus) {
		this.activeStatus = activeStatus;
	}
	public String getRescoremessage() {
		return rescoremessage;
	}
	public void setRescoremessage(String rescoremessage) {
		this.rescoremessage = rescoremessage;
	}
	public Integer getRoleid() {
		return roleid;
	}
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	public List<activityModel> getActivitylst() {
		return activitylst;
	}
	public void setActivitylst(List<activityModel> activitylst) {
		this.activitylst = activitylst;
	}
	public Integer getActivityID() {
		return activityID;
	}
	public void setActivityID(Integer activityID) {
		this.activityID = activityID;
	}
	public String getPermissions() {
		return permissions;
	}
	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}
	public Integer getResourceId() {
		return resourceId;
	}
	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}
	public List<UserActivityAcessModel> getActivityList1() {
		return activityList1;
	}
	public void setActivityList1(List<UserActivityAcessModel> activityList1) {
		this.activityList1 = activityList1;
	}
	public List<UserActivityAcessModel> getUsractivitylst() {
		return usractivitylst;
	}
	public void setUsractivitylst(List<UserActivityAcessModel> usractivitylst) {
		this.usractivitylst = usractivitylst;
	}


}
