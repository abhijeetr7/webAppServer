package com.backend.webappserver.page.service;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.webappserver.data.model.Tbactivitytrans;
import com.backend.webappserver.data.model.Tbsampleinverd;
import com.backend.webappserver.data.model.tblevel2activitytrans;
import com.backend.webappserver.payload.SampleinvertModel;
import com.backend.webappserver.repository.IsolateRepository;
import com.backend.webappserver.repository.Level2ActivityRepository;
import com.backend.webappserver.repository.SampleinvertRepository;

import org.apache.commons.lang3.StringUtils;


@Service
public class SampleinverdService {

	@Autowired
	private SampleinvertRepository sampleinvertRepository;

	@Autowired
	private IsolateRepository isolateRepository;
	@Autowired
	private Level2ActivityRepository level2ActivityRepository;

	public SampleinvertModel savesampleinverd(@Valid SampleinvertModel samp) {
//		SampleinvertModel sampleinvert = new SampleinvertModel();
		SampleinvertModel sampmodel = new SampleinvertModel();

		int length = 10;
		Tbsampleinverd sampin = null;
		if (samp.getId() != null) {
			sampin = sampleinvertRepository.findByid(samp.getId());
			sampin.setEditdate(new Date());
			sampin.setEdituserid(samp.getUserID());
		} else {
			sampin = new Tbsampleinverd();
			sampin.setActive('Y');
			sampin.setAdddate(new Date());
			sampin.setAdduserid(samp.getUserID());
		}

		sampin.setSamplingdate(samp.getSamplingdate());
		sampin.setSamplecollectdate(samp.getSamplecollectdate());
		sampin.setSamplecollectedby(samp.getUserID().toString());
		sampin.setSampledby(samp.getSampledby());
		int lengthcode = 5;
		String numbers = "0123456789";
		Random randomcode = new Random();
		StringBuilder otp15 = new StringBuilder();

		for (int i = 0; i < lengthcode; i++) {
			int index = randomcode.nextInt(numbers.length());
			otp15.append(numbers.charAt(index));
		}
		sampin.setSampleno(otp15.toString());
//			format Stert sampleinno 202311VF6s
//		StringBuilder sbSampleno = new StringBuilder(length);
//        Random randomSampleno = new Random();
//        String ALPHANUMERIC_CHARSSampleno = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
//
//        for (int z = 0; z < length; z++) {
//            int randomIndexSampleno = randomSampleno.nextInt(ALPHANUMERIC_CHARSSampleno.length());
//            char randomCharSampleno = ALPHANUMERIC_CHARSSampleno.charAt(randomIndexSampleno);
//            sbSampleno.append(randomCharSampleno);
//        }
//            sampin.setSampleno(sbSampleno.toString());

//		format Ends sampleinno 202311VF6s

//        format start    sampleinno 202311VF6s

		if (samp.getSampleinno() != null) {
			sampin.setSampleinno(samp.getSampleinno());
//		        	sampin.setSampleinno("ICWWfN4DAB");

		} else {
			StringBuilder sb = new StringBuilder(length);
			Random random = new Random();
			String ALPHANUMERIC_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
			for (int i = 0; i < length; i++) {
				int randomIndex = random.nextInt(ALPHANUMERIC_CHARS.length());
				char randomChar = ALPHANUMERIC_CHARS.charAt(randomIndex);
				sb.append(randomChar);
//				            sampin.setSampleinno("lVicarGVGA");
			}
//		            sampin.setSampleinno(randomChar);

			Calendar calendar = Calendar.getInstance();
			int yearf = calendar.get(Calendar.YEAR);
			int monthf = calendar.get(Calendar.MONTH) + 1;
			sampin.setSampleinno(yearf + "" + monthf + "" + sb.toString());

		}
//		        format end    sampleinno 202311VF6s

		try {
			sampleinvertRepository.save(sampin);
		} catch (Exception ex) {

			StringBuilder sbSampleno1 = new StringBuilder(length);
			Random randomSampleno1 = new Random();
			String ALPHANUMERIC_CHARSSampleno1 = "fghijklmnopqrstuvwxyzabceZA0123456789";

			for (int z = 0; z < length; z++) {
				int randomIndexSampleno1 = randomSampleno1.nextInt(ALPHANUMERIC_CHARSSampleno1.length());
				char randomCharSampleno1 = ALPHANUMERIC_CHARSSampleno1.charAt(randomIndexSampleno1);
				sbSampleno1.append(randomCharSampleno1);
			}
			sampin.setSampleno(sbSampleno1.toString());

			sampmodel.setMessage(sbSampleno1.toString());
			sampmodel.setStatus("Success");

			return sampmodel;

		}

//		 sampmodel.setMessage("Record Saved Successfully!" );
		sampmodel.setMessage(otp15.toString());
		sampmodel.setStatus("Success");

		return sampmodel;
	}

