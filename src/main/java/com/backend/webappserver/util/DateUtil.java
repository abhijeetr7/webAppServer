package com.backend.webappserver.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static String convertDate(Date date,String format) {
		
		String pattern = "MM/dd/yyyy HH:mm:ss";
		
		try {
			DateFormat df = new SimpleDateFormat(format);
			return df.format(date);

		}
		catch(Exception e) {
			return null;
			
		}	
	}

}
