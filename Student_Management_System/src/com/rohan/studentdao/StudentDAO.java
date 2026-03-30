package com.rohan.studentdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Scanner;

import com.rohan.Student;
import com.rohan.jdbc.JdbcConnection;

/*
  CREATE TABLE students (
    student_id INT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(15),
    course VARCHAR(50),
    marks NUMBER(3),
    grade CHAR(1)
   );


 */
public class StudentDAO 
{
	JdbcConnection jc = new JdbcConnection();
	Scanner sc = new Scanner(System.in);
	
	
	public void addStudent(Student s) throws Exception 
	{
		try
		{
			Connection con = jc.dataBase();
			int rowCount = 0;
			
			int id = s.getStuId();
			String fName = s.getfName();
			String lName = s.getlName();
			String email = s.getEmail();
			long phone = s.getPhone();
			String course = s.getCourse();
			int marks = s.getMarks();
			char grade = s.getGrade();
			
			String query = """
							INSERT INTO students 
							(student_id,first_name,last_name,
							email,phone,course,marks,grade) VALUES 
							(?,?,?,?,?,?,?,?)
					       """;
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			pstmt.setString(2, fName);
			pstmt.setString(3, lName);
			pstmt.setString(4, email);
			pstmt.setLong(5, phone);
			pstmt.setString(6, course);
			pstmt.setInt(7, marks);
			pstmt.setString(8, String.valueOf(grade));
			
			 rowCount += pstmt.executeUpdate();
			 System.out.println(rowCount +" row Inserted.");
			 if(con != null)
			 {
				 try 
				 {
					 con.close();
				 }
				 catch (Exception e) 
				 {
					e.printStackTrace();
				}
			 }
			
		}
		catch (Exception e) 
		{
			System.out.println("Student ID already Exist.");
		}
		
		
	}
	
	public void updateStudent(Student s)

	{
		try
		{
			Connection con = jc.dataBase();
			PreparedStatement pstmt = null;
			int sid =s.getStuId();
			String query = "SELECT * FROM students WHERE student_id = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, sid);
			ResultSet rs = pstmt.executeQuery();
			if (!rs.next())
			{
				System.out.println("Student Not Found.");
			}
			else 
			{
				int rowCount=0;
				
				System.out.println("================================================");
				System.out.println("----------Select The Following Action-----------");
				System.out.println("1. Update First Name");
				System.out.println("2. Update Last Name");
				System.out.println("3. Update Email");
				System.out.println("4. Update Phone No.");
				System.out.println("5. Update Course");
				System.out.println("6. Update Marks");
				System.out.println("7. Update Grade");
				System.out.println("================================================");
				int option = sc.nextInt();
				switch(option)
				{
				case 1: System.out.println("Enter First Name:");
						String updateFName = sc.next();
						pstmt = con.prepareStatement("UPDATE students SET first_name = ? WHERE student_id = ?");
						pstmt.setString(1, updateFName);
						pstmt.setInt(2, sid);
						break;
						
				case 2:System.out.println("Enter Last Name:");
						String updateLName = sc.next();
						pstmt = con.prepareStatement("UPDATE students SET last_name = ? WHERE student_id = ?");
						pstmt.setString(1, updateLName);
						pstmt.setInt(2, sid);
						break;
						
				case 3:System.out.println("Enter Email Name:");
						String email = sc.nextLine();
						pstmt = con.prepareStatement("UPDATE students SET email = ? WHERE student_id = ?");
						pstmt.setString(1, email);
						pstmt.setInt(2, sid);
						break;
						
				case 4:System.out.println("Enter Phone No. :");
						long phone = sc.nextInt();
						pstmt = con.prepareStatement("UPDATE students SET phone = ? WHERE student_id = ?");
						pstmt.setLong(1, phone);
						pstmt.setInt(2, sid);
						break;
						
				case 5:System.out.println("Enter Course Name:");
						String course = sc.next();
						pstmt = con.prepareStatement("UPDATE students SET course = ? WHERE student_id = ?");
						pstmt.setString(1, course);
						pstmt.setInt(2, sid);
						break;
						
				case 6:System.out.println("Enter Marks:");
						int marks = sc.nextInt();
						pstmt = con.prepareStatement("UPDATE students SET marks = ? WHERE student_id = ?");
						pstmt.setInt(1, marks);
						pstmt.setInt(2, sid);
						break;
						
				case 7:System.out.println("Enter Grade:");
						char grade = sc.next().charAt(0);
						pstmt = con.prepareStatement("UPDATE students SET grade = ? WHERE student_id = ?");
						pstmt.setString(1, String.valueOf(grade));
						pstmt.setInt(2, sid);
						break;
						
				default: System.out.println("Wrong Input.");
						 return;
				}
				rowCount += pstmt.executeUpdate();
				if(rowCount>0)
				{
					System.out.println(rowCount+" row Updated.");
				}
				else
				{
					System.out.println("Student Not Found.");
				}
				if (con!=null)
				{
					try {
						con.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (pstmt!=null)
				{
					try {
						pstmt.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if (rs!=null)
				{
					try {
						rs.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
					
				
	}
			}
				
			
			
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	public void deleteStudent(Student s) throws Exception
	{
		try {
			int rowCount = 0;
			Connection con = jc.dataBase();
			int id = s.getStuId();
			String query = "DELETE FROM students WHERE student_id = ?";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setInt(1, id);
			rowCount += pstmt.executeUpdate();
			if(rowCount >0)
			{
				System.out.println(rowCount+" row Deleted.");
			}
			else
			{
				System.out.println("Student Not Found.");
			}
			if(pstmt != null)
			{
				try
				{
					pstmt.close();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(con != null)
			{
				try
				{
					con.close();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}			
		
		
	}
	public void showTable() throws Exception
	{
		try(Connection con = new JdbcConnection().dataBase();
				Statement stmt = con.createStatement();)
		{
			
			String query = "SELECT * FROM students";
			ResultSet rs = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			int rowCount = 0;
			for(int i=1; i<=rsmd.getColumnCount();i++)
			{
				System.out.print(rsmd.getColumnName(i)+"\t");
			}
			System.out.println();
			 while (rs.next()) {
			        for (int i = 1; i <= rsmd.getColumnCount(); i++) 
			        {
			            System.out.print(rs.getString(i) + "\t");
			        }
			        System.out.println();
			        ++rowCount;
			        
			    }
			 System.out.println();
		     System.out.println(rowCount+" rows Selected.");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	public void viewStudent(Student s) throws Exception
	{
		Connection con = new JdbcConnection().dataBase();
		
		String query = "SELECT * FROM students WHERE student_id = ?";
		PreparedStatement pstmt = con.prepareStatement(query);
		int id = s.getStuId();
		pstmt.setInt(1, id);
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int rowCount=0;
		if(rs.next())
		{
			for(int i=1; i<=rsmd.getColumnCount();i++)
			{
				System.out.print(rsmd.getColumnName(i)+ "\t");
				
			}
			System.out.println();
			 do{
		        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
		            System.out.print(rs.getString(i) + "\t");
		            
		        }
		        ++rowCount;
		        
		    }while (rs.next());
			 System.out.println();
		        System.out.println(rowCount+" rows Selected.");
		}
		else
		{
			System.out.println("Student Not Found.");
		}
		
		
		
	}
	
	
	
			
}
	
			
			
	
	

