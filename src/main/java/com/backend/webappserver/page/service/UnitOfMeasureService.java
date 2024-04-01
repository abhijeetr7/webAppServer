package com.backend.webappserver.page.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.webappserver.data.model.Tbunitofmeasure;
import com.backend.webappserver.payload.SaveSuccessModel;
import com.backend.webappserver.payload.UnitOfMeasureModel;
import com.backend.webappserver.repository.UnitOfMeasureRepository;

@Service
public class UnitOfMeasureService {

	@Autowired
	private UnitOfMeasureRepository unitOfMeasureRepository;

	public List<UnitOfMeasureModel> getunitofmeasure(@Valid UnitOfMeasureModel usr) {
		List<UnitOfMeasureModel> unitofmes = new ArrayList<UnitOfMeasureModel>();

		List<Tbunitofmeasure> tbunitofmes = unitOfMeasureRepository.findAll();

		for (Tbunitofmeasure tbuom : tbunitofmes) {
			UnitOfMeasureModel unitofmemodel = new UnitOfMeasureModel();

			unitofmemodel.setId(tbuom.getId());
			unitofmemodel.setCode(tbuom.getCode());
			unitofmemodel.setUnitmeasure(tbuom.getUnitmeasures());
			unitofmemodel.setUnittype(tbuom.getUnittype());
			if(tbuom.getUnittype().equals("D")) {
				unitofmemodel.setUnittypename("Date");
			}
			if(tbuom.getUnittype().equals("F")) {
				unitofmemodel.setUnittypename("Decimal");
			}
			if(tbuom.getUnittype().equals("N")) {
				unitofmemodel.setUnittypename("Numeric");
			}
			if(tbuom.getUnittype().equals("C")) {
				unitofmemodel.setUnittypename("Character");
			}
			if(tbuom.getUnittype().equals("B")) {
				unitofmemodel.setUnittypename("Boolean");
			}
			
			
			if (tbuom.getActiveStatus().equals('Y')) {
				unitofmemodel.setActiveStatus('Y');
			} else {
				unitofmemodel.setActiveStatus('N');
			}

			unitofmes.add(unitofmemodel);
		}

		return unitofmes;

	}

	public UnitOfMeasureModel saveunitofmeasure(@Valid UnitOfMeasureModel models) {
		SaveSuccessModel save = new SaveSuccessModel();
		UnitOfMeasureModel saveunitofmes = new UnitOfMeasureModel();
		Tbunitofmeasure tbunitofmesr = null;
		if (models.getId() != null) {
			tbunitofmesr = unitOfMeasureRepository.findByid(models.getId());
			tbunitofmesr.setEditdate(new Date());
			tbunitofmesr.setEdituserid(models.getUserID());
		} else {
			tbunitofmesr = new Tbunitofmeasure();
			tbunitofmesr.setActiveStatus('Y');
			tbunitofmesr.setAdddate(new Date());
			tbunitofmesr.setAdduserid(models.getUserID());
		}
		tbunitofmesr.setId(models.getId());

		tbunitofmesr.setCode(models.getCode());
		tbunitofmesr.setUnitmeasures(models.getUnitmeasure());
		tbunitofmesr.setUnittype(models.getUnittype());
		tbunitofmesr.setEdituserid(models.getEdituserid());
		tbunitofmesr.setAdduserid(models.getUserID());
		tbunitofmesr.setEditdate(models.getEditdate());

		tbunitofmesr = unitOfMeasureRepository.save(tbunitofmesr);

		saveunitofmes.setMessage("Record Saved Successfully!");
		saveunitofmes.setStatus("Success");
		return saveunitofmes;

	}

	public UnitOfMeasureModel getunitofmesureById(Integer trnid) {
		UnitOfMeasureModel unitmeasuremodel = new UnitOfMeasureModel();
		if (trnid != null) {
			Tbunitofmeasure tbunitmeasure = unitOfMeasureRepository.findByid(trnid);
			unitmeasuremodel.setId(tbunitmeasure.getId());
			if (tbunitmeasure.getCode() != null) {
				unitmeasuremodel.setCode(tbunitmeasure.getCode());
			}
			if (tbunitmeasure.getUnitmeasures() != null) {
				unitmeasuremodel.setUnitmeasure(tbunitmeasure.getUnitmeasures());
			}
			if (tbunitmeasure.getUnittype() != null) {
				unitmeasuremodel.setUnittype(tbunitmeasure.getUnittype());
			}
			if (tbunitmeasure.getAdddate() != null) {
				unitmeasuremodel.setAdddate(tbunitmeasure.getAdddate());
			}

		}
		return unitmeasuremodel;

	}

	public UnitOfMeasureModel unitmesuredelstatus(UnitOfMeasureModel model) {
		SaveSuccessModel saveUom = new SaveSuccessModel();
		UnitOfMeasureModel unitmesuremodel = new UnitOfMeasureModel();
		Tbunitofmeasure tbunitofmeasure = null;
		if (model.getId() != null) {
			tbunitofmeasure = unitOfMeasureRepository.findById(model.getId()).get();
			if (model.getActiveStatus() != null && model.getActiveStatus().equals('Y')) {
				tbunitofmeasure.setActiveStatus('Y');
			} else {
				tbunitofmeasure.setActiveStatus('N');
			}
			unitOfMeasureRepository.save(tbunitofmeasure);
			if (model.getActiveStatus().equals('N')) {
				unitmesuremodel.setStatus("Success");
				unitmesuremodel.setMessage("Record Deleted Successfully!");
			} else {
				unitmesuremodel.setRescoremessage("Deleted Record Successfully Recovered!");
				unitmesuremodel.setStatus1("Success2");
			}
		}
		return unitmesuremodel;
	}

	public List<UnitOfMeasureModel> getSearchForUnitOfMeasur(@Valid UnitOfMeasureModel usr) {
		List<UnitOfMeasureModel> unitofmes = new ArrayList<UnitOfMeasureModel>();

		List<Tbunitofmeasure> tbunitofmes = unitOfMeasureRepository.findAll();

		List<Tbunitofmeasure> tbunitofmes1 = null;

		if (StringUtils.isBlank(usr.getSearchText())) {
			tbunitofmes = unitOfMeasureRepository.findAll();
		} else {
			tbunitofmes = unitOfMeasureRepository.findByCodeContainingIgnoreCaseOrUnitmeasuresContainingIgnoreCase(
					usr.getSearchText(), usr.getSearchText());
		}

		for (Tbunitofmeasure tbuom : tbunitofmes) {
			UnitOfMeasureModel unitofmemodel = new UnitOfMeasureModel();

			unitofmemodel.setId(tbuom.getId());
			unitofmemodel.setCode(tbuom.getCode());
			unitofmemodel.setUnitmeasure(tbuom.getUnitmeasures());
			unitofmemodel.setUnittype(tbuom.getUnittype());
			if (tbuom.getActiveStatus().equals('Y')) {
				unitofmemodel.setActiveStatus('Y');
			} else {
				unitofmemodel.setActiveStatus('N');
			}

			unitofmes.add(unitofmemodel);
		}

		return unitofmes;
	}
	

}
