package com.backend.webappserver.page.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.webappserver.data.model.TbDepartment;
import com.backend.webappserver.data.model.Tbdesignation;
import com.backend.webappserver.data.model.TbemployeeMaster;
import com.backend.webappserver.data.model.Tbmenu;
import com.backend.webappserver.data.model.Tbresource;
import com.backend.webappserver.data.model.Tbusergroup;
import com.backend.webappserver.data.model.Tbworkflowrole;
import com.backend.webappserver.payload.ResourceModel;
import com.backend.webappserver.payload.SaveSuccessModel;
import com.backend.webappserver.payload.employeeMasterModel;
import com.backend.webappserver.repository.DepartmentRepository;
import com.backend.webappserver.repository.DesignationRepository;
import com.backend.webappserver.repository.EmployeeMasterRepository;
import com.backend.webappserver.repository.MenuRepository;
import com.backend.webappserver.repository.ResourceRepository;
import com.backend.webappserver.repository.UsergroupRepository;
import com.backend.webappserver.repository.WorkflowroleRepository;
import com.backend.webappserver.util.DateUtil;

@Service
public class EmloyeeMasterService {

	@Autowired
	private EmployeeMasterRepository employeeMasterRepository;
	
	@Autowired
	private ResourceRepository resourceRepository;
	
	
	@Autowired
	private MenuRepository menuRepository;

	@Autowired
	private DesignationRepository designationRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private UsergroupRepository usergroupRepository;
	
	@Autowired
	private WorkflowroleRepository workflowroleRepository;

//	public List<employeeMasterModel> getemployeemaster(@Valid employeeMasterModel usr) {
//		List<employeeMasterModel> empmaster = new ArrayList<employeeMasterModel>();
//		List<Tbresource> tbres = employeeMasterRepository.findAll();
//
//		employeeMasterModel empmodel = new employeeMasterModel();
//		for (Tbresource tbresource : tbres) {
//			if (tbresource.getEmployeecode() != null) {
//				empmodel.setEmployeecode(tbresource.getEmployeecode());
//			}
//			if (tbresource.getFirstname() != null) {
//				empmodel.setFirstname(tbresource.getFirstname());
//			}
//			if (tbresource.getMiddlename() != null) {
//				empmodel.setMiddlename(tbresource.getMiddlename());
//			}
//			if (tbresource.getLastname() != null) {
//				empmodel.setLastname(tbresource.getLastname());
//			}
////			if (tbresource.getUserid() != null) {
////				empmodel.setUserid(tbresource.getUserid());
////			}
//			if (tbresource.getActiveStatus() != null) {
//				empmodel.setActiveStatus(tbresource.getActiveStatus());
//			}
//			empmaster.add(empmodel);
//		}
//		return empmaster;
//	}

	public List<employeeMasterModel> getemployeemaster(@Valid employeeMasterModel usr) {
		List<employeeMasterModel> empmaster = new ArrayList<employeeMasterModel>();

		List<Tbresource> tbres = employeeMasterRepository.findAll();
		employeeMasterModel empmodel = new employeeMasterModel();
		for (Tbresource tbresource : tbres) {
			if (tbresource.getEmployeecode() != null) {
				empmodel.setEmployeecode(tbresource.getEmployeecode());
			}
			if (tbresource.getFirstname() != null) {
				empmodel.setFirstname(tbresource.getFirstname());
			}
			if (tbresource.getMiddlename() != null) {
				empmodel.setMiddlename(tbresource.getMiddlename());
			}
			if (tbresource.getLastname() != null) {
				empmodel.setLastname(tbresource.getLastname());
			}
//		if (tbresource.getUserid() != null) {
//			empmodel.setUserid(tbresource.getUserid());
//		}
			if (tbresource.getActiveStatus() != null) {
				empmodel.setActiveStatus(tbresource.getActiveStatus());
			}

			empmaster.add(empmodel);
		}
		return empmaster;
	}

