package com.backend.webappserver.page.service;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.webappserver.data.model.Tbbmsconfiguration;
import com.backend.webappserver.payload.BmsConfigurationModel;
import com.backend.webappserver.payload.SaveSuccessModel;
import com.backend.webappserver.repository.BmsConfigurationRepository;

@Service
public class BmsConfigurationService {

	@Autowired
	private BmsConfigurationRepository bmsConfigurationRepository;

	public BmsConfigurationModel savebmsconfiguration(@Valid BmsConfigurationModel models) {
		SaveSuccessModel save = new SaveSuccessModel();
		BmsConfigurationModel bmsConfigurationModel = new BmsConfigurationModel();
		Tbbmsconfiguration tbbmsconf = null;
		if (models.getId() != null) {
			tbbmsconf = bmsConfigurationRepository.findByid(models.getId());
			tbbmsconf.setEdituserid(models.getEdituserid());
			tbbmsconf.setEditdate(models.getEditdate());
		}else {
			tbbmsconf =new Tbbmsconfiguration();
			tbbmsconf.setActiveStatus('Y');
			tbbmsconf.setAdddate(new Date());
			tbbmsconf.setAdduserid(models.getUserID());
		}
			tbbmsconf.setOverduetask(models.getOverduetask());
			tbbmsconf.setProjecttasks(models.getProjecttasks());
			tbbmsconf.setTrmtasks(models.getTrmtasks());
			tbbmsconf.setParticipantproject(models.getParticipantproject());
			tbbmsconf.setEditproject(models.getEditproject());
			tbbmsconf.setKrabscpillar(models.getKrabscpillar());
			tbbmsconf.setKraindividualmin(models.getKraindividualmin());
			tbbmsconf.setKraindividualmax(models.getKraindividualmax());
			tbbmsconf.setKraweightagemin(models.getKraweightagemin());
			tbbmsconf.setKraweightagemax(models.getKraweightagemax());
			tbbmsconf.setKpiperindividualkramin(models.getKpiperindividualkramin());
			tbbmsconf.setKpiperindividualkramax(models.getKpiperindividualkramax());
			tbbmsconf.setAdduserid(models.getAdduserid());
			tbbmsconf.setAdddate(models.getAdddate());
			bmsConfigurationRepository.save(tbbmsconf);
			bmsConfigurationModel.setMessage("Success");
			bmsConfigurationModel.setStatus("ok");
		
		return bmsConfigurationModel;
	}

	public BmsConfigurationModel getConfigData() {
		BmsConfigurationModel bmsConfigurationModel=new BmsConfigurationModel();
		List<Tbbmsconfiguration> list=bmsConfigurationRepository.findByActiveStatus('Y');
		 if(list!=null && list.size()>0) {
			 Tbbmsconfiguration tbbmsconfiguration=list.get(0);
			 bmsConfigurationModel.setKraindividualmax(tbbmsconfiguration.getKraindividualmax());
			 bmsConfigurationModel.setKraindividualmin(tbbmsconfiguration.getKraindividualmin());
			 bmsConfigurationModel.setKpiperindividualkramax(tbbmsconfiguration.getKpiperindividualkramax());
			 bmsConfigurationModel.setKpiperindividualkramin(tbbmsconfiguration.getKpiperindividualkramin());
			 bmsConfigurationModel.setKraweightagemax(tbbmsconfiguration.getKraweightagemax());
			 bmsConfigurationModel.setKraweightagemin(tbbmsconfiguration.getKraweightagemin());
		 }
		return bmsConfigurationModel;
	}
	
	public BmsConfigurationModel getBMSConfByid(Integer trnid) {
		BmsConfigurationModel bmsModel = new BmsConfigurationModel();
		if (trnid != null) {
			Tbbmsconfiguration bmsConfig = bmsConfigurationRepository.findByid(trnid);
			if (bmsConfig.getId()!=null) {
				bmsModel.setId(bmsConfig.getId());
			}

			if (bmsConfig.getOverduetask()!=null) {
				bmsModel.setOverduetask(bmsConfig.getOverduetask());
			}
			if (bmsConfig.getProjecttasks()!=null) {
				bmsModel.setProjecttasks(bmsConfig.getProjecttasks());
			}
			if (bmsConfig.getTrmtasks()!=null) {
				bmsModel.setTrmtasks(bmsConfig.getTrmtasks());
			}
			if (bmsConfig.getParticipantproject()!=null) {
				bmsModel.setParticipantproject(bmsConfig.getParticipantproject());
			}
			if (bmsConfig.getEditproject()!=null) {
				bmsModel.setEditproject(bmsConfig.getEditproject());
			}
			if (bmsConfig.getKrabscpillar()!=null) {
				bmsModel.setKrabscpillar(bmsConfig.getKrabscpillar());
			}
			if (bmsConfig.getKraindividualmin()!=null) {
				bmsModel.setKraindividualmin(bmsConfig.getKraindividualmin());
			}
			if (bmsConfig.getKraindividualmax()!=null) {
				bmsModel.setKraindividualmax(bmsConfig.getKraindividualmax());
			}
			if (bmsConfig.getKraweightagemin()!=null) {
				bmsModel.setKraweightagemin(bmsConfig.getKraweightagemin());
			}
			if (bmsConfig.getKraweightagemax()!=null) {
				bmsModel.setKraweightagemax(bmsConfig.getKraweightagemax());
			}
			if (bmsConfig.getKpiperindividualkramin()!=null) {
				bmsModel.setKpiperindividualkramin(bmsConfig.getKpiperindividualkramin());
			}
			if (bmsConfig.getKpiperindividualkramax()!=null) {
				bmsModel.setKpiperindividualkramax(bmsConfig.getKpiperindividualkramax());
			}
		}
		return bmsModel;
	}


}
