package com.backend.webappserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.webappserver.data.model.Tbbmsconfiguration;

@Repository

public interface BmsConfigurationRepository extends JpaRepository<Tbbmsconfiguration, Integer> {

	Tbbmsconfiguration findByid(Integer i);


	List<Tbbmsconfiguration> findByActiveStatus(char c);





}
