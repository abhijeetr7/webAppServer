package com.backend.webappserver.page.service;

import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.webappserver.data.model.Tbresource;
import com.backend.webappserver.payload.ResourceModel;
import com.backend.webappserver.repository.MenuRepository;
import com.backend.webappserver.repository.ResourceRepository;


@Service
public class ResourceService {

	@Autowired
	ResourceRepository resourceRepository;

	@Autowired
	private MenuRepository menuRepository;

	public ResourceModel getUserByid(@Valid ResourceModel usr) {
		ResourceModel model = new ResourceModel();
		Tbresource tbresource = resourceRepository.findByResourceID(usr.getId());
		model.setId(tbresource.getResourceID());
		model.setName(tbresource.getName());
		model.setMobile(tbresource.getMobile());
		model.setPassword(tbresource.getPassword());
		model.setEmail(tbresource.getEmail());
		model.setLoginName(tbresource.getLoginName());
		

		if (tbresource.getActiveInactive() != null && tbresource.getActiveInactive().equals('Y')) {
			model.setActiveInactive("Active");
		} else if (tbresource.getActiveInactive().equals('N')) {
			model.setActiveInactive("Inactive");
		}

		if (tbresource.getSeflag() != null && tbresource.getSeflag().equals('Y')) {
			model.setSeflag(true);
		} else {
			model.setSeflag(false);
		}
		
//		if (tbresource.getUserPrefix() != null) {
//			model.setUserprefix(tbresource.getUserPrefix());
//		}
//	

		return model;
	}
	
	public Tbresource getReportingManager(ResourceModel user) {
		Tbresource resource1 = new Tbresource();
		Tbresource tbresource = resourceRepository.findByresourceID(user.getUserid());
		if(tbresource!=null && tbresource.getReportingmanager()!=null) {
			resource1 = resourceRepository.findByResourceID(tbresource.getReportingmanager());
		}
		return resource1;
	}

	public List<ResourceModel> getresourcelist(ResourceModel resourceModel) {
		List<ResourceModel> resourcelist = new ArrayList<ResourceModel>();
		List<Tbresource>res=resourceRepository.findByReportingmanager((1));
		ResourceModel resmodel = new ResourceModel();
		for (Tbresource resource :res) {
		if(resource.getResourceID()!=null) {
			resmodel.setName(resource.getLastname());
			if(resource.getReportingmanager()!=null) {
			resmodel.setId(resource.getResourceID());
			List<Tbresource>res1=resourceRepository.findByReportingmanager(resource.getResourceID());
			for (Tbresource resource1 :res1) {
				ResourceModel resmodel1 = new ResourceModel();
				if(resource1.getReportingmanager()!=null) {
					resmodel1.setName(resource1.getLastname());
						resmodel1.setId(resource1.getResourceID());	
						List<Tbresource>res2=resourceRepository.findByReportingmanager(resource1.getResourceID());
						ResourceModel resmodel2 = new ResourceModel();
						for (Tbresource resource2 :res2) {
							resmodel2.setName(resource2.getLastname());
							resmodel2.setId(resource2.getResourceID());
						}
						resourcelist.add(resmodel2);	
				}
				resourcelist.add(resmodel1);
			}
			}
			
			resourcelist.add(resmodel);
			}

		}
		return resourcelist;
	}

	public List<Tbresource> getallRecursiveResources(Integer userid) {
		List<Integer> resourceId = new ArrayList<Integer>();
		List<Tbresource> tbresorce = resourceRepository
				.findByReportingmanagerAndActiveStatus(userid, 'Y');
		List<Tbresource> alltbresource = new  ArrayList<>();
		for (Tbresource tbresource : tbresorce) {
			List<Integer> resourceIdList = new ArrayList<Integer>();
			resourceIdList = getResourceRecursive(tbresource);
			if (!resourceIdList.contains(tbresource.getResourceID())) {
				resourceIdList.add(tbresource.getResourceID());
			}
			resourceId.addAll(resourceIdList);
		}
		if(userid !=null) {
			Tbresource res1 = resourceRepository.findByresourceID(userid);
			
			alltbresource.add(res1);
		}
		for (Integer res : resourceId) {
			Tbresource res1 = resourceRepository.findByresourceID(res);
			
			alltbresource.add(res1);
		}
		
		
		
		
		return alltbresource;
	}
		private List<Integer> getResourceRecursive(Tbresource tbresource) {
		List<Integer> resourceIdList = new ArrayList<Integer>();
		if (tbresource.getIsreporting() != null && tbresource.getIsreporting().equals('Y')) {
			List<Tbresource> tbresorce = resourceRepository
					.findByReportingmanagerAndActiveStatus(tbresource.getResourceID(), 'Y');
			for (Tbresource tbr : tbresorce) {
				List<Integer> resourceId = new ArrayList<Integer>();
				resourceId = getResourceRecursive(tbr);
				
				resourceIdList.addAll(resourceId);
			}
		}
		if (!resourceIdList.contains(tbresource.getResourceID())) {
			resourceIdList.add(tbresource.getResourceID());
		}

		return resourceIdList;
	}

	

}
