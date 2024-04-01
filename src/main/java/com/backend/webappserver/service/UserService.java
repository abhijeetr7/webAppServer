package com.backend.webappserver.service;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.backend.webappserver.CurrentTenantId;
import com.backend.webappserver.config.UserPrincipal;
import com.backend.webappserver.data.model.TbDepartment;
import com.backend.webappserver.data.model.Tbdesignation;
import com.backend.webappserver.data.model.Tbmenu;
import com.backend.webappserver.data.model.Tbresource;
import com.backend.webappserver.data.model.Tbworkflowrole;
import com.backend.webappserver.payload.LoginRequest;
import com.backend.webappserver.payload.SaveSuccessModel;
import com.backend.webappserver.payload.employeeMasterModel;
import com.backend.webappserver.payload.workflowrolemodel;
import com.backend.webappserver.repository.DepartmentRepository;
import com.backend.webappserver.repository.DesignationRepository;
import com.backend.webappserver.repository.MenuRepository;
import com.backend.webappserver.repository.ResourceRepository;
import com.backend.webappserver.repository.WorkflowroleRepository;
import com.backend.webappserver.tenants.Tenant;
import com.backend.webappserver.tenants.TenantRepository;

@Service
public class UserService {

	@Autowired
	TenantRepository tenantRepository;

	@Autowired
	ResourceRepository resourceRepository;

	@Autowired
	private MenuRepository menuRepository;

	@Autowired
	private DesignationRepository designationRepository;

	@Autowired
	private DepartmentRepository departmentRepository;
	
@Autowired
private WorkflowroleRepository workflowroleRepository;

