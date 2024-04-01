package com.backend.webappserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.webappserver.data.model.Tbworkflowrole;

import antlr.collections.List;
@Repository
public interface WorkflowroleRepository  extends JpaRepository<Tbworkflowrole, Integer>{

	Tbworkflowrole findByid(Integer id);

	java.util.List<Tbworkflowrole> findByActiveStatus(char c);

	



	
}