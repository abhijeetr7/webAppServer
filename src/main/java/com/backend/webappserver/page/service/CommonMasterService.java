package com.backend.webappserver.page.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;
//
//import org.apache.commons.lang3.StringUtils;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.boot.configurationprocessor.json.JSONArray;
////import org.springframework.boot.configurationprocessor.json.JSONException;
////import org.springframework.boot.configurationprocessor.json.JSONObject;
////import org.springframework.boot.configurationprocessor.json.JSONArray;
////import org.springframework.boot.configurationprocessor.json.JSONException;
////import org.springframework.boot.configurationprocessor.json.JSONObject;
//import org.springframework.stereotype.Service;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.webappserver.data.model.TbMicrobeTypeMaster;
import com.backend.webappserver.data.model.Tbcommonmaster;
import com.backend.webappserver.data.model.Tbcommonmastertype;
import com.backend.webappserver.payload.CommonMasterModel;
import com.backend.webappserver.payload.DependancyModel;
import com.backend.webappserver.payload.MicrobeMasterModel;
import com.backend.webappserver.payload.ParamModel;
import com.backend.webappserver.payload.SaveSuccessModel;
import com.backend.webappserver.repository.CommonMasterRepository;
import com.backend.webappserver.repository.CommonMasterTypeRepository;
import com.backend.webappserver.repository.MicrobemasterReository;
import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

@Service
public class CommonMasterService {

	@Autowired
	private CommonMasterRepository commonMasterRepository;

	@Autowired
	private CommonMasterTypeRepository commonMastertype;
	
	@Autowired
	private CommonMasterTypeRepository commonMasterTypeRepository;
	@Autowired
	private MicrobemasterReository microbemasterReository;

	public List<CommonMasterModel> getCommonMaster(@Valid CommonMasterModel usr) {
		List<CommonMasterModel> comModel = new ArrayList<CommonMasterModel>();
//		
		int offsett = (usr.getPageno() - 1) * 10;
//		List<Tbcommonmaster> tbcommaster = commonMasterRepository.findAllById(usr.getUserID());

		int row_count = 10;
//		List<Tbcommonmaster> tbcommaster = commonMasterRepository.findAll();
		List<Tbcommonmaster> tbcommaster = commonMasterRepository.findAllforpagignation(usr.getTypeid(),offsett, row_count);
		List<DependancyModel> dependlist =new ArrayList<DependancyModel>();
//		List<Tbcommonmaster> tbcommaster = commonMasterRepository.findByTypeid(usr.getTypeid());
			for (Tbcommonmaster tbcom : tbcommaster) {
				CommonMasterModel commastermodel = new CommonMasterModel();
				commastermodel.setId(tbcom.getId());
				commastermodel.setTypeid(tbcom.getTypeid());

//				commastermodel.setValueforjson(tbcom.getDependancyjson());
				if(tbcom.getDependancyjson()!=null ) {
//					commastermodel.setValue(tbcom.getDependancyjson());

					commastermodel.setShortname(tbcom.getValue());
					
					ObjectMapper objectMapper = new ObjectMapper();
//					  objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				    TypeReference<List<DependancyModel>> listType = new TypeReference<List<DependancyModel>>() {};
				    List<DependancyModel> jacksonList =new ArrayList<DependancyModel>();
				    List<DependancyModel> jacksonListstring2 =new ArrayList<DependancyModel>();
					try {
						jacksonList = objectMapper.readValue(tbcom.getDependancyjson(), listType);
//						objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
					} catch (Exception e) {
						e.printStackTrace();
					}
					commastermodel.setDistList(jacksonList);
//					String jsonString = tbcom.getDependancyjson();

//					 try {
//						 //Gson gson = new Gson();
//				            JSONObject jsonObject = new JSONObject(jsonString);
//				            JSONArray jsonArray = jsonObject.toJSONArray(jsonObject.names());
//				            StringBuilder stringBuilder = new StringBuilder();

//				            for (int i = 0; i < jsonArray.length(); i++) {
//				                if (i > 0) {
//				                    stringBuilder.append(",");
//				                }
//				                stringBuilder.append(jsonArray.getString(i));
//				            }

////				            return stringBuilder.toString();
////				            System.out.println(stringBuilder);
////				            commastermodel.setCheckboxValue(true);
//				            commastermodel.setValueforjson(stringBuilder.toString());
//				            commastermodel.setValue(stringBuilder.toString());
//				        } catch (Exception e) {
//				            e.printStackTrace();
////				            return null;
//				        }

				}
				if(tbcom.getDependancyjson()==null) {
					commastermodel.setValue(tbcom.getValue());
					commastermodel.setShortname(tbcom.getShortname());
				}

				if (tbcom.getTypeid() != null) {
					CommonMasterModel mastertypemodel = new CommonMasterModel();
					Tbcommonmastertype mastertype = commonMastertype.findAllById(tbcom.getTypeid());

					commastermodel.setCode(mastertype.getCode());
					commastermodel.setType(mastertype.getType());

				}
				if (tbcom.getActiveStatus().equals('Y')) {
					commastermodel.setActiveStatus('Y');
				} else {
					commastermodel.setActiveStatus('N');
				}

				
				
				Integer count = commonMasterRepository.getallcountcommonmaster(tbcom.getTypeid());
				commastermodel.setTotalItems(count);
				
				comModel.add(commastermodel);
			}
		
		return comModel;

	}

