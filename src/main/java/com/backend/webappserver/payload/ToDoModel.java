package com.backend.webappserver.payload;

import java.util.ArrayList;
import java.util.Date;

public class ToDoModel {
	
	private Integer id;
	private Integer routineactivities;
	private Integer projects;
	private Integer krakpi;
	private Integer initiativeimprovement;
	private Integer meetings;
	private Integer traveltime;
	private String activeStatus;
	private Integer reportingdate;
	private Date formonth;
	private Integer adduserid;
	private Date addDate;
	private Integer edituserid;
	private Date editDate;
	private String status;
	private Integer userID;
	private String message;
	private String rescoremessage;
	private Integer totalworkinghowerscontmonth;
	private Integer weeklyoffhowersofmonth;
	private Integer Weeklyoff;
	private Integer totalworkinghours;
	private Integer resourceid;
//	private Integer id;
	private Date fromdate;
	private Date todate;
	private String activityDate;
//	private String status;
	private Character tasktype;
	private String activitytype;
	private String taskname;
	private String description;
	private String duration;
	private String meetingSubject;
	private Date meetingDate;
	private String meetingTime;
	private Integer userid;
	private String activityformat;
	private String TaskdurationMin;
	private String TaskdurationSec;
	private String resourcename;
	private String department;
	private String band;
	private String employecode;
	private String activityformatproject;
	private String activityformatkra;
	private String activityformatIandI;
	private String conformattandance;
	private String from1000to1030;
	private String from1030to1100;
	private String from1100to1130;
	private String from1130to1200;
	private String from1200to1230;
	private String from1230to1300;
	private String from1300to1330;
	private String from1330to1400;
	private String from1400to1430;
	private String from1430to1500;
	private String from1500to1530;
	private String from1530to1600;
	private String from1600to1630;
	private String from1630to1700;
	private String from1700to1730;
	private String from1730to1800;
    private String kpitotalcount;
    private String projecttottalcount;
    private String travletotalcount;
    private String itoicount;
    private String meetingcount;
	private String genralcount;
	private String kpitotalcountmin;
	private String projecttottalcountmin;
	private String travletotalcountmin;
	private String itoicountmin;
	private String meetingcountmin;
	private String genralcountmin;
	private String companyName;
	private String companyAddress;
	private String plantcode;
	private Integer TotalAllCountHourse;
	private Integer allcountmin;
	private String Clusterunit;
	private String kpiname;
	private Integer taskid;
	private Integer version;
	private Character difftype;
	private Integer resourceID;
	private String monthidFrom;
	private String monthidTo;
//	private String monthidFrmstring;
	
	
	private ArrayList<Integer> resourceidlist = new ArrayList<Integer>();
	
