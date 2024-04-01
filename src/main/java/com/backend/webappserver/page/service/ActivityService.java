package com.backend.webappserver.page.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.webappserver.data.model.Tbactivity;
import com.backend.webappserver.payload.SaveSuccessModel;
import com.backend.webappserver.payload.activityModel;
import com.backend.webappserver.repository.ActivityRepository;

@Service
public class ActivityService {

	@Autowired
	private ActivityRepository activityRepository;
	
	public activityModel saveactivity(@Valid activityModel models) {
		SaveSuccessModel save = new SaveSuccessModel();
		activityModel activity = new activityModel();
		Tbactivity tbacti = null;
		

		Tbactivity tbacti1 = activityRepository.findBySequenceAndActivitylevel(models.getSequence(),models.getActivitylevel());
//		if(tbacti1!=null && tbacti1.getSequence() !=null) {
		if(tbacti1!=null && tbacti1.getSequence() !=null && models.getId() ==null) {
			activity.setStatus3("Success3");
			activity.setRescoremessage3("This Sequence  Is Already Present!");
			return activity;
		}else {
		
		if (models.getId() != null) {
			
			tbacti = activityRepository.findByid(models.getId());
			tbacti.setEditdate(new Date());
			tbacti.setEdituserid(models.getUserID());
		} else {
			tbacti = new Tbactivity();
			tbacti.setStatus('Y');
			tbacti.setAdddate(new Date());
			tbacti.setAdduserid(models.getUserID());
		}
		tbacti.setId(models.getId());
		tbacti.setActivitylevel(models.getActivitylevel());
		tbacti.setShortname(models.getShortname());
		tbacti.setActivityname(models.getActivityname());
		tbacti.setSequence(models.getSequence());

		try {
			activityRepository.save(tbacti);
		} catch (Exception ex) {
		
			activity.setStatus2("Success1");
			activity.setRescoremessage("This Short Name Or Activity Name  Is Already Present!");
			return activity;
		}
		}
		activity.setMessage("Record Saved Successfully!");
		activity.setStatus1("Success");
		return activity;
	}

	public activityModel getactivityById(@Valid Integer trnid) {
		activityModel activity = new activityModel();
		if (trnid != null) {
			Tbactivity tbactivity = activityRepository.findByid(trnid);
			if (tbactivity.getId() != null) {
				activity.setId(tbactivity.getId());
			}
			if (tbactivity.getId() != null) {
				activity.setActivityID(tbactivity.getId());
			}
			if (tbactivity.getShortname() != null) {
				activity.setShortname(tbactivity.getShortname());
			}
			if (tbactivity.getActivityname() != null) {
				activity.setActivityname(tbactivity.getActivityname());
			}
			if (tbactivity.getSequence() != null) {
				activity.setSequence(tbactivity.getSequence());
			}
			if (tbactivity.getActivitylevel() != null) {
				activity.setActivitylevel(tbactivity.getActivitylevel());
			}
		}
		return activity;
	}

	public List<activityModel> getactivity(@Valid activityModel usr) {
		List<activityModel> activity = new ArrayList<activityModel>();
		Integer i = 1 ;
		List<Tbactivity> act = activityRepository.findAll();
		for (Tbactivity tbactivity : act) {
			activityModel actmodel = new activityModel();
			actmodel.setSrno(i);
			if (tbactivity.getId() != null) {
				actmodel.setId(tbactivity.getId());
			}
			if (tbactivity.getShortname() != null) {
				actmodel.setShortname(tbactivity.getShortname());
			}
			if (tbactivity.getActivityname() != null) {
				actmodel.setActivityname(tbactivity.getActivityname());
			}
			if (tbactivity.getSequence() != null) {
				actmodel.setSequence(tbactivity.getSequence());
			}
			if (tbactivity.getActivitylevel() != null) {
				actmodel.setActivitylevel(tbactivity.getActivitylevel());
			}
			if (tbactivity.getStatus().equals('Y')) {
				actmodel.setStatus('Y');
			} else {
				actmodel.setStatus('N');
			}
			activity.add(actmodel);
			i++;
		}
		return activity;
	}

	public activityModel activitydelstatus(activityModel model) {
		SaveSuccessModel savemodel = new SaveSuccessModel();
		activityModel activitymodel = new activityModel();
		Tbactivity tbact = null;


			if (model.getId() != null) {
				tbact = activityRepository.findById(model.getId()).get();
				if (model.getStatus() != null && model.getStatus().equals('Y')) {
					tbact.setStatus('Y');
				} else {
					tbact.setStatus('N');
				}
				activityRepository.save(tbact);
				if (model.getStatus().equals('N')) {
					activitymodel.setStatus1("Success");
					activitymodel.setMessage("Record Deleted Successfully!");
				} else {
					activitymodel.setRescoremessage("Deleted Record Successfully Recovered!");
					activitymodel.setStatus2("Success2");
				}
			}
//		}
		return activitymodel;
	}

	public List<activityModel> getSearchForActivityHome(@Valid activityModel usr) {
		List<activityModel> activity = new ArrayList<activityModel>();
		List<Tbactivity> act = activityRepository.findAll();
		List<Tbactivity> act1 = null;

		if (StringUtils.isBlank(usr.getSearchText())) {
			act = activityRepository.findAll();
		} else {
			act = activityRepository
					.findByShortnameContainingIgnoreCaseOrActivitynameContainingIgnoreCase(usr.getSearchText(),
							usr.getSearchText());
		}
		for (Tbactivity tbactivity : act) {
			activityModel depmodel = new activityModel();
			depmodel.setId(tbactivity.getId());
			depmodel.setShortname(tbactivity.getShortname());
			depmodel.setActivityname(tbactivity.getActivityname());
			if (tbactivity.getStatus().equals('Y')) {
				depmodel.setStatus('Y');
			} else {
				depmodel.setStatus('N');
			}

			activity.add(depmodel);
	
		}
		return activity;
	}

}