	public CommonMasterModel savecommonmastertype(@Valid CommonMasterModel models) {
		SaveSuccessModel save = new SaveSuccessModel();
		CommonMasterModel savecommastertype = new CommonMasterModel();
		Tbcommonmastertype tbcommaster = null;
		if (models.getId() != null && models.getCode()!=null && models.getType()!=null) {
			tbcommaster = commonMastertype.findByid(models.getId());
			tbcommaster.setEditdate(new Date());
			tbcommaster.setEdituserid(models.getUserID());
			tbcommaster.setUserid(models.getUserID());
			
			
		} else {
			tbcommaster = new Tbcommonmastertype();
			tbcommaster.setActiveStatus('Y');
			tbcommaster.setAdddate(new Date());
			tbcommaster.setAdduserid(models.getUserID());
			tbcommaster.setUserid(models.getUserID());
		}
		tbcommaster.setId(models.getId());

		if(models.getCode()!=null) {
			tbcommaster.setCode(models.getCode());
		}
		if(models.getType()!=null) {
			tbcommaster.setType(models.getType());
	}
		

		commonMastertype.save(tbcommaster);

		savecommastertype.setMessage("Record Saved Successfully!");
		savecommastertype.setStatus("Success");
		return savecommastertype;
	}

	public CommonMasterModel getcommasterByID(Integer trnid)  {
		CommonMasterModel mastermodel = new CommonMasterModel();
		if (trnid != null) {
			Tbcommonmaster tbmaster = commonMasterRepository.findByid(trnid);
			mastermodel.setId(tbmaster.getId());
			if (tbmaster.getShortname() != null) {
				mastermodel.setShortname(tbmaster.getShortname());
			}
			if (tbmaster.getValue() != null) {
				mastermodel.setValue(tbmaster.getValue());
			}
			if (tbmaster.getAdddate() != null) {
				mastermodel.setAdddate(tbmaster.getAdddate());
			}
			if(tbmaster.getTypeid()!=null) {
				Tbcommonmastertype mastertype = commonMastertype.findByid(tbmaster.getTypeid());
				mastermodel.setType(mastertype.getType());
				mastermodel.setCode(mastertype.getCode());
				mastermodel.setTypeid(tbmaster.getTypeid());
				
			}
			if(tbmaster.getDependancyjson()!=null) {
				mastermodel.setCheckboxValue(true);
//				mastermodel.setValueforjson(tbmaster.getDependancyjson());
//				 String input =mastermodel.getValueforjson();
//				   String[] keyValuePairs = input.split(",");
//				   JSONObject jsonObject = new JSONObject();
//			        
//			       
//			        for (String pair : keyValuePairs) {
//			        
//			            String[] keyValue = pair.split(":");
//			            
//			            
//			            String key = keyValue[0];
//			            String value = keyValue[1];
//			            
//			            
//			            jsonObject.put(key,value);
//			        }
//			        mastermodel.setValueforjson(jsonObject.toString());;
				  String jsonString =tbmaster.getDependancyjson();

			        // Convert JSON string to a Map
			        Gson gson = new Gson();
			        Map<String, String> jsonMap = gson.fromJson(jsonString, Map.class);

			        // Convert Map to normal string
			        StringBuilder stringBuilder = new StringBuilder();
			        for (Map.Entry<String, String> entry : jsonMap.entrySet()) {
			            stringBuilder.append(entry.getKey()).append(":").append(entry.getValue()).append(",");
			        }
			        String normalString = stringBuilder.toString();
			        normalString = normalString.substring(0, normalString.length() - 1); // Remove the trailing comma

			        System.out.println(normalString);
			        mastermodel.setValueforjson(normalString);
				System.out.println(mastermodel.getValueforjson());
				
				
//				commastermodel.setValue(tbcom.getDependancyjson());
				mastermodel.setShortname(tbmaster.getValue());
//				
//				
				 
			        
			}
//		

		}
		return mastermodel;

	}

	public List<CommonMasterModel> getCommasterType(@Valid CommonMasterModel usr) {
		List<CommonMasterModel> comModel = new ArrayList<CommonMasterModel>();
		Integer i = 1 ;
		int offsett = (usr.getPageno() - 1) * 10;
		int row_count = 10;
		
		List<Tbcommonmastertype> tbcommaster = commonMastertype.findAllcommaster(offsett, row_count);

//		List<Tbcommonmastertype> tbcommaster = commonMastertype.findAll();

		for (Tbcommonmastertype tbcom : tbcommaster) {
			CommonMasterModel commastermodel = new CommonMasterModel();
			commastermodel.setId(tbcom.getId());
			commastermodel.setCode(tbcom.getCode());
			commastermodel.setType(tbcom.getType());
//			commastermodel.setType(tbcom.getTypeid());
			commastermodel.setTypeid(tbcom.getId());
			

			if (tbcom.getActiveStatus().equals('Y')) {
				commastermodel.setActiveStatus('Y');
			} else {
				commastermodel.setActiveStatus('N');
			}

			
			
			Integer count = commonMastertype.getallcountforcommenmastarhome();
			 commastermodel.setTotalItems(count);
			comModel.add(commastermodel);
		}
		return comModel;
	}

