package com.backend.webappserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.webappserver.data.model.Tbactivity;
@Repository
public interface ActivityRepository extends JpaRepository<Tbactivity, Integer>{

	Tbactivity findByid(Integer id);

	List<Tbactivity> findByShortnameContainingIgnoreCaseOrActivitynameContainingIgnoreCase(String searchText,
			String searchText2);

	Tbactivity findBySequence(Integer sequence);


//	List<Tbactivity> findByResourceID(Integer userid);

	Tbactivity findBySequenceAndActivitylevel(Integer sequence, String version);

	List<Tbactivity> findByActivitylevel(String activitylevel);

	@Query(nativeQuery = true, value ="SELECT * FROM tbactivity act where act.adduserid = :userid")
	List<Tbactivity> findByAdduserID(Integer userid);




}
