package com.rohan.jdbc;

import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JdbcConnection 
{
	Connection con = null;
	public Connection dataBase() throws Exception
	{
		/*
		 * Properties prop = new Properties(); prop.setProperty("Path",
		 * "oracle.jdbc.driver.OracleDriver"); prop.setProperty("Url",
		 * "jdbc:oracle:thin:@localhost:1521:orcl"); prop.setProperty("User", "Rohan7");
		 * prop.setProperty("Pass", "Rohan001"); prop.store(new
		 * FileWriter("student.properties"), "Connection Information");
		 * 
		 * prop.load(new FileReader("student.properties")); String path =
		 * prop.getProperty("Path"); String url = prop.getProperty("Url"); String user =
		 * prop.getProperty("User"); String pass = prop.getProperty("Pass");
		 */
		
		try
		{
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","Rohan7","Rohan001");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}			
		return con;
		
		
	}
	
}