	public CommonMasterModel getcommasterTypeByID(Integer trnid) {
		CommonMasterModel mastertypemodel = new CommonMasterModel();
		if (trnid != null) {
			Tbcommonmastertype tbmastertype = commonMastertype.findByid(trnid);
			mastertypemodel.setId(tbmastertype.getId());
			if (tbmastertype.getCode() != null) {
				mastertypemodel.setCode(tbmastertype.getCode());
			}
			if (tbmastertype.getType() != null) {
				mastertypemodel.setType(tbmastertype.getType());
			}
			if (tbmastertype.getAdddate() != null) {
				mastertypemodel.setAdddate(tbmastertype.getAdddate());
			}

		}
		return mastertypemodel;
	}

	public CommonMasterModel savecommonmaster(@Valid CommonMasterModel models) {
		SaveSuccessModel save = new SaveSuccessModel();
		CommonMasterModel savecommastertype = new CommonMasterModel();
		Tbcommonmaster tbcommaster = null;
		if (models.getId() != null) {
			tbcommaster = commonMasterRepository.findByid(models.getId());
			tbcommaster.setEditdate(new Date());
			tbcommaster.setEdituserid(models.getUserID());
		
			
		} else {
			tbcommaster = new Tbcommonmaster();
			tbcommaster.setActiveStatus('Y');
			tbcommaster.setAdddate(new Date());
			tbcommaster.setAdduserid(models.getUserID());
			tbcommaster.setUserid(models.getUserID());
		}
//		tbcommaster.setId(models.getId());
		if (models.getType()!=null) {
			Tbcommonmastertype tbmastertype = commonMastertype.findByType(models.getType());
			tbcommaster.setTypeid(tbmastertype.getId());
		}
		tbcommaster.setId(models.getId());
		tbcommaster.setShortname(models.getShortname());
		tbcommaster.setValue(models.getValue());

		commonMasterRepository.save(tbcommaster);

		savecommastertype.setMessage("Record Saved Successfully!");
		savecommastertype.setStatus("Success");
		return savecommastertype;
	}
	
	public CommonMasterModel gettypeformasterByID(Integer trnid) {
		CommonMasterModel mastermodel = new CommonMasterModel();
		if (trnid != null) {
				Tbcommonmastertype mastertype = commonMastertype.findByid(trnid);
				mastermodel.setType(mastertype.getType());
				mastermodel.setCode(mastertype.getCode());
//				mastermodel.setId(mastertype.getId());
				mastermodel.setTypeid(mastertype.getId());
		}
		return mastermodel;

	}

	public CommonMasterModel changeStatusForCommonMaster(CommonMasterModel model) {
		SaveSuccessModel savemodel = new SaveSuccessModel();
		CommonMasterModel mastermodel = new CommonMasterModel();
		Tbcommonmaster tbmaster = null;

		if (model.getId() != null) {
			tbmaster = commonMasterRepository.findById(model.getId()).get();
			if (model.getActiveStatus() != null && model.getActiveStatus().equals('Y')) {
				tbmaster.setActiveStatus('Y');
			} else {
				tbmaster.setActiveStatus('N');
			}
			commonMasterRepository.save(tbmaster);
			if (model.getActiveStatus().equals('N')) {
				mastermodel.setStatus("Success");
				mastermodel.setMessage("Record Deleted Successfully!");
			} else {
				mastermodel.setRescoremessage("Deleted Record Successfully Recovered!");
				mastermodel.setStatus1("Success2");
			}
		}
		return mastermodel;
	}

	public CommonMasterModel changeStatusForCommonMasterType(CommonMasterModel model) {
		SaveSuccessModel savemodel = new SaveSuccessModel();
		CommonMasterModel mastertypemodel = new CommonMasterModel();
		Tbcommonmastertype tbmastertype = null;

		if (model.getId() != null) {
			tbmastertype = commonMastertype.findById(model.getId()).get();
			if (model.getActiveStatus() != null && model.getActiveStatus().equals('Y')) {
				tbmastertype.setActiveStatus('Y');
			} else {
				tbmastertype.setActiveStatus('N');
			}
			commonMastertype.save(tbmastertype);
			if (model.getActiveStatus().equals('N')) {
				mastertypemodel.setStatus("Success");
				mastertypemodel.setMessage("Record Deleted Successfully!");
			} else {
				mastertypemodel.setRescoremessage("Deleted Record Successfully Recovered!");
				mastertypemodel.setStatus1("Success2");
			}
		}
		return mastertypemodel;
	}