	public List<SampleinvertModel> getsamphome(@Valid SampleinvertModel sampho) {
		List<SampleinvertModel> samp = new ArrayList<SampleinvertModel>();
		Integer i = 1;
		int offsett = (sampho.getPageno() - 1) * 10;

		int row_count = 10;
		List<Tbsampleinverd> sampinverdhome = sampleinvertRepository.findAllforsampl(offsett, row_count);
//		List<Tbsampleinverd> sampinverdhome = sampleinvertRepository.findAll();
		for (Tbsampleinverd tbacti : sampinverdhome) {
			SampleinvertModel sampleinhome = new SampleinvertModel();
			sampleinhome.setSrno(i);
			if (tbacti.getId() != null) {
				sampleinhome.setId(tbacti.getId());
			}
			if (tbacti.getSamplingdate() != null) {
				sampleinhome.setSamplingdate(tbacti.getSamplingdate());
			}
			if (tbacti.getSampledby() != null) {
				sampleinhome.setSampledby(tbacti.getSampledby());
			}

			if (tbacti.getSampleno() != null) {
				sampleinhome.setSampleno(tbacti.getSampleno());
				Object dataforstringorint = tbacti.getSampleno();
//				 if (dataforstringorint instanceof Integer) {
//					 sampleinhome.setTypedataof('I');
//			            System.out.println("Data is an integer");
//			        } else if (dataforstringorint instanceof String) {
//			        	sampleinhome.setTypedataof('S');
//			            System.out.println("Data is a string");
//			        }
				if (tbacti.getSampleno().length() == 5) {
					sampleinhome.setTypedataof("I");
				} else if (tbacti.getSampleno().length() > 5) {
					sampleinhome.setTypedataof("S");
				}
			}
			if (tbacti.getSampleinno() != null) {
				sampleinhome.setSampleinno(tbacti.getSampleinno());
			}

			if (tbacti.getActive() != null) {
				sampleinhome.setActive(tbacti.getActive());
			}

//			if (tbacti.getSvparams() != null) {
//				sampleinhome.setSvparams(tbacti.getSvparams());
//			}
//			if (tbacti.getWflowtrns() != null) {
//				sampleinhome.setWflowtrns(tbacti.getWflowtrns());
//			}
			Integer count = sampleinvertRepository.getallcountforsamp();
			sampleinhome.setTotalItems(count);

			samp.add(sampleinhome);
			i++;
//			

		}
		return samp;
	}

	public SampleinvertModel getsapleivertById(Integer trnid) {
		SampleinvertModel sampleinhome = new SampleinvertModel();
		if (trnid != null) {
			Tbsampleinverd tbact = sampleinvertRepository.findByid(trnid);
			if (tbact != null) {
				if (tbact.getId() != null) {
					sampleinhome.setId(tbact.getId());
				}

				if (tbact.getSamplecollectdate() != null) {
					sampleinhome.setSamplecollectdate(tbact.getSamplecollectdate());
				}
				if (tbact.getSamplecollectedby() != null) {
					sampleinhome.setSamplecollectedby(tbact.getSamplecollectedby());
				}
				if (tbact.getSamplingdate() != null) {
					sampleinhome.setSamplingdate(tbact.getSamplingdate());
				}
				if (tbact.getSampledby() != null) {
					sampleinhome.setSampledby(tbact.getSampledby());
				}
				if (tbact.getSampleno() != null) {
					sampleinhome.setSampleno(tbact.getSampleno());

				}
				if (tbact.getSampleinno() != null) {
					sampleinhome.setSampleinno(tbact.getSampleinno());
				}

			}
		}
		return sampleinhome;
	}

