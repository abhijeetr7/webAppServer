package com.backend.webappserver.api;

import java.text.ParseException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.webappserver.data.model.Tbresource;
import com.backend.webappserver.page.service.ActivityService;
import com.backend.webappserver.page.service.BmsConfigurationService;
import com.backend.webappserver.page.service.CommonMasterService;
import com.backend.webappserver.page.service.DepartmentService;
import com.backend.webappserver.page.service.DesignationService;
import com.backend.webappserver.page.service.EmloyeeMasterService;
import com.backend.webappserver.page.service.IsolateService;
import com.backend.webappserver.page.service.ParameterconfService;
import com.backend.webappserver.page.service.ResourceService;
import com.backend.webappserver.page.service.UnitOfMeasureService;
import com.backend.webappserver.page.service.UserActivityAccess;
import com.backend.webappserver.page.service.WorkflowroleService;
import com.backend.webappserver.payload.BmsConfigurationModel;
import com.backend.webappserver.payload.CommonMasterModel;
import com.backend.webappserver.payload.DepartmentModel;
import com.backend.webappserver.payload.DesignationModel;
import com.backend.webappserver.payload.MicrobeMasterModel;
import com.backend.webappserver.payload.ParamModel;
import com.backend.webappserver.payload.ResourceModel;
import com.backend.webappserver.payload.SampleinvertModel;
import com.backend.webappserver.payload.UnitOfMeasureModel;
import com.backend.webappserver.payload.User;
import com.backend.webappserver.payload.UserActivityAcessModel;
import com.backend.webappserver.payload.activityModel;
import com.backend.webappserver.payload.employeeMasterModel;
import com.backend.webappserver.payload.workflowrolemodel;
import com.backend.webappserver.service.UserService;

@RestController
@RequestMapping("/api/master")

public class MasterApi {

	@Autowired
	private ActivityService activityService;
	private static final Logger logger = LoggerFactory.getLogger(MasterApi.class);
	
	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private DesignationService designationService;

	@Autowired
	private UnitOfMeasureService unitOfMeasureService;

	@Autowired
	private EmloyeeMasterService emloyeeMasterService;

	@Autowired
	private BmsConfigurationService bmsConfigurationService;

	@Autowired
	private UserService userService;

	@Autowired
	private ResourceService repositoryService;
	
	@Autowired
	private CommonMasterService commonMasterService;
	
	@Autowired
	private UserActivityAccess userActivityAccess;
	
	@Autowired
	private WorkflowroleService workflowroleService;

	@Autowired
	private ParameterconfService ParamService;
	
	@Autowired
	private IsolateService isolateService;

	@PostMapping("/getdepartment")
	public List<DepartmentModel> getdepartment(@Valid @RequestBody DepartmentModel usr) {
		List<DepartmentModel> dept = departmentService.getdepartment(usr);
		return dept;
	}

	@PostMapping("/getdepartmentById")
	public DepartmentModel getdepartmentById(@Valid @RequestBody User model) {
		DepartmentModel departmentmodel = departmentService.getdepartmentById(model.getTrnid());
		return departmentmodel;
	}

	@PostMapping("/savedepartment")
	public DepartmentModel savedepartment(@Valid @RequestBody DepartmentModel models) {
		DepartmentModel savedept = departmentService.savedepartment(models);
		return savedept;
	}

	@PostMapping("/dltdepartment")
	public DepartmentModel dltdepartment(@Valid @RequestBody DepartmentModel models) {
		DepartmentModel deletedept = departmentService.dltdepartment(models.getId());
		return deletedept;
	}

	@PostMapping("/departmentdelstatus")
	public DepartmentModel departmentdelstatus(@RequestBody DepartmentModel model) {
		return departmentService.departmentdelstatus(model);
	}

	@PostMapping("/getdesignation")
	public DesignationModel getdesignation(@Valid @RequestBody DesignationModel usr) {
		DesignationModel desig = designationService.getdesignation(usr);
		return desig;
	}

	@PostMapping("/savedesignation")
	public DesignationModel savedesignation(@Valid @RequestBody DesignationModel models) {
		DesignationModel savedesig = designationService.savedesignation(models);
		return savedesig;
	}