	public List<CommonMasterModel> getCommasterTypeformicrobe(@Valid CommonMasterModel usr) {
		List<CommonMasterModel> comModel = new ArrayList<CommonMasterModel>();
		
		
		List<Tbcommonmastertype> tbcommaster = commonMastertype.findByMicrobeType('M');

//		List<Tbcommonmastertype> tbcommaster = commonMastertype.findAll();

		for (Tbcommonmastertype tbcom : tbcommaster) {
			CommonMasterModel commastermodel = new CommonMasterModel();
			commastermodel.setId(tbcom.getId());
			commastermodel.setCode(tbcom.getCode());
			commastermodel.setType(tbcom.getType());
//			commastermodel.setType(tbcom.getTypeid());
			commastermodel.setTypeid(tbcom.getId());
			

			if (tbcom.getActiveStatus().equals('Y')) {
				commastermodel.setActiveStatus('Y');
			} else {
				commastermodel.setActiveStatus('N');
			}

			
			
			Integer count = commonMastertype.getallcountforcommenmastarhome();
			 commastermodel.setTotalItems(count);
			comModel.add(commastermodel);
		}
		return comModel;
	}

	public List<CommonMasterModel> getCommonMastermicrobe(@Valid CommonMasterModel usr) {
		List<CommonMasterModel> comModel = new ArrayList<CommonMasterModel>();
//		
		int offsett = (usr.getPageno() - 1) * 10;
//		List<Tbcommonmaster> tbcommaster = commonMasterRepository.findAllById(usr.getUserID());

		int row_count = 10;
//		List<Tbcommonmaster> tbcommaster = commonMasterRepository.findAll();
//		List<Tbcommonmaster> tbcommaster = commonMasterRepository.findAllforpagignation(usr.getTypeid(),offsett, row_count);
		

		List<Tbcommonmastertype> tbcommaster5 = commonMastertype.findByMicrobeType('M');

//		List<Tbcommonmastertype> tbcommaster = commonMastertype.findAll();
		CommonMasterModel commastermodel5 = new CommonMasterModel();
		for (Tbcommonmastertype tbcom : tbcommaster5) {
			
			commastermodel5.setTypeid(tbcom.getId());
		}
		
		
		
		
		List<Tbcommonmaster> tbcommaster = commonMasterRepository.findByTypeid(commastermodel5.getTypeid());
			for (Tbcommonmaster tbcom : tbcommaster) {
				CommonMasterModel commastermodel = new CommonMasterModel();
				commastermodel.setId(tbcom.getId());
				commastermodel.setBactid(tbcom.getId());
				commastermodel.setShortname(tbcom.getShortname());
				commastermodel.setValue(tbcom.getValue());
				commastermodel.setMicrobeTypename(tbcom.getValue());
				commastermodel.setTypeid(tbcom.getTypeid());
				if (tbcom.getTypeid() != null) {
					CommonMasterModel mastertypemodel = new CommonMasterModel();
					Tbcommonmastertype mastertype = commonMastertype.findAllById(tbcom.getTypeid());

					commastermodel.setCode(mastertype.getCode());
					commastermodel.setType(mastertype.getType());
				}
				if (tbcom.getActiveStatus().equals('Y')) {
					commastermodel.setActiveStatus('Y');
				} else {
					commastermodel.setActiveStatus('N');
				}

				
//				
//				Integer count = commonMasterRepository.getallcountcommonmaster(tbcom.getTypeid());
//				commastermodel.setTotalItems(count);
//				
				comModel.add(commastermodel);
			}
		
		return comModel;
	}

	public MicrobeMasterModel saveMicrobemaster(@Valid MicrobeMasterModel mmastsr) {

		MicrobeMasterModel savemictype = new MicrobeMasterModel();
//		MicrobeMasterModel savedept = new MicrobeMasterModel();
		TbMicrobeTypeMaster tbmicmastr = null;
		if (mmastsr.getId() != null) {
			tbmicmastr = microbemasterReository.findByid(mmastsr.getId());
			tbmicmastr.setEditdate(new Date());  
			tbmicmastr.setEdituserid(mmastsr.getUserid());
		} else {
			tbmicmastr = new TbMicrobeTypeMaster();
			tbmicmastr.setActivestatus('Y');
			tbmicmastr.setAdddate(new Date());
			tbmicmastr.setAdduserid(mmastsr.getUserid());
		}
		tbmicmastr.setId(mmastsr.getId());
		tbmicmastr.setTypeid(mmastsr.getTypeid());
		tbmicmastr.setBactid(mmastsr.getBactid());
		tbmicmastr.setGenus(mmastsr.getGenus());
		tbmicmastr.setSpecies(mmastsr.getSpecies());
		

		microbemasterReository.save(tbmicmastr) ;    
		
	

		savemictype.setMessage("Record Saved Successfully!");
		savemictype.setStatus("Success");
		return savemictype;
	}