	public SampleinvertModel changesampleinStatus(SampleinvertModel model) {
		SampleinvertModel sampleinhome = new SampleinvertModel();

		Tbsampleinverd tbactitra = null;
		if (model.getId() != null) {
			tbactitra = sampleinvertRepository.findById(model.getId()).get();
			if (model.getActive() != null && model.getActive().equals('Y')) {
				tbactitra.setActive('Y');

			} else {
				tbactitra.setActive('N');

			}

			sampleinvertRepository.save(tbactitra);
			if (model.getActive().equals('N')) {
				sampleinhome.setStatus("Success");
				sampleinhome.setMessage("Record Deleted Successfully!");
			}
		}
		return sampleinhome;
	}

	public List<SampleinvertModel> getSearchForsampleinward(@Valid SampleinvertModel usr) {
		List<SampleinvertModel> searchmaster = new ArrayList<SampleinvertModel>();
		int offsett = (usr.getPageno() - 1) * 10;
		int row_count = 10;
		Integer i = 1;
		Integer count;
		List<Tbsampleinverd> tbactvi = null;
//		List<Tbresource> tbres = employeeMasterRepository.findAll();
//		List<Tbsampleinverd> emList = null;

		if (StringUtils.isBlank(usr.getSearchText())) {
			tbactvi = sampleinvertRepository.findAll();
		} else {
			tbactvi = sampleinvertRepository.findBySampleinnoAndSamplenoContainingIgnoreCase(usr.getSearchText(),
					offsett, row_count);
//			
		}
		if (usr.getSearchText().equals("Deleted") || usr.getSearchText().equals("deleted")) {
			count = sampleinvertRepository.getsearchcountfordelete();

		} else {
			count = sampleinvertRepository.getsearchcountforsamplinverted(usr.getSearchText());
		}

		for (Tbsampleinverd tbacti : tbactvi) {
			SampleinvertModel sampleinhome = new SampleinvertModel();
			sampleinhome.setSrno(i);
			if (tbacti.getId() != null) {
				sampleinhome.setId(tbacti.getId());
			}
			if (tbacti.getSamplingdate() != null) {
				sampleinhome.setSamplingdate(tbacti.getSamplingdate());
			}
			if (tbacti.getSampledby() != null) {
				sampleinhome.setSampledby(tbacti.getSampledby());
			}

			if (tbacti.getSampleno() != null) {
				sampleinhome.setSampleno(tbacti.getSampleno());
			}
			if (tbacti.getSampleinno() != null) {
				sampleinhome.setSampleinno(tbacti.getSampleinno());
			}
			if (tbacti.getSampleno() != null) {
				sampleinhome.setSampleno(tbacti.getSampleno());
				Object dataforstringorint = tbacti.getSampleno();
//				 if (dataforstringorint instanceof Integer) {
//					 sampleinhome.setTypedataof('I');
//			            System.out.println("Data is an integer");
//			        } else if (dataforstringorint instanceof String) {
//			        	sampleinhome.setTypedataof('S');
//			            System.out.println("Data is a string");
//			        }
				if (tbacti.getSampleno().length() == 5) {
					sampleinhome.setTypedataof("I");
				} else if (tbacti.getSampleno().length() > 5) {
					sampleinhome.setTypedataof("S");
				}
			}
			if (tbacti.getActive() != null) {
				sampleinhome.setActive(tbacti.getActive());
			}
//			Integer count = sampleinvertRepository.getallcountforsamp();
//			
//
//			
			sampleinhome.setTotalItems(count);
			searchmaster.add(sampleinhome);
			i++;
		}
		return searchmaster;
	}

	public SampleinvertModel getoverwrightotp(String sampleno) {

		SampleinvertModel sampleinhome = new SampleinvertModel();
		if (sampleno != null) {
			Tbsampleinverd tbact = sampleinvertRepository.findBySampleno(sampleno);
			if (tbact != null) {
				if (tbact.getId() != null) {
					sampleinhome.setId(tbact.getId());
				}
//			organismtype

				int length = 10;
				if (tbact.getSampleno().equals(sampleno)) {
					StringBuilder sb = new StringBuilder(length);
					Random random = new Random();
					String ALPHANUMERIC_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
					for (int i = 0; i < length; i++) {
						int randomIndex = random.nextInt(ALPHANUMERIC_CHARS.length());
						char randomChar = ALPHANUMERIC_CHARS.charAt(randomIndex);
						sb.append(randomChar);
						sampleinhome.setOrganismtype(sb.toString());
					}

				}
			}

		}

		return sampleinhome;

	}

