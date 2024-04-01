package com.backend.webappserver.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.OrderBy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backend.webappserver.data.model.Tbresource;
import com.backend.webappserver.payload.ResourceModel;

@Repository
public interface ResourceRepository extends JpaRepository<Tbresource, Integer> {

	Tbresource findByLoginNameAndPasswordAndActiveStatus(String userName, String password, char y);
	
	
	Tbresource findByResourceID(Integer id);

	List<Tbresource> findAllByResourceIDIn(List<Integer> resint);

	List<Tbresource> findByActiveStatusAndActiveInactiveAndNameContaining(char c, char d, String message);

//	Tbresource findByLoginNameAndActiveStatus(String loginName, char c);

//	Tbresource findByDealerId(Integer dealerid);

	@Query(value = "call findResourceByBranch(:branch)", nativeQuery = true)
	List<Object[]> findResourceByBranch(String branch);

	@Query(value = "call findByResourcename(:resource)", nativeQuery = true)
	List<Tbresource> findByResourceName(String resource);

	List<Tbresource> findByResourceIDAndActiveStatus(Integer key, char c);

	List<Tbresource> findByActiveStatusOrderByNameAsc(char c);
//
//	Tbresource findByDealerIdAndDealerContactid(Integer dealerid, Integer id);

//	@Query(value = "call findbydeler(:localeid)", nativeQuery = true)
//	List<Object[]> findbydeler(Integer localeid);


//	List<Tbresource> findByUserid(Integer userid);

	// @Query(value = "call findbyuserid(:userid", nativeQuery = true)
//	Tbresource findByUserid(Integer integer);

	// @Query(value="Select reportingmanager from tbresource where userid=
	// ?1",nativeQuery = true)
	List<Tbresource> findByReportingmanager(Integer integer );

//	@Query(value = "call findalldealer()", nativeQuery = true)
//	List<Tbresource> findbydealerflag();

	List<Tbresource> findByActiveStatus(char c);


	@Query(value = "call findByResourceIdForDeleteMessage(:id)", nativeQuery = true)
	Integer findByResourceIdForDeleteMessage(Integer id);

	@Query(value = "call findBycluterIdForDeleteMessage(:id)", nativeQuery = true)
	Integer findBycluterIdForDeleteMessage(Integer id);

	@Query(value = "call findByDepartmentIdForDeleteMessage(:id)", nativeQuery = true)
	Integer findByDepartmentIdForDeleteMessage(Integer id);

	List<Tbresource> findByClusterunittype(Integer clusterunittype);

	@Query(value = "call findByclusterunittype(:clusterunittype,:userid)", nativeQuery = true)
	List<Object[]> findByclusterunittype(String clusterunittype, Integer userid);

	@Query(value = "call findByTbdepartment(:tbdepartment,:userid)", nativeQuery = true)
	List<Object[]> findByTbdepartment(Integer tbdepartment, Integer userid);


	@Query(value = "call findByclusteriunitidAndDeptid(:clusterunittype,:tbdepartment,:userid)", nativeQuery = true)
	List<Object[]> findByclusteriunitidAndDeptid(String clusterunittype, Integer tbdepartment, Integer userid);

	Tbresource findByMobileAndActiveStatus(String password, char c);

	Tbresource findByPasswordAndActiveStatus(String password, char c);

	Tbresource findByLoginNameAndMobileAndActiveStatus(String userName, String password, char c);
	
//	@Query(nativeQuery = true, value = "select count(*) as count from tbtrmtask t where t.resourceid = :resourceid AND t.activeStatus ='Y' AND t.kpisource = 'S'")
	Tbresource findByresourceID(Integer resourceID);

//	Tbresource findByLoginNameAndActiveStatus(String userName, char c);


	@Query(nativeQuery = true, value = "select t.resourceId,COUNT(t2.resourceid) from tbresource t left join tbmeetingattendance t2 on t2.resourceid =t.resourceID and t2.meetingdate=:date "
			+ " and t2.meetingstatus='S' and t2.1000_1030='Y' where t.resourceId in (:userIds) group by t.resourceId")
	List<Object[]> findTimeAvailabilitySlot1(@Param("date") Date date, @Param("userIds") List<Integer> userIds);

