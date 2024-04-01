package com.backend.webappserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.webappserver.data.model.TbDepartment;


@Repository
public interface DepartmentRepository extends JpaRepository<TbDepartment, Integer>{

	TbDepartment findByid(Integer id);

	List<TbDepartment> findByActiveStatus(char c);

	List<TbDepartment> findByDepartmentcodeContainingIgnoreCaseOrDepartmentnameContainingIgnoreCase(String searchText,
			String searchText2);

	TbDepartment findByid(String tbdepartment);


//	@Query(nativeQuery = true, value = "select * from tbdepartment t where t.id = :departmentid")
//	List<TbDepartment> getdepartmentByunitid(Integer departmentid);
	



//	TbDepartment findAll(Integer id);

}
