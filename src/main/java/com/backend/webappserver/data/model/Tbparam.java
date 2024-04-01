package com.backend.webappserver.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.boot.configurationprocessor.json.JSONObject;

@Entity
@Table(name = "tbparam")
public class Tbparam {

	
	@Id   
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
   private Integer id;
	
    @Column(name="parameters")
	 private String parameters;
//    JSONObject parameters = new JSONObject();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

//	public JSONObject getParameters() {
//		return parameters;
//	}
//
//	public void setParameters(JSONObject parameters) {
//		this.parameters = parameters;
//	}

	
    
    
}
