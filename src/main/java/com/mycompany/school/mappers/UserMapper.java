package com.mycompany.school.mappers;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.mycompany.school.model.User;

public interface UserMapper {
	  @Insert("INSERT INTO user(userName, password, firstName,"
	          + "lastName, dateOfBirth, emailAddress) VALUES"
	          + "(#{userName},#{password}, #{firstName}, #{lastName},"
	          + "#{dateOfBirth}, #{emailAddress})")
	  @Options(useGeneratedKeys=true, keyProperty="id", flushCache=true, keyColumn="id")
	  public void insertUser(User user);
	      
	  @Select("SELECT USERNAME as userName, PASSWORD as password, "
	          + "FIRSTNAME as firstName, LASTNAME as lastName, "
	          + "DATEOFBIRTH as dateOfBirth, EMAILADDRESS as emailAddress "
	          + "FROM user WHERE userName = #{userName}")
	  public User getUserByUserName(String userName);
}