	@PostMapping("/dltdesignation")
	public DesignationModel dltdesignation(@Valid @RequestBody DesignationModel models) {
		DesignationModel deletedesig = designationService.dltdesignation(models.getId());
		return deletedesig;
	}

	@PostMapping("/getemployeemaster")
	public List<employeeMasterModel> getemployeemaster(@Valid @RequestBody employeeMasterModel usr) {
		List<employeeMasterModel> empmaster = emloyeeMasterService.getemployeemaster(usr);
		return empmaster;
	}

	@PostMapping("/saveemployeemaster")
	public employeeMasterModel saveemployeemaster(@Valid @RequestBody employeeMasterModel empmodels) {
		employeeMasterModel empmaster = emloyeeMasterService.saveemployeemaster(empmodels);
		return empmaster;
	}

	@PostMapping("/dltemployeemaster")
	public employeeMasterModel dltemployeemaster(@Valid @RequestBody employeeMasterModel dlmodels) {
		employeeMasterModel deleteemp = emloyeeMasterService.dltemployeemaster(dlmodels.getUserid());
		return deleteemp;
	}

	@PostMapping("/getunitofmesureById")
	public UnitOfMeasureModel getunitofmesureById(@Valid @RequestBody User model) {
		UnitOfMeasureModel unitmodel = unitOfMeasureService.getunitofmesureById(model.getTrnid());
		return unitmodel;
	}

	@PostMapping("/getempmasterfroEmp")
	public List<employeeMasterModel> getempmasterfroEmp(@Valid @RequestBody employeeMasterModel usr) {
		List<employeeMasterModel> getempmaster = emloyeeMasterService.getempmasterfroEmp(usr);
		return getempmaster;

	}

	@PostMapping("/getdesignationall")
	public List<DesignationModel> getdesignationall(@Valid @RequestBody DesignationModel usr) {
		List<DesignationModel> desig = designationService.getdesignationall(usr);
		return desig;
	}

//	@PostMapping("/deleteholiday")
//	public List<UnitHolidayModel>deleteholiday(@Valid @RequestBody UnitHolidayModel model){
//		List<UnitHolidayModel>deleteholiday = holidayService.deleteholiday(model);
//		return deleteholiday;
//	}

	@PostMapping("/getresources")
	public Tbresource getResources(@RequestBody ResourceModel user) {
		Tbresource resourceModel = repositoryService.getReportingManager(user);
		return resourceModel;
	}

	@PostMapping("/getEmployeedByid")
	public employeeMasterModel getEmployeedByid(@Valid @RequestBody User model) {
		employeeMasterModel employeemodel = emloyeeMasterService.getEmployeedByid(model.getTrnid());
		return employeemodel;
	}

	@PostMapping("/Employeechangedeletstatus")
	public employeeMasterModel Employeechangedeletstatus(@RequestBody employeeMasterModel model) {
		return emloyeeMasterService.Employeechangedeletstatus(model);
	}

	@PostMapping("/getMobileForChangePassword")
	public employeeMasterModel getMobileForChangePassword(@Valid @RequestBody User model) {
		employeeMasterModel getmobile = emloyeeMasterService.getMobileForChangePassword(model.getTrnid());
		return getmobile;
	}

	@PostMapping("/getSearchForEmployeeMaster")
	public List<employeeMasterModel> getSearchForEmployeeMaster(@Valid @RequestBody employeeMasterModel usr) {
		List<employeeMasterModel> searchemployee = emloyeeMasterService.getSearchForEmployeeMaster(usr);
		return searchemployee;
	}

	@PostMapping("/getallActiveuser")
	public List<ResourceModel> getallActiveuser(@Valid @RequestBody ResourceModel usr) {
		List<ResourceModel> lst = emloyeeMasterService.getAllUsers(usr);
		return lst;
	}

	@PostMapping("/getusergroup")
	public List<ResourceModel> getusergroup(@Valid @RequestBody ResourceModel usr) {
		List<ResourceModel> resmodlst = emloyeeMasterService.getusergroup(usr);
		return resmodlst;

	}

