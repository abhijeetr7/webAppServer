package com.backend.webappserver.payload;

import java.util.ArrayList;
import java.util.List;

public class CompanyModel {
	private Integer id;

	private String companyname;
	private String companycode;
	private String address;
	private String tcname;
	private String bcname;
	private String city;
	private String pincode;
	private String state;
	private String country;
	private String gstnumber;
	private String telephone;
	private String companywebsite;
	private boolean textgrup;
	private boolean upanddownexel;
	private String defaultcurrency;
	private boolean editmashindescription;
	private Integer defaultcurrencyid;
	private String serviceheadname;
	private Integer serviceheadnameid;
	private boolean taxgroupflag;
	private boolean updownexelflag;
	private boolean mashindescriptionflag;
	private String installationapproval;

	private boolean integratedsaleservice;
	private boolean mcstatus;
	private boolean showbrand;
	private boolean salesfunnel;
	private boolean mobileapplication;
	private boolean mobilecallclose;
	private boolean sparelist;
	private boolean mobileattachments;

	private Integer percentage;
	private Integer nodallowedbeforeservicecall;
	private Integer nodallwedbeforedcr;
	private String bucketname;
	private String amazons3key;
	private String amazonserect3key;
	private Integer noofdaysescalate;
	private String currencyName;

	private boolean firstapproval;
	private boolean secondapproval;
	private boolean thirdapproval;
	private boolean fourthapproval;

	private boolean fortnightly;
	private boolean monthly;
	private boolean edittripdistance;
	private String customervalue;
	private String maxvalues;
	private Character activeStatus;
	private String type;
	private Integer subModuleId;
	private Integer moduleId;
	private String moduleflagName;
	private String moduleflag;
	private boolean chkselect;
	private Integer userid;
	
	List<CompanyModel> complst = new ArrayList<CompanyModel>();
	List<DropdownModel> defautcurrlst = new ArrayList<DropdownModel>();
	List<CompanyModel>modellst= new ArrayList<CompanyModel>();

	public Integer getId() {
		return id;
	}

	public boolean isTaxgroupflag() {
		return taxgroupflag;
	}

	public void setTaxgroupflag(boolean taxgroupflag) {
		this.taxgroupflag = taxgroupflag;
	}

	public boolean isUpdownexelflag() {
		return updownexelflag;
	}

	public void setUpdownexelflag(boolean updownexelflag) {
		this.updownexelflag = updownexelflag;
	}

	public boolean isMashindescriptionflag() {
		return mashindescriptionflag;
	}

	public void setMashindescriptionflag(boolean mashindescriptionflag) {
		this.mashindescriptionflag = mashindescriptionflag;
	}

	public String getInstallationapproval() {
		return installationapproval;
	}

	public void setInstallationapproval(String installationapproval) {
		this.installationapproval = installationapproval;
	}
	public String getGstnumber() {
		return gstnumber;
	}

	public void setGstnumber(String gstnumber) {
		this.gstnumber = gstnumber;
	} 
	
	public boolean isIntegratedsaleservice() {
		return integratedsaleservice;
	}

	public void setIntegratedsaleservice(boolean integratedsaleservice) {
		this.integratedsaleservice = integratedsaleservice;
	}

	public boolean isMcstatus() {
		return mcstatus;
	}

	public void setMcstatus(boolean mcstatus) {
		this.mcstatus = mcstatus;
	}

	public boolean isShowbrand() {
		return showbrand;
	}

	public void setShowbrand(boolean showbrand) {
		this.showbrand = showbrand;
	}

	public boolean isSalesfunnel() {
		return salesfunnel;
	}

	public void setSalesfunnel(boolean salesfunnel) {
		this.salesfunnel = salesfunnel;
	}

	public boolean isMobileapplication() {
		return mobileapplication;
	}

	public void setMobileapplication(boolean mobileapplication) {
		this.mobileapplication = mobileapplication;
	}

	public boolean isMobilecallclose() {
		return mobilecallclose;
	}

	public void setMobilecallclose(boolean mobilecallclose) {
		this.mobilecallclose = mobilecallclose;
	}

	public boolean isSparelist() {
		return sparelist;
	}

	public void setSparelist(boolean sparelist) {
		this.sparelist = sparelist;
	}

	public boolean isMobileattachments() {
		return mobileattachments;
	}

	public void setMobileattachments(boolean mobileattachments) {
		this.mobileattachments = mobileattachments;
	}

	public boolean isFirstapproval() {
		return firstapproval;
	}

	public void setFirstapproval(boolean firstapproval) {
		this.firstapproval = firstapproval;
	}

	public boolean isSecondapproval() {
		return secondapproval;
	}

	public void setSecondapproval(boolean secondapproval) {
		this.secondapproval = secondapproval;
	}

	public boolean isThirdapproval() {
		return thirdapproval;
	}

	public void setThirdapproval(boolean thirdapproval) {
		this.thirdapproval = thirdapproval;
	}

	public boolean isFourthapproval() {
		return fourthapproval;
	}

	public void setFourthapproval(boolean fourthapproval) {
		this.fourthapproval = fourthapproval;
	}

	public boolean isFortnightly() {
		return fortnightly;
	}

	public void setFortnightly(boolean fortnightly) {
		this.fortnightly = fortnightly;
	}

