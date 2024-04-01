package com.backend.webappserver.payload;

import java.util.ArrayList;
import java.util.List;

public class MenuModel extends Message {

	private String mainmenulabel;
	private String mainmenulink;
	private String targetid;
	private List<SubMenuModel> lstsubmenu = new ArrayList();

	public String getMainmenulabel() {
		return mainmenulabel;
	}

	public String getMainmenulink() {
		return mainmenulink;
	}

	public List<SubMenuModel> getLstsubmenu() {
		return lstsubmenu;
	}

	public void setMainmenulabel(String mainmenulabel) {
		this.mainmenulabel = mainmenulabel;
	}

	public void setMainmenulink(String mainmenulink) {
		this.mainmenulink = mainmenulink;
	}

	public void setLstsubmenu(List<SubMenuModel> lstsubmenu) {
		this.lstsubmenu = lstsubmenu;
	}

	public String getTargetid() {
		return targetid;
	}

	public void setTargetid(String targetid) {
		this.targetid = targetid;
	}

}