	@PostMapping("/getSearchForDepartmentHome")
	public List<DepartmentModel> getSearchForDepartmentHome(@Valid @RequestBody DepartmentModel usr) {
		List<DepartmentModel> getSearchdept = departmentService.getSearchForDepartmentHome(usr);
		return getSearchdept;
	}

	@PostMapping("/getSearchForDesignation")
	public List<DesignationModel> getSearchForDesignation(@Valid @RequestBody DesignationModel usr) {
		List<DesignationModel> searchDesignation = designationService.getSearchForDesignation(usr);
		return searchDesignation;
	}

	@PostMapping("/savebmsconfiguration")
	public BmsConfigurationModel savebmsconfiguration(@Valid @RequestBody BmsConfigurationModel models) {
		BmsConfigurationModel savebmsconf = bmsConfigurationService.savebmsconfiguration(models);
		return savebmsconf;
	}

	@PostMapping("/getunitofmeasure")
	public List<UnitOfMeasureModel> getunitofmeasure(@Valid @RequestBody UnitOfMeasureModel usr) {
		List<UnitOfMeasureModel> unitofmes = unitOfMeasureService.getunitofmeasure(usr);
		return unitofmes;
	}

	@PostMapping("/saveunitofmeasure")
	public UnitOfMeasureModel saveunitofmeasure(@Valid @RequestBody UnitOfMeasureModel models) {
		UnitOfMeasureModel saveunitogmes = unitOfMeasureService.saveunitofmeasure(models);
		return saveunitogmes;
	}


	@PostMapping("/unitmesuredelstatus")
	public UnitOfMeasureModel unitmesuredelstatus(@RequestBody UnitOfMeasureModel model) {
		return unitOfMeasureService.unitmesuredelstatus(model);
	}

	@PostMapping("/degination")
	public DesignationModel degination(@RequestBody DesignationModel model) {
		return designationService.degination(model);
	}

//		 @PostMapping("/projtagdelstatus")
//		 public ProjectTagModel projtagdelstatus(@RequestBody ProjectTagModel model){
//			 return projectTagService.projtagdelstatus(model);
//		 }


	@GetMapping("/getConfigData")
	public BmsConfigurationModel getConfigData() {
		BmsConfigurationModel retrunModel = bmsConfigurationService.getConfigData();
		return retrunModel;
	}


	@PostMapping("/getempmasterfroEmp1")
	public List<employeeMasterModel> getempmasterfroEmp1(@Valid @RequestBody employeeMasterModel usr) {
		List<employeeMasterModel> getempmaster = emloyeeMasterService.getempmasterfroEmp1(usr);
		return getempmaster;

	}

	@PostMapping("/getSearchForUnitOfMeasur")
	public List<UnitOfMeasureModel> getSearchForUnitOfMeasur(@Valid @RequestBody UnitOfMeasureModel usr) {
		List<UnitOfMeasureModel> searchunitofmes = unitOfMeasureService.getSearchForUnitOfMeasur(usr);
		return searchunitofmes;
	}

	@PostMapping("/getBMSConfByid")
	public BmsConfigurationModel getBMSConfByid(@Valid @RequestBody User model) {
		BmsConfigurationModel bmsModel = bmsConfigurationService.getBMSConfByid(model.getTrnid());
		return bmsModel;
	}

	@PostMapping("/getdepartmentForEmployee")
	public List<DepartmentModel> getdepartmentForEmployee(@Valid @RequestBody DepartmentModel usr) {
		List<DepartmentModel> dept = departmentService.getdepartmentForEmployee(usr);
		return dept;
	}

	@PostMapping("/getreportingmanagr")
	public List<employeeMasterModel> getreportingmanagr(@Valid @RequestBody employeeMasterModel usr) {
		List<employeeMasterModel> reportmanager = emloyeeMasterService.getreportingmanagr(usr);
		return reportmanager;
	}

	@PostMapping("/getallRecursiveResources")
	public List<Tbresource> getallRecursiveResources(@Valid @RequestBody User model) {
		List<Tbresource> tbresources = repositoryService.getallRecursiveResources(model.getUserId());
		return tbresources;
	}

	@PostMapping("/getempmasterfroEmpresource")
	public List<employeeMasterModel> getempmasterfroEmpresource(@Valid @RequestBody employeeMasterModel usr) {
		List<employeeMasterModel> getempmaster = emloyeeMasterService.getempmasterfroEmpresource(usr);
		return getempmaster;

	}

