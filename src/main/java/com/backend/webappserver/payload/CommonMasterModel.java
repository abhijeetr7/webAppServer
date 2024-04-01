package com.backend.webappserver.payload;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommonMasterModel {
	private Integer id;
	private Integer bactid;
	private String shortname;
	private String type;
	private String code;
	private String value;
	private Integer typeid;
	private Character activeStatus;
	private Integer adduserid;
	private Integer edituserid;
	private Date adddate;
	private Date editdate;
	private Integer userID;
	private String status;
	private String status1;
	private String message;
	private String rescoremessage;
	private String searchText;
	private Integer pageno;
	private Integer totalItems;
	private Character microbeType;
	private String microbeTypename;
	private Integer typeidfordep;
	private String valueforjson;
	private Integer typeidfordepsortname;
	private Boolean checkboxValue;
	private String depenname;
	private String depenshortname;

	private List<CommonMasterModel> parameterList = new ArrayList<CommonMasterModel>();

//	private List<ParamModel> distList = new ArrayList<ParamModel>();
//	private List<DependancyModel> activeList = new ArrayList<DependancyModel>();
	public List<DependancyModel> distList = new ArrayList<DependancyModel>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Character getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(Character activeStatus) {
		this.activeStatus = activeStatus;
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

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatus1() {
		return status1;
	}

	public void setStatus1(String status1) {
		this.status1 = status1;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRescoremessage() {
		return rescoremessage;
	}

	public void setRescoremessage(String rescoremessage) {
		this.rescoremessage = rescoremessage;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getPageno() {
		return pageno;
	}

	public void setPageno(Integer pageno) {
		this.pageno = pageno;
	}

	public Integer getTotalItems() {
		return totalItems;
	}

	public void setTotalItems(Integer totalItems) {
		this.totalItems = totalItems;
	}

	public Character getMicrobeType() {
		return microbeType;
	}

	public void setMicrobeType(Character microbeType) {
		this.microbeType = microbeType;
	}

	public Integer getBactid() {
		return bactid;
	}

	public void setBactid(Integer bactid) {
		this.bactid = bactid;
	}

	public String getMicrobeTypename() {
		return microbeTypename;
	}

	public void setMicrobeTypename(String microbeTypename) {
		this.microbeTypename = microbeTypename;
	}

	public Integer getTypeidfordep() {
		return typeidfordep;
	}

	public void setTypeidfordep(Integer typeidfordep) {
		this.typeidfordep = typeidfordep;
	}

	public String getValueforjson() {
		return valueforjson;
	}

	public void setValueforjson(String valueforjson) {
		this.valueforjson = valueforjson;
	}

	public Integer getTypeidfordepsortname() {
		return typeidfordepsortname;
	}

	public void setTypeidfordepsortname(Integer typeidfordepsortname) {
		this.typeidfordepsortname = typeidfordepsortname;
	}

	public Boolean getCheckboxValue() {
		return checkboxValue;
	}

	public void setCheckboxValue(Boolean checkboxValue) {
		this.checkboxValue = checkboxValue;
	}

	public List<CommonMasterModel> getParameterList() {
		return parameterList;
	}

	public void setParameterList(List<CommonMasterModel> parameterList) {
		this.parameterList = parameterList;
	}

	public List<DependancyModel> getDistList() {
		return distList;
	}

	public void setDistList(List<DependancyModel> distList) {
		this.distList = distList;
	}

	public String getDepenname() {
		return depenname;
	}

	public void setDepenname(String depenname) {
		this.depenname = depenname;
	}

	public String getDepenshortname() {
		return depenshortname;
	}

	public void setDepenshortname(String depenshortname) {
		this.depenshortname = depenshortname;
	}


}
