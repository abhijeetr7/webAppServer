package com.backend.webappserver.page.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.webappserver.data.model.Tbactivity;
import com.backend.webappserver.data.model.Tbactivitytrans;
import com.backend.webappserver.payload.JsonModel;
import com.backend.webappserver.payload.ParamModel;
import com.backend.webappserver.payload.SaveSuccessModel;
import com.backend.webappserver.payload.activityModel;
import com.backend.webappserver.repository.ActivityRepository;
import com.backend.webappserver.repository.IsolateRepository;
import com.backend.webappserver.repository.ParamRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;


@Service
public class ParameterconfService {
	
	@Autowired
	private ParamRepository paramRepository;
	
	@Autowired
	private ActivityRepository activityRepository;
	
	@Autowired
	private IsolateRepository isolaterepository;

	public ParamModel saveParameters(@Valid ParamModel models) {
		SaveSuccessModel save = new SaveSuccessModel();
		Tbactivity tbparam = null;

		ObjectMapper objectMapper = new ObjectMapper();
		String jsonString = "";
		try {
			jsonString = objectMapper.writeValueAsString(models.getActiveList());
		} catch (Exception e) {
			e.printStackTrace();
		}
//		System.out.println(jsonString);
		if (models.getId() != null) {
			tbparam = activityRepository.findById(models.getId()).get();
		} else {
			tbparam = new Tbactivity();
		}
		tbparam.setParameters(jsonString);
		tbparam.setStatus('Y');
		
		activityRepository.save(tbparam);
		save.setMessage("Record Saved Successfully!");
		save.setStatus("Success");
		return null;
	}

	public ParamModel getParamconf(@Valid ParamModel models) {
		
		Tbactivity tbparam = activityRepository.findById(models.getId()).get();
		 ParamModel parammodels = new ParamModel();
		 models.setId(tbparam.getId());

//		 models.setActivityname(tbparam.getActivityname());
		  ObjectMapper objectMapper = new ObjectMapper();
//		  objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		    TypeReference<List<ParamModel>> listType = new TypeReference<List<ParamModel>>() {};
		    List<ParamModel> jacksonList =new ArrayList<ParamModel>();
		    List<ParamModel> jacksonListstring2 =new ArrayList<ParamModel>();
			try {
				jacksonList = objectMapper.readValue(tbparam.getParameters(), listType);
//				objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			} catch (Exception e) {
				e.printStackTrace();
			}
			parammodels.setActiveList(jacksonList);
			parammodels.setActivityname(tbparam.getActivityname());
			parammodels.setActivitylevel(tbparam.getActivitylevel());
			parammodels.setSequence(tbparam.getSequence());
			
//			jacksonList.sort(null);
		return parammodels;
	}
	

