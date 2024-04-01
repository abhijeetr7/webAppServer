package com.backend.webappserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.backend.webappserver.data.model.Tbmenu;
import com.backend.webappserver.data.model.Tbresource;

@Repository
public interface MenuRepository  extends JpaRepository<Tbmenu, Integer>{

	List<Tbmenu> findByUseridAndParentidOrderBySequenceAsc(Integer userid, int i);

	List<Tbmenu> findByUseridAndActiveStatus(Integer userId,char c);

	@Query(value = "call getMenuTree(:parentId)", nativeQuery = true)
	List<Tbmenu> findByid(Integer parentId);

	List<Tbmenu> findByUseridAndResourcegroupidAndActiveStatus(int i, Integer userId, char c);

	List<Tbmenu> findByParentidAndActiveStatus(Integer id, char c);

	List<Tbmenu> findByResourcegroupidAndParentidAndActiveStatus(Integer usergroupid,Integer parantid, char c);

	List<Tbmenu> findByUseridAndParentidAndActiveStatus(Integer resourceID, Integer i, char c);

	Tbmenu findByUseridAndGroupmenuidAndActiveStatus(Integer resourceID, Integer id, char c);

	List<Tbmenu> findByUseridAndParentidAndActiveStatusOrderBySequenceAsc(Integer resourceID, int i, char c);

	@Query(nativeQuery = true, value = "select * from tbmenu m where m.menuname = :routingname and m.userid=:userid LIMIT 1")
	Tbmenu findByMenupagenameLimit1(String routingname,Integer userid);

	

//	List<Tbmenu> findByUseridAndParentidAndIsmobileOrderBySequenceAsc(Integer userid, int i, char c);


}
