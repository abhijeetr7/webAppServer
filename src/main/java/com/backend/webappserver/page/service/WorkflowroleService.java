package com.backend.webappserver.page.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.webappserver.data.model.TbDepartment;
import com.backend.webappserver.data.model.Tbdesignation;
import com.backend.webappserver.data.model.Tbworkflowrole;
import com.backend.webappserver.payload.DepartmentModel;
import com.backend.webappserver.payload.DesignationModel;
import com.backend.webappserver.payload.SaveSuccessModel;
import com.backend.webappserver.payload.workflowrolemodel;
import com.backend.webappserver.repository.DepartmentRepository;
import com.backend.webappserver.repository.WorkflowroleRepository;

@Service
public class WorkflowroleService {
	@Autowired
	private WorkflowroleRepository workflowroleRepository;

	public workflowrolemodel saveworkrole(@Valid workflowrolemodel models) {
		SaveSuccessModel save = new SaveSuccessModel();
		workflowrolemodel saveworkroleall = new workflowrolemodel();
		Tbworkflowrole workflow = null;
		if (models.getId() != null) {
			workflow = workflowroleRepository.findByid(models.getId());
		} else {
			workflow = new Tbworkflowrole();
			workflow.setActiveStatus('Y');
			workflow.setAdddate(new Date());
			workflow.setAdduserid(models.getUserid());
		}
		
		workflow.setShortname(models.getShortname());
		workflow.setRole(models.getRole());
		
		workflow.setHierarchy(models.getHierarchy());
//		if(models.isChkselect()) {
			String s1 = "";
			if (models.isAdd()) {
				s1 = s1 + "Add,";
			}
			if (models.isEdit()) {
				s1 = s1 + "Edit,";
			}
			if (models.isView()) {
				s1 = s1 + "View,";
			}
			if (models.isDelete()) {
				s1 = s1 + "Delete,";
			}
			if (models.isApprove()) {
				s1 = s1 + "Approve,";
			}
			if (models.isMicrobe()) {
				s1 = s1 + "Microbe,";
			}
			workflow.setPermissions(s1);
//		}
		
		try {
			workflowroleRepository.save(workflow);
	} catch (Exception ex) {

	
		saveworkroleall.setStatus1("Success1");
		saveworkroleall.setRescoremessage("This Hierarchy Is Already Present!");
		return saveworkroleall;
		
	}
		saveworkroleall.setMessage("Record Saved Successfully!");
		saveworkroleall.setStatus("Success");
		return saveworkroleall;
	}

	

	public List<workflowrolemodel> getallworkflow(@Valid workflowrolemodel usr) {

		List<workflowrolemodel>  workrole = new ArrayList<workflowrolemodel>();
		int i = 1;
		List<Tbworkflowrole> workflow = workflowroleRepository.findAll();
		for (Tbworkflowrole tbworkflowrole : workflow) {
			workflowrolemodel workroleall = new workflowrolemodel();
			workroleall.setSrno(i);
			if (tbworkflowrole.getId() != null) {
				workroleall.setId(tbworkflowrole.getId());
			}
			if(tbworkflowrole.getShortname()!=null) {
				workroleall.setShortname(tbworkflowrole.getShortname());
			}
			if(tbworkflowrole.getRole()!=null) {
				workroleall.setRole(tbworkflowrole.getRole());
			}
			if(tbworkflowrole.getHierarchy()!=null) {
				workroleall.setHierarchy(tbworkflowrole.getHierarchy());
			}
			if(tbworkflowrole.getActiveStatus()!=null) {
				workroleall.setActiveStatus(tbworkflowrole.getActiveStatus());
			}
			workrole.add(workroleall);
			i++;
		}
	

		return workrole;
	}



	public workflowrolemodel getworkflowbyid(Integer id) {
		workflowrolemodel  workroleall = new workflowrolemodel ();
		Tbworkflowrole work = workflowroleRepository.findByid(id);

		if (work.getId() != null) {
			workroleall.setId(work.getId());
		}
		if(work.getShortname()!=null) {
			workroleall.setShortname(work.getShortname());
		}
		if(work.getRole()!=null) {
			workroleall.setRole(work.getRole());
		}
		if(work.getHierarchy()!=null) {
			workroleall.setHierarchy(work.getHierarchy());
		}
		if(work.getActiveStatus()!=null) {
			workroleall.setActiveStatus(work.getActiveStatus());
		}
		String perm[] = work.getPermissions().split(",");
		for (String string : perm) {
			if (string.equals("Add")) {
				workroleall.setAdd(true);
			} else if (string.equals("Edit")) {
				workroleall.setEdit(true);
			} else if (string.equals("View")) {
				workroleall.setView(true);
			} else if (string.equals("Delete")) {
				workroleall.setDelete(true);
			}else if (string.equals("Approve")) {
				workroleall.setApprove(true);
			}
			 else if (string.equals("Microbe")) {
					workroleall.setMicrobe(true);
				}
		}
		
		return workroleall;
	}

	public workflowrolemodel workflowtdelstatus(workflowrolemodel model) {
		SaveSuccessModel savemodel = new SaveSuccessModel();
		workflowrolemodel workmodel = new workflowrolemodel();
		Tbworkflowrole tbwork = null;

		
			if (model.getId() != null) {
				tbwork = workflowroleRepository.findById(model.getId()).get();
				if (model.getActiveStatus() != null && model.getActiveStatus().equals('Y')) {
					tbwork.setActiveStatus('Y');
				} else {
					tbwork.setActiveStatus('N');
				}
				workflowroleRepository.save(tbwork);
				if (model.getActiveStatus().equals('N')) {
					workmodel.setStatus("Success");
					workmodel.setMessage("Record Deleted Successfully!");
				} else {
					workmodel.setRescoremessage("Deleted Record Successfully Recovered!");
					workmodel.setStatus1("Success2");
				}
			}
		
		return workmodel;
		
	}

//	public DepartmentModel departmentdelstatus(DepartmentModel model) {
//		SaveSuccessModel savemodel = new SaveSuccessModel();
//		DepartmentModel departmentmodel = new DepartmentModel();
//		TbDepartment tbdept = null;
//
//		Integer resourcecount = resourceRepository.findByDepartmentIdForDeleteMessage(model.getId());
//		if (resourcecount != null && resourcecount < 0) {
//			departmentmodel.setStatus("Failed");
//			departmentmodel.setMessage("Unit present Under Cluster");
//		} else {
//			if (model.getId() != null) {
//				tbdept = departmentRepository.findById(model.getId()).get();
//				if (model.getActiveStatus() != null && model.getActiveStatus().equals('Y')) {
//					tbdept.setActiveStatus('Y');
//				} else {
//					tbdept.setActiveStatus('N');
//				}
//				departmentRepository.save(tbdept);
//				if (model.getActiveStatus().equals('N')) {
//					departmentmodel.setStatus("Success");
//					departmentmodel.setMessage("Record Deleted Successfully!");
//				} else {
//					departmentmodel.setRescoremessage("Deleted Record Successfully Recovered!");
//					departmentmodel.setStatus1("Success2");
//				}
//			}
//		}
//		return departmentmodel;
//
//	}
	



}