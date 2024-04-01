//package com.ravish.bms.page.service;
//
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.Query;
//
//import org.springframework.stereotype.Service;
//
//import com.ravish.bms.data.model.Tbalerts;
//import com.ravish.bms.data.model.Tbmeeting;
//
//@Service
//public class NativeSqlService {
//
//	@PersistenceContext
//	  EntityManager em;
//	
//	List<Tbmeeting> gettbMeeting(String sql)
//	{
//		Query query = em.createNativeQuery(sql,Tbmeeting.class);
//		List<Tbmeeting> retrobj = query.getResultList();
//		return null;
////		
//		Tbalerts tbAlert1 = alertsRepository.findByid(Primary id of alert,'O');
////		
////		List<Tbmeeting> lsmeeting = nativeSqlService.gettbMeeting(tbAlert1.getalertsql);
////		// got meeting id from above 
 
////		////		
////		// Tbattednace = select from tb meetingAtt where resourceid=userid and meetingid= meeting
////		//Tbattednace.set yes or no
////		// save above object
		
		
//		List<Tbalerts> tbAlert1 = alertsRepository.findBytoinviteesAndAlertstatus(usr.getToinvitees(),'O');
//	}
//}
package com.backend.webappserver.page.service;





