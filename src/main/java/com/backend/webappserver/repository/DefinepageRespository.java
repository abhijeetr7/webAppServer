package com.backend.webappserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.webappserver.data.model.DefinePages;

@Repository
public interface DefinepageRespository  extends JpaRepository<DefinePages, Integer>{

	List<DefinePages> findByIdNotIn(List<Integer> menuid);

	DefinePages findByDspnameAndActiveStatus(String itemname, String c);

	List<DefinePages> findByModulenameAndActiveStatus(String modulename, String c);

	List<DefinePages> findByModuleidAndActiveStatusAndIdNotIn(Integer modulename, String c, List<Integer> menuid);

	List<DefinePages> findByModuleidAndActiveStatus(Integer modulename, String string);

	List<DefinePages> findByModuleidAndActiveStatusOrderByDspname(Integer moduleid, String string);

	List<DefinePages> findByModuleidAndActiveStatusAndIdNotInOrderByDspname(Integer moduleid, String string,
			List<Integer> menuid);

}
