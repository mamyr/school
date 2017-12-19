package com.mycompany.school.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.ResultSetType;

import com.mycompany.school.model.Student;

public interface StudentMapper {
	  @Insert("INSERT INTO student(userName, password, firstName,"
	          + "lastName, dateOfBirth, emailAddress) VALUES"
	          + "(#{userName},#{password}, #{firstName}, #{lastName},"
	          + "#{dateOfBirth}, #{emailAddress})")
	  @Options(useGeneratedKeys=true, keyProperty="id", flushCache=true, keyColumn="id")
	  public void insertStudent(Student student);
	      
	  @Select("SELECT ID as id, USERNAME as userName, PASSWORD as password, "
	          + "FIRSTNAME as firstName, LASTNAME as lastName, "
	          + "DATEOFBIRTH as dateOfBirth, EMAILADDRESS as emailAddress "
	          + "FROM student")
	  @Result(javaType = Student.class)
	  @Options(resultSetType = ResultSetType.FORWARD_ONLY)
	  public List<Student> getStudentList();

	  @Delete("DELETE FROM student WHERE id = #{id}")
	  public void deleteStudent(int id);

	  @Select("SELECT ID as id, USERNAME as userName, PASSWORD as password, "
	          + "FIRSTNAME as firstName, LASTNAME as lastName, "
	          + "DATEOFBIRTH as dateOfBirth, EMAILADDRESS as emailAddress "
	          + "FROM student WHERE userName = #{userName}")
	  public Student getStudentByUserName(String userName);
}
