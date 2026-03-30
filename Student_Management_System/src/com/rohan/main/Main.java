package com.rohan.main;

import java.util.Scanner;

import com.rohan.Student;
import com.rohan.studentdao.StudentDAO;

public class Main {

	public static void main(String[] args) throws Exception 
	{
		Scanner sc = new Scanner(System.in);		
		StudentDAO sda = new StudentDAO();
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
		case 1: Student s = new Student();
				System.out.println("Enter Student ID :");
					int sid1 = sc.nextInt();
					s.setStuId(sid1);sc.nextLine();
				System.out.println("Enter Student First Name :");
					String fName = sc.nextLine();
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
					sda.addStudent(s);
					break;
		
		case 2: Student s1 = new Student();
				System.out.println("Enter Student ID to Update :");
				int sid = sc.nextInt();
				s1.setStuId(sid);
				sda.updateStudent(s1);
				break;
				
		case 3: Student s2 = new Student();
				System.out.println("Enter Student ID to Delete :");
				int id = sc.nextInt();
				s2.setStuId(id);
				sda.deleteStudent(s2);
				break;	
				
		case 4: sda.showTable();
				break;
				
		case 5: Student s3 = new Student();
				System.out.println("Enter Student ID :");
				int id2 = sc.nextInt();
				s3.setStuId(id2);
				sda.viewStudent(s3);
				break;
				
		default: System.out.println("Invalid option. Please try again.");
			
		}
	}
	}

}
