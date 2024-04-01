package com.backend.webappserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.backend.webappserver.data.model.Tbcommonmastertype;

public interface CommonMasterTypeRepository extends JpaRepository<Tbcommonmastertype, Integer> {

	Tbcommonmastertype findAllById(Integer typeid);

	Tbcommonmastertype findByid(Integer id);

	Tbcommonmastertype findByType(String type);
	@Query(value = "call findAllcommaster(:offsett,:row_count)", nativeQuery = true)
	List<Tbcommonmastertype> findAllcommaster(int offsett, int row_count);

	
	@Query(value = "call getallcountforcommenmastarhome()", nativeQuery = true)
	Integer getallcountforcommenmastarhome();

	List<Tbcommonmastertype> findByMicrobeType(char c);




}
