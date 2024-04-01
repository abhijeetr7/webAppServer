package com.backend.webappserver;

import java.util.Date;

import com.backend.webappserver.util.DateUtil;

public class Test {
	
	public static void main(String[] args) {
		System.out.println(DateUtil.convertDate(new Date(),"dd/MM/yyyy"));
	}

}
