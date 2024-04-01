package com.backend.webappserver.page.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.backend.webappserver.data.model.Tbactivity;
import com.backend.webappserver.data.model.Tbactivitytrans;
import com.backend.webappserver.data.model.Tbsampleinverd;
import com.backend.webappserver.data.model.tblevel2activitytrans;
import com.backend.webappserver.payload.CommonForAllModel;
import com.backend.webappserver.payload.IsolateModel;
import com.backend.webappserver.payload.MicrobeMasterModel;
import com.backend.webappserver.payload.ParamModel;
import com.backend.webappserver.payload.SampleinvertModel;
import com.backend.webappserver.payload.activityModel;
import com.backend.webappserver.repository.ActivityRepository;
import com.backend.webappserver.repository.IsolateRepository;
import com.backend.webappserver.repository.Level2ActivityRepository;
import com.backend.webappserver.repository.SampleinvertRepository;
import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Service
public class IsolateService {

	@Autowired
	private IsolateRepository isolateRepository;
	@Autowired
	private SampleinvertRepository sampleinvertRepository;
	@Autowired
	private Level2ActivityRepository level2ActivityRepository;
	@Autowired
	private ActivityRepository activityRepository;

	public List<SampleinvertModel> getOtpForIsolated(@Valid SampleinvertModel otpget) {

		List<SampleinvertModel> samp = new ArrayList<SampleinvertModel>();

		List<Tbsampleinverd> sampinverdhome = sampleinvertRepository.findAll();

		for (Tbsampleinverd tbacti : sampinverdhome) {
			SampleinvertModel sampleinhome = new SampleinvertModel();
			if (tbacti.getSampleno().length() <= 5) {

//			sampleinhome.setSrno(i);
				if (tbacti.getId() != null) {
					sampleinhome.setId(tbacti.getId());
				}

				if (tbacti.getSampleno() != null) {
					sampleinhome.setSampleno(tbacti.getSampleno());
//				 Object dataforstringorint=tbacti.getSampleno();
//
//				  if (tbacti.getSampleno().length() == 5) {
//					  sampleinhome.setTypedataof("I");
//			        } else if (tbacti.getSampleno().length() > 5) {
//			        	 sampleinhome.setTypedataof("S");
//			        }
				}
				if (tbacti.getSampleinno() != null) {
					sampleinhome.setSampleinno(tbacti.getSampleinno());
				}

				samp.add(sampleinhome);

			}

		}

		return samp;
	}

	public IsolateModel saveisolatecode(@Valid IsolateModel iso) {
		IsolateModel isomodel = new IsolateModel();

		Tbactivitytrans tbactrans = null;
		tbactrans = new Tbactivitytrans();
		tbactrans.setActivesatus('Y');
		tbactrans.setSamplenov(iso.getOrganismtype());
		tbactrans.setSampleno(iso.getSamplenov());
		if (iso.getSamplenov() != null) {
			Tbsampleinverd tbsamp = sampleinvertRepository.findBySampleno(iso.getSamplenov());
			if (tbsamp != null) {
				tbactrans.setSampinvid(tbsamp.getId());
				tbactrans.setSampleinno(tbsamp.getSampleinno());
			}

			isolateRepository.save(tbactrans);
			isomodel.setMessage("Record Saved Successfully!");
//			isomodel.setStatus
			isomodel.setStatuss("Success");

		}

		return isomodel;
	}

	public List<IsolateModel> getactitransctionhome(@Valid IsolateModel actitrans) {
		List<IsolateModel> acttrans = new ArrayList<IsolateModel>();

		Integer i = 1;
		int offsett = (actitrans.getPageno() - 1) * 10;

		int row_count = 10;
		List<Tbactivitytrans> tbact = isolateRepository.findAllacti(offsett, row_count);

		for (Tbactivitytrans tbacti : tbact) {
			IsolateModel isomodel = new IsolateModel();

			isomodel.setSrno(i);

			if (tbacti.getId() != null) {
				isomodel.setId(tbacti.getId());
			}
			if (tbacti.getSampleno() != null) {
				isomodel.setSampleno(tbacti.getSampleno());
			}
			if (tbacti.getSamplenov() != null) {
				isomodel.setSamplenov(tbacti.getSamplenov());
			}

			Integer count = isolateRepository.getallcountforactivitytranshome();
			isomodel.setTotalItems(count);

			acttrans.add(isomodel);
			i++;
		}

		return acttrans;
	}

