package com.backend.webappserver.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.webappserver.page.service.CommonMasterService;
import com.backend.webappserver.page.service.IsolateService;
import com.backend.webappserver.page.service.SampleinverdService;
import com.backend.webappserver.payload.CommonForAllModel;
import com.backend.webappserver.payload.CommonMasterModel;
import com.backend.webappserver.payload.DepartmentModel;
import com.backend.webappserver.payload.IsolateModel;
import com.backend.webappserver.payload.MicrobeMasterModel;
import com.backend.webappserver.payload.SampleinvertModel;
import com.backend.webappserver.payload.User;




@RestController
@RequestMapping("/api/transaction")
public class TransactionApi {

	@Autowired 
	private SampleinverdService sampleinverdService;
	
	@Autowired
	private CommonMasterService commonMasterService;
	
	@Autowired
	private IsolateService isolateService;
	
	
	@PostMapping("/savesampleinverd")
	public SampleinvertModel savesampleinverd(@Valid @RequestBody SampleinvertModel samp) {
		SampleinvertModel sampin = sampleinverdService.savesampleinverd(samp);
		return sampin;
	}
	
	@PostMapping("/getsamphome")
	public List<SampleinvertModel> getsamphome(@Valid @RequestBody SampleinvertModel sampho) {
		List<SampleinvertModel> samphome = sampleinverdService.getsamphome(sampho);
		return samphome;
	}
	@PostMapping("/getsapleivertById")
	public SampleinvertModel getsapleivertById(@Valid @RequestBody User model) {
		SampleinvertModel employeemodel = sampleinverdService.getsapleivertById(model.getTrnid());
		return employeemodel;
	}
	
	@PostMapping("/changesampleinStatus")
	public SampleinvertModel changesampleinStatus(@RequestBody SampleinvertModel model) {
		return sampleinverdService.changesampleinStatus(model);
	}
	@PostMapping("/getSearchForsampleinward")
	public List<SampleinvertModel> getSearchForsampleinward(@Valid @RequestBody SampleinvertModel usr) {
		List<SampleinvertModel> searchempsampinvetr = sampleinverdService.getSearchForsampleinward(usr);
		return searchempsampinvetr;
	}
	
	@PostMapping("/getOtpForIsolated")
	public List<SampleinvertModel> getOtpForIsolated(@Valid @RequestBody SampleinvertModel otpget) {
		List<SampleinvertModel> isolate = isolateService.getOtpForIsolated(otpget);
		return isolate;
	}
	
	
	@PostMapping("/getoverwrightotp")
	public SampleinvertModel getoverwrightotp(@Valid @RequestBody SampleinvertModel model) {
		SampleinvertModel isolaterewright = sampleinverdService.getoverwrightotp(model.getSampleno());
		return isolaterewright;
	}
	@PostMapping("/saveisolatecodereplacetootp")
	public SampleinvertModel saveisolatecodereplacetootp(@Valid @RequestBody SampleinvertModel samp) {
		SampleinvertModel sampin = sampleinverdService.saveisolatecodereplacetootp(samp);
		return sampin;
	}
	
	@PostMapping("/getfindisolate")
	public SampleinvertModel getfindisolate(@Valid @RequestBody SampleinvertModel model) {
		SampleinvertModel isolatefind = sampleinverdService.getfindisolate(model.getSamplenov());
		return isolatefind;
	}
	
	@PostMapping("/saveisolatecode")
	public IsolateModel saveisolatecode(@Valid @RequestBody IsolateModel iso) {
		IsolateModel saveiso = isolateService.saveisolatecode(iso);
		return saveiso;
	}

	@PostMapping("/getactitransctionhome")
	public List<IsolateModel> getactitransctionhome(@Valid @RequestBody IsolateModel actitrans){
		List<IsolateModel> acttransaction =isolateService.getactitransctionhome(actitrans);
		return acttransaction;
	}
	
	@PostMapping("/getSearchForactitransaction")
	public List<IsolateModel> getSearchForactitransaction(@Valid @RequestBody IsolateModel actitrans) {
		List<IsolateModel> searchactitrans = isolateService.getSearchForactitransaction(actitrans);
		return searchactitrans;
	}
	@PostMapping("/getmicrobeidentificationByid")
	public MicrobeMasterModel getmicrobeidentificationByid(@Valid @RequestBody User model) {
		MicrobeMasterModel microbemodel = isolateService.getmicrobeidentificationByid(model.getTrnid());
		return microbemodel;
	}
	@PostMapping("/savemicrobidentification")
	public IsolateModel savemicrobidentification(@Valid @RequestBody IsolateModel iso) {
		IsolateModel saveiso = isolateService.savemicrobidentification(iso);
		return saveiso;
	}
	@PostMapping("/getMasterData")
	public List<CommonMasterModel> getMasterData(@Valid @RequestBody CommonMasterModel usr) {
		List<CommonMasterModel> comModel = commonMasterService.getMasterData(usr);
		return comModel;
	}
	
	@PostMapping("/getLevel2ActivityHome")
	public List<IsolateModel> getLevel2ActivityHome(@Valid @RequestBody IsolateModel l2actitrans){
		List<IsolateModel> l2acttransaction =isolateService.getLevel2ActivityHome(l2actitrans);
		return l2acttransaction;
	}
	
	@PostMapping("/findisolaecodeforplantassesment")
	public SampleinvertModel findisolaecodeforplantassesment(@Valid @RequestBody SampleinvertModel model) {
		SampleinvertModel isolatecodefindforpass = sampleinverdService.findisolaecodeforplantassesment(model.getIsolatecode());
		return isolatecodefindforpass;
	}
	
	@PostMapping("/saveLevel2ActivityPlantassisscode")
	public IsolateModel saveLevel2ActivityPlantassisscode(@Valid @RequestBody IsolateModel pnassissment) {
		IsolateModel savepnassiss = isolateService.saveLevel2ActivityPlantassisscode(pnassissment);
		return savepnassiss;
	}
	
	@PostMapping("/getSearchForLevel2actitransaction")
	public List<IsolateModel> getSearchForLevel2actitransaction(@Valid @RequestBody IsolateModel l2actitrans) {
		List<IsolateModel> searchl2actitrans = isolateService.getSearchForLevel2actitransaction(l2actitrans);
		return searchl2actitrans;
	}
	@PostMapping("/getSearchAllForMicrobeHome")
	public List<CommonForAllModel> getSearchAllForMicrobeHome(@Valid @RequestBody CommonForAllModel searchall){
		List<CommonForAllModel> searchallmicrobe =isolateService.getSearchAllForMicrobeHome(searchall);
		return searchallmicrobe;
	}
	@PostMapping("/getParamiterForSearchMicrobe")
	public CommonForAllModel getParamiterForSearchMicrobe(@Valid @RequestBody CommonForAllModel searchallpara){
		CommonForAllModel searchallparamicrobe =isolateService.getParamiterForSearchMicrobe(searchallpara);
		return searchallparamicrobe;
	}
//	@PostMapping("/getParametersByid")
//	public CommonForAllModel getParametersByid(@Valid @RequestBody CommonForAllModel searchallpara){
//		CommonForAllModel searchallparamicrobe =isolateService.getParametersByid(searchallpara);
//		return searchallparamicrobe;
//	}
//	getParamiterForSearchMicrobe
}