	public List<MicrobeMasterModel> getmicrobemasterhome(@Valid MicrobeMasterModel usr) {
		List<MicrobeMasterModel> micrbmasthome = new ArrayList<MicrobeMasterModel>();
		Integer i = 1 ;
		int offsett = (usr.getPageno() - 1) * 10;

		int row_count = 10;
		List<TbMicrobeTypeMaster> microhome = microbemasterReository.findAllformicrbetype(offsett, row_count);
//		List<Tbactivitytrans> sampinverdhome = sampleinvertRepository.findAll();
		for (TbMicrobeTypeMaster tbmicrohome : microhome) {
			MicrobeMasterModel sampleinhome = new MicrobeMasterModel();
			sampleinhome.setSrno(i);
			if (tbmicrohome.getId() != null) {
				sampleinhome.setId(tbmicrohome.getId());
			}
			
			if (tbmicrohome.getBactid() != null) {
//				tbcommonmaster
				
				Tbcommonmaster tbcommast =commonMasterRepository.findByid(tbmicrohome.getBactid());
				if(tbcommast!=null) {
				sampleinhome.setBacteria(tbcommast.getValue());
				}
			}
			  
			if (tbmicrohome.getTypeid() != null) {
//				tbcommonmaster
				
				Tbcommonmastertype tbcommastype =commonMasterTypeRepository.findByid(tbmicrohome.getTypeid());
				if(tbcommastype!=null) {
				sampleinhome.setMicrobeType(tbcommastype.getType());
				}
			}
			
			if (tbmicrohome.getGenus() != null) {
				sampleinhome.setGenus(tbmicrohome.getGenus());
			}
			if (tbmicrohome.getSpecies() != null) {
				sampleinhome.setSpecies(tbmicrohome.getSpecies());
			}
			if (tbmicrohome.getActivestatus() != null) {
				sampleinhome.setActivestatus(tbmicrohome.getActivestatus());
			}
		
			Integer count = microbemasterReository.getallcountformicrobemasterhome();
			sampleinhome.setTotalItems(count);

			micrbmasthome.add(sampleinhome);
			i++;
//			
			
		}
		return micrbmasthome;
	}

	public MicrobeMasterModel getmicrobemasterById(Integer trnid) {
		MicrobeMasterModel microbehome = new MicrobeMasterModel();
		if (trnid != null) {
			TbMicrobeTypeMaster tbmicrobe =microbemasterReository.findByid(trnid);
			if(tbmicrobe!=null) {
			if (tbmicrobe.getId() != null) {
				microbehome.setId(tbmicrobe.getId());
			}
			
			if (tbmicrobe.getTypeid() != null) {
				microbehome.setTypeid(tbmicrobe.getTypeid());
				Tbcommonmastertype tbcommastype =commonMasterTypeRepository.findByid(tbmicrobe.getTypeid());
				if(tbcommastype!=null) {
					microbehome.setMicrobeType(tbcommastype.getType());
				}
			}
			if (tbmicrobe.getBactid() != null) {
				microbehome.setBactid(tbmicrobe.getBactid());
				Tbcommonmaster tbcommast =commonMasterRepository.findByid(tbmicrobe.getBactid());
				if(tbcommast!=null) {
					microbehome.setBacteria(tbcommast.getValue());
					
					microbehome.setShortname(tbcommast.getShortname());
					microbehome.setValue(tbcommast.getValue());
				}
			}
			
			if (tbmicrobe.getGenus() != null) {
				microbehome.setGenus(tbmicrobe.getGenus());
			}
			
			if (tbmicrobe.getSpecies() != null) {
				microbehome.setSpecies(tbmicrobe.getSpecies());
			}
			
			
			}
		}
		return microbehome;
	}

	public MicrobeMasterModel deletemicrobeStatus(MicrobeMasterModel model) {
	
		MicrobeMasterModel microb = new MicrobeMasterModel();
		TbMicrobeTypeMaster tbmicrobmatst = null;

		if (model.getId() != null) {
			tbmicrobmatst = microbemasterReository.findById(model.getId()).get();
			if (model.getActivestatus() != null && model.getActivestatus().equals('Y')) {
				tbmicrobmatst.setActivestatus('Y');
			} else {
				tbmicrobmatst.setActivestatus('N');
			}
			microbemasterReository.save(tbmicrobmatst);
			if (model.getActivestatus().equals('N')) {
				microb.setStatus("Success");
				microb.setMessage("Record Deleted Successfully!");
			} else {
				microb.setRescoremessage("Deleted Record Successfully Recovered!");
				microb.setStatus1("Success2");
			}
		}
		return microb;
	}

