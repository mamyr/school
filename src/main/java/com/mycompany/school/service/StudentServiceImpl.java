package com.mycompany.school.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.school.mappers.StudentMapper;
import com.mycompany.school.model.Student;

@Service("studentService")
public class StudentServiceImpl implements StudentService {


	@Autowired
	private StudentMapper studentMapper;
	
	@Transactional
	public Student insertStudent(Student student) {
		studentMapper.insertStudent(student);
		return student;
	}

	@Transactional
	public void deleteStudent(int id) {
		studentMapper.deleteStudent(id);
	}

	public List<Student> getStudentList(){
		List<Student> students = studentMapper.getStudentList();
		return students;
	}

	public boolean getStudentByUserName(String userName) {
		Student student = studentMapper.getStudentByUserName(userName);
		
		if(student != null) {
			return true;
		}
		
		return false;
	}
}
