package com.backend.webappserver.payload;

import java.util.ArrayList;
import java.util.List;

public class JsonModel {
	public Integer id;
	public Integer actid;
	public String activityname;
	public String shortname;
	public String parameterName;
	public String input;
	private String svparams;
	private Integer sampinvid;
	private String sampleinno;
	private String sampleno;
	private String samplenov;
	private String organismtype;
	private String identifiedgenus;
	private String species;

	
	
	private List<String> inputList = new ArrayList<String>();
	
	
	
	public List<String> getInputList() {
		return inputList;
	}
	public void setInputList(List<String> inputList) {
		this.inputList = inputList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getActid() {
		return actid;
	}
	public void setActid(Integer actid) {
		this.actid = actid;
	}
	public String getActivityname() {
		return activityname;
	}
	public void setActivityname(String activityname) {
		this.activityname = activityname;
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
	
	

}