	public List<MicrobeMasterModel> getSearchForMicrobemaster(@Valid MicrobeMasterModel usr) {
		List<MicrobeMasterModel> searchmicrobemaster = new ArrayList<MicrobeMasterModel>();
		int offsett = (usr.getPageno() - 1) * 10;
		int row_count = 10 ;
		Integer i = 1 ;
		Integer count;
		List<TbMicrobeTypeMaster> tbmicrob = null;
//		List<Tbresource> tbres = employeeMasterRepository.findAll();
		List<TbMicrobeTypeMaster> emList = null;

		if (StringUtils.isBlank(usr.getSearchText())) {
			tbmicrob = microbemasterReository.findAll();
		} else {
			tbmicrob = microbemasterReository.findByGenusAndGenusContainingIgnoreCase(usr.getSearchText(), offsett, row_count) ;
//			
		}
		if(usr.getSearchText().equals("Deleted") || usr.getSearchText().equals("deleted")  ) {
			 count =microbemasterReository.getsearchcountfordeletemicrobe();
			
		}else {
			 count =microbemasterReository.getsearchcountformicrobesearch(usr.getSearchText());
		}
		
		for (TbMicrobeTypeMaster tbmicrobm : tbmicrob) {
			MicrobeMasterModel microbehome = new MicrobeMasterModel();
			microbehome.setSrno(i);
			if (tbmicrobm.getId() != null) {
				microbehome.setId(tbmicrobm.getId());
			}
			
			if (tbmicrobm.getBactid() != null) {
//				tbcommonmaster
				
				Tbcommonmaster tbcommast =commonMasterRepository.findByid(tbmicrobm.getBactid());
				if(tbcommast!=null) {
					microbehome.setBacteria(tbcommast.getValue());
				}
			}
			  
			if (tbmicrobm.getTypeid() != null) {
//				tbcommonmaster
				
				Tbcommonmastertype tbcommastype =commonMasterTypeRepository.findByid(tbmicrobm.getTypeid());
				if(tbcommastype!=null) {
					microbehome.setMicrobeType(tbcommastype.getType());
				}
			}
			
			if (tbmicrobm.getGenus() != null) {
				microbehome.setGenus(tbmicrobm.getGenus());
			}
			if (tbmicrobm.getSpecies() != null) {
				microbehome.setSpecies(tbmicrobm.getSpecies());
			}
			if (tbmicrobm.getActivestatus() != null) {
				microbehome.setActivestatus(tbmicrobm.getActivestatus());
			}
		
			

//			 count = microbemasterReository.getallcountformicrobemaster();
		
			microbehome.setTotalItems(count);
//			searchmicrobemaster.add(microbehome);

			searchmicrobemaster.add(microbehome);
			i++;

		}
		return searchmicrobemaster;
	}

	public List<MicrobeMasterModel> getCommonMastermicrobeforGenus(@Valid MicrobeMasterModel usr) {
		List<MicrobeMasterModel> getmicrobemaster = new ArrayList<MicrobeMasterModel>();

		
		List<TbMicrobeTypeMaster> tbmicrobemaster = microbemasterReository.findByBactid(usr.getBactid());
			for (TbMicrobeTypeMaster tbmicmast : tbmicrobemaster) {
				MicrobeMasterModel microbemastermodel = new MicrobeMasterModel();
				microbemastermodel.setId(tbmicmast.getId());
				microbemastermodel.setGenusid(usr.getBactid());
				
				microbemastermodel.setTypeid(tbmicmast.getTypeid());
				microbemastermodel.setGenus(tbmicmast.getGenus());
//				microbemastermodel.setSpecies(tbmicmast.getSpecies());
				

				getmicrobemaster.add(microbemastermodel);
			}
		
		return getmicrobemaster;
	}

	public List<MicrobeMasterModel> getCommonMasterforspecies(@Valid MicrobeMasterModel usr) {
	List<MicrobeMasterModel> getmicrobemaster = new ArrayList<MicrobeMasterModel>();

		
		List<TbMicrobeTypeMaster> tbmicrobemaster = microbemasterReository.findByBactidAndGenus(usr.getBactid(),usr.getGenus());
			for (TbMicrobeTypeMaster tbmicmast : tbmicrobemaster) {
				MicrobeMasterModel microbemastermodel = new MicrobeMasterModel();
				microbemastermodel.setId(tbmicmast.getId());
				microbemastermodel.setSpeciesid(tbmicmast.getId());
				
				microbemastermodel.setTypeid(tbmicmast.getTypeid());
//				microbemastermodel.setGenus(tbmicmast.getGenus());
				microbemastermodel.setSpecies(tbmicmast.getSpecies());
				

				getmicrobemaster.add(microbemastermodel);
			}
		
		return getmicrobemaster;
	}
	
	
	public List<CommonMasterModel> getCommasterTypefordropdown(@Valid CommonMasterModel usr) {
		List<CommonMasterModel> comModel = new ArrayList<CommonMasterModel>();
//		Integer i = 1 ;
//		int offsett = (usr.getPageno() - 1) * 10;
//		int row_count = 10;
//		
		List<Tbcommonmastertype> tbcommaster = commonMastertype.findAll();

//		List<Tbcommonmastertype> tbcommaster = commonMastertype.findAll();

		for (Tbcommonmastertype tbcom : tbcommaster) {
			CommonMasterModel commastermodel = new CommonMasterModel();
			commastermodel.setId(tbcom.getId());
			commastermodel.setCode(tbcom.getCode());
			commastermodel.setType(tbcom.getType());
//			commastermodel.setType(tbcom.getTypeid());
			commastermodel.setTypeid(tbcom.getId());
			

			if (tbcom.getActiveStatus().equals('Y')) {
				commastermodel.setActiveStatus('Y');
			} else {
				commastermodel.setActiveStatus('N');
			}

			
//			
//			Integer count = commonMastertype.getallcountforcommenmastarhome();
//			 commastermodel.setTotalItems(count);
			comModel.add(commastermodel);
		}
		return comModel;
	}

