package com.backend.webappserver.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbmenu")
public class Tbmenu {
	
	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
   private Integer id;

    @Column(name="sequence")
   private Integer sequence;

    @Column(name="parentid")
   private Integer parentid;

    @Column(name="issubmenu")
   private String issubmenu="N";

    @Column(name="submenulimit")
   private Integer submenulimit;

    @Column(name="menuname")
   private String menuname;

    @Column(name="menupagename")
   private String menupagename;

    @Column(name="package")
   private String packages;

    @Column(name="resourcegroupid")
   private Integer resourcegroupid;

    @Column(name="userid")
   private Integer userid=0;

    @Column(name="groupmenuid")
   private Integer groupmenuid;

    @Column(name="landpage")
   private Character landpage='N';

    @Column(name = "activeStatus")
   private Character activeStatus='Y';
    
    @Column(name = "type")
    private String type;
    
//    @Column(name = "ismobile")
//    private Character ismobile='N';

//    public Character getIsmobile() {
//		return ismobile;
//	}
//
//	public void setIsmobile(Character ismobile) {
//		this.ismobile = ismobile;
//	}

	@Column(name="pageId")
   private Integer pageId;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public String getIssubmenu() {
		return issubmenu;
	}

	public void setIssubmenu(String issubmenu) {
		this.issubmenu = issubmenu;
	}

	public Integer getSubmenulimit() {
		return submenulimit;
	}

	public void setSubmenulimit(Integer submenulimit) {
		this.submenulimit = submenulimit;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public String getMenupagename() {
		return menupagename;
	}

	public void setMenupagename(String menupagename) {
		this.menupagename = menupagename;
	}

	public String getPackages() {
		return packages;
	}

	public void setPackages(String packages) {
		this.packages = packages;
	}

	public Integer getResourcegroupid() {
		return resourcegroupid;
	}

	public void setResourcegroupid(Integer resourcegroupid) {
		this.resourcegroupid = resourcegroupid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Integer getGroupmenuid() {
		return groupmenuid;
	}

	public void setGroupmenuid(Integer groupmenuid) {
		this.groupmenuid = groupmenuid;
	}

	public Character getLandpage() {
		return landpage;
	}

	public void setLandpage(Character landpage) {
		this.landpage = landpage;
	}

	public Character getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(Character activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Integer getPageId() {
		return pageId;
	}

	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	} 
    
    

}
