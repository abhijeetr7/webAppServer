package com.backend.webappserver.payload;

public class DropDownModel2 {

	private Integer id;
	private Integer newid;
	private Integer projectid;
	private String status;
	private String message;
	private String statusm;
	private String recovermessage;
	private Integer taskgroupid;
	
	
	public String getStatusm() {
		return statusm;
	}
	public String getRecovermessage() {
		return recovermessage;
	}
	public void setStatusm(String statusm) {
		this.statusm = statusm;
	}
	public void setRecovermessage(String recovermessage) {
		this.recovermessage = recovermessage;
	}
	public String getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getId() {
		return id;
	}
	public Integer getNewid() {
		return newid;
	}
	public Integer getProjectid() {
		return projectid;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setNewid(Integer newid) {
		this.newid = newid;
	}
	public void setProjectid(Integer projectid) {
		this.projectid = projectid;
	}
	public Integer getTaskgroupid() {
		return taskgroupid;
	}
	public void setTaskgroupid(Integer taskgroupid) {
		this.taskgroupid = taskgroupid;
	}
	
}