	@Query(nativeQuery = true, value = "select t.resourceId,COUNT(t2.resourceid) from tbresource t left join tbmeetingattendance t2 on t2.resourceid =t.resourceID and t2.meetingdate=:date "
			+ " and t2.meetingstatus='S' and t2.1030_1100='Y' where t.resourceId in (:userIds) group by t.resourceId")
	List<Object[]> findTimeAvailabilitySlot2(@Param("date") Date date, @Param("userIds") List<Integer> userIds);

	@Query(nativeQuery = true, value = "select t.resourceId,COUNT(t2.resourceid) from tbresource t left join tbmeetingattendance t2 on t2.resourceid =t.resourceID and t2.meetingdate=:date "
			+ " and t2.meetingstatus='S' and t2.1100_1130='Y' where t.resourceId in (:userIds) group by t.resourceId")
	List<Object[]> findTimeAvailabilitySlot3(@Param("date") Date date, @Param("userIds") List<Integer> userIds);

	@Query(nativeQuery = true, value = "select t.resourceId,COUNT(t2.resourceid) from tbresource t left join tbmeetingattendance t2 on t2.resourceid =t.resourceID and t2.meetingdate=:date "
			+ " and t2.meetingstatus='S' and t2.1130_1200='Y' where t.resourceId in (:userIds) group by t.resourceId")
	List<Object[]> findTimeAvailabilitySlot4(@Param("date") Date date, @Param("userIds") List<Integer> userIds);

	@Query(nativeQuery = true, value = "select t.resourceId,COUNT(t2.resourceid) from tbresource t left join tbmeetingattendance t2 on t2.resourceid =t.resourceID and t2.meetingdate=:date "
			+ " and t2.meetingstatus='S' and t2.1200_1230='Y' where t.resourceId in (:userIds) group by t.resourceId")
	List<Object[]> findTimeAvailabilitySlot5(@Param("date") Date date, @Param("userIds") List<Integer> userIds);


	@Query(nativeQuery = true, value = "select t.resourceId,COUNT(t2.resourceid) from tbresource t left join tbmeetingattendance t2 on t2.resourceid =t.resourceID and t2.meetingdate=:date "
			+ " and t2.meetingstatus='S' and t2.1230_1300='Y' where t.resourceId in (:userIds) group by t.resourceId")
	List<Object[]> findTimeAvailabilitySlot6(@Param("date") Date date, @Param("userIds") List<Integer> userIds);

	@Query(nativeQuery = true, value = "select t.resourceId,COUNT(t2.resourceid) from tbresource t left join tbmeetingattendance t2 on t2.resourceid =t.resourceID and t2.meetingdate=:date "
			+ " and t2.meetingstatus='S' and t2.1300_1330='Y' where t.resourceId in (:userIds) group by t.resourceId")
	List<Object[]> findTimeAvailabilitySlot7(@Param("date") Date date, @Param("userIds") List<Integer> userIds);

	@Query(nativeQuery = true, value = "select t.resourceId,COUNT(t2.resourceid) from tbresource t left join tbmeetingattendance t2 on t2.resourceid =t.resourceID and t2.meetingdate=:date "
			+ " and t2.meetingstatus='S' and t2.1330_1400='Y' where t.resourceId in (:userIds) group by t.resourceId")
	List<Object[]> findTimeAvailabilitySlot8(@Param("date") Date date, @Param("userIds") List<Integer> userIds);

	@Query(nativeQuery = true, value = "select t.resourceId,COUNT(t2.resourceid) from tbresource t left join tbmeetingattendance t2 on t2.resourceid =t.resourceID and t2.meetingdate=:date "
			+ " and t2.meetingstatus='S' and t2.1400_1430='Y' where t.resourceId in (:userIds) group by t.resourceId")
	List<Object[]> findTimeAvailabilitySlot9(@Param("date") Date date, @Param("userIds") List<Integer> userIds);

	@Query(nativeQuery = true, value = "select t.resourceId,COUNT(t2.resourceid) from tbresource t left join tbmeetingattendance t2 on t2.resourceid =t.resourceID and t2.meetingdate=:date "
			+ " and t2.meetingstatus='S' and t2.1430_1500='Y' where t.resourceId in (:userIds) group by t.resourceId")
	List<Object[]> findTimeAvailabilitySlot10(@Param("date") Date date, @Param("userIds") List<Integer> userIds);

