package com.backend.webappserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backend.webappserver.data.model.TbMicrobeTypeMaster;
import com.backend.webappserver.data.model.Tbcommonmaster;



public interface CommonMasterRepository extends JpaRepository<Tbcommonmaster, Integer> {

	Tbcommonmaster findByid(Integer id);

//	List<Tbcommonmaster> findAll();
//	@Query(value = "call findAllforpagignation(:offsett,:row_count)", nativeQuery = true)
//	List<Tbcommonmaster> findAllforpagignation(int offsett, int row_count);

	@Query(value = "call getallcountcommonmaster(:typeid)", nativeQuery = true)
	Integer getallcountcommonmaster(Integer typeid);
//	Integer getallcountcommonmaster();

	List<Tbcommonmaster> findAllById(Integer userID);

	List<Tbcommonmaster> findByTypeid(Integer typeid);

	@Query(value = "call findAllforpagignation(:typeid,:offsett,:row_count)", nativeQuery = true)
	List<Tbcommonmaster> findAllforpagignation(Object typeid, int offsett, int row_count);

	
	@Query(nativeQuery = true, value ="select  * from tbcommonmaster t where t.typeid = :id ")
	List<Tbcommonmaster> findByTypeid1(Integer id);

//	List<Tbcommonmaster> findAllByValue(String value);






	

	


//	Tbcommonmaster findByTypeID(Integer trnid);

	
//	@Query(nativeQuery = true, value ="SELECT * from tbcommonmaster t where t.adduserid = :adduserid AND activeStatus ='Y' GROUP BY t.type")
//	List<Tbcommonmaster> findAllById(Integer adduserid);

}