	public List<IsolateModel> getSearchForactitransaction(@Valid IsolateModel actitrans) {
		List<IsolateModel> searchisolate = new ArrayList<IsolateModel>();
		int offsett = (actitrans.getPageno() - 1) * 10;
		int row_count = 10;
		Integer i = 1;
		List<Tbactivitytrans> tbactvi = null;
//

		if (StringUtils.isBlank(actitrans.getSearchText())) {
			tbactvi = isolateRepository.findAll();
		} else {
			tbactvi = isolateRepository.findBySamplenoAndSamplenovContainingIgnoreCase(actitrans.getSearchText(),
					offsett, row_count);
		}
//
		for (Tbactivitytrans tbactitns : tbactvi) {
			IsolateModel isomodel = new IsolateModel();
			isomodel.setSrno(i);
			if (tbactitns.getId() != null) {
				isomodel.setId(tbactitns.getId());
			}
			if (tbactitns.getSampleno() != null) {
				isomodel.setSampleno(tbactitns.getSampleno());
			}
			if (tbactitns.getSamplenov() != null) {
				isomodel.setSamplenov(tbactitns.getSamplenov());
			}
			Integer count = isolateRepository.getallcountforactitranssearch(actitrans.getSearchText());

			isomodel.setTotalItems(count);
			searchisolate.add(isomodel);
			i++;
		}
		return searchisolate;
	}

	public MicrobeMasterModel getmicrobeidentificationByid(Integer trnid) {
		MicrobeMasterModel microbe = new MicrobeMasterModel();
		if (trnid != null) {
			Tbactivitytrans tbact = isolateRepository.findByid(trnid);
			if (tbact != null) {
				if (tbact.getId() != null) {
					microbe.setId(tbact.getId());
				}

				if (tbact.getSamplenov() != null) {
					microbe.setSamplenov(tbact.getSamplenov());
				}

			}
		}
		return microbe;
	}

	public activityModel getacttransactionByid(Integer trnid) {
		activityModel activitymodel = new activityModel();
		if (trnid != null) {
			Tbactivitytrans tbact = isolateRepository.findByid(trnid);
			if (tbact != null) {
				if (tbact.getId() != null) {
					activitymodel.setId(tbact.getId());
				}
				if (tbact.getSamplenov() != null) {
					activitymodel.setSamplenov(tbact.getSamplenov());
				}
				if (tbact.getSampleinno() != null) {
					activitymodel.setSampleinno(tbact.getSampleinno());
				}
				if (tbact.getSampleno() != null) {
					activitymodel.setSampleno(tbact.getSampleno());
				}

			}
		}
		return activitymodel;
	}

	public IsolateModel savemicrobidentification(@Valid IsolateModel iso) {
		IsolateModel isomodel = new IsolateModel();
		TypeReference<List<ParamModel>> listType = new TypeReference<List<ParamModel>>() {
		};
		Tbactivitytrans tbact = null;
		Tbactivitytrans tbact1 = isolateRepository.findBySamplenov(iso.getSamplenov());
		if (iso.getSamplenov() != null) {
			tbact1 = isolateRepository.findBySamplenov(iso.getSamplenov());
			tbact1.setOrganismtype(iso.getMicrobeTypename());
			tbact1.setIdentifiedgenus(iso.getGenus());
			tbact1.setSpecies(iso.getSpecies());

			if (tbact1.getSvparams() != null) {
				ParamModel parammodels = new ParamModel();
				parammodels.setOrganismtype(iso.getMicrobeTypename());
				parammodels.setIdentifiedgenus(iso.getGenus());
				parammodels.setSpecies(iso.getSpecies());
				parammodels.setSvparams(tbact1.getSvparams());

				String organismType = null;
				String genus = null;
				String species = null;
				String svparams = null;
				String identifiedgenus = null;
				organismType = (iso.getMicrobeTypename());
				genus = (iso.getGenus());
				identifiedgenus = (iso.getGenus());
				species = (iso.getSpecies());
				svparams = (tbact1.getSvparams());
				String json = tbact1.getSvparams();
				try {
					ObjectMapper objectMapper = new ObjectMapper();
					JsonNode jsonNode = objectMapper.readTree(json);
					// Adding values to the "organismtype" key
					((ObjectNode) jsonNode).put("organismtype", organismType);
					((ObjectNode) jsonNode).put("genus", genus);
					((ObjectNode) jsonNode).put("identifiedgenus", identifiedgenus);
					((ObjectNode) jsonNode).put("species", species);
					tbact1.setSvparams(jsonNode.toString());
					// Printing the modified JSON
					System.out.println(jsonNode.toString());
				} catch (IOException e) {
					e.printStackTrace();
				}



			}
		}
		isolateRepository.save(tbact1);
		isomodel.setMessage("Record Saved Successfully!");
		isomodel.setStatuss("Success");
		return isomodel;
	}

