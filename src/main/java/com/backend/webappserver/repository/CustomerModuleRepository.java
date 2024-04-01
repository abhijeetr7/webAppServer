package com.backend.webappserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.webappserver.data.model.TbcustomerModule;
@Repository
public interface CustomerModuleRepository extends JpaRepository<TbcustomerModule, Integer>{

	List<TbcustomerModule> findByActiveStatusOrderByModulename(char c);

}
