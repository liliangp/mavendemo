package com.hote.dao.impl;

import java.util.List;
import org.jbit.dao.BaseDao;

import com.hote.entity.User;
import com.hotel.dao.IUserDao;

public class UserDaoImpl extends BaseDao implements IUserDao{
	
	@Override
	public List<User> findLoginAndPassword(String userName, String password) throws Exception {
		String sql="SELECT u_userName userName, u_password password "
				+ "FROM t_user WHERE u_userName=? AND u_password=?";
		Object[] params= {userName,password}; 
		List<User> list=this.executeQuery(sql, params, User.class);
		return list;
	}

	@Override
	public int insert(User user) throws Exception {
		String sql="INSERT INTO t_user(u_userName,u_password) VALUES(?,?)";
		Object[] params= {user.getUserName(),user.getPassword()}; 
		return this.executeUpdate(sql, params);
	}

	@Override
	public List<User> findLogin(String userName) throws Exception {
		String sql="SELECT u_userName userName FROM t_user WHERE u_userName=? ";
		Object[] params= {userName}; 
		List<User> list=this.executeQuery(sql, params, User.class);
		return list;
	}
	
    
}
