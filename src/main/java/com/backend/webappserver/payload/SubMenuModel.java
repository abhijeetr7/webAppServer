/**
 * 
 */
package com.backend.webappserver.payload;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vinod
 *
 *         Vinod Patil
 */
public class SubMenuModel implements Serializable {
	private String submenulabel;
	private String submenulink;
	private Boolean fromAndTodate;
	private Boolean project;
	private Boolean employee;
	private String admin;
	private String user;
	private String type;

	List<SubChildMenuModel> lstchildmenu = new ArrayList<SubChildMenuModel>();

	public String getSubmenulabel() {
		return this.submenulabel;
	}

	public void setSubmenulabel(String submenulabel) {
		this.submenulabel = submenulabel;
	}

	public String getSubmenulink() {
		return this.submenulink;
	}

	public void setSubmenulink(String submenulink) {
		this.submenulink = submenulink;
	}

	public List<SubChildMenuModel> getLstchildmenu() {
		return this.lstchildmenu;
	}

	public void setLstchildmenu(List<SubChildMenuModel> lstchildmenu) {
		this.lstchildmenu = lstchildmenu;
	}

	public Boolean getFromAndTodate() {
		return fromAndTodate;
	}

	public void setFromAndTodate(Boolean fromAndTodate) {
		this.fromAndTodate = fromAndTodate;
	}

	public Boolean getProject() {
		return project;
	}

	public void setProject(Boolean project) {
		this.project = project;
	}

	public Boolean getEmployee() {
		return employee;
	}

	public void setEmployee(Boolean employee) {
		this.employee = employee;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