	public List<CommonMasterModel> getMasterData(@Valid CommonMasterModel usr) {
		List<CommonMasterModel> comModel = new ArrayList<CommonMasterModel>();

		if (usr.getMessage() != null) {

			Tbcommonmastertype mastertype = commonMastertype.findByType(usr.getValue());

			if (mastertype != null) {
				mastertype.setId(mastertype.getId());

				List<Tbcommonmaster> tbcommaster = commonMasterRepository.findByTypeid1(mastertype.getId());
				for (Tbcommonmaster tbcom : tbcommaster) {
					CommonMasterModel commastermodel = new CommonMasterModel();
					commastermodel.setId(tbcom.getId());

					if(usr.getValue().equals("District")) {
					
						
						ObjectMapper objectMapper = new ObjectMapper();
						    TypeReference<List<DependancyModel>> listType = new TypeReference<List<DependancyModel>>() {};
						    List<DependancyModel> jacksonList =new ArrayList<DependancyModel>();
						    List<DependancyModel> jacksonListstring2 =new ArrayList<DependancyModel>();
							try {
								jacksonList = objectMapper.readValue(tbcom.getDependancyjson(), listType);
							} catch (Exception e) {
								e.printStackTrace();
							}
							commastermodel.setDistList(jacksonList);
							
							for (DependancyModel object: commastermodel.getDistList()) {


							    commastermodel.setDepenname(object.getDepenname()); 
							}
////						
				}
					else{
					commastermodel.setShortname(tbcom.getValue());

					
				}
					commastermodel.setTypeid(tbcom.getTypeid());

					if (tbcom.getActiveStatus().equals('Y')) {
						commastermodel.setActiveStatus('Y');
					} else {
						commastermodel.setActiveStatus('N');
					}


					comModel.add(commastermodel);
				}
			}

		} else {
			Tbcommonmastertype mastertype = commonMastertype.findByType(usr.getValue());
			if (mastertype != null) {
				mastertype.setId(mastertype.getId());

				List<Tbcommonmaster> tbcommaster = commonMasterRepository.findByTypeid1(mastertype.getId());
				for (Tbcommonmaster tbcom : tbcommaster) {
					CommonMasterModel commastermodel = new CommonMasterModel();
					
					commastermodel.setId(tbcom.getId());
					if(usr.getValue().equals("District")) {

						ObjectMapper objectMapper = new ObjectMapper();
//						  objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
						    TypeReference<List<DependancyModel>> listType = new TypeReference<List<DependancyModel>>() {};
						    List<DependancyModel> jacksonList =new ArrayList<DependancyModel>();
						    List<DependancyModel> jacksonListstring2 =new ArrayList<DependancyModel>();
							try {
								jacksonList = objectMapper.readValue(tbcom.getDependancyjson(), listType);
							} catch (Exception e) {
								e.printStackTrace();
							}

							commastermodel.setDistList(jacksonList);
							for (DependancyModel object: commastermodel.getDistList()) {

							    commastermodel.setDepenname(object.getDepenname()); 
//							    commastermodel.setShortname(object.getDepenname());
							    commastermodel.setShortname(tbcom.getValue());
							    comModel.add(commastermodel);
							}

					
					}
					else {
						commastermodel.setShortname(tbcom.getValue());
					}
					
					commastermodel.setTypeid(tbcom.getTypeid());

					if (tbcom.getActiveStatus().equals('Y')) {
						commastermodel.setActiveStatus('Y');
					} else {
						commastermodel.setActiveStatus('N');
					}
					Integer count = commonMasterRepository.getallcountcommonmaster(tbcom.getTypeid());
					commastermodel.setTotalItems(count);

					comModel.add(commastermodel);
				}
			}
		}
System.out.println(comModel);
		return comModel;
	}
	
	public List<CommonMasterModel> getCommasterTypefordependacy(@Valid CommonMasterModel usr) {
		List<CommonMasterModel> comModel = new ArrayList<CommonMasterModel>();
		Integer i = 1 ;
		
		List<Tbcommonmastertype> tbcommaster = commonMastertype.findAll();

//		List<Tbcommonmastertype> tbcommaster = commonMastertype.findAll();

		for (Tbcommonmastertype tbcom : tbcommaster) {
			CommonMasterModel commastermodel = new CommonMasterModel();
			commastermodel.setId(tbcom.getId());
			commastermodel.setCode(tbcom.getCode());
			commastermodel.setType(tbcom.getType());
//			commastermodel.setType(tbcom.getTypeid());
			commastermodel.setTypeid(tbcom.getId());
			

			if (tbcom.getActiveStatus().equals('Y')) {
				commastermodel.setActiveStatus('Y');
			} else {
				commastermodel.setActiveStatus('N');
			}

			
			
//			Integer count = commonMastertype.getallcountforcommenmastarhome();
//			 commastermodel.setTotalItems(count);
			comModel.add(commastermodel);
		}
		return comModel;
	}

