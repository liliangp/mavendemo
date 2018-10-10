package com.hotel.service;

import java.util.List;

import com.hote.entity.User;

public interface UserService {
	/**
	 * ��¼ҵ��
	 * @param userName
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public List<User> logins(String userName,String password)throws Exception;
	
	/**
	 * ע��ҵ��
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int regist(User user)throws Exception;
	
	/**
     * ���û�������
     * @param userName
     * @return
     * @throws Exception
     */
    public List<User> findLogins(String userName)throws Exception;
}