	public ParamModel saveActivityParameters(@Valid ParamModel models) {
		ParamModel parammodels = new ParamModel();
		JsonModel jsonModel = new JsonModel();
		Tbactivity tbparam = activityRepository.findById(models.getActid()).get();

		 models.setActid(tbparam.getId());
		 models.setActivityname(tbparam.getActivityname());
//		 String parameterforlist ;
////		 models.setActivityname(tbparam.getActivityname());


////		  objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//		    TypeReference<List<ParamModel>> listType = new TypeReference<List<ParamModel>>() {};
//		    ObjectNode activityInput = objectMapper.createObjectNode();
//		    List<ParamModel> jacksonList =new ArrayList<ParamModel>();
//		    List<ParamModel> jacksonList1 =new ArrayList<ParamModel>();
//		    List<ParamModel> jacksonList12 =new ArrayList<ParamModel>();
//		    List<String> jacksonListstring =new ArrayList<String>();
//		    List<String> jacksonListstring1 =new ArrayList<String>();
//		    List<String> jacksonListstring2 =new ArrayList<String>();
//			try {
//				jacksonList = objectMapper.readValue(tbparam.getParameters(), listType);
////				objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			for (ParamModel paramModel : jacksonList) {
//				   jacksonListstring1.add(paramModel.getParameterName());
//			}
//		if(models.getInputList()!=null) {
//			for (String  paramModel1 : models.getInputList()) {
//				String[] arr1 = String.valueOf(paramModel1).split(",");
//				if (arr1 != null || arr1.length>0){
//					jsonModel.setInput(arr1[0]);
//					  jacksonListstring2.add(arr1[0]);
////					jacksonList1.add(parammodels);		
//				}
//			}
//		}
//			for (int i = 0; i < jacksonListstring1.size(); i++) {
//			    String processedData = String.format("%s: %s", jacksonListstring1.get(i), jacksonListstring2.get(i));
//			    
//			    jacksonListstring.add(processedData);
//
////			    System.out.println(jacksonListstring);
//
//			    ObjectNode input = objectMapper.createObjectNode();
//			    input.put("inputList", jacksonListstring.toString());
//				 activityInput.put("activityname", tbparam.getActivityname());
//				 activityInput.set("inputList", input);
////				 System.out.println(activityInput);
		
//			}
//			jsonModel.setInputList(jacksonListstring);

			Tbactivitytrans tbactivity = isolaterepository.findById(models.getId()).get();
			jsonModel.setSampleinno(tbactivity.getSampleinno());
			jsonModel.setSampinvid(tbactivity.getSampinvid());
			jsonModel.setSampleno(tbactivity.getSampleinno());
			jsonModel.setSamplenov(tbactivity.getSamplenov());
//			jsonModel.setSvparams(activityInput.toString());
			ObjectMapper objectMapper2 = new ObjectMapper();
//			  objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			    TypeReference<List<ParamModel>> listType = new TypeReference<List<ParamModel>>() {};
			    List<ParamModel> jacksonList =new ArrayList<ParamModel>();
			    List<ParamModel> jacksonListstring2 =new ArrayList<ParamModel>();
				try {
					jacksonList = objectMapper2.readValue(tbactivity.getSvparams(), listType);
					parammodels.setActiveList(jacksonList);
//					objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
//				System.out.println(jacksonList);
//			if(tbactivity.getSvparams()!=null){
//				jsonModel.setSvparams(activityInput.toString().concat(tbactivity.getSvparams()));
			 List<String> inputListfor = new ArrayList<String>();
			for (String inputstr : models.getInputList()) {
//				String str=inputstr.replace("\\", "\\");
				 String str = inputstr.replace("\\", "");
//				 String str = models.getActivityname().concat(inputstr.replace("\\", ""))  ;
				inputListfor.add(str);
			}
				jsonModel.setInputList(inputListfor);
//				 StringBuilder stringBuilder = new StringBuilder();
//				 
//			            stringBuilder.append(activityInput).append(tbactivity.getSvparams());
//			            String normalString=stringBuilder.toString();
//			            jsonModel.setSvparams(normalString);
//			}
//			if(tbactivity.getSvparams()!=null){
//				jsonModel.setSvparams(activityInput.toString().concat(tbactivity.getSvparams()));
//			}

//			  String input =tbactivity.getSvparams();
//			   String[] keyValuePairs = input.split(",");
//			   JSONObject jsonObject = new JSONObject();
//
//		        for (String pair : keyValuePairs) {
//
//		            String[] keyValue = pair.split(":");
//
//		            String key = keyValue[0];
//		            String value = keyValue[1];
//
//
//		            try {
//						jsonObject.put(key, value);
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//		        }
//			
//			 String json = tbactivity.getSvparams();
//		        ObjectMapper objectMapper9 = new ObjectMapper();
//		        SampleModel sampleModel = new SampleModel();
//				try {
//					sampleModel = objectMapper9.readValue(json, SampleModel.class);
//				} catch (JsonMappingException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (JsonProcessingException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		        System.out.println(sampleModel);
			
//			jsonModel.setSvparams(tbactivity.getSvparams().concat(activityInput.toString()));
			
//			parammodels.setSvparams(tbactivity.getSamplenov().concat(tbactivity.getSampleinno()));

//			parammodels.setSvparams(jacksonListstring);
			
			ObjectMapper objectMapper1 = new ObjectMapper();
			String svparam = "";
			try {
				svparam = objectMapper1.writeValueAsString(jsonModel);
				 String str = svparam.replace("\\", "");

				jsonModel.setSvparams(str);
			} catch (Exception e) {
				e.printStackTrace();
			}
//			System.out.println(svparam);
			System.out.println(jsonModel);
			
			if (models.getId() != null) {
				tbactivity = isolaterepository.findById(models.getId()).get();
				if(tbactivity!=null) {
				tbactivity.setSvparams(jsonModel.getSvparams());
				}
//				parammodels.setSvparams(svparam);
			} else {
				tbactivity = new Tbactivitytrans();
			}

			isolaterepository.save(tbactivity);
			parammodels.setMessage("Success");
//			tbactivity.setSvparams(svparam);
		return parammodels;
	}
	
	public List<activityModel> getactivityforparamconf(@Valid activityModel usr) {
		List<activityModel> activity = new ArrayList<activityModel>();
		Integer i = 1 ;
//		List<Tbactivity> act = activityRepository.findAll();
		List<Tbactivity> act = activityRepository.findByActivitylevel(usr.getActivitylevel());
		
		for (Tbactivity tbactivity : act) {
			activityModel actmodel = new activityModel();
			
//			&& tbactivity.getActivitylevel().equals("Level 1")
			if(tbactivity.getActivitylevel()!=null ) {
//				for only level 1 Activities
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
		}
		return activity;
	}

	public ParamModel getActivityParametersByid(@Valid ParamModel models) {
		Tbactivity tbparam = activityRepository.findById(models.getTrnid()).get();
		 ParamModel parammodels = new ParamModel();
		 models.setId(tbparam.getId());

//		 models.setActivityname(tbparam.getActivityname());
		  ObjectMapper objectMapper = new ObjectMapper();
//		  objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		    TypeReference<List<ParamModel>> listType = new TypeReference<List<ParamModel>>() {};
		    List<ParamModel> jacksonList =new ArrayList<ParamModel>();
		    List<ParamModel> jacksonListstring2 =new ArrayList<ParamModel>();
			try {
				jacksonList = objectMapper.readValue(tbparam.getParameters(), listType);
//				objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			} catch (Exception e) {
				e.printStackTrace();
			}
			parammodels.setActiveList(jacksonList);
			parammodels.setActivityname(tbparam.getActivityname());	
			parammodels.setActivitylevel(tbparam.getActivitylevel());
			parammodels.setSequence(tbparam.getSequence());
			parammodels.setId(tbparam.getId());
			parammodels.setActid(tbparam.getId());
			
//			jacksonList.sort(null);
		return parammodels;
	}
	
	
	
}
