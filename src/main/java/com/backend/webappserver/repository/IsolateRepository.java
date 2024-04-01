package com.backend.webappserver.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.webappserver.data.model.Tbactivitytrans;
import com.backend.webappserver.payload.IsolateModel;

@Repository
public interface IsolateRepository extends JpaRepository<Tbactivitytrans, Integer>{

	List<Tbactivitytrans> findBySampleno(String samplenov);

	
	@Query(value = "call findAllacti(:offsett,:row_count)", nativeQuery = true)
	List<Tbactivitytrans> findAllacti(int offsett, int row_count);

	@Query(value = "call getallcountforactivitytranshome()", nativeQuery = true)
	Integer getallcountforactivitytranshome();

	@Query(value = "call findBySamplenoAndSamplenovContainingIgnoreCase(:searchText,:offsett,:row_count)", nativeQuery = true)
	List<Tbactivitytrans> findBySamplenoAndSamplenovContainingIgnoreCase(String searchText, int offsett, int row_count);

	@Query(value = "call getallcountforactitranssearch(:searchText)", nativeQuery = true)
	Integer getallcountforactitranssearch(String searchText);


	Tbactivitytrans findByid(Integer trnid);


	Tbactivitytrans findBySamplenov(String samplenov);





}
