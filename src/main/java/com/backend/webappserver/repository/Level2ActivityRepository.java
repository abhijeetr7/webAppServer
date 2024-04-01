package com.backend.webappserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backend.webappserver.data.model.tblevel2activitytrans;

public interface Level2ActivityRepository extends JpaRepository<tblevel2activitytrans, Integer>{

	@Query(value = "call findAlll2acti(:offsett,:row_count)", nativeQuery = true)
	List<tblevel2activitytrans> findAlll2acti(int offsett, int row_count);

	@Query(value = "call getallcountforl2activitytranshome()", nativeQuery = true)
	Integer getallcountforl2activitytranshome();

	List<tblevel2activitytrans> findByIsolatecode(String isolatecode);

	tblevel2activitytrans findByisolatecode(String isolatecode);

	tblevel2activitytrans findByPncode(String pncode);

	
	@Query(value = "call findByisolatecodeContainingIgnoreCase(:searchText,:offsett,:row_count)", nativeQuery = true)
	List<tblevel2activitytrans> findByisolatecodeContainingIgnoreCase(String searchText, int offsett, int row_count);

	@Query(value = "call getallcountforl2actitranssearch(:searchText)", nativeQuery = true)
	Integer getallcountforl2actitranssearch(String searchText);

	
	
//	@Query(value = "call findAllacti(:offsett,:row_count)", nativeQuery = true)
//	List<Tbactivitytrans> findAllacti(int offsett, int row_count);

//	@Query(value = "call getallcountforactivitytranshome()", nativeQuery = true)
//	Integer getallcountforactivitytranshome();
 
}