	public UserPrincipal validateUser(LoginRequest loginRequest) {
		CurrentTenantId.set("DBCompany");
		UserPrincipal userPrincipal = new UserPrincipal();
		String userinfo = loginRequest.getUsername();
		final String code = userinfo;
		final Integer i = code.indexOf("@");
//		final String companyCode = userinfo.substring(i + 1, code.length());
		String companyCode ;
		String userName ;
	    if(i<0) {
			
			companyCode ="webapp";
			userName=userinfo;
			
		}else {
			
			companyCode = userinfo.substring(i + 1, code.length());
			userName = userinfo.substring(0, i);
		}
		

		Tenant tenant = tenantRepository.findByCompanyCode(companyCode);
		if (tenant != null) {
//			final String userName = userinfo.substring(0, i);
			CurrentTenantId.set(companyCode);
//			Tbresource user = resourceRepository.findByLoginNameAndPasswordAndActiveStatus(userName,
//					loginRequest.getPassword(), 'Y');
//			Tbresource ok =resourceRepository.findByLoginNameAndActiveStatus(userName,'Y');
			Tbresource ok =resourceRepository.findByLoginNameAndActiveStatusAndSelfactive(userName,'Y','Y');
		if(ok!=null)
			{
				
				if(ok.getPassword()==null|| (ok.getMobile1()!=null && ok.getMobile1().equals(loginRequest.getPassword()))) { 
					Tbresource user = resourceRepository.findByLoginNameAndMobile1AndActiveStatus(userName,
							loginRequest.getPassword(), 'Y');
					if (user != null) {
						if (user.getActiveInactive().equals('Y')) {
							userPrincipal = UserPrincipal.create(user, companyCode);
							userPrincipal.setEmail(user.getEmail());
							userPrincipal.setDbName(tenant.getCompanyDB());
							userPrincipal.setMessage("SUCCESS");
							userPrincipal.setUsername(user.getLoginName());
							userPrincipal.setEmployeecode(user.getEmployeecode());
							userPrincipal.setId(user.getResourceID());
							userPrincipal.setCompanyName(tenant.getCompanyName());
							userPrincipal.setFullname(user.getFirstname()+" ".concat(user.getLastname()));
//							userPrincipal.setFullname(user.getName());
							userPrincipal.setCancreateproject(user.getCancreateproject());
							userPrincipal.setIsreporting(user.getIsreporting());
							userPrincipal.setFullnamefortoggal(user.getFirstname());
							userPrincipal.setCompanyaddress(tenant.getAddress());
							userPrincipal.setTelephone1(tenant.getTelephone1());
							userPrincipal.setUsergroupid(user.getUsergroupid());
							userPrincipal.setUseridmenu(user.getResourceID());
							userPrincipal.setMobile(user.getMobile());
							userPrincipal.setResourceName(user.getFirstname()+" ".concat(user.getLastname()));
							userPrincipal.setMessage("First Login");
							userPrincipal.setReshead(user.getHead());
							userPrincipal.setBand(user.getTbband().toString());
							workflowrolemodel  workroleall = new workflowrolemodel ();
							Tbworkflowrole work = workflowroleRepository.findByid(user.getTbband());
							if(work !=null) {
								String perm[] = work.getPermissions().split(",");
								for (String string : perm) {
									if (string.equals("Add")) {
										userPrincipal.setAdd(true);
									} else if (string.equals("Edit")) {
										userPrincipal.setEdit(true);
									} else if (string.equals("View")) {
										userPrincipal.setView(true);
									} else if (string.equals("Delete")) {
										userPrincipal.setDelete(true);
									}else if (string.equals("Approve")) {
										userPrincipal.setApprove(true);
									}
									 else if (string.equals("Microbe")) {
										 userPrincipal.setMicrobe(true);
										}
								}
								
							}

//							userPrincipal.setResourcename(user.getFirstname()+" ".concat(user.getLastname()));


//							List<Tbmenu> tbmenulst1 = menuRepository.findByUseridAndParentidAndIsmobileOrderBySequenceAsc(user.getResourceID(), 0,'Y');    
							List<Tbmenu> tbmenulst1 = menuRepository.findByUseridAndParentidAndActiveStatusOrderBySequenceAsc(user.getResourceID(), 0,'Y');    
//							if(!tbmenulst1.isEmpty()) {
//								Tbmenu tbmenu =  tbmenulst1.get(0);
//							userPrincipal.setLandingpage(tbmenu.getMenupagename());
//							}
							for (Tbmenu tbmenu : tbmenulst1) {
								if(tbmenu.getLandpage().equals('Y')) {
									userPrincipal.setLandingpage(tbmenu.getMenupagename());
								}
							}
//							
						}
					}}else {
				
					Tbresource user = resourceRepository.findByLoginNameAndPasswordAndActiveStatus(userName,
							loginRequest.getPassword(), 'Y');
			
			if (user != null) {
				if (user.getActiveInactive().equals('Y')) {
					userPrincipal = UserPrincipal.create(user, companyCode);
					userPrincipal.setEmail(user.getEmail());
					userPrincipal.setDbName(tenant.getCompanyDB());
					userPrincipal.setMessage("SUCCESS");
					userPrincipal.setUsername(user.getLoginName());
					userPrincipal.setId(user.getResourceID());
					userPrincipal.setCompanyName(tenant.getCompanyName());
					userPrincipal.setEmployeecode(user.getEmployeecode());
					userPrincipal.setFullname(user.getFirstname()+" ".concat(user.getLastname()));
//					userPrincipal.setFullname(user.getName());
					userPrincipal.setCancreateproject(user.getCancreateproject());
					userPrincipal.setIsreporting(user.getIsreporting());
					userPrincipal.setFullnamefortoggal(user.getFirstname());
					userPrincipal.setCompanyaddress(tenant.getAddress());
					userPrincipal.setTelephone1(tenant.getTelephone1());
					userPrincipal.setUsergroupid(user.getUsergroupid());
					userPrincipal.setMobile(user.getMobile());
					userPrincipal.setReportingmanager(user.getReportingmanager());
//					userPrincipal.setDepartment(user.getTbdepartment());
					userPrincipal.setUseridmenu(user.getResourceID());
					userPrincipal.setResourceName(user.getFirstname()+" ".concat(user.getLastname()));
					userPrincipal.setReshead(user.getHead());
					
					if(user.getTbdesignation()!=null) {
						Tbdesignation tbdesignation=designationRepository.findByid(user.getTbdesignation());
						if(tbdesignation!=null) {
							userPrincipal.setDesignation(tbdesignation.getDesignationname());
						}
					}
					if(user.getTbdepartment()!=null) {
						TbDepartment tbdepartment=departmentRepository.findByid(user.getTbdepartment());
						if(tbdepartment!=null) {
							userPrincipal.setDepartment(tbdepartment.getDepartmentname());
						}
					
					}
					userPrincipal.setBand(user.getTbband().toString());
					workflowrolemodel  workroleall = new workflowrolemodel ();
					Tbworkflowrole work = workflowroleRepository.findByid(user.getTbband());
					if(work !=null) {
						String perm[] = work.getPermissions().split(",");
						for (String string : perm) {
							if (string.equals("Add")) {
								userPrincipal.setAdd(true);
							} else if (string.equals("Edit")) {
								userPrincipal.setEdit(true);
							} else if (string.equals("View")) {
								userPrincipal.setView(true);
							} else if (string.equals("Delete")) {
								userPrincipal.setDelete(true);
							}else if (string.equals("Approve")) {
								userPrincipal.setApprove(true);
							}
							 else if (string.equals("Microbe")) {
								 userPrincipal.setMicrobe(true);
								}
						}
						
					}
					
				List<Tbmenu> tbmenulst1 = menuRepository.findByUseridAndParentidAndActiveStatusOrderBySequenceAsc(user.getResourceID(), 0,'Y');    

					for (Tbmenu tbmenu : tbmenulst1) {
						if(tbmenu.getLandpage().equals('Y')) {
							userPrincipal.setLandingpage(tbmenu.getMenupagename());
						}
					}
//					
				} else {
					userPrincipal.setMessage("User is inactive");
					userPrincipal.setStatus("NO");
				}
			} 
			else {
				userPrincipal.setMessage("Check Login Details");
				userPrincipal.setStatus("NO");
			}
		}
				
				
			}else {
				userPrincipal.setMessage("Please Contact Administrator");
				userPrincipal.setStatus("NO");
			}
		
			}else {
			userPrincipal.setMessage("Company not found");
			userPrincipal.setStatus("NO");
		}
		return userPrincipal;
		}