	public boolean isMonthly() {
		return monthly;
	}

	public void setMonthly(boolean monthly) {
		this.monthly = monthly;
	}

	public boolean isEdittripdistance() {
		return edittripdistance;
	}

	public void setEdittripdistance(boolean edittripdistance) {
		this.edittripdistance = edittripdistance;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getCompanycode() {
		return companycode;
	}

	public void setCompanycode(String companycode) {
		this.companycode = companycode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTcname() {
		return tcname;
	}

	public void setTcname(String tcname) {
		this.tcname = tcname;
	}

	public String getBcname() {
		return bcname;
	}

	public void setBcname(String bcname) {
		this.bcname = bcname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCompanywebsite() {
		return companywebsite;
	}

	public void setCompanywebsite(String companywebsite) {
		this.companywebsite = companywebsite;
	}

	public boolean isTextgrup() {
		return textgrup;
	}

	public void setTextgrup(boolean textgrup) {
		this.textgrup = textgrup;
	}

	public boolean isUpanddownexel() {
		return upanddownexel;
	}

	public void setUpanddownexel(boolean upanddownexel) {
		this.upanddownexel = upanddownexel;
	}

	public boolean isEditmashindescription() {
		return editmashindescription;
	}

	public void setEditmashindescription(boolean editmashindescription) {
		this.editmashindescription = editmashindescription;
	}

	public Integer getDefaultcurrencyid() {
		return defaultcurrencyid;
	}

	public void setDefaultcurrencyid(Integer defaultcurrencyid) {
		this.defaultcurrencyid = defaultcurrencyid;
	}

	public String getDefaultcurrency() {
		return defaultcurrency;
	}

	public void setDefaultcurrency(String defaultcurrency) {
		this.defaultcurrency = defaultcurrency;
	}

	public String getServiceheadname() {
		return serviceheadname;
	}

	public void setServiceheadname(String serviceheadname) {
		this.serviceheadname = serviceheadname;
	}

	public Integer getServiceheadnameid() {
		return serviceheadnameid;
	}

	public void setServiceheadnameid(Integer serviceheadnameid) {
		this.serviceheadnameid = serviceheadnameid;
	}

	

	

//	public List<DropdownModel> getServiceheadlst() {
//		return serviceheadlst;
//	}
//
//	public void setServiceheadlst(List<DropdownModel> serviceheadlst) {
//		this.serviceheadlst = serviceheadlst;
//	}

	public Integer getPercentage() {
		return percentage;
	}

	public Integer getNodallowedbeforeservicecall() {
		return nodallowedbeforeservicecall;
	}

	public Integer getNodallwedbeforedcr() {
		return nodallwedbeforedcr;
	}

	public String getBucketname() {
		return bucketname;
	}

	public String getAmazons3key() {
		return amazons3key;
	}

	public String getAmazonserect3key() {
		return amazonserect3key;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}

	public void setNodallowedbeforeservicecall(Integer nodallowedbeforeservicecall) {
		this.nodallowedbeforeservicecall = nodallowedbeforeservicecall;
	}

	public void setNodallwedbeforedcr(Integer nodallwedbeforedcr) {
		this.nodallwedbeforedcr = nodallwedbeforedcr;
	}

	public void setBucketname(String bucketname) {
		this.bucketname = bucketname;
	}

	public void setAmazons3key(String amazons3key) {
		this.amazons3key = amazons3key;
	}

	public void setAmazonserect3key(String amazonserect3key) {
		this.amazonserect3key = amazonserect3key;
	}

	public Integer getNoofdaysescalate() {
		return noofdaysescalate;
	}

	public void setNoofdaysescalate(Integer noofdaysescalate) {
		this.noofdaysescalate = noofdaysescalate;
	}

	

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public List<CompanyModel> getComplst() {
		return complst;
	}

	public void setComplst(List<CompanyModel> complst) {
		this.complst = complst;
	}

	public List<DropdownModel> getDefautcurrlst() {
		return defautcurrlst;
	}

	public void setDefautcurrlst(List<DropdownModel> defautcurrlst) {
		this.defautcurrlst = defautcurrlst;
	}

	public String getCustomervalue() {
		return customervalue;
	}

	public void setCustomervalue(String customervalue) {
		this.customervalue = customervalue;
	}

	public String getMaxvalues() {
		return maxvalues;
	}

	public void setMaxvalues(String maxvalues) {
		this.maxvalues = maxvalues;
	}

	public List<CompanyModel> getModellst() {
		return modellst;
	}

	public void setModellst(List<CompanyModel> modellst) {
		this.modellst = modellst;
	}

	public Character getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(Character activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getSubModuleId() {
		return subModuleId;
	}

	public void setSubModuleId(Integer subModuleId) {
		this.subModuleId = subModuleId;
	}

	public String getModuleflagName() {
		return moduleflagName;
	}

	public void setModuleflagName(String moduleflagName) {
		this.moduleflagName = moduleflagName;
	}

	public String getModuleflag() {
		return moduleflag;
	}

	public void setModuleflag(String moduleflag) {
		this.moduleflag = moduleflag;
	}

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public boolean isChkselect() {
		return chkselect;
	}

	public void setChkselect(boolean chkselect) {
		this.chkselect = chkselect;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	
	

}