	public employeeMasterModel saveemployeemaster(@Valid employeeMasterModel empmodels) {
		employeeMasterModel empsave = new employeeMasterModel();
		Tbresource res = null;
		Integer usergrp = null;
		if (empmodels.getResourceID() != null) {
			res = employeeMasterRepository.findByresourceID(empmodels.getResourceID());
			res.setEditdate(new Date());
			res.setEdituserid(empmodels.getUserID());
			usergrp = res.getUsergroupid();
//			if(empmodels.getGroupClusterUnit()!=null)
//			{
//				if(empmodels.getGroupClusterUnit().equals("U"))
//				{
//				res.setGroupClusterUnit("U");
//				}else {
//					res.setGroupClusterUnit("C");
//				}
//			}
//			res.setGroupClusterUnit(empmodels.getGroupClusterUnit());
		} else {
			res = new Tbresource();
			res.setAdddate(new Date());
			res.setAdduserid(empmodels.getUserID());
			res.setActiveStatus('Y');
			res.setActiveInactive('Y');

		}
		res.setResourceID(empmodels.getResourceID());
		res.setEmployeecode(empmodels.getEmployeecode());
		res.setSalutation(empmodels.getSalutation());
		res.setGender(empmodels.getGender());
		res.setFirstname(empmodels.getFirstname());
		res.setLoginName(empmodels.getSelfaccessforuser());
		res.setMiddlename(empmodels.getMiddlename());
		res.setLastname(empmodels.getLastname());
		res.setJoiningdate(empmodels.getJoiningdate());
		res.setResigndate(empmodels.getResigndate());
		res.setBirthdate(empmodels.getBirthdate());
		
		res.setName(
				empmodels.getFirstname() + " ".concat(empmodels.getMiddlename() + " ".concat(empmodels.getLastname())));
		res.setAddress(empmodels.getAddress());
		res.setMobile(empmodels.getMobile());
		res.setMobile1(empmodels.getMobile1());
		res.setMobile2(empmodels.getMobile2());
//		res.setPassword(empmodels.getMobile2());
		res.setEmail(empmodels.getEmail());
		res.setClusterunittype(empmodels.getClusterunit());
//		if(empmodels.getGroupClusterUnit()!=null)
//		{
		if (empmodels.getClusterunittype() != null) {
//			if(empmodels.getGroupClusterUnit().equals("U"))
			if (empmodels.getClusterunittype().equals("U")) {
				res.setGroupClusterUnit("U");
			} else {
				res.setGroupClusterUnit("C");
			}
		}
//		}
		res.setTbdepartment(empmodels.getTbdepartment());
		res.setTbdesignation(empmodels.getTbdesignation());
		res.setTbband(empmodels.getTbband());
		
		res.setTbband(empmodels.getTbband());
		res.setReportingmanager(empmodels.getReportingmanager());
		res.setSelfaccess(empmodels.getSelfaccessforuser());
		res.setAssistantaccess(empmodels.getSelfaccessforassistant());
//		res.setGroupClusterUnit(empmodels.getClusterunittype());
		res.setUsergroupid(empmodels.getUsergroupid());
//		if (empmodels.getSelfactive() != null && empmodels.getSelfactive()) {
//			res.setSelfactive('Y');
//			res.setActiveStatus('Y');
//		} else {
//			res.setActiveStatus('N');
//			res.setSelfactive('N');
//			res.setActiveStatus('N');
//		}

		if(empmodels.getSelfactive().equals(true)) {
			res.setSelfactive('Y');
		}
		if(empmodels.getSelfactive().equals(false)) {
			res.setSelfactive('N');
		}
		res.setTbdepartment(empmodels.getTbdepartment());
		res.setTbdesignation(empmodels.getTbdesignation());
		try {
			employeeMasterRepository.save(res);
			if (usergrp != null) {
				if (empmodels.getUsergroupid() != null) {
					if (!usergrp.equals(empmodels.getUsergroupid())) {
						List<Tbmenu> prevmenus = menuRepository.findByUseridAndActiveStatus(res.getResourceID(), 'Y');
						for (Tbmenu tbmenu : prevmenus) {
							tbmenu.setActiveStatus('N');
							tbmenu.setResourcegroupid(0);
							menuRepository.save(tbmenu);
						}
						List<Tbmenu> newMenulst = menuRepository
								.findByResourcegroupidAndParentidAndActiveStatus(empmodels.getUsergroupid(), 0, 'Y');
						for (Tbmenu tbmenu : newMenulst) {
							Tbmenu newmenu = new Tbmenu();
							newmenu.setParentid(0);
							newmenu.setSequence(tbmenu.getSequence());
							newmenu.setMenuname(tbmenu.getMenuname());
							newmenu.setMenupagename(tbmenu.getMenupagename());
							newmenu.setIssubmenu(tbmenu.getIssubmenu());
							newmenu.setUserid(res.getResourceID());
							newmenu.setGroupmenuid(tbmenu.getId());
							newmenu.setActiveStatus('Y');

							menuRepository.save(newmenu);

							List<Tbmenu> subMenulst1 = menuRepository.findByResourcegroupidAndParentidAndActiveStatus(
									empmodels.getUsergroupid(), tbmenu.getId(), 'Y');

							for (Tbmenu tbmenu2 : subMenulst1) {
								Tbmenu newmenu1 = new Tbmenu();
								newmenu1.setParentid(newmenu.getId());
								newmenu1.setSequence(tbmenu2.getSequence());
								newmenu1.setMenuname(tbmenu2.getMenuname());
								newmenu1.setMenupagename(tbmenu2.getMenupagename());
								newmenu1.setIssubmenu(tbmenu2.getIssubmenu());
								newmenu1.setUserid(res.getResourceID());
								newmenu1.setGroupmenuid(tbmenu2.getId());
								newmenu1.setActiveStatus('Y');
								menuRepository.save(newmenu1);

								List<Tbmenu> subMenulst2 = menuRepository
										.findByResourcegroupidAndParentidAndActiveStatus(empmodels.getUsergroupid(),
												tbmenu2.getId(), 'Y');
								for (Tbmenu tbmenu3 : subMenulst2) {
									Tbmenu newmenu2 = new Tbmenu();
									newmenu2.setParentid(newmenu1.getId());
									newmenu2.setSequence(tbmenu3.getSequence());
									newmenu2.setMenuname(tbmenu3.getMenuname());
									newmenu2.setMenupagename(tbmenu3.getMenupagename());
									newmenu2.setIssubmenu(tbmenu3.getIssubmenu());
									newmenu2.setUserid(res.getResourceID());
									newmenu2.setGroupmenuid(tbmenu3.getId());
									newmenu2.setActiveStatus('Y');
									menuRepository.save(newmenu2);
								}

							}

						}
					} else {
						// Update usergroup menus to resource for same usergroup
						List<Integer> alreadymenu = new ArrayList<Integer>();
						List<Tbmenu> resoumenu = menuRepository
								.findByUseridAndParentidAndActiveStatus(res.getResourceID(), 0, 'Y');
						for (Tbmenu tbmenu : resoumenu) {
							alreadymenu.add(tbmenu.getGroupmenuid());
						}
						List<Tbmenu> newMenulst = menuRepository
								.findByResourcegroupidAndParentidAndActiveStatus(res.getUsergroupid(), 0, 'Y');
						for (Tbmenu tbmenu : newMenulst) {
							Tbmenu newmenu = null;
							if (!alreadymenu.contains(tbmenu.getId())) {
								newmenu = new Tbmenu();
								newmenu.setParentid(0);
								newmenu.setSequence(tbmenu.getSequence());
								newmenu.setMenuname(tbmenu.getMenuname());
								newmenu.setMenupagename(tbmenu.getMenupagename());
								newmenu.setIssubmenu(tbmenu.getIssubmenu());
								newmenu.setUserid(res.getResourceID());
								newmenu.setGroupmenuid(tbmenu.getId());
								newmenu.setActiveStatus('Y');
								menuRepository.save(newmenu);

							}

							List<Tbmenu> subMenulst1 = menuRepository.findByResourcegroupidAndParentidAndActiveStatus(
									empmodels.getUsergroupid(), tbmenu.getId(), 'Y');
							Tbmenu parantmenu1 = menuRepository.findByUseridAndGroupmenuidAndActiveStatus(
									res.getResourceID(), tbmenu.getId(), 'Y');
							List<Tbmenu> resoumenu1 = menuRepository.findByUseridAndParentidAndActiveStatus(
									res.getResourceID(), parantmenu1.getId(), 'Y');
							List<Integer> alreadymenu1 = new ArrayList<Integer>();
							for (Tbmenu resoume : resoumenu1) {
								alreadymenu1.add(resoume.getGroupmenuid());
							}
							Tbmenu newmenu1 = null;
							for (Tbmenu tbmenu2 : subMenulst1) {
								if (!alreadymenu1.contains(tbmenu2.getId())) {
									newmenu1 = new Tbmenu();
									newmenu1.setParentid(newmenu.getId());
									newmenu1.setSequence(tbmenu2.getSequence());
									newmenu1.setMenuname(tbmenu2.getMenuname());
									newmenu1.setMenupagename(tbmenu2.getMenupagename());
									newmenu1.setIssubmenu(tbmenu2.getIssubmenu());
									newmenu1.setUserid(res.getResourceID());
									newmenu1.setGroupmenuid(tbmenu2.getId());
									newmenu1.setActiveStatus('Y');
									menuRepository.save(newmenu1);
								}

								List<Tbmenu> subMenulst2 = menuRepository
										.findByResourcegroupidAndParentidAndActiveStatus(empmodels.getUsergroupid(),
												tbmenu2.getId(), 'Y');
								Tbmenu parantmenu2 = menuRepository.findByUseridAndGroupmenuidAndActiveStatus(
										res.getResourceID(), tbmenu2.getId(), 'Y');
								List<Tbmenu> resoumenu2 = menuRepository.findByUseridAndParentidAndActiveStatus(
										res.getResourceID(), parantmenu2.getId(), 'Y');
								List<Integer> alreadymenu2 = new ArrayList<Integer>();
								for (Tbmenu resoume : resoumenu2) {
									alreadymenu2.add(resoume.getGroupmenuid());
								}
								Tbmenu newmenu2 = null;
								for (Tbmenu tbmenu3 : subMenulst2) {
									if (!alreadymenu2.contains(tbmenu3.getId())) {
										newmenu2 = new Tbmenu();
										newmenu2.setParentid(newmenu1.getId());
										newmenu2.setSequence(tbmenu3.getSequence());
										newmenu2.setMenuname(tbmenu3.getMenuname());
										newmenu2.setMenupagename(tbmenu3.getMenupagename());
										newmenu2.setIssubmenu(tbmenu3.getIssubmenu());
										newmenu2.setUserid(res.getResourceID());
										newmenu2.setGroupmenuid(tbmenu3.getId());
										newmenu2.setActiveStatus('Y');
										menuRepository.save(newmenu2);
									}
								}

							}
						}

					}
				}
			} else {
				if (empmodels.getUsergroupid() != null) {
					List<Tbmenu> newMenulst = menuRepository
							.findByResourcegroupidAndParentidAndActiveStatus(empmodels.getUsergroupid(), 0, 'Y');
					for (Tbmenu tbmenu : newMenulst) {
						Tbmenu newmenu = new Tbmenu();
						newmenu.setParentid(0);
						newmenu.setSequence(tbmenu.getSequence());
						newmenu.setMenuname(tbmenu.getMenuname());
						newmenu.setMenupagename(tbmenu.getMenupagename());
						newmenu.setIssubmenu(tbmenu.getIssubmenu());
						newmenu.setUserid(res.getResourceID());
						newmenu.setGroupmenuid(tbmenu.getId());
						newmenu.setActiveStatus('Y');
						menuRepository.save(newmenu);

						List<Tbmenu> subMenulst1 = menuRepository.findByResourcegroupidAndParentidAndActiveStatus(
								empmodels.getUsergroupid(), tbmenu.getId(), 'Y');

						for (Tbmenu tbmenu2 : subMenulst1) {
							Tbmenu newmenu1 = new Tbmenu();
							newmenu1.setParentid(newmenu.getId());
							newmenu1.setSequence(tbmenu2.getSequence());
							newmenu1.setMenuname(tbmenu2.getMenuname());
							newmenu1.setMenupagename(tbmenu2.getMenupagename());
							newmenu1.setIssubmenu(tbmenu2.getIssubmenu());
							newmenu1.setUserid(res.getResourceID());
							newmenu1.setGroupmenuid(tbmenu2.getId());
							newmenu1.setActiveStatus('Y');
							menuRepository.save(newmenu1);

							List<Tbmenu> subMenulst2 = menuRepository.findByResourcegroupidAndParentidAndActiveStatus(
									empmodels.getUsergroupid(), tbmenu2.getId(), 'Y');
							for (Tbmenu tbmenu3 : subMenulst2) {
								Tbmenu newmenu2 = new Tbmenu();
								newmenu2.setParentid(newmenu1.getId());
								newmenu2.setSequence(tbmenu3.getSequence());
								newmenu2.setMenuname(tbmenu3.getMenuname());
								newmenu2.setMenupagename(tbmenu3.getMenupagename());
								newmenu2.setIssubmenu(tbmenu3.getIssubmenu());
								newmenu2.setUserid(res.getResourceID());
								newmenu2.setGroupmenuid(tbmenu3.getId());
								newmenu2.setActiveStatus('Y');
								menuRepository.save(newmenu2);
							}

						}
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			empsave.setStatus1("Success1");
			empsave.setRescoremessage("This Employee Code OR Username Is Already Present!");
			return empsave;
		}
		empsave.setStatus("Success");
		empsave.setMessage("Record Saved Successfully!");
		return empsave;
	}

	public employeeMasterModel dltemployeemaster(Integer userid) {
		SaveSuccessModel save = new SaveSuccessModel();
		employeeMasterModel empdlt = new employeeMasterModel();
		if (userid != null) {
			empdlt.setActiveStatus('n');
			
		}
		save.setMessage("Record Deleted Successfully!");
		save.setStatus("OK");

		return empdlt;
	}

	public List<employeeMasterModel> getempmasterfroEmp(@Valid employeeMasterModel usr) {

		List<employeeMasterModel> empmaster = new ArrayList<employeeMasterModel>();
//
		int offsett = (usr.getPageno() - 1) * 10;

		int row_count = 10;
		List<Tbresource> tbres = employeeMasterRepository.findAllemp(offsett, row_count);
//		List<Tbresource> tbres = employeeMasterRepository.findAll();
	
		for (Tbresource tbresource : tbres) {
			employeeMasterModel empmodel = new employeeMasterModel();
			if (tbresource.getResourceID() != null) {
				empmodel.setResourceID(tbresource.getResourceID());
			}
			if (tbresource.getSalutation() != null) {
				empmodel.setEmployeecode(tbresource.getEmployeecode());
			}
			if (tbresource.getSalutation() != null) {
				empmodel.setSalutation(tbresource.getSalutation());
			}
			if (tbresource.getGender() != null) {
				empmodel.setGender(tbresource.getGender());
			}
			if (tbresource.getFirstname() != null) {
				empmodel.setFirstname(tbresource.getFirstname());
			}
			if (tbresource.getMiddlename() != null) {
				empmodel.setMiddlename(tbresource.getMiddlename());
			}
			if (tbresource.getLastname() != null) {
				empmodel.setLastname(tbresource.getLastname());
			}
			if (tbresource.getName() != null) {
				empmodel.setName(tbresource.getName());
			}
			if (tbresource.getLoginName() != null) {
				empmodel.setLoginName(tbresource.getLoginName());
			}
			if (tbresource.getActiveStatus() != null) {
				empmodel.setActiveStatus(tbresource.getActiveStatus());
				if (tbresource.getActiveStatus().equals('Y')) {
					empmodel.setMsg("Active");
				} else {
					empmodel.setMsg("Inactive");
				}
			}
			if (tbresource.getSelfactive() != null) {
				
				if (tbresource.getSelfactive().equals('Y')) {
					empmodel.setMsg("Active");
				} else {
					empmodel.setMsg("Inactive");
				}
			}
			Integer count = employeeMasterRepository.getallcountemp();
			empmodel.setTotalItems(count);
			empmaster.add(empmodel);
		}

		return empmaster;
	}

	public List<ResourceModel> getresource(@Valid employeeMasterModel usr) {
		List<ResourceModel> getresource = new ArrayList<ResourceModel>();
		return getresource;
	}

	public employeeMasterModel Employeechangedeletstatus(employeeMasterModel model) {
		employeeMasterModel employeemodel = new employeeMasterModel();
		Tbresource resource = null;
		if (model.getResourceID() != null) {
			resource = employeeMasterRepository.findById(model.getResourceID()).get();
			if (model.getActiveStatus() != null && model.getActiveStatus().equals('Y')) {
				resource.setActiveStatus('Y');
				resource.setSelfactive('Y');
			} else {
				resource.setActiveStatus('N');
				resource.setSelfactive('N');
			}
//			if (model.getSelfactive() != null && model.getSelfactive().equals('Y')) {
//				resource.setSelfactive('Y');
//			} else {
//				resource.setSelfactive('N');
//			}
			employeeMasterRepository.save(resource);
			if (model.getActiveStatus().equals('N')) {
				employeemodel.setStatus("Success");
				employeemodel.setMessage("Record Deleted Successfully!");
			} else {
				employeemodel.setRescoremessage("Deleted Record Successfully Recovered!");
				employeemodel.setStatus1("Success2");
			}
		}
		return employeemodel;

	}

	public employeeMasterModel getEmployeedByid(Integer trnid) {
		employeeMasterModel employeeModel = new employeeMasterModel();
		if (trnid != null) {
			Tbresource resource = employeeMasterRepository.findByresourceID(trnid);
			employeeModel.setId(resource.getResourceID());
			employeeModel.setResourceID(resource.getResourceID());
			if (resource.getEmployeecode() != null) {
				employeeModel.setEmployeecode(resource.getEmployeecode());
			}
			if (resource.getSalutation() != null) {
				employeeModel.setSalutation(resource.getSalutation());
			}
			if (resource.getGender() != null) {
				employeeModel.setGender(resource.getGender());
			}
			if (resource.getFirstname() != null) {
				employeeModel.setFirstname(resource.getFirstname());
			}
			if (resource.getMiddlename() != null) {
				employeeModel.setMiddlename(resource.getMiddlename());
			}
			if (resource.getLastname() != null) {
				employeeModel.setLastname(resource.getLastname());
			}
			if (resource.getFirstname() != null && resource.getMiddlename() != null && resource.getLastname() != null) {
				employeeModel.setName(resource.getFirstname()
						+ " ".concat(resource.getMiddlename() + " ".concat(resource.getLastname())));
			}

			if (resource.getAddress() != null) {
				employeeModel.setAddress(resource.getAddress());
			}
			if (resource.getUsergroupid() != null) {
				employeeModel.setUsergroupid(resource.getUsergroupid());
			}

			if (resource.getMobile() != null) {
				employeeModel.setMobile(resource.getMobile());
			}
			if (resource.getMobile2() != null) {
				employeeModel.setMobile2(resource.getMobile2());
			}
			if (resource.getEmail() != null) {
				employeeModel.setEmail(resource.getEmail());
			}
//			employeeModel.setHead(resource.getHead());
			if (resource.getSelfactive() != null) {
				if(resource.getSelfactive().equals('Y'))
				{
					employeeModel.setSelfactive(true);
				}
				if(resource.getSelfactive().equals('N'))
				{
					employeeModel.setSelfactive(false);
				}
				
			}
			
		
			
			if (resource.getTbdepartment() != null) {
				employeeModel.setTbdepartment(resource.getTbdepartment());
			}
			if (resource.getTbdesignation() != null) {
				employeeModel.setTbdesignation(resource.getTbdesignation());
			}
//			if (resource.getIsreporting() != null) {
//				employeeModel.setIsreporting(resource.getIsreporting());
//			}
			if (resource.getTbband() != null) {
				employeeModel.setTbband(resource.getTbband());
			}
//			if (resource.getReportingmanager() != null) {
//				employeeModel.setReportingmanager(resource.getReportingmanager());
//				Tbresource res = employeeMasterRepository.findByresourceID(resource.getReportingmanager());
////					employeeModel.setEmployeecode(res.getEmployeecode());
////					employeeModel.setFirstname(res.getFirstname());
////					employeeModel.setMiddlename(res.getMiddlename());
////					employeeModel.setLastname(res.getLastname());
//				employeeModel.setName(res.getName());
//			}
//			if (resource.getSelfaccess() != null) {
//				employeeModel.setSelfaccess(resource.getSelfaccess());
//			}
			if (resource.getAssistantaccess() != null) {
				employeeModel.setAssistantaccess(resource.getAssistantaccess());
			}
			if (resource.getActiveInactive() != null) {
				employeeModel.setActiveInactive(resource.getActiveInactive());
			}
//			if (resource.getUserid() != null) {
//				employeeModel.setUserid(resource.getUserid());
//			}
			if (resource.getSelfaccess() != null) {
				employeeModel.setSelfaccessforuser(resource.getSelfaccess());
			}
//			if (resource.getLoginName() != null) {
//				employeeModel.setSelfaccessforuser(resource.getLoginName());
//			}
			if (resource.getActiveStatus() != null) {
				employeeModel.setActiveStatus(resource.getActiveStatus());
			}
			if (resource.getBirthdate() != null) {
					employeeModel.setBirthdate(resource.getBirthdate());
					}
			if (resource.getJoiningdate() != null) {
				employeeModel.setJoiningdate(resource.getJoiningdate());
		}
			if (resource.getResigndate() != null) {
				employeeModel.setResigndate(resource.getResigndate());
		}
		

		}
		return employeeModel;

	}

	public employeeMasterModel getMobileForChangePassword(Integer trnid) {
		employeeMasterModel empmodel = new employeeMasterModel();
		if (trnid != null) {
			Tbresource resource = employeeMasterRepository.findByresourceID(trnid);
			empmodel.setId(resource.getResourceID());
			if (resource.getMobile() != null) {
				empmodel.setMobile(resource.getMobile());
			}

		}
		return empmodel;
	}

	public List<employeeMasterModel> getSearchForEmployeeMaster(@Valid employeeMasterModel usr) {
		List<employeeMasterModel> empmaster = new ArrayList<employeeMasterModel>();
		int offsett = (usr.getPageno() - 1) * 10;
		int row_count = 10 ;
		List<Tbresource> tbres = null;
//		List<Tbresource> tbres = employeeMasterRepository.findAll();
		List<TbemployeeMaster> emList = null;

		if (StringUtils.isBlank(usr.getSearchText())) {
			tbres = employeeMasterRepository.findAll();
		} else {
			tbres = employeeMasterRepository.findByNameContainingIgnoreCase(usr.getSearchText(), offsett, row_count) ;
//			tbres = employeeMasterRepository
//					.findByNameContainingIgnoreCaseOrEmployeecodeContainingIgnoreCaseOrFirstnameContainingIgnoreCaseOrMiddlenameContainingIgnoreCaseOrLastnameContainingIgnoreCase(
//							usr.getSearchText(), usr.getSearchText(), usr.getSearchText(), usr.getSearchText(),
//							usr.getSearchText());
		}
		Integer count =employeeMasterRepository.getsearchcountforemployeemaser(usr.getSearchText());
		for (Tbresource tbresource : tbres) {
			employeeMasterModel empmodel = new employeeMasterModel();
			empmodel.setName(tbresource.getName());
			empmodel.setResourceID(tbresource.getResourceID());
			empmodel.setEmployeecode(tbresource.getEmployeecode());
			empmodel.setFirstname(tbresource.getFirstname());
			empmodel.setMiddlename(tbresource.getMiddlename());
			empmodel.setLastname(tbresource.getLastname());
			empmodel.setActiveStatus(tbresource.getActiveStatus());
			if (tbresource.getActiveStatus().equals('Y')) {
				empmodel.setMsg("Active");
			} else {
				empmodel.setMsg("Inactive");
			}
			empmodel.setTotalItems(count );
			empmaster.add(empmodel);
		}
		return empmaster;
	}

	public List<ResourceModel> getAllUsers(@Valid ResourceModel usr) {
		List<ResourceModel> resmodlst = new ArrayList<ResourceModel>();
		List<Tbresource> reslst = resourceRepository.findByActiveStatusOrderByNameAsc('Y');
		Integer i = 1;
		for (Tbresource tbresource : reslst) {
			if (tbresource.getActiveStatus().equals('Y')) {

				ResourceModel model = new ResourceModel();
				model.setId(tbresource.getResourceID());
				model.setName(tbresource.getName());
//					model.setBranchname(tbresource.getBranchname());
//					model.setBirthdate(tbresource.getBirthdate());

				if (tbresource.getTbdesignation() != null) {
					Tbdesignation designation = designationRepository.findById(tbresource.getTbdesignation()).get();
					model.setDesignationName(designation.getDesignationname());
				}

				if (tbresource.getTbdepartment() != null) {
					TbDepartment dept = departmentRepository.findById(tbresource.getTbdepartment()).get();
					if (dept != null) {
						model.setDeptName(dept.getDepartmentname());
					}
				}
				if (tbresource.getActiveInactive() != null) {
					if (tbresource.getActiveInactive().equals('Y')) {
						model.setActiveInactive("Active");
						model.setActivestatus("Active");
					} else {
						model.setActiveInactive("Inactive");
						model.setActivestatus("Inactive");
					}
				}
				i++;
				resmodlst.add(model);
			}

		}
		return resmodlst;
	}

	public List<ResourceModel> getusergroup(@Valid ResourceModel usr) {
		List<ResourceModel> resmodlst = new ArrayList<ResourceModel>();
		Integer i = 1;
		List<Tbusergroup> tbres = usergroupRepository.findAll();
		for (Tbusergroup tbres1 : tbres) {
//			if (tbres1.getActivestatus().equals('Y'))
			{
				ResourceModel model = new ResourceModel();
				model.setUsergroupid(tbres1.getId());
//				model.setUsergroup(tbres1.getUsergroup());
//			resmodlst.add(model);

				i++;
				resmodlst.add(model);
			}

		}
		return resmodlst;

	}

	public List<employeeMasterModel> getempmasterfroEmp1(@Valid employeeMasterModel usr) {
		List<employeeMasterModel> empmaster = new ArrayList<employeeMasterModel>();
		List<Object[]> resource = resourceRepository.findByclusterunittype(usr.getClusterunit1().toString(),
				usr.getUserID());
		for (Object[] res : resource) {
			employeeMasterModel empmodel = new employeeMasterModel();
			Tbresource tbresource = resourceRepository.findByresourceID(Integer.parseInt(res[2].toString()));
			if (tbresource.getIsreporting() != null && tbresource.getIsreporting().equals('Y')) {
				if (tbresource.getClusterunittype().equals(usr.getClusterunit1())) {
					empmodel.setEmployeecode(tbresource.getEmployeecode());
					empmodel.setFirstname(tbresource.getFirstname());
					empmodel.setMiddlename(tbresource.getMiddlename());
					empmodel.setLastname(tbresource.getLastname());
					empmodel.setResourceID(tbresource.getResourceID());
//						empmodel.setName(tbresource.getName());
					if (tbresource.getReportingmanager() != null) {
						empmodel.setReportingmanager(tbresource.getReportingmanager());
						Tbresource res1 = employeeMasterRepository.findByresourceID(tbresource.getReportingmanager());
//								employeeModel.setEmployeecode(res.getEmployeecode());
//								employeeModel.setFirstname(res.getFirstname());
//								employeeModel.setMiddlename(res.getMiddlename());
//								employeeModel.setLastname(res.getLastname());
						empmodel.setName(res1.getName());
					}
					if (tbresource.getActiveStatus().equals('Y')) {
						empmodel.setMsg("Active");
					} else {
						empmodel.setMsg("Inactive");
					}
				}

				empmaster.add(empmodel);
			}
		}
		return empmaster;

	}

	

	public List<employeeMasterModel> getreportingmanagr(@Valid employeeMasterModel usr) {
		List<employeeMasterModel> getreportingmanagrforemp = new ArrayList<employeeMasterModel>();

		List<Tbresource> reportmanager = employeeMasterRepository.findByIsreporting('Y');

		for (Tbresource tbband : reportmanager) {

			employeeMasterModel model1 = new employeeMasterModel();
			model1.setId(tbband.getResourceID());
			model1.setEmployeecode(tbband.getEmployeecode());
			model1.setName(tbband.getName());
			getreportingmanagrforemp.add(model1);
		}

		return getreportingmanagrforemp;
	}

	public List<employeeMasterModel> getempmasterfroEmpresource(@Valid employeeMasterModel usr) {
		List<employeeMasterModel> empmaster = new ArrayList<employeeMasterModel>();
		//
//				int offsett = (usr.getPageno() - 1) * 10;
		//
//				int row_count = 10 ;
//				List<Tbresource> tbres = employeeMasterRepository.findAllemp( offsett, row_count);
		List<Tbresource> tbres = employeeMasterRepository.findAll();

		for (Tbresource tbresource : tbres) {
			employeeMasterModel empmodel = new employeeMasterModel();
			if (tbresource.getResourceID() != null) {
				empmodel.setResourceID(tbresource.getResourceID());
			}
			if (tbresource.getSalutation() != null) {
				empmodel.setEmployeecode(tbresource.getEmployeecode());
			}
			if (tbresource.getSalutation() != null) {
				empmodel.setSalutation(tbresource.getSalutation());
			}
			if (tbresource.getGender() != null) {
				empmodel.setGender(tbresource.getGender());
			}
			if (tbresource.getFirstname() != null) {
				empmodel.setFirstname(tbresource.getFirstname());
			}
			if (tbresource.getMiddlename() != null) {
				empmodel.setMiddlename(tbresource.getMiddlename());
			}
			if (tbresource.getLastname() != null) {
				empmodel.setLastname(tbresource.getLastname());
			}
			if (tbresource.getName() != null) {
				empmodel.setName(tbresource.getName());

//					empmodel.setName(tbresource.getFirstname() + " " + (tbresource.getLastname()));
			}
			if (tbresource.getActiveStatus() != null) {
				empmodel.setActiveStatus(tbresource.getActiveStatus());
				if (tbresource.getActiveStatus().equals('Y')) {
					empmodel.setMsg("Active");
				} else {
					empmodel.setMsg("Inactive");
				}
			}
//					Integer count =employeeMasterRepository.getallcountemp();
//					empmodel.setTotalItems(count);
			empmaster.add(empmodel);
		}

		return empmaster;
	}

	public List<employeeMasterModel> getworkflowroleForemp(@Valid employeeMasterModel usr) {
		// TODO Auto-generated method stub
	
		List<employeeMasterModel> band = new ArrayList<employeeMasterModel>();
		List<Tbworkflowrole> tbband1 = workflowroleRepository.findByActiveStatus('Y');
//		List<Tbresource> tbres = employeeMasterRepository.findAll();
		for(Tbworkflowrole tbband:tbband1) {
			employeeMasterModel bandmodel = new employeeMasterModel();
		if (tbband.getId() != null) {
		bandmodel.setId(tbband.getId());
		}
		
		if (tbband.getRole() != null) {
		bandmodel.setBandname(tbband.getRole());
		}
		if (tbband.getActiveStatus() != null) {
		bandmodel.setActiveStatus(tbband.getActiveStatus());
		}
		band.add(bandmodel);
		}
		return band;
	}

	public List<employeeMasterModel> getAllUsers(@Valid employeeMasterModel usr) {
		List<employeeMasterModel> empmaster = new ArrayList<employeeMasterModel>();
		Integer i = 1 ;
		List<Tbresource> tbres = employeeMasterRepository.findAll();
		for (Tbresource tbresource : tbres) {
			employeeMasterModel empmodel = new employeeMasterModel();
			empmodel.setSrno(i);
			
			if (tbresource.getResourceID() != null) {
				empmodel.setResourceID(tbresource.getResourceID());
			}
			if (tbresource.getSalutation() != null) {
				empmodel.setEmployeecode(tbresource.getEmployeecode());
			}
			if (tbresource.getSalutation() != null) {
				empmodel.setSalutation(tbresource.getSalutation());
			}
			if (tbresource.getGender() != null) {
				empmodel.setGender(tbresource.getGender());
			}
			if (tbresource.getFirstname() != null) {
				empmodel.setFirstname(tbresource.getFirstname());
			}
			if (tbresource.getMiddlename() != null) {
				empmodel.setMiddlename(tbresource.getMiddlename());
			}
			if (tbresource.getLastname() != null) {
				empmodel.setLastname(tbresource.getLastname());
			}
			if (tbresource.getLoginName() != null) {
				empmodel.setLoginName(tbresource.getLoginName());
			}
			if (tbresource.getName() != null) {
				empmodel.setName(tbresource.getName());

//					empmodel.setName(tbresource.getFirstname() + " " + (tbresource.getLastname()));
			}
			if (tbresource.getActiveStatus() != null) {
				empmodel.setActiveStatus(tbresource.getActiveStatus());
				if (tbresource.getActiveStatus().equals('Y')) {
					empmodel.setMsg("Active");
				} else {
					empmodel.setMsg("Inactive");
				}
			}
//					Integer count =employeeMasterRepository.getallcountemp();
//					empmodel.setTotalItems(count);
			empmaster.add(empmodel);
			i++;
		}
		return empmaster;
	}


}