	public UserDetails loadUserById(Integer userId, String comanycode) {
		UserPrincipal userPrincipal = null;
		Tbresource user = resourceRepository.findById(userId).get();
		if (user != null) {
			userPrincipal = UserPrincipal.create(user, comanycode);
		}
		return userPrincipal;
	}

	public UserPrincipal changePassword(employeeMasterModel model) {
		CurrentTenantId.set("DBCompany");
		UserPrincipal save = new UserPrincipal();
		String userinfo = model.getMobile();
		final String code = userinfo;
		final Integer i = code.indexOf("@");
//		final String companyCode = userinfo.substring(i + 1, code.length());
		String companyCode;
		String userName;
		if (i < 0) {

			companyCode = "bioprime";
//			userName=userinfo;

		} else {

			companyCode = userinfo.substring(i + 1, code.length());
//			userName = userinfo.substring(0, i);
		}
		Tenant tenant = tenantRepository.findByCompanyCode(companyCode);
		if (tenant != null) {
			// final String userName = userinfo.substring(0, i);
			CurrentTenantId.set(companyCode);
			if (model.getUserid() != null) {
				Tbresource resource = resourceRepository.findByresourceID(model.getUserid());
				save.setId(resource.getResourceID());
				resource.getMobile().equals(model.getMobile());
				{
					resource.setPassword(model.getPassword());

					resourceRepository.save(resource);
					save.setMessage("Success");
					save.setStatus("OK");
				}

			}

		}
		return save;
	}

}