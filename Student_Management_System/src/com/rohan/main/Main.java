package com.rohan.main;

import java.util.Scanner;

import com.rohan.Student;
import com.rohan.studentdao.StudentDAO;

public class Main {

	public static void main(String[] args) throws Exception 
	{
		Scanner sc = new Scanner(System.in);
		Student s = new Student();
		while(true) 
		{
		System.out.println("================================================");
		System.out.println("----------Select The Following Action-----------");
		System.out.println("1. Add Student");
		System.out.println("2. Update Student");
		System.out.println("3. Delete Student");
		System.out.println("4. View All Student");
		System.out.println("5. Search Student by ID");
		System.out.println("================================================");
		int input = sc.nextInt();
		switch(input)
		{
		case 1: System.out.println("Enter Student ID :");
					int sid1 = sc.nextInt();
					s.setStuId(sid1);
				System.out.println("Enter Student First Name :");
					String fName = sc.next();
					s.setfName(fName);
				System.out.println("Enter Student Last Name :");
					
					String lName = sc.next();					
					s.setlName(lName);
					sc.nextLine();
				System.out.println("Enter Student Email Address :");
					String email = sc.nextLine();
					s.setEmail(email);
				System.out.println("Enter Student Phone No. :");
					long phone = sc.nextLong();
					s.setPhone(phone);
				System.out.println("Enter Student Course Name :");
					String course = sc.next();
					s.setCourse(course);
				System.out.println("Enter Student Marks :");
					int marks = sc.nextInt();
					s.setMarks(marks);
				System.out.println("Enter Student Grade (A to D) :");
					char grade = sc.next().charAt(0);
					s.setGrade(grade);
					new StudentDAO().addStudent(s);
					break;
		
		case 2: new StudentDAO().updateStudent(s);
				break;
		case 3: System.out.println("Enter Student ID to Delete :");
				int sid3 = sc.nextInt();
				break;
		
		
		case 4: break;
		case 5: System.out.println("Enter Student ID :");
				int sid4 = sc.nextInt();
				break;
		default: System.out.println("Wrong Input :");
			
		}
	}
	}

}