	public List<IsolateModel> getLevel2ActivityHome(@Valid IsolateModel l2actitrans) {
		List<IsolateModel> acttrans = new ArrayList<IsolateModel>();

		Integer i = 1;
		int offsett = (l2actitrans.getPageno() - 1) * 10;

		int row_count = 10;
		List<tblevel2activitytrans> tbl2act = level2ActivityRepository.findAlll2acti(offsett, row_count);

		for (tblevel2activitytrans tbl2acti : tbl2act) {
			IsolateModel isomodel = new IsolateModel();

			isomodel.setSrno(i);

			if (tbl2acti.getId() != null) {
				isomodel.setId(tbl2acti.getId());
			}
			if (tbl2acti.getSampleno() != null) {
				isomodel.setSampleno(tbl2acti.getSampleno());
			}
			if (tbl2acti.getIsolatecode() != null) {
				isomodel.setIsolatecode(tbl2acti.getIsolatecode());

			}
			if (tbl2acti.getPncode() != null) {
				isomodel.setPncode(tbl2acti.getPncode());
			}
			if (tbl2acti.getActivesatus() != null) {
				isomodel.setActivesatus(null);

			}

			Integer count = level2ActivityRepository.getallcountforl2activitytranshome();
			isomodel.setTotalItems(count);

			acttrans.add(isomodel);
			i++;
		}

		return acttrans;
	}

	public IsolateModel saveLevel2ActivityPlantassisscode(@Valid IsolateModel pnassissment) {
		IsolateModel sampmodel = new IsolateModel();
if(pnassissment.getPncode()!=null) {
		tblevel2activitytrans tbl2actrans = null;
		tbl2actrans = new tblevel2activitytrans();
		tbl2actrans.setActivesatus('Y');
		tbl2actrans.setPncode(pnassissment.getPncode());
		tbl2actrans.setSampleno(pnassissment.getSampleno());
		tbl2actrans.setIsolatecode(pnassissment.getIsolatecode());


		level2ActivityRepository.save(tbl2actrans);
}
		sampmodel.setMessage("Record Saved Successfully!");
		sampmodel.setStatuss("Success");
		return sampmodel;
	}

	public List<IsolateModel> getSearchForLevel2actitransaction(@Valid IsolateModel l2actitrans) {
		List<IsolateModel> searchisolate = new ArrayList<IsolateModel>();
		int offsett = (l2actitrans.getPageno() - 1) * 10;
		int row_count = 10;
		Integer i = 1;
		List<tblevel2activitytrans> tbl2actvi = null;
//

		if (StringUtils.isBlank(l2actitrans.getSearchText())) {
			tbl2actvi = level2ActivityRepository.findAll();
		} else {
			tbl2actvi = level2ActivityRepository.findByisolatecodeContainingIgnoreCase(l2actitrans.getSearchText(),
					offsett, row_count);
//			findBySamplenoAndSamplenovContainingIgnoreCase
		}
//
		for (tblevel2activitytrans tbl2actitns : tbl2actvi) {
			
			IsolateModel isomodel = new IsolateModel();

			isomodel.setSrno(i);

			if (tbl2actitns.getId() != null) {
				isomodel.setId(tbl2actitns.getId());
			}
			if (tbl2actitns.getSampleno() != null) {
				isomodel.setSampleno(tbl2actitns.getSampleno());
			}
			if (tbl2actitns.getIsolatecode() != null) {
				isomodel.setIsolatecode(tbl2actitns.getIsolatecode());

			}
			if (tbl2actitns.getPncode() != null) {
				isomodel.setPncode(tbl2actitns.getPncode());
			}
			if (tbl2actitns.getActivesatus() != null) {
				isomodel.setActivesatus(null);
			}
			Integer count = level2ActivityRepository.getallcountforl2actitranssearch(l2actitrans.getSearchText());
////			getallcountforactitranssearch
			isomodel.setTotalItems(count);
			searchisolate.add(isomodel);
			i++;
		}
		return searchisolate;
	}

