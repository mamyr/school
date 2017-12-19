package com.mycompany.school.service;

import java.util.List;

import com.mycompany.school.model.Student;

public interface StudentService {
	  Student insertStudent(Student student);
	  List<Student> getStudentList();
	  void deleteStudent(int id);
	  boolean getStudentByUserName(String userName);
}
