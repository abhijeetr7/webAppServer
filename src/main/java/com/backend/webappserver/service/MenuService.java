package com.backend.webappserver.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.swing.text.StyledEditorKit.BoldAction;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.webappserver.CurrentTenantId;
import com.backend.webappserver.data.model.DefinePages;
import com.backend.webappserver.data.model.TbcustomerModule;
import com.backend.webappserver.data.model.TbemployeeMaster;
import com.backend.webappserver.data.model.Tbmenu;
import com.backend.webappserver.data.model.Tbresource;
import com.backend.webappserver.data.model.Tbusergroup;
import com.backend.webappserver.payload.DropdownModel;
import com.backend.webappserver.payload.MenuModel;
import com.backend.webappserver.payload.MenuPayload;
import com.backend.webappserver.payload.ModuleItemModel;
import com.backend.webappserver.payload.Node;
import com.backend.webappserver.payload.ResourceModel;
import com.backend.webappserver.payload.SaveSuccessModel;
import com.backend.webappserver.payload.SubChildMenuModel;
import com.backend.webappserver.payload.SubMenuModel;
import com.backend.webappserver.payload.User;
import com.backend.webappserver.repository.CustomerModuleRepository;
import com.backend.webappserver.repository.CustomerSubModuleRepository;
import com.backend.webappserver.repository.DefinepageRespository;
import com.backend.webappserver.repository.EmployeeMasterRepository;
import com.backend.webappserver.repository.MenuRepository;
import com.backend.webappserver.repository.ResourceRepository;
import com.backend.webappserver.repository.UsergroupRepository;
import com.backend.webappserver.util.ListToTree;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MenuService {

	@Autowired
	private MenuRepository menuRepository;

	@Autowired
	private ResourceRepository resourceRepository;

	@Autowired
	private DefinepageRespository definepageRespository;
//
	@Autowired
	private UsergroupRepository usergroupRepository;

	@Autowired
	CustomerModuleRepository customerModuleRepository;

   @Autowired
   EmployeeMasterRepository employeeMasterRepository;
	public List<MenuModel> menuofUser(@Valid User doc) {
		List<MenuModel> menulst = new ArrayList<MenuModel>();
		List<Tbmenu> tbmenulst1 = menuRepository.findByUseridAndParentidOrderBySequenceAsc(doc.getUserid(), 0);
		for (Tbmenu tbmenu : tbmenulst1) {
			if (tbmenu.getActiveStatus().equals('Y')) {
				final MenuModel model = new MenuModel();
				model.setMainmenulabel(tbmenu.getMenuname());
				model.setMainmenulink(tbmenu.getMenupagename());
				// SUBMENU1
				final List<Tbmenu> lstsubmenu = menuRepository
						.findByUseridAndParentidOrderBySequenceAsc(doc.getUserid(), tbmenu.getId());
				if (lstsubmenu != null && lstsubmenu.size() > 0) {
					final List<SubMenuModel> submenulst = new ArrayList<SubMenuModel>();
					for (Tbmenu submenu : lstsubmenu) {
						if (submenu.getActiveStatus().equals('Y')) {
							final SubMenuModel submodel = new SubMenuModel();
							submodel.setSubmenulabel(submenu.getMenuname());
							submodel.setSubmenulink(submenu.getMenupagename());
//							submodel.setType(submenu.getType());
//							model.settargetid(tbmenu.getmenupagename()+ ""+tbmenu.getid());/
							// SUBMENU2
						
							final List<Tbmenu> lstchildmenu = menuRepository
									.findByUseridAndParentidOrderBySequenceAsc(doc.getUserid(), submenu.getId());
							if (lstchildmenu != null & lstchildmenu.size() > 0) {
								final List<SubChildMenuModel> subchildmenulst = new ArrayList();
								for (final Tbmenu subChildMenuModel : lstchildmenu) {
									if (subChildMenuModel.getActiveStatus().equals('Y')) {
										final SubChildMenuModel childmodel = new SubChildMenuModel();
										childmodel.setSubmenulabel(subChildMenuModel.getMenuname());
										childmodel.setSubmenulink(subChildMenuModel.getMenupagename());

									
										
										subchildmenulst.add(childmodel);
									}
								}
								submodel.setLstchildmenu(subchildmenulst);
							}
							submenulst.add(submodel);
						}
					}
					model.setLstsubmenu(submenulst);
				}
				menulst.add(model);
			}
		}
		return menulst;
	}

	public List<Node> getMenuTree(Integer userId, String from) {
		List<Tbmenu> menulst = new ArrayList<Tbmenu>();
//		CurrentTenantId.set("bms");
		List<Node> nodes = new ArrayList<>();
		Tbusergroup usergroup = null;
		Tbresource resource = null;
		if (from != null && from.equals("group")) {
			usergroup = usergroupRepository.findById(userId).get();
			menulst = menuRepository.findByUseridAndResourcegroupidAndActiveStatus(0, userId, 'Y');
		} else {
			resource = resourceRepository.findByResourceID(userId);
			menulst = menuRepository.findByUseridAndActiveStatus(userId, 'Y');
		}

		for (Tbmenu tbmenu : menulst) {
			Boolean flag = false;
			if (tbmenu.getIssubmenu().equals("Y")) {
				flag = true;
			}
			List<Tbmenu> addmenu = menuRepository.findByParentidAndActiveStatus(tbmenu.getId(), 'Y');
			Node node = null;
			if (addmenu != null && addmenu.size() > 0) {
				node = new Node(tbmenu.getMenuname(), tbmenu.getId().toString(), tbmenu.getParentid(),
						addmenu.get(addmenu.size() - 1).getSequence() + 1, flag);
			} else {
				node = new Node(tbmenu.getMenuname(), tbmenu.getId().toString(), tbmenu.getParentid(), 1, flag);
			}
			nodes.add(node);
		}
		if (usergroup != null) {
			Node node5 = new Node(usergroup.getUsergroup(), "0", null, 1, true);
			nodes.add(node5);
		} else if (resource != null) {

			Node node5 = new Node(resource.getName(), "0", null, 1, true);
			nodes.add(node5);
		} else {

			Node node5 = new Node("root", "0", null, 1, true);
			nodes.add(node5);
		}
		return ListToTree.createTree(nodes);
	}

	public List<DefinePages> getMenuName(MenuPayload menuPayload) {

		List<DefinePages> lsMenuName = new ArrayList<DefinePages>();
		List<Tbmenu> menulst = new ArrayList<Tbmenu>();
		List<Integer> menuid = new ArrayList<>();
		if (menuPayload.getFrom().equals("User"))
		{
			if (menuPayload.getParentId() != null && menuPayload.getParentId() != 0) {
				menulst = menuRepository.findByid(menuPayload.getParentId());
				for (Tbmenu definePages : menulst) {
					if (definePages.getUserid().equals(menuPayload.getUserId())) {
						menuid.add(definePages.getPageId());
					}
				}
			}
		}
		if (menuPayload.getFrom().equals("group")) {
			if (menuPayload.getResourcegroupid() != null && menuPayload.getResourcegroupid() != 0) {
				menulst = menuRepository.findByUseridAndResourcegroupidAndActiveStatus(0,
						menuPayload.getResourcegroupid(), 'Y');
				for (Tbmenu tbmenu : menulst) {
					if (tbmenu.getResourcegroupid().equals(menuPayload.getResourcegroupid())) {
						menuid.add(tbmenu.getPageId());
					}
				}
			}
		}

		if (menuid.isEmpty()) {
			lsMenuName = definepageRespository.findByModuleidAndActiveStatusOrderByDspname(menuPayload.getModuleid(), "Y");
		} else {
			lsMenuName = definepageRespository.findByModuleidAndActiveStatusAndIdNotInOrderByDspname(menuPayload.getModuleid(), "Y",
					menuid);
		}

		return lsMenuName;
	}

	public List<Node> getMenubyUseridAndMenuid(MenuPayload menuPayload) {

		List<Tbmenu> menulst = new ArrayList<Tbmenu>();
		List<Integer> menuid = new ArrayList<>();
		List<Node> nodes = new ArrayList<>();
		menulst = menuRepository.findByid(menuPayload.getParentId());
		for (Tbmenu definePages : menulst) {
			menuid.add(definePages.getGroupmenuid());
		}

		return ListToTree.createTree(nodes);
	}

	public SaveSuccessModel saveMenubyUser(MenuPayload menuPayload) {
		SaveSuccessModel model = new SaveSuccessModel();
		Tbmenu tbmenu = new Tbmenu();
		if (menuPayload.getId() != null) {
			tbmenu = menuRepository.findById(menuPayload.getId()).get();
		}

		tbmenu.setGroupmenuid(menuPayload.getMenuId());

		tbmenu.setParentid(menuPayload.getParentId());
		tbmenu.setIssubmenu(menuPayload.getIsSubMenu());
		if (menuPayload.getIsSubMenu() != null && menuPayload.getIsSubMenu().equals("Y")) {
			menuPayload.setLandPage('N');
			tbmenu.setMenuname(menuPayload.getPagename());
			tbmenu.setPageId(0);
			tbmenu.setMenupagename(menuPayload.getPagename());
		} else {
			DefinePages tblMenuName = definepageRespository.findById(menuPayload.getPageid()).get() ;

			
			tbmenu.setMenuname(tblMenuName.getDspname());
			tbmenu.setPageId(tblMenuName.getId());
			tbmenu.setMenupagename(tblMenuName.getFilename());
			tbmenu.setType(tblMenuName.getType());
		}
		if (menuPayload.getResourcegroupid() != null && menuPayload.getUserId() == 0) {
			tbmenu.setUserid(0);
			tbmenu.setResourcegroupid(menuPayload.getResourcegroupid());
		} else {
			tbmenu.setUserid(menuPayload.getUserId());
			Tbresource resource = resourceRepository.findByResourceID(menuPayload.getUserId());
			if (resource != null) {
				tbmenu.setResourcegroupid(resource.getResourceID());
			}
		}

		tbmenu.setSequence(menuPayload.getSequence());
		tbmenu.setLandpage(menuPayload.getLandPage());

		tbmenu.setActiveStatus('Y');
		tbmenu = menuRepository.save(tbmenu);
		model.setStatus("OK");
		model.setMessage("Menu Added Sucessfully");
		return model;
	}
	@Autowired
	CustomerSubModuleRepository customerSubModuleRepository;
	public SaveSuccessModel deleteMenuByUser(MenuPayload menuPayload) {
		SaveSuccessModel returnmodel = new SaveSuccessModel();
//		List<Tbmenu> menulst = new ArrayList<Tbmenu>();
//		List<Tbmenu> menulst1 = new ArrayList<Tbmenu>();
		Tbmenu tbmenu = menuRepository.findById(menuPayload.getMenuId()).orElse(null);
		tbmenu.setActiveStatus('N');
		menuRepository.save(tbmenu);
		
		List<Tbmenu> childs = menuRepository.findByParentidAndActiveStatus(menuPayload.getMenuId(), 'Y');
		for (Tbmenu tbmenu2 : childs) {
			tbmenu2.setActiveStatus('N');
			menuRepository.save(tbmenu2);
		}
		
//		if (tbmenu != null) {
//			menulst.add(tbmenu);
//		}
//		menulst1 = menuRepository.findByid(menuPayload.getParentId());
//
//		if (!menulst1.isEmpty()) {
//			menulst.addAll(menulst1);
//		}
//		for (Tbmenu definePages : menulst) {
//			if (definePages.getUserid().equals(menuPayload.getUserId())) {
//				definePages.setActiveStatus('N');
//				menuRepository.save(definePages);
//			}
//
//		}
		returnmodel.setStatus("OK");
		returnmodel.setMessage("Menu Deleted Sucessfully");
		return returnmodel;
	}

	public List<ModuleItemModel> getallpages(@Valid User doc) {
		List<ModuleItemModel> retunmodel = new ArrayList<ModuleItemModel>();
		List<DefinePages> pageslst = definepageRespository.findAll();
		for (DefinePages definePages : pageslst) {
			if (definePages.getActiveStatus().equals("Y")) {
				ModuleItemModel model = new ModuleItemModel();
				model.setId(definePages.getId());
				model.setModulename(definePages.getModulename());
				model.setPagename(definePages.getFilename());
				model.setItemname(definePages.getDspname());
				retunmodel.add(model);
			}
		}

		return retunmodel;
	}

	public SaveSuccessModel saveItemname(@Valid ModuleItemModel doc) {
		SaveSuccessModel returnmodel = new SaveSuccessModel();
		DefinePages pages = definepageRespository.findByDspnameAndActiveStatus(doc.getItemname(), "Y");
		if (pages == null || pages.getId() == doc.getId()) {
			DefinePages pagemodel = definepageRespository.findById(doc.getId()).get();
			if (pagemodel != null) {
				pagemodel.setDspname(doc.getItemname());
				definepageRespository.save(pagemodel);
				returnmodel.setStatus("OK");
				returnmodel.setMessage("Menu Item Name Save Sucessfully");
			}
		} else {
			returnmodel.setStatus("NO");
			returnmodel.setMessage("Menu Item already Present");
		}

		return returnmodel;
	}

	public List<ModuleItemModel> getAllgroup(@Valid User doc) {
		List<ModuleItemModel> retunmodel = new ArrayList<ModuleItemModel>();
		List<Tbusergroup> userList = usergroupRepository.findByActivstatusOrderByUsergroup('Y');
		Integer i = 1;
		for (Tbusergroup tbusergroup : userList) {
			if (tbusergroup.getActivestatus().equals('Y')&&tbusergroup.getId()==null) {
				ModuleItemModel model = new ModuleItemModel();
				model.setId(tbusergroup.getId());
				model.setSrno(i++);
				model.setGroupname(tbusergroup.getUsergroup());
				retunmodel.add(model);

			}else {
					if(tbusergroup.getId()!=doc.getId()) {
						ModuleItemModel model = new ModuleItemModel();
						model.setId(tbusergroup.getId());
						model.setSrno(i++);
						model.setGroupname(tbusergroup.getUsergroup());
						retunmodel.add(model);
					}
					
			}
			
			
		}

		return retunmodel;

	}

	public SaveSuccessModel SaveUserGroup(@Valid ModuleItemModel doc) {
		SaveSuccessModel returnmodel = new SaveSuccessModel();
//		Tbusergroup findusergroup = usergroupRepository.findByUsergroupAndActivstatus(doc.getUpdategroupname(), 'Y');
//		if (doc.getId() != null) {
//			if (findusergroup == null || findusergroup.getId() == doc.getId()) {
//				Tbusergroup usergroup = usergroupRepository.findById(doc.getId()).get();
//				if (usergroup != null) {
//					usergroup.setUsergroup(doc.getUpdategroupname());
//					usergroup.setActivestatus('Y');
//				} else {
//					usergroup = new Tbusergroup();
//					usergroup.setUsergroup(doc.getUpdategroupname());
//					usergroup.setActivestatus('Y');
//				}
//				returnmodel.setStatus("OK");
//				returnmodel.setMessage("User Group Save Sucessfully");
////				usergroupRepository.save(usergroup);
//			} else {
//				returnmodel.setStatus("NO");
//				returnmodel.setMessage("User Group  already Present");
//			}
//
//		} else {
//			if (findusergroup != null) {
//				if (!findusergroup.getUsergroup().equals(doc.getUpdategroupname())) {
//					Tbusergroup usergroup = new Tbusergroup();
//					usergroup.setUsergroup(doc.getUpdategroupname());
//					usergroup.setActivestatus('Y');
////					usergroupRepository.save(usergroup);
//					returnmodel.setStatus("OK");
//					returnmodel.setMessage("User Group Save Sucessfully");
//				} else if (findusergroup.getUsergroup().equals(doc.getUpdategroupname())) {
//					returnmodel.setStatus("NO");
//					returnmodel.setMessage("User Group  already Present");
//				}
//			} else {
//				Tbusergroup usergroup = new Tbusergroup();
//				usergroup.setUsergroup(doc.getUpdategroupname());
//				usergroup.setActivestatus('Y');
////				usergroupRepository.save(usergroup);
//				returnmodel.setStatus("OK");
//				returnmodel.setMessage("User Group Save Sucessfully");
//			}
//		}
		Tbusergroup json = new Tbusergroup();
		json.setUsergroup(doc.getUpdategroupname());
		
		json.setActivestatus('Y');
		json.setJsonstring("ok");
		  ObjectMapper objectMapper = new ObjectMapper();
		String jsonString;
		try {
			jsonString = objectMapper.writeValueAsString(json);
			json.setJsonstring(jsonString);
//			saveresourcetoJson(jsonString);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(jsonString);
		usergroupRepository.save(json);
		
	
		
		

		return returnmodel;
	}

	
	
	
	
	
	
	public SaveSuccessModel deletegroup(@Valid ModuleItemModel doc) {
		SaveSuccessModel returnmodel = new SaveSuccessModel();
		Tbusergroup usergroup = usergroupRepository.findById(doc.getId()).get();
		if (usergroup != null) {
			usergroup.setUsergroup(doc.getUpdategroupname());
			usergroup.setActivestatus('N');
		}
		returnmodel.setStatus("OK");
		returnmodel.setMessage("User Group Deleted Sucessfully");
		usergroupRepository.save(usergroup);
		return returnmodel;
	}

	public List<DropdownModel> getmodulelst() {
		List<DropdownModel> retunmodel = new ArrayList<DropdownModel>();
		List<TbcustomerModule> module = customerModuleRepository.findByActiveStatusOrderByModulename('Y');
		for (TbcustomerModule tbcustomerModule : module) {
			DropdownModel model = new DropdownModel();
			model.setId(tbcustomerModule.getId());
			model.setName(tbcustomerModule.getModulename());
			retunmodel.add(model);
		}
		return retunmodel;
	}

	public MenuPayload getallmenudata(@Valid MenuPayload doc) {
		MenuPayload model = new MenuPayload();
		Tbmenu tbmenu = menuRepository.findById(doc.getId()).orElse(null);
		if (tbmenu != null) {
			model.setId(tbmenu.getId());
			model.setPagename(tbmenu.getMenuname());
			model.setSequence(tbmenu.getSequence());

			if (tbmenu.getIssubmenu().equals("N") && tbmenu.getPageId() != null) {
				DefinePages definepage = definepageRespository.findById(tbmenu.getPageId()).get();

				if (definepage != null) {
					model.setModulename(definepage.getModulename());
					model.setModuleid(definepage.getModuleid());
					model.setPageid(definepage.getId());
					List<DefinePages> lsMenuName = new ArrayList<DefinePages>();
					lsMenuName = definepageRespository.findByModuleidAndActiveStatus(definepage.getModuleid(), "Y");
					model.setPagelst(lsMenuName);
					// model.setParentId(definepage.getId());
				}
			}
			model.setIsSubMenu(tbmenu.getIssubmenu());
			model.setLandPage(tbmenu.getLandpage());
			model.setResourcegroupid(tbmenu.getResourcegroupid());
			model.setUserId(tbmenu.getUserid());
			model.setParentId(tbmenu.getParentid());
		}

		return model;
	}

	public List<MenuModel> menuofUserformobile(@Valid User doc) {
		List<MenuModel> menulst = new ArrayList<MenuModel>();
//		List<Tbmenu> tbmenulst1 = menuRepository.findByUseridAndParentidAndIsmobileOrderBySequenceAsc(doc.getUserid(), 0,'Y');    
		List<Tbmenu> tbmenulst1 = menuRepository.findByUseridAndParentidOrderBySequenceAsc(doc.getUserid(), 0);    

		for (Tbmenu tbmenu : tbmenulst1) {
			if (tbmenu.getActiveStatus().equals('Y')) {
				final MenuModel model = new MenuModel();
				model.setMainmenulabel(tbmenu.getMenuname());
				model.setMainmenulink(tbmenu.getMenupagename());
				// SUBMENU1
				final List<Tbmenu> lstsubmenu = menuRepository
						.findByUseridAndParentidOrderBySequenceAsc(doc.getUserid(), tbmenu.getId());
				if (lstsubmenu != null && lstsubmenu.size() > 0) {
					final List<SubMenuModel> submenulst = new ArrayList<SubMenuModel>();
					for (Tbmenu submenu : lstsubmenu) {
						if (submenu.getActiveStatus().equals('Y')) {
							final SubMenuModel submodel = new SubMenuModel();
							submodel.setSubmenulabel(submenu.getMenuname());
							submodel.setSubmenulink(submenu.getMenupagename());
//							model.settargetid(tbmenu.getmenupagename()+ ""+tbmenu.getid());/
							// SUBMENU2
							final List<Tbmenu> lstchildmenu = menuRepository
									.findByUseridAndParentidOrderBySequenceAsc(doc.getUserid(), submenu.getId());
							if (lstchildmenu != null & lstchildmenu.size() > 0) {
								final List<SubChildMenuModel> subchildmenulst = new ArrayList();
								for (final Tbmenu subChildMenuModel : lstchildmenu) {
									if (subChildMenuModel.getActiveStatus().equals('Y')) {
										final SubChildMenuModel childmodel = new SubChildMenuModel();
										childmodel.setSubmenulabel(subChildMenuModel.getMenuname());
										childmodel.setSubmenulink(subChildMenuModel.getMenupagename());
										subchildmenulst.add(childmodel);
									}
								}
								submodel.setLstchildmenu(subchildmenulst);
							}
							submenulst.add(submodel);
						}
					}
					model.setLstsubmenu(submenulst);
				}
				menulst.add(model);
			}
		}
		return menulst;
	}

	public SaveSuccessModel cleargroupall(@Valid ModuleItemModel doc) {
		SaveSuccessModel returnmodel = new SaveSuccessModel();
		List<Tbmenu> clearall =menuRepository.findByid(doc.getId());
		for(Tbmenu tbmenu :clearall) {
			MenuModel model = new MenuModel();
			tbmenu.setActiveStatus('N');
			menuRepository.save(tbmenu);
		}
		Tbresource emp =employeeMasterRepository.findByresourceID(doc.getId());
		emp.setUsergroupid(null);
		employeeMasterRepository.save(emp);
		returnmodel.setStatus("OK");
		returnmodel.setMessage("User Group Deleted Sucessfully");
		return returnmodel;
	}



	public SaveSuccessModel updatemenubyuser(@Valid ModuleItemModel doc) {
		if (doc.getFrom() != null && doc.getFrom().equals("group")) {
			SaveSuccessModel returnmodel = new SaveSuccessModel();
			ResourceModel empmodels = new ResourceModel();
			List<Tbresource> usergroup = resourceRepository.findByusergroupid(doc.getUsergroupid());
			for (Tbresource res : usergroup) {

				List<Tbmenu> newMenulst1 = menuRepository.findByUseridAndActiveStatus(res.getResourceID(), 'Y');
				for (Tbmenu deletemenu : newMenulst1) {

					menuRepository.deleteById(deletemenu.getId());

				}

				{

					List<Tbmenu> newMenulst = menuRepository
							.findByResourcegroupidAndParentidAndActiveStatus(doc.getUsergroupid(), 0, 'Y');

					for (Tbmenu tbmenu : newMenulst) {
						Tbmenu newmenu = new Tbmenu();
						newmenu.setParentid(0);
						newmenu.setSequence(tbmenu.getSequence());
						newmenu.setMenuname(tbmenu.getMenuname());
						newmenu.setMenupagename(tbmenu.getMenupagename());
						newmenu.setIssubmenu(tbmenu.getIssubmenu());
						newmenu.setUserid(res.getResourceID());
						newmenu.setGroupmenuid(tbmenu.getId());
						newmenu.setType(tbmenu.getType());
						newmenu.setActiveStatus('Y');
						menuRepository.save(newmenu);

						List<Tbmenu> subMenulst1 = menuRepository.findByResourcegroupidAndParentidAndActiveStatus(
								doc.getUsergroupid(), tbmenu.getId(), 'Y');

						for (Tbmenu tbmenu2 : subMenulst1) {
							Tbmenu newmenu1 = new Tbmenu();
							newmenu1.setParentid(newmenu.getId());
							newmenu1.setSequence(tbmenu2.getSequence());
							newmenu1.setMenuname(tbmenu2.getMenuname());
							newmenu1.setMenupagename(tbmenu2.getMenupagename());
							newmenu1.setIssubmenu(tbmenu2.getIssubmenu());
							newmenu1.setUserid(res.getResourceID());
							newmenu1.setGroupmenuid(tbmenu2.getId());
							newmenu1.setType(tbmenu2.getType());
							newmenu1.setActiveStatus('Y');
							menuRepository.save(newmenu1);

							List<Tbmenu> subMenulst2 = menuRepository.findByResourcegroupidAndParentidAndActiveStatus(
									doc.getUsergroupid(), tbmenu2.getId(), 'Y');
							for (Tbmenu tbmenu3 : subMenulst2) {
								Tbmenu newmenu2 = new Tbmenu();
								newmenu2.setParentid(newmenu1.getId());
								newmenu2.setSequence(tbmenu3.getSequence());
								newmenu2.setMenuname(tbmenu3.getMenuname());
								newmenu2.setMenupagename(tbmenu3.getMenupagename());
								newmenu2.setIssubmenu(tbmenu3.getIssubmenu());
								newmenu2.setUserid(res.getResourceID());
								newmenu2.setGroupmenuid(tbmenu3.getId());
								newmenu2.setType(tbmenu3.getType());
								newmenu2.setActiveStatus('Y');
								menuRepository.save(newmenu2);
							}

						}
					}
				}
			}
			returnmodel.setStatus("OK");
			returnmodel.setMessage("User Group Updated Sucessfully");
			return returnmodel;
		} else {
			SaveSuccessModel returnmodel = new SaveSuccessModel();
			ResourceModel empmodels = new ResourceModel();
			int resourcegroupid;
			//doc.getUsergroupid is userid 
			Tbresource res = resourceRepository.findByresourceID(doc.getUsergroupid());
			resourcegroupid = doc.getUpdatedusergroupid();
			res.setUsergroupid(doc.getUpdatedusergroupid());
			resourceRepository.save(res);
			List<Tbmenu> newMenulst1 = menuRepository.findByUseridAndActiveStatus(res.getResourceID(), 'Y');
			for (Tbmenu deletemenu : newMenulst1) {

				menuRepository.deleteById(deletemenu.getId());
			}

				{

					List<Tbmenu> newMenulst = menuRepository
							.findByResourcegroupidAndParentidAndActiveStatus(resourcegroupid, 0, 'Y');

					for (Tbmenu tbmenu : newMenulst) {
						Tbmenu newmenu = new Tbmenu();
						newmenu.setParentid(0);
						newmenu.setSequence(tbmenu.getSequence());
						newmenu.setMenuname(tbmenu.getMenuname());
						newmenu.setMenupagename(tbmenu.getMenupagename());
						newmenu.setIssubmenu(tbmenu.getIssubmenu());
						newmenu.setUserid(res.getResourceID());
						newmenu.setGroupmenuid(tbmenu.getId());
						newmenu.setType(tbmenu.getType());
						newmenu.setActiveStatus('Y');
						menuRepository.save(newmenu);

						List<Tbmenu> subMenulst1 = menuRepository
								.findByResourcegroupidAndParentidAndActiveStatus(resourcegroupid, tbmenu.getId(), 'Y');

						for (Tbmenu tbmenu2 : subMenulst1) {
							Tbmenu newmenu1 = new Tbmenu();
							newmenu1.setParentid(newmenu.getId());
							newmenu1.setSequence(tbmenu2.getSequence());
							newmenu1.setMenuname(tbmenu2.getMenuname());
							newmenu1.setMenupagename(tbmenu2.getMenupagename());
							newmenu1.setIssubmenu(tbmenu2.getIssubmenu());
							newmenu1.setUserid(res.getResourceID());
							newmenu1.setGroupmenuid(tbmenu2.getId());
							newmenu1.setType(tbmenu2.getType());
							newmenu1.setActiveStatus('Y');
							menuRepository.save(newmenu1);

							List<Tbmenu> subMenulst2 = menuRepository.findByResourcegroupidAndParentidAndActiveStatus(
									resourcegroupid, tbmenu2.getId(), 'Y');
							for (Tbmenu tbmenu3 : subMenulst2) {
								Tbmenu newmenu2 = new Tbmenu();
								newmenu2.setParentid(newmenu1.getId());
								newmenu2.setSequence(tbmenu3.getSequence());
								newmenu2.setMenuname(tbmenu3.getMenuname());
								newmenu2.setMenupagename(tbmenu3.getMenupagename());
								newmenu2.setIssubmenu(tbmenu3.getIssubmenu());
								newmenu2.setUserid(res.getResourceID());
								newmenu2.setGroupmenuid(tbmenu3.getId());
								newmenu2.setType(tbmenu3.getType());
								newmenu2.setActiveStatus('Y');
								menuRepository.save(newmenu2);
							}

						}
					}
					
				}
				returnmodel.setStatus("OK");
				returnmodel.setMessage("Single User Group Updated Sucessfully");
				return returnmodel;
			}
		

		}

	}

	
	