	public activityModel getLevel2ActivityByid(Integer trnid) {
		activityModel activitymodel = new activityModel();
		if (trnid != null) {
			Tbactivitytrans tbact = isolateRepository.findByid(trnid);
			if (tbact != null) {
				if (tbact.getId() != null) {
					activitymodel.setId(tbact.getId());
				}
				if (tbact.getSamplenov() != null) {
					activitymodel.setSamplenov(tbact.getSamplenov());
				}
				if (tbact.getSampleinno() != null) {
					activitymodel.setSampleinno(tbact.getSampleinno());
				}
				if (tbact.getSampleno() != null) {
					activitymodel.setSampleno(tbact.getSampleno());
				}

			}
		}
		return activitymodel;
	}

	public List<CommonForAllModel> getSearchAllForMicrobeHome(@Valid CommonForAllModel searchall) {
		List<CommonForAllModel> searchmic = new ArrayList<CommonForAllModel>();
		List<Tbactivity> tbact = activityRepository.findAll();

		for (Tbactivity tbacti : tbact) {
			CommonForAllModel isomodel = new CommonForAllModel();

			
			if (tbacti.getId() != null) {
				isomodel.setId(tbacti.getId());
			}
			if (tbacti.getActivityname() != null) {
				isomodel.setActivityname(tbacti.getActivityname());
			}
			

			

			searchmic.add(isomodel);
	
		}

		return searchmic;
	}

	public CommonForAllModel getParamiterForSearchMicrobe(@Valid CommonForAllModel searchallpara) {
//		List<CommonForAllModel> searchmic = new ArrayList<CommonForAllModel>();
		Tbactivity tbacti = activityRepository.findByid(searchallpara.getId());

//		for (Tbactivity tbacti : tbact) {
			CommonForAllModel isomodel = new CommonForAllModel();

			
			if (tbacti.getId() != null) {
				isomodel.setId(tbacti.getId());
			}
			if (tbacti.getParameters() != null) {
				 ObjectMapper objectMapper = new ObjectMapper();
//				  objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				    TypeReference<List<ParamModel>> listType = new TypeReference<List<ParamModel>>() {};
				    List<ParamModel> jacksonList =new ArrayList<ParamModel>();
				    List<ParamModel> jacksonListstring2 =new ArrayList<ParamModel>();
					try {
						jacksonList = objectMapper.readValue(tbacti.getParameters(), listType);
//						objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
					} catch (Exception e) {
						e.printStackTrace();
					}
					isomodel.setParameterList(jacksonList);
				 
			}

		return isomodel;
	}

//	public CommonForAllModel getParametersByid(@Valid CommonForAllModel searchallpara) {
//		Tbactivity tbacti = activityRepository.findByid(searchallpara.getId());
//		CommonForAllModel isomodel = new CommonForAllModel();
//		
//		if (tbacti.getId() != null) {
//			isomodel.setId(tbacti.getId());
//		}
//		if (tbacti.getParameters() != null) {
//			 ObjectMapper objectMapper = new ObjectMapper();
////			  objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//			    TypeReference<List<ParamModel>> listType = new TypeReference<List<ParamModel>>() {};
//			    List<ParamModel> jacksonList =new ArrayList<ParamModel>();
//			    List<ParamModel> jacksonListstring2 =new ArrayList<ParamModel>();
//				try {
//					jacksonList = objectMapper.readValue(tbacti.getParameters(), listType);
////					objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//				isomodel.setParameterList(jacksonList);
//				
//				if(searchallpara.getPushparameterlist()!=null) {
//					ParamModel parametermodel = new ParamModel();
//					
//					tbacti = activityRepository.findByid(searchallpara.getId());
//				}
//		}
//		return isomodel;
//	}
	
}
	