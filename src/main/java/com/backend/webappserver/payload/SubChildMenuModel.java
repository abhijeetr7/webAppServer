/**
 * 
 */
package com.backend.webappserver.payload;

import java.io.Serializable;

/**
 * @author Vinod
 *
 *         Vinod Patil
 */
public class SubChildMenuModel implements Serializable {
	private String submenulabel;
	private String submenulink;
	

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



	
}
