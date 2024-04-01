package com.backend.webappserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.webappserver.data.model.Tbusergroup;

@Repository
public interface UsergroupRepository  extends JpaRepository<Tbusergroup, Integer>{

	Tbusergroup findByUsergroupAndActivstatus(String updategroupname, Character c);

	List<Tbusergroup> findByActivstatusOrderByUsergroup(char c);

}





