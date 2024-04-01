package com.backend.webappserver.payload;

import java.util.ArrayList;
import java.util.List;

public class ParamModel {

	public Integer id;
	public Integer actid;
	public String activityname;
	public String shortname;
	public String parameterName;
	public String mandatory;
	public Integer maxlength;
	public Integer minlength;
	public Integer maxlength1;
	public Integer minlength1;
	public Integer sequence;
	public String type;
	public String unittype;
	public String lessthncurrentdate;
	public String greatthncurrentdate;
	public String currentdate;
	public String booleanyes;
	public String booleanno;
	public String allownegative;
	public String allownegativeforfloat;
	public Integer decimalplaces;
	public String commonmastertype;
	public String input;
	private String svparams;
	private String wflowtrns;
	private Integer sampinvid;
	private String sampleinno;
	private String sampleno;
	private String samplenov;
	private String organismtype;
	private String identifiedgenus;
	private String species;
	private String activitylevel;
	private Integer trnid;
	private String message;
	private String updatedinput;

	private List<IsolateModel> isoList = new ArrayList<IsolateModel>();
	private List<ParamModel> activeList = new ArrayList<ParamModel>();
	private List<String> inputList = new ArrayList<String>();


	validator validator = new validator();

	public List<ParamModel> getActiveList() {
		return activeList;
	}

	public void setActiveList(List<ParamModel> activeList) {
		this.activeList = activeList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShortname() {
		return shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public String getMandatory() {
		return mandatory;
	}

	public void setMandatory(String mandatory) {
		this.mandatory = mandatory;
	}

	public Integer getMaxlength() {
		return maxlength;
	}

	public void setMaxlength(Integer maxlength) {
		this.maxlength = maxlength;
	}

	public Integer getMinlength() {
		return minlength;
	}

	public void setMinlength(Integer minlength) {
		this.minlength = minlength;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUnittype() {
		return unittype;
	}

	public void setUnittype(String unittype) {
		this.unittype = unittype;
	}

	public validator getValidator() {
		return validator;
	}

	public void setValidator(validator validator) {
		this.validator = validator;
	}

	public Integer getMaxlength1() {
		return maxlength1;
	}

	public void setMaxlength1(Integer maxlength1) {
		this.maxlength1 = maxlength1;
	}

	public Integer getMinlength1() {
		return minlength1;
	}

	public void setMinlength1(Integer minlength1) {
		this.minlength1 = minlength1;
	}

	public String getLessthncurrentdate() {
		return lessthncurrentdate;
	}

	public void setLessthncurrentdate(String lessthncurrentdate) {
		this.lessthncurrentdate = lessthncurrentdate;
	}

	public String getGreatthncurrentdate() {
		return greatthncurrentdate;
	}

	public void setGreatthncurrentdate(String greatthncurrentdate) {
		this.greatthncurrentdate = greatthncurrentdate;
	}

	public String getCurrentdate() {
		return currentdate;
	}

	public void setCurrentdate(String currentdate) {
		this.currentdate = currentdate;
	}

	public String getBooleanyes() {
		return booleanyes;
	}

	public void setBooleanyes(String booleanyes) {
		this.booleanyes = booleanyes;
	}

	public String getBooleanno() {
		return booleanno;
	}

	public void setBooleanno(String booleanno) {
		this.booleanno = booleanno;
	}

	public String getAllownegative() {
		return allownegative;
	}

	public void setAllownegative(String allownegative) {
		this.allownegative = allownegative;
	}

	public Integer getDecimalplaces() {
		return decimalplaces;
	}

	public void setDecimalplaces(Integer decimalplaces) {
		this.decimalplaces = decimalplaces;
	}

	public String getCommonmastertype() {
		return commonmastertype;
	}

	public void setCommonmastertype(String commonmastertype) {
		this.commonmastertype = commonmastertype;
	}

	public String getActivityname() {
		return activityname;
	}

	public void setActivityname(String activityname) {
		this.activityname = activityname;
	}



	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public String getSvparams() {
		return svparams;
	}

	public void setSvparams(String svparams) {
		this.svparams = svparams;
	}

	public String getWflowtrns() {
		return wflowtrns;
	}

	public void setWflowtrns(String wflowtrns) {
		this.wflowtrns = wflowtrns;
	}

	public Integer getSampinvid() {
		return sampinvid;
	}

	public void setSampinvid(Integer sampinvid) {
		this.sampinvid = sampinvid;
	}

	public String getSampleinno() {
		return sampleinno;
	}

	public void setSampleinno(String sampleinno) {
		this.sampleinno = sampleinno;
	}

	public String getSampleno() {
		return sampleno;
	}

	public void setSampleno(String sampleno) {
		this.sampleno = sampleno;
	}

	public String getSamplenov() {
		return samplenov;
	}

	public void setSamplenov(String samplenov) {
		this.samplenov = samplenov;
	}

	public Integer getActid() {
		return actid;
	}

	public void setActid(Integer actid) {
		this.actid = actid;
	}

	public String getOrganismtype() {
		return organismtype;
	}

	public void setOrganismtype(String organismtype) {
		this.organismtype = organismtype;
	}

	public String getIdentifiedgenus() {
		return identifiedgenus;
	}

	public void setIdentifiedgenus(String identifiedgenus) {
		this.identifiedgenus = identifiedgenus;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public List<IsolateModel> getIsoList() {
		return isoList;
	}

	public void setIsoList(List<IsolateModel> isoList) {
		this.isoList = isoList;
	}

	public String getActivitylevel() {
		return activitylevel;
	}

	public void setActivitylevel(String activitylevel) {
		this.activitylevel = activitylevel;
	}

	public Integer getTrnid() {
		return trnid;
	}

	public void setTrnid(Integer trnid) {
		this.trnid = trnid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getInputList() {
		return inputList;
	}

	public void setInputList(List<String> inputList) {
		this.inputList = inputList;
	}

	public String getUpdatedinput() {
		return updatedinput;
	}

	public void setUpdatedinput(String updatedinput) {
		this.updatedinput = updatedinput;
	}

	public String getAllownegativeforfloat() {
		return allownegativeforfloat;
	}

	public void setAllownegativeforfloat(String allownegativeforfloat) {
		this.allownegativeforfloat = allownegativeforfloat;
	}


}