	@Query(nativeQuery = true, value = "select t.resourceId,COUNT(t2.resourceid) from tbresource t left join tbmeetingattendance t2 on t2.resourceid =t.resourceID and t2.meetingdate=:date "
			+ " and t2.meetingstatus='S' and t2.1500_1530='Y' where t.resourceId in (:userIds) group by t.resourceId")
	List<Object[]> findTimeAvailabilitySlot11(@Param("date") Date date, @Param("userIds") List<Integer> userIds);

	@Query(nativeQuery = true, value = "select t.resourceId,COUNT(t2.resourceid) from tbresource t left join tbmeetingattendance t2 on t2.resourceid =t.resourceID and t2.meetingdate=:date "
			+ " and t2.meetingstatus='S' and t2.1530_1600='Y' where t.resourceId in (:userIds) group by t.resourceId")
	List<Object[]> findTimeAvailabilitySlot12(@Param("date") Date date, @Param("userIds") List<Integer> userIds);

	@Query(nativeQuery = true, value = "select t.resourceId,COUNT(t2.resourceid) from tbresource t left join tbmeetingattendance t2 on t2.resourceid =t.resourceID and t2.meetingdate=:date "
			+ " and t2.meetingstatus='S' and t2.1600_1630='Y' where t.resourceId in (:userIds) group by t.resourceId")
	List<Object[]> findTimeAvailabilitySlot13(@Param("date") Date date, @Param("userIds") List<Integer> userIds);

	@Query(nativeQuery = true, value = "select t.resourceId,COUNT(t2.resourceid) from tbresource t left join tbmeetingattendance t2 on t2.resourceid =t.resourceID and t2.meetingdate=:date "
			+ " and t2.meetingstatus='S' and t2.1630_1700='Y' where t.resourceId in (:userIds) group by t.resourceId")
	List<Object[]> findTimeAvailabilitySlot14(@Param("date") Date date, @Param("userIds") List<Integer> userIds);

	@Query(nativeQuery = true, value = "select t.resourceId,COUNT(t2.resourceid) from tbresource t left join tbmeetingattendance t2 on t2.resourceid =t.resourceID and t2.meetingdate=:date "
			+ " and t2.meetingstatus='S' and t2.1700_1730='Y' where t.resourceId in (:userIds) group by t.resourceId")
	List<Object[]> findTimeAvailabilitySlot15(@Param("date") Date date, @Param("userIds") List<Integer> userIds);

	@Query(nativeQuery = true, value = "select t.resourceId,COUNT(t2.resourceid) from tbresource t left join tbmeetingattendance t2 on t2.resourceid =t.resourceID and t2.meetingdate=:date "
			+ " and t2.meetingstatus='S' and t2.1730_1800='Y' where t.resourceId in (:userIds) group by t.resourceId")
	List<Object[]> findTimeAvailabilitySlot16(@Param("date") Date date, @Param("userIds") List<Integer> userIds);

//	Tbresource findByLoginNameAndMobile1AndActiveStatus(String userName, String password, char c);

	


	Tbresource findByLoginNameAndMobile1AndActiveStatus(String userName, String password, char c);


	List<Tbresource> findByReportingmanagerAndActiveStatus(Integer adduserid, char c);

//	@Query(value = "call getallcountask(:userID)", nativeQuery = true)
//	Integer getallcountask(Integer userID);

	@Query(nativeQuery = true, value = "select  *  from tbresource t where t.clusterunittype = :unitid group by t.tbdepartment")
	List<Tbresource> findByunitid(Integer unitid);

	@Query(nativeQuery = true, value = "select  *  from tbresource t where t.tbdepartment = :departmentid group by t.tbband ")
	List<Tbresource> findBydepartmentid(Integer departmentid);

	@Query(value = "call getResourceByClusAbdUnitAndDeptAndband(:unitid,:departmentid,:bandid)", nativeQuery = true)
	List<Tbresource> getResourceByClusAbdUnitAndDeptAndband( Integer unitid, Integer departmentid, Integer bandid);

	@Query(nativeQuery = true, value = "select  *  from tbresource t where t.clusterunittype= :clusterid and t.tbdepartment = :departmentid and t.tbband=:bandid " )
	List<Tbresource> findbyclusterallresource(Integer clusterid, Integer departmentid, Integer bandid);


	

	@Query(nativeQuery = true, value = "select  *  from tbresource t where t.usergroupid = :usergroupid ")
	List<Tbresource> findByusergroupid(Integer usergroupid);

