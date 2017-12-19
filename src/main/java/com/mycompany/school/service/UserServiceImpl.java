package com.mycompany.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.school.mappers.UserMapper;
import com.mycompany.school.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Transactional
	public void insertUser(User user) {
		userMapper.insertUser(user);
	}

	public boolean getUserByLogin(String userName, String password) {
		User user = userMapper.getUserByUserName(userName);
		
		if(user != null && user.getPassword().equals(password)) {
			return true;
		}
		
		return false;
	}

	public boolean getUserByUserName(String userName) {
		User user = userMapper.getUserByUserName(userName);
		
		if(user != null) {
			return true;
		}
		
		return false;
	}

}