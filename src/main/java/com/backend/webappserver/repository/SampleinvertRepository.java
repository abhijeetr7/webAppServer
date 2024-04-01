package com.backend.webappserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.webappserver.data.model.Tbsampleinverd;


@Repository
public interface SampleinvertRepository extends JpaRepository<Tbsampleinverd, Integer>  {

	Tbsampleinverd findByid(Integer id);

	@Query(value = "call findAllforsampl(:offsett,:row_count)", nativeQuery = true)
	List<Tbsampleinverd> findAllforsampl(int offsett, int row_count);

	@Query(value = "call getallcountforsamp()", nativeQuery = true)
	Integer getallcountforsamp();

	@Query(value = "call findBySampleinnoAndSamplenoContainingIgnoreCase(:searchText,:offsett,:row_count)", nativeQuery = true)
	List<Tbsampleinverd> findBySampleinnoAndSamplenoContainingIgnoreCase(String searchText, int offsett, int row_count);

	@Query(value = "call getsearchcountfordelete()", nativeQuery = true)
	Integer getsearchcountfordelete();

	@Query(value = "call getsearchcountforsamplinverted(:searchText)", nativeQuery = true)
	Integer getsearchcountforsamplinverted(String searchText);

	Tbsampleinverd findBySampleno(String samplecode);








//	List<Tbsampleinverd> findBySampleinnoAndSamplenoContainingIgnoreCase(String searchText, int offsett,
//			int row_count);

}


