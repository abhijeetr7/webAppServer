package com.backend.webappserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.webappserver.data.model.Tbactivity;
import com.backend.webappserver.data.model.Tbuseractivityactivityacess;


@Repository
public interface UserActivityAccessRepository  extends JpaRepository<Tbuseractivityactivityacess, Integer>{

	


//	Tbuseractivityactivityacess findByActivityid(Integer activityid);

	
	@Query(nativeQuery = true, value ="select * from tbuseractivityactivityacess t where t.resourceId = :resourceId")
	List<Tbuseractivityactivityacess> findByresourceID(Integer resourceId);

	List<Tbactivity> findByResourceID(Integer userid);



//	List<Tbuseractivityactivityacess> findByResourceID(Integer userid);


//	@Query(nativeQuery = true, value ="select * from tbuseractivityactivityacess t where t.typeid = :id")
//	Tbuseractivityactivityacess findByTypeId(Integer id);




}
