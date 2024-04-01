package com.backend.webappserver.page.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.webappserver.data.model.Tbdesignation;
import com.backend.webappserver.payload.DesignationModel;
import com.backend.webappserver.payload.SaveSuccessModel;
import com.backend.webappserver.repository.DesignationRepository;

import net.bytebuddy.asm.Advice.Return;

@Service
public class DesignationService {

	@Autowired
	private DesignationRepository designationRepository;

	public DesignationModel getdesignation(@Valid DesignationModel usr) {

		DesignationModel desig = new DesignationModel();

		Tbdesignation tbdesi = designationRepository.findByid(usr.getId());

		if (tbdesi.getDesignationcode() != null) {
			desig.setDesignationcode(tbdesi.getDesignationcode());
		}
		if (tbdesi.getDesignationname() != null) {
			desig.setDesignationname(tbdesi.getDesignationname());
		}
		if (tbdesi.getActiveStatus().equals('Y')) {
			desig.setActiveStatus('Y');
		} else {
			desig.setActiveStatus('N');
		}

		return desig;

	}

	public DesignationModel savedesignation(@Valid DesignationModel models) {
		SaveSuccessModel save = new SaveSuccessModel();
		DesignationModel savedesig = new DesignationModel();
		Tbdesignation tbdesig = null;
		if (models.getId() != null) {
			tbdesig = designationRepository.findByid(models.getId());
		} else {
			tbdesig = new Tbdesignation();
			tbdesig.setActiveStatus('Y');
			tbdesig.setAdddate(new Date());
			tbdesig.setAdduserid(models.getUserID());
		}
		tbdesig.setId(models.getId());

		tbdesig.setDesignationcode(models.getDesignationcode());
		tbdesig.setDesignationname(models.getDesignationname());
		tbdesig.setAdduserid(models.getAdduserid());
		tbdesig.setEdituserid(models.getEdituserid());
		tbdesig.setEditdate(models.getEditDate());

		try {

			designationRepository.save(tbdesig);

		} catch (Exception ex) {

			savedesig.setStatus1("Success1");
			savedesig.setRescoremessage("This Designation Code Is Already Present!");
			return savedesig;
		}

		savedesig.setMessage("Record Saved Successfully!");
		savedesig.setStatus("Success");

		return savedesig;

	}

	public DesignationModel dltdesignation(Integer id) {
		SaveSuccessModel save = new SaveSuccessModel();
		DesignationModel desigmodel = new DesignationModel();
		if (id != null) {
			Tbdesignation deldesig = designationRepository.findById(id).get();
			deldesig.setActiveStatus('N');
			designationRepository.save(deldesig);
		}
		save.setMessage("Delete Successfully");
		save.setStatus("OK");
		return desigmodel;

	}

	public List<DesignationModel> getdesignationall(@Valid DesignationModel usr) {
		List<DesignationModel> designation = new ArrayList<DesignationModel>();
		Integer i = 1 ;
		List<Tbdesignation> tbdesi = designationRepository.findAll();
		for (Tbdesignation user1 : tbdesi) {
			DesignationModel desigmodel = new DesignationModel();
		 desigmodel.setSrno(i);
			if (user1.getId() != null) {
				desigmodel.setId(user1.getId());
			}
			if (user1.getDesignationcode() != null) {
				desigmodel.setDesignationcode(user1.getDesignationcode());
			}
			if (user1.getDesignationname() != null) {
				desigmodel.setDesignationname(user1.getDesignationname());
			}
			if (user1.getActiveStatus().equals('Y')) {
				desigmodel.setActiveStatus('Y');
			} else {
				desigmodel.setActiveStatus('N');
			}
			designation.add(desigmodel);
			i++;
		}
		return designation;
	}

	public List<DesignationModel> getSearchForDesignation(@Valid DesignationModel usr) {
		List<DesignationModel> designation = new ArrayList<DesignationModel>();
		List<Tbdesignation> tbdesi = designationRepository.findAll();

		List<Tbdesignation> tbdesi1 = null;

		if (StringUtils.isBlank(usr.getSearchText())) {
			tbdesi = designationRepository.findAll();
		} else {
			tbdesi = designationRepository
					.findByDesignationcodeContainingIgnoreCaseOrDesignationnameContainingIgnoreCase(usr.getSearchText(),
							usr.getSearchText());
		}
		for (Tbdesignation user1 : tbdesi) {
			if (user1.getActiveStatus().equals('Y')) {
				DesignationModel desigmodel = new DesignationModel();
				desigmodel.setId(user1.getId());
				desigmodel.setDesignationcode(user1.getDesignationcode());
				desigmodel.setDesignationname(user1.getDesignationname());
				designation.add(desigmodel);
			}

		}
		return designation;
	}

	public DesignationModel degination(DesignationModel model) {
		DesignationModel degignation = new DesignationModel();
		Tbdesignation band = null;
		if (model.getId() != null) {
			band = designationRepository.findById(model.getId()).get();
			if (model.getActiveStatus() != null && model.getActiveStatus().equals('Y')) {
				band.setActiveStatus('Y');
			} else {
				band.setActiveStatus('N');
			}
			designationRepository.save(band);
			if (band.getActiveStatus().equals('N')) {
				degignation.setStatus("Success");
				degignation.setMessage("Record Deleted Successfully!");
			} else {
				degignation.setRescoremessage("Deleted Record Successfully Recovered!");
				degignation.setStatus1("Success2");
			}

		}
		return degignation;
	}

}