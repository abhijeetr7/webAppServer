package com.backend.webappserver.payload;

import java.util.ArrayList;
import java.util.List;

public class User {
	private Integer id;
	private String username;
	private String password;
	private String message;
	private String fullname;
	private String mastername;
	private Integer userid;
	private String accessToken;
	private String dbName;
	private String companyName;
	private String companylogo;
	private Integer usergroupid;
	private String landpage;
	private String pagename;
	private String name;
	private String code;
	private String typeidq;
//	private Integer zoneid;
//	private Integer regionid;
//	private Integer accid;
//	private Integer areaid;
	private Integer trnid;
//	private Integer terrid;
//	private Integer patchid;
//	private Integer localid;
//	private Character isapproval;
//	private String accesstype;
//	private String servicecallNo;
//	private String companyaddress;
	private String address;
//	private String assignbyname;
//	private Character locking;
//	private Integer noofdays;
//	private Integer assignBy;
//	private String sendstring;
	   private String callingFrom;
	private Integer start;
	private Integer end;
	private Integer pageno;
	private Integer pageSize;
	public String samplecode;
//	private String token; 
//	private Integer productcategoryId;
//	private Integer spareCategoryid;
	private boolean status;
//	private Integer locationID;
//	private String statusCode;
//	private Integer cityid;
//	private String calltype; 
//	private Integer productID;
//	private Integer totalItems;
	private String txtserch;
//	private Integer poid;
//	private Integer teamid;
//	private Integer suppilerid;
	private Integer userId;
	private String alert;
	
	
	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}

	public Integer getPageno() {
		return pageno;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageno(Integer pageno) {
		this.pageno = pageno;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
//
//	public Integer getZoneid() {
//		return zoneid;
//	}
//
//	public Integer getRegionid() {
//		return regionid;
//	}
//
//	public void setZoneid(Integer zoneid) {
//		this.zoneid = zoneid;
//	}
//
//	public void setRegionid(Integer regionid) {
//		this.regionid = regionid;
//	}

	public String getCompanyName() {
		return companyName;
	}

	public String getCompanylogo() {
		return companylogo;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setCompanylogo(String companylogo) {
		this.companylogo = companylogo;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public String getDbName() {
		return dbName;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getMastername() {
		return mastername;
	}

	public void setMastername(String mastername) {
		this.mastername = mastername;
	}

	public Integer getUsergroupid() {
		return usergroupid;
	}

	public void setUsergroupid(Integer usergroupid) {
		this.usergroupid = usergroupid;
	}

	public String getLandpage() {
		return landpage;
	}

	public void setLandpage(String landpage) {
		this.landpage = landpage;
	}

	public String getPagename() {
		return pagename;
	}

	public void setPagename(String pagename) {
		this.pagename = pagename;
	}

	public Integer getTrnid() {
		return trnid;
	}

	public void setTrnid(Integer trnid) {
		this.trnid = trnid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
//
//	public Integer getAreaid() {
//		return areaid;
//	}
//
//	public void setAreaid(Integer areaid) {
//		this.areaid = areaid;
//	}
//
//	public Integer getTerrid() {
//		return terrid;
//	}
//
//	public void setTerrid(Integer terrid) {
//		this.terrid = terrid;
//	}
//
//	public Integer getPatchid() {
//		return patchid;
//	}
//
//	public void setPatchid(Integer patchid) {
//		this.patchid = patchid;
//	}
//
//	public Integer getLocalid() {
//		return localid;
//	}
//
//	public void setLocalid(Integer localid) {
//		this.localid = localid;
//	}
//
//	public Character getIsapproval() {
//		return isapproval;
//	}
//
//	public void setIsapproval(Character isapproval) {
//		this.isapproval = isapproval;
//	}
//
//	public Character getLocking() {
//		return locking;
//	}
//
//	public void setLocking(Character locking) {
//		this.locking = locking;
//	}
//
//	public Integer getNoofdays() {
//		return noofdays;
//	}
//
//	public void setNoofdays(Integer noofdays) {
//		this.noofdays = noofdays;
//	}
//
//	public String getSendstring() {
//		return sendstring;
//	}
//
//	public void setSendstring(String sendstring) {
//		this.sendstring = sendstring;
//	}
//
//	public String getCompanyaddress() {
//		return companyaddress;
//	}
//
//	public void setCompanyaddress(String companyaddress) {
//		this.companyaddress = companyaddress;
//	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}
//
//	public String getAccesstype() {
//		return accesstype;
//	}
//
//	public void setAccesstype(String accesstype) {
//		this.accesstype = accesstype;
//	}
//
//	public String getToken() {
//		return token;
//	}
//
//	public void setToken(String token) {
//		this.token = token;
//	}
//
//	public Integer getProductcategoryId() {
//		return productcategoryId;
//	}
//
//	public void setProductcategoryId(Integer productcategoryId) {
//		this.productcategoryId = productcategoryId;
//	}
//
//	public Integer getLocationID() {
//		return locationID;
//	}
//
//	public void setLocationID(Integer locationID) {
//		this.locationID = locationID;
//	}
//
//	public String getCalltype() {
//		return calltype;
//	}
//
//	public void setCalltype(String calltype) {
//		this.calltype = calltype;
//	}
//
//	public Integer getAccid() {
//		return accid;
//	}
//
//	public void setAccid(Integer accid) {
//		this.accid = accid;
//	}
//
//	public String getServicecallNo() {
//		return servicecallNo;
//	}
//
//	public void setServicecallNo(String servicecallNo) {
//		this.servicecallNo = servicecallNo;
//	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
//
//	public Integer getAssignBy() {
//		return assignBy;
//	}
//
//	public void setAssignBy(Integer assignBy) {
//		this.assignBy = assignBy;
//	}
//
//	public String getAssignbyname() {
//		return assignbyname;
//	}
//
//	public void setAssignbyname(String assignbyname) {
//		this.assignbyname = assignbyname;
//	}
//
//	public Integer getSpareCategoryid() {
//		return spareCategoryid;
//	}
//
//	public void setSpareCategoryid(Integer spareCategoryid) {
//		this.spareCategoryid = spareCategoryid;
//	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

//	public String getStatusCode() {
//		return statusCode;
//	}
//
//	public void setStatusCode(String statusCode) {
//		this.statusCode = statusCode;
//	}
//
//	public Integer getCityid() {
//		return cityid;
//	}
//
//	public void setCityid(Integer cityid) {
//		this.cityid = cityid;
//	}
//
//	public Integer getProductID() {
//		return productID;
//	}
//
//	public void setProductID(Integer productID) {
//		this.productID = productID;
//	}
//
//	public Integer getTotalItems() {
//		return totalItems;
//	}
//
//	public void setTotalItems(Integer totalItems) {
//		this.totalItems = totalItems;
//	}

	public String getTxtserch() {
		return txtserch;
	}

	public void setTxtserch(String txtserch) {
		this.txtserch = txtserch;
	}

//	public Integer getPoid() {
//		return poid;
//	}
//
//	public void setPoid(Integer poid) {
//		this.poid = poid;
//	}
//
//	public Integer getTeamid() {
//		return teamid;
//	}
//
//	public void setTeamid(Integer teamid) {
//		this.teamid = teamid;
//	}
//
//	public Integer getSuppilerid() {
//		return suppilerid;
//	}
//
//	public void setSuppilerid(Integer suppilerid) {
//		this.suppilerid = suppilerid;
//	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCallingFrom() {
		return callingFrom;
	}

	public void setCallingFrom(String callingFrom) {
		this.callingFrom = callingFrom;
	}

	public String getTypeidq() {
		return typeidq;
	}

	public void setTypeidq(String typeidq) {
		this.typeidq = typeidq;
	}

	public String getSamplecode() {
		return samplecode;
	}

	public void setSamplecode(String samplecode) {
		this.samplecode = samplecode;
	}
	

}