	public ArrayList<Integer> getResourceidlist() {
		return resourceidlist;
	}
	public void setResourceidlist(ArrayList<Integer> resourceidlist) {
		this.resourceidlist = resourceidlist;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoutineactivities() {
		return routineactivities;
	}
	public void setRoutineactivities(Integer routineactivities) {
		this.routineactivities = routineactivities;
	}
	public Integer getProjects() {
		return projects;
	}
	public void setProjects(Integer projects) {
		this.projects = projects;
	}
	public Integer getKrakpi() {
		return krakpi;
	}
	public void setKrakpi(Integer krakpi) {
		this.krakpi = krakpi;
	}
	public Integer getInitiativeimprovement() {
		return initiativeimprovement;
	}
	public void setInitiativeimprovement(Integer initiativeimprovement) {
		this.initiativeimprovement = initiativeimprovement;
	}
	public Integer getMeetings() {
		return meetings;
	}
	public void setMeetings(Integer meetings) {
		this.meetings = meetings;
	}
	public Integer getTraveltime() {
		return traveltime;
	}
	public void setTraveltime(Integer traveltime) {
		this.traveltime = traveltime;
	}

	public Integer getReportingdate() {
		return reportingdate;
	}
	public void setReportingdate(Integer reportingdate) {
		this.reportingdate = reportingdate;
	}
	public Integer getAdduserid() {
		return adduserid;
	}
	public void setAdduserid(Integer adduserid) {
		this.adduserid = adduserid;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public Integer getEdituserid() {
		return edituserid;
	}
	public void setEdituserid(Integer edituserid) {
		this.edituserid = edituserid;
	}
	public Date getEditDate() {
		return editDate;
	}
	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
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
	public Date getFormonth() {
		return formonth;
	}
	public void setFormonth(Date formonth) {
		this.formonth = formonth;
	}
	public Integer getTotalworkinghowerscontmonth() {
		return totalworkinghowerscontmonth;
	}
	public void setTotalworkinghowerscontmonth(Integer totalworkinghowerscontmonth) {
		this.totalworkinghowerscontmonth = totalworkinghowerscontmonth;
	}
	public Integer getWeeklyoffhowersofmonth() {
		return weeklyoffhowersofmonth;
	}
	public void setWeeklyoffhowersofmonth(Integer weeklyoffhowersofmonth) {
		this.weeklyoffhowersofmonth = weeklyoffhowersofmonth;
	}
	public String getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}
	public Integer getWeeklyoff() {
		return Weeklyoff;
	}
	public void setWeeklyoff(Integer weeklyoff) {
		Weeklyoff = weeklyoff;
	}
	public Integer getTotalworkinghours() {
		return totalworkinghours;
	}
	public void setTotalworkinghours(Integer totalworkinghours) {
		this.totalworkinghours = totalworkinghours;
	}
	public Integer getResourceid() {
		return resourceid;
	}
	public void setResourceid(Integer resourceid) {
		this.resourceid = resourceid;
	}
	public Date getFromdate() {
		return fromdate;
	}
	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}
	public Date getTodate() {
		return todate;
	}
	public void setTodate(Date todate) {
		this.todate = todate;
	}
	public String getActivityDate() {
		return activityDate;
	}
	public void setActivityDate(String activityDate) {
		this.activityDate = activityDate;
	}
	public Character getTasktype() {
		return tasktype;
	}
	public void setTasktype(Character tasktype) {
		this.tasktype = tasktype;
	}
	public String getActivitytype() {
		return activitytype;
	}
	public void setActivitytype(String activitytype) {
		this.activitytype = activitytype;
	}
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getMeetingSubject() {
		return meetingSubject;
	}
	public void setMeetingSubject(String meetingSubject) {
		this.meetingSubject = meetingSubject;
	}
	public Date getMeetingDate() {
		return meetingDate;
	}
	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}
	public String getMeetingTime() {
		return meetingTime;
	}
	public void setMeetingTime(String meetingTime) {
		this.meetingTime = meetingTime;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getActivityformat() {
		return activityformat;
	}
	public void setActivityformat(String activityformat) {
		this.activityformat = activityformat;
	}
	public String getTaskdurationMin() {
		return TaskdurationMin;
	}
	public void setTaskdurationMin(String taskdurationMin) {
		TaskdurationMin = taskdurationMin;
	}
	public String getTaskdurationSec() {
		return TaskdurationSec;
	}
	public void setTaskdurationSec(String taskdurationSec) {
		TaskdurationSec = taskdurationSec;
	}
	public String getResourcename() {
		return resourcename;
	}
	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getBand() {
		return band;
	}
	public void setBand(String band) {
		this.band = band;
	}
	public String getEmployecode() {
		return employecode;
	}
	public void setEmployecode(String employecode) {
		this.employecode = employecode;
	}
	public String getActivityformatproject() {
		return activityformatproject;
	}
	public void setActivityformatproject(String activityformatproject) {
		this.activityformatproject = activityformatproject;
	}
	public String getActivityformatkra() {
		return activityformatkra;
	}
	public void setActivityformatkra(String activityformatkra) {
		this.activityformatkra = activityformatkra;
	}
	public String getActivityformatIandI() {
		return activityformatIandI;
	}
	public void setActivityformatIandI(String activityformatIandI) {
		this.activityformatIandI = activityformatIandI;
	}
	public String getConformattandance() {
		return conformattandance;
	}
	public void setConformattandance(String conformattandance) {
		this.conformattandance = conformattandance;
	}
	public String getFrom1000to1030() {
		return from1000to1030;
	}
	public void setFrom1000to1030(String from1000to1030) {
		this.from1000to1030 = from1000to1030;
	}
	public String getFrom1030to1100() {
		return from1030to1100;
	}
	public void setFrom1030to1100(String from1030to1100) {
		this.from1030to1100 = from1030to1100;
	}
	public String getFrom1100to1130() {
		return from1100to1130;
	}
	public void setFrom1100to1130(String from1100to1130) {
		this.from1100to1130 = from1100to1130;
	}
	public String getFrom1130to1200() {
		return from1130to1200;
	}
	public void setFrom1130to1200(String from1130to1200) {
		this.from1130to1200 = from1130to1200;
	}
	public String getFrom1200to1230() {
		return from1200to1230;
	}
	public void setFrom1200to1230(String from1200to1230) {
		this.from1200to1230 = from1200to1230;
	}
	public String getFrom1230to1300() {
		return from1230to1300;
	}
	public void setFrom1230to1300(String from1230to1300) {
		this.from1230to1300 = from1230to1300;
	}
	public String getFrom1300to1330() {
		return from1300to1330;
	}
	public void setFrom1300to1330(String from1300to1330) {
		this.from1300to1330 = from1300to1330;
	}
	public String getFrom1330to1400() {
		return from1330to1400;
	}
	public void setFrom1330to1400(String from1330to1400) {
		this.from1330to1400 = from1330to1400;
	}
	public String getFrom1400to1430() {
		return from1400to1430;
	}
	public void setFrom1400to1430(String from1400to1430) {
		this.from1400to1430 = from1400to1430;
	}
	public String getFrom1430to1500() {
		return from1430to1500;
	}
	public void setFrom1430to1500(String from1430to1500) {
		this.from1430to1500 = from1430to1500;
	}
	public String getFrom1500to1530() {
		return from1500to1530;
	}
	public void setFrom1500to1530(String from1500to1530) {
		this.from1500to1530 = from1500to1530;
	}
	public String getFrom1530to1600() {
		return from1530to1600;
	}
	public void setFrom1530to1600(String from1530to1600) {
		this.from1530to1600 = from1530to1600;
	}
	public String getFrom1600to1630() {
		return from1600to1630;
	}
	public void setFrom1600to1630(String from1600to1630) {
		this.from1600to1630 = from1600to1630;
	}
	public String getFrom1630to1700() {
		return from1630to1700;
	}
	public void setFrom1630to1700(String from1630to1700) {
		this.from1630to1700 = from1630to1700;
	}
	public String getFrom1700to1730() {
		return from1700to1730;
	}
	public void setFrom1700to1730(String from1700to1730) {
		this.from1700to1730 = from1700to1730;
	}
	public String getFrom1730to1800() {
		return from1730to1800;
	}
	public void setFrom1730to1800(String from1730to1800) {
		this.from1730to1800 = from1730to1800;
	}
	public String getKpitotalcount() {
		return kpitotalcount;
	}
	public void setKpitotalcount(String kpitotalcount) {
		this.kpitotalcount = kpitotalcount;
	}
	public String getProjecttottalcount() {
		return projecttottalcount;
	}
	public void setProjecttottalcount(String projecttottalcount) {
		this.projecttottalcount = projecttottalcount;
	}
	public String getTravletotalcount() {
		return travletotalcount;
	}
	public void setTravletotalcount(String travletotalcount) {
		this.travletotalcount = travletotalcount;
	}
	public String getItoicount() {
		return itoicount;
	}
	public void setItoicount(String itoicount) {
		this.itoicount = itoicount;
	}
	public String getMeetingcount() {
		return meetingcount;
	}
	public void setMeetingcount(String meetingcount) {
		this.meetingcount = meetingcount;
	}
	public String getGenralcount() {
		return genralcount;
	}
	public void setGenralcount(String genralcount) {
		this.genralcount = genralcount;
	}
	public String getKpitotalcountmin() {
		return kpitotalcountmin;
	}
	public void setKpitotalcountmin(String kpitotalcountmin) {
		this.kpitotalcountmin = kpitotalcountmin;
	}
	public String getProjecttottalcountmin() {
		return projecttottalcountmin;
	}
	public void setProjecttottalcountmin(String projecttottalcountmin) {
		this.projecttottalcountmin = projecttottalcountmin;
	}
	public String getTravletotalcountmin() {
		return travletotalcountmin;
	}
	public void setTravletotalcountmin(String travletotalcountmin) {
		this.travletotalcountmin = travletotalcountmin;
	}
	public String getItoicountmin() {
		return itoicountmin;
	}
	public void setItoicountmin(String itoicountmin) {
		this.itoicountmin = itoicountmin;
	}
	public String getMeetingcountmin() {
		return meetingcountmin;
	}
	public void setMeetingcountmin(String meetingcountmin) {
		this.meetingcountmin = meetingcountmin;
	}
	public String getGenralcountmin() {
		return genralcountmin;
	}
	public void setGenralcountmin(String genralcountmin) {
		this.genralcountmin = genralcountmin;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyAddress() {
		return companyAddress;
	}
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	public String getPlantcode() {
		return plantcode;
	}
	public void setPlantcode(String plantcode) {
		this.plantcode = plantcode;
	}
	public Integer getTotalAllCountHourse() {
		return TotalAllCountHourse;
	}
	public void setTotalAllCountHourse(Integer totalAllCountHourse) {
		TotalAllCountHourse = totalAllCountHourse;
	}
	public Integer getAllcountmin() {
		return allcountmin;
	}
	public void setAllcountmin(Integer allcountmin) {
		this.allcountmin = allcountmin;
	}
	public String getClusterunit() {
		return Clusterunit;
	}
	public void setClusterunit(String clusterunit) {
		Clusterunit = clusterunit;
	}
	public String getKpiname() {
		return kpiname;
	}
	public void setKpiname(String kpiname) {
		this.kpiname = kpiname;
	}
	public Integer getTaskid() {
		return taskid;
	}
	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public Character getDifftype() {
		return difftype;
	}
	public void setDifftype(Character difftype) {
		this.difftype = difftype;
	}
	public Integer getResourceID() {
		return resourceID;
	}
	public void setResourceID(Integer resourceID) {
		this.resourceID = resourceID;
	}
	public String getMonthidFrom() {
		return monthidFrom;
	}
	public void setMonthidFrom(String monthidFrom) {
		this.monthidFrom = monthidFrom;
	}
	public String getMonthidTo() {
		return monthidTo;
	}
	public void setMonthidTo(String monthidTo) {
		this.monthidTo = monthidTo;
	}

	

	
	
	
}