	public SampleinvertModel saveisolatecodereplacetootp(@Valid SampleinvertModel samp) {
		SampleinvertModel sampmodel = new SampleinvertModel();

		Tbsampleinverd sampin1 = null;
		if (samp.getSampleno() != null) {
			sampin1 = sampleinvertRepository.findBySampleno(samp.getSampleno());
			sampin1.setEditdate(new Date());
			sampin1.setEdituserid(samp.getUserID());
			sampin1.setSampleno(samp.getOrganismtype());
		}
		sampleinvertRepository.save(sampin1);

		sampmodel.setMessage("Record Saved Successfully!");
		sampmodel.setStatus("Success");
		return sampmodel;
	}

	public SampleinvertModel getfindisolate(String samplenov) {

		SampleinvertModel sampleinhome = new SampleinvertModel();
		if (samplenov != null) {
			int i = 1;
			List<Tbactivitytrans> tbact1 = isolateRepository.findBySampleno(samplenov);
		
			if (tbact1.size()>0) {
				for (Tbactivitytrans tbact : tbact1) {

					if (tbact.getSampleno().equals(samplenov)) {
						i++;
						sampleinhome.setOrganismtype(tbact.getSampleno() + "-" + i);
					} else if (tbact.getOrganismtype().equals(tbact.getSampleno() + "-" + i)) {
						i++;
						sampleinhome.setOrganismtype(tbact.getSampleno() + "-" + i);
					}
				}
			} else {

				Tbsampleinverd tbsamp = sampleinvertRepository.findBySampleno(samplenov);
				if (tbsamp != null) {

					if (tbsamp.getSampleno().equals(samplenov)) {
						sampleinhome.setOrganismtype(tbsamp.getSampleno() + "-1");

					}
				} else {
					sampleinhome.setStatus("error");
					sampleinhome.setMessage("This Isolate Code Not Found");
					return sampleinhome;
				}


			}


		}

		return sampleinhome;
	}

	public SampleinvertModel findisolaecodeforplantassesment(String isolatecode) {
		SampleinvertModel sampleinhome = new SampleinvertModel();
		if (isolatecode != null) {
			int i = 1;
			List<tblevel2activitytrans> tbl2act1 = level2ActivityRepository.findByIsolatecode(isolatecode);
			
			if (tbl2act1.size()>0) {
				for (tblevel2activitytrans tbl2act : tbl2act1) {

					if (tbl2act.getIsolatecode().equals(isolatecode)) {
						i++;
						sampleinhome.setPncode(tbl2act.getIsolatecode() + "-" + i);
					} else if (tbl2act.getPncode().equals(tbl2act.getIsolatecode() + "-" + i)) {
						i++;
						sampleinhome.setOrganismtype(tbl2act.getIsolatecode() + "-" + i);
						
					}
					
					Tbactivitytrans tbl2 = isolateRepository.findBySamplenov(isolatecode);

					if (tbl2 != null) {
						if(tbl2.getSampleno()!=null) {
							sampleinhome.setSampleno(tbl2.getSampleno());
						}
						
						if(tbl2.getSamplenov()!=null) {
							sampleinhome.setIsolatecode(tbl2.getSamplenov());
						}
					}
					
				}
				
			} 
			else {
				Tbactivitytrans tbl2 = isolateRepository.findBySamplenov(isolatecode);

				if (tbl2 != null) {

					if (tbl2.getSamplenov().equals(isolatecode)) {
						sampleinhome.setPncode(tbl2.getSamplenov() + "-1");

					}
					if(tbl2.getSampleno()!=null) {
						sampleinhome.setSampleno(tbl2.getSampleno());
					}
					
					if(tbl2.getSamplenov()!=null) {
						sampleinhome.setIsolatecode(tbl2.getSamplenov());
					}
				} else {
					sampleinhome.setStatus("error");
					sampleinhome.setMessage("This Isolate Code Not Found");
					
				}


			}


		}
		return sampleinhome;
	}


}
