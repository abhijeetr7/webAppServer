package com.backend.webappserver;

import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.sql.*;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class csvreader {
	
	static Integer i=1;

	 public static void main(String[] args) throws IOException, CsvException {

	        String fileName = "/home/aryabhatta/accountwisemcdtlcsv.csv";
			/*
			 * try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
			 * List<String[]> r = reader.readAll(); Set<String> s = new HashSet<String>();
			 * r.forEach(x -> System.out.println(Arrays.toString(x))); //
			 * System.out.println("Set Size "+s.size()); //s.forEach(x ->
			 * updateSql(x.toString())); }
			 */

	        try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
	            String[] lineInArray;
	            Set<String> s = new HashSet<String>();
	            while ((lineInArray = reader.readNext()) != null) {
	            	s.add(lineInArray[0]);
	            	//s.forEach(x -> updateSql(x) );
	            	//updateSql(lineInArray[0]);
	                //System.out.println(lineInArray[0]  );
	            }
	            System.out.println("Set Size "+s.size());
	            s.forEach(x -> updateSql(x) );
	        }
	    }
	 
	 private static void updateSql(String productName)
	 {
		 try
		    {
			 i=i+1;
			 System.out.println("Product No : "+i);
			 System.out.println("Product Name : "+productName);
		      // create a java mysql database connection com.mysql.cj.jdbc.Driver
		      String myDriver = "com.mysql.cj.jdbc.Driver";
		      String myUrl = "jdbc:mysql://localhost/dbeds";
		      Class.forName(myDriver);
		      Connection conn = DriverManager.getConnection(myUrl, "root", "root");
		    
		      // create the java mysql update preparedstatement
		      //String query = "update users set num_points = ? where first_name = ?";
		      String query="DELETE FROM tbaccwisemcdetls WHERE tbaccwisemcdetls.productname= ?";
		      PreparedStatement preparedStmt = conn.prepareStatement(query);
		       
		      preparedStmt.setString(1, productName);

		      // execute the java preparedstatement
		      preparedStmt.executeUpdate();
		      
		      conn.close();
		    }
		    catch (Exception e)
		    {
		      System.err.println("Got an exception! ");
		      System.err.println(e.getMessage());
		    }
	 }
}