	public List<CommonMasterModel> getCommonMasterfordependancy(@Valid CommonMasterModel usr) {
		List<CommonMasterModel> comModel = new ArrayList<CommonMasterModel>();
//		  
//		int offsett = (usr.getPageno() - 1) * 10;
//		List<Tbcommonmaster> tbcommaster = commonMasterRepository.findAllById(usr.getUserID());

//		int row_count = 10;
//		List<Tbcommonmaster> tbcommaster = commonMasterRepository.findAll();
		List<Tbcommonmaster> tbcommaster = commonMasterRepository.findByTypeid(usr.getTypeidfordep());
		
//		List<Tbcommonmaster> tbcommaster = commonMasterRepository.findByTypeid(usr.getTypeid());
			for (Tbcommonmaster tbcom : tbcommaster) {
				CommonMasterModel commastermodel = new CommonMasterModel();
				commastermodel.setId(tbcom.getId());
				commastermodel.setShortname(tbcom.getShortname());
				commastermodel.setValue(tbcom.getValue());
				commastermodel.setTypeid(tbcom.getTypeid());

//				if (tbcom.getTypeid() != null) {
//					CommonMasterModel mastertypemodel = new CommonMasterModel();
//					Tbcommonmastertype mastertype = commonMastertype.findAllById(tbcom.getTypeid());
//
//					commastermodel.setCode(mastertype.getCode());
//					commastermodel.setType(mastertype.getType());
////					comModel.add(commastermodel);
//				}
				if (tbcom.getActiveStatus().equals('Y')) {
					commastermodel.setActiveStatus('Y');
				} else {
					commastermodel.setActiveStatus('N');
				}

				
				
//				Integer count = commonMasterRepository.getallcountcommonmaster(tbcom.getTypeid());
//				commastermodel.setTotalItems(count);
				
				comModel.add(commastermodel);
			}
		
		return comModel;
	}

	public CommonMasterModel savecommonmasterdependancy(@Valid CommonMasterModel models)  {
		SaveSuccessModel save = new SaveSuccessModel();
		CommonMasterModel savecommastertype = new CommonMasterModel();
//		DependancyModel 
		Tbcommonmaster tbcommaster = null;
		if (models.getId() != null) {
			tbcommaster = commonMasterRepository.findByid(models.getId());
			tbcommaster.setEditdate(new Date());
			tbcommaster.setEdituserid(models.getUserID());
		
			
		} else {
			tbcommaster = new Tbcommonmaster();
			tbcommaster.setActiveStatus('Y');
			tbcommaster.setAdddate(new Date());
			tbcommaster.setAdduserid(models.getUserID());
			tbcommaster.setUserid(models.getUserID());
		}
		
		if (models.getTypeidfordepsortname()!=null) {
			Tbcommonmaster tbcommasterdep = commonMasterRepository.findByid(models.getTypeidfordepsortname());
			tbcommaster.setShortname(tbcommasterdep.getShortname());
			tbcommaster.setValue(tbcommasterdep.getValue());
		}
//		tbcommaster.setId(models.getId());
		if (models.getType()!=null) {
			Tbcommonmastertype tbmastertype = commonMastertype.findByType(models.getType());
			tbcommaster.setTypeid(tbmastertype.getId());
			
			tbmastertype.setDependencyid(models.getTypeidfordep());
			commonMastertype.save(tbmastertype);
		}
		tbcommaster.setId(models.getId());

//		tbcommaster.setDependancyjson(models.getValueforjson());
//		  String input =models.getValueforjson();
//		   String[] keyValuePairs = input.split(",");
//		   JSONObject jsonObject = new JSONObject();
//	        
//	        for (String pair : keyValuePairs) {
//	        
//	            String[] keyValue = pair.split(":");
//	            
//	            String key = keyValue[0];
//	            String value = keyValue[1];
//	            
//	            
//	            try {
//					jsonObject.put(key, value);
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//	        }
		

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = "";
		try {
			jsonString = objectMapper.writeValueAsString(models.getDistList());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	        tbcommaster.setDependancyjson(jsonString);
	        
	        try {
			
		commonMasterRepository.save(tbcommaster);

		savecommastertype.setMessage("Record Saved Successfully!");
		savecommastertype.setStatus("Success");
		
			} catch (Exception ex) {
				savecommastertype.setMessage("Please Enter Valid Format!");
				savecommastertype.setStatus("Error1");
			}
			
		return savecommastertype;
	}
}
