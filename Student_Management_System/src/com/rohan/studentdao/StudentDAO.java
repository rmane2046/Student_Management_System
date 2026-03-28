package com.rohan.studentdao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
				 try {
					 con.close();
				 }
				 catch (Exception e) {
					e.printStackTrace();
				}
			 }
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void updateStudent()
	{
		
	}
	
}
