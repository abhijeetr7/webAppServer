package com.backend.webappserver.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.webappserver.config.UserPrincipal;
import com.backend.webappserver.data.model.DefinePages;
import com.backend.webappserver.page.service.ParameterconfService;
import com.backend.webappserver.payload.DropdownModel;
import com.backend.webappserver.payload.MenuModel;
import com.backend.webappserver.payload.MenuPayload;
import com.backend.webappserver.payload.ModuleItemModel;
import com.backend.webappserver.payload.Node;
import com.backend.webappserver.payload.ParamModel;
import com.backend.webappserver.payload.SaveSuccessModel;
import com.backend.webappserver.payload.User;
import com.backend.webappserver.payload.UserActivityAcessModel;
import com.backend.webappserver.payload.employeeMasterModel;
import com.backend.webappserver.service.MenuService;

@RestController
@RequestMapping("/api/menu/")
public class MenuApi {

	@Autowired
	private MenuService menuService;
	
	@Autowired
	private ParameterconfService parameterconfService;


//	@PostMapping("/menubyuser")
//	public ResponseEntity<?> getMenuByUser() {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
//		List<Node> menuuser = menuService.getMenuTree(1, "");
//		return ResponseEntity.ok(menuuser);
//	}
	
	@PostMapping("/menubyuser")
	public ResponseEntity<?> getMenuByUser( @RequestBody MenuPayload menuPayload) {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
		List<Node> menuuser = menuService.getMenuTree(menuPayload.getUserId(), menuPayload.getFrom());
		return ResponseEntity.ok(menuuser);
	}
	
	
	
	
	
	
	
	@GetMapping("/health")
	public ResponseEntity<?> gethealth() {
	
		return ResponseEntity.ok("ok");
	}
	@PostMapping("/deletemenubyuser")
	public SaveSuccessModel getDeleteMenuByUser(@RequestBody MenuPayload menuPayload) {
		SaveSuccessModel saveSuccessModel= menuService.deleteMenuByUser(menuPayload);
		return saveSuccessModel;

	}

	@PostMapping("/menubymenuuser")
	public ResponseEntity<?> getMenuByUseramdMenuid(@RequestBody MenuPayload menuPayload) {
		List<Node> menuuser = menuService.getMenubyUseridAndMenuid(menuPayload);
		return ResponseEntity.ok(menuuser);
	}

	@PostMapping("/menubymenname")
	public ResponseEntity<?> getMenuNames(@RequestBody MenuPayload menuPayload) {
		//Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		//UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
		menuPayload.getUserId();
		List<DefinePages> menuuser = menuService.getMenuName(menuPayload);

		return ResponseEntity.ok(menuuser);
	}

	@PostMapping("/savemenubyuser")
	public SaveSuccessModel saveMenubyUser(@RequestBody MenuPayload menuPayload) {
//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//		UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
		// menuPayload.setUserId(userPrincipal.getId());
		SaveSuccessModel saveSuccessModel = menuService.saveMenubyUser(menuPayload);
		return saveSuccessModel;
	}

	@PostMapping("/menuofUser")
	public List<MenuModel> menuofUser(@Valid @RequestBody User doc) {
		List<MenuModel> lst = menuService.menuofUser(doc);
		return lst;
	}

	@PostMapping("/getAllitempage")
	public List<ModuleItemModel> getAllitempage(@Valid @RequestBody User doc) {
		List<ModuleItemModel> lst = menuService.getallpages(doc);
		return lst;
	}

	@PostMapping("/SaveItemname")
	public SaveSuccessModel SaveItemname(@Valid @RequestBody ModuleItemModel doc) {
		SaveSuccessModel model = menuService.saveItemname(doc);
		return model;
	}

	@PostMapping("/getAllgroup")
	public List<ModuleItemModel> getAllgroup(@Valid @RequestBody User doc) {
		List<ModuleItemModel> lst = menuService.getAllgroup(doc);
		return lst;
	}

//	@PostMapping("/SaveUserGroup")
//	public SaveSuccessModel SaveUserGroup(@Valid @RequestBody ModuleItemModel doc) {
//		SaveSuccessModel model = menuService.SaveUserGroup(doc);
//		return model;
//	}
	
	@PostMapping("/SaveUserGroup")
	public SaveSuccessModel SaveUserGroup(@Valid @RequestBody ModuleItemModel doc) {
		SaveSuccessModel model = menuService.SaveUserGroup(doc);
		return model;
	}

	

	@PostMapping("/deletegroup")
	public SaveSuccessModel deletegroup(@Valid @RequestBody ModuleItemModel doc) {
		SaveSuccessModel model = menuService.deletegroup(doc);
		return model;
	}

	@PostMapping("/getmodulelst")
	public List<DropdownModel> getmodulelst(@Valid @RequestBody MenuPayload doc) {
		List<DropdownModel> model = menuService.getmodulelst();
		return model;
	}
	@PostMapping("/getallmenudata")
	public MenuPayload getallmenudata(@Valid @RequestBody MenuPayload doc) {
		MenuPayload model = menuService.getallmenudata(doc);
		return model;
	}
	
	@PostMapping("/menuofUserformobile")
	public List<MenuModel> menuofUserformobile(@Valid @RequestBody User doc) {
		List<MenuModel> lst = menuService.menuofUserformobile(doc);
		return lst;
	}

	@PostMapping("/cleargroupall")
	public SaveSuccessModel cleargroupall(@Valid @RequestBody ModuleItemModel doc) {
		SaveSuccessModel model = menuService.cleargroupall(doc);
		return model;
	}
	@PostMapping("/updatemenubyuser")
	public SaveSuccessModel updatemenubyuser(@Valid @RequestBody ModuleItemModel doc) {
		SaveSuccessModel model = menuService.updatemenubyuser(doc);
		return model;

	}
	
	


}
