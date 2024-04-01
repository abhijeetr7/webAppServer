package com.backend.webappserver.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.webappserver.data.model.Tbunitofmeasure;


@Repository
public interface UnitOfMeasureRepository extends JpaRepository<Tbunitofmeasure, Integer>{

	Tbunitofmeasure findByid(Integer id);

	List<Tbunitofmeasure> findByCodeContainingIgnoreCaseOrUnitmeasuresContainingIgnoreCase(String searchText,
			String searchText2);
	



}
