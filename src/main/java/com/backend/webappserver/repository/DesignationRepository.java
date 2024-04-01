package com.backend.webappserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.webappserver.data.model.Tbdesignation;
@Repository
public interface DesignationRepository extends JpaRepository<Tbdesignation, Integer>{

	Tbdesignation findByid(Integer id);

	List<Tbdesignation> findByDesignationcodeContainingIgnoreCaseOrDesignationnameContainingIgnoreCase(
			String searchText, String searchText2);

//	List<Tbdesignation> findByDesignationcodeContainingIgnoreCaseOrDesignationnameContainingIgnoreCase(
//			String searchText, String searchText2);

	
}
