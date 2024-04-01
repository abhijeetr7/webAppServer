/**
 * 
 */
package com.backend.webappserver.payload;

import java.util.ArrayList;
import java.util.List;

import com.backend.webappserver.data.model.DefinePages;

//import com.ravish.bms.data.model.DefinePages;

/**
 * @author aruna
 *
 */
public class MenuPayload {

	
	private Integer userId;

	private Integer id;
	private Integer parentId;

	private Integer menuId;

	private Integer groupId;

	private String menuName;

	private String isSubMenu = "N";

	private Character landPage = 'N';

	private String from;

	private String modulename;
	
	private Integer resourcegroupid;
	
	private Integer sequence;
	private String pagename;
	private Integer moduleid;
	private Integer pageid;
	private String type;

	
public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

		List<DefinePages>  pagelst =new ArrayList<DefinePages>();
	/**
	 * @return the landPage
	 */
	public Character getLandPage() {
		return landPage;
	}

	/**
	 * @param landPage the landPage to set
	 */
	public void setLandPage(Character landPage) {
		this.landPage = landPage;
	}

	/**
	 * @return the isSubMenu
	 */
	public String getIsSubMenu() {
		return isSubMenu;
	}

	/**
	 * @param isSubMenu the isSubMenu to set
	 */
	public void setIsSubMenu(String isSubMenu) {
		this.isSubMenu = isSubMenu;
	}

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the parentId
	 */
	public Integer getParentId() {
		return parentId;
	}

	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	/**
	 * @return the menuId
	 */
	public Integer getMenuId() {
		return menuId;
	}

	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	/**
	 * @return the groupId
	 */
	public Integer getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return the menuName
	 */
	public String getMenuName() {
		return menuName;
	}

	/**
	 * @param menuName the menuName to set
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getModulename() {
		return modulename;
	}

	public void setModulename(String modulename) {
		this.modulename = modulename;
	}

	public Integer getResourcegroupid() {
		return resourcegroupid;
	}

	public void setResourcegroupid(Integer resourcegroupid) {
		this.resourcegroupid = resourcegroupid;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public String getPagename() {
		return pagename;
	}

	public void setPagename(String pagename) {
		this.pagename = pagename;
	}

	public Integer getModuleid() {
		return moduleid;
	}

	public void setModuleid(Integer moduleid) {
		this.moduleid = moduleid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getPageid() {
		return pageid;
	}

	public void setPageid(Integer pageid) {
		this.pageid = pageid;
	}

	public List<DefinePages> getPagelst() {
		return pagelst;
	}

	public void setPagelst(List<DefinePages> pagelst) {
		this.pagelst = pagelst;
	}

	
	
}
