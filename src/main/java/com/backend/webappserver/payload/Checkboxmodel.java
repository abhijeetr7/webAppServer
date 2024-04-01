package com.backend.webappserver.payload;

public class Checkboxmodel {
	private boolean chkselect;
	private boolean add;
	private boolean edit;
	private boolean delete;
	private boolean view;
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
	
	
	
}
