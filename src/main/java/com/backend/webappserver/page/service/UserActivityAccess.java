package com.backend.webappserver.page.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.webappserver.data.model.Tbactivity;
import com.backend.webappserver.data.model.Tbresource;
import com.backend.webappserver.data.model.Tbuseractivityactivityacess;
import com.backend.webappserver.data.model.Tbworkflowrole;
import com.backend.webappserver.payload.Checkboxmodel;
import com.backend.webappserver.payload.UserActivityAcessModel;
import com.backend.webappserver.payload.activityModel;
import com.backend.webappserver.payload.employeeMasterModel;
import com.backend.webappserver.repository.ActivityRepository;
import com.backend.webappserver.repository.EmployeeMasterRepository;
import com.backend.webappserver.repository.UserActivityAccessRepository;
import com.backend.webappserver.repository.WorkflowroleRepository;


@Service
public class UserActivityAccess {
	
	@Autowired
	private UserActivityAccessRepository activityacessRepository;
	
	@Autowired
	private EmployeeMasterRepository empMasterRepository;
	
	@Autowired
	private ActivityRepository activityRepository;
	
	@Autowired
	private WorkflowroleRepository workflowroleRepository;
	


	public List<employeeMasterModel> getresourceByroleId(@Valid UserActivityAcessModel usr) {
//		UserActivityAcessModel activeModel = new UserActivityAcessModel();
		List<employeeMasterModel> empmaster = new ArrayList<employeeMasterModel>();

		List<Tbresource> tbres = empMasterRepository.findByTbbandid(usr.getRoleid());
		
		for (Tbresource tbresource : tbres) {
			employeeMasterModel empmodel = new employeeMasterModel();
			if (tbresource.getEmployeecode() != null) {
				empmodel.setEmployeecode(tbresource.getEmployeecode());
			}
			if (tbresource.getName() != null) {
				empmodel.setName(tbresource.getName());
			}
			if (tbresource.getMiddlename() != null) {
				empmodel.setMiddlename(tbresource.getMiddlename());
			}
			if (tbresource.getLastname() != null) {
				empmodel.setLastname(tbresource.getLastname());
			}
			if (tbresource.getResourceID() != null) {
				empmodel.setResourceID(tbresource.getResourceID());
			}

			if (tbresource.getActiveStatus() != null) {
				empmodel.setActiveStatus(tbresource.getActiveStatus());
			}

			empmaster.add(empmodel);
		}
		
		return empmaster;
	}

	public List<UserActivityAcessModel> getAllactivity(@Valid UserActivityAcessModel usr) {

		List<UserActivityAcessModel> activity = new ArrayList<UserActivityAcessModel>();
		Integer i = 1;
//		if (usr.getResourceId() == null) {
		List<Tbactivity> act = activityRepository.findByAdduserID(usr.getUserid());
		for (Tbactivity tbactivity : act) {
			UserActivityAcessModel actmodel = new UserActivityAcessModel();
			actmodel.setSrno(i);
			if (tbactivity.getId() != null) {
				actmodel.setActivityID(tbactivity.getId());
				actmodel.setId(tbactivity.getId());
//					Tbuseractivityactivityacess tbuser = activityacessRepository.findByActivityid(tbactivity.getId());
//					if (tbuser != null) {
//						UserActivityAcessModel usrmodel = new UserActivityAcessModel();
				actmodel.setSrno(i);
				actmodel.setShortname(tbactivity.getShortname());
				actmodel.setActivityname(tbactivity.getActivityname());
				actmodel.setSequence(tbactivity.getSequence());

				if (usr.getUserid() != null) {
					Tbresource emp = empMasterRepository.findByresourceID(usr.getUserid());
					if (emp.getUsergroupid() != null) {
						actmodel.setRoleid(emp.getUsergroupid());
						Tbworkflowrole workflow = workflowroleRepository.findByid(emp.getUsergroupid());
						if (workflow != null) {
							String perm[] = workflow.getPermissions().split(",");
							for (String string : perm) {

								if (string.equals("Add")) {
									actmodel.setAdd(true);
								} else if (string.equals("Edit")) {
									actmodel.setEdit(true);
								} else if (string.equals("View")) {
									actmodel.setView(true);
								} else if (string.equals("Delete")) {
									actmodel.setDelete(true);
								}
							}

						}

					}
				}
				activity.add(actmodel);
				i++;
//					}
			}

		}
		return activity;
	}

