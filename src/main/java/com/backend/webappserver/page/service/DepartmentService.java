package com.backend.webappserver.page.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.webappserver.data.model.TbDepartment;
import com.backend.webappserver.data.model.TbemployeeMaster;
import com.backend.webappserver.payload.DepartmentModel;
import com.backend.webappserver.payload.MicrobeMasterModel;
import com.backend.webappserver.payload.SaveSuccessModel;
import com.backend.webappserver.payload.activityModel;
import com.backend.webappserver.repository.DepartmentRepository;
import com.backend.webappserver.repository.ResourceRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private ResourceRepository resourceRepository;

	public List<DepartmentModel> getdepartment(@Valid DepartmentModel usr) {
		List<DepartmentModel> dept = new ArrayList<DepartmentModel>();
		Integer i = 1 ;
		List<TbDepartment> department = departmentRepository.findAll();
		for (TbDepartment tbdeprtment : department) {
			DepartmentModel depmodel = new DepartmentModel();
			depmodel.setSrno(i);
			if (tbdeprtment.getId() != null) {
				depmodel.setId(tbdeprtment.getId());
			}
			if (tbdeprtment.getDepartmentcode() != null) {
				depmodel.setDepartmentCode(tbdeprtment.getDepartmentcode());
			}
			if (tbdeprtment.getDepartmentname() != null) {
				depmodel.setDepartmentName(tbdeprtment.getDepartmentname());
			}
			if (tbdeprtment.getActiveStatus().equals('Y')) {
				depmodel.setActiveStatus('Y');
			} else {
				depmodel.setActiveStatus('N');
			}
			dept.add(depmodel);
			i++;
		}
		return dept;

	}


	public DepartmentModel savedepartment(@Valid DepartmentModel models) {
		SaveSuccessModel save = new SaveSuccessModel();
		DepartmentModel savedept = new DepartmentModel();
		TbDepartment tbdept = null;
		if (models.getId() != null) {
			tbdept = departmentRepository.findByid(models.getId());
			tbdept.setEditdate(new Date());
			tbdept.setEdituserid(models.getUserID());
		} else {
			tbdept = new TbDepartment();
			tbdept.setActiveStatus('Y');
			tbdept.setAdddate(new Date());
			tbdept.setAdduserid(models.getUserID());
		}
		tbdept.setId(models.getId());

		tbdept.setDepartmentcode(models.getDepartmentCode());
		tbdept.setDepartmentname(models.getDepartmentName());
		try {
			departmentRepository.save(tbdept);
		} catch (Exception ex) {
			savedept.setStatus1("Success1");
			savedept.setRescoremessage("This Department Code Is Already Present!");

			return savedept;
		}
		savedept.setMessage("Record Saved Successfully!");
		savedept.setStatus("Success");
		return savedept;
	}

	public DepartmentModel dltdepartment(Integer id) {
		SaveSuccessModel save = new SaveSuccessModel();
		DepartmentModel deptmodel = new DepartmentModel();
		if (id != null) {
			TbDepartment deldept = departmentRepository.findById(id).get();
			deldept.setActiveStatus('N');
			departmentRepository.save(deldept);
		}
		save.setMessage("Record Deleted Successfully!");
		save.setStatus("OK");
		return deptmodel;

	}

	public DepartmentModel departmentdelstatus(DepartmentModel model) {
		SaveSuccessModel savemodel = new SaveSuccessModel();
		DepartmentModel departmentmodel = new DepartmentModel();
		TbDepartment tbdept = null;

		Integer resourcecount = resourceRepository.findByDepartmentIdForDeleteMessage(model.getId());
		if (resourcecount != null && resourcecount < 0) {
			departmentmodel.setStatus("Failed");
			departmentmodel.setMessage("Unit present Under Cluster");
		} else {
			if (model.getId() != null) {
				tbdept = departmentRepository.findById(model.getId()).get();
				if (model.getActiveStatus() != null && model.getActiveStatus().equals('Y')) {
					tbdept.setActiveStatus('Y');
				} else {
					tbdept.setActiveStatus('N');
				}
				departmentRepository.save(tbdept);
				if (model.getActiveStatus().equals('N')) {
					departmentmodel.setStatus("Success");
					departmentmodel.setMessage("Record Deleted Successfully!");
				} else {
					departmentmodel.setRescoremessage("Deleted Record Successfully Recovered!");
					departmentmodel.setStatus1("Success2");
				}
			}
		}
		return departmentmodel;

	}

	public DepartmentModel getdepartmentById(Integer trnid) {

		DepartmentModel departmentModel = new DepartmentModel();
		if (trnid != null) {
			TbDepartment department = departmentRepository.findByid(trnid);
			if (department.getId() != null) {
				departmentModel.setId(department.getId());
			}
			if (department.getDepartmentcode() != null) {
				departmentModel.setDepartmentCode(department.getDepartmentcode());
			}
			if (department.getDepartmentcode() != null) {
				departmentModel.setDepartmentName(department.getDepartmentname());
			}
		}
		return departmentModel;

	}

	public List<DepartmentModel> getSearchForDepartmentHome(@Valid DepartmentModel usr) {
		List<DepartmentModel> dept = new ArrayList<DepartmentModel>();
		List<TbDepartment> department = departmentRepository.findAll();
		List<TbDepartment> department1 = null;

		if (StringUtils.isBlank(usr.getSearchText())) {
			department = departmentRepository.findAll();
		} else {
			department = departmentRepository
					.findByDepartmentcodeContainingIgnoreCaseOrDepartmentnameContainingIgnoreCase(usr.getSearchText(),
							usr.getSearchText());
		}
		for (TbDepartment tbdeprtment : department) {
			DepartmentModel depmodel = new DepartmentModel();
			depmodel.setId(tbdeprtment.getId());
			depmodel.setDepartmentCode(tbdeprtment.getDepartmentcode());
			depmodel.setDepartmentName(tbdeprtment.getDepartmentname());
			if (tbdeprtment.getActiveStatus().equals('Y')) {
				depmodel.setActiveStatus('Y');
			} else {
				depmodel.setActiveStatus('N');
			}

			dept.add(depmodel);
		}
		return dept;

	}
	
	public List<DepartmentModel> getdepartmentForEmployee(@Valid DepartmentModel usr) {
		List<DepartmentModel> dept = new ArrayList<DepartmentModel>();

		List<TbDepartment> department = departmentRepository.findByActiveStatus('Y');
		for (TbDepartment tbdeprtment : department) {
			DepartmentModel depmodel = new DepartmentModel();
			if (tbdeprtment.getId() != null) {
				depmodel.setId(tbdeprtment.getId());
			}
			if (tbdeprtment.getDepartmentcode() != null) {
				depmodel.setDepartmentCode(tbdeprtment.getDepartmentcode());
			}
			if (tbdeprtment.getDepartmentname() != null) {
				depmodel.setDepartmentName(tbdeprtment.getDepartmentname());
			}
			if (tbdeprtment.getActiveStatus().equals('Y')) {
				depmodel.setActiveStatus('Y');
			}
			dept.add(depmodel);
		}
		return dept;

	}

	
}
