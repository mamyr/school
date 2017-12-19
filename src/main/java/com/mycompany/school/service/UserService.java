package com.mycompany.school.service;

import com.mycompany.school.model.User;

public interface UserService {
	  void insertUser(User user);
	  boolean getUserByLogin(String userName, String password);
	  boolean getUserByUserName(String userName);
}
