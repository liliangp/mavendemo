package com.hotel.service;

import java.util.List;

import com.hote.entity.User;

public interface UserService {
	/**
	 * 登录业务
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public List<User> logins(String userName,String password)throws Exception;
	
	/**
	 * 注册业务
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int regist(User user)throws Exception;
	
	/**
     * 按用户名查找
     * @param userName
     * @return
     * @throws Exception
     */
    public List<User> findLogins(String userName)throws Exception;
}
