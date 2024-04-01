package com.backend.webappserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.webappserver.data.model.TbemployeeMaster;
import com.backend.webappserver.data.model.Tbresource;




@Repository
public interface EmployeeMasterRepository extends JpaRepository<Tbresource, Integer>{

	Tbresource findByresourceID(Integer integer);


	


//	List<Tbresource> findByNameContainingIgnoreCaseOrEmployeecodeContainingIgnoreCaseOrFirstnameContainingIgnoreCaseOrMiddlenameContainingIgnoreCaseOrLastnameContainingIgnoreCase(
//			String searchText, String searchText2,String searchText3, String searchText4, String searchText5);


	List<Tbresource> findByClusterunittype(String string);




//	@Query(value = "call findreportingmanager()", nativeQuery = true)
//	List<Tbresource> findreportingmanager(char c);

	
	@Query(value = "call findByclusterunittypeandisreportingflag(:c ,:id ,:string)", nativeQuery = true)
	List<Tbresource> findByclusterunittypeandisreportingflag(char c ,Integer id ,String string );


//
//	List<Tbresource> findByReportingmanager(char c);





	List<Tbresource> findByIsreporting(char c);




//	@Query(nativeQuery = true, value ="select  * from tbresource t where t.clusterunittype = :id1 and t.groupClusterUnit = 'U' and t.isreporting= 'Y' and t. activeInactive = 'Y'")
//	List<Tbresource> findBygetClusterunit(Integer id1);

//	@Query(nativeQuery = true, value ="select  * from tbresource t where t.clusterunittype = :id1 and t.groupClusterUnit = 'C' and t.isreporting= 'Y' and t. activeInactive = 'Y'")
//	List<Tbresource> findbycluster(Integer id1);




	@Query(value = "call findBygetClusterunitAndResourceid(:id1 ,:resourceID)", nativeQuery = true)
	List<Tbresource> findBygetClusterunitAndResourceid(Integer id1, Integer resourceID);




	@Query(value = "call findbyclusterAndResourceid(:id1 ,:resourceID)", nativeQuery = true)
	List<Tbresource> findbyclusterAndResourceid(Integer id1, Integer resourceID);




	@Query(value = "call findAllemp(:offsett,:row_count)", nativeQuery = true)
	List<Tbresource> findAllemp(int offsett, int row_count);

	@Query(value = "call getallcountemp()", nativeQuery = true)
	Integer getallcountemp();




	@Query(value = "call getsearchcountforemployeemaser(:searchText)", nativeQuery = true)
	Integer getsearchcountforemployeemaser(String searchText);




	@Query(value = "call findByNameContainingIgnoreCase(:searchText,:offsett,:row_count)", nativeQuery = true)
	List<Tbresource> findByNameContainingIgnoreCase(String searchText, int offsett, int row_count);




	@Query(nativeQuery = true, value ="select * from tbresource t where t.tbband = :roleid")
	List<Tbresource> findByTbbandid(Integer roleid);











//	@Query(nativeQuery = true, value ="select reportingmanager,Name from tbresource WHERE isreporting ='Y' ")
//	List<Tbresource> findreportingmanager(char c);



//	@Query(nativeQuery = true, value ="select  * from tbtaskentry t where t.projectid = :projectid group by t.newid ")
//	List<Tbtaskentries> findByProjectidAndgroup(Integer projectid);









//	Tbresource findByid(Integer trnid);

	

}
