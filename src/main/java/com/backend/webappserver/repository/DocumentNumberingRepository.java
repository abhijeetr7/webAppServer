package com.backend.webappserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.backend.webappserver.data.model.Tbdocumentnumbering;

@Repository
public interface DocumentNumberingRepository extends JpaRepository<Tbdocumentnumbering, Integer>{

	Tbdocumentnumbering findByDocument(String string);

	Tbdocumentnumbering findAllById(int i);





}
