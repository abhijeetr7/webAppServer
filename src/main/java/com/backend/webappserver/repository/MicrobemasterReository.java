package com.backend.webappserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backend.webappserver.data.model.TbMicrobeTypeMaster;

public interface MicrobemasterReository extends JpaRepository<TbMicrobeTypeMaster, Integer>{



	TbMicrobeTypeMaster findByid(Integer id);

	
	@Query(value = "call findAllformicrbetype(:offsett,:row_count)", nativeQuery = true)
	List<TbMicrobeTypeMaster> findAllformicrbetype(int offsett, int row_count);

	
	@Query(value = "call getallcountformicrobemasterhome()", nativeQuery = true)
	Integer getallcountformicrobemasterhome();

	@Query(value = "call findByGenusAndGenusContainingIgnoreCase(:searchText,:offsett,:row_count)", nativeQuery = true)
	List<TbMicrobeTypeMaster> findByGenusAndGenusContainingIgnoreCase(String searchText, int offsett, int row_count);

	@Query(value = "call getsearchcountfordeletemicrobe()", nativeQuery = true)
	Integer getsearchcountfordeletemicrobe();

	@Query(value = "call getsearchcountformicrobesearch(:searchText)", nativeQuery = true)
	Integer getsearchcountformicrobesearch(String searchText);


	List<TbMicrobeTypeMaster> findByBactid(Integer bactid);


	List<TbMicrobeTypeMaster> findByBactidAndGenus(Integer genusid, String genus);

//	@Query(value = "call getallcountformicrobemaster()", nativeQuery = true)
//	Integer getallcountformicrobemaster();

}