	public UserActivityAcessModel saveUserActivityAceess(@Valid UserActivityAcessModel team) {
		UserActivityAcessModel model = new UserActivityAcessModel();
		Tbuseractivityactivityacess tbuseraccess = null;
		if (team.getId() != null) {
				tbuseraccess = activityacessRepository.findById(team.getId()).get();
		} 
		else {
//			Tbuseractivityactivityacess tem = activityacessRepository.findByActivityid(team.getActivityID());
//			if (tem != null) {
//				model.setMessage("Activity is alredy present");
//				return model;
//			}
			tbuseraccess = new Tbuseractivityactivityacess();
		}
		
		
		
		if (team.getUsractivitylst().size() > 0) {
			for (UserActivityAcessModel activity : team.getUsractivitylst()) {
//				List<Tbactivity> act = activityRepository.findById(activity.getActivityID());
//				for (Tbactivity activity1 : act) {
				Tbuseractivityactivityacess usersAccess = null;
				if (activity.isChkselect()) {
//					usersAccess = activityacessRepository.findByID(model.getId());
					
					if (usersAccess == null) {
						usersAccess = new Tbuseractivityactivityacess();
						tbuseraccess.setShortname(activity.getShortname());
						tbuseraccess.setActivityname(activity.getActivityname());
						tbuseraccess.setSequence(activity.getSequence());
						tbuseraccess = activityacessRepository.save(tbuseraccess);
					}
					usersAccess.setActiveStatus('Y');
					usersAccess.setResourceID(activity.getResourceId());
					usersAccess.setActivityid(activity.getId());
//					usersAccess.setShortname(activity.getShortname());
//					usersAccess.setActivityname(activity.getActivityname());
//					usersAccess.setSequence(activity.getSequence());
					String s1 = "";
					if (activity.isAdd()) {
						s1 = s1 + "Add,";
					}
					if (activity.isEdit()) {
						s1 = s1 + "Edit,";
					}
					if (activity.isView()) {
						s1 = s1 + "View,";
					}
					if (activity.isDelete()) {
						s1 = s1 + "Delete,";
					}
					tbuseraccess.setPermissions(s1);
					tbuseraccess = activityacessRepository.save(tbuseraccess);
				}
//			}
			}
		}
		
		
		model.setMessage("Record Saved Successfully");
		return model;
	}

	public List<UserActivityAcessModel> getCheckboxes(@Valid UserActivityAcessModel usr) {
		List<UserActivityAcessModel> actmodel = new ArrayList<UserActivityAcessModel>();
		List<Tbactivity> act = activityRepository.findAll();
		for (Tbactivity tbactivity : act) {
		List<Tbuseractivityactivityacess> tbuser1 = activityacessRepository.findByresourceID(usr.getResourceId());
		for (Tbuseractivityactivityacess tbuser : tbuser1) {
		if (tbuser != null) {
			UserActivityAcessModel usrmodel = new UserActivityAcessModel();
			String perm[] = tbuser.getPermissions().split(",");
			for (String string : perm) {
				if (string.equals("Add")) {
					usrmodel.setAdd(true);
				} else if (string.equals("Edit")) {
					usrmodel.setEdit(true);
				} else if (string.equals("View")) {
					usrmodel.setView(true);
				} else if (string.equals("Delete")) {
					usrmodel.setDelete(true);
				}
			}
			actmodel.add(usrmodel);
		}}
		}
		return actmodel;
	}

	public UserActivityAcessModel getAccessDetails(@Valid UserActivityAcessModel user) {
		UserActivityAcessModel returnModel = new UserActivityAcessModel();
		if (user.getResourceId() != null) {
			Tbresource resource = empMasterRepository.findByresourceID(user.getResourceId());
			returnModel.setId(resource.getTbband());
		}
		
		return returnModel;
	}




}