	@PostMapping("/saveworkrole")
	public workflowrolemodel saveworkrole(@Valid @RequestBody workflowrolemodel models) {
		workflowrolemodel saveworkroleall = workflowroleService.saveworkrole(models);
		return saveworkroleall;
	}

	@PostMapping("/getallworkflow")
	public List<workflowrolemodel> getallworkflow(@Valid @RequestBody workflowrolemodel usr) {
		List<workflowrolemodel> allworkflow = workflowroleService.getallworkflow(usr);
		return allworkflow;
	}

	@PostMapping("/saveactivity")
	public activityModel saveactivity(@Valid @RequestBody activityModel models) {
		activityModel activity = activityService.saveactivity(models);
		return activity;
	}

//	@PostMapping("/getactivityById")
//	public activityModel getactivityById(@Valid @RequestBody activityModel usr) {
//		activityModel activity = activityService.getactivityById(usr);
//		return activity;
//	}
	@PostMapping("/getactivityById")
	public activityModel getactivityById(@Valid @RequestBody activityModel model) {
		activityModel departmentmodel = activityService.getactivityById(model.getTrnid());
		return departmentmodel;
	}
	@PostMapping("/getactivity")
	public List<activityModel> getactivity(@Valid @RequestBody activityModel usr) {
		List<activityModel> activity = activityService.getactivity( usr);
		return activity;
	}
	@PostMapping("/activitydelstatus")
	public activityModel activitydelstatus(@RequestBody activityModel model) {
		return activityService.activitydelstatus(model);
	}
	@PostMapping("/getSearchForActivityHome")
	public List<activityModel> getSearchForActivityHome(@Valid @RequestBody activityModel usr) {
		List<activityModel> getSearchactivity = activityService.getSearchForActivityHome(usr);
		return getSearchactivity;
	}

	@PostMapping("/getCommonMaster")
	public List<CommonMasterModel> getCommonMaster(@Valid @RequestBody CommonMasterModel usr) {
		List<CommonMasterModel> comModel = commonMasterService.getCommonMaster(usr);
		return comModel;
	}
	@PostMapping("/savecommonmastertype")
	public CommonMasterModel savecommonmastertype(@Valid @RequestBody CommonMasterModel models) {
		CommonMasterModel savemastertype = commonMasterService.savecommonmastertype(models);
		return savemastertype;
	}
	
	@PostMapping("/getcommasterByID")
	public CommonMasterModel getcommasterByID(@Valid @RequestBody User model)  {
		CommonMasterModel mastermodel = commonMasterService.getcommasterByID(model.getTrnid());
		return mastermodel;
	}
	@PostMapping("/getcommasterTypeByID")
	public CommonMasterModel getmasterttypeByID(@Valid @RequestBody User model) {
		CommonMasterModel mastermodel = commonMasterService.getcommasterTypeByID(model.getTrnid());
		return mastermodel;
	}
	@PostMapping("/getCommasterType")
	public List<CommonMasterModel> getCommasterType(@Valid @RequestBody CommonMasterModel usr) {
		List<CommonMasterModel> comModel = commonMasterService.getCommasterType(usr);
		return comModel;
	}
	@PostMapping("/getCommasterTypefordropdown")
	public List<CommonMasterModel> getCommasterTypefordropdown(@Valid @RequestBody CommonMasterModel usr) {
		List<CommonMasterModel> comModel = commonMasterService.getCommasterTypefordropdown(usr);
		return comModel;
	}
	@PostMapping("/savecommonmaster")
	public CommonMasterModel savecommonmaster(@Valid @RequestBody CommonMasterModel models) {
		CommonMasterModel savemastertype = commonMasterService.savecommonmaster(models);
		return savemastertype;
	}
	@PostMapping("/gettypeformasterByID")
	public CommonMasterModel gettypeformasterByID(@Valid @RequestBody User model) {
		CommonMasterModel mastermodel = commonMasterService.gettypeformasterByID(model.getTrnid());
		return mastermodel;
	}
	@PostMapping("/changeStatusForCommonMaster")
	public CommonMasterModel changeStatusForCommonMaster(@RequestBody CommonMasterModel model) {
		return commonMasterService.changeStatusForCommonMaster(model);
	}
	@PostMapping("/changeStatusForCommonMasterType")
	public CommonMasterModel changeStatusForCommonMasterType(@RequestBody CommonMasterModel model) {
		return commonMasterService.changeStatusForCommonMasterType(model);
	}

