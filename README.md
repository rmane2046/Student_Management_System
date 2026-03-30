# Student_Management_System
# 🎓 Student Management System (JDBC)

A console-based Java application to manage student records using JDBC and Oracle Database.
This project demonstrates CRUD operations and basic database connectivity in Java.

---

## 🚀 Features

* ➕ Add Student
* ✏️ Update Student Details
* ❌ Delete Student
* 📋 View All Students
* 🔍 Search Student by ID

---

## 🛠️ Technologies Used

* Java
* JDBC (Java Database Connectivity)
* Oracle Database
* SQL

---

## 📂 Project Structure

com.rohan
├── main → User Interface (Console आधारित UI)
├── studentdao → Database operations (CRUD)
├── jdbc → Database connection setup
└── Student → Model class (POJO)

---

## 🗄️ Database Schema

```sql
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
```

---

## ⚙️ How to Run

1. Clone the repository
2. Open in Eclipse / IntelliJ
3. Configure your database in `JdbcConnection.java`
4. Run `Main.java`

---

## ⚠️ Note

* This is a beginner-level project built for learning purposes
* Future improvements:

  * Separate UI and DAO properly
  * Add validation
  * Use properties file for DB configuration
  * Improve exception handling

---

## 📌 Author

Rohan

---

## ⭐ If you like this project, give it a star!
