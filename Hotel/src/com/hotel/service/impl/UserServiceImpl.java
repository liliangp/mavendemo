package com.hotel.service.impl;

import java.util.List;

import com.hote.dao.impl.UserDaoImpl;
import com.hote.entity.User;

import com.hotel.dao.IUserDao;
import com.hotel.service.UserService;

public class UserServiceImpl implements UserService {
	private IUserDao userDao=new UserDaoImpl();
	@Override
	public List<User> logins(String userName, String password) throws Exception {
		
		return userDao.findLoginAndPassword(userName, password);
	}
	
	@Override
	public int regist(User user) throws Exception {
		return userDao.insert(user);
	}
	
	@Override
	public List<User> findLogins(String userName) throws Exception {
		
		return userDao.findLogin(userName);
	}

}