	@PostMapping("/getworkflowbyid")
	public workflowrolemodel getworkflowbyid(@Valid @RequestBody workflowrolemodel usr) {
		workflowrolemodel getworkflowbyid1 = workflowroleService.getworkflowbyid(usr.getId());
		return getworkflowbyid1;

	}
	
	@PostMapping("/workflowtdelstatus")
	public workflowrolemodel workflowtdelstatus(@RequestBody workflowrolemodel model) {
		return workflowroleService.workflowtdelstatus(model);
	}

	@PostMapping("/getbandForTask")
	public List<employeeMasterModel> getbandForTask(@Valid @RequestBody employeeMasterModel usr) {
		List<employeeMasterModel> band = emloyeeMasterService.getworkflowroleForemp(usr);
		return band;
	}
	@PostMapping("/getresourceByroleId")
	public List<employeeMasterModel> getresourceByroleId(@Valid @RequestBody UserActivityAcessModel usr) {
		List<employeeMasterModel> resourceByroleId = userActivityAccess.getresourceByroleId(usr);
		return resourceByroleId;
	}
	@PostMapping("/getAllactivity")
	public List<UserActivityAcessModel> getAllactivity(@Valid @RequestBody UserActivityAcessModel usr) {
		List<UserActivityAcessModel> activity = userActivityAccess.getAllactivity(usr);
		return activity;
	}
    @PostMapping("/saveUserActivityAceess")
    public UserActivityAcessModel saveUserActivityAceess(@Valid @RequestBody UserActivityAcessModel team) {
    	UserActivityAcessModel saveUserActivitymodel = userActivityAccess.saveUserActivityAceess(team);
	return saveUserActivitymodel;
    }
	@PostMapping("/getCheckboxes")
	public List<UserActivityAcessModel> getCheckboxes(@Valid @RequestBody UserActivityAcessModel usr) {
		List<UserActivityAcessModel> checkboxes = userActivityAccess.getCheckboxes(usr);
		return checkboxes;
	}
	@PostMapping("/saveParameters")
	public ParamModel saveParameters(@Valid @RequestBody ParamModel models) {
		ParamModel activity = ParamService.saveParameters(models);
		return activity;
	}
	@PostMapping("/getParamconf")
	public ParamModel getParamconf(@Valid @RequestBody ParamModel models) {
		ParamModel returnModel = ParamService.getParamconf(models);
		return returnModel;
	}
	@PostMapping("/saveActivityParameters")
	public ParamModel saveActivityParameters(@Valid @RequestBody ParamModel models) {
		ParamModel activityParam = ParamService.saveActivityParameters(models);
		return activityParam;
	}

	@PostMapping("/getCommasterTypeformicrobe")
	public List<CommonMasterModel> getCommasterTypeformicrobe(@Valid @RequestBody CommonMasterModel usr) {
		List<CommonMasterModel> comModel = commonMasterService.getCommasterTypeformicrobe(usr);
		return comModel;
	}
	@PostMapping("/getCommonMastermicrobe")
	public List<CommonMasterModel> getCommonMastermicrobe(@Valid @RequestBody CommonMasterModel usr) {
		List<CommonMasterModel> comModel = commonMasterService.getCommonMastermicrobe(usr);
		return comModel;
	}
	
