package com.backend.webappserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.webappserver.data.model.Tbparam;

@Repository
public interface ParamRepository  extends JpaRepository<Tbparam, Integer> {

}
