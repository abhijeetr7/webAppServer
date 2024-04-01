package com.backend.webappserver.payload;

import java.util.ArrayList;

import java.util.List;

public class DesignationAllowanceModel {
	private Integer id;
	private Integer designationid;
	private String designationname;
	private Integer unitid;
	private String frequency;
	private String type;
	private double value;
	private Integer userID;
	private String frequunit;
	private String calculate;
	private Character usemap;
	private Integer linkedallowanceID;
	private Integer allowanceid;
	private String allowancename;
	private boolean checkselect;
	private String frequday;
	private Character activeStatus;
	
	
	
	List<DesignationAllowanceModel> modellst =new ArrayList<DesignationAllowanceModel>();
	
	
	public Integer getDesignationid() {
		return designationid;
	}
	public void setDesignationid(Integer designationid) {
		this.designationid = designationid;
	}
	public Integer getUnitid() {
		return unitid;
	}
	public void setUnitid(Integer unitid) {
		this.unitid = unitid;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public String getFrequunit() {
		return frequunit;
	}
	public void setFrequunit(String frequunit) {
		this.frequunit = frequunit;
	}
	public String getCalculate() {
		return calculate;
	}
	public void setCalculate(String calculate) {
		this.calculate = calculate;
	}
	public Character getUsemap() {
		return usemap;
	}
	public void setUsemap(Character usemap) {
		this.usemap = usemap;
	}
	public Integer getLinkedallowanceID() {
		return linkedallowanceID;
	}
	public void setLinkedallowanceID(Integer linkedallowanceID) {
		this.linkedallowanceID = linkedallowanceID;
	}
	public Integer getAllowanceid() {
		return allowanceid;
	}
	public void setAllowanceid(Integer allowanceid) {
		this.allowanceid = allowanceid;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAllowancename() {
		return allowancename;
	}
	public void setAllowancename(String allowancename) {
		this.allowancename = allowancename;
	}
	public boolean isCheckselect() {
		return checkselect;
	}
	public void setCheckselect(boolean checkselect) {
		this.checkselect = checkselect;
	}
	public List<DesignationAllowanceModel> getModellst() {
		return modellst;
	}
	public void setModellst(List<DesignationAllowanceModel> modellst) {
		this.modellst = modellst;
	}
	public String getFrequday() {
		return frequday;
	}
	public void setFrequday(String frequday) {
		this.frequday = frequday;
	}
	public Character getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(Character activeStatus) {
		this.activeStatus = activeStatus;
	}
	public String getDesignationname() {
		return designationname;
	}
	public void setDesignationname(String designationname) {
		this.designationname = designationname;
	}

	
	
	
	
	
	
}