	@PostMapping("/saveMicrobemaster")
	public MicrobeMasterModel saveMicrobemaster(@Valid @RequestBody MicrobeMasterModel mmastsr) {
		MicrobeMasterModel savemicrob = commonMasterService.saveMicrobemaster(mmastsr);
		return savemicrob;
	}
//	getmicrobemasterhome
	@PostMapping("/getmicrobemasterhome")
	public List<MicrobeMasterModel> getmicrobemasterhome(@Valid @RequestBody MicrobeMasterModel usr) {
		List<MicrobeMasterModel> microbehome = commonMasterService.getmicrobemasterhome(usr);
		return microbehome;
	}
	@PostMapping("/getmicrobemasterById")
	public MicrobeMasterModel getmicrobemasterById(@Valid @RequestBody MicrobeMasterModel model) {
		MicrobeMasterModel microbemodel = commonMasterService.getmicrobemasterById(model.getTrnid());
		return microbemodel;
	}
	@PostMapping("/deletemicrobeStatus")
	public MicrobeMasterModel deletemicrobeStatus(@RequestBody MicrobeMasterModel model) {
		return commonMasterService.deletemicrobeStatus(model);
	}
	@PostMapping("/getSearchForMicrobemaster")
	public List<MicrobeMasterModel> getSearchForMicrobemaster(@Valid @RequestBody MicrobeMasterModel usr) {
		List<MicrobeMasterModel> searchmicrob = commonMasterService.getSearchForMicrobemaster(usr);
		return searchmicrob;
	}

	@PostMapping("/getCommonMastermicrobeforGenus")
	public List<MicrobeMasterModel> getCommonMastermicrobeforGenus(@Valid @RequestBody MicrobeMasterModel usr) {
		List<MicrobeMasterModel> searchmicrob = commonMasterService.getCommonMastermicrobeforGenus(usr);
		return searchmicrob;
	}
	@PostMapping("/getCommonMasterforspecies")
	public List<MicrobeMasterModel> getCommonMasterforspecies(@Valid @RequestBody MicrobeMasterModel usr) {
		List<MicrobeMasterModel> searchmicrob = commonMasterService.getCommonMasterforspecies(usr);
		return searchmicrob;
	}
	@PostMapping("/getacttransactionByid")
	public activityModel getacttransactionByid(@Valid @RequestBody User model) {
		activityModel actbemodel = isolateService.getacttransactionByid(model.getTrnid());
	return actbemodel;
	}
	@PostMapping("/getactivityforparamconf")
	public List<activityModel> getactivityforparamconf(@Valid @RequestBody activityModel usr) {
		List<activityModel> activity = ParamService.getactivityforparamconf( usr);
		return activity;
	}
	@PostMapping("/getCommasterTypefordependacy")
	public List<CommonMasterModel> getCommasterTypefordependacy(@Valid @RequestBody CommonMasterModel usr) {
		List<CommonMasterModel> comModel = commonMasterService.getCommasterTypefordependacy(usr);
		return comModel;
	}
	@PostMapping("/getCommonMasterfordependancy")
	public List<CommonMasterModel> getCommonMasterfordependancy(@Valid @RequestBody CommonMasterModel usr) {
		List<CommonMasterModel> comModel = commonMasterService.getCommonMasterfordependancy(usr);
		return comModel;
	}
	
	@PostMapping("/savecommonmasterdependancy")
	public CommonMasterModel savecommonmasterdependancy(@Valid @RequestBody CommonMasterModel models)  {
		CommonMasterModel savemastertypedepe = commonMasterService.savecommonmasterdependancy(models);
		return savemastertypedepe;
	}
	
	@PostMapping("/getLevel2ActivityByid")
	public activityModel getLevel2ActivityByid(@Valid @RequestBody User model) {
		activityModel actmodel = isolateService.getLevel2ActivityByid(model.getTrnid());
	return actmodel;
	}
	@PostMapping("/getActivityParametersByid")
	public ParamModel getActivityParametersByid(@Valid @RequestBody ParamModel models) {
		ParamModel returnModel = ParamService.getActivityParametersByid(models);
		return returnModel;
	}
	@PostMapping("/getAccessDetails")
	public UserActivityAcessModel getActivityParametersByid(@Valid @RequestBody UserActivityAcessModel user) {
		UserActivityAcessModel returnModel = userActivityAccess.getAccessDetails(user);
		return returnModel;
	}
	
	@PostMapping("/getAllUsers")
	public List<employeeMasterModel> getAllUsers(@Valid @RequestBody employeeMasterModel usr) {
		List<employeeMasterModel> getempmaster = emloyeeMasterService.getAllUsers(usr);
		return getempmaster;

	}

}
