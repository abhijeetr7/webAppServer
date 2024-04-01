package com.backend.webappserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.webappserver.data.model.TbcustomerModule;

//import com.ravish.bms.data.model.TbcustomerSubModule;

@Repository
public interface CustomerSubModuleRepository extends JpaRepository<TbcustomerModule, Integer>{

}
