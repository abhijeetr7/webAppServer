package com.backend.webappserver.payload;

public class ModuleItemModel extends Message {

	
	public Integer id;
	public String modulename;
	public String  pagename;
	public String  itemname;
	public String  groupname;
	public Integer srno;
	public String  updategroupname;
	public Integer usergroupid;
	public String from;
	public Integer updatedusergroupid;
	
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getModulename() {
		return modulename;
	}
	public void setModulename(String modulename) {
		this.modulename = modulename;
	}
	public String getPagename() {
		return pagename;
	}
	public void setPagename(String pagename) {
		this.pagename = pagename;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	public Integer getSrno() {
		return srno;
	}
	public void setSrno(Integer srno) {
		this.srno = srno;
	}
	public String getUpdategroupname() {
		return updategroupname;
	}
	public void setUpdategroupname(String updategroupname) {
		this.updategroupname = updategroupname;
	}
	public Integer getUsergroupid() {
		return usergroupid;
	}
	public void setUsergroupid(Integer usergroupid) {
		this.usergroupid = usergroupid;
	}
	public Integer getUpdatedusergroupid() {
		return updatedusergroupid;
	}
	public void setUpdatedusergroupid(Integer updatedusergroupid) {
		this.updatedusergroupid = updatedusergroupid;
	}

	
	
	
	
}