	@Query(value = "call getallcountask(:resourceid)", nativeQuery = true)
	Integer getallcountask(Integer resourceid);


	Tbresource findByLoginNameAndActiveStatusAndSelfactive(String userName, char c, char d);

	

	@Query(nativeQuery = true, value = "select  *  from tbresource t where t.tbdepartment = :departmentid and t.tbband =:bandid ")
	List<Tbresource> findByTbbandAndTbdepartment(Integer departmentid, Integer bandid);

	@Query(nativeQuery = true, value = "select  *  from tbresource t where  t.tbband =:bandid ")
	List<Tbresource> findByTbband(Integer bandid);


//	@Query(value = "call showResourceData(:resourceides)", nativeQuery = true)
//	List<Object[]> showResourceData(Integer resourceides);

//	@Query(value = "call findresource(:clusterid,:unitid,:departmentid,:bandid,:activetype)", nativeQuery = true)
//	List<Integer> findresource(Integer clusterid, Integer unitid, Integer departmentid, Integer bandid,
//			String activetype);


	@Query(value = "call findresourceclusterwise(:clusterid,:departmentid,:bandid,:activetype)", nativeQuery = true)
	List<Object[]> findresourceclusterwise(Integer clusterid,Integer departmentid, Integer bandid,
			Character activetype);

	@Query(value = "call findresourceunitwise(:unitid,:departmentid,:bandid,:activetype)", nativeQuery = true)
	List<Object[]> findresourceunitwise(Integer unitid, Integer departmentid, Integer bandid,Character activetype);

	@Query(value = "call findByResourceAndReportiees(:userid,:activetype)", nativeQuery = true)
	List<Object[]> findByResourceAndReportiees(Integer userid,Character activetype);

	
	@Query(nativeQuery = true, value = "select  *  from tbresource t where t.reportingmanager = :userid or t.resourceID=:userid")
	List<Tbresource> findByresourceIDforReporties(Integer userid);

	@Query(value = "call showResourceData(:resid)", nativeQuery = true)
	List<Object[]> showResourceData(String resid);
	
	@Query(value = "call allbandresource(:unitid,:resid1,:activetype)", nativeQuery = true)
	List<Object[]> allbandresource(Integer unitid, String resid1,Character activetype);

//	@Query(value = "call getResourceInactiveAndActive(:resid)", nativeQuery = true)
//	List<Tbresource> getResourceInactiveAndActive(Integer clusterid, Integer unitid, Integer departmentid,
//			Integer bandid);


	@Query(nativeQuery = true, value = "select * FROM tbresource t where t.reportingmanager  = :resourceID or t.resourceID = :resourceID")
	List<Tbresource> findByResourceIDfor(Integer resourceID);

	
	@Query(value = "call allunitesource(:resid1,:activetype)", nativeQuery = true)
	List<Object[]> allunitesource( String resid1,Character activetype);

	@Query(value = "call allunitesourcewithsinglband(:resid1,:activetype ,:bandid,:departmentid)", nativeQuery = true)
	List<Object[]> allunitesourcewithsinglband(String resid1, Character activetype, Integer bandid,
			Integer departmentid);

	@Query(value = "call allbandresourcewithband(:unitid,:resid1,:activetype,:departmentid)", nativeQuery = true)
	List<Object[]> allbandresourcewithband(Integer unitid, String resid1, Character activetype, Integer departmentid);

	@Query(value = "call allclustbandresourcewithband(:clusterid,:resid1,:activetype,:departmentid)", nativeQuery = true)
	List<Object[]> allclustbandresourcewithband(Integer clusterid, String resid1, Character activetype,
			Integer departmentid);

	@Query(value = "call alluniteAllResForHead(:resid1,:activetype)", nativeQuery = true)
	List<Object[]> alluniteAllResForHead(String resid1, Character activetype);

	@Query(value = "call getAllClusterId(:clusterid,:activetype)", nativeQuery = true)
	List<Object[]> getAllClusterId(Integer clusterid, Character activetype);

	@Query(value = "call getsingleUnitidResource(:unitid,:activetype)", nativeQuery = true)
	List<Object[]> getsingleUnitidResource(Integer unitid, Character activetype);


	@Query(value = "call getByUnitID(:unitid,:activetype)", nativeQuery = true)
	List<Object[]> getByUnitID(Integer unitid, Character activetype);


	


	








}
